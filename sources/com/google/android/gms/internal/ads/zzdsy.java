package com.google.android.gms.internal.ads;

import java.util.Arrays;
import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdsy<E> extends zzdsq<E> {
    private int zzahp;
    @NullableDecl
    private Object[] zzhmb;

    public zzdsy() {
        super(4);
    }

    zzdsy(int i) {
        super(i);
        this.zzhmb = new Object[zzdsz.zzem(i)];
    }

    public final zzdsz<E> zzawq() {
        zzdsz<E> zzdsz;
        int i = this.size;
        if (i == 0) {
            return zzdti.zzhmn;
        }
        if (i == 1) {
            return zzdsz.zzad(this.zzhlr[0]);
        }
        if (this.zzhmb == null || zzdsz.zzem(this.size) != this.zzhmb.length) {
            zzdsz = zzdsz.zza(this.size, this.zzhlr);
            this.size = zzdsz.size();
        } else {
            Object[] copyOf = zzdsz.zzv(this.size, this.zzhlr.length) ? Arrays.copyOf(this.zzhlr, this.size) : this.zzhlr;
            int i2 = this.zzahp;
            Object[] objArr = this.zzhmb;
            zzdsz = new zzdti<>(copyOf, i2, objArr, objArr.length - 1, this.size);
        }
        this.zzhls = true;
        this.zzhmb = null;
        return zzdsz;
    }

    @Override // com.google.android.gms.internal.ads.zzdsq, com.google.android.gms.internal.ads.zzdst
    public final /* synthetic */ zzdst zzg(Iterable iterable) {
        zzdsh.checkNotNull(iterable);
        if (this.zzhmb != null) {
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                zzab(it2.next());
            }
        } else {
            super.zzg(iterable);
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdsq
    public final /* synthetic */ zzdsq zzaa(Object obj) {
        return (zzdsy) zzab(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdst
    public final /* synthetic */ zzdst zza(Iterator it2) {
        zzdsh.checkNotNull(it2);
        while (it2.hasNext()) {
            zzab(it2.next());
        }
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzdsq, com.google.android.gms.internal.ads.zzdst
    public final /* synthetic */ zzdst zzab(Object obj) {
        zzdsh.checkNotNull(obj);
        if (this.zzhmb != null) {
            int zzem = zzdsz.zzem(this.size);
            Object[] objArr = this.zzhmb;
            if (zzem <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int zzek = zzdso.zzek(hashCode);
                while (true) {
                    int i = zzek & length;
                    Object[] objArr2 = this.zzhmb;
                    Object obj2 = objArr2[i];
                    if (obj2 != null) {
                        if (obj2.equals(obj)) {
                            break;
                        }
                        zzek = i + 1;
                    } else {
                        objArr2[i] = obj;
                        this.zzahp += hashCode;
                        super.zzab(obj);
                        break;
                    }
                }
                return this;
            }
        }
        this.zzhmb = null;
        super.zzab(obj);
        return this;
    }
}
