package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.ASN1TaggedObject;
import org.spongycastle.asn1.DERSequence;

public class BodyPartList extends ASN1Object {
    private final BodyPartID[] bodyPartIDs;

    public static BodyPartList getInstance(Object obj) {
        if (obj instanceof BodyPartList) {
            return (BodyPartList) obj;
        }
        if (obj != null) {
            return new BodyPartList(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static BodyPartList getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z));
    }

    public BodyPartList(BodyPartID bodyPartID) {
        this.bodyPartIDs = new BodyPartID[]{bodyPartID};
    }

    public BodyPartList(BodyPartID[] bodyPartIDArr) {
        this.bodyPartIDs = Utils.clone(bodyPartIDArr);
    }

    private BodyPartList(ASN1Sequence aSN1Sequence) {
        this.bodyPartIDs = Utils.toBodyPartIDArray(aSN1Sequence);
    }

    public BodyPartID[] getBodyPartIDs() {
        return Utils.clone(this.bodyPartIDs);
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(this.bodyPartIDs);
    }
}
