package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbxb implements zzela<zzbso> {
    private final zzbxa zzftd;
    private final zzelj<Set<zzbyg<zzbsq>>> zzfte;

    private zzbxb(zzbxa zzbxa, zzelj<Set<zzbyg<zzbsq>>> zzelj) {
        this.zzftd = zzbxa;
        this.zzfte = zzelj;
    }

    public static zzbxb zza(zzbxa zzbxa, zzelj<Set<zzbyg<zzbsq>>> zzelj) {
        return new zzbxb(zzbxa, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbso) zzelg.zza(this.zzftd.zzc(this.zzfte.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
