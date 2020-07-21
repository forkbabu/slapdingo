package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcfm implements zzela<zzcfi> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzcey> zzgat;

    public zzcfm(zzelj<Executor> zzelj, zzelj<zzcey> zzelj2) {
        this.zzerc = zzelj;
        this.zzgat = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcfi(this.zzerc.get(), this.zzgat.get());
    }
}
