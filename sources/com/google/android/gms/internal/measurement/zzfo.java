package com.google.android.gms.internal.measurement;

import java.util.AbstractMap;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzfo extends zzeq<Map.Entry<K, V>> {
    private final /* synthetic */ zzfp zza;

    zzfo(zzfp zzfp) {
        this.zza = zzfp;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return true;
    }

    public final int size() {
        return this.zza.zzd;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzdq.zza(i, this.zza.zzd);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zza.zzb[i2], this.zza.zzb[i2 + 1]);
    }
}
