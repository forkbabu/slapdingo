package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzehk {
    private static final zzehi zzigp = zzbgu();
    private static final zzehi zzigq = new zzehh();

    static zzehi zzbgs() {
        return zzigp;
    }

    static zzehi zzbgt() {
        return zzigq;
    }

    private static zzehi zzbgu() {
        try {
            return (zzehi) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
