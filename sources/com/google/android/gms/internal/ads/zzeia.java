package com.google.android.gms.internal.ads;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeia {
    private static final zzeia zzihm = new zzeia();
    private final zzeik zzihn = new zzehc();
    private final ConcurrentMap<Class<?>, zzeih<?>> zziho = new ConcurrentHashMap();

    public static zzeia zzbgz() {
        return zzihm;
    }

    public final <T> zzeih<T> zzh(Class<T> cls) {
        zzegd.zza(cls, "messageType");
        zzeih<T> zzeih = this.zziho.get(cls);
        if (zzeih != null) {
            return zzeih;
        }
        zzeih<T> zzg = this.zzihn.zzg(cls);
        zzegd.zza(cls, "messageType");
        zzegd.zza(zzg, "schema");
        zzeih<T> putIfAbsent = this.zziho.putIfAbsent(cls, zzg);
        return putIfAbsent != null ? putIfAbsent : zzg;
    }

    public final <T> zzeih<T> zzaw(T t) {
        return zzh(t.getClass());
    }

    private zzeia() {
    }
}
