package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdjt implements Runnable {
    private final zzuy zzgpo;
    private final zzdjr zzgyw;

    zzdjt(zzdjr zzdjr, zzuy zzuy) {
        this.zzgyw = zzdjr;
        this.zzgpo = zzuy;
    }

    public final void run() {
        this.zzgyw.zzgyv.zzgys.onAdFailedToLoad(this.zzgpo.errorCode);
    }
}
