package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdut<V> extends zzdsp implements Future<V> {
    protected zzdut() {
    }

    /* access modifiers changed from: protected */
    /* renamed from: zzaxe */
    public abstract Future<? extends V> zzawf();

    public boolean cancel(boolean z) {
        return zzawf().cancel(z);
    }

    public boolean isCancelled() {
        return zzawf().isCancelled();
    }

    public boolean isDone() {
        return zzawf().isDone();
    }

    @Override // java.util.concurrent.Future
    public V get() throws InterruptedException, ExecutionException {
        return zzawf().get();
    }

    @Override // java.util.concurrent.Future
    public V get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return zzawf().get(j, timeUnit);
    }
}
