package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzege extends zzeel<Integer> implements zzegh, zzehx, RandomAccess {
    private static final zzege zzife;
    private int size;
    private int[] zziff;

    public static zzege zzbft() {
        return zzife;
    }

    zzege() {
        this(new int[10], 0);
    }

    private zzege(int[] iArr, int i) {
        this.zziff = iArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbda();
        if (i2 >= i) {
            int[] iArr = this.zziff;
            System.arraycopy(iArr, i2, iArr, i, this.size - i2);
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
        if (!(obj instanceof zzege)) {
            return super.equals(obj);
        }
        zzege zzege = (zzege) obj;
        if (this.size != zzege.size) {
            return false;
        }
        int[] iArr = zzege.zziff;
        for (int i = 0; i < this.size; i++) {
            if (this.zziff[i] != iArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + this.zziff[i2];
        }
        return i;
    }

    @Override // com.google.android.gms.internal.ads.zzegh
    /* renamed from: zzha */
    public final zzegh zzfs(int i) {
        if (i >= this.size) {
            return new zzege(Arrays.copyOf(this.zziff, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    public final int getInt(int i) {
        zzfq(i);
        return this.zziff[i];
    }

    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i = 0; i < size2; i++) {
            if (this.zziff[i] == intValue) {
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

    @Override // com.google.android.gms.internal.ads.zzegh
    public final void zzhb(int i) {
        zzbda();
        int i2 = this.size;
        int[] iArr = this.zziff;
        if (i2 == iArr.length) {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i2);
            this.zziff = iArr2;
        }
        int[] iArr3 = this.zziff;
        int i3 = this.size;
        this.size = i3 + 1;
        iArr3[i3] = i;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.ads.zzeel
    public final boolean addAll(Collection<? extends Integer> collection) {
        zzbda();
        zzegd.checkNotNull(collection);
        if (!(collection instanceof zzege)) {
            return super.addAll(collection);
        }
        zzege zzege = (zzege) collection;
        int i = zzege.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            int[] iArr = this.zziff;
            if (i3 > iArr.length) {
                this.zziff = Arrays.copyOf(iArr, i3);
            }
            System.arraycopy(zzege.zziff, 0, this.zziff, this.size, zzege.size);
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
            if (obj.equals(Integer.valueOf(this.zziff[i]))) {
                int[] iArr = this.zziff;
                System.arraycopy(iArr, i + 1, iArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Integer set(int i, Integer num) {
        int intValue = num.intValue();
        zzbda();
        zzfq(i);
        int[] iArr = this.zziff;
        int i2 = iArr[i];
        iArr[i] = intValue;
        return Integer.valueOf(i2);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ Integer remove(int i) {
        zzbda();
        zzfq(i);
        int[] iArr = this.zziff;
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
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ void add(int i, Integer num) {
        int i2;
        int intValue = num.intValue();
        zzbda();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfr(i));
        }
        int[] iArr = this.zziff;
        if (i2 < iArr.length) {
            System.arraycopy(iArr, i, iArr, i + 1, i2 - i);
        } else {
            int[] iArr2 = new int[(((i2 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i);
            System.arraycopy(this.zziff, i, iArr2, i + 1, this.size - i);
            this.zziff = iArr2;
        }
        this.zziff[i] = intValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ boolean add(Integer num) {
        zzhb(num.intValue());
        return true;
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        return Integer.valueOf(getInt(i));
    }

    static {
        zzege zzege = new zzege(new int[0], 0);
        zzife = zzege;
        zzege.zzbcz();
    }
}
