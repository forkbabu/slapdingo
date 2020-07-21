package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbor implements zzela<zzboi> {
    private final zzelj<zzbpa> zzewi;
    private final zzelj<Runnable> zzfhh;
    private final zzelj<zzafn> zzfmj;
    private final zzelj<Executor> zzfnr;

    public zzbor(zzelj<zzbpa> zzelj, zzelj<zzafn> zzelj2, zzelj<Runnable> zzelj3, zzelj<Executor> zzelj4) {
        this.zzewi = zzelj;
        this.zzfmj = zzelj2;
        this.zzfhh = zzelj3;
        this.zzfnr = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzboi(this.zzewi.get(), this.zzfmj.get(), this.zzfhh.get(), this.zzfnr.get());
    }
}
