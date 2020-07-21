package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvc extends zzcuj {
    private final zzbwg zzgnk;

    public zzcvc(zzbsk zzbsk, zzbtc zzbtc, zzbtl zzbtl, zzbtv zzbtv, zzbss zzbss, zzbwj zzbwj, zzbyz zzbyz, zzbui zzbui, zzbyq zzbyq, zzbwg zzbwg) {
        super(zzbsk, zzbtc, zzbtl, zzbtv, zzbss, zzbwj, zzbyz, zzbui, zzbyq, zzbwg);
        this.zzgnk = zzbwg;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl, com.google.android.gms.internal.ads.zzamx
    public final void onAdImpression() {
        this.zzgnk.zzaji();
    }
}
