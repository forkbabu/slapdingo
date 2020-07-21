package com.google.android.gms.internal.vision;

import java.util.Map;

/* access modifiers changed from: package-private */
/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzjg implements Comparable<zzjg>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzjb zzaaq;
    private final K zzaau;

    zzjg(zzjb zzjb, Map.Entry<K, V> entry) {
        this(zzjb, entry.getKey(), entry.getValue());
    }

    zzjg(zzjb zzjb, K k, V v) {
        this.zzaaq = zzjb;
        this.zzaau = k;
        this.value = v;
    }

    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzaaq.zzib();
        V v2 = this.value;
        this.value = v;
        return v2;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return equals(this.zzaau, entry.getKey()) && equals(this.value, entry.getValue());
    }

    public final int hashCode() {
        K k = this.zzaau;
        int i = 0;
        int hashCode = k == null ? 0 : k.hashCode();
        V v = this.value;
        if (v != null) {
            i = v.hashCode();
        }
        return hashCode ^ i;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzaau);
        String valueOf2 = String.valueOf(this.value);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length());
        sb.append(valueOf);
        sb.append("=");
        sb.append(valueOf2);
        return sb.toString();
    }

    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzaau;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzjg zzjg) {
        return ((Comparable) getKey()).compareTo((Comparable) zzjg.getKey());
    }
}
