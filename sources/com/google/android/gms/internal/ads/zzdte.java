package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdte<K, V> extends zzdsz<Map.Entry<K, V>> {
    /* access modifiers changed from: private */
    public final transient int size;
    private final transient zzdsw<K, V> zzhmh;
    /* access modifiers changed from: private */
    public final transient Object[] zzhmi;
    private final transient int zzhmj = 0;

    zzdte(zzdsw<K, V> zzdsw, Object[] objArr, int i, int i2) {
        this.zzhmh = zzdsw;
        this.zzhmi = objArr;
        this.size = i2;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean zzawl() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final zzdtn<Map.Entry<K, V>> zzawg() {
        return (zzdtn) zzawk().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zza(Object[] objArr, int i) {
        return zzawk().zza(objArr, i);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsz
    public final zzdss<Map.Entry<K, V>> zzaws() {
        return new zzdth(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            K key = entry.getKey();
            V value = entry.getValue();
            if (value == null || !value.equals(this.zzhmh.get(key))) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.ads.zzdsr, java.util.Collection, java.util.Set, java.lang.Iterable, com.google.android.gms.internal.ads.zzdsz
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
