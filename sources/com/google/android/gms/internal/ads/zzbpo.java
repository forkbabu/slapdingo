package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbpo implements zzduu<zzbpb> {
    private final /* synthetic */ zzduu zzfpm;
    private final /* synthetic */ zzbpi zzfpn;

    zzbpo(zzbpi zzbpi, zzduu zzduu) {
        this.zzfpn = zzbpi;
        this.zzfpm = zzduu;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        this.zzfpn.zzaik();
        this.zzfpm.zzb(th);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(zzbpb zzbpb) {
        this.zzfpn.zzaik();
        this.zzfpm.onSuccess(zzbpb);
    }
}
