package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public abstract class zzdsr<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] zzhlt = new Object[0];

    zzdsr() {
    }

    public abstract boolean contains(@NullableDecl Object obj);

    /* renamed from: zzawg */
    public abstract zzdtn<E> iterator();

    /* access modifiers changed from: package-private */
    @NullableDecl
    public Object[] zzawh() {
        return null;
    }

    /* access modifiers changed from: package-private */
    public abstract boolean zzawl();

    public final Object[] toArray() {
        return toArray(zzhlt);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final <T> T[] toArray(T[] tArr) {
        zzdsh.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            Object[] zzawh = zzawh();
            if (zzawh != null) {
                return Arrays.copyOfRange(zzawh, zzawi(), zzawj(), tArr.getClass());
            }
            tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        zza(tArr, 0);
        return tArr;
    }

    /* access modifiers changed from: package-private */
    public int zzawi() {
        throw new UnsupportedOperationException();
    }

    /* access modifiers changed from: package-private */
    public int zzawj() {
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

    public zzdss<E> zzawk() {
        return isEmpty() ? zzdss.zzawm() : zzdss.zzc(toArray());
    }

    /* access modifiers changed from: package-private */
    public int zza(Object[] objArr, int i) {
        zzdtn zzdtn = (zzdtn) iterator();
        while (zzdtn.hasNext()) {
            objArr[i] = zzdtn.next();
            i++;
        }
        return i;
    }
}
