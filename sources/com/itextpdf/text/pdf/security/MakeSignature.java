package com.itextpdf.text.pdf.security;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.io.RASInputStream;
import com.itextpdf.text.io.RandomAccessSource;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.io.StreamUtil;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import com.itextpdf.text.pdf.AcroFields;
import com.itextpdf.text.pdf.ByteBuffer;
import com.itextpdf.text.pdf.PdfArray;
import com.itextpdf.text.pdf.PdfDate;
import com.itextpdf.text.pdf.PdfDeveloperExtension;
import com.itextpdf.text.pdf.PdfDictionary;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfSignature;
import com.itextpdf.text.pdf.PdfSignatureAppearance;
import com.itextpdf.text.pdf.PdfString;
import java.io.IOException;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import org.spongycastle.asn1.esf.SignaturePolicyIdentifier;

public class MakeSignature {
    private static final Logger LOGGER = LoggerFactory.getLogger(MakeSignature.class);

    public enum CryptoStandard {
        CMS,
        CADES
    }

    public static void signDetached(PdfSignatureAppearance pdfSignatureAppearance, ExternalDigest externalDigest, ExternalSignature externalSignature, Certificate[] certificateArr, Collection<CrlClient> collection, OcspClient ocspClient, TSAClient tSAClient, int i, CryptoStandard cryptoStandard) throws IOException, DocumentException, GeneralSecurityException {
        signDetached(pdfSignatureAppearance, externalDigest, externalSignature, certificateArr, collection, ocspClient, tSAClient, i, cryptoStandard, (SignaturePolicyIdentifier) null);
    }

    public static void signDetached(PdfSignatureAppearance pdfSignatureAppearance, ExternalDigest externalDigest, ExternalSignature externalSignature, Certificate[] certificateArr, Collection<CrlClient> collection, OcspClient ocspClient, TSAClient tSAClient, int i, CryptoStandard cryptoStandard, SignaturePolicyInfo signaturePolicyInfo) throws IOException, DocumentException, GeneralSecurityException {
        signDetached(pdfSignatureAppearance, externalDigest, externalSignature, certificateArr, collection, ocspClient, tSAClient, i, cryptoStandard, signaturePolicyInfo.toSignaturePolicyIdentifier());
    }

