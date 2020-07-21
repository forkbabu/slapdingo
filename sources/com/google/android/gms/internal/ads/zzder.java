package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzder implements zzela<zzdeq> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzaxd> zzesg;
    private final zzelj<ScheduledExecutorService> zzfkv;

    public zzder(zzelj<zzaxd> zzelj, zzelj<Context> zzelj2, zzelj<ScheduledExecutorService> zzelj3, zzelj<Executor> zzelj4) {
        this.zzesg = zzelj;
        this.zzere = zzelj2;
        this.zzfkv = zzelj3;
        this.zzerc = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdeq(this.zzesg.get(), this.zzere.get(), this.zzfkv.get(), this.zzerc.get());
    }
}
