package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdth extends zzdss<Map.Entry<K, V>> {
    private final /* synthetic */ zzdte zzhmm;

    zzdth(zzdte zzdte) {
        this.zzhmm = zzdte;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean zzawl() {
        return true;
    }

    public final int size() {
        return this.zzhmm.size;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzdsh.zzs(i, this.zzhmm.size);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzhmm.zzhmi[i2], this.zzhmm.zzhmi[i2 + 1]);
    }
}
