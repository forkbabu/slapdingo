package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdhd implements zzela<zzdha> {
    private final zzelj<zzbif> zzera;
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<String> zzgws;
    private final zzelj<zzdgr> zzgwt;
    private final zzelj<zzdhi> zzgwu;

    public zzdhd(zzelj<zzbif> zzelj, zzelj<Context> zzelj2, zzelj<String> zzelj3, zzelj<zzdgr> zzelj4, zzelj<zzdhi> zzelj5, zzelj<zzbbd> zzelj6) {
        this.zzera = zzelj;
        this.zzere = zzelj2;
        this.zzgws = zzelj3;
        this.zzgwt = zzelj4;
        this.zzgwu = zzelj5;
        this.zzfmh = zzelj6;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdha(this.zzera.get(), this.zzere.get(), this.zzgws.get(), this.zzgwt.get(), this.zzgwu.get(), this.zzfmh.get());
    }
}
