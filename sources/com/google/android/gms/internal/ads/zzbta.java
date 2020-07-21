package com.google.android.gms.internal.ads;

import java.util.Set;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbta implements zzela<zzbss> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzbsw> zzewc;
    private final zzelj<Set<zzbyg<zzbsp>>> zzfnx;

    private zzbta(zzelj<zzbsw> zzelj, zzelj<Set<zzbyg<zzbsp>>> zzelj2, zzelj<Executor> zzelj3) {
        this.zzewc = zzelj;
        this.zzfnx = zzelj2;
        this.zzerc = zzelj3;
    }

    public static zzbta zzi(zzelj<zzbsw> zzelj, zzelj<Set<zzbyg<zzbsp>>> zzelj2, zzelj<Executor> zzelj3) {
        return new zzbta(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbss(this.zzewc.get(), this.zzfnx.get(), this.zzerc.get());
    }
}
