package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsa implements zzela<zzcrw> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzbny> zzfgm;
    private final zzelj<zzcrc> zzfgq;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzbso> zzgle;

    public zzcsa(zzelj<zzbny> zzelj, zzelj<zzcrc> zzelj2, zzelj<zzbso> zzelj3, zzelj<ScheduledExecutorService> zzelj4, zzelj<zzdvi> zzelj5) {
        this.zzfgm = zzelj;
        this.zzfgq = zzelj2;
        this.zzgle = zzelj3;
        this.zzfkv = zzelj4;
        this.zzerc = zzelj5;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcrw(this.zzfgm.get(), this.zzfgq.get(), this.zzgle.get(), this.zzfkv.get(), this.zzerc.get());
    }
}
