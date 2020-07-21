package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Collection;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
class zzdsq<E> extends zzdst<E> {
    int size = 0;
    Object[] zzhlr;
    boolean zzhls;

    zzdsq(int i) {
        zzdsm.zzj(i, "initialCapacity");
        this.zzhlr = new Object[i];
    }

    private final void zzel(int i) {
        Object[] objArr = this.zzhlr;
        if (objArr.length < i) {
            int length = objArr.length;
            if (i >= 0) {
                int i2 = length + (length >> 1) + 1;
                if (i2 < i) {
                    i2 = Integer.highestOneBit(i - 1) << 1;
                }
                if (i2 < 0) {
                    i2 = Integer.MAX_VALUE;
                }
                this.zzhlr = Arrays.copyOf(objArr, i2);
                this.zzhls = false;
                return;
            }
            throw new AssertionError("cannot store more than MAX_VALUE elements");
        } else if (this.zzhls) {
            this.zzhlr = (Object[]) objArr.clone();
            this.zzhls = false;
        }
    }

    /* renamed from: zzaa */
    public zzdsq<E> zzab(E e) {
        zzdsh.checkNotNull(e);
        zzel(this.size + 1);
        Object[] objArr = this.zzhlr;
        int i = this.size;
        this.size = i + 1;
        objArr[i] = e;
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public zzdst<E> zzg(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            Collection collection = (Collection) iterable;
            zzel(this.size + collection.size());
            if (collection instanceof zzdsr) {
                this.size = ((zzdsr) collection).zza(this.zzhlr, this.size);
                return this;
            }
        }
        super.zzg(iterable);
        return this;
    }
}
