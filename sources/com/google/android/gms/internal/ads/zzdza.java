package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdza {
    @Deprecated
    private static final zzeca zzhqt;
    @Deprecated
    private static final zzeca zzhqu;
    @Deprecated
    private static final zzeca zzhqv;
    private static final String zzhrv = new zzdyw().getKeyType();

    public static void zzaxz() throws GeneralSecurityException {
        zzdwy.zza((zzdwj) new zzdyw(), true);
        zzdwy.zza((zzdwj) new zzdyr(), true);
        zzdwy.zza(new zzdyz());
    }

    static {
        zzeca zzbce = zzeca.zzbce();
        zzhqt = zzbce;
        zzhqu = zzbce;
        zzhqv = zzbce;
        try {
            zzaxz();
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
