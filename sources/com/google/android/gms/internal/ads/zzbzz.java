package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzz implements zzela<Set<zzbyg<zzbyd>>> {
    private final zzelj<zzcas> zzfmy;

    private zzbzz(zzelj<zzcas> zzelj) {
        this.zzfmy = zzelj;
    }

    public static zzbzz zzw(zzelj<zzcas> zzelj) {
        return new zzbzz(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(Collections.singleton(zzbyg.zzb(this.zzfmy.get(), zzbbf.zzedm)), "Cannot return null from a non-@Nullable @Provides method");
    }
}
