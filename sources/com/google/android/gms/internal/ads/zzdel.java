package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdel implements Callable {
    private final zzdem zzguv;

    zzdel(zzdem zzdem) {
        this.zzguv = zzdem;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzguv.zzare();
    }
}
