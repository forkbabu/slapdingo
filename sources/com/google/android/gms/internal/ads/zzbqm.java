package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqm implements zzela<zzbyg<zzbyp>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzbyo> zzfmy;

    private zzbqm(zzelj<zzbyo> zzelj, zzelj<Executor> zzelj2) {
        this.zzfmy = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzbqm zzd(zzelj<zzbyo> zzelj, zzelj<Executor> zzelj2) {
        return new zzbqm(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
