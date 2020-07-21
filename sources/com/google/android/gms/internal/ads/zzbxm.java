package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxm implements zzela<Set<zzbyg<zzbuf>>> {
    private final zzbxa zzftd;

    private zzbxm(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxm zzs(zzbxa zzbxa) {
        return new zzbxm(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzajt(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
