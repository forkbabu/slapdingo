package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnr implements zzela<zzbyg<zzbua>> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<zzdkk> zzfmg;
    private final zzbnj zzfnw;
    private final zzelj<zzdla> zzfnz;

    public zzbnr(zzbnj zzbnj, zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzdkk> zzelj3, zzelj<zzdla> zzelj4) {
        this.zzfnw = zzbnj;
        this.zzere = zzelj;
        this.zzfjy = zzelj2;
        this.zzfmg = zzelj3;
        this.zzfnz = zzelj4;
    }

    public static zzbyg<zzbua> zza(zzbnj zzbnj, Context context, zzbbd zzbbd, zzdkk zzdkk, zzdla zzdla) {
        return (zzbyg) zzelg.zza(new zzbyg(new zzbni(context, zzbbd, zzdkk, zzdla), zzbbf.zzedm), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfnw, this.zzere.get(), this.zzfjy.get(), this.zzfmg.get(), this.zzfnz.get());
    }
}
