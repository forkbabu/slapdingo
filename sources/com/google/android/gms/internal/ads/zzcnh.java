package com.google.android.gms.internal.ads;

import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcnh implements zzela<zzcnf> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzcoa> zzggk;
    private final zzelj<zzcoy> zzggl;

    public zzcnh(zzelj<ScheduledExecutorService> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzcoa> zzelj3, zzelj<zzcoy> zzelj4) {
        this.zzfkv = zzelj;
        this.zzerc = zzelj2;
        this.zzggk = zzelj3;
        this.zzggl = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcnf(this.zzfkv.get(), this.zzerc.get(), this.zzggk.get(), zzekx.zzat(this.zzggl));
    }
}
