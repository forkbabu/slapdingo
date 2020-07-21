package com.itextpdf.text.pdf.security;

import com.itextpdf.text.ExceptionConverter;
import com.itextpdf.text.error_messages.MessageLocalization;
import com.itextpdf.text.pdf.PdfName;
import com.itextpdf.text.pdf.security.MakeSignature;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRL;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.security.cert.X509CRL;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Enumeration;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Encoding;
import org.spongycastle.asn1.ASN1Enumerated;
import org.spongycastle.asn1.ASN1InputStream;
import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1OutputStream;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1Set;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.DERSet;
import org.spongycastle.asn1.DERTaggedObject;
import org.spongycastle.asn1.cms.Attribute;
import org.spongycastle.asn1.cms.AttributeTable;
import org.spongycastle.asn1.cms.ContentInfo;
import org.spongycastle.asn1.esf.SignaturePolicyIdentifier;
import org.spongycastle.asn1.ess.ESSCertIDv2;
import org.spongycastle.asn1.ess.SigningCertificate;
import org.spongycastle.asn1.ess.SigningCertificateV2;
import org.spongycastle.asn1.ocsp.BasicOCSPResponse;
import org.spongycastle.asn1.ocsp.OCSPObjectIdentifiers;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.tsp.MessageImprint;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.cert.jcajce.JcaX509CertificateHolder;
import org.spongycastle.cert.ocsp.BasicOCSPResp;
import org.spongycastle.cert.ocsp.CertificateID;
import org.spongycastle.jce.X509Principal;
import org.spongycastle.jce.provider.X509CertParser;
import org.spongycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder;
import org.spongycastle.tsp.TimeStampToken;
import org.spongycastle.tsp.TimeStampTokenInfo;

public class PdfPKCS7 {
    private byte[] RSAdata;
    private BasicOCSPResp basicResp;
    private Collection<Certificate> certs;
    private Collection<CRL> crls;
    private byte[] digest;
    private String digestAlgorithmOid;
    private byte[] digestAttr;
    private String digestEncryptionAlgorithmOid;
    private Set<String> digestalgos;
    private MessageDigest encContDigest;
    private byte[] externalDigest;
    private byte[] externalRSAdata;
    private PdfName filterSubtype;
    private ExternalDigest interfaceDigest;
    private boolean isCades;
    private boolean isTsp;
    private String location;
    private MessageDigest messageDigest;
    private String provider;
    private String reason;
    private Signature sig;
    private byte[] sigAttr;
    private byte[] sigAttrDer;
    private X509Certificate signCert;
    private Collection<Certificate> signCerts;
    private Calendar signDate;
    private String signName;
    private SignaturePolicyIdentifier signaturePolicyIdentifier;
    private int signerversion = 1;
    private TimeStampToken timeStampToken;
    private boolean verified;
    private boolean verifyResult;
    private int version = 1;

