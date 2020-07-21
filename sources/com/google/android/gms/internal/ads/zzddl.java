package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzddl implements zzela<zzddj> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzavy> zzfkb;

    private zzddl(zzelj<zzavy> zzelj, zzelj<zzdvi> zzelj2, zzelj<Context> zzelj3) {
        this.zzfkb = zzelj;
        this.zzerc = zzelj2;
        this.zzere = zzelj3;
    }

    public static zzddl zzt(zzelj<zzavy> zzelj, zzelj<zzdvi> zzelj2, zzelj<Context> zzelj3) {
        return new zzddl(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzddj(this.zzfkb.get(), this.zzerc.get(), this.zzere.get());
    }
}
