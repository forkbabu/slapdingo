package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzefm extends zzeel<Double> implements zzegm<Double>, zzehx, RandomAccess {
    private static final zzefm zziba;
    private int size;
    private double[] zzibb;

    zzefm() {
        this(new double[10], 0);
    }

    private zzefm(double[] dArr, int i) {
        this.zzibb = dArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbda();
        if (i2 >= i) {
            double[] dArr = this.zzibb;
            System.arraycopy(dArr, i2, dArr, i, this.size - i2);
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
        if (!(obj instanceof zzefm)) {
            return super.equals(obj);
        }
        zzefm zzefm = (zzefm) obj;
        if (this.size != zzefm.size) {
            return false;
        }
        double[] dArr = zzefm.zzibb;
        for (int i = 0; i < this.size; i++) {
            if (Double.doubleToLongBits(this.zzibb[i]) != Double.doubleToLongBits(dArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzegd.zzfr(Double.doubleToLongBits(this.zzibb[i2]));
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
            if (this.zzibb[i] == doubleValue) {
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

    public final void zzd(double d) {
        zzbda();
        int i = this.size;
        double[] dArr = this.zzibb;
        if (i == dArr.length) {
            double[] dArr2 = new double[(((i * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            this.zzibb = dArr2;
        }
        double[] dArr3 = this.zzibb;
        int i2 = this.size;
        this.size = i2 + 1;
        dArr3[i2] = d;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.ads.zzeel
    public final boolean addAll(Collection<? extends Double> collection) {
        zzbda();
        zzegd.checkNotNull(collection);
        if (!(collection instanceof zzefm)) {
            return super.addAll(collection);
        }
        zzefm zzefm = (zzefm) collection;
        int i = zzefm.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            double[] dArr = this.zzibb;
            if (i3 > dArr.length) {
                this.zzibb = Arrays.copyOf(dArr, i3);
            }
            System.arraycopy(zzefm.zzibb, 0, this.zzibb, this.size, zzefm.size);
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
            if (obj.equals(Double.valueOf(this.zzibb[i]))) {
                double[] dArr = this.zzibb;
                System.arraycopy(dArr, i + 1, dArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Double set(int i, Double d) {
        double doubleValue = d.doubleValue();
        zzbda();
        zzfq(i);
        double[] dArr = this.zzibb;
        double d2 = dArr[i];
        dArr[i] = doubleValue;
        return Double.valueOf(d2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ Double remove(int i) {
        zzbda();
        zzfq(i);
        double[] dArr = this.zzibb;
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
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ void add(int i, Double d) {
        int i2;
        double doubleValue = d.doubleValue();
        zzbda();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfr(i));
        }
        double[] dArr = this.zzibb;
        if (i2 < dArr.length) {
            System.arraycopy(dArr, i, dArr, i + 1, i2 - i);
        } else {
            double[] dArr2 = new double[(((i2 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i);
            System.arraycopy(this.zzibb, i, dArr2, i + 1, this.size - i);
            this.zzibb = dArr2;
        }
        this.zzibb[i] = doubleValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ boolean add(Double d) {
        zzd(d.doubleValue());
        return true;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzegm' to match base method */
    @Override // com.google.android.gms.internal.ads.zzegm
    public final /* synthetic */ zzegm<Double> zzfs(int i) {
        if (i >= this.size) {
            return new zzefm(Arrays.copyOf(this.zzibb, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzfq(i);
        return Double.valueOf(this.zzibb[i]);
    }

    static {
        zzefm zzefm = new zzefm(new double[0], 0);
        zziba = zzefm;
        zzefm.zzbcz();
    }
}
