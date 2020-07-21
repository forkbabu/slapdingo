package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxk implements zzela<Set<zzbyg<zzbua>>> {
    private final zzbxa zzftd;

    private zzbxk(zzbxa zzbxa) {
        this.zzftd = zzbxa;
    }

    public static zzbxk zzp(zzbxa zzbxa) {
        return new zzbxk(zzbxa);
    }

    public static Set<zzbyg<zzbua>> zzq(zzbxa zzbxa) {
        return (Set) zzelg.zza(zzbxa.zzajm(), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zzq(this.zzftd);
    }
}
