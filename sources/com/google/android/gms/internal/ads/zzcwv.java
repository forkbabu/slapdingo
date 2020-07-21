package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcwv implements zzduu<zzbnc> {
    private final /* synthetic */ zzbny zzgpk;
    final /* synthetic */ zzcws zzgpl;

    zzcwv(zzcws zzcws, zzbny zzbny) {
        this.zzgpl = zzcws;
        this.zzgpk = zzbny;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        zzuy zze = zzcmi.zze(th);
        synchronized (this.zzgpl) {
            zzdvf unused = this.zzgpl.zzgph = null;
            this.zzgpk.zzaey().onAdFailedToLoad(zze.errorCode);
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxj)).booleanValue()) {
                this.zzgpl.zzgmd.zzade().execute(new zzcwx(this, zze));
            }
            this.zzgpl.zzgpe.zzdu(60);
            zzdlj.zza(zze.errorCode, th, "BannerAdManagerShim.onFailure");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzbnc zzbnc) {
        zzbnc zzbnc2 = zzbnc;
        synchronized (this.zzgpl) {
            zzdvf unused = this.zzgpl.zzgph = null;
            if (this.zzgpl.zzgoq != null) {
                this.zzgpl.zzgoq.destroy();
            }
            zzbnc unused2 = this.zzgpl.zzgoq = zzbnc2;
            this.zzgpl.zzfng.removeAllViews();
            if (zzbnc2.zzahk() != null) {
                ViewParent parent = zzbnc2.zzahk().getParent();
                if (parent instanceof ViewGroup) {
                    String mediationAdapterClassName = this.zzgpl.getMediationAdapterClassName();
                    StringBuilder sb = new StringBuilder(String.valueOf(mediationAdapterClassName).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(mediationAdapterClassName);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzaxv.zzfd(sb.toString());
                    ((ViewGroup) parent).removeView(zzbnc2.zzahk());
                }
            }
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxj)).booleanValue()) {
                zzbnc2.zzaij().zza(this.zzgpl.zzgpa).zza(this.zzgpl.zzgpb).zza(this.zzgpl.zzgpc).zza(this.zzgpl.zzgpd);
            }
            this.zzgpl.zzfng.addView(zzbnc2.zzahk());
            zzbnc2.zzahr();
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxj)).booleanValue()) {
                Executor zzade = this.zzgpl.zzgmd.zzade();
                zzcxb zzf = this.zzgpl.zzgpa;
                zzf.getClass();
                zzade.execute(zzcwu.zzb(zzf));
            }
            this.zzgpl.zzgpe.zzdu(zzbnc2.zzahq());
        }
    }
}
