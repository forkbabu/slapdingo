package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbol implements Runnable {
    private final AtomicReference zzfoj;

    zzbol(AtomicReference atomicReference) {
        this.zzfoj = atomicReference;
    }

    public final void run() {
        Runnable runnable = (Runnable) this.zzfoj.getAndSet(null);
        if (runnable != null) {
            runnable.run();
        }
    }
}
