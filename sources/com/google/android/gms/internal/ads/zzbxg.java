package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxg implements zzela<Set<zzbyg<zzbsq>>> {
    private final zzbxa zzftd;

    private zzbxg(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxg zzl(zzbxa zzbxa) {
        return new zzbxg(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzajn(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
