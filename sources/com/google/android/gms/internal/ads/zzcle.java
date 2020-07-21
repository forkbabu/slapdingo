package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcle implements zzela<zzclc> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzbbe> zzfbe;
    private final zzelj<zzbbd> zzfjy;

    public zzcle(zzelj<Executor> zzelj, zzelj<zzbbe> zzelj2, zzelj<Context> zzelj3, zzelj<zzbbd> zzelj4) {
        this.zzerc = zzelj;
        this.zzfbe = zzelj2;
        this.zzere = zzelj3;
        this.zzfjy = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzclc(this.zzerc.get(), this.zzfbe.get(), this.zzere.get(), this.zzfjy.get());
    }
}
