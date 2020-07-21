package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcmp implements zzela<zzcml> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<zzdvi> zzggj;
    private final zzelj<zzcnw> zzggk;
    private final zzelj<zzcoy> zzggl;

    private zzcmp(zzelj<zzdvi> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzcnw> zzelj3, zzelj<zzcoy> zzelj4) {
        this.zzggj = zzelj;
        this.zzerc = zzelj2;
        this.zzggk = zzelj3;
        this.zzggl = zzelj4;
    }

    public static zzcmp zzc(zzelj<zzdvi> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzcnw> zzelj3, zzelj<zzcoy> zzelj4) {
        return new zzcmp(zzelj, zzelj2, zzelj3, zzelj4);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcml(this.zzggj.get(), this.zzerc.get(), this.zzggk.get(), zzekx.zzat(this.zzggl));
    }
}
