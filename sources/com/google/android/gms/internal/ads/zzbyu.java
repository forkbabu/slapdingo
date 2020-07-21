package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbyu implements zzela<zzbyq> {
    private final zzelj<Set<zzbyg<zzahm>>> zzfnx;

    public zzbyu(zzelj<Set<zzbyg<zzahm>>> zzelj) {
        this.zzfnx = zzelj;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbyq(this.zzfnx.get());
    }
}
