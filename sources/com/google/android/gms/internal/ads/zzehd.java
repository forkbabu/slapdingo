package com.google.android.gms.internal.ads;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzehd<K, V> {
    static <K, V> void zza(zzefl zzefl, zzehg<K, V> zzehg, K k, V v) throws IOException {
        zzefu.zza(zzefl, zzehg.zzigm, 1, k);
        zzefu.zza(zzefl, zzehg.zzigo, 2, v);
    }

    static <K, V> int zza(zzehg<K, V> zzehg, K k, V v) {
        return zzefu.zza(zzehg.zzigm, 1, k) + zzefu.zza(zzehg.zzigo, 2, v);
    }
}
