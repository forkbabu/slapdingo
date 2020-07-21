package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrl implements zzela<zzcrc> {
    private final zzelj<Context> zzere;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzchw> zzfzg;
    private final zzelj<zzbny> zzgkp;
    private final zzelj<zzdrx<zzdkk, zzayv>> zzgks;

    public zzcrl(zzelj<zzbny> zzelj, zzelj<Context> zzelj2, zzelj<Executor> zzelj3, zzelj<zzchw> zzelj4, zzelj<zzdla> zzelj5, zzelj<zzdrx<zzdkk, zzayv>> zzelj6) {
        this.zzgkp = zzelj;
        this.zzere = zzelj2;
        this.zzfnr = zzelj3;
        this.zzfzg = zzelj4;
        this.zzfnz = zzelj5;
        this.zzgks = zzelj6;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcrc(this.zzgkp.get(), this.zzere.get(), this.zzfnr.get(), this.zzfzg.get(), this.zzfnz.get(), this.zzgks.get());
    }
}
