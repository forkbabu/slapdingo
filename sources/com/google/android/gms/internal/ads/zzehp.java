package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzehp<T> implements zzeih<T> {
    private static final Unsafe zzhni = zzejf.zzbhx();
    private static final int[] zzigr = new int[0];
    private final int[] zzigs;
    private final Object[] zzigt;
    private final int zzigu;
    private final int zzigv;
    private final zzehl zzigw;
    private final boolean zzigx;
    private final boolean zzigy;
    private final boolean zzigz;
    private final boolean zziha;
    private final int[] zzihb;
    private final int zzihc;
    private final int zzihd;
    private final zzeht zzihe;
    private final zzegv zzihf;
    private final zzeiz<?, ?> zzihg;
    private final zzefq<?> zzihh;
    private final zzehi zzihi;

    private zzehp(int[] iArr, Object[] objArr, int i, int i2, zzehl zzehl, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzeht zzeht, zzegv zzegv, zzeiz<?, ?> zzeiz, zzefq<?> zzefq, zzehi zzehi) {
        this.zzigs = iArr;
        this.zzigt = objArr;
        this.zzigu = i;
        this.zzigv = i2;
        this.zzigy = zzehl instanceof zzegb;
        this.zzigz = z;
        this.zzigx = zzefq != null && zzefq.zzj(zzehl);
        this.zziha = false;
        this.zzihb = iArr2;
        this.zzihc = i3;
        this.zzihd = i4;
        this.zzihe = zzeht;
        this.zzihf = zzegv;
        this.zzihg = zzeiz;
        this.zzihh = zzefq;
        this.zzigw = zzehl;
        this.zzihi = zzehi;
    }

    private static boolean zzhj(int i) {
        return (i & 536870912) != 0;
    }

    static <T> zzehp<T> zza(Class<T> cls, zzehj zzehj, zzeht zzeht, zzegv zzegv, zzeiz<?, ?> zzeiz, zzefq<?> zzefq, zzehi zzehi) {
        int i;
        char c;
        int[] iArr;
        char c2;
        char c3;
        char c4;
        char c5;
        int i2;
        int i3;
        int i4;
        char c6;
        int i5;
        String str;
        Object[] objArr;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean z;
        int i10;
        Field field;
        int i11;
        char charAt;
        int i12;
        char c7;
        Field field2;
        Field field3;
        int i13;
        char charAt2;
        int i14;
        char charAt3;
        int i15;
        char charAt4;
        int i16;
        char charAt5;
        int i17;
        char charAt6;
        int i18;
        char charAt7;
        int i19;
        char charAt8;
        int i20;
        char charAt9;
        int i21;
        char charAt10;
        int i22;
        char charAt11;
        int i23;
        char charAt12;
        int i24;
        char charAt13;
        if (zzehj instanceof zzeic) {
            zzeic zzeic = (zzeic) zzehj;
            char c8 = 0;
            boolean z2 = zzeic.zzbgp() == zzegb.zze.zziex;
            String zzbha = zzeic.zzbha();
            int length = zzbha.length();
            if (zzbha.charAt(0) >= 55296) {
                int i25 = 1;
                while (true) {
                    i = i25 + 1;
                    if (zzbha.charAt(i25) < 55296) {
                        break;
                    }
                    i25 = i;
                }
            } else {
                i = 1;
            }
            int i26 = i + 1;
            char charAt14 = zzbha.charAt(i);
            if (charAt14 >= 55296) {
                char c9 = charAt14 & 8191;
                int i27 = 13;
                while (true) {
                    i24 = i26 + 1;
                    charAt13 = zzbha.charAt(i26);
                    if (charAt13 < 55296) {
                        break;
                    }
                    c9 |= (charAt13 & 8191) << i27;
                    i27 += 13;
                    i26 = i24;
                }
                charAt14 = c9 | (charAt13 << i27);
                i26 = i24;
            }
            if (charAt14 == 0) {
                iArr = zzigr;
                i2 = 0;
                c5 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
                c = 0;
            } else {
                int i28 = i26 + 1;
                char charAt15 = zzbha.charAt(i26);
                if (charAt15 >= 55296) {
                    char c10 = charAt15 & 8191;
                    int i29 = 13;
                    while (true) {
                        i23 = i28 + 1;
                        charAt12 = zzbha.charAt(i28);
                        if (charAt12 < 55296) {
                            break;
                        }
                        c10 |= (charAt12 & 8191) << i29;
                        i29 += 13;
                        i28 = i23;
                    }
                    charAt15 = c10 | (charAt12 << i29);
                    i28 = i23;
                }
                int i30 = i28 + 1;
                char charAt16 = zzbha.charAt(i28);
                if (charAt16 >= 55296) {
                    char c11 = charAt16 & 8191;
                    int i31 = 13;
                    while (true) {
                        i22 = i30 + 1;
                        charAt11 = zzbha.charAt(i30);
                        if (charAt11 < 55296) {
                            break;
                        }
                        c11 |= (charAt11 & 8191) << i31;
                        i31 += 13;
                        i30 = i22;
                    }
                    charAt16 = c11 | (charAt11 << i31);
                    i30 = i22;
                }
                int i32 = i30 + 1;
                c5 = zzbha.charAt(i30);
                if (c5 >= 55296) {
                    char c12 = c5 & 8191;
                    int i33 = 13;
                    while (true) {
                        i21 = i32 + 1;
                        charAt10 = zzbha.charAt(i32);
                        if (charAt10 < 55296) {
                            break;
                        }
                        c12 |= (charAt10 & 8191) << i33;
                        i33 += 13;
                        i32 = i21;
                    }
                    c5 = c12 | (charAt10 << i33);
                    i32 = i21;
                }
                int i34 = i32 + 1;
                c4 = zzbha.charAt(i32);
                if (c4 >= 55296) {
                    char c13 = c4 & 8191;
                    int i35 = 13;
                    while (true) {
                        i20 = i34 + 1;
                        charAt9 = zzbha.charAt(i34);
                        if (charAt9 < 55296) {
                            break;
                        }
                        c13 |= (charAt9 & 8191) << i35;
                        i35 += 13;
                        i34 = i20;
                    }
                    c4 = c13 | (charAt9 << i35);
                    i34 = i20;
                }
                int i36 = i34 + 1;
                c3 = zzbha.charAt(i34);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i37 = 13;
                    while (true) {
                        i19 = i36 + 1;
                        charAt8 = zzbha.charAt(i36);
                        if (charAt8 < 55296) {
                            break;
                        }
                        c14 |= (charAt8 & 8191) << i37;
                        i37 += 13;
                        i36 = i19;
                    }
                    c3 = c14 | (charAt8 << i37);
                    i36 = i19;
                }
                int i38 = i36 + 1;
                c2 = zzbha.charAt(i36);
                if (c2 >= 55296) {
                    char c15 = c2 & 8191;
                    int i39 = 13;
                    while (true) {
                        i18 = i38 + 1;
                        charAt7 = zzbha.charAt(i38);
                        if (charAt7 < 55296) {
                            break;
                        }
                        c15 |= (charAt7 & 8191) << i39;
                        i39 += 13;
                        i38 = i18;
                    }
                    c2 = c15 | (charAt7 << i39);
                    i38 = i18;
                }
                int i40 = i38 + 1;
                char charAt17 = zzbha.charAt(i38);
                if (charAt17 >= 55296) {
                    char c16 = charAt17 & 8191;
                    int i41 = 13;
                    while (true) {
                        i17 = i40 + 1;
                        charAt6 = zzbha.charAt(i40);
                        if (charAt6 < 55296) {
                            break;
                        }
                        c16 |= (charAt6 & 8191) << i41;
                        i41 += 13;
                        i40 = i17;
                    }
                    charAt17 = c16 | (charAt6 << i41);
                    i40 = i17;
                }
                int i42 = i40 + 1;
                c = zzbha.charAt(i40);
                if (c >= 55296) {
                    char c17 = c & 8191;
                    int i43 = i42;
                    int i44 = 13;
                    while (true) {
                        i16 = i43 + 1;
                        charAt5 = zzbha.charAt(i43);
                        if (charAt5 < 55296) {
                            break;
                        }
                        c17 |= (charAt5 & 8191) << i44;
                        i44 += 13;
                        i43 = i16;
                    }
                    c = c17 | (charAt5 << i44);
                    i42 = i16;
                }
                i2 = (charAt15 << 1) + charAt16;
                iArr = new int[(c + c2 + charAt17)];
                c8 = charAt15;
                i26 = i42;
            }
            Unsafe unsafe = zzhni;
            Object[] zzbhb = zzeic.zzbhb();
            Class<?> cls2 = zzeic.zzbgr().getClass();
            int[] iArr2 = new int[(c3 * 3)];
            Object[] objArr2 = new Object[(c3 << 1)];
            int i45 = c + c2;
            int i46 = i2;
            char c18 = c;
            int i47 = i26;
            int i48 = i45;
            int i49 = 0;
            int i50 = 0;
            while (i47 < length) {
                int i51 = i47 + 1;
                int charAt18 = zzbha.charAt(i47);
                if (charAt18 >= 55296) {
                    int i52 = charAt18 & 8191;
                    int i53 = i51;
                    int i54 = 13;
                    while (true) {
                        i15 = i53 + 1;
                        charAt4 = zzbha.charAt(i53);
                        i3 = length;
                        if (charAt4 < 55296) {
                            break;
                        }
                        i52 |= (charAt4 & 8191) << i54;
                        i54 += 13;
                        i53 = i15;
                        length = i3;
                    }
                    charAt18 = i52 | (charAt4 << i54);
                    i4 = i15;
                } else {
                    i3 = length;
                    i4 = i51;
                }
                int i55 = i4 + 1;
                char charAt19 = zzbha.charAt(i4);
                if (charAt19 >= 55296) {
                    char c19 = charAt19 & 8191;
                    int i56 = i55;
                    int i57 = 13;
                    while (true) {
                        i14 = i56 + 1;
                        charAt3 = zzbha.charAt(i56);
                        c6 = c;
                        if (charAt3 < 55296) {
                            break;
                        }
                        c19 |= (charAt3 & 8191) << i57;
                        i57 += 13;
                        i56 = i14;
                        c = c6;
                    }
                    charAt19 = c19 | (charAt3 << i57);
                    i5 = i14;
                } else {
                    c6 = c;
                    i5 = i55;
                }
                char c20 = charAt19 & 255;
                if ((charAt19 & 1024) != 0) {
                    iArr[i49] = i50;
                    i49++;
                }
                if (c20 >= '3') {
                    int i58 = i5 + 1;
                    char charAt20 = zzbha.charAt(i5);
                    char c21 = 55296;
                    if (charAt20 >= 55296) {
                        char c22 = charAt20 & 8191;
                        int i59 = 13;
                        while (true) {
                            i13 = i58 + 1;
                            charAt2 = zzbha.charAt(i58);
                            if (charAt2 < c21) {
                                break;
                            }
                            c22 |= (charAt2 & 8191) << i59;
                            i59 += 13;
                            i58 = i13;
                            c21 = 55296;
                        }
                        charAt20 = c22 | (charAt2 << i59);
                        i58 = i13;
                    }
                    int i60 = c20 - '3';
                    if (i60 == 9 || i60 == 17) {
                        c7 = 1;
                        objArr2[((i50 / 3) << 1) + 1] = zzbhb[i46];
                        i46++;
                    } else {
                        if (i60 == 12 && !z2) {
                            objArr2[((i50 / 3) << 1) + 1] = zzbhb[i46];
                            i46++;
                        }
                        c7 = 1;
                    }
                    int i61 = charAt20 << c7;
                    Object obj = zzbhb[i61];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls2, (String) obj);
                        zzbhb[i61] = field2;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i62 = i61 + 1;
                    Object obj2 = zzbhb[i62];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls2, (String) obj2);
                        zzbhb[i62] = field3;
                    }
                    str = zzbha;
                    i8 = (int) unsafe.objectFieldOffset(field3);
                    z = z2;
                    objArr = objArr2;
                    i7 = objectFieldOffset;
                    i6 = i58;
                    i9 = 0;
                } else {
                    int i63 = i46 + 1;
                    Field zza = zza(cls2, (String) zzbhb[i46]);
                    if (c20 == '\t' || c20 == 17) {
                        objArr2[((i50 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c20 == 27 || c20 == '1') {
                            i12 = i63 + 1;
                            objArr2[((i50 / 3) << 1) + 1] = zzbhb[i63];
                        } else if (c20 == '\f' || c20 == 30 || c20 == ',') {
                            if (!z2) {
                                i12 = i63 + 1;
                                objArr2[((i50 / 3) << 1) + 1] = zzbhb[i63];
                            }
                        } else if (c20 == '2') {
                            int i64 = c18 + 1;
                            iArr[c18] = i50;
                            int i65 = (i50 / 3) << 1;
                            i12 = i63 + 1;
                            objArr2[i65] = zzbhb[i63];
                            if ((charAt19 & 2048) != 0) {
                                i63 = i12 + 1;
                                objArr2[i65 + 1] = zzbhb[i12];
                                c18 = i64;
                            } else {
                                c18 = i64;
                            }
                        }
                        i10 = i12;
                        i7 = (int) unsafe.objectFieldOffset(zza);
                        if ((charAt19 & 4096) == 4096 || c20 > 17) {
                            str = zzbha;
                            z = z2;
                            objArr = objArr2;
                            i8 = 1048575;
                            i6 = i5;
                            i9 = 0;
                        } else {
                            int i66 = i5 + 1;
                            char charAt21 = zzbha.charAt(i5);
                            if (charAt21 >= 55296) {
                                char c23 = charAt21 & 8191;
                                int i67 = 13;
                                while (true) {
                                    i11 = i66 + 1;
                                    charAt = zzbha.charAt(i66);
                                    if (charAt < 55296) {
                                        break;
                                    }
                                    c23 |= (charAt & 8191) << i67;
                                    i67 += 13;
                                    i66 = i11;
                                }
                                charAt21 = c23 | (charAt << i67);
                                i66 = i11;
                            }
                            int i68 = (c8 << 1) + (charAt21 / ' ');
                            Object obj3 = zzbhb[i68];
                            str = zzbha;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls2, (String) obj3);
                                zzbhb[i68] = field;
                            }
                            z = z2;
                            objArr = objArr2;
                            i9 = charAt21 % ' ';
                            i6 = i66;
                            i8 = (int) unsafe.objectFieldOffset(field);
                        }
                        if (c20 >= 18 && c20 <= '1') {
                            iArr[i48] = i7;
                            i48++;
                        }
                        i46 = i10;
                    }
                    i10 = i63;
                    i7 = (int) unsafe.objectFieldOffset(zza);
                    if ((charAt19 & 4096) == 4096) {
                    }
                    str = zzbha;
                    z = z2;
                    objArr = objArr2;
                    i8 = 1048575;
                    i6 = i5;
                    i9 = 0;
                    iArr[i48] = i7;
                    i48++;
                    i46 = i10;
                }
                int i69 = i50 + 1;
                iArr2[i50] = charAt18;
                int i70 = i69 + 1;
                iArr2[i69] = ((charAt19 & 256) != 0 ? 268435456 : 0) | ((charAt19 & 512) != 0 ? 536870912 : 0) | (c20 << 20) | i7;
                int i71 = i70 + 1;
                iArr2[i70] = (i9 << 20) | i8;
                i47 = i6;
                c8 = c8;
                c4 = c4;
                objArr2 = objArr;
                c = c6;
                c5 = c5;
                z2 = z;
                i50 = i71;
                length = i3;
                zzbha = str;
            }
            return new zzehp<>(iArr2, objArr2, c5, c4, zzeic.zzbgr(), z2, false, iArr, c, i45, zzeht, zzegv, zzeiz, zzefq, zzehi);
        }
        ((zzeiw) zzehj).zzbgp();
        int i72 = zzegb.zze.zziex;
        throw new NoSuchMethodError();
    }

    private static Field zza(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (NoSuchFieldException unused) {
            Field[] declaredFields = cls.getDeclaredFields();
            for (Field field : declaredFields) {
                if (str.equals(field.getName())) {
                    return field;
                }
            }
            String name = cls.getName();
            String arrays = Arrays.toString(declaredFields);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 40 + String.valueOf(name).length() + String.valueOf(arrays).length());
            sb.append("Field ");
            sb.append(str);
            sb.append(" for ");
            sb.append(name);
            sb.append(" not found. Known fields are ");
            sb.append(arrays);
            throw new RuntimeException(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final T newInstance() {
        return this.zzihe.newInstance(this.zzigw);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.ads.zzeij.zzh(com.google.android.gms.internal.ads.zzejf.zzp(r10, r6), com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.ads.zzeij.zzh(com.google.android.gms.internal.ads.zzejf.zzp(r10, r6), com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.ads.zzeij.zzh(com.google.android.gms.internal.ads.zzejf.zzp(r10, r6), com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.ads.zzeij.zzh(com.google.android.gms.internal.ads.zzejf.zzp(r10, r6), com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzm(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzk(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.ads.zzejf.zzl(r10, r6) == com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzejf.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.ads.zzejf.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzejf.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.ads.zzejf.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.ads.zzeij.zzh(com.google.android.gms.internal.ads.zzejf.zzp(r10, r6), com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.ads.zzeih
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzigs
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzhh(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x01a7;
                case 1: goto L_0x018e;
                case 2: goto L_0x017b;
                case 3: goto L_0x0168;
                case 4: goto L_0x0157;
                case 5: goto L_0x0144;
                case 6: goto L_0x0132;
                case 7: goto L_0x0120;
                case 8: goto L_0x010a;
                case 9: goto L_0x00f4;
                case 10: goto L_0x00de;
                case 11: goto L_0x00cc;
                case 12: goto L_0x00ba;
                case 13: goto L_0x00a8;
                case 14: goto L_0x0094;
                case 15: goto L_0x0082;
                case 16: goto L_0x006e;
                case 17: goto L_0x0058;
                case 18: goto L_0x004a;
                case 19: goto L_0x004a;
                case 20: goto L_0x004a;
                case 21: goto L_0x004a;
                case 22: goto L_0x004a;
                case 23: goto L_0x004a;
                case 24: goto L_0x004a;
                case 25: goto L_0x004a;
                case 26: goto L_0x004a;
                case 27: goto L_0x004a;
                case 28: goto L_0x004a;
                case 29: goto L_0x004a;
                case 30: goto L_0x004a;
                case 31: goto L_0x004a;
                case 32: goto L_0x004a;
                case 33: goto L_0x004a;
                case 34: goto L_0x004a;
                case 35: goto L_0x004a;
                case 36: goto L_0x004a;
                case 37: goto L_0x004a;
                case 38: goto L_0x004a;
                case 39: goto L_0x004a;
                case 40: goto L_0x004a;
                case 41: goto L_0x004a;
                case 42: goto L_0x004a;
                case 43: goto L_0x004a;
                case 44: goto L_0x004a;
                case 45: goto L_0x004a;
                case 46: goto L_0x004a;
                case 47: goto L_0x004a;
                case 48: goto L_0x004a;
                case 49: goto L_0x004a;
                case 50: goto L_0x003c;
                case 51: goto L_0x001c;
                case 52: goto L_0x001c;
                case 53: goto L_0x001c;
                case 54: goto L_0x001c;
                case 55: goto L_0x001c;
                case 56: goto L_0x001c;
                case 57: goto L_0x001c;
                case 58: goto L_0x001c;
                case 59: goto L_0x001c;
                case 60: goto L_0x001c;
                case 61: goto L_0x001c;
                case 62: goto L_0x001c;
                case 63: goto L_0x001c;
                case 64: goto L_0x001c;
                case 65: goto L_0x001c;
                case 66: goto L_0x001c;
                case 67: goto L_0x001c;
                case 68: goto L_0x001c;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x01c2
        L_0x001c:
            int r4 = r9.zzhi(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.ads.zzejf.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.ads.zzejf.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzejf.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeij.zzh(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzejf.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.ads.zzeij.zzh(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzejf.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.ads.zzeij.zzh(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzejf.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeij.zzh(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzejf.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzejf.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzejf.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzejf.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzejf.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzejf.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzejf.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeij.zzh(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzejf.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeij.zzh(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.ads.zzejf.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzejf.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.ads.zzeij.zzh(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.ads.zzejf.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.ads.zzejf.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzejf.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzejf.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.ads.zzejf.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.ads.zzejf.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzejf.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.ads.zzejf.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.ads.zzejf.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.ads.zzejf.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.ads.zzejf.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.ads.zzejf.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.ads.zzejf.zzo(r11, r6)
            long r6 = java.lang.Double.doubleToLongBits(r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
        L_0x01c1:
            r3 = 0
        L_0x01c2:
            if (r3 != 0) goto L_0x01c5
            return r1
        L_0x01c5:
            int r2 = r2 + 3
            goto L_0x0005
        L_0x01c9:
            com.google.android.gms.internal.ads.zzeiz<?, ?> r0 = r9.zzihg
            java.lang.Object r0 = r0.zzax(r10)
            com.google.android.gms.internal.ads.zzeiz<?, ?> r2 = r9.zzihg
            java.lang.Object r2 = r2.zzax(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzigx
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.ads.zzefq<?> r0 = r9.zzihh
            com.google.android.gms.internal.ads.zzefu r10 = r0.zzah(r10)
            com.google.android.gms.internal.ads.zzefq<?> r0 = r9.zzihh
            com.google.android.gms.internal.ads.zzefu r11 = r0.zzah(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
            switch-data {0->0x01a7, 1->0x018e, 2->0x017b, 3->0x0168, 4->0x0157, 5->0x0144, 6->0x0132, 7->0x0120, 8->0x010a, 9->0x00f4, 10->0x00de, 11->0x00cc, 12->0x00ba, 13->0x00a8, 14->0x0094, 15->0x0082, 16->0x006e, 17->0x0058, 18->0x004a, 19->0x004a, 20->0x004a, 21->0x004a, 22->0x004a, 23->0x004a, 24->0x004a, 25->0x004a, 26->0x004a, 27->0x004a, 28->0x004a, 29->0x004a, 30->0x004a, 31->0x004a, 32->0x004a, 33->0x004a, 34->0x004a, 35->0x004a, 36->0x004a, 37->0x004a, 38->0x004a, 39->0x004a, 40->0x004a, 41->0x004a, 42->0x004a, 43->0x004a, 44->0x004a, 45->0x004a, 46->0x004a, 47->0x004a, 48->0x004a, 49->0x004a, 50->0x003c, 51->0x001c, 52->0x001c, 53->0x001c, 54->0x001c, 55->0x001c, 56->0x001c, 57->0x001c, 58->0x001c, 59->0x001c, 60->0x001c, 61->0x001c, 62->0x001c, 63->0x001c, 64->0x001c, 65->0x001c, 66->0x001c, 67->0x001c, 68->0x001c, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehp.equals(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final int hashCode(T t) {
        int i;
        int i2;
        int length = this.zzigs.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzhh = zzhh(i4);
            int i5 = this.zzigs[i4];
            long j = (long) (1048575 & zzhh);
            int i6 = 37;
            switch ((zzhh & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzegd.zzfr(Double.doubleToLongBits(zzejf.zzo(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzejf.zzn(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzegd.zzfr(zzejf.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzegd.zzfr(zzejf.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzejf.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzegd.zzfr(zzejf.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzejf.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzegd.zzbu(zzejf.zzm(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzejf.zzp(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzp = zzejf.zzp(t, j);
                    if (zzp != null) {
                        i6 = zzp.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzejf.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzejf.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzejf.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzejf.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzegd.zzfr(zzejf.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzejf.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzegd.zzfr(zzejf.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzp2 = zzejf.zzp(t, j);
                    if (zzp2 != null) {
                        i6 = zzp2.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                case 25:
                case 26:
                case 27:
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                    i2 = i3 * 53;
                    i = zzejf.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzejf.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzegd.zzfr(Double.doubleToLongBits(zzf(t, j)));
                        i3 = i2 + i;
                        break;
                    }
                case 52:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = Float.floatToIntBits(zzg(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 53:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzegd.zzfr(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 54:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzegd.zzfr(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 55:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 56:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzegd.zzfr(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 57:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 58:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzegd.zzbu(zzj(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 59:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = ((String) zzejf.zzp(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 60:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzejf.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 61:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzejf.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 62:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 63:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 64:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 65:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzegd.zzfr(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 66:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzh(t, j);
                        i3 = i2 + i;
                        break;
                    }
                case 67:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzegd.zzfr(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 68:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzejf.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzihg.zzax(t).hashCode();
        return this.zzigx ? (hashCode * 53) + this.zzihh.zzah(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final void zzg(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzigs.length; i += 3) {
                int zzhh = zzhh(i);
                long j = (long) (1048575 & zzhh);
                int i2 = this.zzigs[i];
                switch ((zzhh & 267386880) >>> 20) {
                    case 0:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza(t, j, zzejf.zzo(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 1:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza((Object) t, j, zzejf.zzn(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 2:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza((Object) t, j, zzejf.zzl(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 3:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza((Object) t, j, zzejf.zzl(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 4:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zzb(t, j, zzejf.zzk(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 5:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza((Object) t, j, zzejf.zzl(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 6:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zzb(t, j, zzejf.zzk(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 7:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza(t, j, zzejf.zzm(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 8:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza(t, j, zzejf.zzp(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza(t, j, zzejf.zzp(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 11:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zzb(t, j, zzejf.zzk(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 12:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zzb(t, j, zzejf.zzk(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 13:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zzb(t, j, zzejf.zzk(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 14:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza((Object) t, j, zzejf.zzl(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 15:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zzb(t, j, zzejf.zzk(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 16:
                        if (!zze((Object) t2, i)) {
                            break;
                        } else {
                            zzejf.zza((Object) t, j, zzejf.zzl(t2, j));
                            zzf((Object) t, i);
                            break;
                        }
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 18:
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                    case 23:
                    case 24:
                    case 25:
                    case 26:
                    case 27:
                    case 28:
                    case 29:
                    case 30:
                    case 31:
                    case 32:
                    case 33:
                    case 34:
                    case 35:
                    case 36:
                    case 37:
                    case 38:
                    case 39:
                    case 40:
                    case 41:
                    case 42:
                    case 43:
                    case 44:
                    case 45:
                    case 46:
                    case 47:
                    case 48:
                    case 49:
                        this.zzihf.zza(t, t2, j);
                        break;
                    case 50:
                        zzeij.zza(this.zzihi, t, t2, j);
                        break;
                    case 51:
                    case 52:
                    case 53:
                    case 54:
                    case 55:
                    case 56:
                    case 57:
                    case 58:
                    case 59:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzejf.zza(t, j, zzejf.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 60:
                        zzb(t, t2, i);
                        break;
                    case 61:
                    case 62:
                    case 63:
                    case 64:
                    case 65:
                    case 66:
                    case 67:
                        if (!zza(t2, i2, i)) {
                            break;
                        } else {
                            zzejf.zza(t, j, zzejf.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zzeij.zza(this.zzihg, t, t2);
            if (this.zzigx) {
                zzeij.zza(this.zzihh, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzhh = (long) (zzhh(i) & 1048575);
        if (zze((Object) t2, i)) {
            Object zzp = zzejf.zzp(t, zzhh);
            Object zzp2 = zzejf.zzp(t2, zzhh);
            if (zzp != null && zzp2 != null) {
                zzejf.zza(t, zzhh, zzegd.zze(zzp, zzp2));
                zzf((Object) t, i);
            } else if (zzp2 != null) {
                zzejf.zza(t, zzhh, zzp2);
                zzf((Object) t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzhh = zzhh(i);
        int i2 = this.zzigs[i];
        long j = (long) (zzhh & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzejf.zzp(t, j);
            Object zzp2 = zzejf.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzejf.zza(t, j, zzegd.zze(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzejf.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.ads.zzeih
    public final int zzat(T t) {
        int i;
        int i2;
        long j;
        int i3;
        int zzi;
        int i4;
        int i5;
        int i6;
        int i7;
        int zzc;
        int i8;
        int i9;
        int i10;
        int i11 = 267386880;
        if (this.zzigz) {
            Unsafe unsafe = zzhni;
            int i12 = 0;
            int i13 = 0;
            while (i12 < this.zzigs.length) {
                int zzhh = zzhh(i12);
                int i14 = (zzhh & i11) >>> 20;
                int i15 = this.zzigs[i12];
                long j2 = (long) (zzhh & 1048575);
                int i16 = (i14 < zzefv.DOUBLE_LIST_PACKED.id() || i14 > zzefv.SINT64_LIST_PACKED.id()) ? 0 : this.zzigs[i12 + 2] & 1048575;
                switch (i14) {
                    case 0:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzc(i15, 0.0d);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 1:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzb(i15, 0.0f);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 2:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzk(i15, zzejf.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 3:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzl(i15, zzejf.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 4:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzaf(i15, zzejf.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 5:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzn(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 6:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzai(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 7:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzi(i15, true);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 8:
                        if (zze((Object) t, i12)) {
                            Object zzp = zzejf.zzp(t, j2);
                            if (!(zzp instanceof zzeer)) {
                                zzc = zzefl.zzl(i15, (String) zzp);
                                break;
                            } else {
                                zzc = zzefl.zzc(i15, (zzeer) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 9:
                        if (zze((Object) t, i12)) {
                            zzc = zzeij.zzc(i15, zzejf.zzp(t, j2), zzhe(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 10:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzc(i15, (zzeer) zzejf.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 11:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzag(i15, zzejf.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 12:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzak(i15, zzejf.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 13:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzaj(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 14:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzo(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 15:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzah(i15, zzejf.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 16:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzm(i15, zzejf.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 17:
                        if (zze((Object) t, i12)) {
                            zzc = zzefl.zzc(i15, (zzehl) zzejf.zzp(t, j2), zzhe(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 18:
                        zzc = zzeij.zzw(i15, zze(t, j2), false);
                        break;
                    case 19:
                        zzc = zzeij.zzv(i15, zze(t, j2), false);
                        break;
                    case 20:
                        zzc = zzeij.zzo(i15, zze(t, j2), false);
                        break;
                    case 21:
                        zzc = zzeij.zzp(i15, zze(t, j2), false);
                        break;
                    case 22:
                        zzc = zzeij.zzs(i15, zze(t, j2), false);
                        break;
                    case 23:
                        zzc = zzeij.zzw(i15, zze(t, j2), false);
                        break;
                    case 24:
                        zzc = zzeij.zzv(i15, zze(t, j2), false);
                        break;
                    case 25:
                        zzc = zzeij.zzx(i15, zze(t, j2), false);
                        break;
                    case 26:
                        zzc = zzeij.zzc(i15, zze(t, j2));
                        break;
                    case 27:
                        zzc = zzeij.zzc(i15, zze(t, j2), zzhe(i12));
                        break;
                    case 28:
                        zzc = zzeij.zzd(i15, zze(t, j2));
                        break;
                    case 29:
                        zzc = zzeij.zzt(i15, zze(t, j2), false);
                        break;
                    case 30:
                        zzc = zzeij.zzr(i15, zze(t, j2), false);
                        break;
                    case 31:
                        zzc = zzeij.zzv(i15, zze(t, j2), false);
                        break;
                    case 32:
                        zzc = zzeij.zzw(i15, zze(t, j2), false);
                        break;
                    case 33:
                        zzc = zzeij.zzu(i15, zze(t, j2), false);
                        break;
                    case 34:
                        zzc = zzeij.zzq(i15, zze(t, j2), false);
                        break;
                    case 35:
                        i9 = zzeij.zzai((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 36:
                        i9 = zzeij.zzah((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 37:
                        i9 = zzeij.zzaa((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 38:
                        i9 = zzeij.zzab((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 39:
                        i9 = zzeij.zzae((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 40:
                        i9 = zzeij.zzai((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 41:
                        i9 = zzeij.zzah((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 42:
                        i9 = zzeij.zzaj((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 43:
                        i9 = zzeij.zzaf((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 44:
                        i9 = zzeij.zzad((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 45:
                        i9 = zzeij.zzah((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 46:
                        i9 = zzeij.zzai((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 47:
                        i9 = zzeij.zzag((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 48:
                        i9 = zzeij.zzac((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zziha) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzefl.zzgp(i15);
                            i8 = zzefl.zzgr(i9);
                            zzc = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 49:
                        zzc = zzeij.zzd(i15, zze(t, j2), zzhe(i12));
                        break;
                    case 50:
                        zzc = this.zzihi.zzb(i15, zzejf.zzp(t, j2), zzhf(i12));
                        break;
                    case 51:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzc(i15, 0.0d);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 52:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzb(i15, 0.0f);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 53:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzk(i15, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 54:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzl(i15, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 55:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzaf(i15, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 56:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzn(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 57:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzai(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 58:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzi(i15, true);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 59:
                        if (zza(t, i15, i12)) {
                            Object zzp2 = zzejf.zzp(t, j2);
                            if (!(zzp2 instanceof zzeer)) {
                                zzc = zzefl.zzl(i15, (String) zzp2);
                                break;
                            } else {
                                zzc = zzefl.zzc(i15, (zzeer) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 60:
                        if (zza(t, i15, i12)) {
                            zzc = zzeij.zzc(i15, zzejf.zzp(t, j2), zzhe(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 61:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzc(i15, (zzeer) zzejf.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 62:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzag(i15, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 63:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzak(i15, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 64:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzaj(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 65:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzo(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 66:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzah(i15, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 67:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzm(i15, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 68:
                        if (zza(t, i15, i12)) {
                            zzc = zzefl.zzc(i15, (zzehl) zzejf.zzp(t, j2), zzhe(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    default:
                        i12 += 3;
                        i11 = 267386880;
                }
                i13 += zzc;
                i12 += 3;
                i11 = 267386880;
            }
            return i13 + zza((zzeiz) this.zzihg, (Object) t);
        }
        Unsafe unsafe2 = zzhni;
        int i17 = 0;
        int i18 = 1048575;
        int i19 = 0;
        for (int i20 = 0; i20 < this.zzigs.length; i20 += 3) {
            int zzhh2 = zzhh(i20);
            int[] iArr = this.zzigs;
            int i21 = iArr[i20];
            int i22 = (zzhh2 & 267386880) >>> 20;
            if (i22 <= 17) {
                int i23 = iArr[i20 + 2];
                int i24 = i23 & 1048575;
                i = 1 << (i23 >>> 20);
                if (i24 != i18) {
                    i19 = unsafe2.getInt(t, (long) i24);
                    i18 = i24;
                }
                i2 = i23;
            } else {
                i2 = (!this.zziha || i22 < zzefv.DOUBLE_LIST_PACKED.id() || i22 > zzefv.SINT64_LIST_PACKED.id()) ? 0 : this.zzigs[i20 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzhh2 & 1048575);
            switch (i22) {
                case 0:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i17 += zzefl.zzc(i21, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i17 += zzefl.zzb(i21, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzefl.zzk(i21, unsafe2.getLong(t, j3));
                        i17 += i3;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzefl.zzl(i21, unsafe2.getLong(t, j3));
                        i17 += i3;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzefl.zzaf(i21, unsafe2.getInt(t, j3));
                        i17 += i3;
                    }
                    break;
                case 5:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzefl.zzn(i21, 0);
                        i17 += i3;
                    }
                    break;
                case 6:
                    if ((i19 & i) != 0) {
                        i17 += zzefl.zzai(i21, 0);
                        j = 0;
                        break;
                    }
                    j = 0;
                case 7:
                    if ((i19 & i) != 0) {
                        zzi = zzefl.zzi(i21, true);
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 8:
                    if ((i19 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        zzi = object instanceof zzeer ? zzefl.zzc(i21, (zzeer) object) : zzefl.zzl(i21, (String) object);
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 9:
                    if ((i19 & i) != 0) {
                        zzi = zzeij.zzc(i21, unsafe2.getObject(t, j3), zzhe(i20));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 10:
                    if ((i19 & i) != 0) {
                        zzi = zzefl.zzc(i21, (zzeer) unsafe2.getObject(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 11:
                    if ((i19 & i) != 0) {
                        zzi = zzefl.zzag(i21, unsafe2.getInt(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 12:
                    if ((i19 & i) != 0) {
                        zzi = zzefl.zzak(i21, unsafe2.getInt(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 13:
                    if ((i19 & i) != 0) {
                        i4 = zzefl.zzaj(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 14:
                    if ((i19 & i) != 0) {
                        zzi = zzefl.zzo(i21, 0);
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 15:
                    if ((i19 & i) != 0) {
                        zzi = zzefl.zzah(i21, unsafe2.getInt(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 16:
                    if ((i19 & i) != 0) {
                        zzi = zzefl.zzm(i21, unsafe2.getLong(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 17:
                    if ((i19 & i) != 0) {
                        zzi = zzefl.zzc(i21, (zzehl) unsafe2.getObject(t, j3), zzhe(i20));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 18:
                    zzi = zzeij.zzw(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 19:
                    zzi = zzeij.zzv(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 20:
                    zzi = zzeij.zzo(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 21:
                    zzi = zzeij.zzp(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 22:
                    zzi = zzeij.zzs(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 23:
                    zzi = zzeij.zzw(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 24:
                    zzi = zzeij.zzv(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 25:
                    zzi = zzeij.zzx(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 26:
                    zzi = zzeij.zzc(i21, (List) unsafe2.getObject(t, j3));
                    i17 += zzi;
                    j = 0;
                    break;
                case 27:
                    zzi = zzeij.zzc(i21, (List<?>) ((List) unsafe2.getObject(t, j3)), zzhe(i20));
                    i17 += zzi;
                    j = 0;
                    break;
                case 28:
                    zzi = zzeij.zzd(i21, (List) unsafe2.getObject(t, j3));
                    i17 += zzi;
                    j = 0;
                    break;
                case 29:
                    zzi = zzeij.zzt(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 30:
                    zzi = zzeij.zzr(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 31:
                    zzi = zzeij.zzv(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 32:
                    zzi = zzeij.zzw(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 33:
                    zzi = zzeij.zzu(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 34:
                    zzi = zzeij.zzq(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzi;
                    j = 0;
                    break;
                case 35:
                    i7 = zzeij.zzai((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 36:
                    i7 = zzeij.zzah((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 37:
                    i7 = zzeij.zzaa((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 38:
                    i7 = zzeij.zzab((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 39:
                    i7 = zzeij.zzae((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 40:
                    i7 = zzeij.zzai((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 41:
                    i7 = zzeij.zzah((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 42:
                    i7 = zzeij.zzaj((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 43:
                    i7 = zzeij.zzaf((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 44:
                    i7 = zzeij.zzad((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 45:
                    i7 = zzeij.zzah((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 46:
                    i7 = zzeij.zzai((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 47:
                    i7 = zzeij.zzag((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 48:
                    i7 = zzeij.zzac((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zziha) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzefl.zzgp(i21);
                        i5 = zzefl.zzgr(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 49:
                    zzi = zzeij.zzd(i21, (List) unsafe2.getObject(t, j3), zzhe(i20));
                    i17 += zzi;
                    j = 0;
                    break;
                case 50:
                    zzi = this.zzihi.zzb(i21, unsafe2.getObject(t, j3), zzhf(i20));
                    i17 += zzi;
                    j = 0;
                    break;
                case 51:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzc(i21, 0.0d);
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 52:
                    if (zza(t, i21, i20)) {
                        i4 = zzefl.zzb(i21, 0.0f);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 53:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzk(i21, zzi(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 54:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzl(i21, zzi(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 55:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzaf(i21, zzh(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 56:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzn(i21, 0);
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 57:
                    if (zza(t, i21, i20)) {
                        i4 = zzefl.zzai(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 58:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzi(i21, true);
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 59:
                    if (zza(t, i21, i20)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzeer) {
                            zzi = zzefl.zzc(i21, (zzeer) object2);
                        } else {
                            zzi = zzefl.zzl(i21, (String) object2);
                        }
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 60:
                    if (zza(t, i21, i20)) {
                        zzi = zzeij.zzc(i21, unsafe2.getObject(t, j3), zzhe(i20));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 61:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzc(i21, (zzeer) unsafe2.getObject(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 62:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzag(i21, zzh(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 63:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzak(i21, zzh(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 64:
                    if (zza(t, i21, i20)) {
                        i4 = zzefl.zzaj(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 65:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzo(i21, 0);
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 66:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzah(i21, zzh(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 67:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzm(i21, zzi(t, j3));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                case 68:
                    if (zza(t, i21, i20)) {
                        zzi = zzefl.zzc(i21, (zzehl) unsafe2.getObject(t, j3), zzhe(i20));
                        i17 += zzi;
                    }
                    j = 0;
                    break;
                default:
                    j = 0;
                    break;
            }
        }
        int i25 = 0;
        int zza = i17 + zza((zzeiz) this.zzihg, (Object) t);
        if (!this.zzigx) {
            return zza;
        }
        zzefu<?> zzah = this.zzihh.zzah(t);
        for (int i26 = 0; i26 < zzah.zzibl.zzbhj(); i26++) {
            Map.Entry<T, Object> zzho = zzah.zzibl.zzho(i26);
            i25 += zzefu.zzb((zzefw<?>) zzho.getKey(), zzho.getValue());
        }
        for (Map.Entry<T, Object> entry : zzah.zzibl.zzbhk()) {
            i25 += zzefu.zzb((zzefw<?>) entry.getKey(), entry.getValue());
        }
        return zza + i25;
    }

    private static <UT, UB> int zza(zzeiz<UT, UB> zzeiz, T t) {
        return zzeiz.zzat(zzeiz.zzax(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzejf.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.ads.zzeih
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.ads.zzejw r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzbep()
            int r1 = com.google.android.gms.internal.ads.zzegb.zze.zzifa
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.ads.zzeiz<?, ?> r0 = r13.zzihg
            zza(r0, r14, r15)
            boolean r0 = r13.zzigx
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.ads.zzefq<?> r0 = r13.zzihh
            com.google.android.gms.internal.ads.zzefu r0 = r0.zzah(r14)
            com.google.android.gms.internal.ads.zzeim<T, java.lang.Object> r1 = r0.zzibl
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x0032
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0034
        L_0x0032:
            r0 = r3
            r1 = r0
        L_0x0034:
            int[] r7 = r13.zzigs
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzhh(r7)
            int[] r9 = r13.zzigs
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.ads.zzefq<?> r10 = r13.zzihh
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.ads.zzefq<?> r10 = r13.zzihh
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005f
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0043
        L_0x005f:
            r1 = r3
            goto L_0x0043
        L_0x0061:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04fe;
                case 1: goto L_0x04ee;
                case 2: goto L_0x04de;
                case 3: goto L_0x04ce;
                case 4: goto L_0x04be;
                case 5: goto L_0x04ae;
                case 6: goto L_0x049e;
                case 7: goto L_0x048d;
                case 8: goto L_0x047c;
                case 9: goto L_0x0467;
                case 10: goto L_0x0454;
                case 11: goto L_0x0443;
                case 12: goto L_0x0432;
                case 13: goto L_0x0421;
                case 14: goto L_0x0410;
                case 15: goto L_0x03ff;
                case 16: goto L_0x03ee;
                case 17: goto L_0x03d9;
                case 18: goto L_0x03c8;
                case 19: goto L_0x03b7;
                case 20: goto L_0x03a6;
                case 21: goto L_0x0395;
                case 22: goto L_0x0384;
                case 23: goto L_0x0373;
                case 24: goto L_0x0362;
                case 25: goto L_0x0351;
                case 26: goto L_0x0340;
                case 27: goto L_0x032b;
                case 28: goto L_0x031a;
                case 29: goto L_0x0309;
                case 30: goto L_0x02f8;
                case 31: goto L_0x02e7;
                case 32: goto L_0x02d6;
                case 33: goto L_0x02c5;
                case 34: goto L_0x02b4;
                case 35: goto L_0x02a3;
                case 36: goto L_0x0292;
                case 37: goto L_0x0281;
                case 38: goto L_0x0270;
                case 39: goto L_0x025f;
                case 40: goto L_0x024e;
                case 41: goto L_0x023d;
                case 42: goto L_0x022c;
                case 43: goto L_0x021b;
                case 44: goto L_0x020a;
                case 45: goto L_0x01f9;
                case 46: goto L_0x01e8;
                case 47: goto L_0x01d7;
                case 48: goto L_0x01c6;
                case 49: goto L_0x01b1;
                case 50: goto L_0x01a6;
                case 51: goto L_0x0195;
                case 52: goto L_0x0184;
                case 53: goto L_0x0173;
                case 54: goto L_0x0162;
                case 55: goto L_0x0151;
                case 56: goto L_0x0140;
                case 57: goto L_0x012f;
                case 58: goto L_0x011e;
                case 59: goto L_0x010d;
                case 60: goto L_0x00f8;
                case 61: goto L_0x00e5;
                case 62: goto L_0x00d4;
                case 63: goto L_0x00c3;
                case 64: goto L_0x00b2;
                case 65: goto L_0x00a1;
                case 66: goto L_0x0090;
                case 67: goto L_0x007f;
                case 68: goto L_0x006a;
                default: goto L_0x0068;
            }
        L_0x0068:
            goto L_0x050d
        L_0x006a:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeih r10 = r13.zzhe(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzad(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzq(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzal(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzam(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzac(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeer r8 = (com.google.android.gms.internal.ads.zzeer) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeih r10 = r13.zzhe(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzae(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzab(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzh(r9, r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzp(r9, r10)
            goto L_0x050d
        L_0x0184:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzg(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0195:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zzf(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeih r10 = r13.zzhe(r7)
            com.google.android.gms.internal.ads.zzeij.zzb(r9, r8, r15, r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzb(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zza(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeih r10 = r13.zzhe(r7)
            com.google.android.gms.internal.ads.zzeij.zza(r9, r8, r15, r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zza(r9, r8, r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzb(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzigs
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zza(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeih r10 = r13.zzhe(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r10)
            r15.zzad(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r10)
            r15.zzq(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r10)
            r15.zzal(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r10)
            r15.zzam(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r10)
            r15.zzac(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeer r8 = (com.google.android.gms.internal.ads.zzeer) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            com.google.android.gms.internal.ads.zzeih r10 = r13.zzhe(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.ads.zzejf.zzm(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r10)
            r15.zzae(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r10)
            r15.zzab(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r10)
            r15.zzh(r9, r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r10)
            r15.zzp(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.ads.zzejf.zzn(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zze(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.ads.zzejf.zzo(r14, r10)
            r15.zzb(r9, r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.ads.zzefq<?> r14 = r13.zzihh
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x0526
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x0511
        L_0x0526:
            r1 = r3
            goto L_0x0511
        L_0x0528:
            return
        L_0x0529:
            boolean r0 = r13.zzigz
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzigx
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.ads.zzefq<?> r0 = r13.zzihh
            com.google.android.gms.internal.ads.zzefu r0 = r0.zzah(r14)
            com.google.android.gms.internal.ads.zzeim<T, java.lang.Object> r1 = r0.zzibl
            boolean r1 = r1.isEmpty()
            if (r1 != 0) goto L_0x054a
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x054c
        L_0x054a:
            r0 = r3
            r1 = r0
        L_0x054c:
            int[] r7 = r13.zzigs
            int r7 = r7.length
            r8 = 0
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzhh(r8)
            int[] r10 = r13.zzigs
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.ads.zzefq<?> r11 = r13.zzihh
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.ads.zzefq<?> r11 = r13.zzihh
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0576
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x055a
        L_0x0576:
            r1 = r3
            goto L_0x055a
        L_0x0578:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0a15;
                case 1: goto L_0x0a05;
                case 2: goto L_0x09f5;
                case 3: goto L_0x09e5;
                case 4: goto L_0x09d5;
                case 5: goto L_0x09c5;
                case 6: goto L_0x09b5;
                case 7: goto L_0x09a4;
                case 8: goto L_0x0993;
                case 9: goto L_0x097e;
                case 10: goto L_0x096b;
                case 11: goto L_0x095a;
                case 12: goto L_0x0949;
                case 13: goto L_0x0938;
                case 14: goto L_0x0927;
                case 15: goto L_0x0916;
                case 16: goto L_0x0905;
                case 17: goto L_0x08f0;
                case 18: goto L_0x08df;
                case 19: goto L_0x08ce;
                case 20: goto L_0x08bd;
                case 21: goto L_0x08ac;
                case 22: goto L_0x089b;
                case 23: goto L_0x088a;
                case 24: goto L_0x0879;
                case 25: goto L_0x0868;
                case 26: goto L_0x0857;
                case 27: goto L_0x0842;
                case 28: goto L_0x0831;
                case 29: goto L_0x0820;
                case 30: goto L_0x080f;
                case 31: goto L_0x07fe;
                case 32: goto L_0x07ed;
                case 33: goto L_0x07dc;
                case 34: goto L_0x07cb;
                case 35: goto L_0x07ba;
                case 36: goto L_0x07a9;
                case 37: goto L_0x0798;
                case 38: goto L_0x0787;
                case 39: goto L_0x0776;
                case 40: goto L_0x0765;
                case 41: goto L_0x0754;
                case 42: goto L_0x0743;
                case 43: goto L_0x0732;
                case 44: goto L_0x0721;
                case 45: goto L_0x0710;
                case 46: goto L_0x06ff;
                case 47: goto L_0x06ee;
                case 48: goto L_0x06dd;
                case 49: goto L_0x06c8;
                case 50: goto L_0x06bd;
                case 51: goto L_0x06ac;
                case 52: goto L_0x069b;
                case 53: goto L_0x068a;
                case 54: goto L_0x0679;
                case 55: goto L_0x0668;
                case 56: goto L_0x0657;
                case 57: goto L_0x0646;
                case 58: goto L_0x0635;
                case 59: goto L_0x0624;
                case 60: goto L_0x060f;
                case 61: goto L_0x05fc;
                case 62: goto L_0x05eb;
                case 63: goto L_0x05da;
                case 64: goto L_0x05c9;
                case 65: goto L_0x05b8;
                case 66: goto L_0x05a7;
                case 67: goto L_0x0596;
                case 68: goto L_0x0581;
                default: goto L_0x057f;
            }
        L_0x057f:
            goto L_0x0a24
        L_0x0581:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeih r11 = r13.zzhe(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzad(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzq(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzal(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzam(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzac(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeer r9 = (com.google.android.gms.internal.ads.zzeer) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeih r11 = r13.zzhe(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzae(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzab(r10, r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzh(r10, r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzp(r10, r11)
            goto L_0x0a24
        L_0x069b:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzg(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x06ac:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zzf(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            r13.zza(r15, r10, r9, r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeih r11 = r13.zzhe(r8)
            com.google.android.gms.internal.ads.zzeij.zzb(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzb(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zza(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeih r11 = r13.zzhe(r8)
            com.google.android.gms.internal.ads.zzeij.zza(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zzb(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzigs
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.ads.zzeij.zza(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeih r11 = r13.zzhe(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r11)
            r15.zzad(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r11)
            r15.zzq(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r11)
            r15.zzal(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r11)
            r15.zzam(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r11)
            r15.zzac(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeer r9 = (com.google.android.gms.internal.ads.zzeer) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            com.google.android.gms.internal.ads.zzeih r11 = r13.zzhe(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.ads.zzejf.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.ads.zzejf.zzm(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r11)
            r15.zzae(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.ads.zzejf.zzk(r14, r11)
            r15.zzab(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r11)
            r15.zzh(r10, r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.ads.zzejf.zzl(r14, r11)
            r15.zzp(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.ads.zzejf.zzn(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zze(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.ads.zzejf.zzo(r14, r11)
            r15.zzb(r10, r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.ads.zzefq<?> r2 = r13.zzihh
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0a3c
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0a28
        L_0x0a3c:
            r1 = r3
            goto L_0x0a28
        L_0x0a3e:
            com.google.android.gms.internal.ads.zzeiz<?, ?> r0 = r13.zzihg
            zza(r0, r14, r15)
            return
        L_0x0a44:
            r13.zzb(r14, r15)
            return
            switch-data {0->0x04fe, 1->0x04ee, 2->0x04de, 3->0x04ce, 4->0x04be, 5->0x04ae, 6->0x049e, 7->0x048d, 8->0x047c, 9->0x0467, 10->0x0454, 11->0x0443, 12->0x0432, 13->0x0421, 14->0x0410, 15->0x03ff, 16->0x03ee, 17->0x03d9, 18->0x03c8, 19->0x03b7, 20->0x03a6, 21->0x0395, 22->0x0384, 23->0x0373, 24->0x0362, 25->0x0351, 26->0x0340, 27->0x032b, 28->0x031a, 29->0x0309, 30->0x02f8, 31->0x02e7, 32->0x02d6, 33->0x02c5, 34->0x02b4, 35->0x02a3, 36->0x0292, 37->0x0281, 38->0x0270, 39->0x025f, 40->0x024e, 41->0x023d, 42->0x022c, 43->0x021b, 44->0x020a, 45->0x01f9, 46->0x01e8, 47->0x01d7, 48->0x01c6, 49->0x01b1, 50->0x01a6, 51->0x0195, 52->0x0184, 53->0x0173, 54->0x0162, 55->0x0151, 56->0x0140, 57->0x012f, 58->0x011e, 59->0x010d, 60->0x00f8, 61->0x00e5, 62->0x00d4, 63->0x00c3, 64->0x00b2, 65->0x00a1, 66->0x0090, 67->0x007f, 68->0x006a, }
            switch-data {0->0x0a15, 1->0x0a05, 2->0x09f5, 3->0x09e5, 4->0x09d5, 5->0x09c5, 6->0x09b5, 7->0x09a4, 8->0x0993, 9->0x097e, 10->0x096b, 11->0x095a, 12->0x0949, 13->0x0938, 14->0x0927, 15->0x0916, 16->0x0905, 17->0x08f0, 18->0x08df, 19->0x08ce, 20->0x08bd, 21->0x08ac, 22->0x089b, 23->0x088a, 24->0x0879, 25->0x0868, 26->0x0857, 27->0x0842, 28->0x0831, 29->0x0820, 30->0x080f, 31->0x07fe, 32->0x07ed, 33->0x07dc, 34->0x07cb, 35->0x07ba, 36->0x07a9, 37->0x0798, 38->0x0787, 39->0x0776, 40->0x0765, 41->0x0754, 42->0x0743, 43->0x0732, 44->0x0721, 45->0x0710, 46->0x06ff, 47->0x06ee, 48->0x06dd, 49->0x06c8, 50->0x06bd, 51->0x06ac, 52->0x069b, 53->0x068a, 54->0x0679, 55->0x0668, 56->0x0657, 57->0x0646, 58->0x0635, 59->0x0624, 60->0x060f, 61->0x05fc, 62->0x05eb, 63->0x05da, 64->0x05c9, 65->0x05b8, 66->0x05a7, 67->0x0596, 68->0x0581, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehp.zza(java.lang.Object, com.google.android.gms.internal.ads.zzejw):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.ads.zzejw r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzigx
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.ads.zzefq<?> r3 = r0.zzihh
            com.google.android.gms.internal.ads.zzefu r3 = r3.zzah(r1)
            com.google.android.gms.internal.ads.zzeim<T, java.lang.Object> r5 = r3.zzibl
            boolean r5 = r5.isEmpty()
            if (r5 != 0) goto L_0x0023
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0025
        L_0x0023:
            r3 = 0
            r5 = 0
        L_0x0025:
            int[] r6 = r0.zzigs
            int r6 = r6.length
            sun.misc.Unsafe r7 = com.google.android.gms.internal.ads.zzehp.zzhni
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x002f:
            if (r10 >= r6) goto L_0x0493
            int r13 = r0.zzhh(r10)
            int[] r14 = r0.zzigs
            r15 = r14[r10]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            boolean r9 = r0.zzigz
            if (r9 != 0) goto L_0x005e
            r9 = 17
            if (r4 > r9) goto L_0x005e
            int r9 = r10 + 2
            r9 = r14[r9]
            r14 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r9 & r14
            if (r8 == r11) goto L_0x0058
            long r11 = (long) r8
            int r12 = r7.getInt(r1, r11)
            r11 = r8
        L_0x0058:
            int r8 = r9 >>> 20
            r9 = 1
            int r8 = r9 << r8
            goto L_0x005f
        L_0x005e:
            r8 = 0
        L_0x005f:
            if (r5 == 0) goto L_0x007d
            com.google.android.gms.internal.ads.zzefq<?> r9 = r0.zzihh
            int r9 = r9.zza(r5)
            if (r9 > r15) goto L_0x007d
            com.google.android.gms.internal.ads.zzefq<?> r9 = r0.zzihh
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007b
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x005f
        L_0x007b:
            r5 = 0
            goto L_0x005f
        L_0x007d:
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r13 = r13 & r9
            long r13 = (long) r13
            switch(r4) {
                case 0: goto L_0x0484;
                case 1: goto L_0x0478;
                case 2: goto L_0x046c;
                case 3: goto L_0x0460;
                case 4: goto L_0x0454;
                case 5: goto L_0x0448;
                case 6: goto L_0x043c;
                case 7: goto L_0x0430;
                case 8: goto L_0x0424;
                case 9: goto L_0x0413;
                case 10: goto L_0x0404;
                case 11: goto L_0x03f7;
                case 12: goto L_0x03ea;
                case 13: goto L_0x03dd;
                case 14: goto L_0x03d0;
                case 15: goto L_0x03c3;
                case 16: goto L_0x03b6;
                case 17: goto L_0x03a5;
                case 18: goto L_0x0395;
                case 19: goto L_0x0385;
                case 20: goto L_0x0375;
                case 21: goto L_0x0365;
                case 22: goto L_0x0355;
                case 23: goto L_0x0345;
                case 24: goto L_0x0335;
                case 25: goto L_0x0325;
                case 26: goto L_0x0316;
                case 27: goto L_0x0303;
                case 28: goto L_0x02f4;
                case 29: goto L_0x02e4;
                case 30: goto L_0x02d4;
                case 31: goto L_0x02c4;
                case 32: goto L_0x02b4;
                case 33: goto L_0x02a4;
                case 34: goto L_0x0294;
                case 35: goto L_0x0284;
                case 36: goto L_0x0274;
                case 37: goto L_0x0264;
                case 38: goto L_0x0254;
                case 39: goto L_0x0244;
                case 40: goto L_0x0234;
                case 41: goto L_0x0224;
                case 42: goto L_0x0214;
                case 43: goto L_0x0204;
                case 44: goto L_0x01f4;
                case 45: goto L_0x01e4;
                case 46: goto L_0x01d4;
                case 47: goto L_0x01c4;
                case 48: goto L_0x01b4;
                case 49: goto L_0x01a1;
                case 50: goto L_0x0198;
                case 51: goto L_0x0189;
                case 52: goto L_0x017a;
                case 53: goto L_0x016b;
                case 54: goto L_0x015c;
                case 55: goto L_0x014d;
                case 56: goto L_0x013e;
                case 57: goto L_0x012f;
                case 58: goto L_0x0120;
                case 59: goto L_0x0111;
                case 60: goto L_0x00fe;
                case 61: goto L_0x00ee;
                case 62: goto L_0x00e0;
                case 63: goto L_0x00d2;
                case 64: goto L_0x00c4;
                case 65: goto L_0x00b6;
                case 66: goto L_0x00a8;
                case 67: goto L_0x009a;
                case 68: goto L_0x0088;
                default: goto L_0x0085;
            }
        L_0x0085:
            r4 = 0
            goto L_0x048f
        L_0x0088:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.ads.zzeih r8 = r0.zzhe(r10)
            r2.zzb(r15, r4, r8)
            goto L_0x0085
        L_0x009a:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzi(r15, r13)
            goto L_0x0085
        L_0x00a8:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzad(r15, r4)
            goto L_0x0085
        L_0x00b6:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzq(r15, r13)
            goto L_0x0085
        L_0x00c4:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzal(r15, r4)
            goto L_0x0085
        L_0x00d2:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzam(r15, r4)
            goto L_0x0085
        L_0x00e0:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzac(r15, r4)
            goto L_0x0085
        L_0x00ee:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.ads.zzeer r4 = (com.google.android.gms.internal.ads.zzeer) r4
            r2.zza(r15, r4)
            goto L_0x0085
        L_0x00fe:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.ads.zzeih r8 = r0.zzhe(r10)
            r2.zza(r15, r4, r8)
            goto L_0x0085
        L_0x0111:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            zza(r15, r4, r2)
            goto L_0x0085
        L_0x0120:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            boolean r4 = zzj(r1, r13)
            r2.zzh(r15, r4)
            goto L_0x0085
        L_0x012f:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzae(r15, r4)
            goto L_0x0085
        L_0x013e:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzj(r15, r13)
            goto L_0x0085
        L_0x014d:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzab(r15, r4)
            goto L_0x0085
        L_0x015c:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzh(r15, r13)
            goto L_0x0085
        L_0x016b:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzp(r15, r13)
            goto L_0x0085
        L_0x017a:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            float r4 = zzg(r1, r13)
            r2.zza(r15, r4)
            goto L_0x0085
        L_0x0189:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            double r13 = zzf(r1, r13)
            r2.zzb(r15, r13)
            goto L_0x0085
        L_0x0198:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza(r2, r15, r4, r10)
            goto L_0x0085
        L_0x01a1:
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeih r13 = r0.zzhe(r10)
            com.google.android.gms.internal.ads.zzeij.zzb(r4, r8, r2, r13)
            goto L_0x0085
        L_0x01b4:
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 1
            com.google.android.gms.internal.ads.zzeij.zze(r4, r8, r2, r15)
            goto L_0x0085
        L_0x01c4:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzj(r4, r8, r2, r15)
            goto L_0x0085
        L_0x01d4:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzg(r4, r8, r2, r15)
            goto L_0x0085
        L_0x01e4:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzl(r4, r8, r2, r15)
            goto L_0x0085
        L_0x01f4:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzm(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0204:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzi(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0214:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzn(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0224:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzk(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0234:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzf(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0244:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzh(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0254:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzd(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0264:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzc(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0274:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzb(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0284:
            r15 = 1
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zza(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0294:
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.ads.zzeij.zze(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02a4:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzj(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02b4:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzg(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02c4:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzl(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02d4:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzm(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02e4:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzi(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02f4:
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzb(r4, r8, r2)
            goto L_0x0085
        L_0x0303:
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeih r13 = r0.zzhe(r10)
            com.google.android.gms.internal.ads.zzeij.zza(r4, r8, r2, r13)
            goto L_0x0085
        L_0x0316:
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zza(r4, r8, r2)
            goto L_0x0085
        L_0x0325:
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.ads.zzeij.zzn(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0335:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzk(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0345:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzf(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0355:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzh(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0365:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzd(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0375:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzc(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0385:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zzb(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0395:
            r15 = 0
            int[] r4 = r0.zzigs
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.ads.zzeij.zza(r4, r8, r2, r15)
            goto L_0x0085
        L_0x03a5:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.ads.zzeih r13 = r0.zzhe(r10)
            r2.zzb(r15, r8, r13)
            goto L_0x048f
        L_0x03b6:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzi(r15, r13)
            goto L_0x048f
        L_0x03c3:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzad(r15, r8)
            goto L_0x048f
        L_0x03d0:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzq(r15, r13)
            goto L_0x048f
        L_0x03dd:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzal(r15, r8)
            goto L_0x048f
        L_0x03ea:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzam(r15, r8)
            goto L_0x048f
        L_0x03f7:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzac(r15, r8)
            goto L_0x048f
        L_0x0404:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.ads.zzeer r8 = (com.google.android.gms.internal.ads.zzeer) r8
            r2.zza(r15, r8)
            goto L_0x048f
        L_0x0413:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.ads.zzeih r13 = r0.zzhe(r10)
            r2.zza(r15, r8, r13)
            goto L_0x048f
        L_0x0424:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            java.lang.Object r8 = r7.getObject(r1, r13)
            zza(r15, r8, r2)
            goto L_0x048f
        L_0x0430:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            boolean r8 = com.google.android.gms.internal.ads.zzejf.zzm(r1, r13)
            r2.zzh(r15, r8)
            goto L_0x048f
        L_0x043c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzae(r15, r8)
            goto L_0x048f
        L_0x0448:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzj(r15, r13)
            goto L_0x048f
        L_0x0454:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzab(r15, r8)
            goto L_0x048f
        L_0x0460:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzh(r15, r13)
            goto L_0x048f
        L_0x046c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzp(r15, r13)
            goto L_0x048f
        L_0x0478:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            float r8 = com.google.android.gms.internal.ads.zzejf.zzn(r1, r13)
            r2.zza(r15, r8)
            goto L_0x048f
        L_0x0484:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            double r13 = com.google.android.gms.internal.ads.zzejf.zzo(r1, r13)
            r2.zzb(r15, r13)
        L_0x048f:
            int r10 = r10 + 3
            goto L_0x002f
        L_0x0493:
            if (r5 == 0) goto L_0x04aa
            com.google.android.gms.internal.ads.zzefq<?> r4 = r0.zzihh
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a8
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x0493
        L_0x04a8:
            r5 = 0
            goto L_0x0493
        L_0x04aa:
            com.google.android.gms.internal.ads.zzeiz<?, ?> r3 = r0.zzihg
            zza(r3, r1, r2)
            return
            switch-data {0->0x0484, 1->0x0478, 2->0x046c, 3->0x0460, 4->0x0454, 5->0x0448, 6->0x043c, 7->0x0430, 8->0x0424, 9->0x0413, 10->0x0404, 11->0x03f7, 12->0x03ea, 13->0x03dd, 14->0x03d0, 15->0x03c3, 16->0x03b6, 17->0x03a5, 18->0x0395, 19->0x0385, 20->0x0375, 21->0x0365, 22->0x0355, 23->0x0345, 24->0x0335, 25->0x0325, 26->0x0316, 27->0x0303, 28->0x02f4, 29->0x02e4, 30->0x02d4, 31->0x02c4, 32->0x02b4, 33->0x02a4, 34->0x0294, 35->0x0284, 36->0x0274, 37->0x0264, 38->0x0254, 39->0x0244, 40->0x0234, 41->0x0224, 42->0x0214, 43->0x0204, 44->0x01f4, 45->0x01e4, 46->0x01d4, 47->0x01c4, 48->0x01b4, 49->0x01a1, 50->0x0198, 51->0x0189, 52->0x017a, 53->0x016b, 54->0x015c, 55->0x014d, 56->0x013e, 57->0x012f, 58->0x0120, 59->0x0111, 60->0x00fe, 61->0x00ee, 62->0x00e0, 63->0x00d2, 64->0x00c4, 65->0x00b6, 66->0x00a8, 67->0x009a, 68->0x0088, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehp.zzb(java.lang.Object, com.google.android.gms.internal.ads.zzejw):void");
    }

    private final <K, V> void zza(zzejw zzejw, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzejw.zza(i, this.zzihi.zzao(zzhf(i2)), this.zzihi.zzap(obj));
        }
    }

    private static <UT, UB> void zza(zzeiz<UT, UB> zzeiz, T t, zzejw zzejw) throws IOException {
        zzeiz.zza(zzeiz.zzax(t), zzejw);
    }

    /*  JADX ERROR: StackOverflowError in pass: MarkFinallyVisitor
        java.lang.StackOverflowError
        	at jadx.core.dex.nodes.InsnNode.isSame(InsnNode.java:303)
        	at jadx.core.dex.instructions.IndexInsnNode.isSame(IndexInsnNode.java:32)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.sameInsns(MarkFinallyVisitor.java:451)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.compareBlocks(MarkFinallyVisitor.java:436)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:408)
        	at jadx.core.dex.visitors.MarkFinallyVisitor.checkBlocksTree(MarkFinallyVisitor.java:411)
        */
    @Override // com.google.android.gms.internal.ads.zzeih
    public final void zza(T r13, com.google.android.gms.internal.ads.zzeib r14, com.google.android.gms.internal.ads.zzefo r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05dc
            com.google.android.gms.internal.ads.zzeiz<?, ?> r8 = r12.zzihg
            com.google.android.gms.internal.ads.zzefq<?> r9 = r12.zzihh
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zzbek()     // Catch:{ all -> 0x05c4 }
            int r3 = r12.zzhk(r2)     // Catch:{ all -> 0x05c4 }
            if (r3 >= 0) goto L_0x0077
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzihc
        L_0x001a:
            int r15 = r12.zzihd
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzihb
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r8.zzj(r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r3 = r12.zzigx
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.ads.zzehl r3 = r12.zzigw
            java.lang.Object r2 = r9.zza(r15, r3, r2)
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzefu r1 = r9.zzai(r13)
        L_0x0044:
            r11 = r1
            r1 = r9
            r2 = r14
            r4 = r15
            r5 = r11
            r6 = r10
            r7 = r8
            java.lang.Object r10 = r1.zza(r2, r3, r4, r5, r6, r7)
            r1 = r11
            goto L_0x0009
        L_0x0051:
            r8.zza(r14)
            if (r10 != 0) goto L_0x005a
            java.lang.Object r10 = r8.zzay(r13)
        L_0x005a:
            boolean r2 = r8.zza(r10, r14)
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzihc
        L_0x0062:
            int r15 = r12.zzihd
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzihb
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x0076
            r8.zzj(r13, r10)
        L_0x0076:
            return
        L_0x0077:
            int r4 = r12.zzhh(r3)
            r5 = 267386880(0xff00000, float:2.3665827E-29)
            r5 = r5 & r4
            int r5 = r5 >>> 20
            r6 = 1048575(0xfffff, float:1.469367E-39)
            switch(r5) {
                case 0: goto L_0x0571;
                case 1: goto L_0x0562;
                case 2: goto L_0x0553;
                case 3: goto L_0x0544;
                case 4: goto L_0x0535;
                case 5: goto L_0x0526;
                case 6: goto L_0x0517;
                case 7: goto L_0x0508;
                case 8: goto L_0x0500;
                case 9: goto L_0x04cf;
                case 10: goto L_0x04c0;
                case 11: goto L_0x04b1;
                case 12: goto L_0x048f;
                case 13: goto L_0x0480;
                case 14: goto L_0x0471;
                case 15: goto L_0x0462;
                case 16: goto L_0x0453;
                case 17: goto L_0x0422;
                case 18: goto L_0x0414;
                case 19: goto L_0x0406;
                case 20: goto L_0x03f8;
                case 21: goto L_0x03ea;
                case 22: goto L_0x03dc;
                case 23: goto L_0x03ce;
                case 24: goto L_0x03c0;
                case 25: goto L_0x03b2;
                case 26: goto L_0x0390;
                case 27: goto L_0x037e;
                case 28: goto L_0x0370;
                case 29: goto L_0x0362;
                case 30: goto L_0x034d;
                case 31: goto L_0x033f;
                case 32: goto L_0x0331;
                case 33: goto L_0x0323;
                case 34: goto L_0x0315;
                case 35: goto L_0x0307;
                case 36: goto L_0x02f9;
                case 37: goto L_0x02eb;
                case 38: goto L_0x02dd;
                case 39: goto L_0x02cf;
                case 40: goto L_0x02c1;
                case 41: goto L_0x02b3;
                case 42: goto L_0x02a5;
                case 43: goto L_0x0297;
                case 44: goto L_0x0282;
                case 45: goto L_0x0274;
                case 46: goto L_0x0266;
                case 47: goto L_0x0258;
                case 48: goto L_0x024a;
                case 49: goto L_0x0238;
                case 50: goto L_0x01f6;
                case 51: goto L_0x01e4;
                case 52: goto L_0x01d2;
                case 53: goto L_0x01c0;
                case 54: goto L_0x01ae;
                case 55: goto L_0x019c;
                case 56: goto L_0x018a;
                case 57: goto L_0x0178;
                case 58: goto L_0x0166;
                case 59: goto L_0x015e;
                case 60: goto L_0x012d;
                case 61: goto L_0x011f;
                case 62: goto L_0x010d;
                case 63: goto L_0x00e8;
                case 64: goto L_0x00d6;
                case 65: goto L_0x00c4;
                case 66: goto L_0x00b2;
                case 67: goto L_0x00a0;
                case 68: goto L_0x008e;
                default: goto L_0x0086;
            }
        L_0x0086:
            if (r10 != 0) goto L_0x0580
            java.lang.Object r10 = r8.zzbhr()     // Catch:{ zzego -> 0x059d }
            goto L_0x0580
        L_0x008e:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeih r6 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r6 = r14.zzb(r6, r15)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x00a0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbea()     // Catch:{ zzego -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x00b2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            int r6 = r14.zzbdz()     // Catch:{ zzego -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x00c4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbdy()     // Catch:{ zzego -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x00d6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            int r6 = r14.zzbdx()     // Catch:{ zzego -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x00e8:
            int r5 = r14.zzbdw()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzegi r7 = r12.zzhg(r3)     // Catch:{ zzego -> 0x059d }
            if (r7 == 0) goto L_0x00ff
            boolean r7 = r7.zzi(r5)     // Catch:{ zzego -> 0x059d }
            if (r7 == 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeij.zza(r2, r5, r10, r8)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x00ff:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzego -> 0x059d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r6, r4)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x010d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            int r6 = r14.zzbdv()     // Catch:{ zzego -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x011f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeer r6 = r14.zzbdu()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x012d:
            boolean r5 = r12.zza(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            if (r5 == 0) goto L_0x0149
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzejf.zzp(r13, r4)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeih r7 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.ads.zzegd.zze(r6, r7)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            goto L_0x0159
        L_0x0149:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeih r6 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
        L_0x0159:
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x015e:
            r12.zza(r13, r4, r14)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0166:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            boolean r6 = r14.zzbds()     // Catch:{ zzego -> 0x059d }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0178:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            int r6 = r14.zzbdr()     // Catch:{ zzego -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x018a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbdq()     // Catch:{ zzego -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x019c:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            int r6 = r14.zzbdp()     // Catch:{ zzego -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x01ae:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbdn()     // Catch:{ zzego -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x01c0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbdo()     // Catch:{ zzego -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x01d2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            float r6 = r14.readFloat()     // Catch:{ zzego -> 0x059d }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x01e4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzego -> 0x059d }
            double r6 = r14.readDouble()     // Catch:{ zzego -> 0x059d }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x01f6:
            java.lang.Object r2 = r12.zzhf(r3)     // Catch:{ zzego -> 0x059d }
            int r3 = r12.zzhh(r3)     // Catch:{ zzego -> 0x059d }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.ads.zzejf.zzp(r13, r3)     // Catch:{ zzego -> 0x059d }
            if (r5 != 0) goto L_0x0210
            com.google.android.gms.internal.ads.zzehi r5 = r12.zzihi     // Catch:{ zzego -> 0x059d }
            java.lang.Object r5 = r5.zzas(r2)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r3, r5)     // Catch:{ zzego -> 0x059d }
            goto L_0x0227
        L_0x0210:
            com.google.android.gms.internal.ads.zzehi r6 = r12.zzihi     // Catch:{ zzego -> 0x059d }
            boolean r6 = r6.zzaq(r5)     // Catch:{ zzego -> 0x059d }
            if (r6 == 0) goto L_0x0227
            com.google.android.gms.internal.ads.zzehi r6 = r12.zzihi     // Catch:{ zzego -> 0x059d }
            java.lang.Object r6 = r6.zzas(r2)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzehi r7 = r12.zzihi     // Catch:{ zzego -> 0x059d }
            r7.zzf(r6, r5)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r3, r6)     // Catch:{ zzego -> 0x059d }
            r5 = r6
        L_0x0227:
            com.google.android.gms.internal.ads.zzehi r3 = r12.zzihi     // Catch:{ zzego -> 0x059d }
            java.util.Map r3 = r3.zzan(r5)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzehi r4 = r12.zzihi     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzehg r2 = r4.zzao(r2)     // Catch:{ zzego -> 0x059d }
            r14.zza(r3, r2, r15)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0238:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeih r2 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzegv r3 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzego -> 0x059d }
            r14.zzb(r3, r2, r15)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x024a:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzz(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0258:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzy(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0266:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzx(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0274:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzw(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0282:
            com.google.android.gms.internal.ads.zzegv r5 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzego -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzego -> 0x059d }
            r14.zzv(r4)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzegi r3 = r12.zzhg(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeij.zza(r2, r4, r3, r10, r8)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0297:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzu(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x02a5:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzr(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x02b3:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzq(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x02c1:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x02cf:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x02dd:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzm(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x02eb:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x02f9:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzl(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0307:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0315:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzz(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0323:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzy(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0331:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzx(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x033f:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzw(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x034d:
            com.google.android.gms.internal.ads.zzegv r5 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzego -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzego -> 0x059d }
            r14.zzv(r4)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzegi r3 = r12.zzhg(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeij.zza(r2, r4, r3, r10, r8)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0362:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzu(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0370:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzt(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x037e:
            com.google.android.gms.internal.ads.zzeih r2 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzegv r5 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zza(r3, r2, r15)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0390:
            boolean r2 = zzhj(r4)     // Catch:{ zzego -> 0x059d }
            if (r2 == 0) goto L_0x03a4
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzs(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x03a4:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.readStringList(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x03b2:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzr(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x03c0:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzq(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x03ce:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x03dc:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x03ea:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzm(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x03f8:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0406:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzl(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0414:
            com.google.android.gms.internal.ads.zzegv r2 = r12.zzihf     // Catch:{ zzego -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzego -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzego -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0422:
            boolean r2 = r12.zze(r13, r3)     // Catch:{ zzego -> 0x059d }
            if (r2 == 0) goto L_0x0440
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzejf.zzp(r13, r4)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeih r3 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r3 = r14.zzb(r3, r15)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzegd.zze(r2, r3)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0440:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeih r2 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r2 = r14.zzb(r2, r15)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0453:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbea()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0462:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            int r2 = r14.zzbdz()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zzb(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0471:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbdy()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0480:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            int r2 = r14.zzbdx()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zzb(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x048f:
            int r5 = r14.zzbdw()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzegi r7 = r12.zzhg(r3)     // Catch:{ zzego -> 0x059d }
            if (r7 == 0) goto L_0x04a6
            boolean r7 = r7.zzi(r5)     // Catch:{ zzego -> 0x059d }
            if (r7 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r10 = com.google.android.gms.internal.ads.zzeij.zza(r2, r5, r10, r8)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x04a6:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zzb(r13, r6, r5)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x04b1:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            int r2 = r14.zzbdv()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zzb(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x04c0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeer r2 = r14.zzbdu()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x04cf:
            boolean r2 = r12.zze(r13, r3)     // Catch:{ zzego -> 0x059d }
            if (r2 == 0) goto L_0x04ed
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzejf.zzp(r13, r4)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeih r3 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.ads.zzegd.zze(r2, r3)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x04ed:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzeih r2 = r12.zzhe(r3)     // Catch:{ zzego -> 0x059d }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0500:
            r12.zza(r13, r4, r14)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0508:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            boolean r2 = r14.zzbds()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0517:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            int r2 = r14.zzbdr()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zzb(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0526:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbdq()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0535:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            int r2 = r14.zzbdp()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zzb(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0544:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbdn()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0553:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            long r6 = r14.zzbdo()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0562:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            float r2 = r14.readFloat()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r2)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0571:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzego -> 0x059d }
            double r6 = r14.readDouble()     // Catch:{ zzego -> 0x059d }
            com.google.android.gms.internal.ads.zzejf.zza(r13, r4, r6)     // Catch:{ zzego -> 0x059d }
            r12.zzf(r13, r3)     // Catch:{ zzego -> 0x059d }
            goto L_0x0009
        L_0x0580:
            boolean r2 = r8.zza(r10, r14)     // Catch:{ zzego -> 0x059d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzihc
        L_0x0588:
            int r15 = r12.zzihd
            if (r14 >= r15) goto L_0x0597
            int[] r15 = r12.zzihb
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0588
        L_0x0597:
            if (r10 == 0) goto L_0x059c
            r8.zzj(r13, r10)
        L_0x059c:
            return
        L_0x059d:
            r8.zza(r14)
            if (r10 != 0) goto L_0x05a7
            java.lang.Object r2 = r8.zzay(r13)
            r10 = r2
        L_0x05a7:
            boolean r2 = r8.zza(r10, r14)
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzihc
        L_0x05af:
            int r15 = r12.zzihd
            if (r14 >= r15) goto L_0x05be
            int[] r15 = r12.zzihb
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05af
        L_0x05be:
            if (r10 == 0) goto L_0x05c3
            r8.zzj(r13, r10)
        L_0x05c3:
            return
        L_0x05c4:
            r14 = move-exception
            int r15 = r12.zzihc
        L_0x05c7:
            int r0 = r12.zzihd
            if (r15 >= r0) goto L_0x05d6
            int[] r0 = r12.zzihb
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza(r13, r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c7
        L_0x05d6:
            if (r10 == 0) goto L_0x05db
            r8.zzj(r13, r10)
        L_0x05db:
            throw r14
        L_0x05dc:
            throw r0
            switch-data {0->0x0571, 1->0x0562, 2->0x0553, 3->0x0544, 4->0x0535, 5->0x0526, 6->0x0517, 7->0x0508, 8->0x0500, 9->0x04cf, 10->0x04c0, 11->0x04b1, 12->0x048f, 13->0x0480, 14->0x0471, 15->0x0462, 16->0x0453, 17->0x0422, 18->0x0414, 19->0x0406, 20->0x03f8, 21->0x03ea, 22->0x03dc, 23->0x03ce, 24->0x03c0, 25->0x03b2, 26->0x0390, 27->0x037e, 28->0x0370, 29->0x0362, 30->0x034d, 31->0x033f, 32->0x0331, 33->0x0323, 34->0x0315, 35->0x0307, 36->0x02f9, 37->0x02eb, 38->0x02dd, 39->0x02cf, 40->0x02c1, 41->0x02b3, 42->0x02a5, 43->0x0297, 44->0x0282, 45->0x0274, 46->0x0266, 47->0x0258, 48->0x024a, 49->0x0238, 50->0x01f6, 51->0x01e4, 52->0x01d2, 53->0x01c0, 54->0x01ae, 55->0x019c, 56->0x018a, 57->0x0178, 58->0x0166, 59->0x015e, 60->0x012d, 61->0x011f, 62->0x010d, 63->0x00e8, 64->0x00d6, 65->0x00c4, 66->0x00b2, 67->0x00a0, 68->0x008e, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehp.zza(java.lang.Object, com.google.android.gms.internal.ads.zzeib, com.google.android.gms.internal.ads.zzefo):void");
    }

    private static zzejc zzau(Object obj) {
        zzegb zzegb = (zzegb) obj;
        zzejc zzejc = zzegb.zzieg;
        if (zzejc != zzejc.zzbhs()) {
            return zzejc;
        }
        zzejc zzbht = zzejc.zzbht();
        zzegb.zzieg = zzbht;
        return zzbht;
    }

    private static int zza(byte[] bArr, int i, int i2, zzejq zzejq, Class<?> cls, zzeem zzeem) throws IOException {
        switch (zzehs.zziau[zzejq.ordinal()]) {
            case 1:
                int zzb = zzeen.zzb(bArr, i, zzeem);
                zzeem.zzhzq = Boolean.valueOf(zzeem.zzhzp != 0);
                return zzb;
            case 2:
                return zzeen.zze(bArr, i, zzeem);
            case 3:
                zzeem.zzhzq = Double.valueOf(zzeen.zzi(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzeem.zzhzq = Integer.valueOf(zzeen.zzg(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzeem.zzhzq = Long.valueOf(zzeen.zzh(bArr, i));
                return i + 8;
            case 8:
                zzeem.zzhzq = Float.valueOf(zzeen.zzj(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzeen.zza(bArr, i, zzeem);
                zzeem.zzhzq = Integer.valueOf(zzeem.zzhzo);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzeen.zzb(bArr, i, zzeem);
                zzeem.zzhzq = Long.valueOf(zzeem.zzhzp);
                return zzb2;
            case 14:
                return zzeen.zza(zzeia.zzbgz().zzh(cls), bArr, i, i2, zzeem);
            case 15:
                int zza2 = zzeen.zza(bArr, i, zzeem);
                zzeem.zzhzq = Integer.valueOf(zzefc.zzgb(zzeem.zzhzo));
                return zza2;
            case 16:
                int zzb3 = zzeen.zzb(bArr, i, zzeem);
                zzeem.zzhzq = Long.valueOf(zzefc.zzfh(zzeem.zzhzp));
                return zzb3;
            case 17:
                return zzeen.zzd(bArr, i, zzeem);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:63)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:32)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:15)
        */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x0422 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x01eb  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.ads.zzeem r30) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r2 = r21
            r6 = r23
            r8 = r24
            r9 = r28
            r7 = r30
            sun.misc.Unsafe r11 = com.google.android.gms.internal.ads.zzehp.zzhni
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.ads.zzegm r11 = (com.google.android.gms.internal.ads.zzegm) r11
            boolean r12 = r11.zzbcy()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.ads.zzegm r11 = r11.zzfs(r12)
            sun.misc.Unsafe r12 = com.google.android.gms.internal.ads.zzehp.zzhni
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x03e4;
                case 19: goto L_0x03a6;
                case 20: goto L_0x0365;
                case 21: goto L_0x0365;
                case 22: goto L_0x034b;
                case 23: goto L_0x030c;
                case 24: goto L_0x02cd;
                case 25: goto L_0x0276;
                case 26: goto L_0x01c3;
                case 27: goto L_0x01a9;
                case 28: goto L_0x0151;
                case 29: goto L_0x034b;
                case 30: goto L_0x0119;
                case 31: goto L_0x02cd;
                case 32: goto L_0x030c;
                case 33: goto L_0x00cc;
                case 34: goto L_0x007f;
                case 35: goto L_0x03e4;
                case 36: goto L_0x03a6;
                case 37: goto L_0x0365;
                case 38: goto L_0x0365;
                case 39: goto L_0x034b;
                case 40: goto L_0x030c;
                case 41: goto L_0x02cd;
                case 42: goto L_0x0276;
                case 43: goto L_0x034b;
                case 44: goto L_0x0119;
                case 45: goto L_0x02cd;
                case 46: goto L_0x030c;
                case 47: goto L_0x00cc;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0422
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0422
            com.google.android.gms.internal.ads.zzeih r1 = r0.zzhe(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzhzq
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0422
            int r8 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r9 = r7.zzhzo
            if (r2 != r9) goto L_0x0422
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzhzq
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x00a3
            com.google.android.gms.internal.ads.zzegz r11 = (com.google.android.gms.internal.ads.zzegz) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r2 = r7.zzhzo
            int r2 = r2 + r1
        L_0x008a:
            if (r1 >= r2) goto L_0x009a
            int r1 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r1, r7)
            long r4 = r7.zzhzp
            long r4 = com.google.android.gms.internal.ads.zzefc.zzfh(r4)
            r11.zzfs(r4)
            goto L_0x008a
        L_0x009a:
            if (r1 != r2) goto L_0x009e
            goto L_0x0423
        L_0x009e:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x00a3:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.ads.zzegz r11 = (com.google.android.gms.internal.ads.zzegz) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r4, r7)
            long r8 = r7.zzhzp
            long r8 = com.google.android.gms.internal.ads.zzefc.zzfh(r8)
            r11.zzfs(r8)
        L_0x00b4:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r6 = r7.zzhzo
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r4, r7)
            long r8 = r7.zzhzp
            long r8 = com.google.android.gms.internal.ads.zzefc.zzfh(r8)
            r11.zzfs(r8)
            goto L_0x00b4
        L_0x00cc:
            if (r6 != r10) goto L_0x00f0
            com.google.android.gms.internal.ads.zzege r11 = (com.google.android.gms.internal.ads.zzege) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r2 = r7.zzhzo
            int r2 = r2 + r1
        L_0x00d7:
            if (r1 >= r2) goto L_0x00e7
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r4 = r7.zzhzo
            int r4 = com.google.android.gms.internal.ads.zzefc.zzgb(r4)
            r11.zzhb(r4)
            goto L_0x00d7
        L_0x00e7:
            if (r1 != r2) goto L_0x00eb
            goto L_0x0423
        L_0x00eb:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x00f0:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.ads.zzege r11 = (com.google.android.gms.internal.ads.zzege) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r4 = r7.zzhzo
            int r4 = com.google.android.gms.internal.ads.zzefc.zzgb(r4)
            r11.zzhb(r4)
        L_0x0101:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r6 = r7.zzhzo
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r4 = r7.zzhzo
            int r4 = com.google.android.gms.internal.ads.zzefc.zzgb(r4)
            r11.zzhb(r4)
            goto L_0x0101
        L_0x0119:
            if (r6 != r10) goto L_0x0120
            int r2 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r11, r7)
            goto L_0x0131
        L_0x0120:
            if (r6 != 0) goto L_0x0422
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.ads.zzeen.zza(r2, r3, r4, r5, r6, r7)
        L_0x0131:
            com.google.android.gms.internal.ads.zzegb r1 = (com.google.android.gms.internal.ads.zzegb) r1
            com.google.android.gms.internal.ads.zzejc r3 = r1.zzieg
            com.google.android.gms.internal.ads.zzejc r4 = com.google.android.gms.internal.ads.zzejc.zzbhs()
            if (r3 != r4) goto L_0x013c
            r3 = 0
        L_0x013c:
            com.google.android.gms.internal.ads.zzegi r4 = r0.zzhg(r8)
            com.google.android.gms.internal.ads.zzeiz<?, ?> r5 = r0.zzihg
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.ads.zzeij.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.ads.zzejc r3 = (com.google.android.gms.internal.ads.zzejc) r3
            if (r3 == 0) goto L_0x014e
            r1.zzieg = r3
        L_0x014e:
            r1 = r2
            goto L_0x0423
        L_0x0151:
            if (r6 != r10) goto L_0x0422
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r4 = r7.zzhzo
            if (r4 < 0) goto L_0x01a4
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x019f
            if (r4 != 0) goto L_0x0167
            com.google.android.gms.internal.ads.zzeer r4 = com.google.android.gms.internal.ads.zzeer.zzhzv
            r11.add(r4)
            goto L_0x016f
        L_0x0167:
            com.google.android.gms.internal.ads.zzeer r6 = com.google.android.gms.internal.ads.zzeer.zzi(r3, r1, r4)
            r11.add(r6)
        L_0x016e:
            int r1 = r1 + r4
        L_0x016f:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r6 = r7.zzhzo
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r4 = r7.zzhzo
            if (r4 < 0) goto L_0x019a
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0195
            if (r4 != 0) goto L_0x018d
            com.google.android.gms.internal.ads.zzeer r4 = com.google.android.gms.internal.ads.zzeer.zzhzv
            r11.add(r4)
            goto L_0x016f
        L_0x018d:
            com.google.android.gms.internal.ads.zzeer r6 = com.google.android.gms.internal.ads.zzeer.zzi(r3, r1, r4)
            r11.add(r6)
            goto L_0x016e
        L_0x0195:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x019a:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfv()
            throw r1
        L_0x019f:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x01a4:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfv()
            throw r1
        L_0x01a9:
            if (r6 != r10) goto L_0x0422
            com.google.android.gms.internal.ads.zzeih r1 = r0.zzhe(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0423
        L_0x01c3:
            if (r6 != r10) goto L_0x0422
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x0216
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r6 = r7.zzhzo
            if (r6 < 0) goto L_0x0211
            if (r6 != 0) goto L_0x01de
            r11.add(r1)
            goto L_0x01e9
        L_0x01de:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzegd.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01e8:
            int r4 = r4 + r6
        L_0x01e9:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r8 = r7.zzhzo
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r6, r7)
            int r6 = r7.zzhzo
            if (r6 < 0) goto L_0x020c
            if (r6 != 0) goto L_0x0201
            r11.add(r1)
            goto L_0x01e9
        L_0x0201:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.ads.zzegd.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01e8
        L_0x020c:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfv()
            throw r1
        L_0x0211:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfv()
            throw r1
        L_0x0216:
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r6 = r7.zzhzo
            if (r6 < 0) goto L_0x0271
            if (r6 != 0) goto L_0x0224
            r11.add(r1)
            goto L_0x0237
        L_0x0224:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzeji.zzm(r3, r4, r8)
            if (r9 == 0) goto L_0x026c
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzegd.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x0236:
            r4 = r8
        L_0x0237:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r8 = r7.zzhzo
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r6, r7)
            int r6 = r7.zzhzo
            if (r6 < 0) goto L_0x0267
            if (r6 != 0) goto L_0x024f
            r11.add(r1)
            goto L_0x0237
        L_0x024f:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.ads.zzeji.zzm(r3, r4, r8)
            if (r9 == 0) goto L_0x0262
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.ads.zzegd.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x0236
        L_0x0262:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbgc()
            throw r1
        L_0x0267:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfv()
            throw r1
        L_0x026c:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbgc()
            throw r1
        L_0x0271:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfv()
            throw r1
        L_0x0276:
            r1 = 0
            if (r6 != r10) goto L_0x029e
            com.google.android.gms.internal.ads.zzeep r11 = (com.google.android.gms.internal.ads.zzeep) r11
            int r2 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r4 = r7.zzhzo
            int r4 = r4 + r2
        L_0x0282:
            if (r2 >= r4) goto L_0x0295
            int r2 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r2, r7)
            long r5 = r7.zzhzp
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0290
            r5 = 1
            goto L_0x0291
        L_0x0290:
            r5 = 0
        L_0x0291:
            r11.addBoolean(r5)
            goto L_0x0282
        L_0x0295:
            if (r2 != r4) goto L_0x0299
            goto L_0x014e
        L_0x0299:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x029e:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.ads.zzeep r11 = (com.google.android.gms.internal.ads.zzeep) r11
            int r4 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r4, r7)
            long r8 = r7.zzhzp
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02ae
            r6 = 1
            goto L_0x02af
        L_0x02ae:
            r6 = 0
        L_0x02af:
            r11.addBoolean(r6)
        L_0x02b2:
            if (r4 >= r5) goto L_0x0422
            int r6 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r8 = r7.zzhzo
            if (r2 != r8) goto L_0x0422
            int r4 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r6, r7)
            long r8 = r7.zzhzp
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x02c8
            r6 = 1
            goto L_0x02c9
        L_0x02c8:
            r6 = 0
        L_0x02c9:
            r11.addBoolean(r6)
            goto L_0x02b2
        L_0x02cd:
            if (r6 != r10) goto L_0x02ed
            com.google.android.gms.internal.ads.zzege r11 = (com.google.android.gms.internal.ads.zzege) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r2 = r7.zzhzo
            int r2 = r2 + r1
        L_0x02d8:
            if (r1 >= r2) goto L_0x02e4
            int r4 = com.google.android.gms.internal.ads.zzeen.zzg(r3, r1)
            r11.zzhb(r4)
            int r1 = r1 + 4
            goto L_0x02d8
        L_0x02e4:
            if (r1 != r2) goto L_0x02e8
            goto L_0x0423
        L_0x02e8:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x02ed:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.ads.zzege r11 = (com.google.android.gms.internal.ads.zzege) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zzg(r18, r19)
            r11.zzhb(r1)
        L_0x02f8:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r6 = r7.zzhzo
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeen.zzg(r3, r4)
            r11.zzhb(r1)
            goto L_0x02f8
        L_0x030c:
            if (r6 != r10) goto L_0x032c
            com.google.android.gms.internal.ads.zzegz r11 = (com.google.android.gms.internal.ads.zzegz) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r2 = r7.zzhzo
            int r2 = r2 + r1
        L_0x0317:
            if (r1 >= r2) goto L_0x0323
            long r4 = com.google.android.gms.internal.ads.zzeen.zzh(r3, r1)
            r11.zzfs(r4)
            int r1 = r1 + 8
            goto L_0x0317
        L_0x0323:
            if (r1 != r2) goto L_0x0327
            goto L_0x0423
        L_0x0327:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x032c:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.ads.zzegz r11 = (com.google.android.gms.internal.ads.zzegz) r11
            long r8 = com.google.android.gms.internal.ads.zzeen.zzh(r18, r19)
            r11.zzfs(r8)
        L_0x0337:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r6 = r7.zzhzo
            if (r2 != r6) goto L_0x0423
            long r8 = com.google.android.gms.internal.ads.zzeen.zzh(r3, r4)
            r11.zzfs(r8)
            goto L_0x0337
        L_0x034b:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r11, r7)
            goto L_0x0423
        L_0x0353:
            if (r6 != 0) goto L_0x0422
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r21, r22, r23, r24, r25, r26)
            goto L_0x0423
        L_0x0365:
            if (r6 != r10) goto L_0x0385
            com.google.android.gms.internal.ads.zzegz r11 = (com.google.android.gms.internal.ads.zzegz) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r2 = r7.zzhzo
            int r2 = r2 + r1
        L_0x0370:
            if (r1 >= r2) goto L_0x037c
            int r1 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r1, r7)
            long r4 = r7.zzhzp
            r11.zzfs(r4)
            goto L_0x0370
        L_0x037c:
            if (r1 != r2) goto L_0x0380
            goto L_0x0423
        L_0x0380:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x0385:
            if (r6 != 0) goto L_0x0422
            com.google.android.gms.internal.ads.zzegz r11 = (com.google.android.gms.internal.ads.zzegz) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r4, r7)
            long r8 = r7.zzhzp
            r11.zzfs(r8)
        L_0x0392:
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r6 = r7.zzhzo
            if (r2 != r6) goto L_0x0423
            int r1 = com.google.android.gms.internal.ads.zzeen.zzb(r3, r4, r7)
            long r8 = r7.zzhzp
            r11.zzfs(r8)
            goto L_0x0392
        L_0x03a6:
            if (r6 != r10) goto L_0x03c5
            com.google.android.gms.internal.ads.zzega r11 = (com.google.android.gms.internal.ads.zzega) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r2 = r7.zzhzo
            int r2 = r2 + r1
        L_0x03b1:
            if (r1 >= r2) goto L_0x03bd
            float r4 = com.google.android.gms.internal.ads.zzeen.zzj(r3, r1)
            r11.zzh(r4)
            int r1 = r1 + 4
            goto L_0x03b1
        L_0x03bd:
            if (r1 != r2) goto L_0x03c0
            goto L_0x0423
        L_0x03c0:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x03c5:
            if (r6 != r9) goto L_0x0422
            com.google.android.gms.internal.ads.zzega r11 = (com.google.android.gms.internal.ads.zzega) r11
            float r1 = com.google.android.gms.internal.ads.zzeen.zzj(r18, r19)
            r11.zzh(r1)
        L_0x03d0:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r6 = r7.zzhzo
            if (r2 != r6) goto L_0x0423
            float r1 = com.google.android.gms.internal.ads.zzeen.zzj(r3, r4)
            r11.zzh(r1)
            goto L_0x03d0
        L_0x03e4:
            if (r6 != r10) goto L_0x0403
            com.google.android.gms.internal.ads.zzefm r11 = (com.google.android.gms.internal.ads.zzefm) r11
            int r1 = com.google.android.gms.internal.ads.zzeen.zza(r3, r4, r7)
            int r2 = r7.zzhzo
            int r2 = r2 + r1
        L_0x03ef:
            if (r1 >= r2) goto L_0x03fb
            double r4 = com.google.android.gms.internal.ads.zzeen.zzi(r3, r1)
            r11.zzd(r4)
            int r1 = r1 + 8
            goto L_0x03ef
        L_0x03fb:
            if (r1 != r2) goto L_0x03fe
            goto L_0x0423
        L_0x03fe:
            com.google.android.gms.internal.ads.zzegl r1 = com.google.android.gms.internal.ads.zzegl.zzbfu()
            throw r1
        L_0x0403:
            if (r6 != r13) goto L_0x0422
            com.google.android.gms.internal.ads.zzefm r11 = (com.google.android.gms.internal.ads.zzefm) r11
            double r8 = com.google.android.gms.internal.ads.zzeen.zzi(r18, r19)
            r11.zzd(r8)
        L_0x040e:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0423
            int r4 = com.google.android.gms.internal.ads.zzeen.zza(r3, r1, r7)
            int r6 = r7.zzhzo
            if (r2 != r6) goto L_0x0423
            double r8 = com.google.android.gms.internal.ads.zzeen.zzi(r3, r4)
            r11.zzd(r8)
            goto L_0x040e
        L_0x0422:
            r1 = r4
        L_0x0423:
            return r1
            switch-data {18->0x03e4, 19->0x03a6, 20->0x0365, 21->0x0365, 22->0x034b, 23->0x030c, 24->0x02cd, 25->0x0276, 26->0x01c3, 27->0x01a9, 28->0x0151, 29->0x034b, 30->0x0119, 31->0x02cd, 32->0x030c, 33->0x00cc, 34->0x007f, 35->0x03e4, 36->0x03a6, 37->0x0365, 38->0x0365, 39->0x034b, 40->0x030c, 41->0x02cd, 42->0x0276, 43->0x034b, 44->0x0119, 45->0x02cd, 46->0x030c, 47->0x00cc, 48->0x007f, 49->0x003f, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehp.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.ads.zzeem):int");
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.util.Map<?, ?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzeem zzeem) throws IOException {
        Unsafe unsafe = zzhni;
        Object zzhf = zzhf(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzihi.zzaq(object)) {
            Object zzas = this.zzihi.zzas(zzhf);
            this.zzihi.zzf(zzas, object);
            unsafe.putObject(t, j, zzas);
            object = zzas;
        }
        zzehg<?, ?> zzao = this.zzihi.zzao(zzhf);
        Map<?, ?> zzan = this.zzihi.zzan(object);
        int zza = zzeen.zza(bArr, i, zzeem);
        int i4 = zzeem.zzhzo;
        if (i4 < 0 || i4 > i2 - zza) {
            throw zzegl.zzbfu();
        }
        int i5 = i4 + zza;
        Object obj = zzao.zzign;
        Object obj2 = zzao.zzckr;
        while (zza < i5) {
            int i6 = zza + 1;
            byte b = bArr[zza];
            int i7 = b;
            if (b < 0) {
                i6 = zzeen.zza(b, bArr, i6, zzeem);
                i7 = zzeem.zzhzo;
            }
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzao.zzigo.zzbic()) {
                    zza = zza(bArr, i6, i2, zzao.zzigo, zzao.zzckr.getClass(), zzeem);
                    obj2 = zzeem.zzhzq;
                }
            } else if (i9 == zzao.zzigm.zzbic()) {
                zza = zza(bArr, i6, i2, zzao.zzigm, (Class<?>) null, zzeem);
                obj = zzeem.zzhzq;
            }
            zza = zzeen.zza(i7, bArr, i6, i2, zzeem);
        }
        if (zza == i5) {
            zzan.put(obj, obj2);
            return i5;
        }
        throw zzegl.zzbgb();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzeem zzeem) throws IOException {
        int i9;
        Unsafe unsafe = zzhni;
        long j2 = (long) (this.zzigs[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzeen.zzi(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzeen.zzj(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzeen.zzb(bArr, i, zzeem);
                    unsafe.putObject(t, j, Long.valueOf(zzeem.zzhzp));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzeen.zza(bArr, i, zzeem);
                    unsafe.putObject(t, j, Integer.valueOf(zzeem.zzhzo));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzeen.zzh(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzeen.zzg(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzeen.zzb(bArr, i, zzeem);
                    unsafe.putObject(t, j, Boolean.valueOf(zzeem.zzhzp != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza = zzeen.zza(bArr, i, zzeem);
                    int i10 = zzeem.zzhzo;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzeji.zzm(bArr, zza, zza + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza, i10, zzegd.UTF_8));
                        zza += i10;
                    } else {
                        throw zzegl.zzbgc();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza2 = zzeen.zza(zzhe(i8), bArr, i, i2, zzeem);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzeem.zzhzq);
                    } else {
                        unsafe.putObject(t, j, zzegd.zze(object, zzeem.zzhzq));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzeen.zze(bArr, i, zzeem);
                    unsafe.putObject(t, j, zzeem.zzhzq);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza3 = zzeen.zza(bArr, i, zzeem);
                    int i11 = zzeem.zzhzo;
                    zzegi zzhg = zzhg(i8);
                    if (zzhg == null || zzhg.zzi(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza3;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zzau(t).zzd(i3, Long.valueOf((long) i11));
                    return zza3;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzeen.zza(bArr, i, zzeem);
                    unsafe.putObject(t, j, Integer.valueOf(zzefc.zzgb(zzeem.zzhzo)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzeen.zzb(bArr, i, zzeem);
                    unsafe.putObject(t, j, Long.valueOf(zzefc.zzfh(zzeem.zzhzp)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzeen.zza(zzhe(i8), bArr, i, i2, (i3 & -8) | 4, zzeem);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzeem.zzhzq);
                    } else {
                        unsafe.putObject(t, j, zzegd.zze(object2, zzeem.zzhzq));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zzeih zzhe(int i) {
        int i2 = (i / 3) << 1;
        zzeih zzeih = (zzeih) this.zzigt[i2];
        if (zzeih != null) {
            return zzeih;
        }
        zzeih<T> zzh = zzeia.zzbgz().zzh((Class) this.zzigt[i2 + 1]);
        this.zzigt[i2] = zzh;
        return zzh;
    }

    private final Object zzhf(int i) {
        return this.zzigt[(i / 3) << 1];
    }

    private final zzegi zzhg(int i) {
        return (zzegi) this.zzigt[((i / 3) << 1) + 1];
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x03bb, code lost:
        if (r0 == r3) goto L_0x0424;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x03fe, code lost:
        if (r0 == r15) goto L_0x0424;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r28, byte[] r29, int r30, int r31, int r32, com.google.android.gms.internal.ads.zzeem r33) throws java.io.IOException {
        /*
            r27 = this;
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r11 = r32
            r9 = r33
            sun.misc.Unsafe r10 = com.google.android.gms.internal.ads.zzehp.zzhni
            r16 = 0
            r0 = r30
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            if (r0 >= r13) goto L_0x04cb
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r12, r3, r9)
            int r3 = r9.zzhzo
            r4 = r3
            r3 = r0
            goto L_0x002b
        L_0x002a:
            r4 = r0
        L_0x002b:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x0038
            int r2 = r2 / r8
            int r1 = r15.zzan(r0, r2)
            goto L_0x003c
        L_0x0038:
            int r1 = r15.zzhk(r0)
        L_0x003c:
            r2 = r1
            r1 = -1
            if (r2 != r1) goto L_0x004f
            r30 = r0
            r2 = r3
            r8 = r4
            r22 = r5
            r26 = r10
            r7 = r11
            r17 = 0
            r18 = -1
            goto L_0x0428
        L_0x004f:
            int[] r1 = r15.zzigs
            int r19 = r2 + 1
            r8 = r1[r19]
            r19 = 267386880(0xff00000, float:2.3665827E-29)
            r19 = r8 & r19
            int r11 = r19 >>> 20
            r19 = r4
            r17 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r8 & r17
            long r12 = (long) r4
            r4 = 17
            r20 = r8
            if (r11 > r4) goto L_0x0325
            int r4 = r2 + 2
            r1 = r1[r4]
            int r4 = r1 >>> 20
            r8 = 1
            int r22 = r8 << r4
            r4 = 1048575(0xfffff, float:1.469367E-39)
            r1 = r1 & r4
            if (r1 == r6) goto L_0x0085
            if (r6 == r4) goto L_0x007e
            long r8 = (long) r6
            r10.putInt(r14, r8, r5)
        L_0x007e:
            long r5 = (long) r1
            int r5 = r10.getInt(r14, r5)
            r8 = r1
            goto L_0x0086
        L_0x0085:
            r8 = r6
        L_0x0086:
            r6 = r5
            r1 = 5
            switch(r11) {
                case 0: goto L_0x02ee;
                case 1: goto L_0x02d2;
                case 2: goto L_0x02a9;
                case 3: goto L_0x02a9;
                case 4: goto L_0x028c;
                case 5: goto L_0x0265;
                case 6: goto L_0x023d;
                case 7: goto L_0x0210;
                case 8: goto L_0x01e6;
                case 9: goto L_0x01ab;
                case 10: goto L_0x018d;
                case 11: goto L_0x028c;
                case 12: goto L_0x014e;
                case 13: goto L_0x023d;
                case 14: goto L_0x0265;
                case 15: goto L_0x012d;
                case 16: goto L_0x00f9;
                case 17: goto L_0x009c;
                default: goto L_0x008b;
            }
        L_0x008b:
            r12 = r29
            r13 = r33
            r9 = r0
            r11 = r2
            r30 = r8
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x0316
        L_0x009c:
            r5 = 3
            if (r7 != r5) goto L_0x00e7
            int r1 = r0 << 3
            r5 = r1 | 4
            com.google.android.gms.internal.ads.zzeih r1 = r15.zzhe(r2)
            r9 = r0
            r0 = r1
            r18 = -1
            r1 = r29
            r11 = r2
            r2 = r3
            r3 = r31
            r7 = r19
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r5
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x00c9
            r4 = r33
            java.lang.Object r1 = r4.zzhzq
            r10.putObject(r14, r12, r1)
            goto L_0x00d8
        L_0x00c9:
            r4 = r33
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r4.zzhzq
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzegd.zze(r1, r2)
            r10.putObject(r14, r12, r1)
        L_0x00d8:
            r5 = r6 | r22
            r12 = r29
            r13 = r31
            r3 = r7
            r6 = r8
            r1 = r9
            r2 = r11
            r11 = r32
            r9 = r4
            goto L_0x0019
        L_0x00e7:
            r9 = r0
            r11 = r2
            r7 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            r30 = r8
            r8 = r7
            goto L_0x0316
        L_0x00f9:
            r4 = r33
            r9 = r0
            r11 = r2
            r5 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x0125
            r1 = r12
            r12 = r29
            int r7 = com.google.android.gms.internal.ads.zzeen.zzb(r12, r3, r4)
            r20 = r1
            long r0 = r4.zzhzp
            long r23 = com.google.android.gms.internal.ads.zzefc.zzfh(r0)
            r0 = r10
            r2 = r20
            r1 = r28
            r13 = r4
            r30 = r8
            r8 = r5
            r4 = r23
            r0.putLong(r1, r2, r4)
            goto L_0x02cc
        L_0x0125:
            r12 = r29
            r13 = r4
            r30 = r8
            r8 = r5
            goto L_0x0316
        L_0x012d:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r12, r3, r13)
            int r1 = r13.zzhzo
            int r1 = com.google.android.gms.internal.ads.zzefc.zzgb(r1)
            r10.putInt(r14, r4, r1)
            goto L_0x030a
        L_0x014e:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r12, r3, r13)
            int r1 = r13.zzhzo
            com.google.android.gms.internal.ads.zzegi r2 = r15.zzhg(r11)
            if (r2 == 0) goto L_0x0188
            boolean r2 = r2.zzi(r1)
            if (r2 == 0) goto L_0x0173
            goto L_0x0188
        L_0x0173:
            com.google.android.gms.internal.ads.zzejc r2 = zzau(r28)
            long r3 = (long) r1
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r2.zzd(r8, r1)
            r5 = r6
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
            r6 = r30
            goto L_0x0312
        L_0x0188:
            r10.putInt(r14, r4, r1)
            goto L_0x030a
        L_0x018d:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x0316
            int r0 = com.google.android.gms.internal.ads.zzeen.zze(r12, r3, r13)
            java.lang.Object r1 = r13.zzhzq
            r10.putObject(r14, r4, r1)
            goto L_0x030a
        L_0x01ab:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzeih r0 = r15.zzhe(r11)
            r2 = r31
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r12, r3, r2, r13)
            r1 = r6 & r22
            if (r1 != 0) goto L_0x01d3
            java.lang.Object r1 = r13.zzhzq
            r10.putObject(r14, r4, r1)
            goto L_0x025a
        L_0x01d3:
            java.lang.Object r1 = r10.getObject(r14, r4)
            java.lang.Object r3 = r13.zzhzq
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzegd.zze(r1, r3)
            r10.putObject(r14, r4, r1)
            goto L_0x025a
        L_0x01e2:
            r2 = r31
            goto L_0x0316
        L_0x01e6:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 2
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r0) goto L_0x0316
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r20 & r0
            if (r0 != 0) goto L_0x0206
            int r0 = com.google.android.gms.internal.ads.zzeen.zzc(r12, r3, r13)
            goto L_0x020a
        L_0x0206:
            int r0 = com.google.android.gms.internal.ads.zzeen.zzd(r12, r3, r13)
        L_0x020a:
            java.lang.Object r1 = r13.zzhzq
            r10.putObject(r14, r4, r1)
            goto L_0x025a
        L_0x0210:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r0 = com.google.android.gms.internal.ads.zzeen.zzb(r12, r3, r13)
            r3 = r0
            long r0 = r13.zzhzp
            r20 = 0
            int r7 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r7 == 0) goto L_0x0233
            r0 = 1
            goto L_0x0234
        L_0x0233:
            r0 = 0
        L_0x0234:
            com.google.android.gms.internal.ads.zzejf.zza(r14, r4, r0)
            r5 = r6 | r22
            r6 = r30
            r0 = r3
            goto L_0x025e
        L_0x023d:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r1) goto L_0x0316
            int r0 = com.google.android.gms.internal.ads.zzeen.zzg(r12, r3)
            r10.putInt(r14, r4, r0)
            int r0 = r3 + 4
        L_0x025a:
            r5 = r6 | r22
            r6 = r30
        L_0x025e:
            r3 = r8
            r1 = r9
            r9 = r13
            r13 = r2
            r2 = r11
            goto L_0x04c7
        L_0x0265:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r2 = r31
            r13 = r33
            if (r7 != r0) goto L_0x0316
            long r20 = com.google.android.gms.internal.ads.zzeen.zzh(r12, r3)
            r0 = r10
            r1 = r28
            r7 = r3
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x030a
        L_0x028c:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r12, r3, r13)
            int r1 = r13.zzhzo
            r10.putInt(r14, r4, r1)
            goto L_0x030a
        L_0x02a9:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != 0) goto L_0x0316
            int r7 = com.google.android.gms.internal.ads.zzeen.zzb(r12, r3, r13)
            long r2 = r13.zzhzp
            r0 = r10
            r1 = r28
            r20 = r2
            r2 = r4
            r4 = r20
            r0.putLong(r1, r2, r4)
        L_0x02cc:
            r5 = r6 | r22
            r6 = r30
            r0 = r7
            goto L_0x030e
        L_0x02d2:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r1) goto L_0x0316
            float r0 = com.google.android.gms.internal.ads.zzeen.zzj(r12, r3)
            com.google.android.gms.internal.ads.zzejf.zza(r14, r4, r0)
            int r0 = r3 + 4
            goto L_0x030a
        L_0x02ee:
            r9 = r0
            r11 = r2
            r30 = r8
            r4 = r12
            r8 = r19
            r0 = 1
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r33
            if (r7 != r0) goto L_0x0316
            double r0 = com.google.android.gms.internal.ads.zzeen.zzi(r12, r3)
            com.google.android.gms.internal.ads.zzejf.zza(r14, r4, r0)
            int r0 = r3 + 8
        L_0x030a:
            r5 = r6 | r22
            r6 = r30
        L_0x030e:
            r3 = r8
            r1 = r9
            r2 = r11
            r9 = r13
        L_0x0312:
            r13 = r31
            goto L_0x04c7
        L_0x0316:
            r7 = r32
            r2 = r3
            r22 = r6
            r26 = r10
            r17 = r11
            r6 = r30
            r30 = r9
            goto L_0x0428
        L_0x0325:
            r4 = r2
            r1 = r12
            r8 = r19
            r18 = -1
            r19 = 1048575(0xfffff, float:1.469367E-39)
            r12 = r29
            r13 = r9
            r9 = r0
            r0 = 27
            if (r11 != r0) goto L_0x038c
            r0 = 2
            if (r7 != r0) goto L_0x037d
            java.lang.Object r0 = r10.getObject(r14, r1)
            com.google.android.gms.internal.ads.zzegm r0 = (com.google.android.gms.internal.ads.zzegm) r0
            boolean r7 = r0.zzbcy()
            if (r7 != 0) goto L_0x0357
            int r7 = r0.size()
            if (r7 != 0) goto L_0x034e
            r7 = 10
            goto L_0x0350
        L_0x034e:
            int r7 = r7 << 1
        L_0x0350:
            com.google.android.gms.internal.ads.zzegm r0 = r0.zzfs(r7)
            r10.putObject(r14, r1, r0)
        L_0x0357:
            r7 = r0
            com.google.android.gms.internal.ads.zzeih r0 = r15.zzhe(r4)
            r1 = r8
            r2 = r29
            r17 = r4
            r4 = r31
            r22 = r5
            r5 = r7
            r23 = r6
            r6 = r33
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r32
            r3 = r8
            r1 = r9
            r9 = r13
            r2 = r17
            r5 = r22
            r6 = r23
            r13 = r31
            goto L_0x0019
        L_0x037d:
            r17 = r4
            r22 = r5
            r23 = r6
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            goto L_0x0401
        L_0x038c:
            r17 = r4
            r22 = r5
            r23 = r6
            r0 = 49
            if (r11 > r0) goto L_0x03d9
            r6 = r20
            long r5 = (long) r6
            r0 = r27
            r24 = r1
            r1 = r28
            r2 = r29
            r4 = r3
            r15 = r4
            r4 = r31
            r20 = r5
            r5 = r8
            r6 = r9
            r19 = r8
            r8 = r17
            r30 = r9
            r26 = r10
            r9 = r20
            r12 = r24
            r14 = r33
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x03bf
            goto L_0x0424
        L_0x03bf:
            r15 = r27
            r14 = r28
            r12 = r29
            r1 = r30
            r13 = r31
            r11 = r32
            r9 = r33
            r2 = r17
            r3 = r19
            r5 = r22
            r6 = r23
            r10 = r26
            goto L_0x0019
        L_0x03d9:
            r24 = r1
            r15 = r3
            r19 = r8
            r30 = r9
            r26 = r10
            r6 = r20
            r0 = 50
            if (r11 != r0) goto L_0x0409
            r0 = 2
            if (r7 != r0) goto L_0x0401
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r17
            r6 = r24
            r8 = r33
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x03bf
            goto L_0x0424
        L_0x0401:
            r7 = r32
            r2 = r15
        L_0x0404:
            r8 = r19
            r6 = r23
            goto L_0x0428
        L_0x0409:
            r0 = r27
            r1 = r28
            r2 = r29
            r3 = r15
            r4 = r31
            r5 = r19
            r8 = r6
            r6 = r30
            r9 = r11
            r10 = r24
            r12 = r17
            r13 = r33
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x04af
        L_0x0424:
            r7 = r32
            r2 = r0
            goto L_0x0404
        L_0x0428:
            if (r8 != r7) goto L_0x0437
            if (r7 != 0) goto L_0x042d
            goto L_0x0437
        L_0x042d:
            r9 = r27
            r12 = r28
            r0 = r2
            r3 = r8
            r5 = r22
            goto L_0x04d4
        L_0x0437:
            r9 = r27
            boolean r0 = r9.zzigx
            if (r0 == 0) goto L_0x0488
            r10 = r33
            com.google.android.gms.internal.ads.zzefo r0 = r10.zzhzr
            com.google.android.gms.internal.ads.zzefo r1 = com.google.android.gms.internal.ads.zzefo.zzbeq()
            if (r0 == r1) goto L_0x0483
            com.google.android.gms.internal.ads.zzehl r0 = r9.zzigw
            com.google.android.gms.internal.ads.zzefo r1 = r10.zzhzr
            r11 = r30
            com.google.android.gms.internal.ads.zzegb$zzf r0 = r1.zza(r0, r11)
            if (r0 != 0) goto L_0x0473
            com.google.android.gms.internal.ads.zzejc r4 = zzau(r28)
            r0 = r8
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r1, r2, r3, r4, r5)
            r14 = r28
            r12 = r29
            r13 = r31
            r3 = r8
            r15 = r9
            r9 = r10
            r1 = r11
            r2 = r17
            r5 = r22
            r10 = r26
            goto L_0x04ac
        L_0x0473:
            r12 = r28
            r0 = r12
            com.google.android.gms.internal.ads.zzegb$zzd r0 = (com.google.android.gms.internal.ads.zzegb.zzd) r0
            r0.zzbfr()
            com.google.android.gms.internal.ads.zzefu<com.google.android.gms.internal.ads.zzegb$zzc> r0 = r0.zzien
            java.lang.NoSuchMethodError r0 = new java.lang.NoSuchMethodError
            r0.<init>()
            throw r0
        L_0x0483:
            r12 = r28
            r11 = r30
            goto L_0x048e
        L_0x0488:
            r12 = r28
            r11 = r30
            r10 = r33
        L_0x048e:
            com.google.android.gms.internal.ads.zzejc r4 = zzau(r28)
            r0 = r8
            r1 = r29
            r3 = r31
            r5 = r33
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r1, r2, r3, r4, r5)
            r13 = r31
            r3 = r8
            r15 = r9
            r9 = r10
            r1 = r11
            r14 = r12
            r2 = r17
            r5 = r22
            r10 = r26
            r12 = r29
        L_0x04ac:
            r11 = r7
            goto L_0x0019
        L_0x04af:
            r11 = r30
            r8 = r19
            r15 = r27
            r14 = r28
            r12 = r29
            r13 = r31
            r9 = r33
            r3 = r8
            r1 = r11
            r2 = r17
            r5 = r22
            r6 = r23
            r10 = r26
        L_0x04c7:
            r11 = r32
            goto L_0x0019
        L_0x04cb:
            r22 = r5
            r23 = r6
            r26 = r10
            r7 = r11
            r12 = r14
            r9 = r15
        L_0x04d4:
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r6 == r1) goto L_0x04df
            long r1 = (long) r6
            r4 = r26
            r4.putInt(r12, r1, r5)
        L_0x04df:
            r1 = 0
            int r2 = r9.zzihc
        L_0x04e2:
            int r4 = r9.zzihd
            if (r2 >= r4) goto L_0x04f5
            int[] r4 = r9.zzihb
            r4 = r4[r2]
            com.google.android.gms.internal.ads.zzeiz<?, ?> r5 = r9.zzihg
            java.lang.Object r1 = r9.zza(r12, r4, r1, r5)
            com.google.android.gms.internal.ads.zzejc r1 = (com.google.android.gms.internal.ads.zzejc) r1
            int r2 = r2 + 1
            goto L_0x04e2
        L_0x04f5:
            if (r1 == 0) goto L_0x04fc
            com.google.android.gms.internal.ads.zzeiz<?, ?> r2 = r9.zzihg
            r2.zzj(r12, r1)
        L_0x04fc:
            if (r7 != 0) goto L_0x0508
            r1 = r31
            if (r0 != r1) goto L_0x0503
            goto L_0x050e
        L_0x0503:
            com.google.android.gms.internal.ads.zzegl r0 = com.google.android.gms.internal.ads.zzegl.zzbgb()
            throw r0
        L_0x0508:
            r1 = r31
            if (r0 > r1) goto L_0x050f
            if (r3 != r7) goto L_0x050f
        L_0x050e:
            return r0
        L_0x050f:
            com.google.android.gms.internal.ads.zzegl r0 = com.google.android.gms.internal.ads.zzegl.zzbgb()
            throw r0
            switch-data {0->0x02ee, 1->0x02d2, 2->0x02a9, 3->0x02a9, 4->0x028c, 5->0x0265, 6->0x023d, 7->0x0210, 8->0x01e6, 9->0x01ab, 10->0x018d, 11->0x028c, 12->0x014e, 13->0x023d, 14->0x0265, 15->0x012d, 16->0x00f9, 17->0x009c, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehp.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.ads.zzeem):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x02dc, code lost:
        if (r0 == r4) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0323, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x0346, code lost:
        if (r0 == r15) goto L_0x0348;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x0348, code lost:
        r2 = r0;
     */
    @Override // com.google.android.gms.internal.ads.zzeih
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.ads.zzeem r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.zzigz
            if (r0 == 0) goto L_0x038d
            sun.misc.Unsafe r9 = com.google.android.gms.internal.ads.zzehp.zzhni
            r10 = -1
            r16 = 0
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r33
            r1 = -1
            r2 = 0
            r6 = 0
            r7 = 1048575(0xfffff, float:1.469367E-39)
        L_0x001e:
            if (r0 >= r13) goto L_0x0370
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0030
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r12, r3, r11)
            int r3 = r11.zzhzo
            r4 = r0
            r17 = r3
            goto L_0x0033
        L_0x0030:
            r17 = r0
            r4 = r3
        L_0x0033:
            int r5 = r17 >>> 3
            r3 = r17 & 7
            if (r5 <= r1) goto L_0x0040
            int r2 = r2 / 3
            int r0 = r15.zzan(r5, r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.zzhk(r5)
        L_0x0044:
            r2 = r0
            if (r2 != r10) goto L_0x0052
            r2 = r4
            r25 = r5
            r29 = r9
            r18 = 0
        L_0x004e:
            r20 = -1
            goto L_0x034a
        L_0x0052:
            int[] r0 = r15.zzigs
            int r1 = r2 + 1
            r1 = r0[r1]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r1 & r18
            int r10 = r18 >>> 20
            r33 = r5
            r5 = r1 & r8
            r18 = r9
            long r8 = (long) r5
            r5 = 17
            r21 = r1
            if (r10 > r5) goto L_0x0242
            int r5 = r2 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r1 = 1
            int r23 = r1 << r5
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            r20 = r2
            if (r0 == r7) goto L_0x0092
            if (r7 == r5) goto L_0x0085
            long r1 = (long) r7
            r7 = r18
            r7.putInt(r14, r1, r6)
            goto L_0x0087
        L_0x0085:
            r7 = r18
        L_0x0087:
            if (r0 == r5) goto L_0x008f
            long r1 = (long) r0
            int r1 = r7.getInt(r14, r1)
            r6 = r1
        L_0x008f:
            r2 = r7
            r7 = r0
            goto L_0x0094
        L_0x0092:
            r2 = r18
        L_0x0094:
            r0 = 5
            switch(r10) {
                case 0: goto L_0x021d;
                case 1: goto L_0x0206;
                case 2: goto L_0x01e4;
                case 3: goto L_0x01e4;
                case 4: goto L_0x01cd;
                case 5: goto L_0x01ab;
                case 6: goto L_0x0194;
                case 7: goto L_0x0174;
                case 8: goto L_0x0151;
                case 9: goto L_0x0124;
                case 10: goto L_0x010c;
                case 11: goto L_0x01cd;
                case 12: goto L_0x00f5;
                case 13: goto L_0x0194;
                case 14: goto L_0x01ab;
                case 15: goto L_0x00da;
                case 16: goto L_0x00a5;
                default: goto L_0x0098;
            }
        L_0x0098:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            goto L_0x0239
        L_0x00a5:
            if (r3 != 0) goto L_0x00cc
            int r10 = com.google.android.gms.internal.ads.zzeen.zzb(r12, r4, r11)
            long r0 = r11.zzhzp
            long r17 = com.google.android.gms.internal.ads.zzefc.zzfh(r0)
            r0 = r2
            r1 = r31
            r4 = r20
            r20 = r7
            r7 = r2
            r2 = r8
            r25 = r33
            r8 = r4
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r17
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r8
            r0 = r10
            goto L_0x028c
        L_0x00cc:
            r25 = r33
            r8 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            r5 = r4
            r10 = r8
            goto L_0x0239
        L_0x00da:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r12, r4, r11)
            int r1 = r11.zzhzo
            int r1 = com.google.android.gms.internal.ads.zzefc.zzgb(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x00f5:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r12, r4, r11)
            int r1 = r11.zzhzo
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x010c:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.ads.zzeen.zze(r12, r4, r11)
            java.lang.Object r1 = r11.zzhzq
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0124:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            com.google.android.gms.internal.ads.zzeih r0 = r15.zzhe(r10)
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r12, r4, r13, r11)
            java.lang.Object r1 = r7.getObject(r14, r8)
            if (r1 != 0) goto L_0x0146
            java.lang.Object r1 = r11.zzhzq
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0146:
            java.lang.Object r2 = r11.zzhzq
            java.lang.Object r1 = com.google.android.gms.internal.ads.zzegd.zze(r1, r2)
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0151:
            r25 = r33
            r10 = r20
            r0 = 2
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r21 & r0
            if (r0 != 0) goto L_0x0169
            int r0 = com.google.android.gms.internal.ads.zzeen.zzc(r12, r4, r11)
            goto L_0x016d
        L_0x0169:
            int r0 = com.google.android.gms.internal.ads.zzeen.zzd(r12, r4, r11)
        L_0x016d:
            java.lang.Object r1 = r11.zzhzq
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0174:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.ads.zzeen.zzb(r12, r4, r11)
            long r1 = r11.zzhzp
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018e
            r1 = 1
            goto L_0x018f
        L_0x018e:
            r1 = 0
        L_0x018f:
            com.google.android.gms.internal.ads.zzejf.zza(r14, r8, r1)
            goto L_0x0234
        L_0x0194:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.ads.zzeen.zzg(r12, r4)
            r7.putInt(r14, r8, r0)
            int r0 = r4 + 4
            goto L_0x0234
        L_0x01ab:
            r25 = r33
            r10 = r20
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            long r17 = com.google.android.gms.internal.ads.zzeen.zzh(r12, r4)
            r0 = r7
            r1 = r31
            r2 = r8
            r8 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r8 + 8
            goto L_0x0234
        L_0x01ca:
            r5 = r4
            goto L_0x0239
        L_0x01cd:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0239
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r12, r5, r11)
            int r1 = r11.zzhzo
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x01e4:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x0239
            int r17 = com.google.android.gms.internal.ads.zzeen.zzb(r12, r5, r11)
            long r4 = r11.zzhzp
            r0 = r7
            r1 = r31
            r2 = r8
            r0.putLong(r1, r2, r4)
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            r0 = r17
            goto L_0x028c
        L_0x0206:
            r25 = r33
            r5 = r4
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0239
            float r0 = com.google.android.gms.internal.ads.zzeen.zzj(r12, r5)
            com.google.android.gms.internal.ads.zzejf.zza(r14, r8, r0)
            int r0 = r5 + 4
            goto L_0x0234
        L_0x021d:
            r25 = r33
            r5 = r4
            r10 = r20
            r0 = 1
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x0239
            double r0 = com.google.android.gms.internal.ads.zzeen.zzi(r12, r5)
            com.google.android.gms.internal.ads.zzejf.zza(r14, r8, r0)
            int r0 = r5 + 8
        L_0x0234:
            r6 = r6 | r23
            r9 = r7
            r2 = r10
            goto L_0x028c
        L_0x0239:
            r2 = r5
            r29 = r7
            r18 = r10
            r7 = r20
            goto L_0x004e
        L_0x0242:
            r25 = r33
            r5 = r4
            r20 = r7
            r7 = r18
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r2
            r0 = 27
            if (r10 != r0) goto L_0x029f
            r0 = 2
            if (r3 != r0) goto L_0x0292
            java.lang.Object r0 = r7.getObject(r14, r8)
            com.google.android.gms.internal.ads.zzegm r0 = (com.google.android.gms.internal.ads.zzegm) r0
            boolean r1 = r0.zzbcy()
            if (r1 != 0) goto L_0x0272
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0269
            r1 = 10
            goto L_0x026b
        L_0x0269:
            int r1 = r1 << 1
        L_0x026b:
            com.google.android.gms.internal.ads.zzegm r0 = r0.zzfs(r1)
            r7.putObject(r14, r8, r0)
        L_0x0272:
            r8 = r0
            com.google.android.gms.internal.ads.zzeih r0 = r15.zzhe(r4)
            r1 = r17
            r2 = r32
            r3 = r5
            r18 = r4
            r4 = r34
            r5 = r8
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r1, r2, r3, r4, r5, r6)
            r9 = r7
            r6 = r8
            r2 = r18
        L_0x028c:
            r7 = r20
            r1 = r25
            goto L_0x036a
        L_0x0292:
            r18 = r4
            r15 = r5
            r27 = r6
            r29 = r7
            r28 = r20
            r20 = -1
            goto L_0x0326
        L_0x029f:
            r18 = r4
            r0 = 49
            if (r10 > r0) goto L_0x02f4
            r1 = r21
            long r1 = (long) r1
            r0 = r30
            r21 = r1
            r1 = r31
            r2 = r32
            r4 = r3
            r3 = r5
            r33 = r4
            r4 = r34
            r15 = r5
            r5 = r17
            r27 = r6
            r6 = r25
            r28 = r20
            r20 = r7
            r7 = r33
            r23 = r8
            r9 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r18
            r19 = r10
            r29 = r20
            r20 = -1
            r9 = r21
            r11 = r19
            r12 = r23
            r14 = r35
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x02e0
            goto L_0x0348
        L_0x02e0:
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r18
            r1 = r25
            r6 = r27
            r7 = r28
            goto L_0x0368
        L_0x02f4:
            r33 = r3
            r15 = r5
            r27 = r6
            r29 = r7
            r23 = r8
            r19 = r10
            r28 = r20
            r1 = r21
            r20 = -1
            r0 = 50
            r9 = r19
            if (r9 != r0) goto L_0x032c
            r7 = r33
            r0 = 2
            if (r7 != r0) goto L_0x0326
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r18
            r6 = r23
            r8 = r35
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r15) goto L_0x02e0
            goto L_0x0348
        L_0x0326:
            r2 = r15
        L_0x0327:
            r6 = r27
            r7 = r28
            goto L_0x034a
        L_0x032c:
            r7 = r33
            r0 = r30
            r8 = r1
            r1 = r31
            r2 = r32
            r3 = r15
            r4 = r34
            r5 = r17
            r6 = r25
            r10 = r23
            r12 = r18
            r13 = r35
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x02e0
        L_0x0348:
            r2 = r0
            goto L_0x0327
        L_0x034a:
            com.google.android.gms.internal.ads.zzejc r4 = zzau(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.ads.zzeen.zza(r0, r1, r2, r3, r4, r5)
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            r2 = r18
            r1 = r25
        L_0x0368:
            r9 = r29
        L_0x036a:
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r10 = -1
            goto L_0x001e
        L_0x0370:
            r27 = r6
            r29 = r9
            r1 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 == r1) goto L_0x0383
            long r1 = (long) r7
            r3 = r31
            r6 = r27
            r4 = r29
            r4.putInt(r3, r1, r6)
        L_0x0383:
            r4 = r34
            if (r0 != r4) goto L_0x0388
            return
        L_0x0388:
            com.google.android.gms.internal.ads.zzegl r0 = com.google.android.gms.internal.ads.zzegl.zzbgb()
            throw r0
        L_0x038d:
            r4 = r13
            r3 = r14
            r5 = 0
            r0 = r30
            r1 = r31
            r2 = r32
            r3 = r33
            r4 = r34
            r6 = r35
            r0.zza(r1, r2, r3, r4, r5, r6)
            return
            switch-data {0->0x021d, 1->0x0206, 2->0x01e4, 3->0x01e4, 4->0x01cd, 5->0x01ab, 6->0x0194, 7->0x0174, 8->0x0151, 9->0x0124, 10->0x010c, 11->0x01cd, 12->0x00f5, 13->0x0194, 14->0x01ab, 15->0x00da, 16->0x00a5, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzehp.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.ads.zzeem):void");
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final void zzaj(T t) {
        int i;
        int i2 = this.zzihc;
        while (true) {
            i = this.zzihd;
            if (i2 >= i) {
                break;
            }
            long zzhh = (long) (zzhh(this.zzihb[i2]) & 1048575);
            Object zzp = zzejf.zzp(t, zzhh);
            if (zzp != null) {
                zzejf.zza(t, zzhh, this.zzihi.zzar(zzp));
            }
            i2++;
        }
        int length = this.zzihb.length;
        while (i < length) {
            this.zzihf.zzb(t, (long) this.zzihb[i]);
            i++;
        }
        this.zzihg.zzaj(t);
        if (this.zzigx) {
            this.zzihh.zzaj(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzeiz<UT, UB> zzeiz) {
        zzegi zzhg;
        int i2 = this.zzigs[i];
        Object zzp = zzejf.zzp(obj, (long) (zzhh(i) & 1048575));
        if (zzp == null || (zzhg = zzhg(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzihi.zzan(zzp), zzhg, ub, zzeiz);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzegi zzegi, UB ub, zzeiz<UT, UB> zzeiz) {
        zzehg<?, ?> zzao = this.zzihi.zzao(zzhf(i));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            if (!zzegi.zzi(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzeiz.zzbhr();
                }
                zzeez zzfv = zzeer.zzfv(zzehd.zza(zzao, next.getKey(), next.getValue()));
                try {
                    zzehd.zza(zzfv.zzbdl(), zzao, next.getKey(), next.getValue());
                    zzeiz.zza(ub, i2, zzfv.zzbdk());
                    it2.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    @Override // com.google.android.gms.internal.ads.zzeih
    public final boolean zzav(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzihc) {
                return !this.zzigx || this.zzihh.zzah(t).isInitialized();
            }
            int i6 = this.zzihb[i5];
            int i7 = this.zzigs[i6];
            int zzhh = zzhh(i6);
            int i8 = this.zzigs[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzhni.getInt(t, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzhh) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzhh) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t, i7, i6) && !zza(t, zzhh, zzhe(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzap = this.zzihi.zzap(zzejf.zzp(t, (long) (zzhh & 1048575)));
                            if (!zzap.isEmpty()) {
                                if (this.zzihi.zzao(zzhf(i6)).zzigo.zzbib() == zzejt.MESSAGE) {
                                    zzeih<T> zzeih = null;
                                    Iterator<?> it2 = zzap.values().iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        Object next = it2.next();
                                        if (zzeih == null) {
                                            zzeih = zzeia.zzbgz().zzh(next.getClass());
                                        }
                                        if (!zzeih.zzav(next)) {
                                            z = false;
                                            break;
                                        }
                                    }
                                }
                            }
                            if (!z) {
                                return false;
                            }
                        }
                    }
                }
                List list = (List) zzejf.zzp(t, (long) (zzhh & 1048575));
                if (!list.isEmpty()) {
                    zzeih zzhe = zzhe(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zzhe.zzav(list.get(i12))) {
                            z = false;
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                if (!z) {
                    return false;
                }
            } else if (zza(t, i6, i2, i, i10) && !zza(t, zzhh, zzhe(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    private static boolean zza(Object obj, int i, zzeih zzeih) {
        return zzeih.zzav(zzejf.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzejw zzejw) throws IOException {
        if (obj instanceof String) {
            zzejw.zzk(i, (String) obj);
        } else {
            zzejw.zza(i, (zzeer) obj);
        }
    }

    private final void zza(Object obj, int i, zzeib zzeib) throws IOException {
        if (zzhj(i)) {
            zzejf.zza(obj, (long) (i & 1048575), zzeib.zzbdt());
        } else if (this.zzigy) {
            zzejf.zza(obj, (long) (i & 1048575), zzeib.readString());
        } else {
            zzejf.zza(obj, (long) (i & 1048575), zzeib.zzbdu());
        }
    }

    private final int zzhh(int i) {
        return this.zzigs[i + 1];
    }

    private final int zzhi(int i) {
        return this.zzigs[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzejf.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzejf.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzejf.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzejf.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzejf.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zze(t, i) == zze(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zze((Object) t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zze(T t, int i) {
        int zzhi = zzhi(i);
        long j = (long) (zzhi & 1048575);
        if (j == 1048575) {
            int zzhh = zzhh(i);
            long j2 = (long) (zzhh & 1048575);
            switch ((zzhh & 267386880) >>> 20) {
                case 0:
                    return zzejf.zzo(t, j2) != 0.0d;
                case 1:
                    return zzejf.zzn(t, j2) != 0.0f;
                case 2:
                    return zzejf.zzl(t, j2) != 0;
                case 3:
                    return zzejf.zzl(t, j2) != 0;
                case 4:
                    return zzejf.zzk(t, j2) != 0;
                case 5:
                    return zzejf.zzl(t, j2) != 0;
                case 6:
                    return zzejf.zzk(t, j2) != 0;
                case 7:
                    return zzejf.zzm(t, j2);
                case 8:
                    Object zzp = zzejf.zzp(t, j2);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzeer) {
                        return !zzeer.zzhzv.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzejf.zzp(t, j2) != null;
                case 10:
                    return !zzeer.zzhzv.equals(zzejf.zzp(t, j2));
                case 11:
                    return zzejf.zzk(t, j2) != 0;
                case 12:
                    return zzejf.zzk(t, j2) != 0;
                case 13:
                    return zzejf.zzk(t, j2) != 0;
                case 14:
                    return zzejf.zzl(t, j2) != 0;
                case 15:
                    return zzejf.zzk(t, j2) != 0;
                case 16:
                    return zzejf.zzl(t, j2) != 0;
                case 17:
                    return zzejf.zzp(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzejf.zzk(t, j) & (1 << (zzhi >>> 20))) != 0;
        }
    }

    private final void zzf(T t, int i) {
        int zzhi = zzhi(i);
        long j = (long) (1048575 & zzhi);
        if (j != 1048575) {
            zzejf.zzb(t, j, (1 << (zzhi >>> 20)) | zzejf.zzk(t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzejf.zzk(t, (long) (zzhi(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzejf.zzb(t, (long) (zzhi(i2) & 1048575), i);
    }

    private final int zzhk(int i) {
        if (i < this.zzigu || i > this.zzigv) {
            return -1;
        }
        return zzao(i, 0);
    }

    private final int zzan(int i, int i2) {
        if (i < this.zzigu || i > this.zzigv) {
            return -1;
        }
        return zzao(i, i2);
    }

    private final int zzao(int i, int i2) {
        int length = (this.zzigs.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzigs[i4];
            if (i == i5) {
                return i4;
            }
            if (i < i5) {
                length = i3 - 1;
            } else {
                i2 = i3 + 1;
            }
        }
        return -1;
    }
}
