package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzdp<K, V> extends zzdo<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient zzdl<K, V> zzmj;
    /* access modifiers changed from: private */
    public final transient Object[] zzmk;
    private final transient int zzml = 0;

    zzdp(zzdl<K, V> zzdl, Object[] objArr, int i, int i2) {
        this.zzmj = zzdl;
        this.zzmk = objArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    public final zzdw<Map.Entry<K, V>> zzbz() {
        return (zzdw) zzcd().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final int zza(Object[] objArr, int i) {
        return zzcd().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdo
    public final zzdk<Map.Entry<K, V>> zzci() {
        return new zzds(this);
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            K key = entry.getKey();
            V value = entry.getValue();
            if (value == null || !value.equals(this.zzmj.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.vision.zzdo, java.util.Collection, java.util.Set, com.google.android.gms.internal.vision.zzdh, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
