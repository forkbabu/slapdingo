package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.zzb;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrk implements zzcqw<zzbnc, zzdlm, zzcsd> {
    private final zzbbd zzbov;
    private final Executor zzflp;
    private final zzbny zzgkn;
    private final Context zzvr;

    public zzcrk(Context context, zzbbd zzbbd, zzbny zzbny, Executor executor) {
        this.zzvr = context;
        this.zzbov = zzbbd;
        this.zzgkn = zzbny;
        this.zzflp = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsd> zzcqv) throws zzdlg {
        zzvh zzvh;
        zzvh zzvh2 = zzdkw.zzhat.zzfpv.zzboz;
        if (zzvh2.zzchp) {
            zzvh = new zzvh(this.zzvr, zzb.zza(zzvh2.width, zzvh2.height));
        } else {
            zzvh = zzdld.zzb(this.zzvr, zzdkk.zzgzt);
        }
        if (this.zzbov.zzede < 4100000) {
            zzcqv.zzdka.zza(this.zzvr, zzvh, zzdkw.zzhat.zzfpv.zzhay, zzdkk.zzgzu.toString(), zzcqv.zzgki);
        } else {
            zzcqv.zzdka.zza(this.zzvr, zzvh, zzdkw.zzhat.zzfpv.zzhay, zzdkk.zzgzu.toString(), zzazy.zza(zzdkk.zzgzr), zzcqv.zzgki);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzbnc zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsd> zzcqv) throws zzdlg, zzctw {
        zzbny zzbny = this.zzgkn;
        zzbpr zzbpr = new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp);
        View view = zzcqv.zzdka.getView();
        AdapterT adaptert = zzcqv.zzdka;
        adaptert.getClass();
        zzbnf zza = zzbny.zza(zzbpr, new zzbnj(view, null, zzcrn.zza(adaptert), zzdkk.zzgzt.get(0)));
        zza.zzafo().zzv(zzcqv.zzdka.getView());
        zza.zzaeh().zza(new zzbli(zzcqv.zzdka), this.zzflp);
        zzcqv.zzgki.zzb(zza.zzaem());
        return zza.zzafn();
    }
}
