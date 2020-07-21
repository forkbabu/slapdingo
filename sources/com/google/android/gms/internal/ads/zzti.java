package com.google.android.gms.internal.ads;

import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzti implements Runnable {
    private final zzbbn zzbvh;
    private final Future zzbvi;

    zzti(zzbbn zzbbn, Future future) {
        this.zzbvh = zzbbn;
        this.zzbvi = future;
    }

    public final void run() {
        zzbbn zzbbn = this.zzbvh;
        Future future = this.zzbvi;
        if (zzbbn.isCancelled()) {
            future.cancel(true);
        }
    }
}
