package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfm implements zzela<zzdfk> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzta> zzesg;

    public zzdfm(zzelj<zzta> zzelj, zzelj<zzdvi> zzelj2, zzelj<Context> zzelj3) {
        this.zzesg = zzelj;
        this.zzerc = zzelj2;
        this.zzere = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdfk(this.zzesg.get(), this.zzerc.get(), this.zzere.get());
    }
}
