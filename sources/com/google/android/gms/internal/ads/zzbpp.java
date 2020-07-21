package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbpp implements zzduu<zzbph> {
    private final /* synthetic */ zzduu zzfpm;
    private final /* synthetic */ zzbpi zzfpn;

    zzbpp(zzbpi zzbpi, zzduu zzduu) {
        this.zzfpn = zzbpi;
        this.zzfpm = zzduu;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        this.zzfpm.zzb(th);
        this.zzfpn.zzaik();
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzbph zzbph) {
        this.zzfpn.zza(zzbph.zzfpg, this.zzfpm);
    }
}
