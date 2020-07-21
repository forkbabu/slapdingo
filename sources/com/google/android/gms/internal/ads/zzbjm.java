package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbjm implements zzdhg {
    private final /* synthetic */ zzbiz zzeto;
    private zzelj<Context> zzffm;
    private zzelj<String> zzffn;
    private zzelj<zzdil<zzbmq, zzbmw>> zzffo;
    private zzelj<zzdhi> zzffp;
    private zzelj<zzdgr> zzffq;
    private zzelj<zzdha> zzffr;

    private zzbjm(zzbiz zzbiz, Context context, String str) {
        this.zzeto = zzbiz;
        this.zzffm = zzekz.zzba(context);
        this.zzffn = zzekz.zzba(str);
        this.zzffo = new zzdip(this.zzffm, this.zzeto.zzetf, this.zzeto.zzetg);
        this.zzffp = zzekx.zzas(new zzdhl(this.zzeto.zzetf));
        this.zzffq = zzekx.zzas(new zzdgx(this.zzffm, this.zzeto.zzerj, this.zzeto.zzera, this.zzffo, this.zzffp, zzdlb.zzask()));
        this.zzffr = zzekx.zzas(new zzdhd(this.zzeto.zzera, this.zzffm, this.zzffn, this.zzffq, this.zzffp, this.zzeto.zzerr));
    }

    @Override // com.google.android.gms.internal.ads.zzdhg
    public final zzdha zzafl() {
        return this.zzffr.get();
    }
}
