package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbtx implements zzela<zzbtv> {
    private final zzelj<Set<zzbyg<zzbua>>> zzfnx;

    private zzbtx(zzelj<Set<zzbyg<zzbua>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbtx zzl(zzelj<Set<zzbyg<zzbua>>> zzelj) {
        return new zzbtx(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbtv(this.zzfnx.get());
    }
}
