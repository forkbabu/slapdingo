package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcga implements zzela<zzcfp> {
    private final zzelj<Executor> zzfnr;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzchw> zzfzg;

    public zzcga(zzelj<zzdla> zzelj, zzelj<Executor> zzelj2, zzelj<zzchw> zzelj3) {
        this.zzfnz = zzelj;
        this.zzfnr = zzelj2;
        this.zzfzg = zzelj3;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcfp(this.zzfnz.get(), this.zzfnr.get(), this.zzfzg.get());
    }
}
