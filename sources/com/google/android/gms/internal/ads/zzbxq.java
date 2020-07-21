package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxq implements zzela<Set<zzbyg<zzqs>>> {
    private final zzbxa zzftd;

    private zzbxq(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxq zzw(zzbxa zzbxa) {
        return new zzbxq(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
