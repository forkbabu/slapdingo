package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcgn implements zzela<zzcgl> {
    private final zzelj<zzcdg> zzeww;
    private final zzelj<Context> zzfqq;
    private final zzelj<zzcck> zzfvp;
    private final zzelj<zzccd> zzgbk;

    private zzcgn(zzelj<Context> zzelj, zzelj<zzcck> zzelj2, zzelj<zzcdg> zzelj3, zzelj<zzccd> zzelj4) {
        this.zzfqq = zzelj;
        this.zzfvp = zzelj2;
        this.zzeww = zzelj3;
        this.zzgbk = zzelj4;
    }

    public static zzcgn zzb(zzelj<Context> zzelj, zzelj<zzcck> zzelj2, zzelj<zzcdg> zzelj3, zzelj<zzccd> zzelj4) {
        return new zzcgn(zzelj, zzelj2, zzelj3, zzelj4);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcgl(this.zzfqq.get(), this.zzfvp.get(), this.zzeww.get(), this.zzgbk.get());
    }
}
