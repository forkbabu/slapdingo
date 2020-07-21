package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcsb implements zzduu<zzbnc> {
    private final /* synthetic */ zzcrw zzglf;

    zzcsb(zzcrw zzcrw) {
        this.zzglf = zzcrw;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        zzuy zze = zzcmi.zze(th);
        this.zzglf.zzftb.onAdFailedToLoad(zze.errorCode);
        zzdlj.zza(zze.errorCode, th, "DelayedBannerAd.onFailure");
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzbnc zzbnc) {
        zzbnc.zzahr();
    }
}
