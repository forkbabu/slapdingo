package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbsm implements zzela<zzbsk> {
    private final zzelj<Set<zzbyg<zzuu>>> zzfnx;

    private zzbsm(zzelj<Set<zzbyg<zzuu>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbsm zzg(zzelj<Set<zzbyg<zzuu>>> zzelj) {
        return new zzbsm(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbsk(this.zzfnx.get());
    }
}
