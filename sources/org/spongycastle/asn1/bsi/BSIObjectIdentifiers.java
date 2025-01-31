package org.spongycastle.asn1.bsi;

import androidx.exifinterface.media.ExifInterface;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface BSIObjectIdentifiers {
    public static final ASN1ObjectIdentifier bsi_de;
    public static final ASN1ObjectIdentifier ecdsa_plain_RIPEMD160 = ecdsa_plain_signatures.branch("6");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA1;
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA224 = ecdsa_plain_signatures.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA256 = ecdsa_plain_signatures.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA384 = ecdsa_plain_signatures.branch("4");
    public static final ASN1ObjectIdentifier ecdsa_plain_SHA512 = ecdsa_plain_signatures.branch("5");
    public static final ASN1ObjectIdentifier ecdsa_plain_signatures;
    public static final ASN1ObjectIdentifier id_ecc;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("0.4.0.127.0.7");
        bsi_de = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1.1");
        id_ecc = branch;
        ASN1ObjectIdentifier branch2 = branch.branch("4.1");
        ecdsa_plain_signatures = branch2;
        ecdsa_plain_SHA1 = branch2.branch("1");
    }
}
