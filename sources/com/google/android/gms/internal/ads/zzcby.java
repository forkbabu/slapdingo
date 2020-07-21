package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcby implements zzela<zzbmh> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<Clock> zzfmf;
    private final zzelj<zzqn> zzfvv;

    public zzcby(zzelj<zzqn> zzelj, zzelj<Executor> zzelj2, zzelj<Context> zzelj3, zzelj<Clock> zzelj4) {
        this.zzfvv = zzelj;
        this.zzerc = zzelj2;
        this.zzere = zzelj3;
        this.zzfmf = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbmh) zzelg.zza(new zzbmh(this.zzerc.get(), new zzbls(this.zzere.get(), this.zzfvv.get()), this.zzfmf.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
