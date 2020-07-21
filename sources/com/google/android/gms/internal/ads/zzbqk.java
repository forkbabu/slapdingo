package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqk implements zzbsl, zzbtd, zzbua, zzbva, zzuu {
    private final Clock zzbqd;
    private final zzaxg zzfqj;

    public zzbqk(Clock clock, zzaxg zzaxg) {
        this.zzbqd = clock;
        this.zzfqj = zzaxg;
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdLeftApplication() {
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdOpened() {
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

    @Override // com.google.android.gms.internal.ads.zzbva
    public final void zzd(zzasm zzasm) {
    }

    @Override // com.google.android.gms.internal.ads.zzuu
    public final void onAdClicked() {
        this.zzfqj.zzvv();
    }

    @Override // com.google.android.gms.internal.ads.zzbua
    public final void onAdLoaded() {
        this.zzfqj.zzan(true);
    }

    @Override // com.google.android.gms.internal.ads.zzbtd
    public final void onAdImpression() {
        this.zzfqj.zzvu();
    }

    public final void zzf(zzve zzve) {
        this.zzfqj.zze(zzve);
    }

    @Override // com.google.android.gms.internal.ads.zzbva
    public final void zzb(zzdkw zzdkw) {
        this.zzfqj.zzey(this.zzbqd.elapsedRealtime());
    }

    @Override // com.google.android.gms.internal.ads.zzbsl
    public final void onAdClosed() {
        this.zzfqj.zzvw();
    }

    public final String zzvx() {
        return this.zzfqj.zzvx();
    }
}
