package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcwr implements zzela<zzcwo> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzwj> zzgoy;
    private final zzelj<zzbnc> zzgoz;

    public zzcwr(zzelj<Context> zzelj, zzelj<zzwj> zzelj2, zzelj<zzdla> zzelj3, zzelj<zzbnc> zzelj4) {
        this.zzere = zzelj;
        this.zzgoy = zzelj2;
        this.zzfnz = zzelj3;
        this.zzgoz = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcwo(this.zzere.get(), this.zzgoy.get(), this.zzfnz.get(), this.zzgoz.get());
    }
}
