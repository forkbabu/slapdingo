package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbyh implements zzela<zzbyc> {
    private final zzelj<Set<zzbyg<zzbyd>>> zzfnx;

    private zzbyh(zzelj<Set<zzbyg<zzbyd>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbyh zzt(zzelj<Set<zzbyg<zzbyd>>> zzelj) {
        return new zzbyh(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbyc(this.zzfnx.get());
    }
}
