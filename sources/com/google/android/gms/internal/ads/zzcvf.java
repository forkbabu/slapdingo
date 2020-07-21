package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvf extends zzcvl {
    private final zzbwg zzgnk;

    public zzcvf(zzbsk zzbsk, zzbtc zzbtc, zzbtl zzbtl, zzbtv zzbtv, zzbwj zzbwj, zzbui zzbui, zzbyz zzbyz, zzbwg zzbwg, zzbss zzbss) {
        super(zzbsk, zzbtc, zzbtl, zzbtv, zzbwj, zzbui, zzbyz, zzbwg, zzbss);
        this.zzgnk = zzbwg;
    }

    @Override // com.google.android.gms.internal.ads.zzcvl, com.google.android.gms.internal.ads.zzamx
    public final void onAdImpression() {
        this.zzgnk.zzaji();
    }
}
