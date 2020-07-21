package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbeq implements Runnable {
    private final /* synthetic */ zzben zzeke;

    zzbeq(zzben zzben) {
        this.zzeke = zzben;
    }

    public final void run() {
        zzq.zzls().zzb(this.zzeke);
    }
}