    public PdfPKCS7(PrivateKey privateKey, Certificate[] certificateArr, String str, String str2, ExternalDigest externalDigest2, boolean z) throws InvalidKeyException, NoSuchProviderException, NoSuchAlgorithmException {
        this.provider = str2;
        this.interfaceDigest = externalDigest2;
        String allowedDigests = DigestAlgorithms.getAllowedDigests(str);
        this.digestAlgorithmOid = allowedDigests;
        if (allowedDigests != null) {
            this.signCert = (X509Certificate) certificateArr[0];
            this.certs = new ArrayList();
            for (Certificate certificate : certificateArr) {
                this.certs.add(certificate);
            }
            HashSet hashSet = new HashSet();
            this.digestalgos = hashSet;
            hashSet.add(this.digestAlgorithmOid);
            if (privateKey != null) {
                String algorithm = privateKey.getAlgorithm();
                this.digestEncryptionAlgorithmOid = algorithm;
                if (algorithm.equals(SecurityConstants.RSA)) {
                    this.digestEncryptionAlgorithmOid = SecurityIDs.ID_RSA;
                } else if (this.digestEncryptionAlgorithmOid.equals(SecurityConstants.DSA)) {
                    this.digestEncryptionAlgorithmOid = SecurityIDs.ID_DSA;
                } else {
                    throw new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.key.algorithm.1", this.digestEncryptionAlgorithmOid));
                }
            }
            if (z) {
                this.RSAdata = new byte[0];
                this.messageDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str2);
            }
            if (privateKey != null) {
                this.sig = initSignature(privateKey);
                return;
            }
            return;
        }
        throw new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.hash.algorithm.1", str));
    }

    public PdfPKCS7(byte[] bArr, byte[] bArr2, String str) {
        try {
            this.provider = str;
            X509CertParser x509CertParser = new X509CertParser();
            x509CertParser.engineInit(new ByteArrayInputStream(bArr2));
            Collection<Certificate> engineReadAll = x509CertParser.engineReadAll();
            this.certs = engineReadAll;
            this.signCerts = engineReadAll;
            this.signCert = (X509Certificate) engineReadAll.iterator().next();
            this.crls = new ArrayList();
            this.digest = ((ASN1OctetString) new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject()).getOctets();
            if (str == null) {
                this.sig = Signature.getInstance("SHA1withRSA");
            } else {
                this.sig = Signature.getInstance("SHA1withRSA", str);
            }
            this.sig.initVerify(this.signCert.getPublicKey());
            this.digestAlgorithmOid = "1.2.840.10040.4.3";
            this.digestEncryptionAlgorithmOid = "1.3.36.3.3.1.2";
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public PdfPKCS7(byte[] bArr, PdfName pdfName, String str) {
        boolean z;
        int i;
        Attribute attribute;
        this.filterSubtype = pdfName;
        this.isTsp = PdfName.ETSI_RFC3161.equals(pdfName);
        this.isCades = PdfName.ETSI_CADES_DETACHED.equals(pdfName);
        try {
            this.provider = str;
            try {
                ASN1Primitive readObject = new ASN1InputStream(new ByteArrayInputStream(bArr)).readObject();
                if (readObject instanceof ASN1Sequence) {
                    ASN1Sequence aSN1Sequence = (ASN1Sequence) readObject;
                    if (((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId().equals(SecurityIDs.ID_PKCS7_SIGNED_DATA)) {
                        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) ((ASN1TaggedObject) aSN1Sequence.getObjectAt(1)).getObject();
                        this.version = ((ASN1Integer) aSN1Sequence2.getObjectAt(0)).getValue().intValue();
                        this.digestalgos = new HashSet();
                        Enumeration objects = ((ASN1Set) aSN1Sequence2.getObjectAt(1)).getObjects();
                        while (objects.hasMoreElements()) {
                            this.digestalgos.add(((ASN1ObjectIdentifier) ((ASN1Sequence) objects.nextElement()).getObjectAt(0)).getId());
                        }
                        ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence2.getObjectAt(2);
                        if (aSN1Sequence3.size() > 1) {
                            this.RSAdata = ((ASN1OctetString) ((ASN1TaggedObject) aSN1Sequence3.getObjectAt(1)).getObject()).getOctets();
                        }
                        int i2 = 3;
                        while (aSN1Sequence2.getObjectAt(i2) instanceof ASN1TaggedObject) {
                            i2++;
                        }
                        X509CertParser x509CertParser = new X509CertParser();
                        x509CertParser.engineInit(new ByteArrayInputStream(bArr));
                        this.certs = x509CertParser.engineReadAll();
                        ASN1Set aSN1Set = (ASN1Set) aSN1Sequence2.getObjectAt(i2);
                        if (aSN1Set.size() == 1) {
                            ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Set.getObjectAt(0);
                            this.signerversion = ((ASN1Integer) aSN1Sequence4.getObjectAt(0)).getValue().intValue();
                            ASN1Sequence aSN1Sequence5 = (ASN1Sequence) aSN1Sequence4.getObjectAt(1);
                            X509Principal x509Principal = new X509Principal(aSN1Sequence5.getObjectAt(0).toASN1Primitive().getEncoded());
                            BigInteger value = ((ASN1Integer) aSN1Sequence5.getObjectAt(1)).getValue();
                            Iterator<Certificate> it2 = this.certs.iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    break;
                                }
                                X509Certificate x509Certificate = (X509Certificate) it2.next();
                                if (x509Certificate.getIssuerDN().equals(x509Principal) && value.equals(x509Certificate.getSerialNumber())) {
                                    this.signCert = x509Certificate;
                                    break;
                                }
                            }
                            if (this.signCert != null) {
                                signCertificateChain();
                                this.digestAlgorithmOid = ((ASN1ObjectIdentifier) ((ASN1Sequence) aSN1Sequence4.getObjectAt(2)).getObjectAt(0)).getId();
                                if (aSN1Sequence4.getObjectAt(3) instanceof ASN1TaggedObject) {
                                    ASN1Set instance = ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence4.getObjectAt(3), false);
                                    this.sigAttr = instance.getEncoded();
                                    this.sigAttrDer = instance.getEncoded(ASN1Encoding.DER);
                                    z = false;
                                    for (int i3 = 0; i3 < instance.size(); i3++) {
                                        ASN1Sequence aSN1Sequence6 = (ASN1Sequence) instance.getObjectAt(i3);
                                        String id2 = ((ASN1ObjectIdentifier) aSN1Sequence6.getObjectAt(0)).getId();
                                        if (id2.equals(SecurityIDs.ID_MESSAGE_DIGEST)) {
                                            this.digestAttr = ((ASN1OctetString) ((ASN1Set) aSN1Sequence6.getObjectAt(1)).getObjectAt(0)).getOctets();
                                        } else if (id2.equals(SecurityIDs.ID_ADBE_REVOCATION)) {
                                            ASN1Sequence aSN1Sequence7 = (ASN1Sequence) ((ASN1Set) aSN1Sequence6.getObjectAt(1)).getObjectAt(0);
                                            for (int i4 = 0; i4 < aSN1Sequence7.size(); i4++) {
                                                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence7.getObjectAt(i4);
                                                if (aSN1TaggedObject.getTagNo() == 0) {
                                                    findCRL((ASN1Sequence) aSN1TaggedObject.getObject());
                                                }
                                                if (aSN1TaggedObject.getTagNo() == 1) {
                                                    findOcsp((ASN1Sequence) aSN1TaggedObject.getObject());
                                                }
                                            }
                                        } else {
                                            if (this.isCades && id2.equals(SecurityIDs.ID_AA_SIGNING_CERTIFICATE_V1)) {
                                                if (!Arrays.equals(new BouncyCastleDigest().getMessageDigest(DigestAlgorithms.SHA1).digest(this.signCert.getEncoded()), SigningCertificate.getInstance((ASN1Sequence) ((ASN1Set) aSN1Sequence6.getObjectAt(1)).getObjectAt(0)).getCerts()[0].getCertHash())) {
                                                    throw new IllegalArgumentException("Signing certificate doesn't match the ESS information.");
                                                }
                                            } else if (this.isCades && id2.equals(SecurityIDs.ID_AA_SIGNING_CERTIFICATE_V2)) {
                                                ESSCertIDv2 eSSCertIDv2 = SigningCertificateV2.getInstance((ASN1Sequence) ((ASN1Set) aSN1Sequence6.getObjectAt(1)).getObjectAt(0)).getCerts()[0];
                                                if (!Arrays.equals(new BouncyCastleDigest().getMessageDigest(DigestAlgorithms.getDigest(eSSCertIDv2.getHashAlgorithm().getAlgorithm().getId())).digest(this.signCert.getEncoded()), eSSCertIDv2.getCertHash())) {
                                                    throw new IllegalArgumentException("Signing certificate doesn't match the ESS information.");
                                                }
                                            }
                                            z = true;
                                        }
                                    }
                                    if (this.digestAttr != null) {
                                        i = 4;
                                    } else {
                                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("authenticated.attribute.is.missing.the.digest", new Object[0]));
                                    }
                                } else {
                                    i = 3;
                                    z = false;
                                }
                                if (!this.isCades || z) {
                                    int i5 = i + 1;
                                    this.digestEncryptionAlgorithmOid = ((ASN1ObjectIdentifier) ((ASN1Sequence) aSN1Sequence4.getObjectAt(i)).getObjectAt(0)).getId();
                                    int i6 = i5 + 1;
                                    this.digest = ((ASN1OctetString) aSN1Sequence4.getObjectAt(i5)).getOctets();
                                    if (i6 < aSN1Sequence4.size() && (aSN1Sequence4.getObjectAt(i6) instanceof ASN1TaggedObject) && (attribute = new AttributeTable(ASN1Set.getInstance((ASN1TaggedObject) aSN1Sequence4.getObjectAt(i6), false)).get(PKCSObjectIdentifiers.id_aa_signatureTimeStampToken)) != null && attribute.getAttrValues().size() > 0) {
                                        this.timeStampToken = new TimeStampToken(new ContentInfo(ASN1Sequence.getInstance(attribute.getAttrValues().getObjectAt(0))));
                                    }
                                    if (this.isTsp) {
                                        TimeStampToken timeStampToken2 = new TimeStampToken(new ContentInfo(aSN1Sequence));
                                        this.timeStampToken = timeStampToken2;
                                        this.messageDigest = DigestAlgorithms.getMessageDigestFromOid(timeStampToken2.getTimeStampInfo().getMessageImprintAlgOID().getId(), null);
                                        return;
                                    }
                                    if (!(this.RSAdata == null && this.digestAttr == null)) {
                                        if (PdfName.ADBE_PKCS7_SHA1.equals(getFilterSubtype())) {
                                            this.messageDigest = DigestAlgorithms.getMessageDigest(SecurityConstants.SHA1, str);
                                        } else {
                                            this.messageDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str);
                                        }
                                        this.encContDigest = DigestAlgorithms.getMessageDigest(getHashAlgorithm(), str);
                                    }
                                    this.sig = initSignature(this.signCert.getPublicKey());
                                    return;
                                }
                                throw new IllegalArgumentException("CAdES ESS information missing.");
                            }
                            throw new IllegalArgumentException(MessageLocalization.getComposedMessage("can.t.find.signing.certificate.with.serial.1", x509Principal.getName() + " / " + value.toString(16)));
                        }
                        throw new IllegalArgumentException(MessageLocalization.getComposedMessage("this.pkcs.7.object.has.multiple.signerinfos.only.one.is.supported.at.this.time", new Object[0]));
                    }
                    throw new IllegalArgumentException(MessageLocalization.getComposedMessage("not.a.valid.pkcs.7.object.not.signed.data", new Object[0]));
                }
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("not.a.valid.pkcs.7.object.not.a.sequence", new Object[0]));
            } catch (IOException unused) {
                throw new IllegalArgumentException(MessageLocalization.getComposedMessage("can.t.decode.pkcs7signeddata.object", new Object[0]));
            }
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public void setSignaturePolicy(SignaturePolicyInfo signaturePolicyInfo) {
        this.signaturePolicyIdentifier = signaturePolicyInfo.toSignaturePolicyIdentifier();
    }

    public void setSignaturePolicy(SignaturePolicyIdentifier signaturePolicyIdentifier2) {
        this.signaturePolicyIdentifier = signaturePolicyIdentifier2;
    }

    public String getSignName() {
        return this.signName;
    }

    public void setSignName(String str) {
        this.signName = str;
    }

    public String getReason() {
        return this.reason;
    }

    public void setReason(String str) {
        this.reason = str;
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String str) {
        this.location = str;
    }

    public Calendar getSignDate() {
        Calendar timeStampDate = getTimeStampDate();
        return timeStampDate == null ? this.signDate : timeStampDate;
    }

    public void setSignDate(Calendar calendar) {
        this.signDate = calendar;
    }

    public int getVersion() {
        return this.version;
    }

    public int getSigningInfoVersion() {
        return this.signerversion;
    }

    public String getDigestAlgorithmOid() {
        return this.digestAlgorithmOid;
    }

    public String getHashAlgorithm() {
        return DigestAlgorithms.getDigest(this.digestAlgorithmOid);
    }

    public String getDigestEncryptionAlgorithmOid() {
        return this.digestEncryptionAlgorithmOid;
    }

    public String getDigestAlgorithm() {
        return getHashAlgorithm() + "with" + getEncryptionAlgorithm();
    }

    public void setExternalDigest(byte[] bArr, byte[] bArr2, String str) {
        this.externalDigest = bArr;
        this.externalRSAdata = bArr2;
        if (str == null) {
            return;
        }
        if (str.equals(SecurityConstants.RSA)) {
            this.digestEncryptionAlgorithmOid = SecurityIDs.ID_RSA;
        } else if (str.equals(SecurityConstants.DSA)) {
            this.digestEncryptionAlgorithmOid = SecurityIDs.ID_DSA;
        } else if (str.equals("ECDSA")) {
            this.digestEncryptionAlgorithmOid = SecurityIDs.ID_ECDSA;
        } else {
            throw new ExceptionConverter(new NoSuchAlgorithmException(MessageLocalization.getComposedMessage("unknown.key.algorithm.1", str)));
        }
    }

    private Signature initSignature(PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        Signature signature;
        if (this.provider == null) {
            signature = Signature.getInstance(getDigestAlgorithm());
        } else {
            signature = Signature.getInstance(getDigestAlgorithm(), this.provider);
        }
        signature.initSign(privateKey);
        return signature;
    }

    private Signature initSignature(PublicKey publicKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        Signature signature;
        String digestAlgorithm = getDigestAlgorithm();
        if (PdfName.ADBE_X509_RSA_SHA1.equals(getFilterSubtype())) {
            digestAlgorithm = "SHA1withRSA";
        }
        String str = this.provider;
        if (str == null) {
            signature = Signature.getInstance(digestAlgorithm);
        } else {
            signature = Signature.getInstance(digestAlgorithm, str);
        }
        signature.initVerify(publicKey);
        return signature;
    }

    public void update(byte[] bArr, int i, int i2) throws SignatureException {
        if (this.RSAdata == null && this.digestAttr == null && !this.isTsp) {
            this.sig.update(bArr, i, i2);
        } else {
            this.messageDigest.update(bArr, i, i2);
        }
    }

    public byte[] getEncodedPKCS1() {
        try {
            if (this.externalDigest != null) {
                this.digest = this.externalDigest;
            } else {
                this.digest = this.sig.sign();
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DEROctetString(this.digest));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public byte[] getEncodedPKCS7() {
        return getEncodedPKCS7(null, null, null, null, MakeSignature.CryptoStandard.CMS);
    }

    public byte[] getEncodedPKCS7(byte[] bArr) {
        return getEncodedPKCS7(bArr, null, null, null, MakeSignature.CryptoStandard.CMS);
    }

    public byte[] getEncodedPKCS7(byte[] bArr, TSAClient tSAClient, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        byte[] timeStampToken2;
        ASN1EncodableVector buildUnauthenticatedAttributes;
        try {
            if (this.externalDigest != null) {
                this.digest = this.externalDigest;
                if (this.RSAdata != null) {
                    this.RSAdata = this.externalRSAdata;
                }
            } else if (this.externalRSAdata == null || this.RSAdata == null) {
                if (this.RSAdata != null) {
                    byte[] digest2 = this.messageDigest.digest();
                    this.RSAdata = digest2;
                    this.sig.update(digest2);
                }
                this.digest = this.sig.sign();
            } else {
                byte[] bArr3 = this.externalRSAdata;
                this.RSAdata = bArr3;
                this.sig.update(bArr3);
                this.digest = this.sig.sign();
            }
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (String str : this.digestalgos) {
                ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                aSN1EncodableVector2.add(new ASN1ObjectIdentifier(str));
                aSN1EncodableVector2.add(DERNull.INSTANCE);
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            }
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_DATA));
            if (this.RSAdata != null) {
                aSN1EncodableVector3.add(new DERTaggedObject(0, new DEROctetString(this.RSAdata)));
            }
            DERSequence dERSequence = new DERSequence(aSN1EncodableVector3);
            ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
            Iterator<Certificate> it2 = this.certs.iterator();
            while (it2.hasNext()) {
                aSN1EncodableVector4.add(new ASN1InputStream(new ByteArrayInputStream(((X509Certificate) it2.next()).getEncoded())).readObject());
            }
            DERSet dERSet = new DERSet(aSN1EncodableVector4);
            ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
            aSN1EncodableVector5.add(new ASN1Integer(this.signerversion));
            ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
            aSN1EncodableVector6.add(CertificateInfo.getIssuer(this.signCert.getTBSCertificate()));
            aSN1EncodableVector6.add(new ASN1Integer(this.signCert.getSerialNumber()));
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector6));
            ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
            aSN1EncodableVector7.add(new ASN1ObjectIdentifier(this.digestAlgorithmOid));
            aSN1EncodableVector7.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector7));
            if (bArr != null) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 0, getAuthenticatedAttributeSet(bArr, bArr2, collection, cryptoStandard)));
            }
            ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
            aSN1EncodableVector8.add(new ASN1ObjectIdentifier(this.digestEncryptionAlgorithmOid));
            aSN1EncodableVector8.add(new DERNull());
            aSN1EncodableVector5.add(new DERSequence(aSN1EncodableVector8));
            aSN1EncodableVector5.add(new DEROctetString(this.digest));
            if (!(tSAClient == null || (timeStampToken2 = tSAClient.getTimeStampToken(tSAClient.getMessageDigest().digest(this.digest))) == null || (buildUnauthenticatedAttributes = buildUnauthenticatedAttributes(timeStampToken2)) == null)) {
                aSN1EncodableVector5.add(new DERTaggedObject(false, 1, new DERSet(buildUnauthenticatedAttributes)));
            }
            ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
            aSN1EncodableVector9.add(new ASN1Integer(this.version));
            aSN1EncodableVector9.add(new DERSet(aSN1EncodableVector));
            aSN1EncodableVector9.add(dERSequence);
            aSN1EncodableVector9.add(new DERTaggedObject(false, 0, dERSet));
            aSN1EncodableVector9.add(new DERSet(new DERSequence(aSN1EncodableVector5)));
            ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
            aSN1EncodableVector10.add(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_SIGNED_DATA));
            aSN1EncodableVector10.add(new DERTaggedObject(0, new DERSequence(aSN1EncodableVector9)));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            ASN1OutputStream aSN1OutputStream = new ASN1OutputStream(byteArrayOutputStream);
            aSN1OutputStream.writeObject(new DERSequence(aSN1EncodableVector10));
            aSN1OutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private ASN1EncodableVector buildUnauthenticatedAttributes(byte[] bArr) throws IOException {
        if (bArr == null) {
            return null;
        }
        ASN1InputStream aSN1InputStream = new ASN1InputStream(new ByteArrayInputStream(bArr));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        aSN1EncodableVector2.add(new ASN1ObjectIdentifier("1.2.840.113549.1.9.16.2.14"));
        aSN1EncodableVector2.add(new DERSet((ASN1Sequence) aSN1InputStream.readObject()));
        aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        return aSN1EncodableVector;
    }

    public byte[] getAuthenticatedAttributeBytes(byte[] bArr, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        try {
            return getAuthenticatedAttributeSet(bArr, bArr2, collection, cryptoStandard).getEncoded(ASN1Encoding.DER);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    private DERSet getAuthenticatedAttributeSet(byte[] bArr, byte[] bArr2, Collection<byte[]> collection, MakeSignature.CryptoStandard cryptoStandard) {
        boolean z;
        try {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            aSN1EncodableVector2.add(new ASN1ObjectIdentifier(SecurityIDs.ID_CONTENT_TYPE));
            aSN1EncodableVector2.add(new DERSet(new ASN1ObjectIdentifier(SecurityIDs.ID_PKCS7_DATA)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
            ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
            aSN1EncodableVector3.add(new ASN1ObjectIdentifier(SecurityIDs.ID_MESSAGE_DIGEST));
            aSN1EncodableVector3.add(new DERSet(new DEROctetString(bArr)));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector3));
            if (collection != null) {
                Iterator<byte[]> it2 = collection.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (it2.next() != null) {
                            z = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            z = false;
            if (bArr2 != null || z) {
                ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
                aSN1EncodableVector4.add(new ASN1ObjectIdentifier(SecurityIDs.ID_ADBE_REVOCATION));
                ASN1EncodableVector aSN1EncodableVector5 = new ASN1EncodableVector();
                if (z) {
                    ASN1EncodableVector aSN1EncodableVector6 = new ASN1EncodableVector();
                    for (byte[] bArr3 : collection) {
                        if (bArr3 != null) {
                            aSN1EncodableVector6.add(new ASN1InputStream(new ByteArrayInputStream(bArr3)).readObject());
                        }
                    }
                    aSN1EncodableVector5.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector6)));
                }
                if (bArr2 != null) {
                    DEROctetString dEROctetString = new DEROctetString(bArr2);
                    ASN1EncodableVector aSN1EncodableVector7 = new ASN1EncodableVector();
                    ASN1EncodableVector aSN1EncodableVector8 = new ASN1EncodableVector();
                    aSN1EncodableVector8.add(OCSPObjectIdentifiers.id_pkix_ocsp_basic);
                    aSN1EncodableVector8.add(dEROctetString);
                    ASN1Enumerated aSN1Enumerated = new ASN1Enumerated(0);
                    ASN1EncodableVector aSN1EncodableVector9 = new ASN1EncodableVector();
                    aSN1EncodableVector9.add(aSN1Enumerated);
                    aSN1EncodableVector9.add(new DERTaggedObject(true, 0, new DERSequence(aSN1EncodableVector8)));
                    aSN1EncodableVector7.add(new DERSequence(aSN1EncodableVector9));
                    aSN1EncodableVector5.add(new DERTaggedObject(true, 1, new DERSequence(aSN1EncodableVector7)));
                }
                aSN1EncodableVector4.add(new DERSet(new DERSequence(aSN1EncodableVector5)));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector4));
            }
            if (cryptoStandard == MakeSignature.CryptoStandard.CADES) {
                ASN1EncodableVector aSN1EncodableVector10 = new ASN1EncodableVector();
                aSN1EncodableVector10.add(new ASN1ObjectIdentifier(SecurityIDs.ID_AA_SIGNING_CERTIFICATE_V2));
                ASN1EncodableVector aSN1EncodableVector11 = new ASN1EncodableVector();
                if (!DigestAlgorithms.getAllowedDigests("SHA-256").equals(this.digestAlgorithmOid)) {
                    aSN1EncodableVector11.add(new AlgorithmIdentifier(new ASN1ObjectIdentifier(this.digestAlgorithmOid)));
                }
                aSN1EncodableVector11.add(new DEROctetString(this.interfaceDigest.getMessageDigest(getHashAlgorithm()).digest(this.signCert.getEncoded())));
                aSN1EncodableVector10.add(new DERSet(new DERSequence(new DERSequence(new DERSequence(aSN1EncodableVector11)))));
                aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector10));
            }
            if (this.signaturePolicyIdentifier != null) {
                aSN1EncodableVector.add(new Attribute(PKCSObjectIdentifiers.id_aa_ets_sigPolicyId, new DERSet(this.signaturePolicyIdentifier)));
            }
            return new DERSet(aSN1EncodableVector);
        } catch (Exception e) {
            throw new ExceptionConverter(e);
        }
    }

    public boolean verify() throws GeneralSecurityException {
        boolean z;
        boolean z2;
        if (this.verified) {
            return this.verifyResult;
        }
        if (this.isTsp) {
            this.verifyResult = Arrays.equals(this.messageDigest.digest(), this.timeStampToken.getTimeStampInfo().toASN1Structure().getMessageImprint().getHashedMessage());
        } else if (this.sigAttr == null && this.sigAttrDer == null) {
            if (this.RSAdata != null) {
                this.sig.update(this.messageDigest.digest());
            }
            this.verifyResult = this.sig.verify(this.digest);
        } else {
            byte[] digest2 = this.messageDigest.digest();
            byte[] bArr = this.RSAdata;
            boolean z3 = false;
            if (bArr != null) {
                z2 = Arrays.equals(digest2, bArr);
                this.encContDigest.update(this.RSAdata);
                z = Arrays.equals(this.encContDigest.digest(), this.digestAttr);
            } else {
                z2 = true;
                z = false;
            }
            boolean z4 = Arrays.equals(digest2, this.digestAttr) || z;
            boolean z5 = verifySigAttributes(this.sigAttr) || verifySigAttributes(this.sigAttrDer);
            if (z4 && z5 && z2) {
                z3 = true;
            }
            this.verifyResult = z3;
        }
        this.verified = true;
        return this.verifyResult;
    }

    private boolean verifySigAttributes(byte[] bArr) throws GeneralSecurityException {
        Signature initSignature = initSignature(this.signCert.getPublicKey());
        initSignature.update(bArr);
        return initSignature.verify(this.digest);
    }

    public boolean verifyTimestampImprint() throws GeneralSecurityException {
        TimeStampToken timeStampToken2 = this.timeStampToken;
        if (timeStampToken2 == null) {
            return false;
        }
        TimeStampTokenInfo timeStampInfo = timeStampToken2.getTimeStampInfo();
        MessageImprint messageImprint = timeStampInfo.toASN1Structure().getMessageImprint();
        return Arrays.equals(new BouncyCastleDigest().getMessageDigest(DigestAlgorithms.getDigest(timeStampInfo.getMessageImprintAlgOID().getId())).digest(this.digest), messageImprint.getHashedMessage());
    }

    public Certificate[] getCertificates() {
        Collection<Certificate> collection = this.certs;
        return (Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public Certificate[] getSignCertificateChain() {
        Collection<Certificate> collection = this.signCerts;
        return (Certificate[]) collection.toArray(new X509Certificate[collection.size()]);
    }

    public X509Certificate getSigningCertificate() {
        return this.signCert;
    }

    private void signCertificateChain() {
        boolean z;
        ArrayList arrayList = new ArrayList();
        arrayList.add(this.signCert);
        ArrayList arrayList2 = new ArrayList(this.certs);
        int i = 0;
        while (i < arrayList2.size()) {
            if (this.signCert.equals(arrayList2.get(i))) {
                arrayList2.remove(i);
                i--;
            }
            i++;
        }
        while (true) {
            boolean z2 = true;
            while (true) {
                if (z2) {
                    X509Certificate x509Certificate = (X509Certificate) arrayList.get(arrayList.size() - 1);
                    int i2 = 0;
                    z = false;
                    while (true) {
                        if (i2 >= arrayList2.size()) {
                            break;
                        }
                        X509Certificate x509Certificate2 = (X509Certificate) arrayList2.get(i2);
                        try {
                            if (this.provider == null) {
                                x509Certificate.verify(x509Certificate2.getPublicKey());
                            } else {
                                x509Certificate.verify(x509Certificate2.getPublicKey(), this.provider);
                            }
                            try {
                                arrayList.add(arrayList2.get(i2));
                                arrayList2.remove(i2);
                            } catch (Exception unused) {
                                z = true;
                            }
                        } catch (Exception unused2) {
                        }
                        i2++;
                    }
                } else {
                    this.signCerts = arrayList;
                    return;
                }
                z2 = z;
            }
        }
    }

    public Collection<CRL> getCRLs() {
        return this.crls;
    }

    private void findCRL(ASN1Sequence aSN1Sequence) {
        try {
            this.crls = new ArrayList();
            for (int i = 0; i < aSN1Sequence.size(); i++) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(aSN1Sequence.getObjectAt(i).toASN1Primitive().getEncoded(ASN1Encoding.DER));
                this.crls.add((X509CRL) CertificateFactory.getInstance("X.509").generateCRL(byteArrayInputStream));
            }
        } catch (Exception unused) {
        }
    }

    public BasicOCSPResp getOcsp() {
        return this.basicResp;
    }

    public boolean isRevocationValid() {
        if (this.basicResp == null || this.signCerts.size() < 2) {
            return false;
        }
        try {
            CertificateID certID = this.basicResp.getResponses()[0].getCertID();
            return new CertificateID(new JcaDigestCalculatorProviderBuilder().build().get(new AlgorithmIdentifier(certID.getHashAlgOID(), DERNull.INSTANCE)), new JcaX509CertificateHolder(((X509Certificate[]) getSignCertificateChain())[1]), getSigningCertificate().getSerialNumber()).equals(certID);
        } catch (Exception unused) {
            return false;
        }
    }

    private void findOcsp(ASN1Sequence aSN1Sequence) throws IOException {
        boolean z;
        this.basicResp = null;
        do {
            z = false;
            if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(0)).getId().equals(OCSPObjectIdentifiers.id_pkix_ocsp_basic.getId())) {
                int i = 0;
                while (true) {
                    if (i >= aSN1Sequence.size()) {
                        z = true;
                        continue;
                        break;
                    } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1Sequence) {
                        aSN1Sequence = (ASN1Sequence) aSN1Sequence.getObjectAt(0);
                        continue;
                        break;
                    } else if (aSN1Sequence.getObjectAt(i) instanceof ASN1TaggedObject) {
                        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i);
                        if (aSN1TaggedObject.getObject() instanceof ASN1Sequence) {
                            aSN1Sequence = (ASN1Sequence) aSN1TaggedObject.getObject();
                            continue;
                        } else {
                            return;
                        }
                    } else {
                        i++;
                    }
                }
            } else {
                this.basicResp = new BasicOCSPResp(BasicOCSPResponse.getInstance(new ASN1InputStream(((ASN1OctetString) aSN1Sequence.getObjectAt(1)).getOctets()).readObject()));
                return;
            }
        } while (!z);
    }

    public boolean isTsp() {
        return this.isTsp;
    }

    public TimeStampToken getTimeStampToken() {
        return this.timeStampToken;
    }

    public Calendar getTimeStampDate() {
        if (this.timeStampToken == null) {
            return null;
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(this.timeStampToken.getTimeStampInfo().getGenTime());
        return gregorianCalendar;
    }

    public PdfName getFilterSubtype() {
        return this.filterSubtype;
    }

    public String getEncryptionAlgorithm() {
        String algorithm = EncryptionAlgorithms.getAlgorithm(this.digestEncryptionAlgorithmOid);
        return algorithm == null ? this.digestEncryptionAlgorithmOid : algorithm;
    }
}
