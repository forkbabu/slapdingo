package com.google.android.gms.internal.measurement;

import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzkx implements Iterator<String> {
    private Iterator<String> zza = this.zzb.zza.iterator();
    private final /* synthetic */ zzkv zzb;

    zzkx(zzkv zzkv) {
        this.zzb = zzkv;
    }

    public final boolean hasNext() {
        return this.zza.hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zza.next();
    }
}
