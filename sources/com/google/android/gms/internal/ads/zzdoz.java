package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdoz implements zzela<zzdou> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzdot> zzeyv;
    private final zzelj<ScheduledExecutorService> zzfnh;

    private zzdoz(zzelj<zzdvi> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<zzdot> zzelj3) {
        this.zzerc = zzelj;
        this.zzfnh = zzelj2;
        this.zzeyv = zzelj3;
    }

    public static zzdoz zzv(zzelj<zzdvi> zzelj, zzelj<ScheduledExecutorService> zzelj2, zzelj<zzdot> zzelj3) {
        return new zzdoz(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdou(this.zzerc.get(), this.zzfnh.get(), this.zzeyv.get());
    }
}
