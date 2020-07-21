package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsk implements zzela<zzcsf> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzchw> zzfzg;
    private final zzelj<zzcae> zzgkp;

    public zzcsk(zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzdla> zzelj3, zzelj<Executor> zzelj4, zzelj<zzcae> zzelj5, zzelj<zzchw> zzelj6) {
        this.zzere = zzelj;
        this.zzfmh = zzelj2;
        this.zzfnz = zzelj3;
        this.zzfnr = zzelj4;
        this.zzgkp = zzelj5;
        this.zzfzg = zzelj6;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcsf(this.zzere.get(), this.zzfmh.get(), this.zzfnz.get(), this.zzfnr.get(), this.zzgkp.get(), this.zzfzg.get());
    }
}
