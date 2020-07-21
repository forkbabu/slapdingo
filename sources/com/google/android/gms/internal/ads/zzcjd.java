package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcjd implements zzela<zzciz> {
    private final zzelj<Executor> zzerc;

    public zzcjd(zzelj<Executor> zzelj) {
        this.zzerc = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzciz(this.zzerc.get());
    }
}
