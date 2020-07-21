package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbbn<T> implements zzdvf<T> {
    private final zzdvq<T> zzedr = zzdvq.zzaxg();

    public final boolean set(T t) {
        return zzas(this.zzedr.set(t));
    }

    public final boolean setException(Throwable th) {
        return zzas(this.zzedr.setException(th));
    }

    private static boolean zzas(boolean z) {
        if (!z) {
            zzq.zzla().zzb(new IllegalStateException("Provided SettableFuture with multiple values."), "SettableFuture");
        }
        return z;
    }

    @Override // com.google.android.gms.internal.ads.zzdvf
    public void addListener(Runnable runnable, Executor executor) {
        this.zzedr.addListener(runnable, executor);
    }

    public boolean cancel(boolean z) {
        return this.zzedr.cancel(z);
    }

    public boolean isCancelled() {
        return this.zzedr.isCancelled();
    }

    public boolean isDone() {
        return this.zzedr.isDone();
    }

    @Override // java.util.concurrent.Future
    public T get() throws ExecutionException, InterruptedException {
        return this.zzedr.get();
    }

    @Override // java.util.concurrent.Future
    public T get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return this.zzedr.get(j, timeUnit);
    }
}
