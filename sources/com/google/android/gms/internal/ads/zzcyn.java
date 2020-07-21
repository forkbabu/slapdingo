package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcyn implements zzela<zzcxz> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzeg> zzfkz;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<zzdll<zzcgr>> zzgma;
    private final zzelj<zzbif> zzgra;

    public zzcyn(zzelj<zzbif> zzelj, zzelj<Context> zzelj2, zzelj<zzeg> zzelj3, zzelj<zzbbd> zzelj4, zzelj<zzdll<zzcgr>> zzelj5, zzelj<zzdvi> zzelj6, zzelj<ScheduledExecutorService> zzelj7) {
        this.zzgra = zzelj;
        this.zzere = zzelj2;
        this.zzfkz = zzelj3;
        this.zzfmh = zzelj4;
        this.zzgma = zzelj5;
        this.zzerc = zzelj6;
        this.zzfkv = zzelj7;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcxz(this.zzgra.get(), this.zzere.get(), this.zzfkz.get(), this.zzfmh.get(), this.zzgma.get(), this.zzerc.get(), this.zzfkv.get());
    }
}
