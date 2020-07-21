package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdkd implements zzcxp<zzchj> {
    private final /* synthetic */ zzdke zzgzc;

    zzdkd(zzdke zzdke) {
        this.zzgzc = zzdke;
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zzapy() {
        synchronized (this.zzgzc) {
            zzchj unused = this.zzgzc.zzgzb = null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzcxp
    public final /* synthetic */ void onSuccess(zzchj zzchj) {
        zzchj zzchj2 = zzchj;
        synchronized (this.zzgzc) {
            zzchj unused = this.zzgzc.zzgzb = zzchj2;
            this.zzgzc.zzgzb.zzahr();
        }
    }
}
