package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbuq implements zzela<zzbuo> {
    private final zzelj<zzdkk> zzfkx;
    private final zzelj<Set<zzbyg<zzbup>>> zzfnx;

    private zzbuq(zzelj<Set<zzbyg<zzbup>>> zzelj, zzelj<zzdkk> zzelj2) {
        this.zzfnx = zzelj;
        this.zzfkx = zzelj2;
    }

    public static zzbuq zzt(zzelj<Set<zzbyg<zzbup>>> zzelj, zzelj<zzdkk> zzelj2) {
        return new zzbuq(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbuo(this.zzfnx.get(), this.zzfkx.get());
    }
}
