package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdgw implements zzduu<zzbmw> {
    private final /* synthetic */ zzcxp zzgqi;
    private final /* synthetic */ zzdgy zzgwf;
    final /* synthetic */ zzdgr zzgwg;

    zzdgw(zzdgr zzdgr, zzcxp zzcxp, zzdgy zzdgy) {
        this.zzgwg = zzdgr;
        this.zzgqi = zzcxp;
        this.zzgwf = zzdgy;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        zzuy zze = zzcmi.zze(th);
        synchronized (this.zzgwg) {
            zzdvf unused = this.zzgwg.zzgph = null;
            zzbmq zzbmq = (zzbmq) this.zzgwg.zzgwc.zzarv();
            if (zzbmq != null) {
                zzbmq.zzaey().onAdFailedToLoad(zze.errorCode);
                if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxl)).booleanValue()) {
                    this.zzgwg.zzflp.execute(new zzdgv(this, zze));
                }
            } else {
                this.zzgwg.zzgwb.onAdFailedToLoad(zze.errorCode);
                this.zzgwg.zzb(this.zzgwf).zzafg().zzaex().zzair().zzajk();
            }
            zzdlj.zza(zze.errorCode, th, "AppOpenAdLoader.onFailure");
            this.zzgqi.zzapy();
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzbmw zzbmw) {
        zzbmw zzbmw2 = zzbmw;
        synchronized (this.zzgwg) {
            zzdvf unused = this.zzgwg.zzgph = null;
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxl)).booleanValue()) {
                zzbmw2.zzaij().zza(this.zzgwg.zzgwb);
            }
            this.zzgqi.onSuccess(zzbmw2);
        }
    }
}
