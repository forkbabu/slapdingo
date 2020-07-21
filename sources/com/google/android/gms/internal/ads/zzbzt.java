package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzt implements zzela<zzbyg<zzbua>> {
    private final zzelj<zzcao> zzfmy;
    private final zzbzk zzftx;

    private zzbzt(zzbzk zzbzk, zzelj<zzcao> zzelj) {
        this.zzftx = zzbzk;
        this.zzfmy = zzelj;
    }

    public static zzbzt zzc(zzbzk zzbzk, zzelj<zzcao> zzelj) {
        return new zzbzt(zzbzk, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), zzbbf.zzedl), "Cannot return null from a non-@Nullable @Provides method");
    }
}
