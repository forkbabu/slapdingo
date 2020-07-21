package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzgo {
    private static final zzgk<?> zztu = new zzgm();
    private static final zzgk<?> zztv = zzfq();

    private static zzgk<?> zzfq() {
        try {
            return (zzgk) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzgk<?> zzfr() {
        return zztu;
    }

    static zzgk<?> zzfs() {
        zzgk<?> zzgk = zztv;
        if (zzgk != null) {
            return zzgk;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
