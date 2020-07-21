package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrx implements zzela<zzcrs> {
    private final zzelj<Context> zzere;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzcae> zzgkp;
    private final zzelj<zzdki> zzglc;

    public zzcrx(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<zzcae> zzelj3, zzelj<zzdki> zzelj4) {
        this.zzere = zzelj;
        this.zzfnr = zzelj2;
        this.zzgkp = zzelj3;
        this.zzglc = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcrs(this.zzere.get(), this.zzfnr.get(), this.zzgkp.get(), this.zzglc.get());
    }
}
