package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcky implements zzela<zzckx> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzclc> zzery;

    public zzcky(zzelj<zzclc> zzelj, zzelj<Executor> zzelj2) {
        this.zzery = zzelj;
        this.zzerc = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzckx(this.zzery.get(), this.zzerc.get());
    }
}
