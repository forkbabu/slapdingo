package com.google.android.gms.internal.vision;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzdh<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzly = new Object[0];

    zzdh() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzbz */
    public abstract zzdw<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzca() {
        return null;
    }

    public final Object[] toArray() {
        return toArray(zzly);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzcy.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzca = zzca();
            if (zzca != null) {
                return Arrays.copyOfRange(zzca, zzcb(), zzcc(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzcb() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzcc() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public zzdk<E> zzcd() {
        return isEmpty() ? zzdk.zzce() : zzdk.zza(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzdw zzdw = (zzdw) iterator();
        while (zzdw.hasNext()) {
            objArr[i] = zzdw.next();
            i++;
        }
        return i;
    }
}
