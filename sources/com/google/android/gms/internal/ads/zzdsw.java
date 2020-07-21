package com.google.android.gms.internal.ads;

import com.itextpdf.text.html.HtmlTags;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public abstract class zzdsw<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzhlw = new Map.Entry[0];
    private transient zzdsz<Map.Entry<K, V>> zzhlx;
    private transient zzdsz<K> zzhly;
    private transient zzdsr<V> zzhlz;

    public static <K, V> zzdsw<K, V> zzc(K k, V v) {
        zzdsm.zzb(k, v);
        return zzdtf.zzc(1, new Object[]{k, v});
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzdsz<Map.Entry<K, V>> zzawn();

    /* access modifiers changed from: package-private */
    public abstract zzdsz<K> zzawo();

    /* access modifiers changed from: package-private */
    public abstract zzdsr<V> zzawp();

    public static <K, V> zzdsw<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        zzdsm.zzb(k, v);
        zzdsm.zzb(k2, v2);
        zzdsm.zzb(k3, v3);
        zzdsm.zzb(k4, v4);
        zzdsm.zzb(k5, v5);
        return zzdtf.zzc(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    zzdsw() {
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean containsKey(@NullableDecl Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(@NullableDecl Object obj) {
        return ((zzdsr) values()).contains(obj);
    }

    @Override // java.util.Map
    public final V getOrDefault(@NullableDecl Object obj, @NullableDecl V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    public boolean equals(@NullableDecl Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    public int hashCode() {
        return zzdtl.zzg((zzdsz) entrySet());
    }

    public String toString() {
        int size = size();
        zzdsm.zzj(size, HtmlTags.SIZE);
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append((Object) entry.getKey());
            sb.append('=');
            sb.append((Object) entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzdsz<Map.Entry<K, V>> zzdsz = this.zzhlx;
        if (zzdsz != null) {
            return zzdsz;
        }
        zzdsz<Map.Entry<K, V>> zzawn = zzawn();
        this.zzhlx = zzawn;
        return zzawn;
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzdsr<V> zzdsr = this.zzhlz;
        if (zzdsr != null) {
            return zzdsr;
        }
        zzdsr<V> zzawp = zzawp();
        this.zzhlz = zzawp;
        return zzawp;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzdsz<K> zzdsz = this.zzhly;
        if (zzdsz != null) {
            return zzdsz;
        }
        zzdsz<K> zzawo = zzawo();
        this.zzhly = zzawo;
        return zzawo;
    }
}
