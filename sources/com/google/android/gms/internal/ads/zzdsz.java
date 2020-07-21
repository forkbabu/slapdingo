package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public abstract class zzdsz<E> extends zzdsr<E> implements Set<E> {
    @NullableDecl
    private transient zzdss<E> zzhmc;

    public static <E> zzdsz<E> zzad(E e) {
        return new zzdtk(e);
    }

    /* access modifiers changed from: private */
    public static boolean zzv(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    /* access modifiers changed from: package-private */
    public boolean zzawr() {
        return false;
    }

    @SafeVarargs
    public static <E> zzdsz<E> zza(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        zzdsh.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return zza(length, objArr);
    }

    /* access modifiers changed from: private */
    public static <E> zzdsz<E> zza(int i, Object... objArr) {
        while (i != 0) {
            if (i == 1) {
                return zzad(objArr[0]);
            }
            int zzem = zzem(i);
            Object[] objArr2 = new Object[zzem];
            int i2 = zzem - 1;
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                Object zzd = zzdtd.zzd(objArr[i5], i5);
                int hashCode = zzd.hashCode();
                int zzek = zzdso.zzek(hashCode);
                while (true) {
                    int i6 = zzek & i2;
                    Object obj = objArr2[i6];
                    if (obj != null) {
                        if (obj.equals(zzd)) {
                            break;
                        }
                        zzek++;
                    } else {
                        objArr[i4] = zzd;
                        objArr2[i6] = zzd;
                        i3 += hashCode;
                        i4++;
                        break;
                    }
                }
            }
            Arrays.fill(objArr, i4, i, (Object) null);
            if (i4 == 1) {
                return new zzdtk(objArr[0], i3);
            }
            if (zzem(i4) < zzem / 2) {
                i = i4;
            } else {
                if (zzv(i4, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i4);
                }
                return new zzdti(objArr, i3, objArr2, i2, i4);
            }
        }
        return zzdti.zzhmn;
    }

    static int zzem(int i) {
        int max = Math.max(i, 2);
        boolean z = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z = false;
        }
        zzdsh.checkArgument(z, "collection too large");
        return 1073741824;
    }

    zzdsz() {
    }

    public boolean equals(@NullableDecl Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzdsz) || !zzawr() || !((zzdsz) obj).zzawr() || hashCode() == obj.hashCode()) {
            return zzdtl.zza(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return zzdtl.zzg(this);
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public zzdss<E> zzawk() {
        zzdss<E> zzdss = this.zzhmc;
        if (zzdss != null) {
            return zzdss;
        }
        zzdss<E> zzaws = zzaws();
        this.zzhmc = zzaws;
        return zzaws;
    }

    /* access modifiers changed from: package-private */
    public zzdss<E> zzaws() {
        return zzdss.zzc(toArray());
    }

    public static <E> zzdsy<E> zzen(int i) {
        zzdsm.zzj(i, "expectedSize");
        return new zzdsy<>(i);
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.ads.zzdsr, java.util.Collection, java.util.Set, java.lang.Iterable
    public /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
