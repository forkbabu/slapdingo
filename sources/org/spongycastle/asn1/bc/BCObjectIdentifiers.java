package org.spongycastle.asn1.bc;

import androidx.exifinterface.media.ExifInterface;
import lib.folderpicker.BuildConfig;
import org.spongycastle.asn1.ASN1ObjectIdentifier;

public interface BCObjectIdentifiers {
    public static final ASN1ObjectIdentifier bc;
    public static final ASN1ObjectIdentifier bc_exch;
    public static final ASN1ObjectIdentifier bc_pbe;
    public static final ASN1ObjectIdentifier bc_pbe_sha1;
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12 = bc_pbe_sha1.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes128_cbc = bc_pbe_sha1_pkcs12.branch("1.2");
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes192_cbc = bc_pbe_sha1_pkcs12.branch("1.22");
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs12_aes256_cbc = bc_pbe_sha1_pkcs12.branch("1.42");
    public static final ASN1ObjectIdentifier bc_pbe_sha1_pkcs5 = bc_pbe_sha1.branch("1");
    public static final ASN1ObjectIdentifier bc_pbe_sha224 = bc_pbe.branch(BuildConfig.VERSION_NAME);
    public static final ASN1ObjectIdentifier bc_pbe_sha256 = bc_pbe.branch("2.1");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12 = bc_pbe_sha256.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes128_cbc = bc_pbe_sha256_pkcs12.branch("1.2");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes192_cbc = bc_pbe_sha256_pkcs12.branch("1.22");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs12_aes256_cbc = bc_pbe_sha256_pkcs12.branch("1.42");
    public static final ASN1ObjectIdentifier bc_pbe_sha256_pkcs5 = bc_pbe_sha256.branch("1");
    public static final ASN1ObjectIdentifier bc_pbe_sha384 = bc_pbe.branch("2.2");
    public static final ASN1ObjectIdentifier bc_pbe_sha512 = bc_pbe.branch("2.3");
    public static final ASN1ObjectIdentifier bc_sig;
    public static final ASN1ObjectIdentifier newHope;
    public static final ASN1ObjectIdentifier sphincs256;
    public static final ASN1ObjectIdentifier sphincs256_with_BLAKE512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA3_512 = sphincs256.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier sphincs256_with_SHA512 = sphincs256.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier xmss;
    public static final ASN1ObjectIdentifier xmss_mt;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA256;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA512 = xmss_mt.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE128 = xmss_mt.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE256 = xmss_mt.branch("4");
    public static final ASN1ObjectIdentifier xmss_with_SHA256;
    public static final ASN1ObjectIdentifier xmss_with_SHA512 = xmss.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier xmss_with_SHAKE128 = xmss.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier xmss_with_SHAKE256 = xmss.branch("4");

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.22554");
        bc = aSN1ObjectIdentifier;
        ASN1ObjectIdentifier branch = aSN1ObjectIdentifier.branch("1");
        bc_pbe = branch;
        bc_pbe_sha1 = branch.branch("1");
        ASN1ObjectIdentifier branch2 = bc.branch(ExifInterface.GPS_MEASUREMENT_2D);
        bc_sig = branch2;
        ASN1ObjectIdentifier branch3 = branch2.branch("1");
        sphincs256 = branch3;
        sphincs256_with_BLAKE512 = branch3.branch("1");
        ASN1ObjectIdentifier branch4 = bc_sig.branch(ExifInterface.GPS_MEASUREMENT_2D);
        xmss = branch4;
        xmss_with_SHA256 = branch4.branch("1");
        ASN1ObjectIdentifier branch5 = bc_sig.branch(ExifInterface.GPS_MEASUREMENT_3D);
        xmss_mt = branch5;
        xmss_mt_with_SHA256 = branch5.branch("1");
        ASN1ObjectIdentifier branch6 = bc.branch(ExifInterface.GPS_MEASUREMENT_3D);
        bc_exch = branch6;
        newHope = branch6.branch("1");
    }
}
