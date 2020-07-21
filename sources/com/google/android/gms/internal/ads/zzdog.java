package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public abstract class zzdog<E> {
    /* access modifiers changed from: private */
    public static final zzdvf<?> zzhfm = zzdux.zzaf(null);
    /* access modifiers changed from: private */
    public final ScheduledExecutorService zzfmo;
    /* access modifiers changed from: private */
    public final zzdvi zzgad;
    /* access modifiers changed from: private */
    public final zzdos<E> zzhfn;

    public zzdog(zzdvi zzdvi, ScheduledExecutorService scheduledExecutorService, zzdos<E> zzdos) {
        this.zzgad = zzdvi;
        this.zzfmo = scheduledExecutorService;
        this.zzhfn = zzdos;
    }

    /* access modifiers changed from: protected */
    public abstract String zzv(E e);

    public final zzdok zzu(E e) {
        return new zzdok(this, e);
    }

    public final <I> zzdom<I> zza(E e, zzdvf<I> zzdvf) {
        return new zzdom<>(this, e, zzdvf, Collections.singletonList(zzdvf), zzdvf);
    }

    public final zzdoi zza(E e, zzdvf<?>... zzdvfArr) {
        return new zzdoi(this, e, Arrays.asList(zzdvfArr));
    }
}
