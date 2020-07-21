package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcfh implements zzduh {
    private final zzdvf zzgay;

    zzcfh(zzdvf zzdvf) {
        this.zzgay = zzdvf;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        zzdvf zzdvf = this.zzgay;
        if (obj != null) {
            return zzdvf;
        }
        return zzdux.immediateFailedFuture(new zzctw(zzdls.zzhbq, "Retrieve required value in native ad response failed."));
    }
}
