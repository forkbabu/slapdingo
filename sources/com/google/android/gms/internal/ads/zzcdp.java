package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcdp implements zzela<zzcdn> {
    private final zzelj<zzcgr> zzewj;
    private final zzelj<Clock> zzfmf;

    public zzcdp(zzelj<zzcgr> zzelj, zzelj<Clock> zzelj2) {
        this.zzewj = zzelj;
        this.zzfmf = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcdn(this.zzewj.get(), this.zzfmf.get());
    }
}
