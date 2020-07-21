package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbsx implements zzela<zzbsw> {
    private final zzelj<Set<zzbyg<zzbsz>>> zzfnx;

    private zzbsx(zzelj<Set<zzbyg<zzbsz>>> zzelj) {
        this.zzfnx = zzelj;
    }

    public static zzbsx zzh(zzelj<Set<zzbyg<zzbsz>>> zzelj) {
        return new zzbsx(zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbsw(this.zzfnx.get());
    }
}