    public static void signDetached(PdfSignatureAppearance pdfSignatureAppearance, ExternalDigest externalDigest, ExternalSignature externalSignature, Certificate[] certificateArr, Collection<CrlClient> collection, OcspClient ocspClient, TSAClient tSAClient, int i, CryptoStandard cryptoStandard, SignaturePolicyIdentifier signaturePolicyIdentifier) throws IOException, DocumentException, GeneralSecurityException {
        int i2;
        byte[] bArr;
        byte[] bArr2;
        int i3 = 0;
        Collection<byte[]> collection2 = null;
        while (collection2 == null && i3 < certificateArr.length) {
            collection2 = processCrl(certificateArr[i3], collection);
            i3++;
        }
        if (i == 0) {
            int i4 = 8192;
            i4 = 8192;
            if (collection2 != null) {
                for (byte[] bArr3 : collection2) {
                    i4 += bArr3.length + 10;
                }
            }
            if (ocspClient != null) {
                i4 += 4192;
            }
            if (tSAClient != null) {
                i4 += 4192;
            }
            i2 = i4;
        } else {
            i2 = i;
        }
        pdfSignatureAppearance.setCertificate(certificateArr[0]);
        if (cryptoStandard == CryptoStandard.CADES) {
            pdfSignatureAppearance.addDeveloperExtension(PdfDeveloperExtension.ESIC_1_7_EXTENSIONLEVEL2);
        }
        PdfSignature pdfSignature = new PdfSignature(PdfName.ADOBE_PPKLITE, cryptoStandard == CryptoStandard.CADES ? PdfName.ETSI_CADES_DETACHED : PdfName.ADBE_PKCS7_DETACHED);
        pdfSignature.setReason(pdfSignatureAppearance.getReason());
        pdfSignature.setLocation(pdfSignatureAppearance.getLocation());
        pdfSignature.setSignatureCreator(pdfSignatureAppearance.getSignatureCreator());
        pdfSignature.setContact(pdfSignatureAppearance.getContact());
        pdfSignature.setDate(new PdfDate(pdfSignatureAppearance.getSignDate()));
        pdfSignatureAppearance.setCryptoDictionary(pdfSignature);
        HashMap hashMap = new HashMap();
        hashMap.put(PdfName.CONTENTS, new Integer((i2 * 2) + 2));
        pdfSignatureAppearance.preClose(hashMap);
        String hashAlgorithm = externalSignature.getHashAlgorithm();
        PdfPKCS7 pdfPKCS7 = new PdfPKCS7(null, certificateArr, hashAlgorithm, null, externalDigest, false);
        if (signaturePolicyIdentifier != null) {
            pdfPKCS7.setSignaturePolicy(signaturePolicyIdentifier);
        }
        byte[] digest = DigestAlgorithms.digest(pdfSignatureAppearance.getRangeStream(), externalDigest.getMessageDigest(hashAlgorithm));
        if (certificateArr.length < 2 || ocspClient == null) {
            bArr2 = null;
            bArr = null;
        } else {
            bArr2 = null;
            bArr = ocspClient.getEncoded((X509Certificate) certificateArr[0], (X509Certificate) certificateArr[1], null);
        }
        pdfPKCS7.setExternalDigest(externalSignature.sign(pdfPKCS7.getAuthenticatedAttributeBytes(digest, bArr, collection2, cryptoStandard)), bArr2, externalSignature.getEncryptionAlgorithm());
        byte[] encodedPKCS7 = pdfPKCS7.getEncodedPKCS7(digest, tSAClient, bArr, collection2, cryptoStandard);
        if (i2 >= encodedPKCS7.length) {
            byte[] bArr4 = new byte[i2];
            System.arraycopy(encodedPKCS7, 0, bArr4, 0, encodedPKCS7.length);
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.CONTENTS, new PdfString(bArr4).setHexWriting(true));
            pdfSignatureAppearance.close(pdfDictionary);
            return;
        }
        throw new IOException("Not enough space");
    }

    public static Collection<byte[]> processCrl(Certificate certificate, Collection<CrlClient> collection) {
        if (collection == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (CrlClient crlClient : collection) {
            if (crlClient != null) {
                Logger logger = LOGGER;
                logger.info("Processing " + crlClient.getClass().getName());
                Collection<byte[]> encoded = crlClient.getEncoded((X509Certificate) certificate, null);
                if (encoded != null) {
                    arrayList.addAll(encoded);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    public static void signExternalContainer(PdfSignatureAppearance pdfSignatureAppearance, ExternalSignatureContainer externalSignatureContainer, int i) throws GeneralSecurityException, IOException, DocumentException {
        PdfSignature pdfSignature = new PdfSignature(null, null);
        pdfSignature.setReason(pdfSignatureAppearance.getReason());
        pdfSignature.setLocation(pdfSignatureAppearance.getLocation());
        pdfSignature.setSignatureCreator(pdfSignatureAppearance.getSignatureCreator());
        pdfSignature.setContact(pdfSignatureAppearance.getContact());
        pdfSignature.setDate(new PdfDate(pdfSignatureAppearance.getSignDate()));
        externalSignatureContainer.modifySigningDictionary(pdfSignature);
        pdfSignatureAppearance.setCryptoDictionary(pdfSignature);
        HashMap hashMap = new HashMap();
        hashMap.put(PdfName.CONTENTS, new Integer((i * 2) + 2));
        pdfSignatureAppearance.preClose(hashMap);
        byte[] sign = externalSignatureContainer.sign(pdfSignatureAppearance.getRangeStream());
        if (i >= sign.length) {
            byte[] bArr = new byte[i];
            System.arraycopy(sign, 0, bArr, 0, sign.length);
            PdfDictionary pdfDictionary = new PdfDictionary();
            pdfDictionary.put(PdfName.CONTENTS, new PdfString(bArr).setHexWriting(true));
            pdfSignatureAppearance.close(pdfDictionary);
            return;
        }
        throw new IOException("Not enough space");
    }

    public static void signDeferred(PdfReader pdfReader, String str, OutputStream outputStream, ExternalSignatureContainer externalSignatureContainer) throws DocumentException, IOException, GeneralSecurityException {
        AcroFields acroFields = pdfReader.getAcroFields();
        PdfDictionary signatureDictionary = acroFields.getSignatureDictionary(str);
        if (signatureDictionary == null) {
            throw new DocumentException("No field");
        } else if (acroFields.signatureCoversWholeDocument(str)) {
            PdfArray asArray = signatureDictionary.getAsArray(PdfName.BYTERANGE);
            long[] asLongArray = asArray.asLongArray();
            if (asArray.size() == 4) {
                if (asLongArray[0] == 0) {
                    RandomAccessSource createSourceView = pdfReader.getSafeFile().createSourceView();
                    byte[] sign = externalSignatureContainer.sign(new RASInputStream(new RandomAccessSourceFactory().createRanged(createSourceView, asLongArray)));
                    int i = ((int) (asLongArray[2] - asLongArray[1])) - 2;
                    if ((i & 1) == 0) {
                        int i2 = i / 2;
                        if (i2 >= sign.length) {
                            StreamUtil.CopyBytes(createSourceView, 0, asLongArray[1] + 1, outputStream);
                            ByteBuffer byteBuffer = new ByteBuffer(i2 * 2);
                            for (byte b : sign) {
                                byteBuffer.appendHex(b);
                            }
                            int length = (i2 - sign.length) * 2;
                            for (int i3 = 0; i3 < length; i3++) {
                                byteBuffer.append(ByteBuffer.ZERO);
                            }
                            byteBuffer.writeTo(outputStream);
                            StreamUtil.CopyBytes(createSourceView, asLongArray[2] - 1, asLongArray[3] + 1, outputStream);
                            return;
                        }
                        throw new DocumentException("Not enough space");
                    }
                    throw new DocumentException("Gap is not a multiple of 2");
                }
            }
            throw new DocumentException("Single exclusion space supported");
        } else {
            throw new DocumentException("Not the last signature");
        }
    }
}
