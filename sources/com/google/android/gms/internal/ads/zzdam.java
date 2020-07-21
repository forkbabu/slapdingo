package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdam implements zzela<zzdai> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<ScheduledExecutorService> zzfkv;

    private zzdam(zzelj<Context> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<Executor> zzelj3) {
        this.zzere = zzelj;
        this.zzfkv = zzelj2;
        this.zzerc = zzelj3;
    }

    public static zzdam zzr(zzelj<Context> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<Executor> zzelj3) {
        return new zzdam(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdai(this.zzere.get(), this.zzfkv.get(), this.zzerc.get());
    }
}
