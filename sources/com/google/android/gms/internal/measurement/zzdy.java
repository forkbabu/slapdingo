package com.google.android.gms.internal.measurement;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
abstract class zzdy<E> extends zzfy<E> {
    private final int zza;
    private int zzb;

    protected zzdy(int i, int i2) {
        zzdq.zzb(i2, i);
        this.zza = i;
        this.zzb = i2;
    }

    /* access modifiers changed from: protected */
    public abstract E zza(int i);

    public final boolean hasNext() {
        return this.zzb < this.zza;
    }

    @Override // java.util.Iterator, java.util.ListIterator
    public final E next() {
        if (hasNext()) {
            int i = this.zzb;
            this.zzb = i + 1;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.zzb;
    }

    public final boolean hasPrevious() {
        return this.zzb > 0;
    }

    @Override // java.util.ListIterator
    public final E previous() {
        if (hasPrevious()) {
            int i = this.zzb - 1;
            this.zzb = i;
            return zza(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.zzb - 1;
    }
}
