package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxe implements zzela<Set<zzbyg<zzbwd>>> {
    private final zzbxa zzftd;

    private zzbxe(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxe zzj(zzbxa zzbxa) {
        return new zzbxe(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
