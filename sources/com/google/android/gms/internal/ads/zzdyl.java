package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdyl {
    @Deprecated
    public static final zzeca zzhqt = zzeca.zzbce();
    @Deprecated
    private static final zzeca zzhqu = zzeca.zzbce();
    @Deprecated
    private static final zzeca zzhqv = zzeca.zzbce();
    private static final String zzhrj = new zzdyj().getKeyType();
    private static final String zzhrk = new zzdye().getKeyType();

    static {
        try {
            zzdxe.zzaxz();
            zzdwy.zza((zzdwv) new zzdye(), (zzdwj) new zzdyj(), true);
            zzdwy.zza(new zzdyk());
            zzdwy.zza(new zzdyo());
        } catch (GeneralSecurityException e) {
            throw new ExceptionInInitializerError(e);
        }
    }
}
