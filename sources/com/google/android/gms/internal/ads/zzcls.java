package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcls implements zzela<Set<zzbyg<zzdpa>>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzclv> zzgdq;
    private final zzcll zzgfd;

    private zzcls(zzcll zzcll, zzelj<zzclv> zzelj, zzelj<Executor> zzelj2) {
        this.zzgfd = zzcll;
        this.zzgdq = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzcls zzg(zzcll zzcll, zzelj<zzclv> zzelj, zzelj<Executor> zzelj2) {
        return new zzcls(zzcll, zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(zzcll.zzh(this.zzgdq.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
