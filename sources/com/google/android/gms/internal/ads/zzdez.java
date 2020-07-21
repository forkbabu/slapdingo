package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdez implements Callable {
    private final zzdfa zzgve;

    zzdez(zzdfa zzdfa) {
        this.zzgve = zzdfa;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgve.zzarf();
    }
}
