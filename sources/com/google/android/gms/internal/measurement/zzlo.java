package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@17.4.4 */
public enum zzlo {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzgt.zza),
    ENUM(null),
    MESSAGE(null);
    
    private final Object zzj;

    private zzlo(Object obj) {
        this.zzj = obj;
    }
}
