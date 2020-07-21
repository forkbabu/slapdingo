package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeif implements Iterator<zzeey> {
    private final ArrayDeque<zzeie> zzihy;
    private zzeey zzihz;

    private zzeif(zzeer zzeer) {
        if (zzeer instanceof zzeie) {
            zzeie zzeie = (zzeie) zzeer;
            ArrayDeque<zzeie> arrayDeque = new ArrayDeque<>(zzeie.zzbdg());
            this.zzihy = arrayDeque;
            arrayDeque.push(zzeie);
            this.zzihz = zzak(zzeie.zzihu);
            return;
        }
        this.zzihy = null;
        this.zzihz = (zzeey) zzeer;
    }

    private final zzeey zzak(zzeer zzeer) {
        while (zzeer instanceof zzeie) {
            zzeie zzeie = (zzeie) zzeer;
            this.zzihy.push(zzeie);
            zzeer = zzeie.zzihu;
        }
        return (zzeey) zzeer;
    }

    public final boolean hasNext() {
        return this.zzihz != null;
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    @Override // java.util.Iterator
    public final /* synthetic */ zzeey next() {
        zzeey zzeey;
        zzeey zzeey2 = this.zzihz;
        if (zzeey2 != null) {
            while (true) {
                ArrayDeque<zzeie> arrayDeque = this.zzihy;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    zzeey = zzak(this.zzihy.pop().zzihv);
                    if (!zzeey.isEmpty()) {
                        break;
                    }
                } else {
                    zzeey = null;
                }
            }
            zzeey = null;
            this.zzihz = zzeey;
            return zzeey2;
        }
        throw new NoSuchElementException();
    }

    /* synthetic */ zzeif(zzeer zzeer, zzeid zzeid) {
        this(zzeer);
    }
}
