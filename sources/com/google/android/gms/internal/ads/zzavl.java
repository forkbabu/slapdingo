package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzavl implements zzduu<Void> {
    private final /* synthetic */ zzdvf zzdvs;

    zzavl(zzavi zzavi, zzdvf zzdvf) {
        this.zzdvs = zzdvf;
    }

    @Override // com.google.android.gms.internal.ads.zzduu
    public final void zzb(Throwable th) {
        zzavi.zzdvf.remove(this.zzdvs);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzduu
    public final /* synthetic */ void onSuccess(Void voidR) {
        zzavi.zzdvf.remove(this.zzdvs);
    }
}
