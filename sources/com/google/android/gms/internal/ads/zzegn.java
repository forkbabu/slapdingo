package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public enum zzegn {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzeer.class, zzeer.class, zzeer.zzhzv),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);
    
    private final Class<?> zzifr;
    private final Class<?> zzifs;
    private final Object zzift;

    private zzegn(Class<?> cls, Class<?> cls2, Object obj) {
        this.zzifr = cls;
        this.zzifs = cls2;
        this.zzift = obj;
    }

    public final Class<?> zzbgd() {
        return this.zzifs;
    }
}
