package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcmj implements zzela<zzclx> {
    private final zzelj<zzcix> zzeqz;
    private final zzelj<Executor> zzerc;
    private final zzelj<zzclh> zzerz;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<Executor> zzfnr;
    private final zzelj<Context> zzggc;
    private final zzelj<WeakReference<Context>> zzggd;

    public zzcmj(zzelj<Executor> zzelj, zzelj<Context> zzelj2, zzelj<WeakReference<Context>> zzelj3, zzelj<Executor> zzelj4, zzelj<zzcix> zzelj5, zzelj<ScheduledExecutorService> zzelj6, zzelj<zzclh> zzelj7, zzelj<zzbbd> zzelj8) {
        this.zzfnr = zzelj;
        this.zzggc = zzelj2;
        this.zzggd = zzelj3;
        this.zzerc = zzelj4;
        this.zzeqz = zzelj5;
        this.zzfkv = zzelj6;
        this.zzerz = zzelj7;
        this.zzfmh = zzelj8;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzclx(this.zzfnr.get(), this.zzggc.get(), this.zzggd.get(), this.zzerc.get(), this.zzeqz.get(), this.zzfkv.get(), this.zzerz.get(), this.zzfmh.get());
    }
}
