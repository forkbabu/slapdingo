package com.google.android.gms.internal.clearcut;

import java.util.ArrayList;
import java.util.List;

final class zzeb<E> extends zzav<E> {
    private static final zzeb<Object> zznf;
    private final List<E> zzls;

    static {
        zzeb<Object> zzeb = new zzeb<>();
        zznf = zzeb;
        zzeb.zzv();
    }

    zzeb() {
        this(new ArrayList(10));
    }

    private zzeb(List<E> list) {
        this.zzls = list;
    }

    public static <E> zzeb<E> zzcn() {
        return zznf;
    }

    @Override // java.util.List, com.google.android.gms.internal.clearcut.zzav, java.util.AbstractList
    public final void add(int i, E e) {
        zzw();
        this.zzls.add(i, e);
        this.modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E get(int i) {
        return this.zzls.get(i);
    }

    @Override // java.util.List, com.google.android.gms.internal.clearcut.zzav, java.util.AbstractList
    public final E remove(int i) {
        zzw();
        E remove = this.zzls.remove(i);
        this.modCount++;
        return remove;
    }

    @Override // java.util.List, com.google.android.gms.internal.clearcut.zzav, java.util.AbstractList
    public final E set(int i, E e) {
        zzw();
        E e2 = this.zzls.set(i, e);
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.zzls.size();
    }

    @Override // com.google.android.gms.internal.clearcut.zzcn
    public final /* synthetic */ zzcn zzi(int i) {
        if (i >= size()) {
            ArrayList arrayList = new ArrayList(i);
            arrayList.addAll(this.zzls);
            return new zzeb(arrayList);
        }
        throw new IllegalArgumentException();
    }
}
