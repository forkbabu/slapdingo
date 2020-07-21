package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdvc;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdux extends zzdva {
    /* JADX DEBUG: Type inference failed for r1v1. Raw type applied. Possible types: com.google.android.gms.internal.ads.zzdvf<?>, com.google.android.gms.internal.ads.zzdvf<V> */
    public static <V> zzdvf<V> zzaf(@NullableDecl V v) {
        if (v == null) {
            return zzdvc.zzhop;
        }
        return new zzdvc(v);
    }

    public static <V> zzdvf<V> immediateFailedFuture(Throwable th) {
        zzdsh.checkNotNull(th);
        return new zzdvc.zza(th);
    }

    public static <O> zzdvf<O> zza(zzduf<O> zzduf, Executor executor) {
        zzdvt zzdvt = new zzdvt(zzduf);
        executor.execute(zzdvt);
        return zzdvt;
    }

    public static <V, X extends Throwable> zzdvf<V> zzb(zzdvf<? extends V> zzdvf, Class<X> cls, zzduh<? super X, ? extends V> zzduh, Executor executor) {
        return zzdtt.zza(zzdvf, cls, zzduh, executor);
    }

    public static <V> zzdvf<V> zza(zzdvf<V> zzdvf, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        if (zzdvf.isDone()) {
            return zzdvf;
        }
        return zzdvp.zzb(zzdvf, j, timeUnit, scheduledExecutorService);
    }

    public static <I, O> zzdvf<O> zzb(zzdvf<I> zzdvf, zzduh<? super I, ? extends O> zzduh, Executor executor) {
        return zzdtw.zza(zzdvf, zzduh, executor);
    }

    public static <I, O> zzdvf<O> zzb(zzdvf<I> zzdvf, zzdrx<? super I, ? extends O> zzdrx, Executor executor) {
        return zzdtw.zza(zzdvf, zzdrx, executor);
    }

    public static <V> zzdvf<List<V>> zzi(Iterable<? extends zzdvf<? extends V>> iterable) {
        return new zzduj(zzdss.zzh(iterable), true);
    }

    @SafeVarargs
    public static <V> zzduy<V> zza(zzdvf<? extends V>... zzdvfArr) {
        return new zzduy<>(false, zzdss.zzb(zzdvfArr), null);
    }

    public static <V> zzduy<V> zzj(Iterable<? extends zzdvf<? extends V>> iterable) {
        return new zzduy<>(false, zzdss.zzh(iterable), null);
    }

    @SafeVarargs
    public static <V> zzduy<V> zzb(zzdvf<? extends V>... zzdvfArr) {
        return new zzduy<>(true, zzdss.zzb(zzdvfArr), null);
    }

    public static <V> zzduy<V> zzk(Iterable<? extends zzdvf<? extends V>> iterable) {
        return new zzduy<>(true, zzdss.zzh(iterable), null);
    }

    public static <V> void zza(zzdvf<V> zzdvf, zzduu<? super V> zzduu, Executor executor) {
        zzdsh.checkNotNull(zzduu);
        zzdvf.addListener(new zzduz(zzdvf, zzduu), executor);
    }

    public static <V> V zza(Future<V> future) throws ExecutionException {
        if (future.isDone()) {
            return zzdvx.getUninterruptibly(future);
        }
        throw new IllegalStateException(zzdsi.zzb("Future was expected to be done: %s", future));
    }

    public static <V> V zzb(Future<V> future) {
        zzdsh.checkNotNull(future);
        try {
            return zzdvx.getUninterruptibly(future);
        } catch (ExecutionException e) {
            Throwable cause = e.getCause();
            if (cause instanceof Error) {
                throw new zzdup((Error) cause);
            }
            throw new zzdvy(cause);
        }
    }
}
