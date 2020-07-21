package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbym implements zzela<zzbyk> {
    private final zzelj<Set<zzbyg<zzbyp>>> zzfnx;

    private zzbym(zzelj<Set<zzbyg<zzbyp>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbym zzu(zzelj<Set<zzbyg<zzbyp>>> zzelj) {
        return new zzbym(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbyk(this.zzfnx.get());
    }
}
