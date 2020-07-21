package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrr implements zzela<zzbro> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdkk> zzfos;
    private final zzelj<zzaqp> zzfqx;

    private zzbrr(zzelj<Context> zzelj, zzelj<zzdkk> zzelj2, zzelj<zzaqp> zzelj3) {
        this.zzere = zzelj;
        this.zzfos = zzelj2;
        this.zzfqx = zzelj3;
    }

    public static zzbrr zzh(zzelj<Context> zzelj, zzelj<zzdkk> zzelj2, zzelj<zzaqp> zzelj3) {
        return new zzbrr(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbro(this.zzere.get(), this.zzfos.get(), this.zzfqx.get());
    }
}
