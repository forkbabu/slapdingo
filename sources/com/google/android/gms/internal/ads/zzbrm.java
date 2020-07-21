package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrm implements zzela<zzdrx<zzdkk, zzayv>> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<zzdla> zzfnz;

    public zzbrm(zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzdla> zzelj3) {
        this.zzere = zzelj;
        this.zzfjy = zzelj2;
        this.zzfnz = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzdrx) zzelg.zza(new zzbrn(this.zzere.get(), this.zzfjy.get(), this.zzfnz.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
