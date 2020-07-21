package org.spongycastle.asn1.teletrust;

import androidx.exifinterface.media.ExifInterface;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface TeleTrusTObjectIdentifiers {
    public static final ASN1ObjectIdentifier brainpoolP160r1;
    public static final ASN1ObjectIdentifier brainpoolP160t1 = versionOne.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier brainpoolP192r1 = versionOne.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier brainpoolP192t1 = versionOne.branch("4");
    public static final ASN1ObjectIdentifier brainpoolP224r1 = versionOne.branch("5");
    public static final ASN1ObjectIdentifier brainpoolP224t1 = versionOne.branch("6");
    public static final ASN1ObjectIdentifier brainpoolP256r1 = versionOne.branch("7");
    public static final ASN1ObjectIdentifier brainpoolP256t1 = versionOne.branch("8");
    public static final ASN1ObjectIdentifier brainpoolP320r1 = versionOne.branch("9");
    public static final ASN1ObjectIdentifier brainpoolP320t1 = versionOne.branch("10");
    public static final ASN1ObjectIdentifier brainpoolP384r1 = versionOne.branch("11");
    public static final ASN1ObjectIdentifier brainpoolP384t1 = versionOne.branch("12");
    public static final ASN1ObjectIdentifier brainpoolP512r1 = versionOne.branch("13");
    public static final ASN1ObjectIdentifier brainpoolP512t1 = versionOne.branch("14");
    public static final ASN1ObjectIdentifier ecSign;
    public static final ASN1ObjectIdentifier ecSignWithRipemd160 = ecSign.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier ecSignWithSha1;
    public static final ASN1ObjectIdentifier ecc_brainpool;
    public static final ASN1ObjectIdentifier ellipticCurve;
    public static final ASN1ObjectIdentifier ripemd128 = teleTrusTAlgorithm.branch("2.2");
    public static final ASN1ObjectIdentifier ripemd160;
    public static final ASN1ObjectIdentifier ripemd256 = teleTrusTAlgorithm.branch("2.3");
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd128 = teleTrusTRSAsignatureAlgorithm.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd160;
    public static final ASN1ObjectIdentifier rsaSignatureWithripemd256 = teleTrusTRSAsignatureAlgorithm.branch("4");
    public static final ASN1ObjectIdentifier teleTrusTAlgorithm;
    public static final ASN1ObjectIdentifier teleTrusTRSAsignatureAlgorithm;
    public static final ASN1ObjectIdentifier versionOne;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.36.3");
        teleTrusTAlgorithm = aSN1ObjectIdentifier;
        ripemd160 = aSN1ObjectIdentifier.branch("2.1");
        ASN1ObjectIdentifier branch = teleTrusTAlgorithm.branch("3.1");
        teleTrusTRSAsignatureAlgorithm = branch;
        rsaSignatureWithripemd160 = branch.branch(ExifInterface.GPS_MEASUREMENT_2D);
        ASN1ObjectIdentifier branch2 = teleTrusTAlgorithm.branch("3.2");
        ecSign = branch2;
        ecSignWithSha1 = branch2.branch("1");
        ASN1ObjectIdentifier branch3 = teleTrusTAlgorithm.branch("3.2.8");
        ecc_brainpool = branch3;
        ASN1ObjectIdentifier branch4 = branch3.branch("1");
        ellipticCurve = branch4;
        ASN1ObjectIdentifier branch5 = branch4.branch("1");
        versionOne = branch5;
        brainpoolP160r1 = branch5.branch("1");
    }
}
