package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
final class zzdtg<K> extends zzdsz<K> {
    private final transient zzdss<K> zzhlv;
    private final transient zzdsw<K, ?> zzhmh;

    zzdtg(zzdsw<K, ?> zzdsw, zzdss<K> zzdss) {
        this.zzhmh = zzdsw;
        this.zzhlv = zzdss;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean zzawl() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final zzdtn<K> zzawg() {
        return (zzdtn) zzawk().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzdsr
    public final int zza(Object[] objArr, int i) {
        return zzawk().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdsr, com.google.android.gms.internal.ads.zzdsz
    public final zzdss<K> zzawk() {
        return this.zzhlv;
    }

    @Override // com.google.android.gms.internal.ads.zzdsr
    public final boolean contains(@NullableDecl Object obj) {
        return this.zzhmh.get(obj) != null;
    }

    public final int size() {
        return this.zzhmh.size();
    }

    @Override // java.util.AbstractCollection, com.google.android.gms.internal.ads.zzdsr, java.util.Collection, java.util.Set, java.lang.Iterable, com.google.android.gms.internal.ads.zzdsz
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
