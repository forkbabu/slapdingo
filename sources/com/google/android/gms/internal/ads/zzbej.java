package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbej implements zzbfa {
    @Override // com.google.android.gms.internal.ads.zzbfa
    public final zzbes zza(zzbdb zzbdb, int i, String str, zzbdc zzbdc) {
        if (i <= 0) {
            return new zzbez(zzbdb);
        }
        int zzaan = zzbdy.zzaan();
        if (zzaan < zzbdc.zzeho) {
            return new zzbfd(zzbdb, zzbdc);
        }
        if (zzaan < zzbdc.zzehi) {
            return new zzbfe(zzbdb, zzbdc);
        }
        return new zzbfc(zzbdb);
    }
}
