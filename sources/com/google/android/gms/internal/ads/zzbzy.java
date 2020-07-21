package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzy implements zzela<zzbyg<zzbwd>> {
    private final zzelj<Executor> zzerc;
    private final zzbzk zzftx;

    private zzbzy(zzbzk zzbzk, zzelj<Executor> zzelj) {
        this.zzftx = zzbzk;
        this.zzerc = zzelj;
    }

    public static zzbzy zzd(zzbzk zzbzk, zzelj<Executor> zzelj) {
        return new zzbzy(zzbzk, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(this.zzftx.zzb(this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
