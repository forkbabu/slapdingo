package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzgl<T> {
    private final Map<String, AtomicReference<T>> zzabo = new HashMap();

    public final AtomicReference<T> zzas(String str) {
        synchronized (this) {
            if (!this.zzabo.containsKey(str)) {
                this.zzabo.put(str, new AtomicReference<>());
            }
        }
        return this.zzabo.get(str);
    }
}
