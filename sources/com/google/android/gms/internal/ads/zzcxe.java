package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcxe implements Runnable {
    private final zzcxc zzgpx;

    zzcxe(zzcxc zzcxc) {
        this.zzgpx = zzcxc;
    }

    public final void run() {
        this.zzgpx.zzgpt.zzgpu.onAdLoaded();
    }
}
