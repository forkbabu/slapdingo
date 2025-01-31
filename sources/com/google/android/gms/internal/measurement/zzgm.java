package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
final class zzgm {
    private static final Class<?> zza = zza("libcore.io.Memory");
    private static final boolean zzb = (zza("org.robolectric.Robolectric") != null);

    static boolean zza() {
        return zza != null && !zzb;
    }

    static Class<?> zzb() {
        return zza;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<T> */
    private static <T> Class<T> zza(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
