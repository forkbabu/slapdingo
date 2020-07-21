package org.spongycastle.pqc.asn1;

import androidx.exifinterface.media.ExifInterface;
import org.spongycastle.asn1.ASN1ObjectIdentifier;
import org.spongycastle.asn1.bc.BCObjectIdentifiers;
import org.spongycastle.pqc.crypto.gmss.GMSSKeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceCCA2KeyPairGenerator;
import org.spongycastle.pqc.crypto.mceliece.McElieceCipher;
import org.spongycastle.pqc.crypto.mceliece.McElieceFujisakiCipher;
import org.spongycastle.pqc.crypto.mceliece.McElieceKobaraImaiCipher;
import org.spongycastle.pqc.crypto.mceliece.McEliecePointchevalCipher;

public interface PQCObjectIdentifiers {
    public static final ASN1ObjectIdentifier gmss;
    public static final ASN1ObjectIdentifier gmssWithSha1;
    public static final ASN1ObjectIdentifier gmssWithSha224 = gmss.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier gmssWithSha256 = gmss.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier gmssWithSha384 = gmss.branch("4");
    public static final ASN1ObjectIdentifier gmssWithSha512 = gmss.branch("5");
    public static final ASN1ObjectIdentifier mcEliece = new ASN1ObjectIdentifier(McElieceCipher.OID);
    public static final ASN1ObjectIdentifier mcElieceCca2 = new ASN1ObjectIdentifier(McElieceCCA2KeyPairGenerator.OID);
    public static final ASN1ObjectIdentifier mcElieceFujisaki = new ASN1ObjectIdentifier(McElieceFujisakiCipher.OID);
    public static final ASN1ObjectIdentifier mcElieceKobara_Imai = new ASN1ObjectIdentifier(McElieceKobaraImaiCipher.OID);
    public static final ASN1ObjectIdentifier mcEliecePointcheval = new ASN1ObjectIdentifier(McEliecePointchevalCipher.OID);
    public static final ASN1ObjectIdentifier newHope = BCObjectIdentifiers.newHope;
    public static final ASN1ObjectIdentifier rainbow;
    public static final ASN1ObjectIdentifier rainbowWithSha1;
    public static final ASN1ObjectIdentifier rainbowWithSha224 = rainbow.branch(ExifInterface.GPS_MEASUREMENT_2D);
    public static final ASN1ObjectIdentifier rainbowWithSha256 = rainbow.branch(ExifInterface.GPS_MEASUREMENT_3D);
    public static final ASN1ObjectIdentifier rainbowWithSha384 = rainbow.branch("4");
    public static final ASN1ObjectIdentifier rainbowWithSha512 = rainbow.branch("5");
    public static final ASN1ObjectIdentifier sphincs256 = BCObjectIdentifiers.sphincs256;
    public static final ASN1ObjectIdentifier sphincs256_with_BLAKE512 = BCObjectIdentifiers.sphincs256_with_BLAKE512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA3_512 = BCObjectIdentifiers.sphincs256_with_SHA3_512;
    public static final ASN1ObjectIdentifier sphincs256_with_SHA512 = BCObjectIdentifiers.sphincs256_with_SHA512;
    public static final ASN1ObjectIdentifier xmss = BCObjectIdentifiers.xmss;
    public static final ASN1ObjectIdentifier xmss_mt = BCObjectIdentifiers.xmss_mt;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA256 = BCObjectIdentifiers.xmss_mt_with_SHA256;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHA512 = BCObjectIdentifiers.xmss_mt_with_SHA512;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE128 = BCObjectIdentifiers.xmss_mt_with_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_mt_with_SHAKE256 = BCObjectIdentifiers.xmss_mt_with_SHAKE256;
    public static final ASN1ObjectIdentifier xmss_with_SHA256 = BCObjectIdentifiers.xmss_with_SHA256;
    public static final ASN1ObjectIdentifier xmss_with_SHA512 = BCObjectIdentifiers.xmss_with_SHA512;
    public static final ASN1ObjectIdentifier xmss_with_SHAKE128 = BCObjectIdentifiers.xmss_with_SHAKE128;
    public static final ASN1ObjectIdentifier xmss_with_SHAKE256 = BCObjectIdentifiers.xmss_with_SHAKE256;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier("1.3.6.1.4.1.8301.3.1.3.5.3.2");
        rainbow = aSN1ObjectIdentifier;
        rainbowWithSha1 = aSN1ObjectIdentifier.branch("1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = new ASN1ObjectIdentifier(GMSSKeyPairGenerator.OID);
        gmss = aSN1ObjectIdentifier2;
        gmssWithSha1 = aSN1ObjectIdentifier2.branch("1");
    }
}
