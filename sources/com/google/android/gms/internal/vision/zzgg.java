package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzgg extends zzfc<Double> implements zzhe<Double>, zzit, RandomAccess {
    private static final zzgg zzti;
    private int size;
    private double[] zztj;

    zzgg() {
        this(new double[10], 0);
    }

    private zzgg(double[] dArr, int i) {
        this.zztj = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdr();
        if (i2 >= i) {
            double[] dArr = this.zztj;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzgg)) {
            return super.equals(obj);
        }
        zzgg zzgg = (zzgg) obj;
        if (this.size != zzgg.size) {
            return false;
        }
        double[] dArr = zzgg.zztj;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zztj[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzgy.zzab(Double.doubleToLongBits(this.zztj[i2]));
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zztj[i] == doubleValue) {
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

    public final void zzc(double d) {
        zzdr();
        int i = this.size;
        double[] dArr = this.zztj;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zztj = dArr2;
        }
        double[] dArr3 = this.zztj;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection
    public final boolean addAll(Collection<? extends Double> collection) {
        zzdr();
        zzgy.checkNotNull(collection);
        if (!(collection instanceof zzgg)) {
            return super.addAll(collection);
        }
        zzgg zzgg = (zzgg) collection;
        int i = zzgg.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zztj;
            if (i3 > dArr.length) {
                this.zztj = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzgg.zztj, 0, this.zztj, this.size, zzgg.size);
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
            if (obj.equals(Double.valueOf(this.zztj[i]))) {
                double[] dArr = this.zztj;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Double set(int i, Double d) {
        double doubleValue = d.doubleValue();
        zzdr();
        zzaf(i);
        double[] dArr = this.zztj;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ Double remove(int i) {
        zzdr();
        zzaf(i);
        double[] dArr = this.zztj;
        double d = dArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(dArr, i + 1, dArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ void add(int i, Double d) {
        int i2;
        double doubleValue = d.doubleValue();
        zzdr();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
        double[] dArr = this.zztj;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zztj, i, dArr2, i + 1, this.size - i);
            this.zztj = dArr2;
        }
        this.zztj[i] = doubleValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Double d) {
        zzc(d.doubleValue());
        return true;
    }

    /* Return type fixed from 'com.google.android.gms.internal.vision.zzhe' to match base method */
    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe<Double> zzah(int i) {
        if (i >= this.size) {
            return new zzgg(Arrays.copyOf(this.zztj, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzaf(i);
        return Double.valueOf(this.zztj[i]);
    }

    static {
        zzgg zzgg = new zzgg(new double[0], 0);
        zzti = zzgg;
        zzgg.zzdq();
    }
}
