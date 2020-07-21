package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcjh implements zzela<zzbyg<zzuu>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzcjq> zzfmj;

    private zzcjh(zzelj<zzcjq> zzelj, zzelj<Executor> zzelj2) {
        this.zzfmj = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzcjh zzaa(zzelj<zzcjq> zzelj, zzelj<Executor> zzelj2) {
        return new zzcjh(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmj.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
