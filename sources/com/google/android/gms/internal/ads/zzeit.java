package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
class zzeit extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzeim zziiq;

    private zzeit(zzeim zzeim) {
        this.zziiq = zzeim;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzeiu(this.zziiq, null);
    }

    public int size() {
        return this.zziiq.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zziiq.get(entry.getKey());
        Object value = entry.getValue();
        if (obj2 != value) {
            return obj2 != null && obj2.equals(value);
        }
        return true;
    }

    public boolean remove(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (!contains(entry)) {
            return false;
        }
        this.zziiq.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zziiq.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zziiq.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzeit(zzeim zzeim, zzeil zzeil) {
        this(zzeim);
    }
}
