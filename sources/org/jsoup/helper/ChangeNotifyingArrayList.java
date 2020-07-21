package org.jsoup.helper;

import java.util.ArrayList;
import java.util.Collection;

public abstract class ChangeNotifyingArrayList<E> extends ArrayList<E> {
    public abstract void onContentsChanged();

    public ChangeNotifyingArrayList(int i) {
        super(i);
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public E set(int i, E e) {
        onContentsChanged();
        return super.set(i, e);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.util.ArrayList
    public boolean add(E e) {
        onContentsChanged();
        return super.add(e);
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public void add(int i, E e) {
        onContentsChanged();
        super.add(i, e);
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public E remove(int i) {
        onContentsChanged();
        return super.remove(i);
    }

    @Override // java.util.List, java.util.ArrayList
    public boolean remove(Object obj) {
        onContentsChanged();
        return super.remove(obj);
    }

    public void clear() {
        onContentsChanged();
        super.clear();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.ArrayList
    public boolean addAll(Collection<? extends E> collection) {
        onContentsChanged();
        return super.addAll(collection);
    }

    @Override // java.util.List, java.util.AbstractList, java.util.ArrayList
    public boolean addAll(int i, Collection<? extends E> collection) {
        onContentsChanged();
        return super.addAll(i, collection);
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i, int i2) {
        onContentsChanged();
        super.removeRange(i, i2);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.ArrayList
    public boolean removeAll(Collection<?> collection) {
        onContentsChanged();
        return super.removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.ArrayList
    public boolean retainAll(Collection<?> collection) {
        onContentsChanged();
        return super.retainAll(collection);
    }
}
