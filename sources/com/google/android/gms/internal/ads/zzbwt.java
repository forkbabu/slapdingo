package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbwt implements zzela<zzbwo> {
    private final zzelj<Set<zzbyg<zzbww>>> zzfnx;

    private zzbwt(zzelj<Set<zzbyg<zzbww>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbwt zzs(zzelj<Set<zzbyg<zzbww>>> zzelj) {
        return new zzbwt(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbwo(this.zzfnx.get());
    }
}
