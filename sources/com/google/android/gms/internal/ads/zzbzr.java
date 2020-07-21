package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzr implements zzela<Set<zzbyg<zzbsl>>> {
    private final zzelj<zzcaq> zzfmy;
    private final zzbzk zzftx;

    private zzbzr(zzbzk zzbzk, zzelj<zzcaq> zzelj) {
        this.zzftx = zzbzk;
        this.zzfmy = zzelj;
    }

    public static zzbzr zza(zzbzk zzbzk, zzelj<zzcaq> zzelj) {
        return new zzbzr(zzbzk, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftx.zza(this.zzfmy.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
