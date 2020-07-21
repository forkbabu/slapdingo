package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzduq<V> extends zzduo<V> {
    private final zzdvf<V> zzhol;

    zzduq(zzdvf<V> zzdvf) {
        this.zzhol = (zzdvf) zzdsh.checkNotNull(zzdvf);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu, com.google.android.gms.internal.ads.zzdvf
    public final void addListener(Runnable runnable, Executor executor) {
        this.zzhol.addListener(runnable, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final boolean cancel(boolean z) {
        return this.zzhol.cancel(z);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final boolean isCancelled() {
        return this.zzhol.isCancelled();
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final boolean isDone() {
        return this.zzhol.isDone();
    }

    @Override // java.util.concurrent.Future, com.google.android.gms.internal.ads.zzdtu
    public final V get() throws InterruptedException, ExecutionException {
        return this.zzhol.get();
    }

    @Override // java.util.concurrent.Future, com.google.android.gms.internal.ads.zzdtu
    public final V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzhol.get(j, timeUnit);
    }

    @Override // com.google.android.gms.internal.ads.zzdtu
    public final String toString() {
        return this.zzhol.toString();
    }
}
