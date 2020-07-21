package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzddp implements zzela<zzddn> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfjy;

    private zzddp(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2, zzelj<zzbbd> zzelj3) {
        this.zzerc = zzelj;
        this.zzere = zzelj2;
        this.zzfjy = zzelj3;
    }

    public static zzddp zzu(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2, zzelj<zzbbd> zzelj3) {
        return new zzddp(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzddn(this.zzerc.get(), this.zzere.get(), this.zzfjy.get());
    }
}
