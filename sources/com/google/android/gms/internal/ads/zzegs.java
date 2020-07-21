package com.google.android.gms.internal.ads;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzegs<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzegq> zzifw;

    private zzegs(Map.Entry<K, zzegq> entry) {
        this.zzifw = entry;
    }

    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zzifw.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zzifw.getValue() == null) {
            return null;
        }
        return zzegq.zzbge();
    }

    public final zzegq zzbgf() {
        return this.zzifw.getValue();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzehl) {
            return this.zzifw.getValue().zzn((zzehl) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }
}
