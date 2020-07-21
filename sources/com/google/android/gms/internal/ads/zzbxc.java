package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxc implements zzela<Set<zzbyg<zzbua>>> {
    private final zzbxa zzftd;

    private zzbxc(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxc zzg(zzbxa zzbxa) {
        return new zzbxc(zzbxa);
    }

    public static Set<zzbyg<zzbua>> zzh(zzbxa zzbxa) {
        return (Set) zzelg.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzh(this.zzftd);
    }
}
