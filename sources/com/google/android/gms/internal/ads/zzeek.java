package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeek {
    private static final Class<?> zzhzm = zzhr("libcore.io.Memory");
    private static final boolean zzhzn = (zzhr("org.robolectric.Robolectric") != null);

    static boolean zzbcw() {
        return zzhzm != null && !zzhzn;
    }

    static Class<?> zzbcx() {
        return zzhzm;
    }

    /* JADX DEBUG: Type inference failed for r0v2. Raw type applied. Possible types: java.lang.Class<?>, java.lang.Class<T> */
    private static <T> Class<T> zzhr(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
