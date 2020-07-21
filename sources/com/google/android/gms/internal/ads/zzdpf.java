package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdpf implements zzela<zzdpd> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzbbe> zzerx;
    private final zzelj<zzdkv> zzfim;
    private final zzelj<zzeg> zzfkz;
    private final zzelj<Clock> zzfmf;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<String> zzgrz;
    private final zzelj<String> zzgsj;
    private final zzelj<zzcts> zzhha;

    private zzdpf(zzelj<Executor> zzelj, zzelj<zzbbe> zzelj2, zzelj<zzcts> zzelj3, zzelj<zzbbd> zzelj4, zzelj<String> zzelj5, zzelj<String> zzelj6, zzelj<Context> zzelj7, zzelj<zzdkv> zzelj8, zzelj<Clock> zzelj9, zzelj<zzeg> zzelj10) {
        this.zzerc = zzelj;
        this.zzerx = zzelj2;
        this.zzhha = zzelj3;
        this.zzfmh = zzelj4;
        this.zzgrz = zzelj5;
        this.zzgsj = zzelj6;
        this.zzere = zzelj7;
        this.zzfim = zzelj8;
        this.zzfmf = zzelj9;
        this.zzfkz = zzelj10;
    }

    public static zzdpf zzb(zzelj<Executor> zzelj, zzelj<zzbbe> zzelj2, zzelj<zzcts> zzelj3, zzelj<zzbbd> zzelj4, zzelj<String> zzelj5, zzelj<String> zzelj6, zzelj<Context> zzelj7, zzelj<zzdkv> zzelj8, zzelj<Clock> zzelj9, zzelj<zzeg> zzelj10) {
        return new zzdpf(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7, zzelj8, zzelj9, zzelj10);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdpd(this.zzerc.get(), this.zzerx.get(), this.zzhha.get(), this.zzfmh.get(), this.zzgrz.get(), this.zzgsj.get(), this.zzere.get(), this.zzfim.get(), this.zzfmf.get(), this.zzfkz.get());
    }
}
