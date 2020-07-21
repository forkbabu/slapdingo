package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcpg implements Callable {
    private final zzdvf zzfpl;
    private final zzdvf zzfrf;
    private final zzcoy zzgik;

    zzcpg(zzcoy zzcoy, zzdvf zzdvf, zzdvf zzdvf2) {
        this.zzgik = zzcoy;
        this.zzfrf = zzdvf;
        this.zzfpl = zzdvf2;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgik.zza(this.zzfrf, this.zzfpl);
    }
}
