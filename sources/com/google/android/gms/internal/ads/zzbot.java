package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbot implements zzela<zzboq> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<zzbfn> zzfno;
    private final zzelj<zzdkk> zzfos;

    public zzbot(zzelj<Context> zzelj, zzelj<zzbfn> zzelj2, zzelj<zzdkk> zzelj3, zzelj<zzbbd> zzelj4) {
        this.zzere = zzelj;
        this.zzfno = zzelj2;
        this.zzfos = zzelj3;
        this.zzfjy = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzboq(this.zzere.get(), this.zzfno.get(), this.zzfos.get(), this.zzfjy.get());
    }
}
