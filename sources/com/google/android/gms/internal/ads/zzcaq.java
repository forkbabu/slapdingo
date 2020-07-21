package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcaq implements zzbsl {
    private final zzbtc zzfud;
    private final zzdkk zzfue;

    public zzcaq(zzbtc zzbtc, zzdkk zzdkk) {
        this.zzfud = zzbtc;
        this.zzfue = zzdkk;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdClosed() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoCompleted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onRewardedVideoStarted() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void zzb(zzatg zzatg, String str, String str2) {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdOpened() {
        if (this.zzfue.zzhac == 0 || this.zzfue.zzhac == 1) {
            this.zzfud.onAdImpression();
        }
    }
}
