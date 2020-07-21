package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbwe implements zzela<zzbwc> {
    private final zzelj<Set<zzbyg<zzbwd>>> zzfnx;

    private zzbwe(zzelj<Set<zzbyg<zzbwd>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbwe zzp(zzelj<Set<zzbyg<zzbwd>>> zzelj) {
        return new zzbwe(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbwc(this.zzfnx.get());
    }
}
