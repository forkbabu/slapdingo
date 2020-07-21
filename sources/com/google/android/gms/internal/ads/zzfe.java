package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzfe {
    static zzdwf zzzz;

    static boolean zzb(zzex zzex) throws IllegalAccessException, InvocationTargetException {
        Method zza;
        if (zzzz != null) {
            return true;
        }
        String str = (String) zzwg.zzpw().zzd(zzaav.zzcqn);
        if (str == null || str.length() == 0) {
            if (zzex == null || (zza = zzex.zza("IPyaXEy+F5at6zi6GEs/jkKHpFTAlYWM90ImI4874hawRCOEgKKUBzsomxFaeDkJ", "UMjKs/aJTfdn6BJRL96Zl/lGRXJtRxPMhZNhmq0gEjI=")) == null) {
                str = null;
            } else {
                str = (String) zza.invoke(null, new Object[0]);
            }
            if (str == null) {
                return false;
            }
        }
        try {
            zzdwo zzm = zzdws.zzm(zzcv.zza(str, true));
            for (zzebm zzebm : zzdyl.zzhqt.zzbcd()) {
                if (zzebm.zzbar().isEmpty()) {
                    throw new GeneralSecurityException("Missing type_url.");
                } else if (zzebm.zzbaz().isEmpty()) {
                    throw new GeneralSecurityException("Missing primitive_name.");
                } else if (zzebm.zzbbc().isEmpty()) {
                    throw new GeneralSecurityException("Missing catalogue_name.");
                } else if (!zzebm.zzbbc().equals("TinkAead") && !zzebm.zzbbc().equals("TinkMac") && !zzebm.zzbbc().equals("TinkHybridDecrypt") && !zzebm.zzbbc().equals("TinkHybridEncrypt") && !zzebm.zzbbc().equals("TinkPublicKeySign") && !zzebm.zzbbc().equals("TinkPublicKeyVerify") && !zzebm.zzbbc().equals("TinkStreamingAead") && !zzebm.zzbbc().equals("TinkDeterministicAead")) {
                    zzdwb<?> zzhl = zzdwy.zzhl(zzebm.zzbbc());
                    zzdwy.zza(zzhl.zzaxh());
                    zzdwy.zza(zzhl.zzb(zzebm.zzbar(), zzebm.zzbaz(), zzebm.zzbba()), zzebm.zzbbb());
                }
            }
            zzdwf zza2 = zzdym.zza(zzm, null);
            zzzz = zza2;
            if (zza2 != null) {
                return true;
            }
            return false;
        } catch (IllegalArgumentException unused) {
        }
    }
}
