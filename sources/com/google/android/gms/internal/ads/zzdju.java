package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdju implements Runnable {
    private final zzdjr zzgyw;

    zzdju(zzdjr zzdjr) {
        this.zzgyw = zzdjr;
    }

    public final void run() {
        this.zzgyw.zzgyv.zzgys.onAdLoaded();
    }
}
