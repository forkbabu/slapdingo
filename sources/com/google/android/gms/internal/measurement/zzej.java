package com.google.android.gms.internal.measurement;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@17.4.4 */
final class zzej extends AbstractSet<Map.Entry<K, V>> {
    private final /* synthetic */ zzef zza;

    zzej(zzef zzef) {
        this.zza = zzef;
    }

    public final int size() {
        return this.zza.size();
    }

    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set, java.lang.Iterable
    public final Iterator<Map.Entry<K, V>> iterator() {
        return this.zza.zzf();
    }

    public final boolean contains(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int zzb2 = this.zza.zza(entry.getKey());
            if (zzb2 == -1 || !zzdo.zza(this.zza.zzc[zzb2], entry.getValue())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final boolean remove(@NullableDecl Object obj) {
        Map zzb = this.zza.zzb();
        if (zzb != null) {
            return zzb.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (this.zza.zza()) {
            return false;
        }
        int zzb2 = this.zza.zzi();
        int zza2 = zzem.zza(entry.getKey(), entry.getValue(), zzb2, this.zza.zze, this.zza.zza, this.zza.zzb, this.zza.zzc);
        if (zza2 == -1) {
            return false;
        }
        this.zza.zza(zza2, zzb2);
        zzef.zzd(this.zza);
        this.zza.zzc();
        return true;
    }
}
