package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcoi implements zzela<zzcoj> {
    private final zzelj<Context> zzere;
    private final zzelj<zzavy> zzfkb;

    private zzcoi(zzelj<Context> zzelj, zzelj<zzavy> zzelj2) {
        this.zzere = zzelj;
        this.zzfkb = zzelj2;
    }

    public static zzcoi zzar(zzelj<Context> zzelj, zzelj<zzavy> zzelj2) {
        return new zzcoi(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcoj(this.zzere.get(), this.zzfkb.get());
    }
}
