package com.google.android.gms.internal.ads;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public enum zzefv {
    DOUBLE(0, zzefx.SCALAR, zzegn.DOUBLE),
    FLOAT(1, zzefx.SCALAR, zzegn.FLOAT),
    INT64(2, zzefx.SCALAR, zzegn.LONG),
    UINT64(3, zzefx.SCALAR, zzegn.LONG),
    INT32(4, zzefx.SCALAR, zzegn.INT),
    FIXED64(5, zzefx.SCALAR, zzegn.LONG),
    FIXED32(6, zzefx.SCALAR, zzegn.INT),
    BOOL(7, zzefx.SCALAR, zzegn.BOOLEAN),
    STRING(8, zzefx.SCALAR, zzegn.STRING),
    MESSAGE(9, zzefx.SCALAR, zzegn.MESSAGE),
    BYTES(10, zzefx.SCALAR, zzegn.BYTE_STRING),
    UINT32(11, zzefx.SCALAR, zzegn.INT),
    ENUM(12, zzefx.SCALAR, zzegn.ENUM),
    SFIXED32(13, zzefx.SCALAR, zzegn.INT),
    SFIXED64(14, zzefx.SCALAR, zzegn.LONG),
    SINT32(15, zzefx.SCALAR, zzegn.INT),
    SINT64(16, zzefx.SCALAR, zzegn.LONG),
    GROUP(17, zzefx.SCALAR, zzegn.MESSAGE),
    DOUBLE_LIST(18, zzefx.VECTOR, zzegn.DOUBLE),
    FLOAT_LIST(19, zzefx.VECTOR, zzegn.FLOAT),
    INT64_LIST(20, zzefx.VECTOR, zzegn.LONG),
    UINT64_LIST(21, zzefx.VECTOR, zzegn.LONG),
    INT32_LIST(22, zzefx.VECTOR, zzegn.INT),
    FIXED64_LIST(23, zzefx.VECTOR, zzegn.LONG),
    FIXED32_LIST(24, zzefx.VECTOR, zzegn.INT),
    BOOL_LIST(25, zzefx.VECTOR, zzegn.BOOLEAN),
    STRING_LIST(26, zzefx.VECTOR, zzegn.STRING),
    MESSAGE_LIST(27, zzefx.VECTOR, zzegn.MESSAGE),
    BYTES_LIST(28, zzefx.VECTOR, zzegn.BYTE_STRING),
    UINT32_LIST(29, zzefx.VECTOR, zzegn.INT),
    ENUM_LIST(30, zzefx.VECTOR, zzegn.ENUM),
    SFIXED32_LIST(31, zzefx.VECTOR, zzegn.INT),
    SFIXED64_LIST(32, zzefx.VECTOR, zzegn.LONG),
    SINT32_LIST(33, zzefx.VECTOR, zzegn.INT),
    SINT64_LIST(34, zzefx.VECTOR, zzegn.LONG),
    DOUBLE_LIST_PACKED(35, zzefx.PACKED_VECTOR, zzegn.DOUBLE),
    FLOAT_LIST_PACKED(36, zzefx.PACKED_VECTOR, zzegn.FLOAT),
    INT64_LIST_PACKED(37, zzefx.PACKED_VECTOR, zzegn.LONG),
    UINT64_LIST_PACKED(38, zzefx.PACKED_VECTOR, zzegn.LONG),
    INT32_LIST_PACKED(39, zzefx.PACKED_VECTOR, zzegn.INT),
    FIXED64_LIST_PACKED(40, zzefx.PACKED_VECTOR, zzegn.LONG),
    FIXED32_LIST_PACKED(41, zzefx.PACKED_VECTOR, zzegn.INT),
    BOOL_LIST_PACKED(42, zzefx.PACKED_VECTOR, zzegn.BOOLEAN),
    UINT32_LIST_PACKED(43, zzefx.PACKED_VECTOR, zzegn.INT),
    ENUM_LIST_PACKED(44, zzefx.PACKED_VECTOR, zzegn.ENUM),
    SFIXED32_LIST_PACKED(45, zzefx.PACKED_VECTOR, zzegn.INT),
    SFIXED64_LIST_PACKED(46, zzefx.PACKED_VECTOR, zzegn.LONG),
    SINT32_LIST_PACKED(47, zzefx.PACKED_VECTOR, zzegn.INT),
    SINT64_LIST_PACKED(48, zzefx.PACKED_VECTOR, zzegn.LONG),
    GROUP_LIST(49, zzefx.VECTOR, zzegn.MESSAGE),
    MAP(50, zzefx.MAP, zzegn.VOID);
    
    private static final zzefv[] zzids;
    private static final Type[] zzidt = new Type[0];

    /* renamed from: id  reason: collision with root package name */
    private final int f25id;
    private final zzegn zzido;
    private final zzefx zzidp;
    private final Class<?> zzidq;
    private final boolean zzidr;

    private zzefv(int i, zzefx zzefx, zzegn zzegn) {
        int i2;
        this.f25id = i;
        this.zzidp = zzefx;
        this.zzido = zzegn;
        int i3 = zzefy.zzieb[zzefx.ordinal()];
        boolean z = true;
        if (i3 == 1) {
            this.zzidq = zzegn.zzbgd();
        } else if (i3 != 2) {
            this.zzidq = null;
        } else {
            this.zzidq = zzegn.zzbgd();
        }
        this.zzidr = (zzefx != zzefx.SCALAR || (i2 = zzefy.zziec[zzegn.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : z;
    }

    public final int id() {
        return this.f25id;
    }

    static {
        zzefv[] values = values();
        zzids = new zzefv[values.length];
        for (zzefv zzefv : values) {
            zzids[zzefv.f25id] = zzefv;
        }
    }
}
