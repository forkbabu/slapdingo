package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdjr implements zzduu<zzchj> {
    private final /* synthetic */ zzcxp zzgqi;
    private final /* synthetic */ zzdjw zzgyu;
    final /* synthetic */ zzdjq zzgyv;

    zzdjr(zzdjq zzdjq, zzcxp zzcxp, zzdjw zzdjw) {
        this.zzgyv = zzdjq;
        this.zzgqi = zzcxp;
        this.zzgyu = zzdjw;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        zzuy zze = zzcmi.zze(th);
        synchronized (this.zzgyv) {
            zzchm zzchm = (zzchm) this.zzgyv.zzgwc.zzarv();
            if (zzchm != null) {
                zzchm.zzaey().onAdFailedToLoad(zze.errorCode);
                if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxk)).booleanValue()) {
                    this.zzgyv.zzflp.execute(new zzdjt(this, zze));
                }
            } else {
                this.zzgyv.zzgys.onAdFailedToLoad(zze.errorCode);
                this.zzgyv.zze(this.zzgyu).zzafz().zzaex().zzair().zzajk();
            }
            zzdlj.zza(zze.errorCode, th, "RewardedAdLoader.onFailure");
            this.zzgqi.zzapy();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzchj zzchj) {
        zzchj zzchj2 = zzchj;
        synchronized (this.zzgyv) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxk)).booleanValue()) {
                zzchj2.zzaij().zza(this.zzgyv.zzgys);
            }
            this.zzgqi.onSuccess(zzchj2);
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxk)).booleanValue()) {
                this.zzgyv.zzflp.execute(new zzdju(this));
            }
            this.zzgyv.zzgys.onAdMetadataChanged();
        }
    }
}
