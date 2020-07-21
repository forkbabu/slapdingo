package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
public class zzew<K, V> extends zzed<K, V> implements Serializable {
    private final transient zzeu<K, ? extends zzer<V>> zza;
    private final transient int zzb;

    zzew(zzeu<K, ? extends zzer<V>> zzeu, int i) {
        this.zza = zzeu;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzea
    public final boolean zza(@NullableDecl Object obj) {
        return obj != null && super.zza(obj);
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.measurement.zzea
    public final Map<K, Collection<V>> zzb() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.android.gms.internal.measurement.zzea
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzea
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.measurement.zzea
    public /* bridge */ /* synthetic */ boolean equals(@NullableDecl Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzfg, com.google.android.gms.internal.measurement.zzea
    public final /* synthetic */ Map zza() {
        return this.zza;
    }
}
