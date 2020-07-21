package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcmk implements Callable {
    private final zzcml zzgge;
    private final zzasm zzggf;

    zzcmk(zzcml zzcml, zzasm zzasm) {
        this.zzgge = zzcml;
        this.zzggf = zzasm;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgge.zzf(this.zzggf);
    }
}
