package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzefr {
    private static final zzefq<?> zzibi = new zzefs();
    private static final zzefq<?> zzibj = zzbes();

    private static zzefq<?> zzbes() {
        try {
            return (zzefq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    static zzefq<?> zzbet() {
        return zzibi;
    }

    static zzefq<?> zzbeu() {
        zzefq<?> zzefq = zzibj;
        if (zzefq != null) {
            return zzefq;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }
}
