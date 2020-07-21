package com.google.android.gms.internal.vision;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzds extends zzdk<Map.Entry<K, V>> {
    private final /* synthetic */ zzdp zzmo;

    zzds(zzdp zzdp) {
        this.zzmo = zzdp;
    }

    public final int size() {
        return this.zzmo.size;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzcy.zzd(i, this.zzmo.size);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzmo.zzmk[i2], this.zzmo.zzmk[i2 + 1]);
    }
}
