package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdjz implements zzela<zzdjy> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdkv> zzfim;
    private final zzelj<String> zzgws;
    private final zzelj<zzdjq> zzgwt;
    private final zzelj<zzdiu> zzgwu;

    public zzdjz(zzelj<String> zzelj, zzelj<zzdjq> zzelj2, zzelj<Context> zzelj3, zzelj<zzdiu> zzelj4, zzelj<zzdkv> zzelj5) {
        this.zzgws = zzelj;
        this.zzgwt = zzelj2;
        this.zzere = zzelj3;
        this.zzgwu = zzelj4;
        this.zzfim = zzelj5;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdjy(this.zzgws.get(), this.zzgwt.get(), this.zzere.get(), this.zzgwu.get(), this.zzfim.get());
    }
}
