package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbns implements zzela<zzbyg<zzbua>> {
    private final zzelj<zzboq> zzfmy;
    private final zzbnj zzfnw;

    public zzbns(zzbnj zzbnj, zzelj<zzboq> zzelj) {
        this.zzfnw = zzbnj;
        this.zzfmy = zzelj;
    }

    public static zzbyg<zzbua> zza(zzbnj zzbnj, zzboq zzboq) {
        return (zzbyg) zzelg.zza(new zzbyg(zzboq, zzbbf.zzedl), "Cannot return null from a non-@Nullable @Provides method");
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfnw, this.zzfmy.get());
    }
}
