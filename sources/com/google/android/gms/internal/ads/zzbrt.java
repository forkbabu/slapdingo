package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbrt implements Callable {
    private final zzbrq zzfre;
    private final zzdvf zzfrf;

    zzbrt(zzbrq zzbrq, zzdvf zzdvf) {
        this.zzfre = zzbrq;
        this.zzfrf = zzdvf;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzfre.zzc(this.zzfrf);
    }
}
