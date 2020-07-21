package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdxe {
    public static final String zzhqm = new zzdxh().getKeyType();
    public static final String zzhqn = new zzdxo().getKeyType();
    private static final String zzhqo = new zzdxn().getKeyType();
    private static final String zzhqp = new zzdxu().getKeyType();
    private static final String zzhqq = new zzdxy().getKeyType();
    private static final String zzhqr = new zzdxt().getKeyType();
    private static final String zzhqs = new zzdyd().getKeyType();
    @Deprecated
    private static final zzeca zzhqt;
    @Deprecated
    private static final zzeca zzhqu;
    @Deprecated
    private static final zzeca zzhqv;

    public static void zzaxz() throws GeneralSecurityException {
        zzdza.zzaxz();
        zzdwy.zza((zzdwj) new zzdxh(), true);
        zzdwy.zza((zzdwj) new zzdxn(), true);
        zzdwy.zza((zzdwj) new zzdxo(), true);
        zzdwy.zza((zzdwj) new zzdxt(), true);
        zzdwy.zza((zzdwj) new zzdxu(), true);
        zzdwy.zza((zzdwj) new zzdxy(), true);
        zzdwy.zza((zzdwj) new zzdyd(), true);
        zzdwy.zza(new zzdxd());
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
