package com.google.android.gms.internal.ads;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcrz implements Callable {
    private final zzdkk zzfnu;
    private final zzdkw zzgao;
    private final zzcrw zzgld;

    zzcrz(zzcrw zzcrw, zzdkw zzdkw, zzdkk zzdkk) {
        this.zzgld = zzcrw;
        this.zzgao = zzdkw;
        this.zzfnu = zzdkk;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        return this.zzgld.zzc(this.zzgao, this.zzfnu);
    }
}
