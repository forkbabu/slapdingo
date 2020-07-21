package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.Predicate;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzajy implements Predicate {
    private final zzahc zzdfq;

    zzajy(zzahc zzahc) {
        this.zzdfq = zzahc;
    }

    @Override // com.google.android.gms.common.util.Predicate
    public final boolean apply(Object obj) {
        zzahc zzahc = (zzahc) obj;
        return (zzahc instanceof zzakf) && ((zzakf) zzahc).zzdfw.equals(this.zzdfq);
    }
}
