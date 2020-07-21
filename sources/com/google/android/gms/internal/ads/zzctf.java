package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzctf implements zzela<zzctc> {
    private final zzelj<Context> zzere;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzcbc> zzgkp;

    public zzctf(zzelj<Context> zzelj, zzelj<zzcbc> zzelj2, zzelj<Executor> zzelj3) {
        this.zzere = zzelj;
        this.zzgkp = zzelj2;
        this.zzfnr = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzctc(this.zzere.get(), this.zzgkp.get(), this.zzfnr.get());
    }
}
