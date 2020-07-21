package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzduo<V> extends zzdvb<V> {
    zzduo() {
    }

    public static <V> zzduo<V> zzg(zzdvf<V> zzdvf) {
        if (zzdvf instanceof zzduo) {
            return (zzduo) zzdvf;
        }
        return new zzduq(zzdvf);
    }

    public final <X extends Throwable> zzduo<V> zza(Class<X> cls, zzdrx<? super X, ? extends V> zzdrx, Executor executor) {
        zzdtv zzdtv = new zzdtv(this, cls, zzdrx);
        addListener(zzdtv, zzdvh.zza(executor, zzdtv));
        return zzdtv;
    }

    public final <X extends Throwable> zzduo<V> zza(Class<X> cls, zzduh<? super X, ? extends V> zzduh, Executor executor) {
        zzdts zzdts = new zzdts(this, cls, zzduh);
        addListener(zzdts, zzdvh.zza(executor, zzdts));
        return zzdts;
    }

    public final zzduo<V> zza(long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        return (zzduo) zzdux.zza(this, j, timeUnit, scheduledExecutorService);
    }

    public final <T> zzduo<T> zzb(zzduh<? super V, T> zzduh, Executor executor) {
        zzdsh.checkNotNull(executor);
        zzdtz zzdtz = new zzdtz(this, zzduh);
        addListener(zzdtz, zzdvh.zza(executor, zzdtz));
        return zzdtz;
    }

    public final <T> zzduo<T> zza(zzdrx<? super V, T> zzdrx, Executor executor) {
        zzdsh.checkNotNull(zzdrx);
        zzdty zzdty = new zzdty(this, zzdrx);
        addListener(zzdty, zzdvh.zza(executor, zzdty));
        return zzdty;
    }
}
