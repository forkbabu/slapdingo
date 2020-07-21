package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcsj implements zzdrx {
    private final zzdkk zzfnu;
    private final zzbfn zzfzp;
    private final zzcsf zzglj;
    private final zzbzl zzglo;

    zzcsj(zzcsf zzcsf, zzbfn zzbfn, zzdkk zzdkk, zzbzl zzbzl) {
        this.zzglj = zzcsf;
        this.zzfzp = zzbfn;
        this.zzfnu = zzdkk;
        this.zzglo = zzbzl;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        zzbfn zzbfn = this.zzfzp;
        zzdkk zzdkk = this.zzfnu;
        zzbzl zzbzl = this.zzglo;
        if (zzdkk.zzdub) {
            zzbfn.zzabm();
        }
        zzbfn.zzaat();
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnq)).booleanValue()) {
            zzq.zzky();
            zzayj.zza(zzbfn);
        }
        return zzbzl.zzafw();
    }
}
