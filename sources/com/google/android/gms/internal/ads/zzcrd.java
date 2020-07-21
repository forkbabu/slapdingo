package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrd implements zzela<zzcqz> {
    private final zzelj<Context> zzere;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzchw> zzfzg;
    private final zzelj<zzbmq> zzgkp;

    public zzcrd(zzelj<zzbmq> zzelj, zzelj<Context> zzelj2, zzelj<Executor> zzelj3, zzelj<zzchw> zzelj4, zzelj<zzdla> zzelj5) {
        this.zzgkp = zzelj;
        this.zzere = zzelj2;
        this.zzfnr = zzelj3;
        this.zzfzg = zzelj4;
        this.zzfnz = zzelj5;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcqz(this.zzgkp.get(), this.zzere.get(), this.zzfnr.get(), this.zzfzg.get(), this.zzfnz.get());
    }
}
