package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrm implements zzela<zzcrk> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzbny> zzgkp;

    public zzcrm(zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzbny> zzelj3, zzelj<Executor> zzelj4) {
        this.zzere = zzelj;
        this.zzfmh = zzelj2;
        this.zzgkp = zzelj3;
        this.zzfnr = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcrk(this.zzere.get(), this.zzfmh.get(), this.zzgkp.get(), this.zzfnr.get());
    }
}
