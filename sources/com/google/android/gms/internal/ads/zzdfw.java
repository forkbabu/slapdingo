package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdfw implements Callable {
    private final zzdft zzgvt;

    zzdfw(zzdft zzdft) {
        this.zzgvt = zzdft;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzdft zzdft = this.zzgvt;
        return new zzdfu(zzdft.zzgvs.zzf(zzdft.zzdpu));
    }
}
