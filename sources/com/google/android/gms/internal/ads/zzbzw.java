package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzw implements zzela<zzbyg<zzbsl>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzcau> zzfmy;
    private final zzbzk zzftx;

    private zzbzw(zzbzk zzbzk, zzelj<zzcau> zzelj, zzelj<Executor> zzelj2) {
        this.zzftx = zzbzk;
        this.zzfmy = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzbzw zzb(zzbzk zzbzk, zzelj<zzcau> zzelj, zzelj<Executor> zzelj2) {
        return new zzbzw(zzbzk, zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
