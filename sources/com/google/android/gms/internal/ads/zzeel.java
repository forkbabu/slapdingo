package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
abstract class zzeel<E> extends AbstractList<E> implements zzegm<E> {
    private boolean zzhzk = true;

    zzeel() {
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
        zzbda();
        return super.add(e);
    }

    @Override // java.util.List, java.util.AbstractList
    public void add(int i, E e) {
        zzbda();
        super.add(i, e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        zzbda();
        return super.addAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public boolean addAll(int i, Collection<? extends E> collection) {
        zzbda();
        return super.addAll(i, collection);
    }

    public void clear() {
        zzbda();
        super.clear();
    }

    @Override // com.google.android.gms.internal.ads.zzegm
    public boolean zzbcy() {
        return this.zzhzk;
    }

    @Override // com.google.android.gms.internal.ads.zzegm
    public final void zzbcz() {
        this.zzhzk = false;
    }

    @Override // java.util.List, java.util.AbstractList
    public E remove(int i) {
        zzbda();
        return super.remove(i);
    }

    @Override // java.util.List
    public boolean remove(Object obj) {
        zzbda();
        return super.remove(obj);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean removeAll(Collection<?> collection) {
        zzbda();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection
    public boolean retainAll(Collection<?> collection) {
        zzbda();
        return super.retainAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList
    public E set(int i, E e) {
        zzbda();
        return super.set(i, e);
    }

    /* access modifiers changed from: protected */
    public final void zzbda() {
        if (!this.zzhzk) {
            throw new UnsupportedOperationException();
        }
    }
}
