package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbok implements Runnable {
    private final Runnable zzfjx;
    private final zzboi zzfoi;

    zzbok(zzboi zzboi, Runnable runnable) {
        this.zzfoi = zzboi;
        this.zzfjx = runnable;
    }

    public final void run() {
        this.zzfoi.zze(this.zzfjx);
    }
}
