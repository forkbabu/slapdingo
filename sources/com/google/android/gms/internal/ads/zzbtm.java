package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbtm implements zzela<zzbtf> {
    private final zzelj<Set<zzbyg<zzbtg>>> zzfnx;

    private zzbtm(zzelj<Set<zzbyg<zzbtg>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbtm zzj(zzelj<Set<zzbyg<zzbtg>>> zzelj) {
        return new zzbtm(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbtf(this.zzfnx.get());
    }
}
