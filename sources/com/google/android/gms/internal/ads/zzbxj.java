package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxj implements zzela<Set<zzbyg<zzbsz>>> {
    private final zzbxa zzftd;

    private zzbxj(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxj zzo(zzbxa zzbxa) {
        return new zzbxj(zzbxa);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (Set) zzelg.zza(this.zzftd.zzajo(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
