package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcuo implements zzdrx {
    private final zzdkk zzfnu;
    private final zzbfn zzfzp;
    private final zzcuk zzgmx;
    private final zzchl zzgmy;

    zzcuo(zzcuk zzcuk, zzbfn zzbfn, zzdkk zzdkk, zzchl zzchl) {
        this.zzgmx = zzcuk;
        this.zzfzp = zzbfn;
        this.zzfnu = zzdkk;
        this.zzgmy = zzchl;
    }

    @Override // com.google.android.gms.internal.ads.zzdrx
    public final Object apply(Object obj) {
        zzbfn zzbfn = this.zzfzp;
        zzdkk zzdkk = this.zzfnu;
        zzchl zzchl = this.zzgmy;
        if (zzdkk.zzdub) {
            zzbfn.zzabm();
        }
        zzbfn.zzaat();
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnq)).booleanValue()) {
            zzq.zzky();
            zzayj.zza(zzbfn);
        }
        return zzchl.zzagc();
    }
}
