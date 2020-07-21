package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzfp<K, V> extends zzey<Map.Entry<K, V>> {
    private final transient zzeu<K, V> zza;
    /* access modifiers changed from: private */
    public final transient Object[] zzb;
    private final transient int zzc = 0;
    /* access modifiers changed from: private */
    public final transient int zzd;

    zzfp(zzeu<K, V> zzeu, Object[] objArr, int i, int i2) {
        this.zza = zzeu;
        this.zzb = objArr;
        this.zzd = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final zzfz<Map.Entry<K, V>> zzb() {
        return (zzfz) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzb(Object[] objArr, int i) {
        return zzc().zzb(objArr, i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzey
    public final zzeq<Map.Entry<K, V>> zzd() {
        return new zzfo(this);
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            K key = entry.getKey();
            V value = entry.getValue();
            if (value == null || !value.equals(this.zza.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.measurement.zzey, java.util.AbstractCollection, com.google.android.gms.internal.measurement.zzer, java.util.Collection, java.util.Set, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
