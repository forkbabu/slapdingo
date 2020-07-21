package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdau implements zzela<zzdas> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;

    public zzdau(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2) {
        this.zzerc = zzelj;
        this.zzere = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdas(this.zzerc.get(), this.zzere.get());
    }
}
