package com.google.android.gms.internal.ads;

import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RunnableFuture;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdtx extends AbstractExecutorService implements zzdvi {
    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Runnable runnable, T t) {
        return zzdvt.zza(runnable, (Object) t);
    }

    /* access modifiers changed from: protected */
    @Override // java.util.concurrent.AbstractExecutorService
    public final <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return zzdvt.zzf(callable);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    /* renamed from: zzf */
    public final zzdvf<?> submit(Runnable runnable) {
        return (zzdvf) super.submit(runnable);
    }

    @Override // com.google.android.gms.internal.ads.zzdvi
    /* renamed from: zze */
    public final <T> zzdvf<T> submit(Callable<T> callable) {
        return (zzdvf) super.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    public /* synthetic */ Future submit(Runnable runnable, @NullableDecl Object obj) {
        return (zzdvf) super.submit(runnable, obj);
    }
}
