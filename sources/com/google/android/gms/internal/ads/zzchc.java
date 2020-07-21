package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzchc implements zzela<zzchb> {
    private final zzelj<Context> zzere;
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzbbd> zzfro;
    private final zzelj<zzeg> zzfvq;
    private final zzelj<zza> zzgaz;
    private final zzelj<zzbfv> zzgcd;

    public zzchc(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<zzeg> zzelj3, zzelj<zzbbd> zzelj4, zzelj<zza> zzelj5, zzelj<zzbfv> zzelj6) {
        this.zzere = zzelj;
        this.zzfnr = zzelj2;
        this.zzfvq = zzelj3;
        this.zzfro = zzelj4;
        this.zzgaz = zzelj5;
        this.zzgcd = zzelj6;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzchb(this.zzere.get(), this.zzfnr.get(), this.zzfvq.get(), this.zzfro.get(), this.zzgaz.get(), this.zzgcd.get());
    }
}
