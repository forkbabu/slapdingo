package com.itextpdf.text.pdf.security;

import com.itextpdf.text.pdf.codec.Base64;
import org.spongycastle.asn1.DERIA5String;
import org.spongycastle.asn1.DERObjectIdentifier;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.esf.OtherHashAlgAndValue;
import org.spongycastle.asn1.esf.SigPolicyQualifierInfo;
import org.spongycastle.asn1.esf.SigPolicyQualifiers;
import org.spongycastle.asn1.esf.SignaturePolicyId;
import org.spongycastle.asn1.esf.SignaturePolicyIdentifier;
import org.spongycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;

public class SignaturePolicyInfo {
    private String policyDigestAlgorithm;
    private byte[] policyHash;
    private String policyIdentifier;
    private String policyUri;

    public SignaturePolicyInfo(String str, byte[] bArr, String str2, String str3) {
        if (str == null || str.length() == 0) {
            throw new IllegalArgumentException("Policy identifier cannot be null");
        } else if (bArr == null) {
            throw new IllegalArgumentException("Policy hash cannot be null");
        } else if (str2 == null || str2.length() == 0) {
            throw new IllegalArgumentException("Policy digest algorithm cannot be null");
        } else {
            this.policyIdentifier = str;
            this.policyHash = bArr;
            this.policyDigestAlgorithm = str2;
            this.policyUri = str3;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SignaturePolicyInfo(String str, String str2, String str3, String str4) {
        this(str, str2 != null ? Base64.decode(str2) : null, str3, str4);
    }

    public String getPolicyIdentifier() {
        return this.policyIdentifier;
    }

    public byte[] getPolicyHash() {
        return this.policyHash;
    }

    public String getPolicyDigestAlgorithm() {
        return this.policyDigestAlgorithm;
    }

    public String getPolicyUri() {
        return this.policyUri;
    }

    /* access modifiers changed from: package-private */
    public SignaturePolicyIdentifier toSignaturePolicyIdentifier() {
        String allowedDigests = DigestAlgorithms.getAllowedDigests(this.policyDigestAlgorithm);
        if (allowedDigests == null || allowedDigests.length() == 0) {
            throw new IllegalArgumentException("Invalid policy hash algorithm");
        }
        SigPolicyQualifierInfo sigPolicyQualifierInfo = null;
        String str = this.policyUri;
        if (str != null && str.length() > 0) {
            sigPolicyQualifierInfo = new SigPolicyQualifierInfo(PKCSObjectIdentifiers.id_spq_ets_uri, new DERIA5String(this.policyUri));
        }
        return new SignaturePolicyIdentifier(new SignaturePolicyId(DERObjectIdentifier.getInstance(new DERObjectIdentifier(this.policyIdentifier.replace("urn:oid:", ""))), new OtherHashAlgAndValue(new AlgorithmIdentifier(allowedDigests), new DEROctetString(this.policyHash)), new SigPolicyQualifiers(new SigPolicyQualifierInfo[]{sigPolicyQualifierInfo})));
    }
}
