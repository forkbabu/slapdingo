package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdka implements zzcxp<zzchj> {
    private final /* synthetic */ zzdjy zzgyy;

    zzdka(zzdjy zzdjy) {
        this.zzgyy = zzdjy;
    }

    @Override // com.google.android.gms.internal.ads.zzcxp
    public final void zzapy() {
        synchronized (this.zzgyy) {
            zzchj unused = this.zzgyy.zzgzb = (zzchj) null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzcxp
    public final /* synthetic */ void onSuccess(zzchj zzchj) {
        zzchj zzchj2 = zzchj;
        synchronized (this.zzgyy) {
            zzchj unused = this.zzgyy.zzgzb = zzchj2;
            this.zzgyy.zzgzb.zzahr();
        }
    }
}
