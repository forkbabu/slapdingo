package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqq implements zzela<zzbyg<zzbua>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzblk> zzfmy;

    private zzbqq(zzelj<zzblk> zzelj, zzelj<Executor> zzelj2) {
        this.zzfmy = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzbqq zzh(zzelj<zzblk> zzelj, zzelj<Executor> zzelj2) {
        return new zzbqq(zzelj, zzelj2);
    }

    public static zzbyg<zzbua> zza(zzblk zzblk, Executor executor) {
        return (zzbyg) zzelg.zza(new zzbyg(zzblk, executor), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfmy.get(), this.zzerc.get());
    }
}
