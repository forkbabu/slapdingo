package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;
import java.util.Collections;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxf implements zzela<Set<zzbyg<zzo>>> {
    private final zzbxa zzftd;

    private zzbxf(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxf zzk(zzbxa zzbxa) {
        return new zzbxf(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
