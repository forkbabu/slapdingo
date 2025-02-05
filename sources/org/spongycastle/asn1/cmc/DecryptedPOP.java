package org.spongycastle.asn1.cmc;

import org.spongycastle.asn1.ASN1EncodableVector;
import org.spongycastle.asn1.ASN1Object;
import org.spongycastle.asn1.ASN1OctetString;
import org.spongycastle.asn1.ASN1Primitive;
import org.spongycastle.asn1.ASN1Sequence;
import org.spongycastle.asn1.DEROctetString;
import org.spongycastle.asn1.DERSequence;
import org.spongycastle.asn1.x509.AlgorithmIdentifier;
import org.spongycastle.util.Arrays;

public class DecryptedPOP extends ASN1Object {
    private final BodyPartID bodyPartID;
    private final byte[] thePOP;
    private final AlgorithmIdentifier thePOPAlgID;

    public DecryptedPOP(BodyPartID bodyPartID2, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        this.bodyPartID = bodyPartID2;
        this.thePOPAlgID = algorithmIdentifier;
        this.thePOP = Arrays.clone(bArr);
    }

    private DecryptedPOP(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            this.bodyPartID = BodyPartID.getInstance(aSN1Sequence.getObjectAt(0));
            this.thePOPAlgID = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(1));
            this.thePOP = Arrays.clone(ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2)).getOctets());
            return;
        }
        throw new IllegalArgumentException("incorrect sequence size");
    }

    public static DecryptedPOP getInstance(Object obj) {
        if (obj instanceof DecryptedPOP) {
            return (DecryptedPOP) obj;
        }
        if (obj != null) {
            return new DecryptedPOP(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BodyPartID getBodyPartID() {
        return this.bodyPartID;
    }

    public AlgorithmIdentifier getThePOPAlgID() {
        return this.thePOPAlgID;
    }

    public byte[] getThePOP() {
        return Arrays.clone(this.thePOP);
    }

    @Override // org.spongycastle.asn1.ASN1Encodable, org.spongycastle.asn1.ASN1Object
    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.bodyPartID);
        aSN1EncodableVector.add(this.thePOPAlgID);
        aSN1EncodableVector.add(new DEROctetString(this.thePOP));
        return new DERSequence(aSN1EncodableVector);
    }
}
