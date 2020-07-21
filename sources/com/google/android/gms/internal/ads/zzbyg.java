package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbyg<T> {
    public Executor executor;
    public T zzfti;

    public static <T> zzbyg<T> zzb(T t, Executor executor2) {
        return new zzbyg<>(t, executor2);
    }

    public zzbyg(T t, Executor executor2) {
        this.zzfti = t;
        this.executor = executor2;
    }
}
