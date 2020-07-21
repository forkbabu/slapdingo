package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzegc implements zzehm {
    private static final zzegc zziej = new zzegc();

    private zzegc() {
    }

    public static zzegc zzbfl() {
        return zziej;
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    public final boolean zze(Class<?> cls) {
        return zzegb.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzehm
    public final zzehj zzf(Class<?> cls) {
        if (!zzegb.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzehj) zzegb.zzd(cls.asSubclass(zzegb.class)).zza(zzegb.zze.zzieq, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
