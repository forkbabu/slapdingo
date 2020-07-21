package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcev implements zzela<zzcet> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzazq> zzfbr;
    private final zzelj<Clock> zzfmf;

    public zzcev(zzelj<zzazq> zzelj, zzelj<Clock> zzelj2, zzelj<Executor> zzelj3) {
        this.zzfbr = zzelj;
        this.zzfmf = zzelj2;
        this.zzerc = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcet(this.zzfbr.get(), this.zzfmf.get(), this.zzerc.get());
    }
}
