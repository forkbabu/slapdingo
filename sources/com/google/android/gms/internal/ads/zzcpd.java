package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcpd implements Callable {
    private final zzdvf zzfrf;
    private final zzdvf zzgay;

    zzcpd(zzdvf zzdvf, zzdvf zzdvf2) {
        this.zzgay = zzdvf;
        this.zzfrf = zzdvf2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzdvf zzdvf = this.zzgay;
        zzdvf zzdvf2 = this.zzfrf;
        return new zzcpm((zzcpt) zzdvf.get(), ((zzcpn) zzdvf2.get()).zzgio, ((zzcpn) zzdvf2.get()).zzgip);
    }
}
