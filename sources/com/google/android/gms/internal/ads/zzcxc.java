package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcxc implements zzduu<zzbzj> {
    private final /* synthetic */ zzcae zzgps;
    final /* synthetic */ zzcxd zzgpt;

    zzcxc(zzcxd zzcxd, zzcae zzcae) {
        this.zzgpt = zzcxd;
        this.zzgps = zzcae;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        zzuy zze = zzcmi.zze(th);
        synchronized (this.zzgpt) {
            zzdvf unused = this.zzgpt.zzgph = null;
            this.zzgps.zzaey().onAdFailedToLoad(zze.errorCode);
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxj)).booleanValue()) {
                this.zzgpt.zzgmd.zzade().execute(new zzcxh(this, zze));
                this.zzgpt.zzgmd.zzade().execute(new zzcxg(this, zze));
            }
            zzdlj.zza(zze.errorCode, th, "InterstitialAdManagerShim.onFailure");
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzbzj zzbzj) {
        zzbzj zzbzj2 = zzbzj;
        synchronized (this.zzgpt) {
            zzdvf unused = this.zzgpt.zzgph = null;
            zzbzj unused2 = this.zzgpt.zzgpv = zzbzj2;
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxm)).booleanValue()) {
                zzbzj2.zzaij().zza(this.zzgpt.zzgpa).zza(this.zzgpt.zzgpc).zza(this.zzgpt.zzgpd).zza(this.zzgpt.zzgpu);
            }
            zzbzj2.zzahr();
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcxm)).booleanValue()) {
                this.zzgpt.zzgmd.zzade().execute(new zzcxf(this));
                this.zzgpt.zzgmd.zzade().execute(new zzcxe(this));
            }
        }
    }
}
