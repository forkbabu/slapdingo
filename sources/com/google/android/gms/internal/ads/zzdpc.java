package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdpc implements zzela<zzdot> {
    private final zzelj<Set<zzbyg<zzdpa>>> zzfnx;

    private zzdpc(zzelj<Set<zzbyg<zzdpa>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzdpc zzar(zzelj<Set<zzbyg<zzdpa>>> zzelj) {
        return new zzdpc(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdot(this.zzfnx.get());
    }
}
