package com.google.android.gms.internal.ads;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzacy {
    private static final AtomicReference<zzacz> zzdbp = new AtomicReference<>();
    static final AtomicBoolean zzdbq = new AtomicBoolean();

    static zzacz zzrs() {
        return zzdbp.get();
    }

    public static void zza(zzacz zzacz) {
        zzdbp.set(zzacz);
    }
}
