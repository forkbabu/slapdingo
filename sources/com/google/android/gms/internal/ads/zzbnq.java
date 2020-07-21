package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbnq implements zzela<Set<zzbyg<zzbua>>> {
    private final zzelj<zzbos> zzfmy;
    private final zzbnj zzfnw;

    public zzbnq(zzbnj zzbnj, zzelj<zzbos> zzelj) {
        this.zzfnw = zzbnj;
        this.zzfmy = zzelj;
    }

    public static Set<zzbyg<zzbua>> zza(zzbnj zzbnj, zzbos zzbos) {
        return (Set) zzelg.zza(Collections.singleton(new zzbyg(zzbos, zzbbf.zzedm)), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfnw, this.zzfmy.get());
    }
}
