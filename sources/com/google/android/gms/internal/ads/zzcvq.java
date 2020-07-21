package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvq implements zzela<zzcvk> {
    private final zzelj<zzdvi> zzfnr;
    private final zzelj<zzdou> zzfoc;
    private final zzelj<zzbny> zzgkp;
    private final zzelj<Context> zzgnz;
    private final zzelj<zzabo> zzgoa;

    public zzcvq(zzelj<Context> zzelj, zzelj<zzbny> zzelj2, zzelj<zzdou> zzelj3, zzelj<zzdvi> zzelj4, zzelj<zzabo> zzelj5) {
        this.zzgnz = zzelj;
        this.zzgkp = zzelj2;
        this.zzfoc = zzelj3;
        this.zzfnr = zzelj4;
        this.zzgoa = zzelj5;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcvk(this.zzgnz.get(), this.zzgkp.get(), this.zzfoc.get(), this.zzfnr.get(), this.zzgoa.get());
    }
}
