package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxh implements zzela<Set<zzbyg<zzuu>>> {
    private final zzbxa zzftd;

    private zzbxh(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxh zzm(zzbxa zzbxa) {
        return new zzbxh(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzajr(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
