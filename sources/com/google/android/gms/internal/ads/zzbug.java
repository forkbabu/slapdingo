package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbug implements zzela<zzbue> {
    private final zzelj<Set<zzbyg<zzbuf>>> zzfnx;

    private zzbug(zzelj<Set<zzbyg<zzbuf>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbug zzn(zzelj<Set<zzbyg<zzbuf>>> zzelj) {
        return new zzbug(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbue(this.zzfnx.get());
    }
}
