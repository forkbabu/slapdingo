package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdlw implements zzela<zzbyg<zzbsq>> {
    private final zzelj<zzdlv> zzfqi;
    private final zzdlt zzhby;

    private zzdlw(zzdlt zzdlt, zzelj<zzdlv> zzelj) {
        this.zzhby = zzdlt;
        this.zzfqi = zzelj;
    }

    public static zzdlw zza(zzdlt zzdlt, zzelj<zzdlv> zzelj) {
        return new zzdlw(zzdlt, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfqi.get(), zzbbf.zzedm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
