package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcpy implements Callable {
    private final zzcpx zzgiy;

    private zzcpy(zzcpx zzcpx) {
        this.zzgiy = zzcpx;
    }

    static Callable zza(zzcpx zzcpx) {
        return new zzcpy(zzcpx);
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgiy.getWritableDatabase();
    }
}
