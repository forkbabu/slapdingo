package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.security.NoSuchAlgorithmException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdyq {
    public static void zza(zzeam zzeam) throws GeneralSecurityException {
        zzedc.zza(zza(zzeam.zzazq().zzbad()));
        zza(zzeam.zzazq().zzbae());
        if (zzeam.zzazs() != zzeag.UNKNOWN_FORMAT) {
            zzdwy.zza(zzeam.zzazr().zzazl());
            return;
        }
        throw new GeneralSecurityException("unknown EC point format");
    }

    public static String zza(zzeav zzeav) throws NoSuchAlgorithmException {
        int i = zzdyp.zzhrm[zzeav.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha512";
        }
        String valueOf = String.valueOf(zzeav);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 27);
        sb.append("hash unsupported for HMAC: ");
        sb.append(valueOf);
        throw new NoSuchAlgorithmException(sb.toString());
    }

    public static zzede zza(zzeau zzeau) throws GeneralSecurityException {
        int i = zzdyp.zzhrn[zzeau.ordinal()];
        if (i == 1) {
            return zzede.NIST_P256;
        }
        if (i == 2) {
            return zzede.NIST_P384;
        }
        if (i == 3) {
            return zzede.NIST_P521;
        }
        String valueOf = String.valueOf(zzeau);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 20);
        sb.append("unknown curve type: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }

    public static zzedd zza(zzeag zzeag) throws GeneralSecurityException {
        int i = zzdyp.zzhro[zzeag.ordinal()];
        if (i == 1) {
            return zzedd.UNCOMPRESSED;
        }
        if (i == 2) {
            return zzedd.DO_NOT_USE_CRUNCHY_UNCOMPRESSED;
        }
        if (i == 3) {
            return zzedd.COMPRESSED;
        }
        String valueOf = String.valueOf(zzeag);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 22);
        sb.append("unknown point format: ");
        sb.append(valueOf);
        throw new GeneralSecurityException(sb.toString());
    }
}
