package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzo implements zzela<zzbyg<zzbua>> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<zzdkk> zzfmg;
    private final zzelj<zzdla> zzfnz;
    private final zzbzk zzftx;

    private zzbzo(zzbzk zzbzk, zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzdkk> zzelj3, zzelj<zzdla> zzelj4) {
        this.zzftx = zzbzk;
        this.zzere = zzelj;
        this.zzfjy = zzelj2;
        this.zzfmg = zzelj3;
        this.zzfnz = zzelj4;
    }

    public static zzbzo zza(zzbzk zzbzk, zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzdkk> zzelj3, zzelj<zzdla> zzelj4) {
        return new zzbzo(zzbzk, zzelj, zzelj2, zzelj3, zzelj4);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(new zzbzn(this.zzere.get(), this.zzfjy.get(), this.zzfmg.get(), this.zzfnz.get()), zzbbf.zzedm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
