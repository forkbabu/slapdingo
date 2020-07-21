package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdom<O> {
    private final E zzhfj;
    private final String zzhfk;
    private final List<zzdvf<?>> zzhfo;
    final /* synthetic */ zzdog zzhfp;
    private final zzdvf<?> zzhfs;
    private final zzdvf<O> zzhft;

    private zzdom(zzdog zzdog, E e, String str, zzdvf<?> zzdvf, List<zzdvf<?>> list, zzdvf<O> zzdvf2) {
        this.zzhfp = zzdog;
        this.zzhfj = e;
        this.zzhfk = str;
        this.zzhfs = zzdvf;
        this.zzhfo = list;
        this.zzhft = zzdvf2;
    }

    public final zzdom<O> zzgw(String str) {
        return new zzdom<>(this.zzhfp, this.zzhfj, str, this.zzhfs, this.zzhfo, this.zzhft);
    }

    public final <O2> zzdom<O2> zzb(zzdob<O, O2> zzdob) {
        return zza(new zzdol(zzdob));
    }

    public final <O2> zzdom<O2> zza(zzduh<O, O2> zzduh) {
        return zza(zzduh, this.zzhfp.zzgad);
    }

    private final <O2> zzdom<O2> zza(zzduh<O, O2> zzduh, Executor executor) {
        return new zzdom<>(this.zzhfp, this.zzhfj, this.zzhfk, this.zzhfs, this.zzhfo, zzdux.zzb(this.zzhft, zzduh, executor));
    }

    public final <O2> zzdom<O2> zze(zzdvf<O2> zzdvf) {
        return zza(new zzdoo(zzdvf), zzbbf.zzedm);
    }

    public final <T extends Throwable> zzdom<O> zza(Class<T> cls, zzdob<T, O> zzdob) {
        return zza(cls, new zzdon(zzdob));
    }

    public final <T extends Throwable> zzdom<O> zza(Class<T> cls, zzduh<T, O> zzduh) {
        zzdog zzdog = this.zzhfp;
        return new zzdom<>(zzdog, this.zzhfj, this.zzhfk, this.zzhfs, this.zzhfo, zzdux.zzb(this.zzhft, cls, zzduh, zzdog.zzgad));
    }

    public final zzdom<O> zza(long j, TimeUnit timeUnit) {
        zzdog zzdog = this.zzhfp;
        return new zzdom<>(zzdog, this.zzhfj, this.zzhfk, this.zzhfs, this.zzhfo, zzdux.zza(this.zzhft, j, timeUnit, zzdog.zzfmo));
    }

    public final zzdod<E, O> zzaus() {
        E e = this.zzhfj;
        String str = this.zzhfk;
        if (str == null) {
            str = this.zzhfp.zzv(e);
        }
        zzdod<E, O> zzdod = new zzdod<>(e, str, this.zzhft);
        this.zzhfp.zzhfn.zza(zzdod);
        this.zzhfs.addListener(new zzdoq(this, zzdod), zzbbf.zzedm);
        zzdux.zza(zzdod, new zzdop(this, zzdod), zzbbf.zzedm);
        return zzdod;
    }

    public final zzdom<O> zzw(E e) {
        return this.zzhfp.zza(e, zzaus());
    }
}
