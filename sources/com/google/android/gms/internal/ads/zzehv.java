package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzehv {
    private static final zzeht zzihj = zzbgx();
    private static final zzeht zzihk = new zzehw();

    static zzeht zzbgv() {
        return zzihj;
    }

    static zzeht zzbgw() {
        return zzihk;
    }

    private static zzeht zzbgx() {
        try {
            return (zzeht) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
