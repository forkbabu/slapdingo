package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeep extends zzeel<Boolean> implements zzegm<Boolean>, zzehx, RandomAccess {
    private static final zzeep zzhzs;
    private int size;
    private boolean[] zzhzt;

    zzeep() {
        this(new boolean[10], 0);
    }

    private zzeep(boolean[] zArr, int i) {
        this.zzhzt = zArr;
        this.size = i;
    }

    /* access modifiers changed from: protected */
    public final void removeRange(int i, int i2) {
        zzbda();
        if (i2 >= i) {
            boolean[] zArr = this.zzhzt;
            System.arraycopy(zArr, i2, zArr, i, this.size - i2);
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
        if (!(obj instanceof zzeep)) {
            return super.equals(obj);
        }
        zzeep zzeep = (zzeep) obj;
        if (this.size != zzeep.size) {
            return false;
        }
        boolean[] zArr = zzeep.zzhzt;
        for (int i = 0; i < this.size; i++) {
            if (this.zzhzt[i] != zArr[i]) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzeel
    public final int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < this.size; i2++) {
            i = (i * 31) + zzegd.zzbu(this.zzhzt[i2]);
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
            if (this.zzhzt[i] == booleanValue) {
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
        zzbda();
        int i = this.size;
        boolean[] zArr = this.zzhzt;
        if (i == zArr.length) {
            boolean[] zArr2 = new boolean[(((i * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            this.zzhzt = zArr2;
        }
        boolean[] zArr3 = this.zzhzt;
        int i2 = this.size;
        this.size = i2 + 1;
        zArr3[i2] = z;
    }

    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, com.google.android.gms.internal.ads.zzeel
    public final boolean addAll(Collection<? extends Boolean> collection) {
        zzbda();
        zzegd.checkNotNull(collection);
        if (!(collection instanceof zzeep)) {
            return super.addAll(collection);
        }
        zzeep zzeep = (zzeep) collection;
        int i = zzeep.size;
        if (i == 0) {
            return false;
        }
        int i2 = this.size;
        if (Integer.MAX_VALUE - i2 >= i) {
            int i3 = i2 + i;
            boolean[] zArr = this.zzhzt;
            if (i3 > zArr.length) {
                this.zzhzt = Arrays.copyOf(zArr, i3);
            }
            System.arraycopy(zzeep.zzhzt, 0, this.zzhzt, this.size, zzeep.size);
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
            if (obj.equals(Boolean.valueOf(this.zzhzt[i]))) {
                boolean[] zArr = this.zzhzt;
                System.arraycopy(zArr, i + 1, zArr, i, (this.size - i) - 1);
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
    public final /* synthetic */ Boolean set(int i, Boolean bool) {
        boolean booleanValue = bool.booleanValue();
        zzbda();
        zzfq(i);
        boolean[] zArr = this.zzhzt;
        boolean z = zArr[i];
        zArr[i] = booleanValue;
        return Boolean.valueOf(z);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ Boolean remove(int i) {
        zzbda();
        zzfq(i);
        boolean[] zArr = this.zzhzt;
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
    @Override // java.util.List, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ void add(int i, Boolean bool) {
        int i2;
        boolean booleanValue = bool.booleanValue();
        zzbda();
        if (i < 0 || i > (i2 = this.size)) {
            throw new IndexOutOfBoundsException(zzfr(i));
        }
        boolean[] zArr = this.zzhzt;
        if (i2 < zArr.length) {
            System.arraycopy(zArr, i, zArr, i + 1, i2 - i);
        } else {
            boolean[] zArr2 = new boolean[(((i2 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i);
            System.arraycopy(this.zzhzt, i, zArr2, i + 1, this.size - i);
            this.zzhzt = zArr2;
        }
        this.zzhzt[i] = booleanValue;
        this.size++;
        this.modCount++;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.util.AbstractCollection, java.util.List, java.util.Collection, java.util.AbstractList, com.google.android.gms.internal.ads.zzeel
    public final /* synthetic */ boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    /* Return type fixed from 'com.google.android.gms.internal.ads.zzegm' to match base method */
    @Override // com.google.android.gms.internal.ads.zzegm
    public final /* synthetic */ zzegm<Boolean> zzfs(int i) {
        if (i >= this.size) {
            return new zzeep(Arrays.copyOf(this.zzhzt, i), this.size);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.List, java.util.AbstractList
    public final /* synthetic */ Object get(int i) {
        zzfq(i);
        return Boolean.valueOf(this.zzhzt[i]);
    }

    static {
        zzeep zzeep = new zzeep(new boolean[0], 0);
        zzhzs = zzeep;
        zzeep.zzbcz();
    }
}
