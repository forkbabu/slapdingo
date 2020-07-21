package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbjw implements zzdkc {
    private final /* synthetic */ zzbiz zzeto;
    private zzelj<Context> zzffm;
    private zzelj<String> zzffn;
    private zzelj<zzdil<zzchm, zzchj>> zzfik;
    private zzelj<zzdiu> zzfil;
    private zzelj<zzdkv> zzfim;
    private zzelj<zzdjq> zzfin;
    private zzelj<zzdke> zzfio;
    private zzelj<zzdjy> zzfip;

    private zzbjw(zzbiz zzbiz, Context context, String str) {
        this.zzeto = zzbiz;
        zzela zzba = zzekz.zzba(context);
        this.zzffm = zzba;
        this.zzfik = new zzdis(zzba, this.zzeto.zzetf, this.zzeto.zzetg);
        this.zzfil = zzekx.zzas(new zzdjo(this.zzeto.zzetf));
        this.zzfim = zzekx.zzas(zzdky.zzasi());
        zzelj<zzdjq> zzas = zzekx.zzas(new zzdjv(this.zzffm, this.zzeto.zzerj, this.zzeto.zzera, this.zzfik, this.zzfil, zzdlb.zzask(), this.zzfim));
        this.zzfin = zzas;
        this.zzfio = zzekx.zzas(new zzdkf(zzas, this.zzfil, this.zzfim));
        zzela zzbb = zzekz.zzbb(str);
        this.zzffn = zzbb;
        this.zzfip = zzekx.zzas(new zzdjz(zzbb, this.zzfin, this.zzffm, this.zzfil, this.zzfim));
    }

    @Override // com.google.android.gms.internal.ads.zzdkc
    public final zzdke zzaga() {
        return this.zzfio.get();
    }

    @Override // com.google.android.gms.internal.ads.zzdkc
    public final zzdjy zzagb() {
        return this.zzfip.get();
    }
}
