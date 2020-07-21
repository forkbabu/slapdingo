package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcdk implements zzela<zzcdg> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzcco> zzetw;
    private final zzelj<zzcdo> zzews;
    private final zzelj<zzcdw> zzewt;
    private final zzelj<zzccj> zzewv;
    private final zzelj<zzaxx> zzexy;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzcck> zzfvp;

    private zzcdk(zzelj<zzaxx> zzelj, zzelj<zzdla> zzelj2, zzelj<zzcco> zzelj3, zzelj<zzcck> zzelj4, zzelj<zzcdo> zzelj5, zzelj<zzcdw> zzelj6, zzelj<Executor> zzelj7, zzelj<Executor> zzelj8, zzelj<zzccj> zzelj9) {
        this.zzexy = zzelj;
        this.zzfnz = zzelj2;
        this.zzetw = zzelj3;
        this.zzfvp = zzelj4;
        this.zzews = zzelj5;
        this.zzewt = zzelj6;
        this.zzfnr = zzelj7;
        this.zzerc = zzelj8;
        this.zzewv = zzelj9;
    }

    public static zzcdk zzb(zzelj<zzaxx> zzelj, zzelj<zzdla> zzelj2, zzelj<zzcco> zzelj3, zzelj<zzcck> zzelj4, zzelj<zzcdo> zzelj5, zzelj<zzcdw> zzelj6, zzelj<Executor> zzelj7, zzelj<Executor> zzelj8, zzelj<zzccj> zzelj9) {
        return new zzcdk(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7, zzelj8, zzelj9);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcdg(this.zzexy.get(), this.zzfnz.get(), this.zzetw.get(), this.zzfvp.get(), this.zzews.get(), this.zzewt.get(), this.zzfnr.get(), this.zzerc.get(), this.zzewv.get());
    }
}
