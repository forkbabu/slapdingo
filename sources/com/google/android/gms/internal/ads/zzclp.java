package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzclp implements zzela<Set<zzbyg<zzbua>>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzclv> zzgdq;
    private final zzcll zzgfd;

    private zzclp(zzcll zzcll, zzelj<zzclv> zzelj, zzelj<Executor> zzelj2) {
        this.zzgfd = zzcll;
        this.zzgdq = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzclp zzd(zzcll zzcll, zzelj<zzclv> zzelj, zzelj<Executor> zzelj2) {
        return new zzclp(zzcll, zzelj, zzelj2);
    }

    public static Set<zzbyg<zzbua>> zzb(zzcll zzcll, zzclv zzclv, Executor executor) {
        return (Set) zzelg.zza(zzcll.zzc(zzclv, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzb(this.zzgfd, this.zzgdq.get(), this.zzerc.get());
    }
}
