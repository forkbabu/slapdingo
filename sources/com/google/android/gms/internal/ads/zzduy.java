package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzduy<V> {
    private final boolean zzhnu;
    private final zzdss<zzdvf<? extends V>> zzhom;

    private zzduy(boolean z, zzdss<zzdvf<? extends V>> zzdss) {
        this.zzhnu = z;
        this.zzhom = zzdss;
    }

    public final <C> zzdvf<C> zza(Callable<C> callable, Executor executor) {
        return new zzdul(this.zzhom, this.zzhnu, executor, callable);
    }

    /* synthetic */ zzduy(boolean z, zzdss zzdss, zzduw zzduw) {
        this(z, zzdss);
    }
}
