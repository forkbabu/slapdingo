package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbio implements zzela<zzblb> {
    private final zzbie zzeqy;
    private final zzelj<zzbif> zzera;

    public zzbio(zzbie zzbie, zzelj<zzbif> zzelj) {
        this.zzeqy = zzbie;
        this.zzera = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzblb) zzelg.zza(this.zzera.get(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
