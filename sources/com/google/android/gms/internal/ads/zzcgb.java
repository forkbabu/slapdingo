package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcgb implements zzela<zzcfu> {
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzbmh> zzfzh;
    private final zzelj<zzbyj> zzgbh;

    public zzcgb(zzelj<Executor> zzelj, zzelj<zzbmh> zzelj2, zzelj<zzbyj> zzelj3) {
        this.zzfnr = zzelj;
        this.zzfzh = zzelj2;
        this.zzgbh = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcfu(this.zzfnr.get(), this.zzfzh.get(), this.zzgbh.get());
    }
}
