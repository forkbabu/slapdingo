package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbri implements zzela<zzbrj> {
    private final zzelj<zzclx> zzesa;
    private final zzelj<zzaxx> zzexy;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<Context> zzfqq;

    private zzbri(zzelj<Context> zzelj, zzelj<zzdla> zzelj2, zzelj<zzbbd> zzelj3, zzelj<zzaxx> zzelj4, zzelj<zzclx> zzelj5) {
        this.zzfqq = zzelj;
        this.zzfnz = zzelj2;
        this.zzfmh = zzelj3;
        this.zzexy = zzelj4;
        this.zzesa = zzelj5;
    }

    public static zzbri zzb(zzelj<Context> zzelj, zzelj<zzdla> zzelj2, zzelj<zzbbd> zzelj3, zzelj<zzaxx> zzelj4, zzelj<zzclx> zzelj5) {
        return new zzbri(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbrj(this.zzfqq.get(), this.zzfnz.get(), this.zzfmh.get(), this.zzexy.get(), this.zzesa.get());
    }
}
