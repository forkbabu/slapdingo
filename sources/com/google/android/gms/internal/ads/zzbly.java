package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbly implements zzela<zzblp> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzqn> zzfma;
    private final zzelj<zzalw> zzfmb;

    private zzbly(zzelj<zzqn> zzelj, zzelj<zzalw> zzelj2, zzelj<Executor> zzelj3) {
        this.zzfma = zzelj;
        this.zzfmb = zzelj2;
        this.zzerc = zzelj3;
    }

    public static zzbly zza(zzelj<zzqn> zzelj, zzelj<zzalw> zzelj2, zzelj<Executor> zzelj3) {
        return new zzbly(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzblp) zzelg.zza(new zzblp(this.zzfma.get().getUniqueId(), this.zzfmb.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
