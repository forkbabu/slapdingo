package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeio implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzeim zziiq;
    private Iterator<Map.Entry<K, V>> zziir;

    private zzeio(zzeim zzeim) {
        this.zziiq = zzeim;
        this.pos = this.zziiq.zziil.size();
    }

    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zziiq.zziil.size()) || zzbho().hasNext();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    private final Iterator<Map.Entry<K, V>> zzbho() {
        if (this.zziir == null) {
            this.zziir = this.zziiq.zziio.entrySet().iterator();
        }
        return this.zziir;
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzbho().hasNext()) {
            return (Map.Entry) zzbho().next();
        }
        List zzb = this.zziiq.zziil;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) zzb.get(i);
    }

    /* synthetic */ zzeio(zzeim zzeim, zzeil zzeil) {
        this(zzeim);
    }
}
