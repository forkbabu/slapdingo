package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeiu implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzeim zziiq;
    private Iterator<Map.Entry<K, V>> zziir;
    private boolean zziiv;

    private zzeiu(zzeim zzeim) {
        this.zziiq = zzeim;
        this.pos = -1;
    }

    public final boolean hasNext() {
        if (this.pos + 1 < this.zziiq.zziil.size() || (!this.zziiq.zziim.isEmpty() && zzbho().hasNext())) {
            return true;
        }
        return false;
    }

    public final void remove() {
        if (this.zziiv) {
            this.zziiv = false;
            this.zziiq.zzbhm();
            if (this.pos < this.zziiq.zziil.size()) {
                zzeim zzeim = this.zziiq;
                int i = this.pos;
                this.pos = i - 1;
                Object unused = zzeim.zzhp(i);
                return;
            }
            zzbho().remove();
            return;
        }
        throw new IllegalStateException("remove() was called before next()");
    }

    private final Iterator<Map.Entry<K, V>> zzbho() {
        if (this.zziir == null) {
            this.zziir = this.zziiq.zziim.entrySet().iterator();
        }
        return this.zziir;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zziiv = true;
        int i = this.pos + 1;
        this.pos = i;
        if (i < this.zziiq.zziil.size()) {
            return (Map.Entry) this.zziiq.zziil.get(this.pos);
        }
        return (Map.Entry) zzbho().next();
    }

    /* synthetic */ zzeiu(zzeim zzeim, zzeil zzeil) {
        this(zzeim);
    }
}
