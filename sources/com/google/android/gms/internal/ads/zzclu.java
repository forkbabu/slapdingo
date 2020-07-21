package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzclu implements zzela<zzclv> {
    private final zzelj<zzbif> zzera;
    private final zzelj<zzclj> zzgdq;

    private zzclu(zzelj<zzclj> zzelj, zzelj<zzbif> zzelj2) {
        this.zzgdq = zzelj;
        this.zzera = zzelj2;
    }

    public static zzclu zzan(zzelj<zzclj> zzelj, zzelj<zzbif> zzelj2) {
        return new zzclu(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzclv(this.zzgdq.get(), this.zzera.get());
    }
}
