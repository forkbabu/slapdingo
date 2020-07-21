package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbtu implements zzela<zzbtl> {
    private final zzelj<Set<zzbyg<zzbsl>>> zzfnx;

    private zzbtu(zzelj<Set<zzbyg<zzbsl>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbtu zzk(zzelj<Set<zzbyg<zzbsl>>> zzelj) {
        return new zzbtu(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbtl(this.zzfnx.get());
    }
}
