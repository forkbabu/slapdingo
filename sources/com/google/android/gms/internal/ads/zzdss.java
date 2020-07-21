package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public abstract class zzdss<E> extends zzdsr<E> implements List<E>, RandomAccess {
    private static final zzdtm<Object> zzhlu = new zzdsu(zzdtc.zzhmf, 0);

    public static <E> zzdss<E> zzawm() {
        return zzdtc.zzhmf;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final zzdss<E> zzawk() {
        return this;
    }

    public static <E> zzdss<E> zzac(E e) {
        Object[] objArr = {e};
        for (int i = 0; i <= 0; i++) {
            zzdtd.zzd(objArr[0], 0);
        }
        return zzb(objArr, 1);
    }

    public static <E> zzdss<E> zzh(Iterable<? extends E> iterable) {
        zzdsh.checkNotNull(iterable);
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            if (collection instanceof zzdsr) {
                zzdss<E> zzawk = ((zzdsr) collection).zzawk();
                if (!zzawk.zzawl()) {
                    return zzawk;
                }
                Object[] array = zzawk.toArray();
                return zzb(array, array.length);
            }
            Object[] array2 = collection.toArray();
            int length = array2.length;
            for (int i = 0; i < length; i++) {
                zzdtd.zzd(array2[i], i);
            }
            return zzb(array2, array2.length);
        }
        Iterator<? extends E> it2 = iterable.iterator();
        if (!it2.hasNext()) {
            return zzdtc.zzhmf;
        }
        E next = it2.next();
        if (!it2.hasNext()) {
            return zzac(next);
        }
        zzdsv zzdsv = (zzdsv) ((zzdsv) new zzdsv().zzab(next)).zza(it2);
        zzdsv.zzhls = true;
        return zzb(zzdsv.zzhlr, zzdsv.size);
    }

    public static <E> zzdss<E> zzb(E[] eArr) {
        if (eArr.length == 0) {
            return zzdtc.zzhmf;
        }
        Object[] objArr = (Object[]) eArr.clone();
        int length = objArr.length;
        for (int i = 0; i < length; i++) {
            zzdtd.zzd(objArr[i], i);
        }
        return zzb(objArr, objArr.length);
    }

    static <E> zzdss<E> zzc(Object[] objArr) {
        return zzb(objArr, objArr.length);
    }

    static <E> zzdss<E> zzb(Object[] objArr, int i) {
        if (i == 0) {
            return zzdtc.zzhmf;
        }
        return new zzdtc(objArr, i);
    }

    zzdss() {
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final zzdtn<E> zzawg() {
        return (zzdtm) listIterator();
    }

    public int indexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            int size = size();
            int i = 0;
            if (obj == null) {
                while (i < size) {
                    if (get(i) == null) {
                        return i;
                    }
                    i++;
                }
            } else {
                while (i < size) {
                    if (obj.equals(get(i))) {
                        return i;
                    }
                    i++;
                }
            }
            return -1;
        }
        ListIterator<E> listIterator = listIterator();
        while (listIterator.hasNext()) {
            if (zzdse.equal(obj, listIterator.next())) {
                return listIterator.previousIndex();
            }
        }
        return -1;
    }

    public int lastIndexOf(@NullableDecl Object obj) {
        if (obj == null) {
            return -1;
        }
        if (this instanceof RandomAccess) {
            if (obj == null) {
                for (int size = size() - 1; size >= 0; size--) {
                    if (get(size) == null) {
                        return size;
                    }
                }
            } else {
                for (int size2 = size() - 1; size2 >= 0; size2--) {
                    if (obj.equals(get(size2))) {
                        return size2;
                    }
                }
            }
            return -1;
        }
        ListIterator<E> listIterator = listIterator(size());
        while (listIterator.hasPrevious()) {
            if (zzdse.equal(obj, listIterator.previous())) {
                return listIterator.nextIndex();
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public boolean contains(@NullableDecl Object obj) {
        return indexOf(obj) >= 0;
    }

    /* renamed from: zzu */
    public zzdss<E> subList(int i, int i2) {
        zzdsh.zzf(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return zzdtc.zzhmf;
        }
        return new zzdsx(this, i, i3);
    }

    @Override // java.util.List
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.List
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public int zza(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == zzdsh.checkNotNull(this)) {
            return true;
        }
        if (obj instanceof List) {
            List list = (List) obj;
            int size = size();
            if (size == list.size()) {
                if (!(this instanceof RandomAccess) || !(list instanceof RandomAccess)) {
                    zzdss zzdss = this;
                    int size2 = zzdss.size();
                    Iterator<E> it2 = list.iterator();
                    int i = 0;
                    while (true) {
                        if (i < size2) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            E e = zzdss.get(i);
                            i++;
                            if (!zzdse.equal(e, it2.next())) {
                                break;
                            }
                        } else if (!it2.hasNext()) {
                            return true;
                        }
                    }
                } else {
                    int i2 = 0;
                    while (i2 < size) {
                        if (zzdse.equal(get(i2), list.get(i2))) {
                            i2++;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        int size = size();
        int i = 1;
        for (int i2 = 0; i2 < size; i2++) {
            i = ~(~((i * 31) + get(i2).hashCode()));
        }
        return i;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.ads.zzdsr, java.util.Collection, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator(int i) {
        zzdsh.zzt(i, size());
        if (isEmpty()) {
            return zzhlu;
        }
        return new zzdsu(this, i);
    }

    @Override // java.util.List
    public /* synthetic */ ListIterator listIterator() {
        return (zzdtm) listIterator(0);
    }
}
