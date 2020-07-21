package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdaq implements zzela<zzdao> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;

    private zzdaq(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2) {
        this.zzerc = zzelj;
        this.zzere = zzelj2;
    }

    public static zzdaq zzaz(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2) {
        return new zzdaq(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdao(this.zzerc.get(), this.zzere.get());
    }
}
