package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzgz extends zzfc<Integer> implements zzhe<Integer>, zzit, RandomAccess {
    private static final zzgz zzxu;
    private int size;
    private int[] zzxv;

    public static zzgz zzgm() {
        return zzxu;
    }

    zzgz() {
        this(new int[10], 0);
    }

    private zzgz(int[] iArr, int i) {
        this.zzxv = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdr();
        if (i2 >= i) {
            int[] iArr = this.zzxv;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
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
        if (!(obj instanceof zzgz)) {
            return super.equals(obj);
        }
        zzgz zzgz = (zzgz) obj;
        if (this.size != zzgz.size) {
            return false;
        }
        int[] iArr = zzgz.zzxv;
        for (int i = 0; i < this.size; i++) {
            if (this.zzxv[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zzxv[i2];
        }
        return i;
    }

    public final int getInt(int i) {
        zzaf(i);
        return this.zzxv[i];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzxv[i] == intValue) {
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

    public final void zzbm(int i) {
        zzdr();
        int i2 = this.size;
        int[] iArr = this.zzxv;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zzxv = iArr2;
        }
        int[] iArr3 = this.zzxv;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzdr();
        zzgy.checkNotNull(collection);
        if (!(collection instanceof zzgz)) {
            return super.addAll(collection);
        }
        zzgz zzgz = (zzgz) collection;
        int i = zzgz.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zzxv;
            if (i3 > iArr.length) {
                this.zzxv = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzgz.zzxv, 0, this.zzxv, this.size, zzgz.size);
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
            if (obj.equals(Integer.valueOf(this.zzxv[i]))) {
                int[] iArr = this.zzxv;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Integer set(int i, Integer num) {
        int intValue = num.intValue();
        zzdr();
        zzaf(i);
        int[] iArr = this.zzxv;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ Integer remove(int i) {
        zzdr();
        zzaf(i);
        int[] iArr = this.zzxv;
        int i2 = iArr[i];
        int i3 = this.size;
        if (i < i3 - 1) {
            System.arraycopy(iArr, i + 1, iArr, i, (i3 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i2);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ void add(int i, Integer num) {
        int i2;
        int intValue = num.intValue();
        zzdr();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
        int[] iArr = this.zzxv;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zzxv, i, iArr2, i + 1, this.size - i);
            this.zzxv = iArr2;
        }
        this.zzxv[i] = intValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Integer num) {
        zzbm(num.intValue());
        return true;
    }

    /* Return type fixed from 'com.google.android.gms.internal.vision.zzhe' to match base method */
    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe<Integer> zzah(int i) {
        if (i >= this.size) {
            return new zzgz(Arrays.copyOf(this.zzxv, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzgz zzgz = new zzgz(new int[0], 0);
        zzxu = zzgz;
        zzgz.zzdq();
    }
}
