package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbkl implements zzela<zzbkg> {
    private final zzelj<Context> zzere;
    private final zzelj<zzcix> zzerp;
    private final zzelj<zzclx> zzesa;
    private final zzelj<zzciz> zzesc;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<zzcqu<zzdlm, zzcsc>> zzfjz;
    private final zzelj<zzcwj> zzfka;
    private final zzelj<zzavy> zzfkb;

    public zzbkl(zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzcix> zzelj3, zzelj<zzcqu<zzdlm, zzcsc>> zzelj4, zzelj<zzcwj> zzelj5, zzelj<zzclx> zzelj6, zzelj<zzavy> zzelj7, zzelj<zzciz> zzelj8) {
        this.zzere = zzelj;
        this.zzfjy = zzelj2;
        this.zzerp = zzelj3;
        this.zzfjz = zzelj4;
        this.zzfka = zzelj5;
        this.zzesa = zzelj6;
        this.zzfkb = zzelj7;
        this.zzesc = zzelj8;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbkg(this.zzere.get(), this.zzfjy.get(), this.zzerp.get(), this.zzfjz.get(), this.zzfka.get(), this.zzesa.get(), this.zzfkb.get(), this.zzesc.get());
    }
}
