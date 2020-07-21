package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzegz extends zzeel<Long> implements zzegj, zzehx, RandomAccess {
    private static final zzegz zzigg;
    private int size;
    private long[] zzigh;

    public static zzegz zzbgk() {
        return zzigg;
    }

    zzegz() {
        this(new long[10], 0);
    }

    private zzegz(long[] jArr, int i) {
        this.zzigh = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbda();
        if (i2 >= i) {
            long[] jArr = this.zzigh;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzegz)) {
            return super.equals(obj);
        }
        zzegz zzegz = (zzegz) obj;
        if (this.size != zzegz.size) {
            return false;
        }
        long[] jArr = zzegz.zzigh;
        for (int i = 0; i < this.size; i++) {
            if (this.zzigh[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzegd.zzfr(this.zzigh[i2]);
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzegj
    /* renamed from: zzhc */
    public final zzegj zzfs(int i) {
        if (i >= this.size) {
            return new zzegz(Arrays.copyOf(this.zzigh, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final long getLong(int i) {
        zzfq(i);
        return this.zzigh[i];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzigh[i] == longValue) {
                return i;
            }
        }
        return -1;
    }

    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final int size() {
        return this.size;
    }

    public final void zzfs(long j) {
        zzbda();
        int i = this.size;
        long[] jArr = this.zzigh;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzigh = jArr2;
        }
        long[] jArr3 = this.zzigh;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.ads.zzeel
    public final boolean addAll(Collection<? extends Long> collection) {
        zzbda();
        zzegd.checkNotNull(collection);
        if (!(collection instanceof zzegz)) {
            return super.addAll(collection);
        }
        zzegz zzegz = (zzegz) collection;
        int i = zzegz.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzigh;
            if (i3 > jArr.length) {
                this.zzigh = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzegz.zzigh, 0, this.zzigh, this.size, zzegz.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.List, com.google.android.gms.internal.ads.zzeel
    public final boolean remove(Object obj) {
        zzbda();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzigh[i]))) {
                long[] jArr = this.zzigh;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
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

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ Long set(int i, Long l) {
        long longValue = l.longValue();
        zzbda();
        zzfq(i);
        long[] jArr = this.zzigh;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ Long remove(int i) {
        zzbda();
        zzfq(i);
        long[] jArr = this.zzigh;
        long j = jArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(jArr, i + 1, jArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ void add(int i, Long l) {
        int i2;
        long longValue = l.longValue();
        zzbda();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfr(i));
        }
        long[] jArr = this.zzigh;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzigh, i, jArr2, i + 1, this.size - i);
            this.zzigh = jArr2;
        }
        this.zzigh[i] = longValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ boolean add(Long l) {
        zzfs(l.longValue());
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzegz zzegz = new zzegz(new long[0], 0);
        zzigg = zzegz;
        zzegz.zzbcz();
    }
}
