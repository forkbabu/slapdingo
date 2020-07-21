package com.itextpdf.text.pdf.security;

import java.security.GeneralSecurityException;
import java.security.PrivateKey;
import java.security.Signature;

public class PrivateKeySignature implements ExternalSignature {
    private String encryptionAlgorithm;
    private String hashAlgorithm;
    private PrivateKey pk;
    private String provider;

    public PrivateKeySignature(PrivateKey privateKey, String str, String str2) {
        this.pk = privateKey;
        this.provider = str2;
        this.hashAlgorithm = DigestAlgorithms.getDigest(DigestAlgorithms.getAllowedDigests(str));
        String algorithm = privateKey.getAlgorithm();
        this.encryptionAlgorithm = algorithm;
        if (algorithm.startsWith("EC")) {
            this.encryptionAlgorithm = "ECDSA";
        }
    }

    @Override // com.itextpdf.text.pdf.security.ExternalSignature
    public String getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    @Override // com.itextpdf.text.pdf.security.ExternalSignature
    public String getEncryptionAlgorithm() {
        return this.encryptionAlgorithm;
    }

    @Override // com.itextpdf.text.pdf.security.ExternalSignature
    public byte[] sign(byte[] bArr) throws GeneralSecurityException {
        Signature signature;
        String str = this.hashAlgorithm + "with" + this.encryptionAlgorithm;
        String str2 = this.provider;
        if (str2 == null) {
            signature = Signature.getInstance(str);
        } else {
            signature = Signature.getInstance(str, str2);
        }
        signature.initSign(this.pk);
        signature.update(bArr);
        return signature.sign();
    }
}
