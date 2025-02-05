package com.google.android.gms.internal.measurement;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
abstract class zzei<T> implements Iterator<T> {
    private int zza;
    private int zzb;
    private int zzc;
    private final /* synthetic */ zzef zzd;

    private zzei(zzef zzef) {
        this.zzd = zzef;
        this.zza = this.zzd.zzf;
        this.zzb = this.zzd.zzd();
        this.zzc = -1;
    }

    /* access modifiers changed from: package-private */
    public abstract T zza(int i);

    public boolean hasNext() {
        return this.zzb >= 0;
    }

    @Override // java.util.Iterator
    public T next() {
        zza();
        if (hasNext()) {
            int i = this.zzb;
            this.zzc = i;
            T zza2 = zza(i);
            this.zzb = this.zzd.zza(this.zzb);
            return zza2;
        }
        throw new NoSuchElementException();
    }

    public void remove() {
        zza();
        zzdq.zzb(this.zzc >= 0, "no calls to next() since the last call to remove()");
        this.zza += 32;
        zzef zzef = this.zzd;
        zzef.remove(zzef.zzb[this.zzc]);
        this.zzb = zzef.zzb(this.zzb, this.zzc);
        this.zzc = -1;
    }

    private final void zza() {
        if (this.zzd.zzf != this.zza) {
            throw new ConcurrentModificationException();
        }
    }

    /* synthetic */ zzei(zzef zzef, zzee zzee) {
        this(zzef);
    }
}
