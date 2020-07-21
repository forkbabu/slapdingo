package com.google.android.gms.internal.vision;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
abstract class zzfc<E> extends AbstractList<E> implements zzhe<E> {
    private boolean zzry = true;

    zzfc() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof List)) {
            return false;
        }
        if (!(obj instanceof RandomAccess)) {
            return super.equals(obj);
        }
        List list = (List) obj;
        int size = size();
        if (size != list.size()) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!get(i).equals(list.get(i))) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = (i * 31) + get(i2).hashCode();
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList
    public boolean add(E e) {
        zzdr();
        return super.add(e);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        zzdr();
        super.add(i, e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        zzdr();
        return super.addAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends E> collection) {
        zzdr();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzdr();
        super.clear();
    }

    @Override // com.google.android.gms.internal.vision.zzhe
    public boolean zzdp() {
        return this.zzry;
    }

    @Override // com.google.android.gms.internal.vision.zzhe
    public final void zzdq() {
        this.zzry = false;
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        zzdr();
        return super.remove(i);
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        zzdr();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        zzdr();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        zzdr();
        return super.retainAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        zzdr();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzdr() {
        if (!this.zzry) {
            throw new UnsupportedOperationException();
        }
    }
}
