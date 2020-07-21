package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbrn implements zzdrx {
    private final Context zzclf;
    private final zzbbd zzfnt;
    private final zzdla zzfqs;

    zzbrn(Context context, zzbbd zzbbd, zzdla zzdla) {
        this.zzclf = context;
        this.zzfnt = zzbbd;
        this.zzfqs = zzdla;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        Context context = this.zzclf;
        zzbbd zzbbd = this.zzfnt;
        zzdla zzdla = this.zzfqs;
        zzdkk zzdkk = (zzdkk) obj;
        zzayv zzayv = new zzayv(context);
        zzayv.zzes(zzdkk.zzdrk);
        zzayv.zzet(zzdkk.zzgzw.toString());
        zzayv.zzad(zzbbd.zzbpn);
        zzayv.setAdUnitId(zzdla.zzhaz);
        return zzayv;
    }
}
