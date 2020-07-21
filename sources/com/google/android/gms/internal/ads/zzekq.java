package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzekq<E> extends AbstractList<E> {
    private static final zzeks zzdc = zzeks.zzn(zzekq.class);
    List<E> zzipg;
    Iterator<E> zziph;

    public zzekq(List<E> list, Iterator<E> it2) {
        this.zzipg = list;
        this.zziph = it2;
    }

    @Override // java.util.List, java.util.AbstractList
    public E get(int i) {
        if (this.zzipg.size() > i) {
            return this.zzipg.get(i);
        }
        if (this.zziph.hasNext()) {
            this.zzipg.add(this.zziph.next());
            return get(i);
        }
        throw new NoSuchElementException();
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, java.lang.Iterable
    public Iterator<E> iterator() {
        return new zzekp(this);
    }

    public int size() {
        zzdc.zzii("potentially expensive size() call");
        zzdc.zzii("blowup running");
        while (this.zziph.hasNext()) {
            this.zzipg.add(this.zziph.next());
        }
        return this.zzipg.size();
    }
}
