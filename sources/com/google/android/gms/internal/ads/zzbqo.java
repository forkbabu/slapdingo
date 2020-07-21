package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqo implements zzela<zzbyg<zzbsl>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzblk> zzfmy;

    private zzbqo(zzelj<zzblk> zzelj, zzelj<Executor> zzelj2) {
        this.zzfmy = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzbqo zzf(zzelj<zzblk> zzelj, zzelj<Executor> zzelj2) {
        return new zzbqo(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
