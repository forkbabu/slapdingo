package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzfk extends zzfc<Boolean> implements zzhe<Boolean>, zzit, RandomAccess {
    private static final zzfk zzsh;
    private int size;
    private boolean[] zzsi;

    zzfk() {
        this(new boolean[10], 0);
    }

    private zzfk(boolean[] zArr, int i) {
        this.zzsi = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdr();
        if (i2 >= i) {
            boolean[] zArr = this.zzsi;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzfk)) {
            return super.equals(obj);
        }
        zzfk zzfk = (zzfk) obj;
        if (this.size != zzfk.size) {
            return false;
        }
        boolean[] zArr = zzfk.zzsi;
        for (int i = 0; i < this.size; i++) {
            if (this.zzsi[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzgy.zzm(this.zzsi[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzsi[i] == booleanValue) {
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

    public final void addBoolean(boolean z) {
        zzdr();
        int i = this.size;
        boolean[] zArr = this.zzsi;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzsi = zArr2;
        }
        boolean[] zArr3 = this.zzsi;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzdr();
        zzgy.checkNotNull(collection);
        if (!(collection instanceof zzfk)) {
            return super.addAll(collection);
        }
        zzfk zzfk = (zzfk) collection;
        int i = zzfk.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzsi;
            if (i3 > zArr.length) {
                this.zzsi = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzfk.zzsi, 0, this.zzsi, this.size, zzfk.size);
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
            if (obj.equals(Boolean.valueOf(this.zzsi[i]))) {
                boolean[] zArr = this.zzsi;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Boolean set(int i, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        zzdr();
        zzaf(i);
        boolean[] zArr = this.zzsi;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ Boolean remove(int i) {
        zzdr();
        zzaf(i);
        boolean[] zArr = this.zzsi;
        boolean z = zArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(zArr, i + 1, zArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ void add(int i, Boolean bool) {
        int i2;
        boolean booleanValue = bool.booleanValue();
        zzdr();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
        boolean[] zArr = this.zzsi;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzsi, i, zArr2, i + 1, this.size - i);
            this.zzsi = zArr2;
        }
        this.zzsi[i] = booleanValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    /* Return type fixed from 'com.google.android.gms.internal.vision.zzhe' to match base method */
    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe<Boolean> zzah(int i) {
        if (i >= this.size) {
            return new zzfk(Arrays.copyOf(this.zzsi, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzaf(i);
        return Boolean.valueOf(this.zzsi[i]);
    }

    static {
        zzfk zzfk = new zzfk(new boolean[0], 0);
        zzsh = zzfk;
        zzfk.zzdq();
    }
}
