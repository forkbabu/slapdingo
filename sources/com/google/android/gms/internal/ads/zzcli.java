package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Clock;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcli implements zzela<zzclj> {
    private final zzelj<Clock> zzfmf;

    public zzcli(zzelj<Clock> zzelj) {
        this.zzfmf = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzclj(this.zzfmf.get());
    }
}
