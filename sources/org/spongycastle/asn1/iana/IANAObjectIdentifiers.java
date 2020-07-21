package org.spongycastle.asn1.iana;

import androidx.exifinterface.media.ExifInterface;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface IANAObjectIdentifiers {
    public static final ASN1ObjectIdentifier SNMPv2 = internet.branch("6");
    public static final ASN1ObjectIdentifier _private = internet.branch("4");
    public static final ASN1ObjectIdentifier directory;
    public static final ASN1ObjectIdentifier experimental = internet.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier hmacMD5;
    public static final ASN1ObjectIdentifier hmacRIPEMD160 = isakmpOakley.branch("4");
    public static final ASN1ObjectIdentifier hmacSHA1 = isakmpOakley.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier hmacTIGER = isakmpOakley.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier internet;
    public static final ASN1ObjectIdentifier ipsec;
    public static final ASN1ObjectIdentifier isakmpOakley;
    public static final ASN1ObjectIdentifier mail = internet.branch("7");
    public static final ASN1ObjectIdentifier mgmt = internet.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier pkix = security_mechanisms.branch("6");
    public static final ASN1ObjectIdentifier security = internet.branch("5");
    public static final ASN1ObjectIdentifier security_mechanisms = security.branch("5");
    public static final ASN1ObjectIdentifier security_nametypes = security.branch("6");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1");
        internet = aSN1ObjectIdentifier;
        directory = aSN1ObjectIdentifier.branch("1");
        ASN1ObjectIdentifier branch = security_mechanisms.branch("8");
        ipsec = branch;
        ASN1ObjectIdentifier branch2 = branch.branch("1");
        isakmpOakley = branch2;
        hmacMD5 = branch2.branch("1");
    }
}
