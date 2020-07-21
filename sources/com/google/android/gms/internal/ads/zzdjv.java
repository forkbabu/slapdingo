package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdjv implements zzela<zzdjq> {
    private final zzelj<zzbif> zzera;
    private final zzelj<zzdkv> zzfim;
    private final zzelj<Executor> zzfnr;
    private final zzelj<Context> zzgwh;
    private final zzelj<zzdil<zzchm, zzchj>> zzgwi;
    private final zzelj<zzdiu> zzgwj;
    private final zzelj<zzdlc> zzgwk;

    public zzdjv(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<zzbif> zzelj3, zzelj<zzdil<zzchm, zzchj>> zzelj4, zzelj<zzdiu> zzelj5, zzelj<zzdlc> zzelj6, zzelj<zzdkv> zzelj7) {
        this.zzgwh = zzelj;
        this.zzfnr = zzelj2;
        this.zzera = zzelj3;
        this.zzgwi = zzelj4;
        this.zzgwj = zzelj5;
        this.zzgwk = zzelj6;
        this.zzfim = zzelj7;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdjq(this.zzgwh.get(), this.zzfnr.get(), this.zzera.get(), this.zzgwi.get(), this.zzgwj.get(), this.zzgwk.get(), this.zzfim.get());
    }
}
