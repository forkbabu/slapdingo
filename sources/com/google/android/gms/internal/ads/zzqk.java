package com.google.android.gms.internal.ads;

import android.view.Surface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqk implements Runnable {
    private final /* synthetic */ zzqe zzbmr;
    private final /* synthetic */ Surface zzbmu;

    zzqk(zzqe zzqe, Surface surface) {
        this.zzbmr = zzqe;
        this.zzbmu = surface;
    }

    public final void run() {
        this.zzbmr.zzbmq.zzb(this.zzbmu);
    }
}
