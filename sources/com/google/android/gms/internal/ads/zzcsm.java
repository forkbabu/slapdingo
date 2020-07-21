package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsm implements zzcqw<zzbzj, zzdlm, zzcsd> {
    private final zzbbd zzbov;
    private final Executor zzflp;
    private final zzcae zzgkx;
    private final Context zzvr;

    public zzcsm(Context context, zzbbd zzbbd, zzcae zzcae, Executor executor) {
        this.zzvr = context;
        this.zzbov = zzbbd;
        this.zzgkx = zzcae;
        this.zzflp = executor;
    }

    @Override // com.google.android.gms.internal.ads.zzcqw
    public final void zza(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsd> zzcqv) throws zzdlg {
        if (this.zzbov.zzede < 4100000) {
            zzcqv.zzdka.zza(this.zzvr, zzdkw.zzhat.zzfpv.zzhay, zzdkk.zzgzu.toString(), zzcqv.zzgki);
        } else {
            zzcqv.zzdka.zza(this.zzvr, zzdkw.zzhat.zzfpv.zzhay, zzdkk.zzgzu.toString(), zzazy.zza(zzdkk.zzgzr), zzcqv.zzgki);
        }
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.android.gms.internal.ads.zzdkw, com.google.android.gms.internal.ads.zzdkk, com.google.android.gms.internal.ads.zzcqv] */
    @Override // com.google.android.gms.internal.ads.zzcqw
    public final /* synthetic */ zzbzj zzb(zzdkw zzdkw, zzdkk zzdkk, zzcqv<zzdlm, zzcsd> zzcqv) throws zzdlg, zzctw {
        zzbzl zza = this.zzgkx.zza(new zzbpr(zzdkw, zzdkk, zzcqv.zzfpp), new zzbzk(new zzcsp(zzcqv)));
        zza.zzaeh().zza(new zzbli(zzcqv.zzdka), this.zzflp);
        zzcqv.zzgki.zzb(zza.zzaem());
        return zza.zzafw();
    }
}
