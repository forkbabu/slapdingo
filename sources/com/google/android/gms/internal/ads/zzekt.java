package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
abstract class zzekt<K, V, V2> implements zzela<Map<K, V2>> {
    private final Map<K, zzelj<V>> zzipq;

    zzekt(Map<K, zzelj<V>> map) {
        this.zzipq = Collections.unmodifiableMap(map);
    }

    /* access modifiers changed from: package-private */
    public final Map<K, zzelj<V>> zzbjf() {
        return this.zzipq;
    }
}
