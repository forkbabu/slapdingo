package com.google.android.gms.internal.vision;

import com.itextpdf.text.html.HtmlTags;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzdl<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzmb = new Map.Entry[0];
    private transient zzdo<Map.Entry<K, V>> zzmc;
    private transient zzdo<K> zzmd;
    private transient zzdh<V> zzme;

    public static <K, V> zzdl<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4) {
        zzdf.zza(k, v);
        zzdf.zza(k2, v2);
        zzdf.zza(k3, v3);
        zzdf.zza(k4, v4);
        return zzdq.zza(4, new Object[]{k, v, k2, v2, k3, v3, k4, v4});
    }

    @Override // java.util.Map
    public abstract V get(@NullableDecl Object obj);

    /* access modifiers changed from: package-private */
    public abstract zzdo<Map.Entry<K, V>> zzcf();

    /* access modifiers changed from: package-private */
    public abstract zzdo<K> zzcg();

    /* access modifiers changed from: package-private */
    public abstract zzdh<V> zzch();

    zzdl() {
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
        return ((zzdh) values()).contains(obj);
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
        return zzdt.zza((zzdo) entrySet());
    }

    public String toString() {
        int size = size();
        if (size >= 0) {
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
        StringBuilder sb2 = new StringBuilder(HtmlTags.SIZE.length() + 40);
        sb2.append(HtmlTags.SIZE);
        sb2.append(" cannot be negative but was: ");
        sb2.append(size);
        throw new IllegalArgumentException(sb2.toString());
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzdo<Map.Entry<K, V>> zzdo = this.zzmc;
        if (zzdo != null) {
            return zzdo;
        }
        zzdo<Map.Entry<K, V>> zzcf = zzcf();
        this.zzmc = zzcf;
        return zzcf;
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzdh<V> zzdh = this.zzme;
        if (zzdh != null) {
            return zzdh;
        }
        zzdh<V> zzch = zzch();
        this.zzme = zzch;
        return zzch;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzdo<K> zzdo = this.zzmd;
        if (zzdo != null) {
            return zzdo;
        }
        zzdo<K> zzcg = zzcg();
        this.zzmd = zzcg;
        return zzcg;
    }
}
