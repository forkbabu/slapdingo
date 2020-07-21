package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcnt implements zzela<zzcnp> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzcqf> zzeyi;
    private final zzelj<zzcml> zzfcg;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzdla> zzfnz;

    private zzcnt(zzelj<zzdla> zzelj, zzelj<zzcml> zzelj2, zzelj<zzdvi> zzelj3, zzelj<ScheduledExecutorService> zzelj4, zzelj<zzcqf> zzelj5) {
        this.zzfnz = zzelj;
        this.zzfcg = zzelj2;
        this.zzerc = zzelj3;
        this.zzfkv = zzelj4;
        this.zzeyi = zzelj5;
    }

    public static zzcnt zzg(zzelj<zzdla> zzelj, zzelj<zzcml> zzelj2, zzelj<zzdvi> zzelj3, zzelj<ScheduledExecutorService> zzelj4, zzelj<zzcqf> zzelj5) {
        return new zzcnt(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcnp(this.zzfnz.get(), this.zzfcg.get(), this.zzerc.get(), this.zzfkv.get(), this.zzeyi.get());
    }
}
