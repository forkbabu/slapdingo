package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzfr<K> extends zzey<K> {
    private final transient zzeu<K, ?> zza;
    private final transient zzeq<K> zzb;

    zzfr(zzeu<K, ?> zzeu, zzeq<K> zzeq) {
        this.zza = zzeu;
        this.zzb = zzeq;
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean zzh() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final zzfz<K> zzb() {
        return (zzfz) zzc().iterator();
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzer
    public final int zzb(Object[] objArr, int i) {
        return zzc().zzb(objArr, i);
    }

    @Override // com.google.android.gms.internal.measurement.zzey, com.google.android.gms.internal.measurement.zzer
    public final zzeq<K> zzc() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.measurement.zzer
    public final boolean contains(@NullableDecl Object obj) {
        return this.zza.get(obj) != null;
    }

    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.measurement.zzey, java.util.AbstractCollection, com.google.android.gms.internal.measurement.zzer, java.util.Collection, java.util.Set, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }
}
