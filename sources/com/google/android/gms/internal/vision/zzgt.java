package com.google.android.gms.internal.vision;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzgt extends zzfc<Float> implements zzhe<Float>, zzit, RandomAccess {
    private static final zzgt zzwf;
    private int size;
    private float[] zzwg;

    zzgt() {
        this(new float[10], 0);
    }

    private zzgt(float[] fArr, int i) {
        this.zzwg = fArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzdr();
        if (i2 >= i) {
            float[] fArr = this.zzwg;
            System.arraycopy(fArr, i2, fArr, i, this.size - i2);
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
        if (!(obj instanceof zzgt)) {
            return super.equals(obj);
        }
        zzgt zzgt = (zzgt) obj;
        if (this.size != zzgt.size) {
            return false;
        }
        float[] fArr = zzgt.zzwg;
        for (int i = 0; i < this.size; i++) {
            if (Float.floatToIntBits(this.zzwg[i]) != Float.floatToIntBits(fArr[i])) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.vision.zzfc
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + Float.floatToIntBits(this.zzwg[i2]);
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
            if (this.zzwg[i] == floatValue) {
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

    public final void zzu(float f) {
        zzdr();
        int i = this.size;
        float[] fArr = this.zzwg;
        if (i == fArr.length) {
            float[] fArr2 = new float[(((i * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            this.zzwg = fArr2;
        }
        float[] fArr3 = this.zzwg;
        int i2 = this.size;
        this.size = i2 + 1;
        fArr3[i2] = f;
    }

    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection
    public final boolean addAll(Collection<? extends Float> collection) {
        zzdr();
        zzgy.checkNotNull(collection);
        if (!(collection instanceof zzgt)) {
            return super.addAll(collection);
        }
        zzgt zzgt = (zzgt) collection;
        int i = zzgt.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            float[] fArr = this.zzwg;
            if (i3 > fArr.length) {
                this.zzwg = Arrays.copyOf(fArr, i3);
            }
            System.arraycopy(zzgt.zzwg, 0, this.zzwg, this.size, zzgt.size);
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
            if (obj.equals(Float.valueOf(this.zzwg[i]))) {
                float[] fArr = this.zzwg;
                System.arraycopy(fArr, i + 1, fArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Float set(int i, Float f) {
        float floatValue = f.floatValue();
        zzdr();
        zzaf(i);
        float[] fArr = this.zzwg;
        float f2 = fArr[i];
        fArr[i] = floatValue;
        return Float.valueOf(f2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ Float remove(int i) {
        zzdr();
        zzaf(i);
        float[] fArr = this.zzwg;
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
    @Override // java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.AbstractList
    public final /* synthetic */ void add(int i, Float f) {
        int i2;
        float floatValue = f.floatValue();
        zzdr();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzag(i));
        }
        float[] fArr = this.zzwg;
        if (i2 < fArr.length) {
            System.arraycopy(fArr, i, fArr, i + 1, i2 - i);
        } else {
            float[] fArr2 = new float[(((i2 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i);
            System.arraycopy(this.zzwg, i, fArr2, i + 1, this.size - i);
            this.zzwg = fArr2;
        }
        this.zzwg[i] = floatValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, com.google.android.gms.internal.vision.zzfc, java.util.Collection, java.util.AbstractList
    public final /* synthetic */ boolean add(Float f) {
        zzu(f.floatValue());
        return true;
    }

    /* Return type fixed from 'com.google.android.gms.internal.vision.zzhe' to match base method */
    @Override // com.google.android.gms.internal.vision.zzhe
    public final /* synthetic */ zzhe<Float> zzah(int i) {
        if (i >= this.size) {
            return new zzgt(Arrays.copyOf(this.zzwg, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzaf(i);
        return Float.valueOf(this.zzwg[i]);
    }

    static {
        zzgt zzgt = new zzgt(new float[0], 0);
        zzwf = zzgt;
        zzgt.zzdq();
    }
}
