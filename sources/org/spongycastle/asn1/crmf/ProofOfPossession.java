package org.spongycastle.asn1.crmf;

import org.spongycastle.asn1.ASN1Choice;
import org.spongycastle.asn1.ASN1Encodable;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERNull;
import org.spongycastle.asn1.DERTaggedObject;

public class ProofOfPossession extends ASN1Object implements ASN1Choice {
    public static final int TYPE_KEY_AGREEMENT = 3;
    public static final int TYPE_KEY_ENCIPHERMENT = 2;
    public static final int TYPE_RA_VERIFIED = 0;
    public static final int TYPE_SIGNING_KEY = 1;
    private ASN1Encodable obj;
    private int tagNo;

    private ProofOfPossession(ASN1TaggedObject aSN1TaggedObject) {
        int tagNo2 = aSN1TaggedObject.getTagNo();
        this.tagNo = tagNo2;
        if (tagNo2 == 0) {
            this.obj = DERNull.INSTANCE;
        } else if (tagNo2 == 1) {
            this.obj = POPOSigningKey.getInstance(aSN1TaggedObject, false);
        } else if (tagNo2 == 2 || tagNo2 == 3) {
            this.obj = POPOPrivKey.getInstance(aSN1TaggedObject, true);
        } else {
            throw new IllegalArgumentException("unknown tag: " + this.tagNo);
        }
    }

    public static ProofOfPossession getInstance(Object obj2) {
        if (obj2 == null || (obj2 instanceof ProofOfPossession)) {
            return (ProofOfPossession) obj2;
        }
        if (obj2 instanceof ASN1TaggedObject) {
            return new ProofOfPossession((ASN1TaggedObject) obj2);
        }
        throw new IllegalArgumentException("Invalid object: " + obj2.getClass().getName());
    }

    public ProofOfPossession() {
        this.tagNo = 0;
        this.obj = DERNull.INSTANCE;
    }

    public ProofOfPossession(POPOSigningKey pOPOSigningKey) {
        this.tagNo = 1;
        this.obj = pOPOSigningKey;
    }

    public ProofOfPossession(int i, POPOPrivKey pOPOPrivKey) {
        this.tagNo = i;
        this.obj = pOPOPrivKey;
    }

    public int getType() {
        return this.tagNo;
    }

    public ASN1Encodable getObject() {
        return this.obj;
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(false, this.tagNo, this.obj);
    }
}
