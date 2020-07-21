package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdns implements zzela<zzdvi> {
    public static zzdns zzaue() {
        return zzdnr.zzhfd;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        zzdvi zzdvi;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcum)).booleanValue()) {
            zzdvi = zzbbf.zzedj;
        } else {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcul)).booleanValue()) {
                zzdvi = zzbbf.zzedh;
            } else {
                zzdvi = zzbbf.zzedl;
            }
        }
        return (zzdvi) zzelg.zza(zzdvi, "Cannot return null from a non-@Nullable @Provides method");
    }
}
