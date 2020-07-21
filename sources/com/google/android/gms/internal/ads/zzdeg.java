package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdeg<T> implements zzela<zzdeb<T>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Set<zzdec<? extends zzddz<T>>>> zzgut;

    private zzdeg(zzelj<Executor> zzelj, zzelj<Set<zzdec<? extends zzddz<T>>>> zzelj2) {
        this.zzerc = zzelj;
        this.zzgut = zzelj2;
    }

    public static <T> zzdeg<T> zzbh(zzelj<Executor> zzelj, zzelj<Set<zzdec<? extends zzddz<T>>>> zzelj2) {
        return new zzdeg<>(zzelj, zzelj2);
    }

    public static <T> zzdeb<T> zza(Executor executor, Set<zzdec<? extends zzddz<T>>> set) {
        return new zzdeb<>(executor, set);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzerc.get(), this.zzgut.get());
    }
}
