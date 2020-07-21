package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdfs implements Callable {
    private final zzdvf zzfrf;
    private final zzdvf zzgay;

    zzdfs(zzdvf zzdvf, zzdvf zzdvf2) {
        this.zzgay = zzdvf;
        this.zzfrf = zzdvf2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return new zzdfq((String) this.zzgay.get(), (String) this.zzfrf.get());
    }
}
