package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzib;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzhz implements zzjk {
    private static final zzhz zza = new zzhz();

    private zzhz() {
    }

    public static zzhz zza() {
        return zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final boolean zza(Class<?> cls) {
        return zzib.class.isAssignableFrom(cls);
    }

    @Override // com.google.android.gms.internal.measurement.zzjk
    public final zzjh zzb(Class<?> cls) {
        if (!zzib.class.isAssignableFrom(cls)) {
            String valueOf = String.valueOf(cls.getName());
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Unsupported message type: ".concat(valueOf) : new String("Unsupported message type: "));
        }
        try {
            return (zzjh) zzib.zza(cls.asSubclass(zzib.class)).zza(zzib.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            String valueOf2 = String.valueOf(cls.getName());
            throw new RuntimeException(valueOf2.length() != 0 ? "Unable to get message info for ".concat(valueOf2) : new String("Unable to get message info for "), e);
        }
    }
}
