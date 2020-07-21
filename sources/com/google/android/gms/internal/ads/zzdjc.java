package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdjc implements zzdie {
    private final zzuy zzfrr;

    zzdjc(zzuy zzuy) {
        this.zzfrr = zzuy;
    }

    @Override // com.google.android.gms.internal.ads.zzdie
    public final void zzq(Object obj) {
        ((zzauj) obj).onRewardedAdFailedToShow(this.zzfrr.errorCode);
    }
}
