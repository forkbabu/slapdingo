package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzegr<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzifv;

    public zzegr(Iterator<Map.Entry<K, Object>> it2) {
        this.zzifv = it2;
    }

    public final boolean hasNext() {
        return this.zzifv.hasNext();
    }

    public final void remove() {
        this.zzifv.remove();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzifv.next();
        return next.getValue() instanceof zzegq ? new zzegs(next) : next;
    }
}
