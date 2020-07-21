package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcff implements zzduh {
    private final zzdvf zzgay;

    zzcff(zzdvf zzdvf) {
        this.zzgay = zzdvf;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        zzdvf zzdvf = this.zzgay;
        zzbfn zzbfn = (zzbfn) obj;
        if (zzbfn != null && zzbfn.zzzj() != null) {
            return zzdvf;
        }
        throw new zzctw(zzdls.zzhbq, "Retrieve video view in instream ad response failed.");
    }
}
