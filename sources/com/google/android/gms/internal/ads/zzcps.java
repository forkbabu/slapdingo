package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcps implements zzela<zzbyg<zzbsq>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzcqd> zzfmj;

    private zzcps(zzelj<zzcqd> zzelj, zzelj<Executor> zzelj2) {
        this.zzfmj = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzcps zzas(zzelj<zzcqd> zzelj, zzelj<Executor> zzelj2) {
        return new zzcps(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmj.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
