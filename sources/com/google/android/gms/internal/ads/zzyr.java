package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzyr extends zzwf {
    private final /* synthetic */ zzys zzcji;

    zzyr(zzys zzys) {
        this.zzcji = zzys;
    }

    @Override // com.google.android.gms.internal.ads.zzwf, com.google.android.gms.ads.AdListener
    public final void onAdLoaded() {
        this.zzcji.zzcjk.zza(this.zzcji.zzdu());
        super.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzwf, com.google.android.gms.ads.AdListener
    public final void onAdFailedToLoad(int i) {
        this.zzcji.zzcjk.zza(this.zzcji.zzdu());
        super.onAdFailedToLoad(i);
    }
}
