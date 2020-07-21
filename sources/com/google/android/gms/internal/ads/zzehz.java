package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzehz<E> extends zzeel<E> implements RandomAccess {
    private static final zzehz<Object> zzihl;
    private int size;
    private E[] zzhmg;

    public static <E> zzehz<E> zzbgy() {
        return zzihl;
    }

    zzehz() {
        this(new Object[10], 0);
    }

    private zzehz(E[] eArr, int i) {
        this.zzhmg = eArr;
        this.size = i;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final boolean add(E e) {
        zzbda();
        int i = this.size;
        E[] eArr = this.zzhmg;
        if (i == eArr.length) {
            this.zzhmg = Arrays.copyOf(eArr, ((i * 3) / 2) + 1);
        }
        E[] eArr2 = this.zzhmg;
        int i2 = this.size;
        this.size = i2 + 1;
        eArr2[i2] = e;
        this.modCount++;
        return true;
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final void add(int i, E e) {
        int i2;
        zzbda();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfr(i));
        }
        E[] eArr = this.zzhmg;
        if (i2 < eArr.length) {
            System.arraycopy(eArr, i, eArr, i + 1, i2 - i);
        } else {
            E[] eArr2 = new Object[(((i2 * 3) / 2) + 1)];
            System.arraycopy(eArr, 0, eArr2, 0, i);
            System.arraycopy(this.zzhmg, i, eArr2, i + 1, this.size - i);
            this.zzhmg = eArr2;
        }
        this.zzhmg[i] = e;
        this.size++;
        this.modCount++;
    }

    @Override // java.util.List, java.util.AbstractList
    public final E get(int i) {
        zzfq(i);
        return this.zzhmg[i];
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final E remove(int i) {
        zzbda();
        zzfq(i);
        E[] eArr = this.zzhmg;
        E e = eArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(eArr, i + 1, eArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return e;
    }

    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final E set(int i, E e) {
        zzbda();
        zzfq(i);
        E[] eArr = this.zzhmg;
        E e2 = eArr[i];
        eArr[i] = e;
        this.modCount++;
        return e2;
    }

    public final int size() {
        return this.size;
    }

    private final void zzfq(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzfr(i));
        }
    }

    private final String zzfr(int i) {
        int i2 = this.size;
        StringBuilder sb = new StringBuilder(35);
        sb.append("Index:");
        sb.append(i);
        sb.append(", Size:");
        sb.append(i2);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzegm
    public final /* synthetic */ zzegm zzfs(int i) {
        if (i >= this.size) {
            return new zzehz(Arrays.copyOf(this.zzhmg, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    static {
        zzehz<Object> zzehz = new zzehz<>(new Object[0], 0);
        zzihl = zzehz;
        zzehz.zzbcz();
    }
}
