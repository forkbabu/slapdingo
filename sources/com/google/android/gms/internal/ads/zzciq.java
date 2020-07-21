package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzciq implements zzela<zzbyg<zzbtg>> {
    private final zzelj<zzcip> zzfmy;
    private final zzcir zzgcx;

    private zzciq(zzcir zzcir, zzelj<zzcip> zzelj) {
        this.zzgcx = zzcir;
        this.zzfmy = zzelj;
    }

    public static zzciq zza(zzcir zzcir, zzelj<zzcip> zzelj) {
        return new zzciq(zzcir, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), zzbbf.zzedl), "Cannot return null from a non-@Nullable @Provides method");
    }
}
