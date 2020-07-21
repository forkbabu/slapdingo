package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbqp implements zzela<zzbyg<zzuu>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzblk> zzfmy;

    private zzbqp(zzelj<zzblk> zzelj, zzelj<Executor> zzelj2) {
        this.zzfmy = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzbqp zzg(zzelj<zzblk> zzelj, zzelj<Executor> zzelj2) {
        return new zzbqp(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
