package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcxi implements zzcxp<zzbpb> {
    private final /* synthetic */ zzcxj zzgpy;

    zzcxi(zzcxj zzcxj) {
        this.zzgpy = zzcxj;
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zzapy() {
        synchronized (this.zzgpy) {
            boolean unused = this.zzgpy.zzaeu = false;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzcxp
    public final /* synthetic */ void onSuccess(zzbpb zzbpb) {
        zzbpb zzbpb2 = zzbpb;
        synchronized (this.zzgpy) {
            boolean unused = this.zzgpy.zzaeu = false;
            zzyd unused2 = this.zzgpy.zzadl = zzbpb2.zzaih();
            zzbpb2.zzahr();
        }
    }
}
