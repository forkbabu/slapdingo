package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblz implements zzela<zzblu> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzalw> zzfmc;
    private final zzelj<zzbls> zzfmd;
    private final zzelj<zzblp> zzfme;
    private final zzelj<Clock> zzfmf;

    private zzblz(zzelj<zzalw> zzelj, zzelj<zzbls> zzelj2, zzelj<Executor> zzelj3, zzelj<zzblp> zzelj4, zzelj<Clock> zzelj5) {
        this.zzfmc = zzelj;
        this.zzfmd = zzelj2;
        this.zzerc = zzelj3;
        this.zzfme = zzelj4;
        this.zzfmf = zzelj5;
    }

    public static zzblz zza(zzelj<zzalw> zzelj, zzelj<zzbls> zzelj2, zzelj<Executor> zzelj3, zzelj<zzblp> zzelj4, zzelj<Clock> zzelj5) {
        return new zzblz(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzblu(this.zzfmc.get(), this.zzfmd.get(), this.zzerc.get(), this.zzfme.get(), this.zzfmf.get());
    }
}
