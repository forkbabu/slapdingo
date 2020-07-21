package com.google.android.gms.internal.vision;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzhz<K, V> {
    static <K, V> void zza(zzgf zzgf, zzhy<K, V> zzhy, K k, V v) throws IOException {
        zzgn.zza(zzgf, zzhy.zzzb, 1, k);
        zzgn.zza(zzgf, zzhy.zzzd, 2, v);
    }

    static <K, V> int zza(zzhy<K, V> zzhy, K k, V v) {
        return zzgn.zza(zzhy.zzzb, 1, k) + zzgn.zza(zzhy.zzzd, 2, v);
    }
}
