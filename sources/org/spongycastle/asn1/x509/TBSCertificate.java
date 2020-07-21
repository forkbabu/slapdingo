package org.spongycastle.asn1.x509;

import org.spongycastle.asn1.ASN1Integer;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERBitString;
import org.spongycastle.asn1.x500.X500Name;

public class TBSCertificate extends ASN1Object {
    Time endDate;
    Extensions extensions;
    X500Name issuer;
    DERBitString issuerUniqueId;
    ASN1Sequence seq;
    ASN1Integer serialNumber;
    AlgorithmIdentifier signature;
    Time startDate;
    X500Name subject;
    SubjectPublicKeyInfo subjectPublicKeyInfo;
    DERBitString subjectUniqueId;
    ASN1Integer version;

    public static TBSCertificate getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public static TBSCertificate getInstance(Object obj) {
        if (obj instanceof TBSCertificate) {
            return (TBSCertificate) obj;
        }
        if (obj != null) {
            return new TBSCertificate(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00d0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TBSCertificate(org.spongycastle.asn1.ASN1Sequence r9) {
        /*
            r8 = this;
            r8.<init>()
            r8.seq = r9
            r0 = 0
            org.spongycastle.asn1.ASN1Encodable r1 = r9.getObjectAt(r0)
            boolean r1 = r1 instanceof org.spongycastle.asn1.ASN1TaggedObject
            r2 = 0
            r4 = 1
            if (r1 == 0) goto L_0x001f
            org.spongycastle.asn1.ASN1Encodable r1 = r9.getObjectAt(r0)
            org.spongycastle.asn1.ASN1TaggedObject r1 = (org.spongycastle.asn1.ASN1TaggedObject) r1
            org.spongycastle.asn1.ASN1Integer r1 = org.spongycastle.asn1.ASN1Integer.getInstance(r1, r4)
            r8.version = r1
            r1 = 0
            goto L_0x0027
        L_0x001f:
            org.spongycastle.asn1.ASN1Integer r1 = new org.spongycastle.asn1.ASN1Integer
            r1.<init>(r2)
            r8.version = r1
            r1 = -1
        L_0x0027:
            org.spongycastle.asn1.ASN1Integer r5 = r8.version
            java.math.BigInteger r5 = r5.getValue()
            java.math.BigInteger r2 = java.math.BigInteger.valueOf(r2)
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x003a
            r2 = 1
        L_0x0038:
            r3 = 0
            goto L_0x0063
        L_0x003a:
            org.spongycastle.asn1.ASN1Integer r2 = r8.version
            java.math.BigInteger r2 = r2.getValue()
            r5 = 1
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r5)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004f
            r2 = 0
            r3 = 1
            goto L_0x0063
        L_0x004f:
            org.spongycastle.asn1.ASN1Integer r2 = r8.version
            java.math.BigInteger r2 = r2.getValue()
            r5 = 2
            java.math.BigInteger r3 = java.math.BigInteger.valueOf(r5)
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x010b
            r2 = 0
            goto L_0x0038
        L_0x0063:
            int r5 = r1 + 1
            org.spongycastle.asn1.ASN1Encodable r5 = r9.getObjectAt(r5)
            org.spongycastle.asn1.ASN1Integer r5 = org.spongycastle.asn1.ASN1Integer.getInstance(r5)
            r8.serialNumber = r5
            int r5 = r1 + 2
            org.spongycastle.asn1.ASN1Encodable r5 = r9.getObjectAt(r5)
            org.spongycastle.asn1.x509.AlgorithmIdentifier r5 = org.spongycastle.asn1.x509.AlgorithmIdentifier.getInstance(r5)
            r8.signature = r5
            int r5 = r1 + 3
            org.spongycastle.asn1.ASN1Encodable r5 = r9.getObjectAt(r5)
            org.spongycastle.asn1.x500.X500Name r5 = org.spongycastle.asn1.x500.X500Name.getInstance(r5)
            r8.issuer = r5
            int r5 = r1 + 4
            org.spongycastle.asn1.ASN1Encodable r5 = r9.getObjectAt(r5)
            org.spongycastle.asn1.ASN1Sequence r5 = (org.spongycastle.asn1.ASN1Sequence) r5
            org.spongycastle.asn1.ASN1Encodable r6 = r5.getObjectAt(r0)
            org.spongycastle.asn1.x509.Time r6 = org.spongycastle.asn1.x509.Time.getInstance(r6)
            r8.startDate = r6
            org.spongycastle.asn1.ASN1Encodable r5 = r5.getObjectAt(r4)
            org.spongycastle.asn1.x509.Time r5 = org.spongycastle.asn1.x509.Time.getInstance(r5)
            r8.endDate = r5
            int r5 = r1 + 5
            org.spongycastle.asn1.ASN1Encodable r5 = r9.getObjectAt(r5)
            org.spongycastle.asn1.x500.X500Name r5 = org.spongycastle.asn1.x500.X500Name.getInstance(r5)
            r8.subject = r5
            int r1 = r1 + 6
            org.spongycastle.asn1.ASN1Encodable r5 = r9.getObjectAt(r1)
            org.spongycastle.asn1.x509.SubjectPublicKeyInfo r5 = org.spongycastle.asn1.x509.SubjectPublicKeyInfo.getInstance(r5)
            r8.subjectPublicKeyInfo = r5
            int r5 = r9.size()
            int r5 = r5 - r1
            int r5 = r5 - r4
            if (r5 == 0) goto L_0x00ce
            if (r2 != 0) goto L_0x00c6
            goto L_0x00ce
        L_0x00c6:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version 1 certificate contains extra data"
            r9.<init>(r0)
            throw r9
        L_0x00ce:
            if (r5 <= 0) goto L_0x010a
            int r2 = r1 + r5
            org.spongycastle.asn1.ASN1Encodable r2 = r9.getObjectAt(r2)
            org.spongycastle.asn1.ASN1TaggedObject r2 = (org.spongycastle.asn1.ASN1TaggedObject) r2
            int r6 = r2.getTagNo()
            if (r6 == r4) goto L_0x0101
            r7 = 2
            if (r6 == r7) goto L_0x00fa
            r7 = 3
            if (r6 == r7) goto L_0x00e5
            goto L_0x0107
        L_0x00e5:
            if (r3 != 0) goto L_0x00f2
            org.spongycastle.asn1.ASN1Sequence r2 = org.spongycastle.asn1.ASN1Sequence.getInstance(r2, r4)
            org.spongycastle.asn1.x509.Extensions r2 = org.spongycastle.asn1.x509.Extensions.getInstance(r2)
            r8.extensions = r2
            goto L_0x0107
        L_0x00f2:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version 2 certificate cannot contain extensions"
            r9.<init>(r0)
            throw r9
        L_0x00fa:
            org.spongycastle.asn1.DERBitString r2 = org.spongycastle.asn1.DERBitString.getInstance(r2, r0)
            r8.subjectUniqueId = r2
            goto L_0x0107
        L_0x0101:
            org.spongycastle.asn1.DERBitString r2 = org.spongycastle.asn1.DERBitString.getInstance(r2, r0)
            r8.issuerUniqueId = r2
        L_0x0107:
            int r5 = r5 + -1
            goto L_0x00ce
        L_0x010a:
            return
        L_0x010b:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "version number not recognised"
            r9.<init>(r0)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.spongycastle.asn1.x509.TBSCertificate.<init>(org.spongycastle.asn1.ASN1Sequence):void");
    }

    public int getVersionNumber() {
        return this.version.getValue().intValue() + 1;
    }

    public ASN1Integer getVersion() {
        return this.version;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public Time getStartDate() {
        return this.startDate;
    }

    public Time getEndDate() {
        return this.endDate;
    }

    public X500Name getSubject() {
        return this.subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPublicKeyInfo;
    }

    public DERBitString getIssuerUniqueId() {
        return this.issuerUniqueId;
    }

    public DERBitString getSubjectUniqueId() {
        return this.subjectUniqueId;
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
