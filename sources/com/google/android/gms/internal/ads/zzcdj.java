package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcdj implements Runnable {
    private final zzcdg zzfyl;
    private final zzcee zzfyn;

    zzcdj(zzcdg zzcdg, zzcee zzcee) {
        this.zzfyl = zzcdg;
        this.zzfyn = zzcee;
    }

    public final void run() {
        this.zzfyl.zze(this.zzfyn);
    }
}
