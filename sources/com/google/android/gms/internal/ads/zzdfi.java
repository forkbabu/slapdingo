package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfi implements zzela<zzdfe> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzaxd> zzesg;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzaxh> zzgrt;
    private final zzelj<Integer> zzgvk;

    public zzdfi(zzelj<zzaxd> zzelj, zzelj<Integer> zzelj2, zzelj<Context> zzelj3, zzelj<zzaxh> zzelj4, zzelj<ScheduledExecutorService> zzelj5, zzelj<Executor> zzelj6) {
        this.zzesg = zzelj;
        this.zzgvk = zzelj2;
        this.zzere = zzelj3;
        this.zzgrt = zzelj4;
        this.zzfkv = zzelj5;
        this.zzerc = zzelj6;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdfe(this.zzesg.get(), this.zzgvk.get().intValue(), this.zzere.get(), this.zzgrt.get(), this.zzfkv.get(), this.zzerc.get());
    }
}
