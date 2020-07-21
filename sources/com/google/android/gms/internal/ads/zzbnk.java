package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnk implements zzela<zzbtv> {
    private final zzbnj zzfnw;
    private final zzelj<Set<zzbyg<zzbua>>> zzfnx;

    public zzbnk(zzbnj zzbnj, zzelj<Set<zzbyg<zzbua>>> zzelj) {
        this.zzfnw = zzbnj;
        this.zzfnx = zzelj;
    }

    public static zzbtv zza(zzbnj zzbnj, Set<zzbyg<zzbua>> set) {
        return (zzbtv) zzelg.zza(zzbnj.zza(set), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfnw, this.zzfnx.get());
    }
}
