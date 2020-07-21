package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbz implements zzela<zzbyg<zzbtd>> {
    private final zzelj<zzceh> zzfmy;
    private final zzcbr zzfvs;

    public zzcbz(zzcbr zzcbr, zzelj<zzceh> zzelj) {
        this.zzfvs = zzcbr;
        this.zzfmy = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), zzbbf.zzedm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
