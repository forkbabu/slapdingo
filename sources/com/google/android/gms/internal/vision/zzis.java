package com.google.android.gms.internal.vision;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzis {
    private static final zzis zzaac = new zzis();
    private final zziz zzaad = new zzhu();
    private final ConcurrentMap<Class<?>, zziw<?>> zzaae = new ConcurrentHashMap();

    public static zzis zzhp() {
        return zzaac;
    }

    public final <T> zziw<T> zzf(Class<T> cls) {
        zzgy.zza(cls, "messageType");
        zziw<T> zziw = this.zzaae.get(cls);
        if (zziw != null) {
            return zziw;
        }
        zziw<T> zze = this.zzaad.zze(cls);
        zzgy.zza(cls, "messageType");
        zzgy.zza(zze, "schema");
        zziw<T> putIfAbsent = this.zzaae.putIfAbsent(cls, zze);
        return putIfAbsent != null ? putIfAbsent : zze;
    }

    public final <T> zziw<T> zzv(T t) {
        return zzf(t.getClass());
    }

    private zzis() {
    }
}
