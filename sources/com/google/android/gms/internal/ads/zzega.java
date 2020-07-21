package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzega extends zzeel<Float> implements zzegm<Float>, zzehx, RandomAccess {
    private static final zzega zziee;
    private int size;
    private float[] zzief;

    zzega() {
        this(new float[10], 0);
    }

    private zzega(float[] fArr, int i) {
        this.zzief = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbda();
        if (i2 >= i) {
            float[] fArr = this.zzief;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzega)) {
            return super.equals(obj);
        }
        zzega zzega = (zzega) obj;
        if (this.size != zzega.size) {
            return false;
        }
        float[] fArr = zzega.zzief;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzief[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzief[i2]);
        }
        return i;
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zzief[i] == floatValue) {
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

    public final void zzh(float f) {
        zzbda();
        int i = this.size;
        float[] fArr = this.zzief;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzief = fArr2;
        }
        float[] fArr3 = this.zzief;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.ads.zzeel
    public final boolean addAll(Collection<? extends Float> collection) {
        zzbda();
        zzegd.checkNotNull(collection);
        if (!(collection instanceof zzega)) {
            return super.addAll(collection);
        }
        zzega zzega = (zzega) collection;
        int i = zzega.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzief;
            if (i3 > fArr.length) {
                this.zzief = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzega.zzief, 0, this.zzief, this.size, zzega.size);
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
            if (obj.equals(Float.valueOf(this.zzief[i]))) {
                float[] fArr = this.zzief;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Float set(int i, Float f) {
        float floatValue = f.floatValue();
        zzbda();
        zzfq(i);
        float[] fArr = this.zzief;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ Float remove(int i) {
        zzbda();
        zzfq(i);
        float[] fArr = this.zzief;
        float f = fArr[i];
        int i2 = this.size;
        if (i < i2 - 1) {
            System.arraycopy(fArr, i + 1, fArr, i, (i2 - i) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, java.lang.Object] */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ void add(int i, Float f) {
        int i2;
        float floatValue = f.floatValue();
        zzbda();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfr(i));
        }
        float[] fArr = this.zzief;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzief, i, fArr2, i + 1, this.size - i);
            this.zzief = fArr2;
        }
        this.zzief[i] = floatValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ boolean add(Float f) {
        zzh(f.floatValue());
        return true;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzegm' to match base method */
    @Override // com.google.android.gms.internal.ads.zzegm
    public final /* synthetic */ zzegm<Float> zzfs(int i) {
        if (i >= this.size) {
            return new zzega(Arrays.copyOf(this.zzief, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzfq(i);
        return Float.valueOf(this.zzief[i]);
    }

    static {
        zzega zzega = new zzega(new float[0], 0);
        zziee = zzega;
        zzega.zzbcz();
    }
}
