package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcyw implements zzela<zzcyu> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzcnf> zzggk;

    public zzcyw(zzelj<Executor> zzelj, zzelj<zzcnf> zzelj2) {
        this.zzerc = zzelj;
        this.zzggk = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcyu(this.zzerc.get(), this.zzggk.get());
    }
}
