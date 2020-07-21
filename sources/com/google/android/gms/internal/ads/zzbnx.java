package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnx implements zzela<zzbyg<zzqs>> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzbow> zzfmy;
    private final zzbnj zzfnw;

    public zzbnx(zzbnj zzbnj, zzelj<zzbow> zzelj, zzelj<Executor> zzelj2) {
        this.zzfnw = zzbnj;
        this.zzfmy = zzelj;
        this.zzerc = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), this.zzerc.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
