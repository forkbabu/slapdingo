package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcxf implements Runnable {
    private final zzcxc zzgpx;

    zzcxf(zzcxc zzcxc) {
        this.zzgpx = zzcxc;
    }

    public final void run() {
        this.zzgpx.zzgpt.zzgpa.onAdLoaded();
    }
}
