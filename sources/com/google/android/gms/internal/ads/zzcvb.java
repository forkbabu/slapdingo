package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcvb implements zzela<zzcuu> {
    private final zzelj<Context> zzere;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzchm> zzgkp;

    public zzcvb(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<zzchm> zzelj3) {
        this.zzere = zzelj;
        this.zzfnr = zzelj2;
        this.zzgkp = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcuu(this.zzere.get(), this.zzfnr.get(), this.zzgkp.get());
    }
}
