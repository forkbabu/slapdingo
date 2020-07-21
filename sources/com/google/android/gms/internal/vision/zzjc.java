package com.google.android.gms.internal.vision;

import java.util.Iterator;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzjc extends zzji {
    private final /* synthetic */ zzjb zzaaq;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzjc(zzjb zzjb) {
        super(zzjb, null);
        this.zzaaq = zzjb;
    }

    @Override // com.google.android.gms.internal.vision.zzji, java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzjd(this.zzaaq, null);
    }

    /* synthetic */ zzjc(zzjb zzjb, zzja zzja) {
        this(zzjb);
    }
}
