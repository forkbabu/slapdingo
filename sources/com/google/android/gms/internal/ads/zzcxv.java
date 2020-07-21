package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcxv implements Runnable {
    private final zzcxs zzgql;

    zzcxv(zzcxs zzcxs) {
        this.zzgql = zzcxs;
    }

    public final void run() {
        this.zzgql.zzgqk.zzgqg.zzaqc().onAdLoaded();
    }
}
