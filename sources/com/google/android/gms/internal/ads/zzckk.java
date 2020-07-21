package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzckk implements zzela<zzckl> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdli> zzesx;
    private final zzelj<zzckx> zzesy;
    private final zzelj<zzdkk> zzfkx;
    private final zzelj<zzdkw> zzgec;

    private zzckk(zzelj<Context> zzelj, zzelj<zzdli> zzelj2, zzelj<zzckx> zzelj3, zzelj<zzdkw> zzelj4, zzelj<zzdkk> zzelj5) {
        this.zzere = zzelj;
        this.zzesx = zzelj2;
        this.zzesy = zzelj3;
        this.zzgec = zzelj4;
        this.zzfkx = zzelj5;
    }

    public static zzckk zzf(zzelj<Context> zzelj, zzelj<zzdli> zzelj2, zzelj<zzckx> zzelj3, zzelj<zzdkw> zzelj4, zzelj<zzdkk> zzelj5) {
        return new zzckk(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzckl(this.zzere.get(), this.zzesx.get(), this.zzesy.get(), this.zzgec.get(), this.zzfkx.get());
    }
}
