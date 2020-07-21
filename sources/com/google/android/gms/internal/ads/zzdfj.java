package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdfj implements Callable {
    private final zzdfk zzgvl;

    zzdfj(zzdfk zzdfk) {
        this.zzgvl = zzdfk;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        zzdfk zzdfk = this.zzgvl;
        return new zzdfh(zzdfk.zzgvm.zzf(zzdfk.zzvr));
    }
}
