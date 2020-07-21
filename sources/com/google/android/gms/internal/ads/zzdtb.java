package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdtb extends zzdtn<T> {
    private boolean zzhmd;
    private final /* synthetic */ Object zzhme;

    zzdtb(Object obj) {
        this.zzhme = obj;
    }

    public final boolean hasNext() {
        return !this.zzhmd;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (!this.zzhmd) {
            this.zzhmd = true;
            return this.zzhme;
        }
        throw new NoSuchElementException();
    }
}
