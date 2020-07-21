package com.google.android.gms.internal.vision;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public enum zzkf {
    DOUBLE(zzki.DOUBLE, 1),
    FLOAT(zzki.FLOAT, 5),
    INT64(zzki.LONG, 0),
    UINT64(zzki.LONG, 0),
    INT32(zzki.INT, 0),
    FIXED64(zzki.LONG, 1),
    FIXED32(zzki.INT, 5),
    BOOL(zzki.BOOLEAN, 0),
    STRING(zzki.STRING, 2) {
    },
    GROUP(zzki.MESSAGE, 3) {
    },
    MESSAGE(zzki.MESSAGE, 2) {
    },
    BYTES(zzki.BYTE_STRING, 2) {
    },
    UINT32(zzki.INT, 0),
    ENUM(zzki.ENUM, 0),
    SFIXED32(zzki.INT, 5),
    SFIXED64(zzki.LONG, 1),
    SINT32(zzki.INT, 0),
    SINT64(zzki.LONG, 0);
    
    private final zzki zzact;
    private final int zzacu;

    private zzkf(zzki zzki, int i) {
        this.zzact = zzki;
        this.zzacu = i;
    }

    public final zzki zziq() {
        return this.zzact;
    }

    public final int zzir() {
        return this.zzacu;
    }

    /* synthetic */ zzkf(zzki zzki, int i, zzkc zzkc) {
        this(zzki, i);
    }
}
