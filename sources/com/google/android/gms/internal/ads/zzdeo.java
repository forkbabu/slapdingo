package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdeo implements zzela<zzdem> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;

    private zzdeo(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2) {
        this.zzerc = zzelj;
        this.zzere = zzelj2;
    }

    public static zzdeo zzbi(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2) {
        return new zzdeo(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdem(this.zzerc.get(), this.zzere.get());
    }
}
