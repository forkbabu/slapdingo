package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbmr {
    private final zzdkw zzetl;
    private final zzckx zzfmz;

    public zzbmr(zzckx zzckx, zzdkw zzdkw) {
        this.zzfmz = zzckx;
        this.zzetl = zzdkw;
    }

    public final void zzfd(long j) {
        this.zzfmz.zzaok().zza(this.zzetl.zzhau.zzhar).zzq("action", "ad_closed").zzq("show_time", String.valueOf(j)).zzq("ad_format", "appopen").zzaoi();
    }
}
