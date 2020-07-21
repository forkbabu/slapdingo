package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzjj implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzjb zzaaq;
    private Iterator<Map.Entry<K, V>> zzaar;
    private boolean zzaav;

    private zzjj(zzjb zzjb) {
        this.zzaaq = zzjb;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zzaaq.zzaal.size() || (!this.zzaaq.zzaam.isEmpty() && zzid().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zzaav) {
            this.zzaav = false;
            this.zzaaq.zzib();
            if (this.pos < this.zzaaq.zzaal.size()) {
                zzjb zzjb = this.zzaaq;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzjb.zzbw(i);
                return;
            }
            zzid().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzid() {
        if (this.zzaar == null) {
            this.zzaar = this.zzaaq.zzaam.entrySet().iterator();
        }
        return this.zzaar;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzaav = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zzaaq.zzaal.size()) {
            return (Map.Entry) this.zzaaq.zzaal.get(this.pos);
        }
        return (Map.Entry) zzid().next();
    }

    /* synthetic */ zzjj(zzjb zzjb, zzja zzja) {
        this(zzjb);
    }
}
