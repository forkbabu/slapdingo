package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdok {
    private final E zzhfj;
    private final /* synthetic */ zzdog zzhfp;

    private zzdok(zzdog zzdog, E e) {
        this.zzhfp = zzdog;
        this.zzhfj = e;
    }

    public final <O> zzdom<O> zze(zzdvf<O> zzdvf) {
        return new zzdom<>(this.zzhfp, this.zzhfj, zzdog.zzhfm, Collections.emptyList(), zzdvf);
    }

    public final <O> zzdom<O> zzc(Callable<O> callable) {
        return zza(callable, this.zzhfp.zzgad);
    }

    private final <O> zzdom<O> zza(Callable<O> callable, zzdvi zzdvi) {
        return new zzdom<>(this.zzhfp, this.zzhfj, zzdog.zzhfm, Collections.emptyList(), zzdvi.zze(callable));
    }

    public final zzdom<?> zza(zzdoe zzdoe, zzdvi zzdvi) {
        return zza(new zzdoj(zzdoe), zzdvi);
    }
}
