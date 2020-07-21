package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxi implements zzela<Set<zzbyg<zzbtd>>> {
    private final zzbxa zzftd;

    private zzbxi(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxi zzn(zzbxa zzbxa) {
        return new zzbxi(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzajs(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
