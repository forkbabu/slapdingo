package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzhv extends zzfc<Long> implements zzhe<Long>, zzit, RandomAccess {
    private static final zzhv zzyy;
    private int size;
    private long[] zzyz;

    zzhv() {
        this(new long[10], 0);
    }

    private zzhv(long[] jArr, int i) {
        this.zzyz = jArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdr();
        if (i2 >= i) {
            long[] jArr = this.zzyz;
            System.arraycopy(jArr, i2, jArr, i, this.size - i2);
            this.size -= i2 - i;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzhv)) {
            return super.equals(obj);
        }
        zzhv zzhv = (zzhv) obj;
        if (this.size != zzhv.size) {
            return false;
        }
        long[] jArr = zzhv.zzyz;
        for (int i = 0; i < this.size; i++) {
            if (this.zzyz[i] != jArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzgy.zzab(this.zzyz[i2]);
        }
        return i;
    }

    public final long getLong(int i) {
        zzaf(i);
        return this.zzyz[i];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzyz[i] == longValue) {
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

    public final void zzac(long j) {
        zzdr();
        int i = this.size;
        long[] jArr = this.zzyz;
        if (i == jArr.length) {
            long[] jArr2 = new long[(((i * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            this.zzyz = jArr2;
        }
        long[] jArr3 = this.zzyz;
        int i2 = this.size;
        this.size = i2 + 1;
        jArr3[i2] = j;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection
    public final boolean addAll(Collection<? extends Long> collection) {
        zzdr();
        zzgy.checkNotNull(collection);
        if (!(collection instanceof zzhv)) {
            return super.addAll(collection);
        }
        zzhv zzhv = (zzhv) collection;
        int i = zzhv.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            long[] jArr = this.zzyz;
            if (i3 > jArr.length) {
                this.zzyz = Arrays.copyOf(jArr, i3);
            }
            System.arraycopy(zzhv.zzyz, 0, this.zzyz, this.size, zzhv.size);
            this.size = i3;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc
    public final boolean remove(Object obj) {
        zzdr();
        for (int i = 0; i < this.size; i++) {
            if (obj.equals(Long.valueOf(this.zzyz[i]))) {
                long[] jArr = this.zzyz;
                System.arraycopy(jArr, i + 1, jArr, i, (this.size - i) - 1);
                this.size--;
                this.modCount++;
                return true;
            }
        }
        return false;
    }

    private final void zzaf(int i) {
        if (i < 0 || i >= this.size) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
    }

    private final String zzag(int i) {
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
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ Long set(int i, Long l) {
        long longValue = l.longValue();
        zzdr();
        zzaf(i);
        long[] jArr = this.zzyz;
        long j = jArr[i];
        jArr[i] = longValue;
        return Long.valueOf(j);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ Long remove(int i) {
        zzdr();
        zzaf(i);
        long[] jArr = this.zzyz;
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
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ void add(int i, Long l) {
        int i2;
        long longValue = l.longValue();
        zzdr();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
        long[] jArr = this.zzyz;
        if (i2 < jArr.length) {
            System.arraycopy(jArr, i, jArr, i + 1, i2 - i);
        } else {
            long[] jArr2 = new long[(((i2 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i);
            System.arraycopy(this.zzyz, i, jArr2, i + 1, this.size - i);
            this.zzyz = jArr2;
        }
        this.zzyz[i] = longValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Long l) {
        zzac(l.longValue());
        return true;
    }

    /* Return type fixed from 'com.google.android.gms.internal.vision.zzhe' to match base method */
    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe<Long> zzah(int i) {
        if (i >= this.size) {
            return new zzhv(Arrays.copyOf(this.zzyz, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Long.valueOf(getLong(i));
    }

    static {
        zzhv zzhv = new zzhv(new long[0], 0);
        zzyy = zzhv;
        zzhv.zzdq();
    }
}
