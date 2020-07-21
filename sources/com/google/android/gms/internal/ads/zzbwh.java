package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbwh implements zzela<zzbwg> {
    private final zzelj<Set<zzbyg<zzbwk>>> zzfnx;

    private zzbwh(zzelj<Set<zzbyg<zzbwk>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbwh zzq(zzelj<Set<zzbyg<zzbwk>>> zzelj) {
        return new zzbwh(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbwg(this.zzfnx.get());
    }
}
