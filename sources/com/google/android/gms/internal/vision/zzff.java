package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzff {
    private static final Class<?> zzsb = zzv("libcore.io.Memory");
    private static final boolean zzsc = (zzv("org.robolectric.Robolectric") != null);

    static boolean zzds() {
        return zzsb != null && !zzsc;
    }

    static Class<?> zzdt() {
        return zzsb;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<T> */
    private static <T> Class<T> zzv(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
