package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzekp implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzekq zzipf;

    zzekp(zzekq zzekq) {
        this.zzipf = zzekq;
    }

    public final boolean hasNext() {
        return this.pos < this.zzipf.zzipg.size() || this.zzipf.zziph.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.pos >= this.zzipf.zzipg.size()) {
            this.zzipf.zzipg.add(this.zzipf.zziph.next());
        }
        List<E> list = this.zzipf.zzipg;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
