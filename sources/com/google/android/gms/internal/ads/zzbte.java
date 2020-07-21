package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbte implements zzela<zzbtc> {
    private final zzelj<Set<zzbyg<zzbtd>>> zzfnx;

    private zzbte(zzelj<Set<zzbyg<zzbtd>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbte zzi(zzelj<Set<zzbyg<zzbtd>>> zzelj) {
        return new zzbte(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbtc(this.zzfnx.get());
    }
}
