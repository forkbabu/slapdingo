package com.google.android.gms.internal.vision;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzdr<K> extends zzdo<K> {
    private final transient zzdk<K> zzlz;
    private final transient zzdl<K, ?> zzmj;

    zzdr(zzdl<K, ?> zzdl, zzdk<K> zzdk) {
        this.zzmj = zzdl;
        this.zzlz = zzdk;
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    public final zzdw<K> zzbz() {
        return (zzdw) zzcd().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzdh
    public final int zza(Object[] objArr, int i) {
        return zzcd().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.vision.zzdo, com.google.android.gms.internal.vision.zzdh
    public final zzdk<K> zzcd() {
        return this.zzlz;
    }

    @Override // com.google.android.gms.internal.vision.zzdh
    public final boolean contains(@NullableDecl Object obj) {
        return this.zzmj.get(obj) != null;
    }

    public final int size() {
        return this.zzmj.size();
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.vision.zzdo, java.util.Collection, java.util.Set, com.google.android.gms.internal.vision.zzdh, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
