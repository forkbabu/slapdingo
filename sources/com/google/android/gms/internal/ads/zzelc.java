package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzelc<K, V> extends zzekt<K, V, V> {
    private static final zzelj<Map<Object, Object>> zzipw = zzekz.zzba(Collections.emptyMap());

    public static <K, V> zzele<K, V> zzib(int i) {
        return new zzele<>(i);
    }

    private zzelc(Map<K, zzelj<V>> map) {
        super(map);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        LinkedHashMap zzhz = zzekv.zzhz(zzbjf().size());
        for (Map.Entry<K, zzelj<V>> entry : zzbjf().entrySet()) {
            zzhz.put(entry.getKey(), entry.getValue().get());
        }
        return Collections.unmodifiableMap(zzhz);
    }
}
