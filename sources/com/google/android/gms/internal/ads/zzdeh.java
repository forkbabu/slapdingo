package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdeh implements Callable {
    private final zzdei zzguu;

    zzdeh(zzdei zzdei) {
        this.zzguu = zzdei;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzguu.zzard();
    }
}
