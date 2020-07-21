package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzil<T> implements zziw<T> {
    private static final int[] zzzh = new int[0];
    private static final Unsafe zzzi = zzju.zzim();
    private final int[] zzzj;
    private final Object[] zzzk;
    private final int zzzl;
    private final int zzzm;
    private final zzih zzzn;
    private final boolean zzzo;
    private final boolean zzzp;
    private final boolean zzzq;
    private final boolean zzzr;
    private final int[] zzzs;
    private final int zzzt;
    private final int zzzu;
    private final zzip zzzv;
    private final zzhr zzzw;
    private final zzjo<?, ?> zzzx;
    private final zzgk<?> zzzy;
    private final zzia zzzz;

    private zzil(int[] iArr, Object[] objArr, int i, int i2, zzih zzih, boolean z, boolean z2, int[] iArr2, int i3, int i4, zzip zzip, zzhr zzhr, zzjo<?, ?> zzjo, zzgk<?> zzgk, zzia zzia) {
        this.zzzj = iArr;
        this.zzzk = objArr;
        this.zzzl = i;
        this.zzzm = i2;
        this.zzzp = zzih instanceof zzgx;
        this.zzzq = z;
        this.zzzo = zzgk != null && zzgk.zze(zzih);
        this.zzzr = false;
        this.zzzs = iArr2;
        this.zzzt = i3;
        this.zzzu = i4;
        this.zzzv = zzip;
        this.zzzw = zzhr;
        this.zzzx = zzjo;
        this.zzzy = zzgk;
        this.zzzn = zzih;
        this.zzzz = zzia;
    }

    private static boolean zzbs(int i) {
        return (i & 536870912) != 0;
    }

    static <T> zzil<T> zza(Class<T> cls, zzif zzif, zzip zzip, zzhr zzhr, zzjo<?, ?> zzjo, zzgk<?> zzgk, zzia zzia) {
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
        if (zzif instanceof zziu) {
            zziu zziu = (zziu) zzif;
            char c8 = 0;
            boolean z2 = zziu.zzhj() == zzgx.zzf.zzxj;
            String zzhq = zziu.zzhq();
            int length = zzhq.length();
            if (zzhq.charAt(0) >= 55296) {
                int i25 = 1;
                while (true) {
                    i = i25 + 1;
                    if (zzhq.charAt(i25) < 55296) {
                        break;
                    }
                    i25 = i;
                }
            } else {
                i = 1;
            }
            int i26 = i + 1;
            char charAt14 = zzhq.charAt(i);
            if (charAt14 >= 55296) {
                char c9 = charAt14 & 8191;
                int i27 = 13;
                while (true) {
                    i24 = i26 + 1;
                    charAt13 = zzhq.charAt(i26);
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
                iArr = zzzh;
                i2 = 0;
                c5 = 0;
                c4 = 0;
                c3 = 0;
                c2 = 0;
                c = 0;
            } else {
                int i28 = i26 + 1;
                char charAt15 = zzhq.charAt(i26);
                if (charAt15 >= 55296) {
                    char c10 = charAt15 & 8191;
                    int i29 = 13;
                    while (true) {
                        i23 = i28 + 1;
                        charAt12 = zzhq.charAt(i28);
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
                char charAt16 = zzhq.charAt(i28);
                if (charAt16 >= 55296) {
                    char c11 = charAt16 & 8191;
                    int i31 = 13;
                    while (true) {
                        i22 = i30 + 1;
                        charAt11 = zzhq.charAt(i30);
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
                c5 = zzhq.charAt(i30);
                if (c5 >= 55296) {
                    char c12 = c5 & 8191;
                    int i33 = 13;
                    while (true) {
                        i21 = i32 + 1;
                        charAt10 = zzhq.charAt(i32);
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
                c4 = zzhq.charAt(i32);
                if (c4 >= 55296) {
                    char c13 = c4 & 8191;
                    int i35 = 13;
                    while (true) {
                        i20 = i34 + 1;
                        charAt9 = zzhq.charAt(i34);
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
                c3 = zzhq.charAt(i34);
                if (c3 >= 55296) {
                    char c14 = c3 & 8191;
                    int i37 = 13;
                    while (true) {
                        i19 = i36 + 1;
                        charAt8 = zzhq.charAt(i36);
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
                c2 = zzhq.charAt(i36);
                if (c2 >= 55296) {
                    char c15 = c2 & 8191;
                    int i39 = 13;
                    while (true) {
                        i18 = i38 + 1;
                        charAt7 = zzhq.charAt(i38);
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
                char charAt17 = zzhq.charAt(i38);
                if (charAt17 >= 55296) {
                    char c16 = charAt17 & 8191;
                    int i41 = 13;
                    while (true) {
                        i17 = i40 + 1;
                        charAt6 = zzhq.charAt(i40);
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
                c = zzhq.charAt(i40);
                if (c >= 55296) {
                    char c17 = c & 8191;
                    int i43 = i42;
                    int i44 = 13;
                    while (true) {
                        i16 = i43 + 1;
                        charAt5 = zzhq.charAt(i43);
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
            Unsafe unsafe = zzzi;
            Object[] zzhr2 = zziu.zzhr();
            Class<?> cls2 = zziu.zzhl().getClass();
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
                int charAt18 = zzhq.charAt(i47);
                if (charAt18 >= 55296) {
                    int i52 = charAt18 & 8191;
                    int i53 = i51;
                    int i54 = 13;
                    while (true) {
                        i15 = i53 + 1;
                        charAt4 = zzhq.charAt(i53);
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
                char charAt19 = zzhq.charAt(i4);
                if (charAt19 >= 55296) {
                    char c19 = charAt19 & 8191;
                    int i56 = i55;
                    int i57 = 13;
                    while (true) {
                        i14 = i56 + 1;
                        charAt3 = zzhq.charAt(i56);
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
                    char charAt20 = zzhq.charAt(i5);
                    char c21 = 55296;
                    if (charAt20 >= 55296) {
                        char c22 = charAt20 & 8191;
                        int i59 = 13;
                        while (true) {
                            i13 = i58 + 1;
                            charAt2 = zzhq.charAt(i58);
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
                        objArr2[((i50 / 3) << 1) + 1] = zzhr2[i46];
                        i46++;
                    } else {
                        if (i60 == 12 && !z2) {
                            objArr2[((i50 / 3) << 1) + 1] = zzhr2[i46];
                            i46++;
                        }
                        c7 = 1;
                    }
                    int i61 = charAt20 << c7;
                    Object obj = zzhr2[i61];
                    if (obj instanceof Field) {
                        field2 = (Field) obj;
                    } else {
                        field2 = zza(cls2, (String) obj);
                        zzhr2[i61] = field2;
                    }
                    int objectFieldOffset = (int) unsafe.objectFieldOffset(field2);
                    int i62 = i61 + 1;
                    Object obj2 = zzhr2[i62];
                    if (obj2 instanceof Field) {
                        field3 = (Field) obj2;
                    } else {
                        field3 = zza(cls2, (String) obj2);
                        zzhr2[i62] = field3;
                    }
                    str = zzhq;
                    i8 = (int) unsafe.objectFieldOffset(field3);
                    z = z2;
                    objArr = objArr2;
                    i7 = objectFieldOffset;
                    i6 = i58;
                    i9 = 0;
                } else {
                    int i63 = i46 + 1;
                    Field zza = zza(cls2, (String) zzhr2[i46]);
                    if (c20 == '\t' || c20 == 17) {
                        objArr2[((i50 / 3) << 1) + 1] = zza.getType();
                    } else {
                        if (c20 == 27 || c20 == '1') {
                            i12 = i63 + 1;
                            objArr2[((i50 / 3) << 1) + 1] = zzhr2[i63];
                        } else if (c20 == '\f' || c20 == 30 || c20 == ',') {
                            if (!z2) {
                                i12 = i63 + 1;
                                objArr2[((i50 / 3) << 1) + 1] = zzhr2[i63];
                            }
                        } else if (c20 == '2') {
                            int i64 = c18 + 1;
                            iArr[c18] = i50;
                            int i65 = (i50 / 3) << 1;
                            i12 = i63 + 1;
                            objArr2[i65] = zzhr2[i63];
                            if ((charAt19 & 2048) != 0) {
                                i63 = i12 + 1;
                                objArr2[i65 + 1] = zzhr2[i12];
                                c18 = i64;
                            } else {
                                c18 = i64;
                            }
                        }
                        i10 = i12;
                        i7 = (int) unsafe.objectFieldOffset(zza);
                        if ((charAt19 & 4096) == 4096 || c20 > 17) {
                            str = zzhq;
                            z = z2;
                            objArr = objArr2;
                            i8 = 1048575;
                            i6 = i5;
                            i9 = 0;
                        } else {
                            int i66 = i5 + 1;
                            char charAt21 = zzhq.charAt(i5);
                            if (charAt21 >= 55296) {
                                char c23 = charAt21 & 8191;
                                int i67 = 13;
                                while (true) {
                                    i11 = i66 + 1;
                                    charAt = zzhq.charAt(i66);
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
                            Object obj3 = zzhr2[i68];
                            str = zzhq;
                            if (obj3 instanceof Field) {
                                field = (Field) obj3;
                            } else {
                                field = zza(cls2, (String) obj3);
                                zzhr2[i68] = field;
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
                    str = zzhq;
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
                zzhq = str;
            }
            return new zzil<>(iArr2, objArr2, c5, c4, zziu.zzhl(), z2, false, iArr, c, i45, zzip, zzhr, zzjo, zzgk, zzia);
        }
        ((zzjl) zzif).zzhj();
        int i72 = zzgx.zzf.zzxj;
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

    @Override // com.google.android.gms.internal.vision.zziw
    public final T newInstance() {
        return this.zzzv.newInstance(this.zzzn);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006a, code lost:
        if (com.google.android.gms.internal.vision.zziy.zze(com.google.android.gms.internal.vision.zzju.zzp(r10, r6), com.google.android.gms.internal.vision.zzju.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x007e, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzl(r10, r6) == com.google.android.gms.internal.vision.zzju.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0090, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzk(r10, r6) == com.google.android.gms.internal.vision.zzju.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a4, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzl(r10, r6) == com.google.android.gms.internal.vision.zzju.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00b6, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzk(r10, r6) == com.google.android.gms.internal.vision.zzju.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00c8, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzk(r10, r6) == com.google.android.gms.internal.vision.zzju.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00da, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzk(r10, r6) == com.google.android.gms.internal.vision.zzju.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00f0, code lost:
        if (com.google.android.gms.internal.vision.zziy.zze(com.google.android.gms.internal.vision.zzju.zzp(r10, r6), com.google.android.gms.internal.vision.zzju.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0106, code lost:
        if (com.google.android.gms.internal.vision.zziy.zze(com.google.android.gms.internal.vision.zzju.zzp(r10, r6), com.google.android.gms.internal.vision.zzju.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011c, code lost:
        if (com.google.android.gms.internal.vision.zziy.zze(com.google.android.gms.internal.vision.zzju.zzp(r10, r6), com.google.android.gms.internal.vision.zzju.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012e, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzm(r10, r6) == com.google.android.gms.internal.vision.zzju.zzm(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0140, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzk(r10, r6) == com.google.android.gms.internal.vision.zzju.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzl(r10, r6) == com.google.android.gms.internal.vision.zzju.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0165, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzk(r10, r6) == com.google.android.gms.internal.vision.zzju.zzk(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0178, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzl(r10, r6) == com.google.android.gms.internal.vision.zzju.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x018b, code lost:
        if (com.google.android.gms.internal.vision.zzju.zzl(r10, r6) == com.google.android.gms.internal.vision.zzju.zzl(r11, r6)) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x01a4, code lost:
        if (java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzju.zzn(r10, r6)) == java.lang.Float.floatToIntBits(com.google.android.gms.internal.vision.zzju.zzn(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x01bf, code lost:
        if (java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzju.zzo(r10, r6)) == java.lang.Double.doubleToLongBits(com.google.android.gms.internal.vision.zzju.zzo(r11, r6))) goto L_0x01c2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.vision.zziy.zze(com.google.android.gms.internal.vision.zzju.zzp(r10, r6), com.google.android.gms.internal.vision.zzju.zzp(r11, r6)) != false) goto L_0x01c2;
     */
    @Override // com.google.android.gms.internal.vision.zziw
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzzj
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01c9
            int r4 = r9.zzbq(r2)
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
            int r4 = r9.zzbr(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.vision.zzju.zzk(r10, r4)
            int r4 = com.google.android.gms.internal.vision.zzju.zzk(r11, r4)
            if (r8 != r4) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzju.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzju.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zziy.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzju.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzju.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zziy.zze(r3, r4)
            goto L_0x01c2
        L_0x004a:
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzju.zzp(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzju.zzp(r11, r6)
            boolean r3 = com.google.android.gms.internal.vision.zziy.zze(r3, r4)
            goto L_0x01c2
        L_0x0058:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzju.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzju.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zziy.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x006e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzju.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzju.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0082:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzju.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzju.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0094:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzju.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzju.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00a8:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzju.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzju.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00ba:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzju.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzju.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00cc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzju.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzju.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x00de:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzju.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzju.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zziy.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x00f4:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzju.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzju.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zziy.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x010a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            java.lang.Object r4 = com.google.android.gms.internal.vision.zzju.zzp(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzju.zzp(r11, r6)
            boolean r4 = com.google.android.gms.internal.vision.zziy.zze(r4, r5)
            if (r4 != 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0120:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            boolean r4 = com.google.android.gms.internal.vision.zzju.zzm(r10, r6)
            boolean r5 = com.google.android.gms.internal.vision.zzju.zzm(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0132:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzju.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzju.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0144:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzju.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzju.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x0157:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            int r4 = com.google.android.gms.internal.vision.zzju.zzk(r10, r6)
            int r5 = com.google.android.gms.internal.vision.zzju.zzk(r11, r6)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x0168:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzju.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzju.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x017b:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            long r4 = com.google.android.gms.internal.vision.zzju.zzl(r10, r6)
            long r6 = com.google.android.gms.internal.vision.zzju.zzl(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01c2
            goto L_0x01c1
        L_0x018e:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            float r4 = com.google.android.gms.internal.vision.zzju.zzn(r10, r6)
            int r4 = java.lang.Float.floatToIntBits(r4)
            float r5 = com.google.android.gms.internal.vision.zzju.zzn(r11, r6)
            int r5 = java.lang.Float.floatToIntBits(r5)
            if (r4 == r5) goto L_0x01c2
            goto L_0x01c1
        L_0x01a7:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01c1
            double r4 = com.google.android.gms.internal.vision.zzju.zzo(r10, r6)
            long r4 = java.lang.Double.doubleToLongBits(r4)
            double r6 = com.google.android.gms.internal.vision.zzju.zzo(r11, r6)
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
            com.google.android.gms.internal.vision.zzjo<?, ?> r0 = r9.zzzx
            java.lang.Object r0 = r0.zzw(r10)
            com.google.android.gms.internal.vision.zzjo<?, ?> r2 = r9.zzzx
            java.lang.Object r2 = r2.zzw(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01dc
            return r1
        L_0x01dc:
            boolean r0 = r9.zzzo
            if (r0 == 0) goto L_0x01f1
            com.google.android.gms.internal.vision.zzgk<?> r0 = r9.zzzy
            com.google.android.gms.internal.vision.zzgn r10 = r0.zzf(r10)
            com.google.android.gms.internal.vision.zzgk<?> r0 = r9.zzzy
            com.google.android.gms.internal.vision.zzgn r11 = r0.zzf(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01f1:
            return r3
            switch-data {0->0x01a7, 1->0x018e, 2->0x017b, 3->0x0168, 4->0x0157, 5->0x0144, 6->0x0132, 7->0x0120, 8->0x010a, 9->0x00f4, 10->0x00de, 11->0x00cc, 12->0x00ba, 13->0x00a8, 14->0x0094, 15->0x0082, 16->0x006e, 17->0x0058, 18->0x004a, 19->0x004a, 20->0x004a, 21->0x004a, 22->0x004a, 23->0x004a, 24->0x004a, 25->0x004a, 26->0x004a, 27->0x004a, 28->0x004a, 29->0x004a, 30->0x004a, 31->0x004a, 32->0x004a, 33->0x004a, 34->0x004a, 35->0x004a, 36->0x004a, 37->0x004a, 38->0x004a, 39->0x004a, 40->0x004a, 41->0x004a, 42->0x004a, 43->0x004a, 44->0x004a, 45->0x004a, 46->0x004a, 47->0x004a, 48->0x004a, 49->0x004a, 50->0x003c, 51->0x001c, 52->0x001c, 53->0x001c, 54->0x001c, 55->0x001c, 56->0x001c, 57->0x001c, 58->0x001c, 59->0x001c, 60->0x001c, 61->0x001c, 62->0x001c, 63->0x001c, 64->0x001c, 65->0x001c, 66->0x001c, 67->0x001c, 68->0x001c, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzil.equals(java.lang.Object, java.lang.Object):boolean");
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final int hashCode(T t) {
        int i;
        int i2;
        int length = this.zzzj.length;
        int i3 = 0;
        for (int i4 = 0; i4 < length; i4 += 3) {
            int zzbq = zzbq(i4);
            int i5 = this.zzzj[i4];
            long j = (long) (1048575 & zzbq);
            int i6 = 37;
            switch ((zzbq & 267386880) >>> 20) {
                case 0:
                    i2 = i3 * 53;
                    i = zzgy.zzab(Double.doubleToLongBits(zzju.zzo(t, j)));
                    i3 = i2 + i;
                    break;
                case 1:
                    i2 = i3 * 53;
                    i = Float.floatToIntBits(zzju.zzn(t, j));
                    i3 = i2 + i;
                    break;
                case 2:
                    i2 = i3 * 53;
                    i = zzgy.zzab(zzju.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 3:
                    i2 = i3 * 53;
                    i = zzgy.zzab(zzju.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 4:
                    i2 = i3 * 53;
                    i = zzju.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 5:
                    i2 = i3 * 53;
                    i = zzgy.zzab(zzju.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 6:
                    i2 = i3 * 53;
                    i = zzju.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 7:
                    i2 = i3 * 53;
                    i = zzgy.zzm(zzju.zzm(t, j));
                    i3 = i2 + i;
                    break;
                case 8:
                    i2 = i3 * 53;
                    i = ((String) zzju.zzp(t, j)).hashCode();
                    i3 = i2 + i;
                    break;
                case 9:
                    Object zzp = zzju.zzp(t, j);
                    if (zzp != null) {
                        i6 = zzp.hashCode();
                    }
                    i3 = (i3 * 53) + i6;
                    break;
                case 10:
                    i2 = i3 * 53;
                    i = zzju.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 11:
                    i2 = i3 * 53;
                    i = zzju.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 12:
                    i2 = i3 * 53;
                    i = zzju.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 13:
                    i2 = i3 * 53;
                    i = zzju.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 14:
                    i2 = i3 * 53;
                    i = zzgy.zzab(zzju.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 15:
                    i2 = i3 * 53;
                    i = zzju.zzk(t, j);
                    i3 = i2 + i;
                    break;
                case 16:
                    i2 = i3 * 53;
                    i = zzgy.zzab(zzju.zzl(t, j));
                    i3 = i2 + i;
                    break;
                case 17:
                    Object zzp2 = zzju.zzp(t, j);
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
                    i = zzju.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 50:
                    i2 = i3 * 53;
                    i = zzju.zzp(t, j).hashCode();
                    i3 = i2 + i;
                    break;
                case 51:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgy.zzab(Double.doubleToLongBits(zzf(t, j)));
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
                        i = zzgy.zzab(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 54:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzgy.zzab(zzi(t, j));
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
                        i = zzgy.zzab(zzi(t, j));
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
                        i = zzgy.zzm(zzj(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 59:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = ((String) zzju.zzp(t, j)).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 60:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzju.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
                case 61:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzju.zzp(t, j).hashCode();
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
                        i = zzgy.zzab(zzi(t, j));
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
                        i = zzgy.zzab(zzi(t, j));
                        i3 = i2 + i;
                        break;
                    }
                case 68:
                    if (!zza(t, i5, i4)) {
                        break;
                    } else {
                        i2 = i3 * 53;
                        i = zzju.zzp(t, j).hashCode();
                        i3 = i2 + i;
                        break;
                    }
            }
        }
        int hashCode = (i3 * 53) + this.zzzx.zzw(t).hashCode();
        return this.zzzo ? (hashCode * 53) + this.zzzy.zzf(t).hashCode() : hashCode;
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zzd(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzzj.length; i += 3) {
                int zzbq = zzbq(i);
                long j = (long) (1048575 & zzbq);
                int i2 = this.zzzj[i];
                switch ((zzbq & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza(t, j, zzju.zzo(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza((Object) t, j, zzju.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza((Object) t, j, zzju.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza((Object) t, j, zzju.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zzb(t, j, zzju.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza((Object) t, j, zzju.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zzb(t, j, zzju.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza(t, j, zzju.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza(t, j, zzju.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 9:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza(t, j, zzju.zzp(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zzb(t, j, zzju.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zzb(t, j, zzju.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zzb(t, j, zzju.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza((Object) t, j, zzju.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zzb(t, j, zzju.zzk(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzju.zza((Object) t, j, zzju.zzl(t2, j));
                            zzb(t, i);
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
                        this.zzzw.zza(t, t2, j);
                        break;
                    case 50:
                        zziy.zza(this.zzzz, t, t2, j);
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
                            zzju.zza(t, j, zzju.zzp(t2, j));
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
                            zzju.zza(t, j, zzju.zzp(t2, j));
                            zzb(t, i2, i);
                            break;
                        }
                    case 68:
                        zzb(t, t2, i);
                        break;
                }
            }
            zziy.zza(this.zzzx, t, t2);
            if (this.zzzo) {
                zziy.zza(this.zzzy, t, t2);
                return;
            }
            return;
        }
        throw null;
    }

    private final void zza(T t, T t2, int i) {
        long zzbq = (long) (zzbq(i) & 1048575);
        if (zza(t2, i)) {
            Object zzp = zzju.zzp(t, zzbq);
            Object zzp2 = zzju.zzp(t2, zzbq);
            if (zzp != null && zzp2 != null) {
                zzju.zza(t, zzbq, zzgy.zzb(zzp, zzp2));
                zzb(t, i);
            } else if (zzp2 != null) {
                zzju.zza(t, zzbq, zzp2);
                zzb(t, i);
            }
        }
    }

    private final void zzb(T t, T t2, int i) {
        int zzbq = zzbq(i);
        int i2 = this.zzzj[i];
        long j = (long) (zzbq & 1048575);
        if (zza(t2, i2, i)) {
            Object zzp = zzju.zzp(t, j);
            Object zzp2 = zzju.zzp(t2, j);
            if (zzp != null && zzp2 != null) {
                zzju.zza(t, j, zzgy.zzb(zzp, zzp2));
                zzb(t, i2, i);
            } else if (zzp2 != null) {
                zzju.zza(t, j, zzp2);
                zzb(t, i2, i);
            }
        }
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.google.android.gms.internal.vision.zziw
    public final int zzs(T t) {
        int i;
        int i2;
        long j;
        int i3;
        int zzb;
        int i4;
        int i5;
        int i6;
        int i7;
        int zzb2;
        int i8;
        int i9;
        int i10;
        int i11 = 267386880;
        if (this.zzzq) {
            Unsafe unsafe = zzzi;
            int i12 = 0;
            int i13 = 0;
            while (i12 < this.zzzj.length) {
                int zzbq = zzbq(i12);
                int i14 = (zzbq & i11) >>> 20;
                int i15 = this.zzzj[i12];
                long j2 = (long) (zzbq & 1048575);
                int i16 = (i14 < zzgs.DOUBLE_LIST_PACKED.id() || i14 > zzgs.SINT64_LIST_PACKED.id()) ? 0 : this.zzzj[i12 + 2] & 1048575;
                switch (i14) {
                    case 0:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzb(i15, 0.0d);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 1:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzb(i15, 0.0f);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 2:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzd(i15, zzju.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 3:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zze(i15, zzju.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 4:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzl(i15, zzju.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 5:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzg(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 6:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzo(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 7:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzb(i15, true);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 8:
                        if (zza(t, i12)) {
                            Object zzp = zzju.zzp(t, j2);
                            if (!(zzp instanceof zzfm)) {
                                zzb2 = zzgf.zzb(i15, (String) zzp);
                                break;
                            } else {
                                zzb2 = zzgf.zzc(i15, (zzfm) zzp);
                                break;
                            }
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 9:
                        if (zza(t, i12)) {
                            zzb2 = zziy.zzc(i15, zzju.zzp(t, j2), zzbn(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 10:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzc(i15, (zzfm) zzju.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 11:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzm(i15, zzju.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 12:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzq(i15, zzju.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 13:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzp(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 14:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzh(i15, 0L);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 15:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzn(i15, zzju.zzk(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 16:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzf(i15, zzju.zzl(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 17:
                        if (zza(t, i12)) {
                            zzb2 = zzgf.zzc(i15, (zzih) zzju.zzp(t, j2), zzbn(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 18:
                        zzb2 = zziy.zzw(i15, zze(t, j2), false);
                        break;
                    case 19:
                        zzb2 = zziy.zzv(i15, zze(t, j2), false);
                        break;
                    case 20:
                        zzb2 = zziy.zzo(i15, zze(t, j2), false);
                        break;
                    case 21:
                        zzb2 = zziy.zzp(i15, zze(t, j2), false);
                        break;
                    case 22:
                        zzb2 = zziy.zzs(i15, zze(t, j2), false);
                        break;
                    case 23:
                        zzb2 = zziy.zzw(i15, zze(t, j2), false);
                        break;
                    case 24:
                        zzb2 = zziy.zzv(i15, zze(t, j2), false);
                        break;
                    case 25:
                        zzb2 = zziy.zzx(i15, zze(t, j2), false);
                        break;
                    case 26:
                        zzb2 = zziy.zzc(i15, zze(t, j2));
                        break;
                    case 27:
                        zzb2 = zziy.zzc(i15, zze(t, j2), zzbn(i12));
                        break;
                    case 28:
                        zzb2 = zziy.zzd(i15, zze(t, j2));
                        break;
                    case 29:
                        zzb2 = zziy.zzt(i15, zze(t, j2), false);
                        break;
                    case 30:
                        zzb2 = zziy.zzr(i15, zze(t, j2), false);
                        break;
                    case 31:
                        zzb2 = zziy.zzv(i15, zze(t, j2), false);
                        break;
                    case 32:
                        zzb2 = zziy.zzw(i15, zze(t, j2), false);
                        break;
                    case 33:
                        zzb2 = zziy.zzu(i15, zze(t, j2), false);
                        break;
                    case 34:
                        zzb2 = zziy.zzq(i15, zze(t, j2), false);
                        break;
                    case 35:
                        i9 = zziy.zzy((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 36:
                        i9 = zziy.zzx((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 37:
                        i9 = zziy.zzq((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 38:
                        i9 = zziy.zzr((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 39:
                        i9 = zziy.zzu((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 40:
                        i9 = zziy.zzy((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 41:
                        i9 = zziy.zzx((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 42:
                        i9 = zziy.zzz((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 43:
                        i9 = zziy.zzv((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 44:
                        i9 = zziy.zzt((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 45:
                        i9 = zziy.zzx((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 46:
                        i9 = zziy.zzy((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 47:
                        i9 = zziy.zzw((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 48:
                        i9 = zziy.zzs((List) unsafe.getObject(t, j2));
                        if (i9 > 0) {
                            if (this.zzzr) {
                                unsafe.putInt(t, (long) i16, i9);
                            }
                            i10 = zzgf.zzbb(i15);
                            i8 = zzgf.zzbd(i9);
                            zzb2 = i10 + i8 + i9;
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 49:
                        zzb2 = zziy.zzd(i15, zze(t, j2), zzbn(i12));
                        break;
                    case 50:
                        zzb2 = this.zzzz.zzb(i15, zzju.zzp(t, j2), zzbo(i12));
                        break;
                    case 51:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzb(i15, 0.0d);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 52:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzb(i15, 0.0f);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 53:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzd(i15, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 54:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zze(i15, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 55:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzl(i15, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 56:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzg(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 57:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzo(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 58:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzb(i15, true);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 59:
                        if (zza(t, i15, i12)) {
                            Object zzp2 = zzju.zzp(t, j2);
                            if (!(zzp2 instanceof zzfm)) {
                                zzb2 = zzgf.zzb(i15, (String) zzp2);
                                break;
                            } else {
                                zzb2 = zzgf.zzc(i15, (zzfm) zzp2);
                                break;
                            }
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 60:
                        if (zza(t, i15, i12)) {
                            zzb2 = zziy.zzc(i15, zzju.zzp(t, j2), zzbn(i12));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 61:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzc(i15, (zzfm) zzju.zzp(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 62:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzm(i15, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 63:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzq(i15, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 64:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzp(i15, 0);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 65:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzh(i15, 0L);
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 66:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzn(i15, zzh(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 67:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzf(i15, zzi(t, j2));
                            break;
                        } else {
                            continue;
                            i12 += 3;
                            i11 = 267386880;
                        }
                    case 68:
                        if (zza(t, i15, i12)) {
                            zzb2 = zzgf.zzc(i15, (zzih) zzju.zzp(t, j2), zzbn(i12));
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
                i13 += zzb2;
                i12 += 3;
                i11 = 267386880;
            }
            return i13 + zza((zzjo) this.zzzx, (Object) t);
        }
        Unsafe unsafe2 = zzzi;
        int i17 = 0;
        int i18 = 1048575;
        int i19 = 0;
        for (int i20 = 0; i20 < this.zzzj.length; i20 += 3) {
            int zzbq2 = zzbq(i20);
            int[] iArr = this.zzzj;
            int i21 = iArr[i20];
            int i22 = (zzbq2 & 267386880) >>> 20;
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
                i2 = (!this.zzzr || i22 < zzgs.DOUBLE_LIST_PACKED.id() || i22 > zzgs.SINT64_LIST_PACKED.id()) ? 0 : this.zzzj[i20 + 2] & 1048575;
                i = 0;
            }
            long j3 = (long) (zzbq2 & 1048575);
            switch (i22) {
                case 0:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i17 += zzgf.zzb(i21, 0.0d);
                        break;
                    }
                    break;
                case 1:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i17 += zzgf.zzb(i21, 0.0f);
                        break;
                    }
                case 2:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzgf.zzd(i21, unsafe2.getLong(t, j3));
                        i17 += i3;
                    }
                    break;
                case 3:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzgf.zze(i21, unsafe2.getLong(t, j3));
                        i17 += i3;
                    }
                    break;
                case 4:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzgf.zzl(i21, unsafe2.getInt(t, j3));
                        i17 += i3;
                    }
                    break;
                case 5:
                    j = 0;
                    if ((i19 & i) != 0) {
                        i3 = zzgf.zzg(i21, 0);
                        i17 += i3;
                    }
                    break;
                case 6:
                    if ((i19 & i) != 0) {
                        i17 += zzgf.zzo(i21, 0);
                        j = 0;
                        break;
                    }
                    j = 0;
                case 7:
                    if ((i19 & i) != 0) {
                        zzb = zzgf.zzb(i21, true);
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 8:
                    if ((i19 & i) != 0) {
                        Object object = unsafe2.getObject(t, j3);
                        zzb = object instanceof zzfm ? zzgf.zzc(i21, (zzfm) object) : zzgf.zzb(i21, (String) object);
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 9:
                    if ((i19 & i) != 0) {
                        zzb = zziy.zzc(i21, unsafe2.getObject(t, j3), zzbn(i20));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 10:
                    if ((i19 & i) != 0) {
                        zzb = zzgf.zzc(i21, (zzfm) unsafe2.getObject(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 11:
                    if ((i19 & i) != 0) {
                        zzb = zzgf.zzm(i21, unsafe2.getInt(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 12:
                    if ((i19 & i) != 0) {
                        zzb = zzgf.zzq(i21, unsafe2.getInt(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 13:
                    if ((i19 & i) != 0) {
                        i4 = zzgf.zzp(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 14:
                    if ((i19 & i) != 0) {
                        zzb = zzgf.zzh(i21, 0L);
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 15:
                    if ((i19 & i) != 0) {
                        zzb = zzgf.zzn(i21, unsafe2.getInt(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 16:
                    if ((i19 & i) != 0) {
                        zzb = zzgf.zzf(i21, unsafe2.getLong(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 17:
                    if ((i19 & i) != 0) {
                        zzb = zzgf.zzc(i21, (zzih) unsafe2.getObject(t, j3), zzbn(i20));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 18:
                    zzb = zziy.zzw(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 19:
                    zzb = zziy.zzv(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 20:
                    zzb = zziy.zzo(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 21:
                    zzb = zziy.zzp(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 22:
                    zzb = zziy.zzs(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 23:
                    zzb = zziy.zzw(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 24:
                    zzb = zziy.zzv(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 25:
                    zzb = zziy.zzx(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 26:
                    zzb = zziy.zzc(i21, (List) unsafe2.getObject(t, j3));
                    i17 += zzb;
                    j = 0;
                    break;
                case 27:
                    zzb = zziy.zzc(i21, (List<?>) ((List) unsafe2.getObject(t, j3)), zzbn(i20));
                    i17 += zzb;
                    j = 0;
                    break;
                case 28:
                    zzb = zziy.zzd(i21, (List) unsafe2.getObject(t, j3));
                    i17 += zzb;
                    j = 0;
                    break;
                case 29:
                    zzb = zziy.zzt(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 30:
                    zzb = zziy.zzr(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 31:
                    zzb = zziy.zzv(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 32:
                    zzb = zziy.zzw(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 33:
                    zzb = zziy.zzu(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 34:
                    zzb = zziy.zzq(i21, (List) unsafe2.getObject(t, j3), false);
                    i17 += zzb;
                    j = 0;
                    break;
                case 35:
                    i7 = zziy.zzy((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 36:
                    i7 = zziy.zzx((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 37:
                    i7 = zziy.zzq((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 38:
                    i7 = zziy.zzr((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 39:
                    i7 = zziy.zzu((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 40:
                    i7 = zziy.zzy((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 41:
                    i7 = zziy.zzx((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 42:
                    i7 = zziy.zzz((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 43:
                    i7 = zziy.zzv((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 44:
                    i7 = zziy.zzt((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 45:
                    i7 = zziy.zzx((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 46:
                    i7 = zziy.zzy((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 47:
                    i7 = zziy.zzw((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 48:
                    i7 = zziy.zzs((List) unsafe2.getObject(t, j3));
                    if (i7 > 0) {
                        if (this.zzzr) {
                            unsafe2.putInt(t, (long) i2, i7);
                        }
                        i6 = zzgf.zzbb(i21);
                        i5 = zzgf.zzbd(i7);
                        i4 = i6 + i5 + i7;
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 49:
                    zzb = zziy.zzd(i21, (List) unsafe2.getObject(t, j3), zzbn(i20));
                    i17 += zzb;
                    j = 0;
                    break;
                case 50:
                    zzb = this.zzzz.zzb(i21, unsafe2.getObject(t, j3), zzbo(i20));
                    i17 += zzb;
                    j = 0;
                    break;
                case 51:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzb(i21, 0.0d);
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 52:
                    if (zza(t, i21, i20)) {
                        i4 = zzgf.zzb(i21, 0.0f);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 53:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzd(i21, zzi(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 54:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zze(i21, zzi(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 55:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzl(i21, zzh(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 56:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzg(i21, 0);
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 57:
                    if (zza(t, i21, i20)) {
                        i4 = zzgf.zzo(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 58:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzb(i21, true);
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 59:
                    if (zza(t, i21, i20)) {
                        Object object2 = unsafe2.getObject(t, j3);
                        if (object2 instanceof zzfm) {
                            zzb = zzgf.zzc(i21, (zzfm) object2);
                        } else {
                            zzb = zzgf.zzb(i21, (String) object2);
                        }
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 60:
                    if (zza(t, i21, i20)) {
                        zzb = zziy.zzc(i21, unsafe2.getObject(t, j3), zzbn(i20));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 61:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzc(i21, (zzfm) unsafe2.getObject(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 62:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzm(i21, zzh(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 63:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzq(i21, zzh(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 64:
                    if (zza(t, i21, i20)) {
                        i4 = zzgf.zzp(i21, 0);
                        i17 += i4;
                    }
                    j = 0;
                    break;
                case 65:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzh(i21, 0L);
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 66:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzn(i21, zzh(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 67:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzf(i21, zzi(t, j3));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                case 68:
                    if (zza(t, i21, i20)) {
                        zzb = zzgf.zzc(i21, (zzih) unsafe2.getObject(t, j3), zzbn(i20));
                        i17 += zzb;
                    }
                    j = 0;
                    break;
                default:
                    j = 0;
                    break;
            }
        }
        int i25 = 0;
        int zza = i17 + zza((zzjo) this.zzzx, (Object) t);
        if (!this.zzzo) {
            return zza;
        }
        zzgn<?> zzf = this.zzzy.zzf(t);
        for (int i26 = 0; i26 < zzf.zztq.zzhy(); i26++) {
            Map.Entry<T, Object> zzbv = zzf.zztq.zzbv(i26);
            i25 += zzgn.zzc(zzbv.getKey(), zzbv.getValue());
        }
        for (Map.Entry<T, Object> entry : zzf.zztq.zzhz()) {
            i25 += zzgn.zzc(entry.getKey(), entry.getValue());
        }
        return zza + i25;
    }

    private static <UT, UB> int zza(zzjo<UT, UB> zzjo, T t) {
        return zzjo.zzs(zzjo.zzw(t));
    }

    private static List<?> zze(Object obj, long j) {
        return (List) zzju.zzp(obj, j);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x0513  */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0552  */
    /* JADX WARNING: Removed duplicated region for block: B:331:0x0a2a  */
    @Override // com.google.android.gms.internal.vision.zziw
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.vision.zzkl r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzfk()
            int r1 = com.google.android.gms.internal.vision.zzgx.zzf.zzxm
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x0529
            com.google.android.gms.internal.vision.zzjo<?, ?> r0 = r13.zzzx
            zza(r0, r14, r15)
            boolean r0 = r13.zzzo
            if (r0 == 0) goto L_0x0032
            com.google.android.gms.internal.vision.zzgk<?> r0 = r13.zzzy
            com.google.android.gms.internal.vision.zzgn r0 = r0.zzf(r14)
            com.google.android.gms.internal.vision.zzjb<T, java.lang.Object> r1 = r0.zztq
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
            int[] r7 = r13.zzzj
            int r7 = r7.length
            int r7 = r7 + -3
        L_0x0039:
            if (r7 < 0) goto L_0x0511
            int r8 = r13.zzbq(r7)
            int[] r9 = r13.zzzj
            r9 = r9[r7]
        L_0x0043:
            if (r1 == 0) goto L_0x0061
            com.google.android.gms.internal.vision.zzgk<?> r10 = r13.zzzy
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x0061
            com.google.android.gms.internal.vision.zzgk<?> r10 = r13.zzzy
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
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            com.google.android.gms.internal.vision.zziw r10 = r13.zzbn(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x007f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x0090:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzj(r9, r8)
            goto L_0x050d
        L_0x00a1:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x00b2:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x00c3:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x00d4:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x050d
        L_0x00e5:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzfm r8 = (com.google.android.gms.internal.vision.zzfm) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x00f8:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            com.google.android.gms.internal.vision.zziw r10 = r13.zzbn(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x010d:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x011e:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzj(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x012f:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x0140:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x0151:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzh(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x0162:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x0173:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzi(r14, r10)
            r15.zzi(r9, r10)
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
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x01a6:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x050d
        L_0x01b1:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziw r10 = r13.zzbn(r7)
            com.google.android.gms.internal.vision.zziy.zzb(r9, r8, r15, r10)
            goto L_0x050d
        L_0x01c6:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zze(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01d7:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzj(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01e8:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzg(r9, r8, r15, r4)
            goto L_0x050d
        L_0x01f9:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzl(r9, r8, r15, r4)
            goto L_0x050d
        L_0x020a:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzm(r9, r8, r15, r4)
            goto L_0x050d
        L_0x021b:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzi(r9, r8, r15, r4)
            goto L_0x050d
        L_0x022c:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzn(r9, r8, r15, r4)
            goto L_0x050d
        L_0x023d:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzk(r9, r8, r15, r4)
            goto L_0x050d
        L_0x024e:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzf(r9, r8, r15, r4)
            goto L_0x050d
        L_0x025f:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzh(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0270:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzd(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0281:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzc(r9, r8, r15, r4)
            goto L_0x050d
        L_0x0292:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzb(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02a3:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zza(r9, r8, r15, r4)
            goto L_0x050d
        L_0x02b4:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zze(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02c5:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzj(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02d6:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzg(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02e7:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzl(r9, r8, r15, r5)
            goto L_0x050d
        L_0x02f8:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzm(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0309:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzi(r9, r8, r15, r5)
            goto L_0x050d
        L_0x031a:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzb(r9, r8, r15)
            goto L_0x050d
        L_0x032b:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziw r10 = r13.zzbn(r7)
            com.google.android.gms.internal.vision.zziy.zza(r9, r8, r15, r10)
            goto L_0x050d
        L_0x0340:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zza(r9, r8, r15)
            goto L_0x050d
        L_0x0351:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzn(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0362:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzk(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0373:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzf(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0384:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzh(r9, r8, r15, r5)
            goto L_0x050d
        L_0x0395:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzd(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03a6:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzc(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03b7:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzb(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03c8:
            int[] r9 = r13.zzzj
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zza(r9, r8, r15, r5)
            goto L_0x050d
        L_0x03d9:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            com.google.android.gms.internal.vision.zziw r10 = r13.zzbn(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x050d
        L_0x03ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzju.zzl(r14, r10)
            r15.zzb(r9, r10)
            goto L_0x050d
        L_0x03ff:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzju.zzk(r14, r10)
            r15.zzj(r9, r8)
            goto L_0x050d
        L_0x0410:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzju.zzl(r14, r10)
            r15.zzj(r9, r10)
            goto L_0x050d
        L_0x0421:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzju.zzk(r14, r10)
            r15.zzr(r9, r8)
            goto L_0x050d
        L_0x0432:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzju.zzk(r14, r10)
            r15.zzs(r9, r8)
            goto L_0x050d
        L_0x0443:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzju.zzk(r14, r10)
            r15.zzi(r9, r8)
            goto L_0x050d
        L_0x0454:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            com.google.android.gms.internal.vision.zzfm r8 = (com.google.android.gms.internal.vision.zzfm) r8
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x0467:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            com.google.android.gms.internal.vision.zziw r10 = r13.zzbn(r7)
            r15.zza(r9, r8, r10)
            goto L_0x050d
        L_0x047c:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.vision.zzju.zzp(r14, r10)
            zza(r9, r8, r15)
            goto L_0x050d
        L_0x048d:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.vision.zzju.zzm(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x049e:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzju.zzk(r14, r10)
            r15.zzk(r9, r8)
            goto L_0x050d
        L_0x04ae:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzju.zzl(r14, r10)
            r15.zzc(r9, r10)
            goto L_0x050d
        L_0x04be:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.vision.zzju.zzk(r14, r10)
            r15.zzh(r9, r8)
            goto L_0x050d
        L_0x04ce:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzju.zzl(r14, r10)
            r15.zza(r9, r10)
            goto L_0x050d
        L_0x04de:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.vision.zzju.zzl(r14, r10)
            r15.zzi(r9, r10)
            goto L_0x050d
        L_0x04ee:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.vision.zzju.zzn(r14, r10)
            r15.zza(r9, r8)
            goto L_0x050d
        L_0x04fe:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x050d
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.vision.zzju.zzo(r14, r10)
            r15.zza(r9, r10)
        L_0x050d:
            int r7 = r7 + -3
            goto L_0x0039
        L_0x0511:
            if (r1 == 0) goto L_0x0528
            com.google.android.gms.internal.vision.zzgk<?> r14 = r13.zzzy
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
            boolean r0 = r13.zzzq
            if (r0 == 0) goto L_0x0a44
            boolean r0 = r13.zzzo
            if (r0 == 0) goto L_0x054a
            com.google.android.gms.internal.vision.zzgk<?> r0 = r13.zzzy
            com.google.android.gms.internal.vision.zzgn r0 = r0.zzf(r14)
            com.google.android.gms.internal.vision.zzjb<T, java.lang.Object> r1 = r0.zztq
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
            int[] r7 = r13.zzzj
            int r7 = r7.length
            r8 = 0
        L_0x0550:
            if (r8 >= r7) goto L_0x0a28
            int r9 = r13.zzbq(r8)
            int[] r10 = r13.zzzj
            r10 = r10[r8]
        L_0x055a:
            if (r1 == 0) goto L_0x0578
            com.google.android.gms.internal.vision.zzgk<?> r11 = r13.zzzy
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x0578
            com.google.android.gms.internal.vision.zzgk<?> r11 = r13.zzzy
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
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            com.google.android.gms.internal.vision.zziw r11 = r13.zzbn(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0596:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x05a7:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzj(r10, r9)
            goto L_0x0a24
        L_0x05b8:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x05c9:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a24
        L_0x05da:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a24
        L_0x05eb:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0a24
        L_0x05fc:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzfm r9 = (com.google.android.gms.internal.vision.zzfm) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x060f:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            com.google.android.gms.internal.vision.zziw r11 = r13.zzbn(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0624:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0635:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzj(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0646:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a24
        L_0x0657:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x0668:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzh(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a24
        L_0x0679:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x068a:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzi(r14, r11)
            r15.zzi(r10, r11)
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
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x06bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            r13.zza(r15, r10, r9, r8)
            goto L_0x0a24
        L_0x06c8:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziw r11 = r13.zzbn(r8)
            com.google.android.gms.internal.vision.zziy.zzb(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x06dd:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zze(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ee:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzj(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x06ff:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzg(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0710:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzl(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0721:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzm(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0732:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzi(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0743:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzn(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0754:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzk(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0765:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzf(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0776:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzh(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0787:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzd(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x0798:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzc(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07a9:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzb(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07ba:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zza(r10, r9, r15, r4)
            goto L_0x0a24
        L_0x07cb:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zze(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07dc:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzj(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07ed:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzg(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x07fe:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzl(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x080f:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzm(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0820:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzi(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0831:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzb(r10, r9, r15)
            goto L_0x0a24
        L_0x0842:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziw r11 = r13.zzbn(r8)
            com.google.android.gms.internal.vision.zziy.zza(r10, r9, r15, r11)
            goto L_0x0a24
        L_0x0857:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zza(r10, r9, r15)
            goto L_0x0a24
        L_0x0868:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzn(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x0879:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzk(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x088a:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzf(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x089b:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzh(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ac:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzd(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08bd:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzc(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08ce:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zzb(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08df:
            int[] r10 = r13.zzzj
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.vision.zziy.zza(r10, r9, r15, r5)
            goto L_0x0a24
        L_0x08f0:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            com.google.android.gms.internal.vision.zziw r11 = r13.zzbn(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0a24
        L_0x0905:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzju.zzl(r14, r11)
            r15.zzb(r10, r11)
            goto L_0x0a24
        L_0x0916:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzju.zzk(r14, r11)
            r15.zzj(r10, r9)
            goto L_0x0a24
        L_0x0927:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzju.zzl(r14, r11)
            r15.zzj(r10, r11)
            goto L_0x0a24
        L_0x0938:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzju.zzk(r14, r11)
            r15.zzr(r10, r9)
            goto L_0x0a24
        L_0x0949:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzju.zzk(r14, r11)
            r15.zzs(r10, r9)
            goto L_0x0a24
        L_0x095a:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzju.zzk(r14, r11)
            r15.zzi(r10, r9)
            goto L_0x0a24
        L_0x096b:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            com.google.android.gms.internal.vision.zzfm r9 = (com.google.android.gms.internal.vision.zzfm) r9
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x097e:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            com.google.android.gms.internal.vision.zziw r11 = r13.zzbn(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0a24
        L_0x0993:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.vision.zzju.zzp(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0a24
        L_0x09a4:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.vision.zzju.zzm(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x09b5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzju.zzk(r14, r11)
            r15.zzk(r10, r9)
            goto L_0x0a24
        L_0x09c5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzju.zzl(r14, r11)
            r15.zzc(r10, r11)
            goto L_0x0a24
        L_0x09d5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.vision.zzju.zzk(r14, r11)
            r15.zzh(r10, r9)
            goto L_0x0a24
        L_0x09e5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzju.zzl(r14, r11)
            r15.zza(r10, r11)
            goto L_0x0a24
        L_0x09f5:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.vision.zzju.zzl(r14, r11)
            r15.zzi(r10, r11)
            goto L_0x0a24
        L_0x0a05:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.vision.zzju.zzn(r14, r11)
            r15.zza(r10, r9)
            goto L_0x0a24
        L_0x0a15:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0a24
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.vision.zzju.zzo(r14, r11)
            r15.zza(r10, r11)
        L_0x0a24:
            int r8 = r8 + 3
            goto L_0x0550
        L_0x0a28:
            if (r1 == 0) goto L_0x0a3e
            com.google.android.gms.internal.vision.zzgk<?> r2 = r13.zzzy
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
            com.google.android.gms.internal.vision.zzjo<?, ?> r0 = r13.zzzx
            zza(r0, r14, r15)
            return
        L_0x0a44:
            r13.zzb(r14, r15)
            return
            switch-data {0->0x04fe, 1->0x04ee, 2->0x04de, 3->0x04ce, 4->0x04be, 5->0x04ae, 6->0x049e, 7->0x048d, 8->0x047c, 9->0x0467, 10->0x0454, 11->0x0443, 12->0x0432, 13->0x0421, 14->0x0410, 15->0x03ff, 16->0x03ee, 17->0x03d9, 18->0x03c8, 19->0x03b7, 20->0x03a6, 21->0x0395, 22->0x0384, 23->0x0373, 24->0x0362, 25->0x0351, 26->0x0340, 27->0x032b, 28->0x031a, 29->0x0309, 30->0x02f8, 31->0x02e7, 32->0x02d6, 33->0x02c5, 34->0x02b4, 35->0x02a3, 36->0x0292, 37->0x0281, 38->0x0270, 39->0x025f, 40->0x024e, 41->0x023d, 42->0x022c, 43->0x021b, 44->0x020a, 45->0x01f9, 46->0x01e8, 47->0x01d7, 48->0x01c6, 49->0x01b1, 50->0x01a6, 51->0x0195, 52->0x0184, 53->0x0173, 54->0x0162, 55->0x0151, 56->0x0140, 57->0x012f, 58->0x011e, 59->0x010d, 60->0x00f8, 61->0x00e5, 62->0x00d4, 63->0x00c3, 64->0x00b2, 65->0x00a1, 66->0x0090, 67->0x007f, 68->0x006a, }
            switch-data {0->0x0a15, 1->0x0a05, 2->0x09f5, 3->0x09e5, 4->0x09d5, 5->0x09c5, 6->0x09b5, 7->0x09a4, 8->0x0993, 9->0x097e, 10->0x096b, 11->0x095a, 12->0x0949, 13->0x0938, 14->0x0927, 15->0x0916, 16->0x0905, 17->0x08f0, 18->0x08df, 19->0x08ce, 20->0x08bd, 21->0x08ac, 22->0x089b, 23->0x088a, 24->0x0879, 25->0x0868, 26->0x0857, 27->0x0842, 28->0x0831, 29->0x0820, 30->0x080f, 31->0x07fe, 32->0x07ed, 33->0x07dc, 34->0x07cb, 35->0x07ba, 36->0x07a9, 37->0x0798, 38->0x0787, 39->0x0776, 40->0x0765, 41->0x0754, 42->0x0743, 43->0x0732, 44->0x0721, 45->0x0710, 46->0x06ff, 47->0x06ee, 48->0x06dd, 49->0x06c8, 50->0x06bd, 51->0x06ac, 52->0x069b, 53->0x068a, 54->0x0679, 55->0x0668, 56->0x0657, 57->0x0646, 58->0x0635, 59->0x0624, 60->0x060f, 61->0x05fc, 62->0x05eb, 63->0x05da, 64->0x05c9, 65->0x05b8, 66->0x05a7, 67->0x0596, 68->0x0581, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzil.zza(java.lang.Object, com.google.android.gms.internal.vision.zzkl):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0495  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0031  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r18, com.google.android.gms.internal.vision.zzkl r19) throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            boolean r3 = r0.zzzo
            if (r3 == 0) goto L_0x0023
            com.google.android.gms.internal.vision.zzgk<?> r3 = r0.zzzy
            com.google.android.gms.internal.vision.zzgn r3 = r3.zzf(r1)
            com.google.android.gms.internal.vision.zzjb<T, java.lang.Object> r5 = r3.zztq
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
            int[] r6 = r0.zzzj
            int r6 = r6.length
            sun.misc.Unsafe r7 = com.google.android.gms.internal.vision.zzil.zzzi
            r10 = 0
            r11 = 1048575(0xfffff, float:1.469367E-39)
            r12 = 0
        L_0x002f:
            if (r10 >= r6) goto L_0x0493
            int r13 = r0.zzbq(r10)
            int[] r14 = r0.zzzj
            r15 = r14[r10]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r16 = r13 & r16
            int r4 = r16 >>> 20
            boolean r9 = r0.zzzq
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
            com.google.android.gms.internal.vision.zzgk<?> r9 = r0.zzzy
            int r9 = r9.zza(r5)
            if (r9 > r15) goto L_0x007d
            com.google.android.gms.internal.vision.zzgk<?> r9 = r0.zzzy
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
            com.google.android.gms.internal.vision.zziw r8 = r0.zzbn(r10)
            r2.zzb(r15, r4, r8)
            goto L_0x0085
        L_0x009a:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzb(r15, r13)
            goto L_0x0085
        L_0x00a8:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzj(r15, r4)
            goto L_0x0085
        L_0x00b6:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzj(r15, r13)
            goto L_0x0085
        L_0x00c4:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzr(r15, r4)
            goto L_0x0085
        L_0x00d2:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzs(r15, r4)
            goto L_0x0085
        L_0x00e0:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzi(r15, r4)
            goto L_0x0085
        L_0x00ee:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zzfm r4 = (com.google.android.gms.internal.vision.zzfm) r4
            r2.zza(r15, r4)
            goto L_0x0085
        L_0x00fe:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            java.lang.Object r4 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zziw r8 = r0.zzbn(r10)
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
            r2.zza(r15, r4)
            goto L_0x0085
        L_0x012f:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzk(r15, r4)
            goto L_0x0085
        L_0x013e:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzc(r15, r13)
            goto L_0x0085
        L_0x014d:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            int r4 = zzh(r1, r13)
            r2.zzh(r15, r4)
            goto L_0x0085
        L_0x015c:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zza(r15, r13)
            goto L_0x0085
        L_0x016b:
            boolean r4 = r0.zza(r1, r15, r10)
            if (r4 == 0) goto L_0x0085
            long r13 = zzi(r1, r13)
            r2.zzi(r15, r13)
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
            r2.zza(r15, r13)
            goto L_0x0085
        L_0x0198:
            java.lang.Object r4 = r7.getObject(r1, r13)
            r0.zza(r2, r15, r4, r10)
            goto L_0x0085
        L_0x01a1:
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziw r13 = r0.zzbn(r10)
            com.google.android.gms.internal.vision.zziy.zzb(r4, r8, r2, r13)
            goto L_0x0085
        L_0x01b4:
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 1
            com.google.android.gms.internal.vision.zziy.zze(r4, r8, r2, r15)
            goto L_0x0085
        L_0x01c4:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzj(r4, r8, r2, r15)
            goto L_0x0085
        L_0x01d4:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzg(r4, r8, r2, r15)
            goto L_0x0085
        L_0x01e4:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzl(r4, r8, r2, r15)
            goto L_0x0085
        L_0x01f4:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzm(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0204:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzi(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0214:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzn(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0224:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzk(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0234:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzf(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0244:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzh(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0254:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzd(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0264:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzc(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0274:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzb(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0284:
            r15 = 1
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zza(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0294:
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.vision.zziy.zze(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02a4:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzj(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02b4:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzg(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02c4:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzl(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02d4:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzm(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02e4:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzi(r4, r8, r2, r15)
            goto L_0x0085
        L_0x02f4:
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzb(r4, r8, r2)
            goto L_0x0085
        L_0x0303:
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziw r13 = r0.zzbn(r10)
            com.google.android.gms.internal.vision.zziy.zza(r4, r8, r2, r13)
            goto L_0x0085
        L_0x0316:
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zza(r4, r8, r2)
            goto L_0x0085
        L_0x0325:
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            r15 = 0
            com.google.android.gms.internal.vision.zziy.zzn(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0335:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzk(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0345:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzf(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0355:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzh(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0365:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzd(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0375:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzc(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0385:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zzb(r4, r8, r2, r15)
            goto L_0x0085
        L_0x0395:
            r15 = 0
            int[] r4 = r0.zzzj
            r4 = r4[r10]
            java.lang.Object r8 = r7.getObject(r1, r13)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.vision.zziy.zza(r4, r8, r2, r15)
            goto L_0x0085
        L_0x03a5:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zziw r13 = r0.zzbn(r10)
            r2.zzb(r15, r8, r13)
            goto L_0x048f
        L_0x03b6:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzb(r15, r13)
            goto L_0x048f
        L_0x03c3:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzj(r15, r8)
            goto L_0x048f
        L_0x03d0:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzj(r15, r13)
            goto L_0x048f
        L_0x03dd:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzr(r15, r8)
            goto L_0x048f
        L_0x03ea:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzs(r15, r8)
            goto L_0x048f
        L_0x03f7:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzi(r15, r8)
            goto L_0x048f
        L_0x0404:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zzfm r8 = (com.google.android.gms.internal.vision.zzfm) r8
            r2.zza(r15, r8)
            goto L_0x048f
        L_0x0413:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            java.lang.Object r8 = r7.getObject(r1, r13)
            com.google.android.gms.internal.vision.zziw r13 = r0.zzbn(r10)
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
            boolean r8 = com.google.android.gms.internal.vision.zzju.zzm(r1, r13)
            r2.zza(r15, r8)
            goto L_0x048f
        L_0x043c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzk(r15, r8)
            goto L_0x048f
        L_0x0448:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzc(r15, r13)
            goto L_0x048f
        L_0x0454:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            int r8 = r7.getInt(r1, r13)
            r2.zzh(r15, r8)
            goto L_0x048f
        L_0x0460:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zza(r15, r13)
            goto L_0x048f
        L_0x046c:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            long r13 = r7.getLong(r1, r13)
            r2.zzi(r15, r13)
            goto L_0x048f
        L_0x0478:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            float r8 = com.google.android.gms.internal.vision.zzju.zzn(r1, r13)
            r2.zza(r15, r8)
            goto L_0x048f
        L_0x0484:
            r4 = 0
            r8 = r8 & r12
            if (r8 == 0) goto L_0x048f
            double r13 = com.google.android.gms.internal.vision.zzju.zzo(r1, r13)
            r2.zza(r15, r13)
        L_0x048f:
            int r10 = r10 + 3
            goto L_0x002f
        L_0x0493:
            if (r5 == 0) goto L_0x04aa
            com.google.android.gms.internal.vision.zzgk<?> r4 = r0.zzzy
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
            com.google.android.gms.internal.vision.zzjo<?, ?> r3 = r0.zzzx
            zza(r3, r1, r2)
            return
            switch-data {0->0x0484, 1->0x0478, 2->0x046c, 3->0x0460, 4->0x0454, 5->0x0448, 6->0x043c, 7->0x0430, 8->0x0424, 9->0x0413, 10->0x0404, 11->0x03f7, 12->0x03ea, 13->0x03dd, 14->0x03d0, 15->0x03c3, 16->0x03b6, 17->0x03a5, 18->0x0395, 19->0x0385, 20->0x0375, 21->0x0365, 22->0x0355, 23->0x0345, 24->0x0335, 25->0x0325, 26->0x0316, 27->0x0303, 28->0x02f4, 29->0x02e4, 30->0x02d4, 31->0x02c4, 32->0x02b4, 33->0x02a4, 34->0x0294, 35->0x0284, 36->0x0274, 37->0x0264, 38->0x0254, 39->0x0244, 40->0x0234, 41->0x0224, 42->0x0214, 43->0x0204, 44->0x01f4, 45->0x01e4, 46->0x01d4, 47->0x01c4, 48->0x01b4, 49->0x01a1, 50->0x0198, 51->0x0189, 52->0x017a, 53->0x016b, 54->0x015c, 55->0x014d, 56->0x013e, 57->0x012f, 58->0x0120, 59->0x0111, 60->0x00fe, 61->0x00ee, 62->0x00e0, 63->0x00d2, 64->0x00c4, 65->0x00b6, 66->0x00a8, 67->0x009a, 68->0x0088, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzil.zzb(java.lang.Object, com.google.android.gms.internal.vision.zzkl):void");
    }

    private final <K, V> void zza(zzkl zzkl, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzkl.zza(i, this.zzzz.zzq(zzbo(i2)), this.zzzz.zzm(obj));
        }
    }

    private static <UT, UB> void zza(zzjo<UT, UB> zzjo, T t, zzkl zzkl) throws IOException {
        zzjo.zza(zzjo.zzw(t), zzkl);
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
    @Override // com.google.android.gms.internal.vision.zziw
    public final void zza(T r13, com.google.android.gms.internal.vision.zzix r14, com.google.android.gms.internal.vision.zzgi r15) throws java.io.IOException {
        /*
            r12 = this;
            r0 = 0
            if (r15 == 0) goto L_0x05dc
            com.google.android.gms.internal.vision.zzjo<?, ?> r8 = r12.zzzx
            com.google.android.gms.internal.vision.zzgk<?> r9 = r12.zzzy
            r1 = r0
            r10 = r1
        L_0x0009:
            int r2 = r14.zzdv()     // Catch:{ all -> 0x05c4 }
            int r3 = r12.zzbt(r2)     // Catch:{ all -> 0x05c4 }
            if (r3 >= 0) goto L_0x0077
            r3 = 2147483647(0x7fffffff, float:NaN)
            if (r2 != r3) goto L_0x002f
            int r14 = r12.zzzt
        L_0x001a:
            int r15 = r12.zzzu
            if (r14 >= r15) goto L_0x0029
            int[] r15 = r12.zzzs
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x001a
        L_0x0029:
            if (r10 == 0) goto L_0x002e
            r8.zzg(r13, r10)
        L_0x002e:
            return
        L_0x002f:
            boolean r3 = r12.zzzo
            if (r3 != 0) goto L_0x0035
            r3 = r0
            goto L_0x003c
        L_0x0035:
            com.google.android.gms.internal.vision.zzih r3 = r12.zzzn
            java.lang.Object r2 = r9.zza(r15, r3, r2)
            r3 = r2
        L_0x003c:
            if (r3 == 0) goto L_0x0051
            if (r1 != 0) goto L_0x0044
            com.google.android.gms.internal.vision.zzgn r1 = r9.zzg(r13)
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
            java.lang.Object r10 = r8.zzx(r13)
        L_0x005a:
            boolean r2 = r8.zza(r10, r14)
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzzt
        L_0x0062:
            int r15 = r12.zzzu
            if (r14 >= r15) goto L_0x0071
            int[] r15 = r12.zzzs
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0062
        L_0x0071:
            if (r10 == 0) goto L_0x0076
            r8.zzg(r13, r10)
        L_0x0076:
            return
        L_0x0077:
            int r4 = r12.zzbq(r3)
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
            java.lang.Object r10 = r8.zzig()     // Catch:{ zzhg -> 0x059d }
            goto L_0x0580
        L_0x008e:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zziw r6 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r6 = r14.zzc(r6, r15)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x00a0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzek()     // Catch:{ zzhg -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x00b2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            int r6 = r14.zzej()     // Catch:{ zzhg -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x00c4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzei()     // Catch:{ zzhg -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x00d6:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            int r6 = r14.zzeh()     // Catch:{ zzhg -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x00e8:
            int r5 = r14.zzeg()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzhd r7 = r12.zzbp(r3)     // Catch:{ zzhg -> 0x059d }
            if (r7 == 0) goto L_0x00ff
            boolean r7 = r7.zzg(r5)     // Catch:{ zzhg -> 0x059d }
            if (r7 == 0) goto L_0x00f9
            goto L_0x00ff
        L_0x00f9:
            java.lang.Object r10 = com.google.android.gms.internal.vision.zziy.zza(r2, r5, r10, r8)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x00ff:
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzhg -> 0x059d }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r6, r4)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x010d:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            int r6 = r14.zzef()     // Catch:{ zzhg -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x011f:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzfm r6 = r14.zzee()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x012d:
            boolean r5 = r12.zza(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            if (r5 == 0) goto L_0x0149
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.vision.zzju.zzp(r13, r4)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zziw r7 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r7 = r14.zza(r7, r15)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r6 = com.google.android.gms.internal.vision.zzgy.zzb(r6, r7)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0159
        L_0x0149:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zziw r6 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r6 = r14.zza(r6, r15)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
        L_0x0159:
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x015e:
            r12.zza(r13, r4, r14)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0166:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            boolean r6 = r14.zzec()     // Catch:{ zzhg -> 0x059d }
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0178:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            int r6 = r14.zzeb()     // Catch:{ zzhg -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x018a:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzea()     // Catch:{ zzhg -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x019c:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            int r6 = r14.zzdz()     // Catch:{ zzhg -> 0x059d }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x01ae:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzdx()     // Catch:{ zzhg -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x01c0:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzdy()     // Catch:{ zzhg -> 0x059d }
            java.lang.Long r6 = java.lang.Long.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x01d2:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            float r6 = r14.readFloat()     // Catch:{ zzhg -> 0x059d }
            java.lang.Float r6 = java.lang.Float.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x01e4:
            r4 = r4 & r6
            long r4 = (long) r4     // Catch:{ zzhg -> 0x059d }
            double r6 = r14.readDouble()     // Catch:{ zzhg -> 0x059d }
            java.lang.Double r6 = java.lang.Double.valueOf(r6)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r2, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x01f6:
            java.lang.Object r2 = r12.zzbo(r3)     // Catch:{ zzhg -> 0x059d }
            int r3 = r12.zzbq(r3)     // Catch:{ zzhg -> 0x059d }
            r3 = r3 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r5 = com.google.android.gms.internal.vision.zzju.zzp(r13, r3)     // Catch:{ zzhg -> 0x059d }
            if (r5 != 0) goto L_0x0210
            com.google.android.gms.internal.vision.zzia r5 = r12.zzzz     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r5 = r5.zzp(r2)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r3, r5)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0227
        L_0x0210:
            com.google.android.gms.internal.vision.zzia r6 = r12.zzzz     // Catch:{ zzhg -> 0x059d }
            boolean r6 = r6.zzn(r5)     // Catch:{ zzhg -> 0x059d }
            if (r6 == 0) goto L_0x0227
            com.google.android.gms.internal.vision.zzia r6 = r12.zzzz     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r6 = r6.zzp(r2)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzia r7 = r12.zzzz     // Catch:{ zzhg -> 0x059d }
            r7.zzc(r6, r5)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r3, r6)     // Catch:{ zzhg -> 0x059d }
            r5 = r6
        L_0x0227:
            com.google.android.gms.internal.vision.zzia r3 = r12.zzzz     // Catch:{ zzhg -> 0x059d }
            java.util.Map r3 = r3.zzl(r5)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzia r4 = r12.zzzz     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzhy r2 = r4.zzq(r2)     // Catch:{ zzhg -> 0x059d }
            r14.zza(r3, r2, r15)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0238:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zziw r2 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzhr r3 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            java.util.List r3 = r3.zza(r13, r4)     // Catch:{ zzhg -> 0x059d }
            r14.zzb(r3, r2, r15)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x024a:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0258:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0266:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0274:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzm(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0282:
            com.google.android.gms.internal.vision.zzhr r5 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzhg -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzhg -> 0x059d }
            r14.zzl(r4)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzhd r3 = r12.zzbp(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.vision.zziy.zza(r2, r4, r3, r10, r8)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0297:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x02a5:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzh(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x02b3:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzg(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x02c1:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzf(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x02cf:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zze(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x02dd:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzc(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x02eb:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzd(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x02f9:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzb(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0307:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zza(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0315:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzp(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0323:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzo(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0331:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzn(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x033f:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzm(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x034d:
            com.google.android.gms.internal.vision.zzhr r5 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r4 = r4 & r6
            long r6 = (long) r4     // Catch:{ zzhg -> 0x059d }
            java.util.List r4 = r5.zza(r13, r6)     // Catch:{ zzhg -> 0x059d }
            r14.zzl(r4)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzhd r3 = r12.zzbp(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r10 = com.google.android.gms.internal.vision.zziy.zza(r2, r4, r3, r10, r8)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0362:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzk(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0370:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzj(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x037e:
            com.google.android.gms.internal.vision.zziw r2 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzhr r5 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            java.util.List r3 = r5.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zza(r3, r2, r15)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0390:
            boolean r2 = zzbs(r4)     // Catch:{ zzhg -> 0x059d }
            if (r2 == 0) goto L_0x03a4
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzi(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x03a4:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.readStringList(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x03b2:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzh(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x03c0:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzg(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x03ce:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzf(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x03dc:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zze(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x03ea:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzc(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x03f8:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzd(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0406:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zzb(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0414:
            com.google.android.gms.internal.vision.zzhr r2 = r12.zzzw     // Catch:{ zzhg -> 0x059d }
            r3 = r4 & r6
            long r3 = (long) r3     // Catch:{ zzhg -> 0x059d }
            java.util.List r2 = r2.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            r14.zza(r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0422:
            boolean r2 = r12.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            if (r2 == 0) goto L_0x0440
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzju.zzp(r13, r4)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zziw r3 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r3 = r14.zzc(r3, r15)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzgy.zzb(r2, r3)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0440:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zziw r2 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r2 = r14.zzc(r2, r15)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0453:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzek()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0462:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            int r2 = r14.zzej()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zzb(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0471:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzei()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0480:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            int r2 = r14.zzeh()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zzb(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x048f:
            int r5 = r14.zzeg()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzhd r7 = r12.zzbp(r3)     // Catch:{ zzhg -> 0x059d }
            if (r7 == 0) goto L_0x04a6
            boolean r7 = r7.zzg(r5)     // Catch:{ zzhg -> 0x059d }
            if (r7 == 0) goto L_0x04a0
            goto L_0x04a6
        L_0x04a0:
            java.lang.Object r10 = com.google.android.gms.internal.vision.zziy.zza(r2, r5, r10, r8)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x04a6:
            r2 = r4 & r6
            long r6 = (long) r2     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zzb(r13, r6, r5)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x04b1:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            int r2 = r14.zzef()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zzb(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x04c0:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzfm r2 = r14.zzee()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x04cf:
            boolean r2 = r12.zza(r13, r3)     // Catch:{ zzhg -> 0x059d }
            if (r2 == 0) goto L_0x04ed
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzju.zzp(r13, r4)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zziw r3 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r3 = r14.zza(r3, r15)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r2 = com.google.android.gms.internal.vision.zzgy.zzb(r2, r3)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x04ed:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zziw r2 = r12.zzbn(r3)     // Catch:{ zzhg -> 0x059d }
            java.lang.Object r2 = r14.zza(r2, r15)     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0500:
            r12.zza(r13, r4, r14)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0508:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            boolean r2 = r14.zzec()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0517:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            int r2 = r14.zzeb()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zzb(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0526:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzea()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0535:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            int r2 = r14.zzdz()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zzb(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0544:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzdx()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0553:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            long r6 = r14.zzdy()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0562:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            float r2 = r14.readFloat()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r2)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0571:
            r2 = r4 & r6
            long r4 = (long) r2     // Catch:{ zzhg -> 0x059d }
            double r6 = r14.readDouble()     // Catch:{ zzhg -> 0x059d }
            com.google.android.gms.internal.vision.zzju.zza(r13, r4, r6)     // Catch:{ zzhg -> 0x059d }
            r12.zzb(r13, r3)     // Catch:{ zzhg -> 0x059d }
            goto L_0x0009
        L_0x0580:
            boolean r2 = r8.zza(r10, r14)     // Catch:{ zzhg -> 0x059d }
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzzt
        L_0x0588:
            int r15 = r12.zzzu
            if (r14 >= r15) goto L_0x0597
            int[] r15 = r12.zzzs
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x0588
        L_0x0597:
            if (r10 == 0) goto L_0x059c
            r8.zzg(r13, r10)
        L_0x059c:
            return
        L_0x059d:
            r8.zza(r14)
            if (r10 != 0) goto L_0x05a7
            java.lang.Object r2 = r8.zzx(r13)
            r10 = r2
        L_0x05a7:
            boolean r2 = r8.zza(r10, r14)
            if (r2 != 0) goto L_0x0009
            int r14 = r12.zzzt
        L_0x05af:
            int r15 = r12.zzzu
            if (r14 >= r15) goto L_0x05be
            int[] r15 = r12.zzzs
            r15 = r15[r14]
            java.lang.Object r10 = r12.zza(r13, r15, r10, r8)
            int r14 = r14 + 1
            goto L_0x05af
        L_0x05be:
            if (r10 == 0) goto L_0x05c3
            r8.zzg(r13, r10)
        L_0x05c3:
            return
        L_0x05c4:
            r14 = move-exception
            int r15 = r12.zzzt
        L_0x05c7:
            int r0 = r12.zzzu
            if (r15 >= r0) goto L_0x05d6
            int[] r0 = r12.zzzs
            r0 = r0[r15]
            java.lang.Object r10 = r12.zza(r13, r0, r10, r8)
            int r15 = r15 + 1
            goto L_0x05c7
        L_0x05d6:
            if (r10 == 0) goto L_0x05db
            r8.zzg(r13, r10)
        L_0x05db:
            throw r14
        L_0x05dc:
            throw r0
            switch-data {0->0x0571, 1->0x0562, 2->0x0553, 3->0x0544, 4->0x0535, 5->0x0526, 6->0x0517, 7->0x0508, 8->0x0500, 9->0x04cf, 10->0x04c0, 11->0x04b1, 12->0x048f, 13->0x0480, 14->0x0471, 15->0x0462, 16->0x0453, 17->0x0422, 18->0x0414, 19->0x0406, 20->0x03f8, 21->0x03ea, 22->0x03dc, 23->0x03ce, 24->0x03c0, 25->0x03b2, 26->0x0390, 27->0x037e, 28->0x0370, 29->0x0362, 30->0x034d, 31->0x033f, 32->0x0331, 33->0x0323, 34->0x0315, 35->0x0307, 36->0x02f9, 37->0x02eb, 38->0x02dd, 39->0x02cf, 40->0x02c1, 41->0x02b3, 42->0x02a5, 43->0x0297, 44->0x0282, 45->0x0274, 46->0x0266, 47->0x0258, 48->0x024a, 49->0x0238, 50->0x01f6, 51->0x01e4, 52->0x01d2, 53->0x01c0, 54->0x01ae, 55->0x019c, 56->0x018a, 57->0x0178, 58->0x0166, 59->0x015e, 60->0x012d, 61->0x011f, 62->0x010d, 63->0x00e8, 64->0x00d6, 65->0x00c4, 66->0x00b2, 67->0x00a0, 68->0x008e, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzil.zza(java.lang.Object, com.google.android.gms.internal.vision.zzix, com.google.android.gms.internal.vision.zzgi):void");
    }

    private static zzjr zzt(Object obj) {
        zzgx zzgx = (zzgx) obj;
        zzjr zzjr = zzgx.zzws;
        if (zzjr != zzjr.zzih()) {
            return zzjr;
        }
        zzjr zzii = zzjr.zzii();
        zzgx.zzws = zzii;
        return zzii;
    }

    private static int zza(byte[] bArr, int i, int i2, zzkf zzkf, Class<?> cls, zzfg zzfg) throws IOException {
        switch (zzik.zzsg[zzkf.ordinal()]) {
            case 1:
                int zzb = zzfe.zzb(bArr, i, zzfg);
                zzfg.zzsf = Boolean.valueOf(zzfg.zzse != 0);
                return zzb;
            case 2:
                return zzfe.zze(bArr, i, zzfg);
            case 3:
                zzfg.zzsf = Double.valueOf(zzfe.zzc(bArr, i));
                return i + 8;
            case 4:
            case 5:
                zzfg.zzsf = Integer.valueOf(zzfe.zza(bArr, i));
                return i + 4;
            case 6:
            case 7:
                zzfg.zzsf = Long.valueOf(zzfe.zzb(bArr, i));
                return i + 8;
            case 8:
                zzfg.zzsf = Float.valueOf(zzfe.zzd(bArr, i));
                return i + 4;
            case 9:
            case 10:
            case 11:
                int zza = zzfe.zza(bArr, i, zzfg);
                zzfg.zzsf = Integer.valueOf(zzfg.zzsd);
                return zza;
            case 12:
            case 13:
                int zzb2 = zzfe.zzb(bArr, i, zzfg);
                zzfg.zzsf = Long.valueOf(zzfg.zzse);
                return zzb2;
            case 14:
                return zzfe.zza(zzis.zzhp().zzf(cls), bArr, i, i2, zzfg);
            case 15:
                int zza2 = zzfe.zza(bArr, i, zzfg);
                zzfg.zzsf = Integer.valueOf(zzfy.zzav(zzfg.zzsd));
                return zza2;
            case 16:
                int zzb3 = zzfe.zzb(bArr, i, zzfg);
                zzfg.zzsf = Long.valueOf(zzfy.zzr(zzfg.zzse));
                return zzb3;
            case 17:
                return zzfe.zzd(bArr, i, zzfg);
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
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:190:0x0354 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x0353 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:203:0x0353 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x01b3  */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.vision.zzfg r30) throws java.io.IOException {
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
            sun.misc.Unsafe r11 = com.google.android.gms.internal.vision.zzil.zzzi
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.vision.zzhe r11 = (com.google.android.gms.internal.vision.zzhe) r11
            boolean r12 = r11.zzdp()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.vision.zzhe r11 = r11.zzah(r12)
            sun.misc.Unsafe r12 = com.google.android.gms.internal.vision.zzil.zzzi
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x032d;
                case 19: goto L_0x0307;
                case 20: goto L_0x02de;
                case 21: goto L_0x02de;
                case 22: goto L_0x02c4;
                case 23: goto L_0x029d;
                case 24: goto L_0x0276;
                case 25: goto L_0x023e;
                case 26: goto L_0x018b;
                case 27: goto L_0x0171;
                case 28: goto L_0x0119;
                case 29: goto L_0x02c4;
                case 30: goto L_0x00e1;
                case 31: goto L_0x0276;
                case 32: goto L_0x029d;
                case 33: goto L_0x00b0;
                case 34: goto L_0x007f;
                case 35: goto L_0x032d;
                case 36: goto L_0x0307;
                case 37: goto L_0x02de;
                case 38: goto L_0x02de;
                case 39: goto L_0x02c4;
                case 40: goto L_0x029d;
                case 41: goto L_0x0276;
                case 42: goto L_0x023e;
                case 43: goto L_0x02c4;
                case 44: goto L_0x00e1;
                case 45: goto L_0x0276;
                case 46: goto L_0x029d;
                case 47: goto L_0x00b0;
                case 48: goto L_0x007f;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x0353
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x0353
            com.google.android.gms.internal.vision.zziw r1 = r0.zzbn(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzsf
            r11.add(r8)
        L_0x005f:
            if (r4 >= r5) goto L_0x0353
            int r8 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r9 = r7.zzsd
            if (r2 != r9) goto L_0x0353
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r22, r23, r24, r25, r26, r27)
            java.lang.Object r8 = r7.zzsf
            r11.add(r8)
            goto L_0x005f
        L_0x007f:
            if (r6 != r10) goto L_0x0087
            int r1 = com.google.android.gms.internal.vision.zzfe.zzi(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0087:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.zzhv r11 = (com.google.android.gms.internal.vision.zzhv) r11
            int r1 = com.google.android.gms.internal.vision.zzfe.zzb(r3, r4, r7)
            long r8 = r7.zzse
            long r8 = com.google.android.gms.internal.vision.zzfy.zzr(r8)
            r11.zzac(r8)
        L_0x0098:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r6 = r7.zzsd
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzfe.zzb(r3, r4, r7)
            long r8 = r7.zzse
            long r8 = com.google.android.gms.internal.vision.zzfy.zzr(r8)
            r11.zzac(r8)
            goto L_0x0098
        L_0x00b0:
            if (r6 != r10) goto L_0x00b8
            int r1 = com.google.android.gms.internal.vision.zzfe.zzh(r3, r4, r11, r7)
            goto L_0x0354
        L_0x00b8:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.zzgz r11 = (com.google.android.gms.internal.vision.zzgz) r11
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r4 = r7.zzsd
            int r4 = com.google.android.gms.internal.vision.zzfy.zzav(r4)
            r11.zzbm(r4)
        L_0x00c9:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r6 = r7.zzsd
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r4 = r7.zzsd
            int r4 = com.google.android.gms.internal.vision.zzfy.zzav(r4)
            r11.zzbm(r4)
            goto L_0x00c9
        L_0x00e1:
            if (r6 != r10) goto L_0x00e8
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r11, r7)
            goto L_0x00f9
        L_0x00e8:
            if (r6 != 0) goto L_0x0353
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r2, r3, r4, r5, r6, r7)
        L_0x00f9:
            com.google.android.gms.internal.vision.zzgx r1 = (com.google.android.gms.internal.vision.zzgx) r1
            com.google.android.gms.internal.vision.zzjr r3 = r1.zzws
            com.google.android.gms.internal.vision.zzjr r4 = com.google.android.gms.internal.vision.zzjr.zzih()
            if (r3 != r4) goto L_0x0104
            r3 = 0
        L_0x0104:
            com.google.android.gms.internal.vision.zzhd r4 = r0.zzbp(r8)
            com.google.android.gms.internal.vision.zzjo<?, ?> r5 = r0.zzzx
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.vision.zziy.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.vision.zzjr r3 = (com.google.android.gms.internal.vision.zzjr) r3
            if (r3 == 0) goto L_0x0116
            r1.zzws = r3
        L_0x0116:
            r1 = r2
            goto L_0x0354
        L_0x0119:
            if (r6 != r10) goto L_0x0353
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r4 = r7.zzsd
            if (r4 < 0) goto L_0x016c
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x0167
            if (r4 != 0) goto L_0x012f
            com.google.android.gms.internal.vision.zzfm r4 = com.google.android.gms.internal.vision.zzfm.zzsm
            r11.add(r4)
            goto L_0x0137
        L_0x012f:
            com.google.android.gms.internal.vision.zzfm r6 = com.google.android.gms.internal.vision.zzfm.zza(r3, r1, r4)
            r11.add(r6)
        L_0x0136:
            int r1 = r1 + r4
        L_0x0137:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r6 = r7.zzsd
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r4 = r7.zzsd
            if (r4 < 0) goto L_0x0162
            int r6 = r3.length
            int r6 = r6 - r1
            if (r4 > r6) goto L_0x015d
            if (r4 != 0) goto L_0x0155
            com.google.android.gms.internal.vision.zzfm r4 = com.google.android.gms.internal.vision.zzfm.zzsm
            r11.add(r4)
            goto L_0x0137
        L_0x0155:
            com.google.android.gms.internal.vision.zzfm r6 = com.google.android.gms.internal.vision.zzfm.zza(r3, r1, r4)
            r11.add(r6)
            goto L_0x0136
        L_0x015d:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgn()
            throw r1
        L_0x0162:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgo()
            throw r1
        L_0x0167:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgn()
            throw r1
        L_0x016c:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgo()
            throw r1
        L_0x0171:
            if (r6 != r10) goto L_0x0353
            com.google.android.gms.internal.vision.zziw r1 = r0.zzbn(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x0354
        L_0x018b:
            if (r6 != r10) goto L_0x0353
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 != 0) goto L_0x01de
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r6 = r7.zzsd
            if (r6 < 0) goto L_0x01d9
            if (r6 != 0) goto L_0x01a6
            r11.add(r1)
            goto L_0x01b1
        L_0x01a6:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzgy.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
        L_0x01b0:
            int r4 = r4 + r6
        L_0x01b1:
            if (r4 >= r5) goto L_0x0353
            int r6 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r8 = r7.zzsd
            if (r2 != r8) goto L_0x0353
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r6, r7)
            int r6 = r7.zzsd
            if (r6 < 0) goto L_0x01d4
            if (r6 != 0) goto L_0x01c9
            r11.add(r1)
            goto L_0x01b1
        L_0x01c9:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.vision.zzgy.UTF_8
            r8.<init>(r3, r4, r6, r9)
            r11.add(r8)
            goto L_0x01b0
        L_0x01d4:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgo()
            throw r1
        L_0x01d9:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgo()
            throw r1
        L_0x01de:
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r6 = r7.zzsd
            if (r6 < 0) goto L_0x0239
            if (r6 != 0) goto L_0x01ec
            r11.add(r1)
            goto L_0x01ff
        L_0x01ec:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.vision.zzjx.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x0234
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzgy.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
        L_0x01fe:
            r4 = r8
        L_0x01ff:
            if (r4 >= r5) goto L_0x0353
            int r6 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r7)
            int r8 = r7.zzsd
            if (r2 != r8) goto L_0x0353
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r6, r7)
            int r6 = r7.zzsd
            if (r6 < 0) goto L_0x022f
            if (r6 != 0) goto L_0x0217
            r11.add(r1)
            goto L_0x01ff
        L_0x0217:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.vision.zzjx.zzf(r3, r4, r8)
            if (r9 == 0) goto L_0x022a
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.vision.zzgy.UTF_8
            r9.<init>(r3, r4, r6, r10)
            r11.add(r9)
            goto L_0x01fe
        L_0x022a:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgu()
            throw r1
        L_0x022f:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgo()
            throw r1
        L_0x0234:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgu()
            throw r1
        L_0x0239:
            com.google.android.gms.internal.vision.zzhh r1 = com.google.android.gms.internal.vision.zzhh.zzgo()
            throw r1
        L_0x023e:
            if (r6 != r10) goto L_0x0246
            int r1 = com.google.android.gms.internal.vision.zzfe.zzg(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0246:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.zzfk r11 = (com.google.android.gms.internal.vision.zzfk) r11
            int r1 = com.google.android.gms.internal.vision.zzfe.zzb(r3, r4, r7)
            long r8 = r7.zzse
            r4 = 0
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0257
            r6 = 1
            goto L_0x0258
        L_0x0257:
            r6 = 0
        L_0x0258:
            r11.addBoolean(r6)
        L_0x025b:
            if (r1 >= r5) goto L_0x0354
            int r6 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r8 = r7.zzsd
            if (r2 != r8) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzfe.zzb(r3, r6, r7)
            long r8 = r7.zzse
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0271
            r6 = 1
            goto L_0x0272
        L_0x0271:
            r6 = 0
        L_0x0272:
            r11.addBoolean(r6)
            goto L_0x025b
        L_0x0276:
            if (r6 != r10) goto L_0x027e
            int r1 = com.google.android.gms.internal.vision.zzfe.zzc(r3, r4, r11, r7)
            goto L_0x0354
        L_0x027e:
            if (r6 != r9) goto L_0x0353
            com.google.android.gms.internal.vision.zzgz r11 = (com.google.android.gms.internal.vision.zzgz) r11
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r18, r19)
            r11.zzbm(r1)
        L_0x0289:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r6 = r7.zzsd
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4)
            r11.zzbm(r1)
            goto L_0x0289
        L_0x029d:
            if (r6 != r10) goto L_0x02a5
            int r1 = com.google.android.gms.internal.vision.zzfe.zzd(r3, r4, r11, r7)
            goto L_0x0354
        L_0x02a5:
            if (r6 != r13) goto L_0x0353
            com.google.android.gms.internal.vision.zzhv r11 = (com.google.android.gms.internal.vision.zzhv) r11
            long r8 = com.google.android.gms.internal.vision.zzfe.zzb(r18, r19)
            r11.zzac(r8)
        L_0x02b0:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r6 = r7.zzsd
            if (r2 != r6) goto L_0x0354
            long r8 = com.google.android.gms.internal.vision.zzfe.zzb(r3, r4)
            r11.zzac(r8)
            goto L_0x02b0
        L_0x02c4:
            if (r6 != r10) goto L_0x02cc
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r3, r4, r11, r7)
            goto L_0x0354
        L_0x02cc:
            if (r6 != 0) goto L_0x0353
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r21, r22, r23, r24, r25, r26)
            goto L_0x0354
        L_0x02de:
            if (r6 != r10) goto L_0x02e6
            int r1 = com.google.android.gms.internal.vision.zzfe.zzb(r3, r4, r11, r7)
            goto L_0x0354
        L_0x02e6:
            if (r6 != 0) goto L_0x0353
            com.google.android.gms.internal.vision.zzhv r11 = (com.google.android.gms.internal.vision.zzhv) r11
            int r1 = com.google.android.gms.internal.vision.zzfe.zzb(r3, r4, r7)
            long r8 = r7.zzse
            r11.zzac(r8)
        L_0x02f3:
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r6 = r7.zzsd
            if (r2 != r6) goto L_0x0354
            int r1 = com.google.android.gms.internal.vision.zzfe.zzb(r3, r4, r7)
            long r8 = r7.zzse
            r11.zzac(r8)
            goto L_0x02f3
        L_0x0307:
            if (r6 != r10) goto L_0x030e
            int r1 = com.google.android.gms.internal.vision.zzfe.zze(r3, r4, r11, r7)
            goto L_0x0354
        L_0x030e:
            if (r6 != r9) goto L_0x0353
            com.google.android.gms.internal.vision.zzgt r11 = (com.google.android.gms.internal.vision.zzgt) r11
            float r1 = com.google.android.gms.internal.vision.zzfe.zzd(r18, r19)
            r11.zzu(r1)
        L_0x0319:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r6 = r7.zzsd
            if (r2 != r6) goto L_0x0354
            float r1 = com.google.android.gms.internal.vision.zzfe.zzd(r3, r4)
            r11.zzu(r1)
            goto L_0x0319
        L_0x032d:
            if (r6 != r10) goto L_0x0334
            int r1 = com.google.android.gms.internal.vision.zzfe.zzf(r3, r4, r11, r7)
            goto L_0x0354
        L_0x0334:
            if (r6 != r13) goto L_0x0353
            com.google.android.gms.internal.vision.zzgg r11 = (com.google.android.gms.internal.vision.zzgg) r11
            double r8 = com.google.android.gms.internal.vision.zzfe.zzc(r18, r19)
            r11.zzc(r8)
        L_0x033f:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x0354
            int r4 = com.google.android.gms.internal.vision.zzfe.zza(r3, r1, r7)
            int r6 = r7.zzsd
            if (r2 != r6) goto L_0x0354
            double r8 = com.google.android.gms.internal.vision.zzfe.zzc(r3, r4)
            r11.zzc(r8)
            goto L_0x033f
        L_0x0353:
            r1 = r4
        L_0x0354:
            return r1
            switch-data {18->0x032d, 19->0x0307, 20->0x02de, 21->0x02de, 22->0x02c4, 23->0x029d, 24->0x0276, 25->0x023e, 26->0x018b, 27->0x0171, 28->0x0119, 29->0x02c4, 30->0x00e1, 31->0x0276, 32->0x029d, 33->0x00b0, 34->0x007f, 35->0x032d, 36->0x0307, 37->0x02de, 38->0x02de, 39->0x02c4, 40->0x029d, 41->0x0276, 42->0x023e, 43->0x02c4, 44->0x00e1, 45->0x0276, 46->0x029d, 47->0x00b0, 48->0x007f, 49->0x003f, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzil.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.vision.zzfg):int");
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v3, resolved type: java.util.Map<?, ?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: byte} */
    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, long j, zzfg zzfg) throws IOException {
        Unsafe unsafe = zzzi;
        Object zzbo = zzbo(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzzz.zzn(object)) {
            Object zzp = this.zzzz.zzp(zzbo);
            this.zzzz.zzc(zzp, object);
            unsafe.putObject(t, j, zzp);
            object = zzp;
        }
        zzhy<?, ?> zzq = this.zzzz.zzq(zzbo);
        Map<?, ?> zzl = this.zzzz.zzl(object);
        int zza = zzfe.zza(bArr, i, zzfg);
        int i4 = zzfg.zzsd;
        if (i4 < 0 || i4 > i2 - zza) {
            throw zzhh.zzgn();
        }
        int i5 = i4 + zza;
        Object obj = zzq.zzzc;
        Object obj2 = zzq.zzgl;
        while (zza < i5) {
            int i6 = zza + 1;
            byte b = bArr[zza];
            int i7 = b;
            if (b < 0) {
                i6 = zzfe.zza(b, bArr, i6, zzfg);
                i7 = zzfg.zzsd;
            }
            int i8 = i7 >>> 3;
            int i9 = i7 & 7;
            if (i8 != 1) {
                if (i8 == 2 && i9 == zzq.zzzd.zzir()) {
                    zza = zza(bArr, i6, i2, zzq.zzzd, zzq.zzgl.getClass(), zzfg);
                    obj2 = zzfg.zzsf;
                }
            } else if (i9 == zzq.zzzb.zzir()) {
                zza = zza(bArr, i6, i2, zzq.zzzb, (Class<?>) null, zzfg);
                obj = zzfg.zzsf;
            }
            zza = zzfe.zza(i7, bArr, i6, i2, zzfg);
        }
        if (zza == i5) {
            zzl.put(obj, obj2);
            return i5;
        }
        throw zzhh.zzgt();
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzfg zzfg) throws IOException {
        int i9;
        Unsafe unsafe = zzzi;
        long j2 = (long) (this.zzzj[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Double.valueOf(zzfe.zzc(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Float.valueOf(zzfe.zzd(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    i9 = zzfe.zzb(bArr, i, zzfg);
                    unsafe.putObject(t, j, Long.valueOf(zzfg.zzse));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzfe.zza(bArr, i, zzfg);
                    unsafe.putObject(t, j, Integer.valueOf(zzfg.zzsd));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    unsafe.putObject(t, j, Long.valueOf(zzfe.zzb(bArr, i)));
                    i9 = i + 8;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    unsafe.putObject(t, j, Integer.valueOf(zzfe.zza(bArr, i)));
                    i9 = i + 4;
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzfe.zzb(bArr, i, zzfg);
                    unsafe.putObject(t, j, Boolean.valueOf(zzfg.zzse != 0));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    int zza = zzfe.zza(bArr, i, zzfg);
                    int i10 = zzfg.zzsd;
                    if (i10 == 0) {
                        unsafe.putObject(t, j, "");
                    } else if ((i6 & 536870912) == 0 || zzjx.zzf(bArr, zza, zza + i10)) {
                        unsafe.putObject(t, j, new String(bArr, zza, i10, zzgy.UTF_8));
                        zza += i10;
                    } else {
                        throw zzhh.zzgu();
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza;
                }
                return i;
            case 60:
                if (i5 == 2) {
                    int zza2 = zzfe.zza(zzbn(i8), bArr, i, i2, zzfg);
                    Object object = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object == null) {
                        unsafe.putObject(t, j, zzfg.zzsf);
                    } else {
                        unsafe.putObject(t, j, zzgy.zzb(object, zzfg.zzsf));
                    }
                    unsafe.putInt(t, j2, i4);
                    return zza2;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzfe.zze(bArr, i, zzfg);
                    unsafe.putObject(t, j, zzfg.zzsf);
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza3 = zzfe.zza(bArr, i, zzfg);
                    int i11 = zzfg.zzsd;
                    zzhd zzbp = zzbp(i8);
                    if (zzbp == null || zzbp.zzg(i11)) {
                        unsafe.putObject(t, j, Integer.valueOf(i11));
                        i9 = zza3;
                        unsafe.putInt(t, j2, i4);
                        return i9;
                    }
                    zzt(t).zzb(i3, Long.valueOf((long) i11));
                    return zza3;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzfe.zza(bArr, i, zzfg);
                    unsafe.putObject(t, j, Integer.valueOf(zzfy.zzav(zzfg.zzsd)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    i9 = zzfe.zzb(bArr, i, zzfg);
                    unsafe.putObject(t, j, Long.valueOf(zzfy.zzr(zzfg.zzse)));
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zzfe.zza(zzbn(i8), bArr, i, i2, (i3 & -8) | 4, zzfg);
                    Object object2 = unsafe.getInt(t, j2) == i4 ? unsafe.getObject(t, j) : null;
                    if (object2 == null) {
                        unsafe.putObject(t, j, zzfg.zzsf);
                    } else {
                        unsafe.putObject(t, j, zzgy.zzb(object2, zzfg.zzsf));
                    }
                    unsafe.putInt(t, j2, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    private final zziw zzbn(int i) {
        int i2 = (i / 3) << 1;
        zziw zziw = (zziw) this.zzzk[i2];
        if (zziw != null) {
            return zziw;
        }
        zziw<T> zzf = zzis.zzhp().zzf((Class) this.zzzk[i2 + 1]);
        this.zzzk[i2] = zzf;
        return zzf;
    }

    private final Object zzbo(int i) {
        return this.zzzk[(i / 3) << 1];
    }

    private final zzhd zzbp(int i) {
        return (zzhd) this.zzzk[((i / 3) << 1) + 1];
    }

    /* JADX DEBUG: Additional 28 move instruction added to help type inference */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v50, types: [com.google.android.gms.internal.vision.zzgt, com.google.android.gms.internal.vision.zzhe] */
    /* JADX WARN: Type inference failed for: r0v51, types: [com.google.android.gms.internal.vision.zzhv, com.google.android.gms.internal.vision.zzhe] */
    /* JADX WARN: Type inference failed for: r0v52, types: [com.google.android.gms.internal.vision.zzhe, com.google.android.gms.internal.vision.zzgz] */
    /* JADX WARN: Type inference failed for: r0v53, types: [com.google.android.gms.internal.vision.zzhv, com.google.android.gms.internal.vision.zzhe] */
    /* JADX WARN: Type inference failed for: r0v54, types: [com.google.android.gms.internal.vision.zzhe, com.google.android.gms.internal.vision.zzgz] */
    /* JADX WARN: Type inference failed for: r0v55, types: [com.google.android.gms.internal.vision.zzhe, com.google.android.gms.internal.vision.zzfk] */
    /* JADX WARN: Type inference failed for: r0v56, types: [com.google.android.gms.internal.vision.zzhe, com.google.android.gms.internal.vision.zzgz] */
    /* JADX WARN: Type inference failed for: r0v57, types: [com.google.android.gms.internal.vision.zzhv, com.google.android.gms.internal.vision.zzhe] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x036e, code lost:
        if (r0 == r3) goto L_0x03d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:126:0x03b4, code lost:
        if (r0 == r14) goto L_0x03d8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0680, code lost:
        if (r1 != 18) goto L_0x068f;
     */
    /* JADX WARNING: Unknown variable types count: 8 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zza(T r33, byte[] r34, int r35, int r36, int r37, com.google.android.gms.internal.vision.zzfg r38) throws java.io.IOException {
        /*
            r32 = this;
            r15 = r32
            r14 = r33
            r12 = r34
            r13 = r36
            r11 = r37
            r9 = r38
            sun.misc.Unsafe r10 = com.google.android.gms.internal.vision.zzil.zzzi
            r16 = 0
            r0 = r35
            r1 = -1
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
        L_0x0019:
            r17 = 0
            if (r0 >= r13) goto L_0x06e4
            int r3 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002c
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r12, r3, r9)
            int r3 = r9.zzsd
            r4 = r3
            r3 = r0
            goto L_0x002d
        L_0x002c:
            r4 = r0
        L_0x002d:
            int r0 = r4 >>> 3
            r7 = r4 & 7
            r8 = 3
            if (r0 <= r1) goto L_0x003a
            int r2 = r2 / r8
            int r1 = r15.zzt(r0, r2)
            goto L_0x003e
        L_0x003a:
            int r1 = r15.zzbt(r0)
        L_0x003e:
            r2 = r1
            r20 = 0
            r8 = -1
            if (r2 != r8) goto L_0x0055
            r26 = r0
            r2 = r3
            r7 = r4
            r23 = r5
            r31 = r10
            r15 = r11
            r18 = 1
            r24 = -1
            r25 = 0
            goto L_0x03da
        L_0x0055:
            int[] r8 = r15.zzzj
            int r23 = r2 + 1
            r1 = r8[r23]
            r23 = 267386880(0xff00000, float:2.3665827E-29)
            r23 = r1 & r23
            int r11 = r23 >>> 20
            r18 = r4
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r4 = r1 & r13
            long r13 = (long) r4
            r4 = 17
            if (r11 > r4) goto L_0x02d6
            int r24 = r2 + 2
            r8 = r8[r24]
            int r24 = r8 >>> 20
            r22 = 1
            int r24 = r22 << r24
            r25 = r13
            r13 = 1048575(0xfffff, float:1.469367E-39)
            r8 = r8 & r13
            if (r8 == r6) goto L_0x0095
            if (r6 == r13) goto L_0x008a
            long r13 = (long) r6
            r6 = r33
            r27 = r25
            r10.putInt(r6, r13, r5)
            goto L_0x008e
        L_0x008a:
            r6 = r33
            r27 = r25
        L_0x008e:
            long r13 = (long) r8
            int r5 = r10.getInt(r6, r13)
            r14 = r6
            goto L_0x009a
        L_0x0095:
            r14 = r33
            r27 = r25
            r8 = r6
        L_0x009a:
            r6 = r5
            r5 = 5
            switch(r11) {
                case 0: goto L_0x029e;
                case 1: goto L_0x0282;
                case 2: goto L_0x025c;
                case 3: goto L_0x025c;
                case 4: goto L_0x0242;
                case 5: goto L_0x0220;
                case 6: goto L_0x0207;
                case 7: goto L_0x01e6;
                case 8: goto L_0x01c1;
                case 9: goto L_0x017d;
                case 10: goto L_0x015e;
                case 11: goto L_0x0242;
                case 12: goto L_0x0128;
                case 13: goto L_0x0207;
                case 14: goto L_0x0220;
                case 15: goto L_0x0110;
                case 16: goto L_0x00e9;
                case 17: goto L_0x00ad;
                default: goto L_0x009f;
            }
        L_0x009f:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
        L_0x00a7:
            r2 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            goto L_0x02c4
        L_0x00ad:
            r11 = 3
            if (r7 != r11) goto L_0x009f
            int r1 = r0 << 3
            r4 = r1 | 4
            com.google.android.gms.internal.vision.zziw r1 = r15.zzbn(r2)
            r13 = r0
            r0 = r1
            r1 = r34
            r11 = r2
            r2 = r3
            r3 = r36
            r7 = r18
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r24
            if (r1 != 0) goto L_0x00d4
            java.lang.Object r1 = r9.zzsf
            r2 = r27
            r10.putObject(r14, r2, r1)
            goto L_0x00e3
        L_0x00d4:
            r2 = r27
            java.lang.Object r1 = r10.getObject(r14, r2)
            java.lang.Object r4 = r9.zzsf
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgy.zzb(r1, r4)
            r10.putObject(r14, r2, r1)
        L_0x00e3:
            r5 = r6 | r24
            r3 = r7
            r6 = r8
            goto L_0x02bc
        L_0x00e9:
            r13 = r0
            r11 = r2
            r5 = r18
            r1 = r27
            if (r7 != 0) goto L_0x010b
            int r7 = com.google.android.gms.internal.vision.zzfe.zzb(r12, r3, r9)
            long r3 = r9.zzse
            long r17 = com.google.android.gms.internal.vision.zzfy.zzr(r3)
            r0 = r10
            r2 = r1
            r1 = r33
            r35 = r8
            r8 = r5
            r4 = r17
            r0.putLong(r1, r2, r4)
            r5 = r6 | r24
            goto L_0x027e
        L_0x010b:
            r35 = r8
            r8 = r5
            goto L_0x0179
        L_0x0110:
            r13 = r0
            r11 = r2
            r35 = r8
            r8 = r18
            r0 = r27
            if (r7 != 0) goto L_0x0179
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r12, r3, r9)
            int r3 = r9.zzsd
            int r3 = com.google.android.gms.internal.vision.zzfy.zzav(r3)
            r10.putInt(r14, r0, r3)
            goto L_0x0172
        L_0x0128:
            r13 = r0
            r11 = r2
            r35 = r8
            r8 = r18
            r0 = r27
            if (r7 != 0) goto L_0x0179
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r12, r3, r9)
            int r3 = r9.zzsd
            com.google.android.gms.internal.vision.zzhd r4 = r15.zzbp(r11)
            if (r4 == 0) goto L_0x015a
            boolean r4 = r4.zzg(r3)
            if (r4 == 0) goto L_0x0145
            goto L_0x015a
        L_0x0145:
            com.google.android.gms.internal.vision.zzjr r0 = zzt(r33)
            long r3 = (long) r3
            java.lang.Long r1 = java.lang.Long.valueOf(r3)
            r0.zzb(r8, r1)
            r0 = r2
            r5 = r6
            r3 = r8
            r2 = r11
            r1 = r13
            r6 = r35
            goto L_0x02be
        L_0x015a:
            r10.putInt(r14, r0, r3)
            goto L_0x0172
        L_0x015e:
            r13 = r0
            r11 = r2
            r35 = r8
            r8 = r18
            r0 = r27
            r2 = 2
            if (r7 != r2) goto L_0x0179
            int r2 = com.google.android.gms.internal.vision.zzfe.zze(r12, r3, r9)
            java.lang.Object r3 = r9.zzsf
            r10.putObject(r14, r0, r3)
        L_0x0172:
            r5 = r6 | r24
            r6 = r35
            r0 = r2
            goto L_0x02bb
        L_0x0179:
            r23 = r6
            goto L_0x00a7
        L_0x017d:
            r13 = r0
            r11 = r2
            r35 = r8
            r8 = r18
            r0 = r27
            r2 = 2
            if (r7 != r2) goto L_0x01b8
            com.google.android.gms.internal.vision.zziw r2 = r15.zzbn(r11)
            r5 = r36
            r18 = 1048575(0xfffff, float:1.469367E-39)
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r2, r12, r3, r5, r9)
            r3 = r6 & r24
            if (r3 != 0) goto L_0x019f
            java.lang.Object r3 = r9.zzsf
            r10.putObject(r14, r0, r3)
            goto L_0x01ac
        L_0x019f:
            java.lang.Object r3 = r10.getObject(r14, r0)
            java.lang.Object r4 = r9.zzsf
            java.lang.Object r3 = com.google.android.gms.internal.vision.zzgy.zzb(r3, r4)
            r10.putObject(r14, r0, r3)
        L_0x01ac:
            r0 = r6 | r24
            r6 = r35
            r3 = r8
            r1 = r13
            r13 = r5
            r5 = r0
            r0 = r2
            r2 = r11
            goto L_0x02c0
        L_0x01b8:
            r5 = r36
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r23 = r6
            goto L_0x029c
        L_0x01c1:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
            r5 = r27
            r0 = 2
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029c
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r1
            if (r0 != 0) goto L_0x01db
            int r0 = com.google.android.gms.internal.vision.zzfe.zzc(r12, r3, r9)
            goto L_0x01df
        L_0x01db:
            int r0 = com.google.android.gms.internal.vision.zzfe.zzd(r12, r3, r9)
        L_0x01df:
            java.lang.Object r1 = r9.zzsf
            r10.putObject(r14, r5, r1)
            goto L_0x02b7
        L_0x01e6:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
            r5 = r27
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x029c
            int r0 = com.google.android.gms.internal.vision.zzfe.zzb(r12, r3, r9)
            long r1 = r9.zzse
            int r3 = (r1 > r20 ? 1 : (r1 == r20 ? 0 : -1))
            if (r3 == 0) goto L_0x0201
            r1 = 1
            goto L_0x0202
        L_0x0201:
            r1 = 0
        L_0x0202:
            com.google.android.gms.internal.vision.zzju.zza(r14, r5, r1)
            goto L_0x02b7
        L_0x0207:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
            r5 = r27
            r0 = 5
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029c
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r12, r3)
            r10.putInt(r14, r5, r0)
            goto L_0x0299
        L_0x0220:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
            r5 = r27
            r0 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029c
            long r20 = com.google.android.gms.internal.vision.zzfe.zzb(r12, r3)
            r0 = r10
            r1 = r33
            r7 = r3
            r2 = r5
            r4 = r20
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x02b7
        L_0x0242:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
            r5 = r27
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x029c
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r12, r3, r9)
            int r1 = r9.zzsd
            r10.putInt(r14, r5, r1)
            goto L_0x02b7
        L_0x025c:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
            r5 = r27
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != 0) goto L_0x029c
            int r7 = com.google.android.gms.internal.vision.zzfe.zzb(r12, r3, r9)
            long r2 = r9.zzse
            r0 = r10
            r1 = r33
            r20 = r2
            r2 = r5
            r4 = r20
            r0.putLong(r1, r2, r4)
            r5 = r23 | r24
        L_0x027e:
            r6 = r35
            r0 = r7
            goto L_0x02bb
        L_0x0282:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
            r5 = r27
            r0 = 5
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r0) goto L_0x029c
            float r0 = com.google.android.gms.internal.vision.zzfe.zzd(r12, r3)
            com.google.android.gms.internal.vision.zzju.zza(r14, r5, r0)
        L_0x0299:
            int r0 = r3 + 4
            goto L_0x02b7
        L_0x029c:
            r2 = 1
            goto L_0x02c4
        L_0x029e:
            r13 = r0
            r11 = r2
            r23 = r6
            r35 = r8
            r8 = r18
            r5 = r27
            r2 = 1
            r18 = 1048575(0xfffff, float:1.469367E-39)
            if (r7 != r2) goto L_0x02c4
            double r0 = com.google.android.gms.internal.vision.zzfe.zzc(r12, r3)
            com.google.android.gms.internal.vision.zzju.zza(r14, r5, r0)
            int r0 = r3 + 8
        L_0x02b7:
            r5 = r23 | r24
            r6 = r35
        L_0x02bb:
            r3 = r8
        L_0x02bc:
            r2 = r11
            r1 = r13
        L_0x02be:
            r13 = r36
        L_0x02c0:
            r11 = r37
            goto L_0x0019
        L_0x02c4:
            r6 = r35
            r15 = r37
            r2 = r3
            r7 = r8
            r31 = r10
            r25 = r11
            r26 = r13
            r18 = 1
            r24 = -1
            goto L_0x03da
        L_0x02d6:
            r23 = r5
            r22 = r6
            r5 = r13
            r8 = r18
            r18 = 1048575(0xfffff, float:1.469367E-39)
            r14 = r33
            r13 = r0
            r0 = r2
            r2 = 27
            if (r11 != r2) goto L_0x033b
            r2 = 2
            if (r7 != r2) goto L_0x032a
            java.lang.Object r1 = r10.getObject(r14, r5)
            com.google.android.gms.internal.vision.zzhe r1 = (com.google.android.gms.internal.vision.zzhe) r1
            boolean r2 = r1.zzdp()
            if (r2 != 0) goto L_0x0309
            int r2 = r1.size()
            if (r2 != 0) goto L_0x0300
            r2 = 10
            goto L_0x0302
        L_0x0300:
            int r2 = r2 << 1
        L_0x0302:
            com.google.android.gms.internal.vision.zzhe r1 = r1.zzah(r2)
            r10.putObject(r14, r5, r1)
        L_0x0309:
            r5 = r1
            com.google.android.gms.internal.vision.zziw r1 = r15.zzbn(r0)
            r25 = r0
            r0 = r1
            r1 = r8
            r2 = r34
            r4 = r36
            r6 = r38
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r1, r2, r3, r4, r5, r6)
            r11 = r37
            r3 = r8
            r1 = r13
            r6 = r22
            r5 = r23
            r2 = r25
            r13 = r36
            goto L_0x0019
        L_0x032a:
            r25 = r0
            r15 = r37
            r14 = r3
            r19 = r8
            r31 = r10
            r26 = r13
            r18 = 1
            r24 = -1
            goto L_0x03b7
        L_0x033b:
            r25 = r0
            r0 = 49
            if (r11 > r0) goto L_0x038b
            long r1 = (long) r1
            r0 = r32
            r26 = r1
            r1 = r33
            r24 = 1
            r2 = r34
            r35 = r3
            r4 = r36
            r29 = r5
            r5 = r8
            r6 = r13
            r19 = r8
            r18 = 1
            r24 = -1
            r8 = r25
            r31 = r10
            r9 = r26
            r15 = r37
            r26 = r13
            r12 = r29
            r14 = r38
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            r14 = r35
            if (r0 != r14) goto L_0x0372
            goto L_0x03d8
        L_0x0372:
            r14 = r33
            r12 = r34
            r13 = r36
            r9 = r38
            r11 = r15
            r3 = r19
            r6 = r22
            r5 = r23
            r2 = r25
            r1 = r26
            r10 = r31
            r15 = r32
            goto L_0x0019
        L_0x038b:
            r15 = r37
            r14 = r3
            r29 = r5
            r19 = r8
            r31 = r10
            r26 = r13
            r18 = 1
            r24 = -1
            r0 = 50
            if (r11 != r0) goto L_0x03bd
            r0 = 2
            if (r7 != r0) goto L_0x03b7
            r0 = r32
            r1 = r33
            r2 = r34
            r3 = r14
            r4 = r36
            r5 = r25
            r6 = r29
            r8 = r38
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r8)
            if (r0 != r14) goto L_0x0372
            goto L_0x03d8
        L_0x03b7:
            r2 = r14
        L_0x03b8:
            r7 = r19
            r6 = r22
            goto L_0x03da
        L_0x03bd:
            r0 = r32
            r8 = r1
            r1 = r33
            r2 = r34
            r3 = r14
            r4 = r36
            r5 = r19
            r6 = r26
            r9 = r11
            r10 = r29
            r12 = r25
            r13 = r38
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r14) goto L_0x06c8
        L_0x03d8:
            r2 = r0
            goto L_0x03b8
        L_0x03da:
            if (r7 != r15) goto L_0x03f0
            if (r15 != 0) goto L_0x03df
            goto L_0x03f0
        L_0x03df:
            r8 = r32
            r13 = r33
            r0 = r2
            r1 = r6
            r3 = r7
            r9 = r15
            r5 = r23
            r2 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r36
            goto L_0x06f3
        L_0x03f0:
            r8 = r32
            r9 = r15
            boolean r0 = r8.zzzo
            if (r0 == 0) goto L_0x069b
            r10 = r38
            com.google.android.gms.internal.vision.zzgi r0 = r10.zzcu
            com.google.android.gms.internal.vision.zzgi r1 = com.google.android.gms.internal.vision.zzgi.zzfm()
            if (r0 == r1) goto L_0x0696
            com.google.android.gms.internal.vision.zzih r0 = r8.zzzn
            com.google.android.gms.internal.vision.zzjo<?, ?> r1 = r8.zzzx
            com.google.android.gms.internal.vision.zzgi r3 = r10.zzcu
            r11 = r26
            com.google.android.gms.internal.vision.zzgx$zzg r12 = r3.zza(r0, r11)
            if (r12 != 0) goto L_0x0428
            com.google.android.gms.internal.vision.zzjr r4 = zzt(r33)
            r0 = r7
            r1 = r34
            r3 = r36
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r1, r2, r3, r4, r5)
            r13 = r33
            r15 = r34
            r35 = r6
            r6 = r36
            goto L_0x06b6
        L_0x0428:
            r13 = r33
            r0 = r13
            com.google.android.gms.internal.vision.zzgx$zze r0 = (com.google.android.gms.internal.vision.zzgx.zze) r0
            r0.zzgl()
            com.google.android.gms.internal.vision.zzgn<com.google.android.gms.internal.vision.zzgx$zzd> r14 = r0.zzwz
            com.google.android.gms.internal.vision.zzgx$zzd r3 = r12.zzxq
            boolean r3 = r3.zzwx
            if (r3 == 0) goto L_0x0512
            com.google.android.gms.internal.vision.zzgx$zzd r3 = r12.zzxq
            boolean r3 = r3.zzwy
            if (r3 == 0) goto L_0x0512
            int[] r3 = com.google.android.gms.internal.vision.zzfh.zzsg
            com.google.android.gms.internal.vision.zzgx$zzd r4 = r12.zzxq
            com.google.android.gms.internal.vision.zzkf r4 = r4.zzww
            int r4 = r4.ordinal()
            r3 = r3[r4]
            switch(r3) {
                case 1: goto L_0x0500;
                case 2: goto L_0x04f4;
                case 3: goto L_0x04e8;
                case 4: goto L_0x04e8;
                case 5: goto L_0x04dc;
                case 6: goto L_0x04dc;
                case 7: goto L_0x04d0;
                case 8: goto L_0x04d0;
                case 9: goto L_0x04c4;
                case 10: goto L_0x04c4;
                case 11: goto L_0x04b8;
                case 12: goto L_0x04ac;
                case 13: goto L_0x04a0;
                case 14: goto L_0x0476;
                default: goto L_0x044d;
            }
        L_0x044d:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            com.google.android.gms.internal.vision.zzgx$zzd r1 = r12.zzxq
            com.google.android.gms.internal.vision.zzkf r1 = r1.zzww
            java.lang.String r1 = java.lang.String.valueOf(r1)
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            int r2 = r2 + 23
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            java.lang.String r2 = "Type cannot be packed: "
            r3.append(r2)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r0.<init>(r1)
            throw r0
        L_0x0476:
            com.google.android.gms.internal.vision.zzgz r3 = new com.google.android.gms.internal.vision.zzgz
            r3.<init>()
            r15 = r34
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r15, r2, r3, r10)
            com.google.android.gms.internal.vision.zzjr r4 = r0.zzws
            com.google.android.gms.internal.vision.zzjr r5 = com.google.android.gms.internal.vision.zzjr.zzih()
            if (r4 != r5) goto L_0x048b
            r4 = r17
        L_0x048b:
            com.google.android.gms.internal.vision.zzgx$zzd r5 = r12.zzxq
            com.google.android.gms.internal.vision.zzha<?> r5 = r5.zzwv
            java.lang.Object r1 = com.google.android.gms.internal.vision.zziy.zza(r11, r3, r5, r4, r1)
            com.google.android.gms.internal.vision.zzjr r1 = (com.google.android.gms.internal.vision.zzjr) r1
            if (r1 == 0) goto L_0x0499
            r0.zzws = r1
        L_0x0499:
            com.google.android.gms.internal.vision.zzgx$zzd r0 = r12.zzxq
            r14.zza(r0, r3)
            goto L_0x053f
        L_0x04a0:
            r15 = r34
            com.google.android.gms.internal.vision.zzhv r0 = new com.google.android.gms.internal.vision.zzhv
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zzi(r15, r2, r0, r10)
            goto L_0x050b
        L_0x04ac:
            r15 = r34
            com.google.android.gms.internal.vision.zzgz r0 = new com.google.android.gms.internal.vision.zzgz
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zzh(r15, r2, r0, r10)
            goto L_0x050b
        L_0x04b8:
            r15 = r34
            com.google.android.gms.internal.vision.zzfk r0 = new com.google.android.gms.internal.vision.zzfk
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zzg(r15, r2, r0, r10)
            goto L_0x050b
        L_0x04c4:
            r15 = r34
            com.google.android.gms.internal.vision.zzgz r0 = new com.google.android.gms.internal.vision.zzgz
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zzc(r15, r2, r0, r10)
            goto L_0x050b
        L_0x04d0:
            r15 = r34
            com.google.android.gms.internal.vision.zzhv r0 = new com.google.android.gms.internal.vision.zzhv
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zzd(r15, r2, r0, r10)
            goto L_0x050b
        L_0x04dc:
            r15 = r34
            com.google.android.gms.internal.vision.zzgz r0 = new com.google.android.gms.internal.vision.zzgz
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zza(r15, r2, r0, r10)
            goto L_0x050b
        L_0x04e8:
            r15 = r34
            com.google.android.gms.internal.vision.zzhv r0 = new com.google.android.gms.internal.vision.zzhv
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zzb(r15, r2, r0, r10)
            goto L_0x050b
        L_0x04f4:
            r15 = r34
            com.google.android.gms.internal.vision.zzgt r0 = new com.google.android.gms.internal.vision.zzgt
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zze(r15, r2, r0, r10)
            goto L_0x050b
        L_0x0500:
            r15 = r34
            com.google.android.gms.internal.vision.zzgg r0 = new com.google.android.gms.internal.vision.zzgg
            r0.<init>()
            int r1 = com.google.android.gms.internal.vision.zzfe.zzf(r15, r2, r0, r10)
        L_0x050b:
            r2 = r1
            r35 = r6
            r6 = r36
            goto L_0x068f
        L_0x0512:
            r15 = r34
            com.google.android.gms.internal.vision.zzgx$zzd r3 = r12.zzxq
            com.google.android.gms.internal.vision.zzkf r3 = r3.zzww
            com.google.android.gms.internal.vision.zzkf r4 = com.google.android.gms.internal.vision.zzkf.ENUM
            if (r3 != r4) goto L_0x0553
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r15, r2, r10)
            com.google.android.gms.internal.vision.zzgx$zzd r3 = r12.zzxq
            com.google.android.gms.internal.vision.zzha<?> r3 = r3.zzwv
            int r4 = r10.zzsd
            com.google.android.gms.internal.vision.zzhb r3 = r3.zzh(r4)
            if (r3 != 0) goto L_0x0545
            com.google.android.gms.internal.vision.zzjr r3 = r0.zzws
            com.google.android.gms.internal.vision.zzjr r4 = com.google.android.gms.internal.vision.zzjr.zzih()
            if (r3 != r4) goto L_0x053a
            com.google.android.gms.internal.vision.zzjr r3 = com.google.android.gms.internal.vision.zzjr.zzii()
            r0.zzws = r3
        L_0x053a:
            int r0 = r10.zzsd
            com.google.android.gms.internal.vision.zziy.zza(r11, r0, r3, r1)
        L_0x053f:
            r35 = r6
            r6 = r36
            goto L_0x0694
        L_0x0545:
            int r0 = r10.zzsd
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            r35 = r6
            r0 = r17
            r6 = r36
            goto L_0x0662
        L_0x0553:
            int[] r0 = com.google.android.gms.internal.vision.zzfh.zzsg
            com.google.android.gms.internal.vision.zzgx$zzd r1 = r12.zzxq
            com.google.android.gms.internal.vision.zzkf r1 = r1.zzww
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0652;
                case 2: goto L_0x0642;
                case 3: goto L_0x0632;
                case 4: goto L_0x0632;
                case 5: goto L_0x0622;
                case 6: goto L_0x0622;
                case 7: goto L_0x0615;
                case 8: goto L_0x0615;
                case 9: goto L_0x0608;
                case 10: goto L_0x0608;
                case 11: goto L_0x05f1;
                case 12: goto L_0x05dd;
                case 13: goto L_0x05ca;
                case 14: goto L_0x05c2;
                case 15: goto L_0x05b6;
                case 16: goto L_0x05aa;
                case 17: goto L_0x0585;
                case 18: goto L_0x056a;
                default: goto L_0x0562;
            }
        L_0x0562:
            r35 = r6
            r6 = r36
        L_0x0566:
            r0 = r17
            goto L_0x0662
        L_0x056a:
            com.google.android.gms.internal.vision.zzis r0 = com.google.android.gms.internal.vision.zzis.zzhp()
            com.google.android.gms.internal.vision.zzih r1 = r12.zzxp
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zziw r0 = r0.zzf(r1)
            r5 = r36
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r0, r15, r2, r5, r10)
            java.lang.Object r0 = r10.zzsf
            r35 = r6
            r6 = r5
            goto L_0x0662
        L_0x0585:
            r5 = r36
            int r0 = r11 << 3
            r4 = r0 | 4
            com.google.android.gms.internal.vision.zzis r0 = com.google.android.gms.internal.vision.zzis.zzhp()
            com.google.android.gms.internal.vision.zzih r1 = r12.zzxp
            java.lang.Class r1 = r1.getClass()
            com.google.android.gms.internal.vision.zziw r0 = r0.zzf(r1)
            r1 = r34
            r3 = r36
            r35 = r6
            r6 = r5
            r5 = r38
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r0, r1, r2, r3, r4, r5)
            java.lang.Object r0 = r10.zzsf
            goto L_0x0662
        L_0x05aa:
            r35 = r6
            r6 = r36
            int r2 = com.google.android.gms.internal.vision.zzfe.zzc(r15, r2, r10)
            java.lang.Object r0 = r10.zzsf
            goto L_0x0662
        L_0x05b6:
            r35 = r6
            r6 = r36
            int r2 = com.google.android.gms.internal.vision.zzfe.zze(r15, r2, r10)
            java.lang.Object r0 = r10.zzsf
            goto L_0x0662
        L_0x05c2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "Shouldn't reach here."
            r0.<init>(r1)
            throw r0
        L_0x05ca:
            r35 = r6
            r6 = r36
            int r2 = com.google.android.gms.internal.vision.zzfe.zzb(r15, r2, r10)
            long r0 = r10.zzse
            long r0 = com.google.android.gms.internal.vision.zzfy.zzr(r0)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0566
        L_0x05dd:
            r35 = r6
            r6 = r36
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r15, r2, r10)
            int r0 = r10.zzsd
            int r0 = com.google.android.gms.internal.vision.zzfy.zzav(r0)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0566
        L_0x05f1:
            r35 = r6
            r6 = r36
            int r2 = com.google.android.gms.internal.vision.zzfe.zzb(r15, r2, r10)
            long r0 = r10.zzse
            int r3 = (r0 > r20 ? 1 : (r0 == r20 ? 0 : -1))
            if (r3 == 0) goto L_0x0600
            goto L_0x0602
        L_0x0600:
            r18 = 0
        L_0x0602:
            java.lang.Boolean r17 = java.lang.Boolean.valueOf(r18)
            goto L_0x0566
        L_0x0608:
            r35 = r6
            r6 = r36
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r15, r2)
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x064e
        L_0x0615:
            r35 = r6
            r6 = r36
            long r0 = com.google.android.gms.internal.vision.zzfe.zzb(r15, r2)
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x065e
        L_0x0622:
            r35 = r6
            r6 = r36
            int r2 = com.google.android.gms.internal.vision.zzfe.zza(r15, r2, r10)
            int r0 = r10.zzsd
            java.lang.Integer r17 = java.lang.Integer.valueOf(r0)
            goto L_0x0566
        L_0x0632:
            r35 = r6
            r6 = r36
            int r2 = com.google.android.gms.internal.vision.zzfe.zzb(r15, r2, r10)
            long r0 = r10.zzse
            java.lang.Long r17 = java.lang.Long.valueOf(r0)
            goto L_0x0566
        L_0x0642:
            r35 = r6
            r6 = r36
            float r0 = com.google.android.gms.internal.vision.zzfe.zzd(r15, r2)
            java.lang.Float r17 = java.lang.Float.valueOf(r0)
        L_0x064e:
            int r2 = r2 + 4
            goto L_0x0566
        L_0x0652:
            r35 = r6
            r6 = r36
            double r0 = com.google.android.gms.internal.vision.zzfe.zzc(r15, r2)
            java.lang.Double r17 = java.lang.Double.valueOf(r0)
        L_0x065e:
            int r2 = r2 + 8
            goto L_0x0566
        L_0x0662:
            com.google.android.gms.internal.vision.zzgx$zzd r1 = r12.zzxq
            boolean r1 = r1.zzwx
            if (r1 == 0) goto L_0x066e
            com.google.android.gms.internal.vision.zzgx$zzd r1 = r12.zzxq
            r14.zzb(r1, r0)
            goto L_0x0694
        L_0x066e:
            int[] r1 = com.google.android.gms.internal.vision.zzfh.zzsg
            com.google.android.gms.internal.vision.zzgx$zzd r3 = r12.zzxq
            com.google.android.gms.internal.vision.zzkf r3 = r3.zzww
            int r3 = r3.ordinal()
            r1 = r1[r3]
            r3 = 17
            if (r1 == r3) goto L_0x0683
            r3 = 18
            if (r1 == r3) goto L_0x0683
            goto L_0x068f
        L_0x0683:
            com.google.android.gms.internal.vision.zzgx$zzd r1 = r12.zzxq
            java.lang.Object r1 = r14.zza(r1)
            if (r1 == 0) goto L_0x068f
            java.lang.Object r0 = com.google.android.gms.internal.vision.zzgy.zzb(r1, r0)
        L_0x068f:
            com.google.android.gms.internal.vision.zzgx$zzd r1 = r12.zzxq
            r14.zza(r1, r0)
        L_0x0694:
            r0 = r2
            goto L_0x06b6
        L_0x0696:
            r13 = r33
            r15 = r34
            goto L_0x06a1
        L_0x069b:
            r13 = r33
            r15 = r34
            r10 = r38
        L_0x06a1:
            r35 = r6
            r11 = r26
            r6 = r36
            com.google.android.gms.internal.vision.zzjr r4 = zzt(r33)
            r0 = r7
            r1 = r34
            r3 = r36
            r5 = r38
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r1, r2, r3, r4, r5)
        L_0x06b6:
            r3 = r7
            r1 = r11
            r14 = r13
            r12 = r15
            r5 = r23
            r2 = r25
            r13 = r6
            r15 = r8
            r11 = r9
            r9 = r10
            r10 = r31
            r6 = r35
            goto L_0x0019
        L_0x06c8:
            r9 = r15
            r7 = r19
            r11 = r26
            r15 = r32
            r14 = r33
            r12 = r34
            r13 = r36
            r3 = r7
            r1 = r11
            r6 = r22
            r5 = r23
            r2 = r25
            r10 = r31
            r11 = r9
            r9 = r38
            goto L_0x0019
        L_0x06e4:
            r23 = r5
            r22 = r6
            r31 = r10
            r9 = r11
            r6 = r13
            r13 = r14
            r8 = r15
            r1 = r22
            r2 = 1048575(0xfffff, float:1.469367E-39)
        L_0x06f3:
            if (r1 == r2) goto L_0x06fb
            long r1 = (long) r1
            r4 = r31
            r4.putInt(r13, r1, r5)
        L_0x06fb:
            int r1 = r8.zzzt
            r2 = r17
        L_0x06ff:
            int r4 = r8.zzzu
            if (r1 >= r4) goto L_0x0712
            int[] r4 = r8.zzzs
            r4 = r4[r1]
            com.google.android.gms.internal.vision.zzjo<?, ?> r5 = r8.zzzx
            java.lang.Object r2 = r8.zza(r13, r4, r2, r5)
            com.google.android.gms.internal.vision.zzjr r2 = (com.google.android.gms.internal.vision.zzjr) r2
            int r1 = r1 + 1
            goto L_0x06ff
        L_0x0712:
            if (r2 == 0) goto L_0x0719
            com.google.android.gms.internal.vision.zzjo<?, ?> r1 = r8.zzzx
            r1.zzg(r13, r2)
        L_0x0719:
            if (r9 != 0) goto L_0x0723
            if (r0 != r6) goto L_0x071e
            goto L_0x0727
        L_0x071e:
            com.google.android.gms.internal.vision.zzhh r0 = com.google.android.gms.internal.vision.zzhh.zzgt()
            throw r0
        L_0x0723:
            if (r0 > r6) goto L_0x0728
            if (r3 != r9) goto L_0x0728
        L_0x0727:
            return r0
        L_0x0728:
            com.google.android.gms.internal.vision.zzhh r0 = com.google.android.gms.internal.vision.zzhh.zzgt()
            throw r0
            switch-data {0->0x029e, 1->0x0282, 2->0x025c, 3->0x025c, 4->0x0242, 5->0x0220, 6->0x0207, 7->0x01e6, 8->0x01c1, 9->0x017d, 10->0x015e, 11->0x0242, 12->0x0128, 13->0x0207, 14->0x0220, 15->0x0110, 16->0x00e9, 17->0x00ad, }
            switch-data {1->0x0500, 2->0x04f4, 3->0x04e8, 4->0x04e8, 5->0x04dc, 6->0x04dc, 7->0x04d0, 8->0x04d0, 9->0x04c4, 10->0x04c4, 11->0x04b8, 12->0x04ac, 13->0x04a0, 14->0x0476, }
            switch-data {1->0x0652, 2->0x0642, 3->0x0632, 4->0x0632, 5->0x0622, 6->0x0622, 7->0x0615, 8->0x0615, 9->0x0608, 10->0x0608, 11->0x05f1, 12->0x05dd, 13->0x05ca, 14->0x05c2, 15->0x05b6, 16->0x05aa, 17->0x0585, 18->0x056a, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzil.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.vision.zzfg):int");
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
    @Override // com.google.android.gms.internal.vision.zziw
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r31, byte[] r32, int r33, int r34, com.google.android.gms.internal.vision.zzfg r35) throws java.io.IOException {
        /*
            r30 = this;
            r15 = r30
            r14 = r31
            r12 = r32
            r13 = r34
            r11 = r35
            boolean r0 = r15.zzzq
            if (r0 == 0) goto L_0x038d
            sun.misc.Unsafe r9 = com.google.android.gms.internal.vision.zzil.zzzi
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
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r12, r3, r11)
            int r3 = r11.zzsd
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
            int r0 = r15.zzt(r5, r2)
            goto L_0x0044
        L_0x0040:
            int r0 = r15.zzbt(r5)
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
            int[] r0 = r15.zzzj
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
            int r10 = com.google.android.gms.internal.vision.zzfe.zzb(r12, r4, r11)
            long r0 = r11.zzse
            long r17 = com.google.android.gms.internal.vision.zzfy.zzr(r0)
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
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r12, r4, r11)
            int r1 = r11.zzsd
            int r1 = com.google.android.gms.internal.vision.zzfy.zzav(r1)
            r7.putInt(r14, r8, r1)
            goto L_0x0234
        L_0x00f5:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r12, r4, r11)
            int r1 = r11.zzsd
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
            int r0 = com.google.android.gms.internal.vision.zzfe.zze(r12, r4, r11)
            java.lang.Object r1 = r11.zzsf
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
            com.google.android.gms.internal.vision.zziw r0 = r15.zzbn(r10)
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r12, r4, r13, r11)
            java.lang.Object r1 = r7.getObject(r14, r8)
            if (r1 != 0) goto L_0x0146
            java.lang.Object r1 = r11.zzsf
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0146:
            java.lang.Object r2 = r11.zzsf
            java.lang.Object r1 = com.google.android.gms.internal.vision.zzgy.zzb(r1, r2)
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
            int r0 = com.google.android.gms.internal.vision.zzfe.zzc(r12, r4, r11)
            goto L_0x016d
        L_0x0169:
            int r0 = com.google.android.gms.internal.vision.zzfe.zzd(r12, r4, r11)
        L_0x016d:
            java.lang.Object r1 = r11.zzsf
            r7.putObject(r14, r8, r1)
            goto L_0x0234
        L_0x0174:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != 0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.vision.zzfe.zzb(r12, r4, r11)
            long r1 = r11.zzse
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x018e
            r1 = 1
            goto L_0x018f
        L_0x018e:
            r1 = 0
        L_0x018f:
            com.google.android.gms.internal.vision.zzju.zza(r14, r8, r1)
            goto L_0x0234
        L_0x0194:
            r25 = r33
            r10 = r20
            r26 = 1048575(0xfffff, float:1.469367E-39)
            r20 = r7
            r7 = r2
            if (r3 != r0) goto L_0x01ca
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r12, r4)
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
            long r17 = com.google.android.gms.internal.vision.zzfe.zzb(r12, r4)
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
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r12, r5, r11)
            int r1 = r11.zzsd
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
            int r17 = com.google.android.gms.internal.vision.zzfe.zzb(r12, r5, r11)
            long r4 = r11.zzse
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
            float r0 = com.google.android.gms.internal.vision.zzfe.zzd(r12, r5)
            com.google.android.gms.internal.vision.zzju.zza(r14, r8, r0)
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
            double r0 = com.google.android.gms.internal.vision.zzfe.zzc(r12, r5)
            com.google.android.gms.internal.vision.zzju.zza(r14, r8, r0)
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
            com.google.android.gms.internal.vision.zzhe r0 = (com.google.android.gms.internal.vision.zzhe) r0
            boolean r1 = r0.zzdp()
            if (r1 != 0) goto L_0x0272
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0269
            r1 = 10
            goto L_0x026b
        L_0x0269:
            int r1 = r1 << 1
        L_0x026b:
            com.google.android.gms.internal.vision.zzhe r0 = r0.zzah(r1)
            r7.putObject(r14, r8, r0)
        L_0x0272:
            r8 = r0
            com.google.android.gms.internal.vision.zziw r0 = r15.zzbn(r4)
            r1 = r17
            r2 = r32
            r3 = r5
            r18 = r4
            r4 = r34
            r5 = r8
            r8 = r6
            r6 = r35
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r1, r2, r3, r4, r5, r6)
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
            com.google.android.gms.internal.vision.zzjr r4 = zzt(r31)
            r0 = r17
            r1 = r32
            r3 = r34
            r5 = r35
            int r0 = com.google.android.gms.internal.vision.zzfe.zza(r0, r1, r2, r3, r4, r5)
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
            com.google.android.gms.internal.vision.zzhh r0 = com.google.android.gms.internal.vision.zzhh.zzgt()
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzil.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.vision.zzfg):void");
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final void zzh(T t) {
        int i;
        int i2 = this.zzzt;
        while (true) {
            i = this.zzzu;
            if (i2 >= i) {
                break;
            }
            long zzbq = (long) (zzbq(this.zzzs[i2]) & 1048575);
            Object zzp = zzju.zzp(t, zzbq);
            if (zzp != null) {
                zzju.zza(t, zzbq, this.zzzz.zzo(zzp));
            }
            i2++;
        }
        int length = this.zzzs.length;
        while (i < length) {
            this.zzzw.zzb(t, (long) this.zzzs[i]);
            i++;
        }
        this.zzzx.zzh(t);
        if (this.zzzo) {
            this.zzzy.zzh(t);
        }
    }

    private final <UT, UB> UB zza(Object obj, int i, UB ub, zzjo<UT, UB> zzjo) {
        zzhd zzbp;
        int i2 = this.zzzj[i];
        Object zzp = zzju.zzp(obj, (long) (zzbq(i) & 1048575));
        if (zzp == null || (zzbp = zzbp(i)) == null) {
            return ub;
        }
        return zza(i, i2, this.zzzz.zzl(zzp), zzbp, ub, zzjo);
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzhd zzhd, UB ub, zzjo<UT, UB> zzjo) {
        zzhy<?, ?> zzq = this.zzzz.zzq(zzbo(i));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            if (!zzhd.zzg(next.getValue().intValue())) {
                if (ub == null) {
                    ub = zzjo.zzig();
                }
                zzfu zzaq = zzfm.zzaq(zzhz.zza(zzq, next.getKey(), next.getValue()));
                try {
                    zzhz.zza(zzaq.zzex(), zzq, next.getKey(), next.getValue());
                    zzjo.zza(ub, i2, zzaq.zzew());
                    it2.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    @Override // com.google.android.gms.internal.vision.zziw
    public final boolean zzu(T t) {
        int i;
        int i2;
        int i3 = 1048575;
        int i4 = 0;
        int i5 = 0;
        while (true) {
            boolean z = true;
            if (i5 >= this.zzzt) {
                return !this.zzzo || this.zzzy.zzf(t).isInitialized();
            }
            int i6 = this.zzzs[i5];
            int i7 = this.zzzj[i6];
            int zzbq = zzbq(i6);
            int i8 = this.zzzj[i6 + 2];
            int i9 = i8 & 1048575;
            int i10 = 1 << (i8 >>> 20);
            if (i9 != i3) {
                if (i9 != 1048575) {
                    i4 = zzzi.getInt(t, (long) i9);
                }
                i = i4;
                i2 = i9;
            } else {
                i2 = i3;
                i = i4;
            }
            if (((268435456 & zzbq) != 0) && !zza(t, i6, i2, i, i10)) {
                return false;
            }
            int i11 = (267386880 & zzbq) >>> 20;
            if (i11 != 9 && i11 != 17) {
                if (i11 != 27) {
                    if (i11 == 60 || i11 == 68) {
                        if (zza(t, i7, i6) && !zza(t, zzbq, zzbn(i6))) {
                            return false;
                        }
                    } else if (i11 != 49) {
                        if (i11 != 50) {
                            continue;
                        } else {
                            Map<?, ?> zzm = this.zzzz.zzm(zzju.zzp(t, (long) (zzbq & 1048575)));
                            if (!zzm.isEmpty()) {
                                if (this.zzzz.zzq(zzbo(i6)).zzzd.zziq() == zzki.MESSAGE) {
                                    zziw<T> zziw = null;
                                    Iterator<?> it2 = zzm.values().iterator();
                                    while (true) {
                                        if (!it2.hasNext()) {
                                            break;
                                        }
                                        Object next = it2.next();
                                        if (zziw == null) {
                                            zziw = zzis.zzhp().zzf(next.getClass());
                                        }
                                        if (!zziw.zzu(next)) {
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
                List list = (List) zzju.zzp(t, (long) (zzbq & 1048575));
                if (!list.isEmpty()) {
                    zziw zzbn = zzbn(i6);
                    int i12 = 0;
                    while (true) {
                        if (i12 >= list.size()) {
                            break;
                        } else if (!zzbn.zzu(list.get(i12))) {
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
            } else if (zza(t, i6, i2, i, i10) && !zza(t, zzbq, zzbn(i6))) {
                return false;
            }
            i5++;
            i3 = i2;
            i4 = i;
        }
    }

    private static boolean zza(Object obj, int i, zziw zziw) {
        return zziw.zzu(zzju.zzp(obj, (long) (i & 1048575)));
    }

    private static void zza(int i, Object obj, zzkl zzkl) throws IOException {
        if (obj instanceof String) {
            zzkl.zza(i, (String) obj);
        } else {
            zzkl.zza(i, (zzfm) obj);
        }
    }

    private final void zza(Object obj, int i, zzix zzix) throws IOException {
        if (zzbs(i)) {
            zzju.zza(obj, (long) (i & 1048575), zzix.zzed());
        } else if (this.zzzp) {
            zzju.zza(obj, (long) (i & 1048575), zzix.readString());
        } else {
            zzju.zza(obj, (long) (i & 1048575), zzix.zzee());
        }
    }

    private final int zzbq(int i) {
        return this.zzzj[i + 1];
    }

    private final int zzbr(int i) {
        return this.zzzj[i + 2];
    }

    private static <T> double zzf(T t, long j) {
        return ((Double) zzju.zzp(t, j)).doubleValue();
    }

    private static <T> float zzg(T t, long j) {
        return ((Float) zzju.zzp(t, j)).floatValue();
    }

    private static <T> int zzh(T t, long j) {
        return ((Integer) zzju.zzp(t, j)).intValue();
    }

    private static <T> long zzi(T t, long j) {
        return ((Long) zzju.zzp(t, j)).longValue();
    }

    private static <T> boolean zzj(T t, long j) {
        return ((Boolean) zzju.zzp(t, j)).booleanValue();
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private final boolean zza(T t, int i, int i2, int i3, int i4) {
        if (i2 == 1048575) {
            return zza(t, i);
        }
        return (i3 & i4) != 0;
    }

    private final boolean zza(T t, int i) {
        int zzbr = zzbr(i);
        long j = (long) (zzbr & 1048575);
        if (j == 1048575) {
            int zzbq = zzbq(i);
            long j2 = (long) (zzbq & 1048575);
            switch ((zzbq & 267386880) >>> 20) {
                case 0:
                    return zzju.zzo(t, j2) != 0.0d;
                case 1:
                    return zzju.zzn(t, j2) != 0.0f;
                case 2:
                    return zzju.zzl(t, j2) != 0;
                case 3:
                    return zzju.zzl(t, j2) != 0;
                case 4:
                    return zzju.zzk(t, j2) != 0;
                case 5:
                    return zzju.zzl(t, j2) != 0;
                case 6:
                    return zzju.zzk(t, j2) != 0;
                case 7:
                    return zzju.zzm(t, j2);
                case 8:
                    Object zzp = zzju.zzp(t, j2);
                    if (zzp instanceof String) {
                        return !((String) zzp).isEmpty();
                    }
                    if (zzp instanceof zzfm) {
                        return !zzfm.zzsm.equals(zzp);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzju.zzp(t, j2) != null;
                case 10:
                    return !zzfm.zzsm.equals(zzju.zzp(t, j2));
                case 11:
                    return zzju.zzk(t, j2) != 0;
                case 12:
                    return zzju.zzk(t, j2) != 0;
                case 13:
                    return zzju.zzk(t, j2) != 0;
                case 14:
                    return zzju.zzl(t, j2) != 0;
                case 15:
                    return zzju.zzk(t, j2) != 0;
                case 16:
                    return zzju.zzl(t, j2) != 0;
                case 17:
                    return zzju.zzp(t, j2) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            return (zzju.zzk(t, j) & (1 << (zzbr >>> 20))) != 0;
        }
    }

    private final void zzb(T t, int i) {
        int zzbr = zzbr(i);
        long j = (long) (1048575 & zzbr);
        if (j != 1048575) {
            zzju.zzb(t, j, (1 << (zzbr >>> 20)) | zzju.zzk(t, j));
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzju.zzk(t, (long) (zzbr(i2) & 1048575)) == i;
    }

    private final void zzb(T t, int i, int i2) {
        zzju.zzb(t, (long) (zzbr(i2) & 1048575), i);
    }

    private final int zzbt(int i) {
        if (i < this.zzzl || i > this.zzzm) {
            return -1;
        }
        return zzu(i, 0);
    }

    private final int zzt(int i, int i2) {
        if (i < this.zzzl || i > this.zzzm) {
            return -1;
        }
        return zzu(i, i2);
    }

    private final int zzu(int i, int i2) {
        int length = (this.zzzj.length / 3) - 1;
        while (i2 <= length) {
            int i3 = (length + i2) >>> 1;
            int i4 = i3 * 3;
            int i5 = this.zzzj[i4];
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
