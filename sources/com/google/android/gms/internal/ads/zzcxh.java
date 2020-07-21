package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcxh implements Runnable {
    private final zzuy zzgpo;
    private final zzcxc zzgpx;

    zzcxh(zzcxc zzcxc, zzuy zzuy) {
        this.zzgpx = zzcxc;
        this.zzgpo = zzuy;
    }

    public final void run() {
        this.zzgpx.zzgpt.zzgpa.onAdFailedToLoad(this.zzgpo.errorCode);
    }
}
