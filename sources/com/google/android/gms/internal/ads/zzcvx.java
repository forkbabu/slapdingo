package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvx<AdT> implements zzela<zzcvt<AdT>> {
    private final zzelj<zzdvi> zzfnr;
    private final zzelj<zzdou> zzfoc;
    private final zzelj<zzabo> zzgoa;
    private final zzelj<zzcvu<AdT>> zzgoh;

    public zzcvx(zzelj<zzdou> zzelj, zzelj<zzdvi> zzelj2, zzelj<zzabo> zzelj3, zzelj<zzcvu<AdT>> zzelj4) {
        this.zzfoc = zzelj;
        this.zzfnr = zzelj2;
        this.zzgoa = zzelj3;
        this.zzgoh = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcvt(this.zzfoc.get(), this.zzfnr.get(), this.zzgoa.get(), this.zzgoh.get());
    }
}
