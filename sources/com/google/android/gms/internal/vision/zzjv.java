package com.google.android.gms.internal.vision;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzjv implements Iterator<String> {
    private final /* synthetic */ zzjt zzabc;
    private Iterator<String> zzaby = this.zzabc.zzabd.iterator();

    zzjv(zzjt zzjt) {
        this.zzabc = zzjt;
    }

    public final boolean hasNext() {
        return this.zzaby.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zzaby.next();
    }
}
