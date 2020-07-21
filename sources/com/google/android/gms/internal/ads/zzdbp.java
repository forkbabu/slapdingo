package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbp implements zzela<zzdbn> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;

    private zzdbp(zzelj<Context> zzelj, zzelj<zzdvi> zzelj2) {
        this.zzere = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzdbp zzbb(zzelj<Context> zzelj, zzelj<zzdvi> zzelj2) {
        return new zzdbp(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdbn(this.zzere.get(), this.zzerc.get());
    }
}
