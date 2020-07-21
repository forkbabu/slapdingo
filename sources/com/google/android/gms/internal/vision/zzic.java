package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzic {
    private static final zzia zzzf = zzhi();
    private static final zzia zzzg = new zzid();

    static zzia zzhg() {
        return zzzf;
    }

    static zzia zzhh() {
        return zzzg;
    }

    private static zzia zzhi() {
        try {
            return (zzia) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
