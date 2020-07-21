package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzein extends zzeit {
    private final /* synthetic */ zzeim zziiq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzein(zzeim zzeim) {
        super(zzeim, null);
        this.zziiq = zzeim;
    }

    @Override // com.google.android.gms.internal.ads.zzeit, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzeio(this.zziiq, null);
    }

    /* synthetic */ zzein(zzeim zzeim, zzeil zzeil) {
        this(zzeim);
    }
}
