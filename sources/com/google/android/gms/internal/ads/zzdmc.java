package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdmc implements zzela<zzdlx> {
    private final zzelj<zzbbd> zzfmh;
    private final zzelj<Context> zzfqq;
    private final zzelj<zzaxh> zzgrt;

    public zzdmc(zzelj<Context> zzelj, zzelj<zzbbd> zzelj2, zzelj<zzaxh> zzelj3) {
        this.zzfqq = zzelj;
        this.zzfmh = zzelj2;
        this.zzgrt = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdlx(this.zzfqq.get(), this.zzfmh.get(), this.zzgrt.get());
    }
}
