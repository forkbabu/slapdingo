package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxl implements zzela<Set<zzbyg<zzbsl>>> {
    private final zzbxa zzftd;

    private zzbxl(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxl zzr(zzbxa zzbxa) {
        return new zzbxl(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzajl(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
