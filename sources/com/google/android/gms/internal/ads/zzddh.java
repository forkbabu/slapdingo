package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzddh implements zzela<zzdde> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzcwj> zzert;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<String> zzfmi;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzcwh> zzgnl;

    private zzddh(zzelj<zzdvi> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<String> zzelj3, zzelj<zzcwj> zzelj4, zzelj<Context> zzelj5, zzelj<zzdla> zzelj6, zzelj<zzcwh> zzelj7) {
        this.zzerc = zzelj;
        this.zzfkv = zzelj2;
        this.zzfmi = zzelj3;
        this.zzert = zzelj4;
        this.zzere = zzelj5;
        this.zzfnz = zzelj6;
        this.zzgnl = zzelj7;
    }

    public static zzddh zzb(zzelj<zzdvi> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<String> zzelj3, zzelj<zzcwj> zzelj4, zzelj<Context> zzelj5, zzelj<zzdla> zzelj6, zzelj<zzcwh> zzelj7) {
        return new zzddh(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdde(this.zzerc.get(), this.zzfkv.get(), this.zzfmi.get(), this.zzert.get(), this.zzere.get(), this.zzfnz.get(), this.zzgnl.get());
    }
}
