package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdab implements zzela<zzdaa> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzaxh> zzgrt;

    private zzdab(zzelj<Executor> zzelj, zzelj<zzaxh> zzelj2) {
        this.zzerc = zzelj;
        this.zzgrt = zzelj2;
    }

    public static zzdab zzay(zzelj<Executor> zzelj, zzelj<zzaxh> zzelj2) {
        return new zzdab(zzelj, zzelj2);
    }

    public static zzdaa zza(Executor executor, zzaxh zzaxh) {
        return new zzdaa(executor, zzaxh);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzerc.get(), this.zzgrt.get());
    }
}
