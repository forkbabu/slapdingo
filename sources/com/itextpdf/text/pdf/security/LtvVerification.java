package com.itextpdf.text.pdf.security;

import com.itextpdf.text.Utilities;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.PRIndirectReference;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfIndirectReference;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfObject;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfStream;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;

public class LtvVerification {
    private Logger LOGGER = LoggerFactory.getLogger(LtvVerification.class);
    private AcroFields acroFields;
    private PdfReader reader;
    private PdfStamper stp;
    private boolean used = false;
    private Map<PdfName, ValidationData> validated = new HashMap();
    private PdfWriter writer;

    public enum CertificateInclusion {
        YES,
        NO
    }

    public enum CertificateOption {
        SIGNING_CERTIFICATE,
        WHOLE_CHAIN
    }

    public enum Level {
        OCSP,
        CRL,
        OCSP_CRL,
        OCSP_OPTIONAL_CRL
    }

    public LtvVerification(PdfStamper pdfStamper) {
        this.stp = pdfStamper;
        this.writer = pdfStamper.getWriter();
        this.reader = pdfStamper.getReader();
        this.acroFields = pdfStamper.getAcroFields();
    }

    public boolean addVerification(String str, OcspClient ocspClient, CrlClient crlClient, CertificateOption certificateOption, Level level, CertificateInclusion certificateInclusion) throws IOException, GeneralSecurityException {
        byte[] bArr;
        Collection<byte[]> encoded;
        boolean z;
        if (!this.used) {
            PdfPKCS7 verifySignature = this.acroFields.verifySignature(str);
            Logger logger = this.LOGGER;
            logger.info("Adding verification for " + str);
            Certificate[] certificates = verifySignature.getCertificates();
            X509Certificate signingCertificate = verifySignature.getSigningCertificate();
            String str2 = null;
            ValidationData validationData = new ValidationData();
            int i = 0;
            while (i < certificates.length) {
                X509Certificate x509Certificate = (X509Certificate) certificates[i];
                Logger logger2 = this.LOGGER;
                logger2.info("Certificate: " + x509Certificate.getSubjectDN());
                if (certificateOption != CertificateOption.SIGNING_CERTIFICATE || x509Certificate.equals(signingCertificate)) {
                    if (ocspClient == null || level == Level.CRL) {
                        bArr = str2;
                    } else {
                        bArr = ocspClient.getEncoded(x509Certificate, getParent(x509Certificate, certificates), str2);
                        if (bArr != null) {
                            validationData.ocsps.add(buildOCSPResponse(bArr));
                            this.LOGGER.info("OCSP added");
                        }
                    }
                    if (crlClient != null && ((level == Level.CRL || level == Level.OCSP_CRL || (level == Level.OCSP_OPTIONAL_CRL && bArr == null)) && (encoded = crlClient.getEncoded(x509Certificate, str2)) != null)) {
                        for (byte[] bArr2 : encoded) {
                            Iterator<byte[]> it2 = validationData.crls.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z = false;
                                    break;
                                } else if (Arrays.equals(it2.next(), bArr2)) {
                                    z = true;
                                    break;
                                }
                            }
                            if (!z) {
                                validationData.crls.add(bArr2);
                                this.LOGGER.info("CRL added");
                            }
                        }
                    }
                    if (certificateInclusion == CertificateInclusion.YES) {
                        validationData.certs.add(x509Certificate.getEncoded());
                    }
                }
                i++;
                str2 = null;
            }
            if (validationData.crls.isEmpty() && validationData.ocsps.isEmpty()) {
                return false;
            }
            this.validated.put(getSignatureHashKey(str), validationData);
            return true;
        }
        throw new IllegalStateException(MessageLocalization.getComposedMessage("verification.already.output", new Object[0]));
    }

    private X509Certificate getParent(X509Certificate x509Certificate, Certificate[] certificateArr) {
        for (Certificate certificate : certificateArr) {
            X509Certificate x509Certificate2 = (X509Certificate) certificate;
            if (x509Certificate.getIssuerDN().equals(x509Certificate2.getSubjectDN())) {
                try {
                    x509Certificate.verify(x509Certificate2.getPublicKey());
                    return x509Certificate2;
                } catch (Exception unused) {
                    continue;
                }
            }
        }
        return null;
    }

    public boolean addVerification(String str, Collection<byte[]> collection, Collection<byte[]> collection2, Collection<byte[]> collection3) throws IOException, GeneralSecurityException {
        if (!this.used) {
            ValidationData validationData = new ValidationData();
            if (collection != null) {
                for (byte[] bArr : collection) {
                    validationData.ocsps.add(buildOCSPResponse(bArr));
                }
            }
            if (collection2 != null) {
                for (byte[] bArr2 : collection2) {
                    validationData.crls.add(bArr2);
                }
            }
            if (collection3 != null) {
                for (byte[] bArr3 : collection3) {
                    validationData.certs.add(bArr3);
                }
            }
            this.validated.put(getSignatureHashKey(str), validationData);
            return true;
        }
        throw new IllegalStateException(MessageLocalization.getComposedMessage("verification.already.output", new Object[0]));
    }

    private static byte[] buildOCSPResponse(byte[] bArr) throws IOException {
        DEROctetString dEROctetString = new DEROctetString(bArr);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
        aSN1EncodableVector.add(dEROctetString);
        ASN1Enumerated aSN1Enumerated = new ASN1Enumerated(0);
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(aSN1Enumerated);
        aSN1EncodableVector2.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector)));
        return new DERSequence(aSN1EncodableVector2).getEncoded();
    }

    private PdfName getSignatureHashKey(String str) throws NoSuchAlgorithmException, IOException {
        PdfDictionary signatureDictionary = this.acroFields.getSignatureDictionary(str);
        byte[] originalBytes = signatureDictionary.getAsString(PdfName.CONTENTS).getOriginalBytes();
        if (PdfName.ETSI_RFC3161.equals(PdfReader.getPdfObject(signatureDictionary.get(PdfName.SUBFILTER)))) {
            originalBytes = new ASN1InputStream(new ByteArrayInputStream(originalBytes)).readObject().getEncoded();
        }
        return new PdfName(Utilities.convertToHex(hashBytesSha1(originalBytes)));
    }

    private static byte[] hashBytesSha1(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance(SecurityConstants.SHA1).digest(bArr);
    }

    public void merge() throws IOException {
        if (!this.used && !this.validated.isEmpty()) {
            this.used = true;
            if (this.reader.getCatalog().get(PdfName.DSS) == null) {
                createDss();
            } else {
                updateDss();
            }
        }
    }

    private void updateDss() throws IOException {
        PdfDictionary asDict;
        PdfDictionary catalog = this.reader.getCatalog();
        this.stp.markUsed(catalog);
        PdfDictionary asDict2 = catalog.getAsDict(PdfName.DSS);
        PdfArray asArray = asDict2.getAsArray(PdfName.OCSPS);
        PdfArray asArray2 = asDict2.getAsArray(PdfName.CRLS);
        PdfArray asArray3 = asDict2.getAsArray(PdfName.CERTS);
        asDict2.remove(PdfName.OCSPS);
        asDict2.remove(PdfName.CRLS);
        asDict2.remove(PdfName.CERTS);
        PdfDictionary asDict3 = asDict2.getAsDict(PdfName.VRI);
        if (asDict3 != null) {
            for (PdfName pdfName : asDict3.getKeys()) {
                if (this.validated.containsKey(pdfName) && (asDict = asDict3.getAsDict(pdfName)) != null) {
                    deleteOldReferences(asArray, asDict.getAsArray(PdfName.OCSP));
                    deleteOldReferences(asArray2, asDict.getAsArray(PdfName.CRL));
                    deleteOldReferences(asArray3, asDict.getAsArray(PdfName.CERT));
                }
            }
        }
        if (asArray == null) {
            asArray = new PdfArray();
        }
        outputDss(asDict2, asDict3, asArray, asArray2 == null ? new PdfArray() : asArray2, asArray3 == null ? new PdfArray() : asArray3);
    }

    private static void deleteOldReferences(PdfArray pdfArray, PdfArray pdfArray2) {
        if (pdfArray != null && pdfArray2 != null) {
            Iterator<PdfObject> it2 = pdfArray2.iterator();
            while (it2.hasNext()) {
                PdfObject next = it2.next();
                if (next.isIndirect()) {
                    PRIndirectReference pRIndirectReference = (PRIndirectReference) next;
                    int i = 0;
                    while (i < pdfArray.size()) {
                        PdfObject pdfObject = pdfArray.getPdfObject(i);
                        if (pdfObject.isIndirect() && pRIndirectReference.getNumber() == ((PRIndirectReference) pdfObject).getNumber()) {
                            pdfArray.remove(i);
                            i--;
                        }
                        i++;
                    }
                }
            }
        }
    }

    private void createDss() throws IOException {
        outputDss(new PdfDictionary(), new PdfDictionary(), new PdfArray(), new PdfArray(), new PdfArray());
    }

    private void outputDss(PdfDictionary pdfDictionary, PdfDictionary pdfDictionary2, PdfArray pdfArray, PdfArray pdfArray2, PdfArray pdfArray3) throws IOException {
        this.writer.addDeveloperExtension(PdfDeveloperExtension.ESIC_1_7_EXTENSIONLEVEL5);
        PdfDictionary catalog = this.reader.getCatalog();
        this.stp.markUsed(catalog);
        Iterator<PdfName> it2 = this.validated.keySet().iterator();
        while (it2.hasNext()) {
            PdfName next = it2.next();
            PdfArray pdfArray4 = new PdfArray();
            PdfArray pdfArray5 = new PdfArray();
            PdfArray pdfArray6 = new PdfArray();
            PdfDictionary pdfDictionary3 = new PdfDictionary();
            for (byte[] bArr : this.validated.get(next).crls) {
                PdfStream pdfStream = new PdfStream(bArr);
                pdfStream.flateCompress();
                PdfIndirectReference indirectReference = this.writer.addToBody((PdfObject) pdfStream, false).getIndirectReference();
                pdfArray5.add(indirectReference);
                pdfArray2.add(indirectReference);
                it2 = it2;
            }
            for (byte[] bArr2 : this.validated.get(next).ocsps) {
                PdfStream pdfStream2 = new PdfStream(bArr2);
                pdfStream2.flateCompress();
                PdfIndirectReference indirectReference2 = this.writer.addToBody((PdfObject) pdfStream2, false).getIndirectReference();
                pdfArray4.add(indirectReference2);
                pdfArray.add(indirectReference2);
            }
            for (byte[] bArr3 : this.validated.get(next).certs) {
                PdfStream pdfStream3 = new PdfStream(bArr3);
                pdfStream3.flateCompress();
                PdfIndirectReference indirectReference3 = this.writer.addToBody((PdfObject) pdfStream3, false).getIndirectReference();
                pdfArray6.add(indirectReference3);
                pdfArray3.add(indirectReference3);
            }
            if (pdfArray4.size() > 0) {
                pdfDictionary3.put(PdfName.OCSP, this.writer.addToBody((PdfObject) pdfArray4, false).getIndirectReference());
            }
            if (pdfArray5.size() > 0) {
                pdfDictionary3.put(PdfName.CRL, this.writer.addToBody((PdfObject) pdfArray5, false).getIndirectReference());
            }
            if (pdfArray6.size() > 0) {
                pdfDictionary3.put(PdfName.CERT, this.writer.addToBody((PdfObject) pdfArray6, false).getIndirectReference());
            }
            pdfDictionary2.put(next, this.writer.addToBody((PdfObject) pdfDictionary3, false).getIndirectReference());
            it2 = it2;
        }
        pdfDictionary.put(PdfName.VRI, this.writer.addToBody((PdfObject) pdfDictionary2, false).getIndirectReference());
        if (pdfArray.size() > 0) {
            pdfDictionary.put(PdfName.OCSPS, this.writer.addToBody((PdfObject) pdfArray, false).getIndirectReference());
        }
        if (pdfArray2.size() > 0) {
            pdfDictionary.put(PdfName.CRLS, this.writer.addToBody((PdfObject) pdfArray2, false).getIndirectReference());
        }
        if (pdfArray3.size() > 0) {
            pdfDictionary.put(PdfName.CERTS, this.writer.addToBody((PdfObject) pdfArray3, false).getIndirectReference());
        }
        catalog.put(PdfName.DSS, this.writer.addToBody((PdfObject) pdfDictionary, false).getIndirectReference());
    }

    private static class ValidationData {
        public List<byte[]> certs;
        public List<byte[]> crls;
        public List<byte[]> ocsps;

        private ValidationData() {
            this.crls = new ArrayList();
            this.ocsps = new ArrayList();
            this.certs = new ArrayList();
        }
    }
}
