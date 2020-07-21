package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
class zzdvm extends zzdtx {
    private final ExecutorService zzhoz;

    zzdvm(ExecutorService executorService) {
        this.zzhoz = (ExecutorService) zzdsh.checkNotNull(executorService);
    }

    @Override // java.util.concurrent.ExecutorService
    public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.zzhoz.awaitTermination(j, timeUnit);
    }

    public final boolean isShutdown() {
        return this.zzhoz.isShutdown();
    }

    public final boolean isTerminated() {
        return this.zzhoz.isTerminated();
    }

    public final void shutdown() {
        this.zzhoz.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public final List<Runnable> shutdownNow() {
        return this.zzhoz.shutdownNow();
    }

    public final void execute(Runnable runnable) {
        this.zzhoz.execute(runnable);
    }
}
