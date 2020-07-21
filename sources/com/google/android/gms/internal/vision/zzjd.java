package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzjd implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzjb zzaaq;
    private Iterator<Map.Entry<K, V>> zzaar;

    private zzjd(zzjb zzjb) {
        this.zzaaq = zzjb;
        this.pos = this.zzaaq.zzaal.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzaaq.zzaal.size()) || zzid().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzid() {
        if (this.zzaar == null) {
            this.zzaar = this.zzaaq.zzaao.entrySet().iterator();
        }
        return this.zzaar;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzid().hasNext()) {
            return (Map.Entry) zzid().next();
        }
        List zzb = this.zzaaq.zzaal;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzjd(zzjb zzjb, zzja zzja) {
        this(zzjb);
    }
}
