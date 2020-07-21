package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdgx implements zzela<zzdgr> {
    private final zzelj<zzbif> zzera;
    private final zzelj<Executor> zzfnr;
    private final zzelj<Context> zzgwh;
    private final zzelj<zzdil<zzbmq, zzbmw>> zzgwi;
    private final zzelj<zzdhi> zzgwj;
    private final zzelj<zzdlc> zzgwk;

    public zzdgx(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<zzbif> zzelj3, zzelj<zzdil<zzbmq, zzbmw>> zzelj4, zzelj<zzdhi> zzelj5, zzelj<zzdlc> zzelj6) {
        this.zzgwh = zzelj;
        this.zzfnr = zzelj2;
        this.zzera = zzelj3;
        this.zzgwi = zzelj4;
        this.zzgwj = zzelj5;
        this.zzgwk = zzelj6;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdgr(this.zzgwh.get(), this.zzfnr.get(), this.zzera.get(), this.zzgwi.get(), this.zzgwj.get(), this.zzgwk.get());
    }
}
