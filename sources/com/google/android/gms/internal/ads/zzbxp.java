package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxp implements zzela<Set<zzbyg<zzbup>>> {
    private final zzbxa zzftd;

    private zzbxp(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxp zzv(zzbxa zzbxa) {
        return new zzbxp(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzaju(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
