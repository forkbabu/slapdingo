package com.google.android.gms.internal.vision;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
class zzji extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzjb zzaaq;

    private zzji(zzjb zzjb) {
        this.zzaaq = zzjb;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public Iterator<Map.Entry<K, V>> iterator() {
        return new zzjj(this.zzaaq, null);
    }

    public int size() {
        return this.zzaaq.size();
    }

    public boolean contains(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        Object obj2 = this.zzaaq.get(entry.getKey());
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
        this.zzaaq.remove(entry.getKey());
        return true;
    }

    public void clear() {
        this.zzaaq.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public /* synthetic */ boolean add(Object obj) {
        Map.Entry entry = (Map.Entry) obj;
        if (contains(entry)) {
            return false;
        }
        this.zzaaq.put((Comparable) entry.getKey(), entry.getValue());
        return true;
    }

    /* synthetic */ zzji(zzjb zzjb, zzja zzja) {
        this(zzjb);
    }
}
