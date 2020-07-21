package com.google.android.gms.internal.clearcut;

import com.google.android.gms.internal.clearcut.zzcg;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import sun.misc.Unsafe;

final class zzds<T> implements zzef<T> {
    private static final Unsafe zzmh = zzfd.zzef();
    private final int[] zzmi;
    private final Object[] zzmj;
    private final int zzmk;
    private final int zzml;
    private final int zzmm;
    private final zzdo zzmn;
    private final boolean zzmo;
    private final boolean zzmp;
    private final boolean zzmq;
    private final boolean zzmr;
    private final int[] zzms;
    private final int[] zzmt;
    private final int[] zzmu;
    private final zzdw zzmv;
    private final zzcy zzmw;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;
    private final zzdj zzmz;

    private zzds(int[] iArr, Object[] objArr, int i, int i2, int i3, zzdo zzdo, boolean z, boolean z2, int[] iArr2, int[] iArr3, int[] iArr4, zzdw zzdw, zzcy zzcy, zzex<?, ?> zzex, zzbu<?> zzbu, zzdj zzdj) {
        this.zzmi = iArr;
        this.zzmj = objArr;
        this.zzmk = i;
        this.zzml = i2;
        this.zzmm = i3;
        this.zzmp = zzdo instanceof zzcg;
        this.zzmq = z;
        this.zzmo = zzbu != null && zzbu.zze(zzdo);
        this.zzmr = false;
        this.zzms = iArr2;
        this.zzmt = iArr3;
        this.zzmu = iArr4;
        this.zzmv = zzdw;
        this.zzmw = zzcy;
        this.zzmx = zzex;
        this.zzmy = zzbu;
        this.zzmn = zzdo;
        this.zzmz = zzdj;
    }

    private static int zza(int i, byte[] bArr, int i2, int i3, Object obj, zzay zzay) throws IOException {
        return zzax.zza(i, bArr, i2, i3, zzn(obj), zzay);
    }

    private static int zza(zzef<?> zzef, int i, byte[] bArr, int i2, int i3, zzcn<?> zzcn, zzay zzay) throws IOException {
        int zza = zza((zzef) zzef, bArr, i2, i3, zzay);
        while (true) {
            zzcn.add(zzay.zzff);
            if (zza >= i3) {
                break;
            }
            int zza2 = zzax.zza(bArr, zza, zzay);
            if (i != zzay.zzfd) {
                break;
            }
            zza = zza((zzef) zzef, bArr, zza2, i3, zzay);
        }
        return zza;
    }

    private static int zza(zzef zzef, byte[] bArr, int i, int i2, int i3, zzay zzay) throws IOException {
        zzds zzds = (zzds) zzef;
        T newInstance = zzds.newInstance();
        int zza = zzds.zza((Object) newInstance, bArr, i, i2, i3, zzay);
        zzds.zzc(newInstance);
        zzay.zzff = newInstance;
        return zza;
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    private static int zza(zzef zzef, byte[] bArr, int i, int i2, zzay zzay) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zzax.zza(b, bArr, i3, zzay);
            b2 = zzay.zzfd;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzco.zzbl();
        }
        T newInstance = zzef.newInstance();
        int i4 = b2 + i3;
        zzef.zza(newInstance, bArr, i3, i4, zzay);
        zzef.zzc(newInstance);
        zzay.zzff = newInstance;
        return i4;
    }

    private static <UT, UB> int zza(zzex<UT, UB> zzex, T t) {
        return zzex.zzm(zzex.zzq(t));
    }

    private final int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, long j, int i8, zzay zzay) throws IOException {
        int i9;
        Object obj;
        Object obj2;
        Object obj3;
        long j2;
        int zzb;
        int i10;
        int i11;
        Unsafe unsafe = zzmh;
        long j3 = (long) (this.zzmi[i8 + 2] & 1048575);
        switch (i7) {
            case 51:
                if (i5 == 1) {
                    obj = Double.valueOf(zzax.zze(bArr, i));
                    unsafe.putObject(t, j, obj);
                    i9 = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 52:
                if (i5 == 5) {
                    obj2 = Float.valueOf(zzax.zzf(bArr, i));
                    unsafe.putObject(t, j, obj2);
                    i9 = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 53:
            case 54:
                if (i5 == 0) {
                    zzb = zzax.zzb(bArr, i, zzay);
                    j2 = zzay.zzfe;
                    obj3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 55:
            case 62:
                if (i5 == 0) {
                    i9 = zzax.zza(bArr, i, zzay);
                    i10 = zzay.zzfd;
                    obj3 = Integer.valueOf(i10);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 56:
            case 65:
                if (i5 == 1) {
                    obj = Long.valueOf(zzax.zzd(bArr, i));
                    unsafe.putObject(t, j, obj);
                    i9 = i + 8;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 57:
            case 64:
                if (i5 == 5) {
                    obj2 = Integer.valueOf(zzax.zzc(bArr, i));
                    unsafe.putObject(t, j, obj2);
                    i9 = i + 4;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 58:
                if (i5 == 0) {
                    i9 = zzax.zzb(bArr, i, zzay);
                    obj3 = Boolean.valueOf(zzay.zzfe != 0);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 59:
                if (i5 == 2) {
                    i9 = zzax.zza(bArr, i, zzay);
                    i11 = zzay.zzfd;
                    if (i11 == 0) {
                        obj3 = "";
                        unsafe.putObject(t, j, obj3);
                        unsafe.putInt(t, j3, i4);
                        return i9;
                    } else if ((i6 & 536870912) == 0 || zzff.zze(bArr, i9, i9 + i11)) {
                        unsafe.putObject(t, j, new String(bArr, i9, i11, zzci.UTF_8));
                        i9 += i11;
                        unsafe.putInt(t, j3, i4);
                        return i9;
                    } else {
                        throw zzco.zzbp();
                    }
                }
                return i;
            case 60:
                if (i5 == 2) {
                    i9 = zza(zzad(i8), bArr, i, i2, zzay);
                    Object object = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    obj3 = zzay.zzff;
                    if (object != null) {
                        obj3 = zzci.zza(object, obj3);
                    }
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 61:
                if (i5 == 2) {
                    i9 = zzax.zza(bArr, i, zzay);
                    i11 = zzay.zzfd;
                    if (i11 == 0) {
                        obj3 = zzbb.zzfi;
                        unsafe.putObject(t, j, obj3);
                        unsafe.putInt(t, j3, i4);
                        return i9;
                    }
                    unsafe.putObject(t, j, zzbb.zzb(bArr, i9, i11));
                    i9 += i11;
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 63:
                if (i5 == 0) {
                    int zza = zzax.zza(bArr, i, zzay);
                    int i12 = zzay.zzfd;
                    zzck<?> zzaf = zzaf(i8);
                    if (zzaf == null || zzaf.zzb(i12) != null) {
                        unsafe.putObject(t, j, Integer.valueOf(i12));
                        i9 = zza;
                        unsafe.putInt(t, j3, i4);
                        return i9;
                    }
                    zzn(t).zzb(i3, Long.valueOf((long) i12));
                    return zza;
                }
                return i;
            case 66:
                if (i5 == 0) {
                    i9 = zzax.zza(bArr, i, zzay);
                    i10 = zzbk.zzm(zzay.zzfd);
                    obj3 = Integer.valueOf(i10);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 67:
                if (i5 == 0) {
                    zzb = zzax.zzb(bArr, i, zzay);
                    j2 = zzbk.zza(zzay.zzfe);
                    obj3 = Long.valueOf(j2);
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            case 68:
                if (i5 == 3) {
                    i9 = zza(zzad(i8), bArr, i, i2, (i3 & -8) | 4, zzay);
                    Object object2 = unsafe.getInt(t, j3) == i4 ? unsafe.getObject(t, j) : null;
                    obj3 = zzay.zzff;
                    if (object2 != null) {
                        obj3 = zzci.zza(object2, obj3);
                    }
                    unsafe.putObject(t, j, obj3);
                    unsafe.putInt(t, j3, i4);
                    return i9;
                }
                return i;
            default:
                return i;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0232, code lost:
        if (r30.zzfe != 0) goto L_0x0234;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0234, code lost:
        r6 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x0236, code lost:
        r6 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0237, code lost:
        r11.addBoolean(r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x023a, code lost:
        if (r4 >= r20) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x023c, code lost:
        r6 = com.google.android.gms.internal.clearcut.zzax.zza(r18, r4, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0242, code lost:
        if (r21 != r30.zzfd) goto L_0x039b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0244, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzax.zzb(r18, r6, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x024c, code lost:
        if (r30.zzfe == 0) goto L_0x0236;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:?, code lost:
        return r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x013a, code lost:
        if (r4 == 0) goto L_0x013c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x013c, code lost:
        r11.add(com.google.android.gms.internal.clearcut.zzbb.zzfi);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0142, code lost:
        r11.add(com.google.android.gms.internal.clearcut.zzbb.zzb(r18, r1, r4));
        r1 = r1 + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x014a, code lost:
        if (r1 >= r20) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x014c, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzax.zza(r18, r1, r30);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0152, code lost:
        if (r21 != r30.zzfd) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0154, code lost:
        r1 = com.google.android.gms.internal.clearcut.zzax.zza(r18, r4, r30);
        r4 = r30.zzfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x015a, code lost:
        if (r4 != 0) goto L_0x0142;
     */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x019d  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r17, byte[] r18, int r19, int r20, int r21, int r22, int r23, int r24, long r25, int r27, long r28, com.google.android.gms.internal.clearcut.zzay r30) throws java.io.IOException {
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
            sun.misc.Unsafe r11 = com.google.android.gms.internal.clearcut.zzds.zzmh
            java.lang.Object r11 = r11.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.zzcn r11 = (com.google.android.gms.internal.clearcut.zzcn) r11
            boolean r12 = r11.zzu()
            r13 = 1
            if (r12 != 0) goto L_0x0036
            int r12 = r11.size()
            if (r12 != 0) goto L_0x002c
            r12 = 10
            goto L_0x002d
        L_0x002c:
            int r12 = r12 << r13
        L_0x002d:
            com.google.android.gms.internal.clearcut.zzcn r11 = r11.zzi(r12)
            sun.misc.Unsafe r12 = com.google.android.gms.internal.clearcut.zzds.zzmh
            r12.putObject(r1, r9, r11)
        L_0x0036:
            r9 = 5
            r14 = 0
            r10 = 2
            switch(r27) {
                case 18: goto L_0x035d;
                case 19: goto L_0x031f;
                case 20: goto L_0x02e7;
                case 21: goto L_0x02e7;
                case 22: goto L_0x02cd;
                case 23: goto L_0x028e;
                case 24: goto L_0x024f;
                case 25: goto L_0x01fe;
                case 26: goto L_0x0177;
                case 27: goto L_0x015d;
                case 28: goto L_0x0132;
                case 29: goto L_0x02cd;
                case 30: goto L_0x00fa;
                case 31: goto L_0x024f;
                case 32: goto L_0x028e;
                case 33: goto L_0x00ba;
                case 34: goto L_0x007a;
                case 35: goto L_0x035d;
                case 36: goto L_0x031f;
                case 37: goto L_0x02e7;
                case 38: goto L_0x02e7;
                case 39: goto L_0x02cd;
                case 40: goto L_0x028e;
                case 41: goto L_0x024f;
                case 42: goto L_0x01fe;
                case 43: goto L_0x02cd;
                case 44: goto L_0x00fa;
                case 45: goto L_0x024f;
                case 46: goto L_0x028e;
                case 47: goto L_0x00ba;
                case 48: goto L_0x007a;
                case 49: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x039b
        L_0x003f:
            r1 = 3
            if (r6 != r1) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzef r1 = r0.zzad(r8)
            r6 = r2 & -8
            r6 = r6 | 4
            r22 = r1
            r23 = r18
            r24 = r19
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = zza(r22, r23, r24, r25, r26, r27)
        L_0x005a:
            java.lang.Object r8 = r7.zzff
            r11.add(r8)
            if (r4 >= r5) goto L_0x039b
            int r8 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r9 = r7.zzfd
            if (r2 != r9) goto L_0x039b
            r22 = r1
            r23 = r18
            r24 = r8
            r25 = r20
            r26 = r6
            r27 = r30
            int r4 = zza(r22, r23, r24, r25, r26, r27)
            goto L_0x005a
        L_0x007a:
            if (r6 != r10) goto L_0x009e
            com.google.android.gms.internal.clearcut.zzdc r11 = (com.google.android.gms.internal.clearcut.zzdc) r11
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x0085:
            if (r1 >= r2) goto L_0x0095
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r1, r7)
            long r4 = r7.zzfe
            long r4 = com.google.android.gms.internal.clearcut.zzbk.zza(r4)
            r11.zzm(r4)
            goto L_0x0085
        L_0x0095:
            if (r1 != r2) goto L_0x0099
            goto L_0x039c
        L_0x0099:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x009e:
            if (r6 != 0) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzdc r11 = (com.google.android.gms.internal.clearcut.zzdc) r11
        L_0x00a2:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r7)
            long r8 = r7.zzfe
            long r8 = com.google.android.gms.internal.clearcut.zzbk.zza(r8)
            r11.zzm(r8)
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039c
            goto L_0x00a2
        L_0x00ba:
            if (r6 != r10) goto L_0x00de
            com.google.android.gms.internal.clearcut.zzch r11 = (com.google.android.gms.internal.clearcut.zzch) r11
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x00c5:
            if (r1 >= r2) goto L_0x00d5
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r4 = r7.zzfd
            int r4 = com.google.android.gms.internal.clearcut.zzbk.zzm(r4)
            r11.zzac(r4)
            goto L_0x00c5
        L_0x00d5:
            if (r1 != r2) goto L_0x00d9
            goto L_0x039c
        L_0x00d9:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x00de:
            if (r6 != 0) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzch r11 = (com.google.android.gms.internal.clearcut.zzch) r11
        L_0x00e2:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            int r4 = com.google.android.gms.internal.clearcut.zzbk.zzm(r4)
            r11.zzac(r4)
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039c
            goto L_0x00e2
        L_0x00fa:
            if (r6 != r10) goto L_0x0101
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11, r7)
            goto L_0x0112
        L_0x0101:
            if (r6 != 0) goto L_0x039b
            r2 = r21
            r3 = r18
            r4 = r19
            r5 = r20
            r6 = r11
            r7 = r30
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r2, r3, r4, r5, r6, r7)
        L_0x0112:
            com.google.android.gms.internal.clearcut.zzcg r1 = (com.google.android.gms.internal.clearcut.zzcg) r1
            com.google.android.gms.internal.clearcut.zzey r3 = r1.zzjp
            com.google.android.gms.internal.clearcut.zzey r4 = com.google.android.gms.internal.clearcut.zzey.zzea()
            if (r3 != r4) goto L_0x011d
            r3 = 0
        L_0x011d:
            com.google.android.gms.internal.clearcut.zzck r4 = r0.zzaf(r8)
            com.google.android.gms.internal.clearcut.zzex<?, ?> r5 = r0.zzmx
            r6 = r22
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzeh.zza(r6, r11, r4, r3, r5)
            com.google.android.gms.internal.clearcut.zzey r3 = (com.google.android.gms.internal.clearcut.zzey) r3
            if (r3 == 0) goto L_0x012f
            r1.zzjp = r3
        L_0x012f:
            r1 = r2
            goto L_0x039c
        L_0x0132:
            if (r6 != r10) goto L_0x039b
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            if (r4 != 0) goto L_0x0142
        L_0x013c:
            com.google.android.gms.internal.clearcut.zzbb r4 = com.google.android.gms.internal.clearcut.zzbb.zzfi
            r11.add(r4)
            goto L_0x014a
        L_0x0142:
            com.google.android.gms.internal.clearcut.zzbb r6 = com.google.android.gms.internal.clearcut.zzbb.zzb(r3, r1, r4)
            r11.add(r6)
            int r1 = r1 + r4
        L_0x014a:
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039c
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            if (r4 != 0) goto L_0x0142
            goto L_0x013c
        L_0x015d:
            if (r6 != r10) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzef r1 = r0.zzad(r8)
            r22 = r1
            r23 = r21
            r24 = r18
            r25 = r19
            r26 = r20
            r27 = r11
            r28 = r30
            int r1 = zza(r22, r23, r24, r25, r26, r27, r28)
            goto L_0x039c
        L_0x0177:
            if (r6 != r10) goto L_0x039b
            r8 = 536870912(0x20000000, double:2.652494739E-315)
            long r8 = r25 & r8
            java.lang.String r1 = ""
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            if (r6 != 0) goto L_0x01b6
            int r6 = r7.zzfd
            if (r6 != 0) goto L_0x0190
        L_0x018c:
            r11.add(r1)
            goto L_0x019b
        L_0x0190:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r8.<init>(r3, r4, r6, r9)
        L_0x0197:
            r11.add(r8)
            int r4 = r4 + r6
        L_0x019b:
            if (r4 >= r5) goto L_0x039b
            int r6 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r8 = r7.zzfd
            if (r2 != r8) goto L_0x039b
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r6, r7)
            int r6 = r7.zzfd
            if (r6 != 0) goto L_0x01ae
            goto L_0x018c
        L_0x01ae:
            java.lang.String r8 = new java.lang.String
            java.nio.charset.Charset r9 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r8.<init>(r3, r4, r6, r9)
            goto L_0x0197
        L_0x01b6:
            int r6 = r7.zzfd
            if (r6 != 0) goto L_0x01be
        L_0x01ba:
            r11.add(r1)
            goto L_0x01d1
        L_0x01be:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.clearcut.zzff.zze(r3, r4, r8)
            if (r9 == 0) goto L_0x01f9
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r9.<init>(r3, r4, r6, r10)
        L_0x01cd:
            r11.add(r9)
            r4 = r8
        L_0x01d1:
            if (r4 >= r5) goto L_0x039b
            int r6 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r8 = r7.zzfd
            if (r2 != r8) goto L_0x039b
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r6, r7)
            int r6 = r7.zzfd
            if (r6 != 0) goto L_0x01e4
            goto L_0x01ba
        L_0x01e4:
            int r8 = r4 + r6
            boolean r9 = com.google.android.gms.internal.clearcut.zzff.zze(r3, r4, r8)
            if (r9 == 0) goto L_0x01f4
            java.lang.String r9 = new java.lang.String
            java.nio.charset.Charset r10 = com.google.android.gms.internal.clearcut.zzci.UTF_8
            r9.<init>(r3, r4, r6, r10)
            goto L_0x01cd
        L_0x01f4:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbp()
            throw r1
        L_0x01f9:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbp()
            throw r1
        L_0x01fe:
            r1 = 0
            if (r6 != r10) goto L_0x0226
            com.google.android.gms.internal.clearcut.zzaz r11 = (com.google.android.gms.internal.clearcut.zzaz) r11
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r4 = r7.zzfd
            int r4 = r4 + r2
        L_0x020a:
            if (r2 >= r4) goto L_0x021d
            int r2 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r2, r7)
            long r5 = r7.zzfe
            int r8 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            if (r8 == 0) goto L_0x0218
            r5 = 1
            goto L_0x0219
        L_0x0218:
            r5 = 0
        L_0x0219:
            r11.addBoolean(r5)
            goto L_0x020a
        L_0x021d:
            if (r2 != r4) goto L_0x0221
            goto L_0x012f
        L_0x0221:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x0226:
            if (r6 != 0) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzaz r11 = (com.google.android.gms.internal.clearcut.zzaz) r11
            int r4 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r7)
            long r8 = r7.zzfe
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0236
        L_0x0234:
            r6 = 1
            goto L_0x0237
        L_0x0236:
            r6 = 0
        L_0x0237:
            r11.addBoolean(r6)
            if (r4 >= r5) goto L_0x039b
            int r6 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r8 = r7.zzfd
            if (r2 != r8) goto L_0x039b
            int r4 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r6, r7)
            long r8 = r7.zzfe
            int r6 = (r8 > r14 ? 1 : (r8 == r14 ? 0 : -1))
            if (r6 == 0) goto L_0x0236
            goto L_0x0234
        L_0x024f:
            if (r6 != r10) goto L_0x026f
            com.google.android.gms.internal.clearcut.zzch r11 = (com.google.android.gms.internal.clearcut.zzch) r11
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x025a:
            if (r1 >= r2) goto L_0x0266
            int r4 = com.google.android.gms.internal.clearcut.zzax.zzc(r3, r1)
            r11.zzac(r4)
            int r1 = r1 + 4
            goto L_0x025a
        L_0x0266:
            if (r1 != r2) goto L_0x026a
            goto L_0x039c
        L_0x026a:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x026f:
            if (r6 != r9) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzch r11 = (com.google.android.gms.internal.clearcut.zzch) r11
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzc(r18, r19)
            r11.zzac(r1)
        L_0x027a:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039c
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzc(r3, r4)
            r11.zzac(r1)
            goto L_0x027a
        L_0x028e:
            if (r6 != r10) goto L_0x02ae
            com.google.android.gms.internal.clearcut.zzdc r11 = (com.google.android.gms.internal.clearcut.zzdc) r11
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x0299:
            if (r1 >= r2) goto L_0x02a5
            long r4 = com.google.android.gms.internal.clearcut.zzax.zzd(r3, r1)
            r11.zzm(r4)
            int r1 = r1 + 8
            goto L_0x0299
        L_0x02a5:
            if (r1 != r2) goto L_0x02a9
            goto L_0x039c
        L_0x02a9:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x02ae:
            if (r6 != r13) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzdc r11 = (com.google.android.gms.internal.clearcut.zzdc) r11
            long r8 = com.google.android.gms.internal.clearcut.zzax.zzd(r18, r19)
            r11.zzm(r8)
        L_0x02b9:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039c
            long r8 = com.google.android.gms.internal.clearcut.zzax.zzd(r3, r4)
            r11.zzm(r8)
            goto L_0x02b9
        L_0x02cd:
            if (r6 != r10) goto L_0x02d5
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r11, r7)
            goto L_0x039c
        L_0x02d5:
            if (r6 != 0) goto L_0x039b
            r22 = r18
            r23 = r19
            r24 = r20
            r25 = r11
            r26 = r30
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r21, r22, r23, r24, r25, r26)
            goto L_0x039c
        L_0x02e7:
            if (r6 != r10) goto L_0x0307
            com.google.android.gms.internal.clearcut.zzdc r11 = (com.google.android.gms.internal.clearcut.zzdc) r11
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x02f2:
            if (r1 >= r2) goto L_0x02fe
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r1, r7)
            long r4 = r7.zzfe
            r11.zzm(r4)
            goto L_0x02f2
        L_0x02fe:
            if (r1 != r2) goto L_0x0302
            goto L_0x039c
        L_0x0302:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x0307:
            if (r6 != 0) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzdc r11 = (com.google.android.gms.internal.clearcut.zzdc) r11
        L_0x030b:
            int r1 = com.google.android.gms.internal.clearcut.zzax.zzb(r3, r4, r7)
            long r8 = r7.zzfe
            r11.zzm(r8)
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039c
            goto L_0x030b
        L_0x031f:
            if (r6 != r10) goto L_0x033e
            com.google.android.gms.internal.clearcut.zzce r11 = (com.google.android.gms.internal.clearcut.zzce) r11
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x032a:
            if (r1 >= r2) goto L_0x0336
            float r4 = com.google.android.gms.internal.clearcut.zzax.zzf(r3, r1)
            r11.zzc(r4)
            int r1 = r1 + 4
            goto L_0x032a
        L_0x0336:
            if (r1 != r2) goto L_0x0339
            goto L_0x039c
        L_0x0339:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x033e:
            if (r6 != r9) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzce r11 = (com.google.android.gms.internal.clearcut.zzce) r11
            float r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r18, r19)
            r11.zzc(r1)
        L_0x0349:
            int r1 = r4 + 4
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039c
            float r1 = com.google.android.gms.internal.clearcut.zzax.zzf(r3, r4)
            r11.zzc(r1)
            goto L_0x0349
        L_0x035d:
            if (r6 != r10) goto L_0x037c
            com.google.android.gms.internal.clearcut.zzbq r11 = (com.google.android.gms.internal.clearcut.zzbq) r11
            int r1 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r4, r7)
            int r2 = r7.zzfd
            int r2 = r2 + r1
        L_0x0368:
            if (r1 >= r2) goto L_0x0374
            double r4 = com.google.android.gms.internal.clearcut.zzax.zze(r3, r1)
            r11.zzc(r4)
            int r1 = r1 + 8
            goto L_0x0368
        L_0x0374:
            if (r1 != r2) goto L_0x0377
            goto L_0x039c
        L_0x0377:
            com.google.android.gms.internal.clearcut.zzco r1 = com.google.android.gms.internal.clearcut.zzco.zzbl()
            throw r1
        L_0x037c:
            if (r6 != r13) goto L_0x039b
            com.google.android.gms.internal.clearcut.zzbq r11 = (com.google.android.gms.internal.clearcut.zzbq) r11
            double r8 = com.google.android.gms.internal.clearcut.zzax.zze(r18, r19)
            r11.zzc(r8)
        L_0x0387:
            int r1 = r4 + 8
            if (r1 >= r5) goto L_0x039c
            int r4 = com.google.android.gms.internal.clearcut.zzax.zza(r3, r1, r7)
            int r6 = r7.zzfd
            if (r2 != r6) goto L_0x039c
            double r8 = com.google.android.gms.internal.clearcut.zzax.zze(r3, r4)
            r11.zzc(r8)
            goto L_0x0387
        L_0x039b:
            r1 = r4
        L_0x039c:
            return r1
            switch-data {18->0x035d, 19->0x031f, 20->0x02e7, 21->0x02e7, 22->0x02cd, 23->0x028e, 24->0x024f, 25->0x01fe, 26->0x0177, 27->0x015d, 28->0x0132, 29->0x02cd, 30->0x00fa, 31->0x024f, 32->0x028e, 33->0x00ba, 34->0x007a, 35->0x035d, 36->0x031f, 37->0x02e7, 38->0x02e7, 39->0x02cd, 40->0x028e, 41->0x024f, 42->0x01fe, 43->0x02cd, 44->0x00fa, 45->0x024f, 46->0x028e, 47->0x00ba, 48->0x007a, 49->0x003f, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, int, int, int, long, int, long, com.google.android.gms.internal.clearcut.zzay):int");
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v3, resolved type: java.util.Map<?, ?>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v4, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v12, resolved type: byte} */
    /* JADX WARN: Multi-variable type inference failed */
    private final <K, V> int zza(T t, byte[] bArr, int i, int i2, int i3, int i4, long j, zzay zzay) throws IOException {
        Unsafe unsafe = zzmh;
        Object zzae = zzae(i3);
        Object object = unsafe.getObject(t, j);
        if (this.zzmz.zzi(object)) {
            Object zzk = this.zzmz.zzk(zzae);
            this.zzmz.zzb(zzk, object);
            unsafe.putObject(t, j, zzk);
            object = zzk;
        }
        zzdh<?, ?> zzl = this.zzmz.zzl(zzae);
        Map<?, ?> zzg = this.zzmz.zzg(object);
        int zza = zzax.zza(bArr, i, zzay);
        int i5 = zzay.zzfd;
        if (i5 < 0 || i5 > i2 - zza) {
            throw zzco.zzbl();
        }
        int i6 = i5 + zza;
        Object obj = zzl.zzmc;
        Object obj2 = zzl.zzdu;
        while (zza < i6) {
            int i7 = zza + 1;
            byte b = bArr[zza];
            int i8 = b;
            if (b < 0) {
                i7 = zzax.zza(b, bArr, i7, zzay);
                i8 = zzay.zzfd;
            }
            int i9 = i8 >>> 3;
            int i10 = i8 & 7;
            if (i9 != 1) {
                if (i9 == 2 && i10 == zzl.zzmd.zzel()) {
                    zza = zza(bArr, i7, i2, zzl.zzmd, zzl.zzdu.getClass(), zzay);
                    obj2 = zzay.zzff;
                }
            } else if (i10 == zzl.zzmb.zzel()) {
                zza = zza(bArr, i7, i2, zzl.zzmb, (Class<?>) null, zzay);
                obj = zzay.zzff;
            }
            zza = zzax.zza(i8, bArr, i7, i2, zzay);
        }
        if (zza == i6) {
            zzg.put(obj, obj2);
            return i6;
        }
        throw zzco.zzbo();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:112:0x02f0, code lost:
        if (r0 == r4) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0338, code lost:
        if (r0 == r15) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0354, code lost:
        if (r0 == r15) goto L_0x0356;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0356, code lost:
        r9 = r29;
        r8 = r31;
        r2 = r0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0370 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(T r27, byte[] r28, int r29, int r30, int r31, com.google.android.gms.internal.clearcut.zzay r32) throws java.io.IOException {
        /*
            r26 = this;
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r31
            r9 = r32
            sun.misc.Unsafe r10 = com.google.android.gms.internal.clearcut.zzds.zzmh
            r16 = 0
            r8 = -1
            r0 = r29
            r1 = 0
            r6 = 0
            r7 = -1
        L_0x0016:
            r17 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 >= r13) goto L_0x0395
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x002a
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r0, r12, r1, r9)
            int r1 = r9.zzfd
            r4 = r0
            r5 = r1
            goto L_0x002c
        L_0x002a:
            r5 = r0
            r4 = r1
        L_0x002c:
            int r3 = r5 >>> 3
            r2 = r5 & 7
            int r1 = r15.zzai(r3)
            if (r1 == r8) goto L_0x035c
            int[] r0 = r15.zzmi
            int r18 = r1 + 1
            r8 = r0[r18]
            r18 = 267386880(0xff00000, float:2.3665827E-29)
            r18 = r8 & r18
            int r11 = r18 >>> 20
            r29 = r5
            r5 = r8 & r17
            long r12 = (long) r5
            r5 = 17
            r18 = r8
            if (r11 > r5) goto L_0x026c
            int r5 = r1 + 2
            r0 = r0[r5]
            int r5 = r0 >>> 20
            r8 = 1
            int r20 = r8 << r5
            r0 = r0 & r17
            r5 = -1
            if (r0 == r7) goto L_0x0067
            if (r7 == r5) goto L_0x0061
            long r8 = (long) r7
            r10.putInt(r14, r8, r6)
        L_0x0061:
            long r6 = (long) r0
            int r6 = r10.getInt(r14, r6)
            r7 = r0
        L_0x0067:
            r0 = 5
            switch(r11) {
                case 0: goto L_0x0240;
                case 1: goto L_0x022a;
                case 2: goto L_0x0206;
                case 3: goto L_0x0206;
                case 4: goto L_0x01f0;
                case 5: goto L_0x01cd;
                case 6: goto L_0x01b0;
                case 7: goto L_0x0190;
                case 8: goto L_0x016d;
                case 9: goto L_0x0141;
                case 10: goto L_0x0124;
                case 11: goto L_0x01f0;
                case 12: goto L_0x00ef;
                case 13: goto L_0x01b0;
                case 14: goto L_0x01cd;
                case 15: goto L_0x00d7;
                case 16: goto L_0x00b1;
                case 17: goto L_0x0076;
                default: goto L_0x006b;
            }
        L_0x006b:
            r12 = r28
            r9 = r29
            r11 = r32
        L_0x0071:
            r5 = r4
            r29 = r7
            goto L_0x0263
        L_0x0076:
            r0 = 3
            if (r2 != r0) goto L_0x00ac
            int r0 = r3 << 3
            r8 = r0 | 4
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r1)
            r1 = r28
            r2 = r4
            r3 = r30
            r4 = r8
            r9 = r29
            r8 = -1
            r5 = r32
            int r0 = zza(r0, r1, r2, r3, r4, r5)
            r1 = r6 & r20
            r11 = r32
            if (r1 != 0) goto L_0x0099
            java.lang.Object r1 = r11.zzff
            goto L_0x00a3
        L_0x0099:
            java.lang.Object r1 = r10.getObject(r14, r12)
            java.lang.Object r2 = r11.zzff
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.zzci.zza(r1, r2)
        L_0x00a3:
            r10.putObject(r14, r12, r1)
            r6 = r6 | r20
            r12 = r28
            goto L_0x0121
        L_0x00ac:
            r9 = r29
            r11 = r32
            goto L_0x00d4
        L_0x00b1:
            r9 = r29
            r11 = r32
            r8 = -1
            if (r2 != 0) goto L_0x00d4
            r2 = r12
            r12 = r28
            int r13 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r4, r11)
            long r0 = r11.zzfe
            long r4 = com.google.android.gms.internal.clearcut.zzbk.zza(r0)
            r0 = r10
            r1 = r27
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            r1 = r9
            r9 = r11
            r0 = r13
            r13 = r30
            goto L_0x025f
        L_0x00d4:
            r12 = r28
            goto L_0x0071
        L_0x00d7:
            r9 = r29
            r11 = r32
            r0 = r12
            r8 = -1
            r12 = r28
            if (r2 != 0) goto L_0x0071
            int r2 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r4, r11)
            int r3 = r11.zzfd
            int r3 = com.google.android.gms.internal.clearcut.zzbk.zzm(r3)
            r10.putInt(r14, r0, r3)
            goto L_0x0138
        L_0x00ef:
            r9 = r29
            r11 = r32
            r21 = r12
            r8 = -1
            r12 = r28
            if (r2 != 0) goto L_0x0071
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r4, r11)
            int r2 = r11.zzfd
            com.google.android.gms.internal.clearcut.zzck r1 = r15.zzaf(r1)
            if (r1 == 0) goto L_0x011a
            com.google.android.gms.internal.clearcut.zzcj r1 = r1.zzb(r2)
            if (r1 == 0) goto L_0x010d
            goto L_0x011a
        L_0x010d:
            com.google.android.gms.internal.clearcut.zzey r1 = zzn(r27)
            long r2 = (long) r2
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.zzb(r9, r2)
            goto L_0x0121
        L_0x011a:
            r3 = r21
            r10.putInt(r14, r3, r2)
            r6 = r6 | r20
        L_0x0121:
            r13 = r30
            goto L_0x013d
        L_0x0124:
            r9 = r29
            r11 = r32
            r0 = r12
            r3 = 2
            r8 = -1
            r12 = r28
            if (r2 != r3) goto L_0x0071
            int r2 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r4, r11)
            java.lang.Object r3 = r11.zzff
            r10.putObject(r14, r0, r3)
        L_0x0138:
            r6 = r6 | r20
            r13 = r30
            r0 = r2
        L_0x013d:
            r1 = r9
            r9 = r11
            goto L_0x025f
        L_0x0141:
            r9 = r29
            r11 = r32
            r29 = r7
            r7 = r12
            r3 = 2
            r12 = r28
            if (r2 != r3) goto L_0x0169
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r1)
            r5 = r30
            int r0 = zza(r0, r12, r4, r5, r11)
            r1 = r6 & r20
            if (r1 != 0) goto L_0x015e
            java.lang.Object r1 = r11.zzff
            goto L_0x018c
        L_0x015e:
            java.lang.Object r1 = r10.getObject(r14, r7)
            java.lang.Object r2 = r11.zzff
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.zzci.zza(r1, r2)
            goto L_0x018c
        L_0x0169:
            r5 = r30
            goto L_0x01ed
        L_0x016d:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r0 = 2
            r12 = r28
            if (r2 != r0) goto L_0x01ed
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r18 & r0
            if (r0 != 0) goto L_0x0186
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r4, r11)
            goto L_0x018a
        L_0x0186:
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r4, r11)
        L_0x018a:
            java.lang.Object r1 = r11.zzff
        L_0x018c:
            r10.putObject(r14, r7, r1)
            goto L_0x01c6
        L_0x0190:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x01ed
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r4, r11)
            long r1 = r11.zzfe
            r3 = 0
            int r17 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r17 == 0) goto L_0x01ab
            r1 = 1
            goto L_0x01ac
        L_0x01ab:
            r1 = 0
        L_0x01ac:
            com.google.android.gms.internal.clearcut.zzfd.zza(r14, r7, r1)
            goto L_0x01c6
        L_0x01b0:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != r0) goto L_0x01ed
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r4)
            r10.putInt(r14, r7, r0)
            int r0 = r4 + 4
        L_0x01c6:
            r6 = r6 | r20
            r7 = r29
            r13 = r5
            goto L_0x025c
        L_0x01cd:
            r9 = r29
            r5 = r30
            r11 = r32
            r29 = r7
            r7 = r12
            r0 = 1
            r12 = r28
            if (r2 != r0) goto L_0x01ed
            long r17 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r4)
            r0 = r10
            r1 = r27
            r2 = r7
            r7 = r4
            r4 = r17
            r0.putLong(r1, r2, r4)
            int r0 = r7 + 8
            goto L_0x0256
        L_0x01ed:
            r5 = r4
            goto L_0x0263
        L_0x01f0:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0263
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r5, r11)
            int r1 = r11.zzfd
            r10.putInt(r14, r7, r1)
            goto L_0x0256
        L_0x0206:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != 0) goto L_0x0263
            int r17 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r5, r11)
            long r4 = r11.zzfe
            r0 = r10
            r1 = r27
            r2 = r7
            r0.putLong(r1, r2, r4)
            r6 = r6 | r20
            r7 = r29
            r13 = r30
            r1 = r9
            r9 = r11
            r0 = r17
            goto L_0x025e
        L_0x022a:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r12 = r28
            if (r2 != r0) goto L_0x0263
            float r0 = com.google.android.gms.internal.clearcut.zzax.zzf(r12, r5)
            com.google.android.gms.internal.clearcut.zzfd.zza(r14, r7, r0)
            int r0 = r5 + 4
            goto L_0x0256
        L_0x0240:
            r9 = r29
            r11 = r32
            r5 = r4
            r29 = r7
            r7 = r12
            r0 = 1
            r12 = r28
            if (r2 != r0) goto L_0x0263
            double r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r5)
            com.google.android.gms.internal.clearcut.zzfd.zza(r14, r7, r0)
            int r0 = r5 + 8
        L_0x0256:
            r6 = r6 | r20
            r7 = r29
            r13 = r30
        L_0x025c:
            r1 = r9
            r9 = r11
        L_0x025e:
            r8 = -1
        L_0x025f:
            r11 = r31
            goto L_0x0016
        L_0x0263:
            r7 = r29
            r8 = r31
            r2 = r5
            r25 = r10
            goto L_0x036e
        L_0x026c:
            r9 = r29
            r5 = r4
            r19 = r7
            r7 = r12
            r12 = r28
            r0 = 27
            if (r11 != r0) goto L_0x02be
            r0 = 2
            if (r2 != r0) goto L_0x02b7
            java.lang.Object r0 = r10.getObject(r14, r7)
            com.google.android.gms.internal.clearcut.zzcn r0 = (com.google.android.gms.internal.clearcut.zzcn) r0
            boolean r2 = r0.zzu()
            if (r2 != 0) goto L_0x0299
            int r2 = r0.size()
            if (r2 != 0) goto L_0x0290
            r2 = 10
            goto L_0x0292
        L_0x0290:
            int r2 = r2 << 1
        L_0x0292:
            com.google.android.gms.internal.clearcut.zzcn r0 = r0.zzi(r2)
            r10.putObject(r14, r7, r0)
        L_0x0299:
            r7 = r0
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r1)
            r1 = r9
            r2 = r28
            r3 = r5
            r4 = r30
            r5 = r7
            r20 = r6
            r6 = r32
            int r0 = zza(r0, r1, r2, r3, r4, r5, r6)
            r13 = r30
            r11 = r31
            r7 = r19
            r6 = r20
            goto L_0x0390
        L_0x02b7:
            r20 = r6
            r15 = r5
            r29 = r9
            goto L_0x0363
        L_0x02be:
            r20 = r6
            r0 = 49
            if (r11 > r0) goto L_0x030b
            r6 = r18
            long r13 = (long) r6
            r0 = r26
            r18 = r1
            r1 = r27
            r6 = r2
            r2 = r28
            r21 = r3
            r3 = r5
            r4 = r30
            r15 = r5
            r5 = r9
            r22 = r6
            r6 = r21
            r23 = r7
            r7 = r22
            r8 = r18
            r29 = r9
            r25 = r10
            r9 = r13
            r14 = r31
            r12 = r23
            r14 = r32
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x02f4
            goto L_0x0356
        L_0x02f4:
            r15 = r26
            r14 = r27
            r12 = r28
            r1 = r29
            r13 = r30
            r11 = r31
            r9 = r32
            r7 = r19
            r6 = r20
            r10 = r25
            r8 = -1
            goto L_0x0016
        L_0x030b:
            r22 = r2
            r21 = r3
            r15 = r5
            r23 = r7
            r29 = r9
            r25 = r10
            r6 = r18
            r18 = r1
            r0 = 50
            r7 = r22
            if (r11 != r0) goto L_0x033b
            r0 = 2
            if (r7 != r0) goto L_0x0365
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r18
            r6 = r21
            r7 = r23
            r9 = r32
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r9)
            if (r0 != r15) goto L_0x02f4
            goto L_0x0356
        L_0x033b:
            r0 = r26
            r1 = r27
            r2 = r28
            r3 = r15
            r4 = r30
            r5 = r29
            r8 = r6
            r6 = r21
            r9 = r11
            r10 = r23
            r12 = r18
            r13 = r32
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x02f4
        L_0x0356:
            r9 = r29
            r8 = r31
            r2 = r0
            goto L_0x036a
        L_0x035c:
            r15 = r4
            r29 = r5
            r20 = r6
            r19 = r7
        L_0x0363:
            r25 = r10
        L_0x0365:
            r9 = r29
            r8 = r31
            r2 = r15
        L_0x036a:
            r7 = r19
            r6 = r20
        L_0x036e:
            if (r9 != r8) goto L_0x0377
            if (r8 != 0) goto L_0x0373
            goto L_0x0377
        L_0x0373:
            r0 = r7
            r1 = -1
            r7 = r2
            goto L_0x03a1
        L_0x0377:
            r0 = r9
            r1 = r28
            r3 = r30
            r4 = r27
            r5 = r32
            int r0 = zza(r0, r1, r2, r3, r4, r5)
            r15 = r26
            r14 = r27
            r12 = r28
            r13 = r30
            r11 = r8
            r1 = r9
            r10 = r25
        L_0x0390:
            r8 = -1
            r9 = r32
            goto L_0x0016
        L_0x0395:
            r20 = r6
            r19 = r7
            r25 = r10
            r8 = r11
            r7 = r0
            r9 = r1
            r0 = r19
            r1 = -1
        L_0x03a1:
            if (r0 == r1) goto L_0x03ac
            long r0 = (long) r0
            r10 = r27
            r2 = r25
            r2.putInt(r10, r0, r6)
            goto L_0x03ae
        L_0x03ac:
            r10 = r27
        L_0x03ae:
            r11 = r26
            int[] r12 = r11.zzmt
            if (r12 == 0) goto L_0x03ef
            r0 = 0
            int r13 = r12.length
            r5 = r0
            r14 = 0
        L_0x03b8:
            if (r14 >= r13) goto L_0x03e8
            r1 = r12[r14]
            com.google.android.gms.internal.clearcut.zzex<?, ?> r6 = r11.zzmx
            int[] r0 = r11.zzmi
            r2 = r0[r1]
            int r0 = r11.zzag(r1)
            r0 = r0 & r17
            long r3 = (long) r0
            java.lang.Object r0 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r3)
            if (r0 != 0) goto L_0x03d0
            goto L_0x03e3
        L_0x03d0:
            com.google.android.gms.internal.clearcut.zzck r4 = r11.zzaf(r1)
            if (r4 != 0) goto L_0x03d7
            goto L_0x03e3
        L_0x03d7:
            com.google.android.gms.internal.clearcut.zzdj r3 = r11.zzmz
            java.util.Map r3 = r3.zzg(r0)
            r0 = r26
            java.lang.Object r5 = r0.zza(r1, r2, r3, r4, r5, r6)
        L_0x03e3:
            com.google.android.gms.internal.clearcut.zzey r5 = (com.google.android.gms.internal.clearcut.zzey) r5
            int r14 = r14 + 1
            goto L_0x03b8
        L_0x03e8:
            if (r5 == 0) goto L_0x03ef
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r11.zzmx
            r0.zzf(r10, r5)
        L_0x03ef:
            r0 = r30
            if (r8 != 0) goto L_0x03fb
            if (r7 != r0) goto L_0x03f6
            goto L_0x03ff
        L_0x03f6:
            com.google.android.gms.internal.clearcut.zzco r0 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            throw r0
        L_0x03fb:
            if (r7 > r0) goto L_0x0400
            if (r9 != r8) goto L_0x0400
        L_0x03ff:
            return r7
        L_0x0400:
            com.google.android.gms.internal.clearcut.zzco r0 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            throw r0
            switch-data {0->0x0240, 1->0x022a, 2->0x0206, 3->0x0206, 4->0x01f0, 5->0x01cd, 6->0x01b0, 7->0x0190, 8->0x016d, 9->0x0141, 10->0x0124, 11->0x01f0, 12->0x00ef, 13->0x01b0, 14->0x01cd, 15->0x00d7, 16->0x00b1, 17->0x0076, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, int, com.google.android.gms.internal.clearcut.zzay):int");
    }

    private static int zza(byte[] bArr, int i, int i2, zzfl zzfl, Class<?> cls, zzay zzay) throws IOException {
        int zzb;
        Object valueOf;
        Object obj;
        Object obj2;
        int i3;
        int zza;
        long j;
        switch (zzdt.zzgq[zzfl.ordinal()]) {
            case 1:
                zzb = zzax.zzb(bArr, i, zzay);
                valueOf = Boolean.valueOf(zzay.zzfe != 0);
                zzay.zzff = valueOf;
                return zzb;
            case 2:
                return zzax.zze(bArr, i, zzay);
            case 3:
                obj = Double.valueOf(zzax.zze(bArr, i));
                zzay.zzff = obj;
                return i + 8;
            case 4:
            case 5:
                obj2 = Integer.valueOf(zzax.zzc(bArr, i));
                zzay.zzff = obj2;
                return i + 4;
            case 6:
            case 7:
                obj = Long.valueOf(zzax.zzd(bArr, i));
                zzay.zzff = obj;
                return i + 8;
            case 8:
                obj2 = Float.valueOf(zzax.zzf(bArr, i));
                zzay.zzff = obj2;
                return i + 4;
            case 9:
            case 10:
            case 11:
                zza = zzax.zza(bArr, i, zzay);
                i3 = zzay.zzfd;
                valueOf = Integer.valueOf(i3);
                zzay.zzff = valueOf;
                return zzb;
            case 12:
            case 13:
                zzb = zzax.zzb(bArr, i, zzay);
                j = zzay.zzfe;
                valueOf = Long.valueOf(j);
                zzay.zzff = valueOf;
                return zzb;
            case 14:
                return zza((zzef) zzea.zzcm().zze(cls), bArr, i, i2, zzay);
            case 15:
                zza = zzax.zza(bArr, i, zzay);
                i3 = zzbk.zzm(zzay.zzfd);
                valueOf = Integer.valueOf(i3);
                zzay.zzff = valueOf;
                return zzb;
            case 16:
                zzb = zzax.zzb(bArr, i, zzay);
                j = zzbk.zza(zzay.zzfe);
                valueOf = Long.valueOf(j);
                zzay.zzff = valueOf;
                return zzb;
            case 17:
                return zzax.zzd(bArr, i, zzay);
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    static <T> zzds<T> zza(Class<T> cls, zzdm zzdm, zzdw zzdw, zzcy zzcy, zzex<?, ?> zzex, zzbu<?> zzbu, zzdj zzdj) {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (zzdm instanceof zzec) {
            zzec zzec = (zzec) zzdm;
            boolean z = zzec.zzcf() == zzcg.zzg.zzkm;
            if (zzec.getFieldCount() == 0) {
                i3 = 0;
                i2 = 0;
                i = 0;
            } else {
                int zzcp = zzec.zzcp();
                int zzcq = zzec.zzcq();
                i3 = zzec.zzcu();
                i2 = zzcp;
                i = zzcq;
            }
            int[] iArr = new int[(i3 << 2)];
            Object[] objArr = new Object[(i3 << 1)];
            int[] iArr2 = zzec.zzcr() > 0 ? new int[zzec.zzcr()] : null;
            int[] iArr3 = zzec.zzcs() > 0 ? new int[zzec.zzcs()] : null;
            zzed zzco = zzec.zzco();
            if (zzco.next()) {
                int zzcx = zzco.zzcx();
                int i7 = 0;
                int i8 = 0;
                int i9 = 0;
                while (true) {
                    if (zzcx >= zzec.zzcv() || i7 >= ((zzcx - i2) << 2)) {
                        if (zzco.zzda()) {
                            i6 = (int) zzfd.zza(zzco.zzdb());
                            i4 = (int) zzfd.zza(zzco.zzdc());
                            i5 = 0;
                        } else {
                            i6 = (int) zzfd.zza(zzco.zzdd());
                            if (zzco.zzde()) {
                                i4 = (int) zzfd.zza(zzco.zzdf());
                                i5 = zzco.zzdg();
                            } else {
                                i5 = 0;
                                i4 = 0;
                            }
                        }
                        iArr[i7] = zzco.zzcx();
                        int i10 = i7 + 1;
                        iArr[i10] = (zzco.zzdi() ? 536870912 : 0) | (zzco.zzdh() ? 268435456 : 0) | (zzco.zzcy() << 20) | i6;
                        iArr[i7 + 2] = (i5 << 20) | i4;
                        if (zzco.zzdl() != null) {
                            int i11 = (i7 / 4) << 1;
                            objArr[i11] = zzco.zzdl();
                            if (zzco.zzdj() != null) {
                                objArr[i11 + 1] = zzco.zzdj();
                            } else if (zzco.zzdk() != null) {
                                objArr[i11 + 1] = zzco.zzdk();
                            }
                        } else if (zzco.zzdj() != null) {
                            objArr[((i7 / 4) << 1) + 1] = zzco.zzdj();
                        } else if (zzco.zzdk() != null) {
                            objArr[((i7 / 4) << 1) + 1] = zzco.zzdk();
                        }
                        int zzcy2 = zzco.zzcy();
                        if (zzcy2 == zzcb.MAP.ordinal()) {
                            iArr2[i8] = i7;
                            i8++;
                        } else if (zzcy2 >= 18 && zzcy2 <= 49) {
                            iArr3[i9] = iArr[i10] & 1048575;
                            i9++;
                        }
                        if (!zzco.next()) {
                            break;
                        }
                        zzcx = zzco.zzcx();
                    } else {
                        for (int i12 = 0; i12 < 4; i12++) {
                            iArr[i7 + i12] = -1;
                        }
                    }
                    i7 += 4;
                }
            }
            return new zzds<>(iArr, objArr, i2, i, zzec.zzcv(), zzec.zzch(), z, false, zzec.zzct(), iArr2, iArr3, zzdw, zzcy, zzex, zzbu, zzdj);
        }
        ((zzes) zzdm).zzcf();
        throw new NoSuchMethodError();
    }

    private final <K, V, UT, UB> UB zza(int i, int i2, Map<K, V> map, zzck<?> zzck, UB ub, zzex<UT, UB> zzex) {
        zzdh<?, ?> zzl = this.zzmz.zzl(zzae(i));
        Iterator<Map.Entry<K, V>> it2 = map.entrySet().iterator();
        while (it2.hasNext()) {
            Map.Entry<K, V> next = it2.next();
            if (zzck.zzb(next.getValue().intValue()) == null) {
                if (ub == null) {
                    ub = zzex.zzdz();
                }
                zzbg zzk = zzbb.zzk(zzdg.zza(zzl, next.getKey(), next.getValue()));
                try {
                    zzdg.zza(zzk.zzae(), zzl, next.getKey(), next.getValue());
                    zzex.zza(ub, i2, zzk.zzad());
                    it2.remove();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return ub;
    }

    private static void zza(int i, Object obj, zzfr zzfr) throws IOException {
        if (obj instanceof String) {
            zzfr.zza(i, (String) obj);
        } else {
            zzfr.zza(i, (zzbb) obj);
        }
    }

    private static <UT, UB> void zza(zzex<UT, UB> zzex, T t, zzfr zzfr) throws IOException {
        zzex.zza(zzex.zzq(t), zzfr);
    }

    private final <K, V> void zza(zzfr zzfr, int i, Object obj, int i2) throws IOException {
        if (obj != null) {
            zzfr.zza(i, this.zzmz.zzl(zzae(i2)), this.zzmz.zzh(obj));
        }
    }

    private final void zza(T t, T t2, int i) {
        long zzag = (long) (zzag(i) & 1048575);
        if (zza(t2, i)) {
            Object zzo = zzfd.zzo(t, zzag);
            Object zzo2 = zzfd.zzo(t2, zzag);
            if (zzo != null && zzo2 != null) {
                zzfd.zza(t, zzag, zzci.zza(zzo, zzo2));
                zzb(t, i);
            } else if (zzo2 != null) {
                zzfd.zza(t, zzag, zzo2);
                zzb(t, i);
            }
        }
    }

    private final boolean zza(T t, int i) {
        if (this.zzmq) {
            int zzag = zzag(i);
            long j = (long) (zzag & 1048575);
            switch ((zzag & 267386880) >>> 20) {
                case 0:
                    return zzfd.zzn(t, j) != 0.0d;
                case 1:
                    return zzfd.zzm(t, j) != 0.0f;
                case 2:
                    return zzfd.zzk(t, j) != 0;
                case 3:
                    return zzfd.zzk(t, j) != 0;
                case 4:
                    return zzfd.zzj(t, j) != 0;
                case 5:
                    return zzfd.zzk(t, j) != 0;
                case 6:
                    return zzfd.zzj(t, j) != 0;
                case 7:
                    return zzfd.zzl(t, j);
                case 8:
                    Object zzo = zzfd.zzo(t, j);
                    if (zzo instanceof String) {
                        return !((String) zzo).isEmpty();
                    }
                    if (zzo instanceof zzbb) {
                        return !zzbb.zzfi.equals(zzo);
                    }
                    throw new IllegalArgumentException();
                case 9:
                    return zzfd.zzo(t, j) != null;
                case 10:
                    return !zzbb.zzfi.equals(zzfd.zzo(t, j));
                case 11:
                    return zzfd.zzj(t, j) != 0;
                case 12:
                    return zzfd.zzj(t, j) != 0;
                case 13:
                    return zzfd.zzj(t, j) != 0;
                case 14:
                    return zzfd.zzk(t, j) != 0;
                case 15:
                    return zzfd.zzj(t, j) != 0;
                case 16:
                    return zzfd.zzk(t, j) != 0;
                case 17:
                    return zzfd.zzo(t, j) != null;
                default:
                    throw new IllegalArgumentException();
            }
        } else {
            int zzah = zzah(i);
            return (zzfd.zzj(t, (long) (zzah & 1048575)) & (1 << (zzah >>> 20))) != 0;
        }
    }

    private final boolean zza(T t, int i, int i2) {
        return zzfd.zzj(t, (long) (zzah(i2) & 1048575)) == i;
    }

    private final boolean zza(T t, int i, int i2, int i3) {
        return this.zzmq ? zza(t, i) : (i2 & i3) != 0;
    }

    private static boolean zza(Object obj, int i, zzef zzef) {
        return zzef.zzo(zzfd.zzo(obj, (long) (i & 1048575)));
    }

    private final zzef zzad(int i) {
        int i2 = (i / 4) << 1;
        zzef zzef = (zzef) this.zzmj[i2];
        if (zzef != null) {
            return zzef;
        }
        zzef<T> zze = zzea.zzcm().zze((Class) this.zzmj[i2 + 1]);
        this.zzmj[i2] = zze;
        return zze;
    }

    private final Object zzae(int i) {
        return this.zzmj[(i / 4) << 1];
    }

    private final zzck<?> zzaf(int i) {
        return (zzck) this.zzmj[((i / 4) << 1) + 1];
    }

    private final int zzag(int i) {
        return this.zzmi[i + 1];
    }

    private final int zzah(int i) {
        return this.zzmi[i + 2];
    }

    private final int zzai(int i) {
        int i2 = this.zzmk;
        if (i >= i2) {
            int i3 = this.zzmm;
            if (i < i3) {
                int i4 = (i - i2) << 2;
                if (this.zzmi[i4] == i) {
                    return i4;
                }
                return -1;
            } else if (i <= this.zzml) {
                int i5 = i3 - i2;
                int length = (this.zzmi.length / 4) - 1;
                while (i5 <= length) {
                    int i6 = (length + i5) >>> 1;
                    int i7 = i6 << 2;
                    int i8 = this.zzmi[i7];
                    if (i == i8) {
                        return i7;
                    }
                    if (i < i8) {
                        length = i6 - 1;
                    } else {
                        i5 = i6 + 1;
                    }
                }
            }
        }
        return -1;
    }

    private final void zzb(T t, int i) {
        if (!this.zzmq) {
            int zzah = zzah(i);
            long j = (long) (zzah & 1048575);
            zzfd.zza((Object) t, j, zzfd.zzj(t, j) | (1 << (zzah >>> 20)));
        }
    }

    private final void zzb(T t, int i, int i2) {
        zzfd.zza((Object) t, (long) (zzah(i2) & 1048575), i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:170:0x0494  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzb(T r19, com.google.android.gms.internal.clearcut.zzfr r20) throws java.io.IOException {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            boolean r3 = r0.zzmo
            if (r3 == 0) goto L_0x0021
            com.google.android.gms.internal.clearcut.zzbu<?> r3 = r0.zzmy
            com.google.android.gms.internal.clearcut.zzby r3 = r3.zza(r1)
            boolean r5 = r3.isEmpty()
            if (r5 != 0) goto L_0x0021
            java.util.Iterator r3 = r3.iterator()
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x0023
        L_0x0021:
            r3 = 0
            r5 = 0
        L_0x0023:
            r6 = -1
            int[] r7 = r0.zzmi
            int r7 = r7.length
            sun.misc.Unsafe r8 = com.google.android.gms.internal.clearcut.zzds.zzmh
            r10 = 0
            r11 = 0
        L_0x002b:
            if (r10 >= r7) goto L_0x0492
            int r12 = r0.zzag(r10)
            int[] r13 = r0.zzmi
            r14 = r13[r10]
            r15 = 267386880(0xff00000, float:2.3665827E-29)
            r15 = r15 & r12
            int r15 = r15 >>> 20
            boolean r4 = r0.zzmq
            r16 = 1048575(0xfffff, float:1.469367E-39)
            if (r4 != 0) goto L_0x005b
            r4 = 17
            if (r15 > r4) goto L_0x005b
            int r4 = r10 + 2
            r4 = r13[r4]
            r13 = r4 & r16
            r17 = r10
            if (r13 == r6) goto L_0x0055
            long r9 = (long) r13
            int r11 = r8.getInt(r1, r9)
            r6 = r13
        L_0x0055:
            int r4 = r4 >>> 20
            r9 = 1
            int r4 = r9 << r4
            goto L_0x005e
        L_0x005b:
            r17 = r10
            r4 = 0
        L_0x005e:
            if (r5 == 0) goto L_0x007c
            com.google.android.gms.internal.clearcut.zzbu<?> r9 = r0.zzmy
            int r9 = r9.zza(r5)
            if (r9 > r14) goto L_0x007c
            com.google.android.gms.internal.clearcut.zzbu<?> r9 = r0.zzmy
            r9.zza(r2, r5)
            boolean r5 = r3.hasNext()
            if (r5 == 0) goto L_0x007a
            java.lang.Object r5 = r3.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            goto L_0x005e
        L_0x007a:
            r5 = 0
            goto L_0x005e
        L_0x007c:
            r9 = r12 & r16
            long r9 = (long) r9
            r12 = r17
            switch(r15) {
                case 0: goto L_0x0483;
                case 1: goto L_0x0477;
                case 2: goto L_0x046b;
                case 3: goto L_0x045f;
                case 4: goto L_0x0453;
                case 5: goto L_0x0447;
                case 6: goto L_0x043b;
                case 7: goto L_0x042f;
                case 8: goto L_0x0423;
                case 9: goto L_0x0412;
                case 10: goto L_0x0403;
                case 11: goto L_0x03f6;
                case 12: goto L_0x03e9;
                case 13: goto L_0x03dc;
                case 14: goto L_0x03cf;
                case 15: goto L_0x03c2;
                case 16: goto L_0x03b5;
                case 17: goto L_0x03a4;
                case 18: goto L_0x0394;
                case 19: goto L_0x0384;
                case 20: goto L_0x0374;
                case 21: goto L_0x0364;
                case 22: goto L_0x0354;
                case 23: goto L_0x0344;
                case 24: goto L_0x0334;
                case 25: goto L_0x0324;
                case 26: goto L_0x0315;
                case 27: goto L_0x0302;
                case 28: goto L_0x02f3;
                case 29: goto L_0x02e3;
                case 30: goto L_0x02d3;
                case 31: goto L_0x02c3;
                case 32: goto L_0x02b3;
                case 33: goto L_0x02a3;
                case 34: goto L_0x0293;
                case 35: goto L_0x0283;
                case 36: goto L_0x0273;
                case 37: goto L_0x0263;
                case 38: goto L_0x0253;
                case 39: goto L_0x0243;
                case 40: goto L_0x0233;
                case 41: goto L_0x0223;
                case 42: goto L_0x0213;
                case 43: goto L_0x0203;
                case 44: goto L_0x01f3;
                case 45: goto L_0x01e3;
                case 46: goto L_0x01d3;
                case 47: goto L_0x01c3;
                case 48: goto L_0x01b3;
                case 49: goto L_0x01a0;
                case 50: goto L_0x0197;
                case 51: goto L_0x0188;
                case 52: goto L_0x0179;
                case 53: goto L_0x016a;
                case 54: goto L_0x015b;
                case 55: goto L_0x014c;
                case 56: goto L_0x013d;
                case 57: goto L_0x012e;
                case 58: goto L_0x011f;
                case 59: goto L_0x0110;
                case 60: goto L_0x00fd;
                case 61: goto L_0x00ed;
                case 62: goto L_0x00df;
                case 63: goto L_0x00d1;
                case 64: goto L_0x00c3;
                case 65: goto L_0x00b5;
                case 66: goto L_0x00a7;
                case 67: goto L_0x0099;
                case 68: goto L_0x0087;
                default: goto L_0x0084;
            }
        L_0x0084:
            r13 = 0
            goto L_0x048e
        L_0x0087:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r12)
            r2.zzb(r14, r4, r9)
            goto L_0x0084
        L_0x0099:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            long r9 = zzh(r1, r9)
            r2.zzb(r14, r9)
            goto L_0x0084
        L_0x00a7:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            int r4 = zzg(r1, r9)
            r2.zze(r14, r4)
            goto L_0x0084
        L_0x00b5:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            long r9 = zzh(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x0084
        L_0x00c3:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            int r4 = zzg(r1, r9)
            r2.zzm(r14, r4)
            goto L_0x0084
        L_0x00d1:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            int r4 = zzg(r1, r9)
            r2.zzn(r14, r4)
            goto L_0x0084
        L_0x00df:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            int r4 = zzg(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x0084
        L_0x00ed:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.zzbb r4 = (com.google.android.gms.internal.clearcut.zzbb) r4
            r2.zza(r14, r4)
            goto L_0x0084
        L_0x00fd:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r12)
            r2.zza(r14, r4, r9)
            goto L_0x0084
        L_0x0110:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza(r14, r4, r2)
            goto L_0x0084
        L_0x011f:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            boolean r4 = zzi(r1, r9)
            r2.zzb(r14, r4)
            goto L_0x0084
        L_0x012e:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            int r4 = zzg(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x0084
        L_0x013d:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            long r9 = zzh(r1, r9)
            r2.zzc(r14, r9)
            goto L_0x0084
        L_0x014c:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            int r4 = zzg(r1, r9)
            r2.zzc(r14, r4)
            goto L_0x0084
        L_0x015b:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            long r9 = zzh(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0084
        L_0x016a:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            long r9 = zzh(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x0084
        L_0x0179:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            float r4 = zzf(r1, r9)
            r2.zza(r14, r4)
            goto L_0x0084
        L_0x0188:
            boolean r4 = r0.zza(r1, r14, r12)
            if (r4 == 0) goto L_0x0084
            double r9 = zze(r1, r9)
            r2.zza(r14, r9)
            goto L_0x0084
        L_0x0197:
            java.lang.Object r4 = r8.getObject(r1, r9)
            r0.zza(r2, r14, r4, r12)
            goto L_0x0084
        L_0x01a0:
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzef r10 = r0.zzad(r12)
            com.google.android.gms.internal.clearcut.zzeh.zzb(r4, r9, r2, r10)
            goto L_0x0084
        L_0x01b3:
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 1
            com.google.android.gms.internal.clearcut.zzeh.zze(r4, r9, r2, r13)
            goto L_0x0084
        L_0x01c3:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzj(r4, r9, r2, r13)
            goto L_0x0084
        L_0x01d3:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzg(r4, r9, r2, r13)
            goto L_0x0084
        L_0x01e3:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzl(r4, r9, r2, r13)
            goto L_0x0084
        L_0x01f3:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzm(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0203:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzi(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0213:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzn(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0223:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzk(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0233:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzf(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0243:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzh(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0253:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0263:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzc(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0273:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0283:
            r13 = 1
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza(r4, r9, r2, r13)
            goto L_0x0084
        L_0x0293:
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.clearcut.zzeh.zze(r4, r9, r2, r13)
            goto L_0x048e
        L_0x02a3:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzj(r4, r9, r2, r13)
            goto L_0x048e
        L_0x02b3:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzg(r4, r9, r2, r13)
            goto L_0x048e
        L_0x02c3:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzl(r4, r9, r2, r13)
            goto L_0x048e
        L_0x02d3:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzm(r4, r9, r2, r13)
            goto L_0x048e
        L_0x02e3:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzi(r4, r9, r2, r13)
            goto L_0x048e
        L_0x02f3:
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb(r4, r9, r2)
            goto L_0x0084
        L_0x0302:
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzef r10 = r0.zzad(r12)
            com.google.android.gms.internal.clearcut.zzeh.zza(r4, r9, r2, r10)
            goto L_0x0084
        L_0x0315:
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza(r4, r9, r2)
            goto L_0x0084
        L_0x0324:
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            r13 = 0
            com.google.android.gms.internal.clearcut.zzeh.zzn(r4, r9, r2, r13)
            goto L_0x048e
        L_0x0334:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzk(r4, r9, r2, r13)
            goto L_0x048e
        L_0x0344:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzf(r4, r9, r2, r13)
            goto L_0x048e
        L_0x0354:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzh(r4, r9, r2, r13)
            goto L_0x048e
        L_0x0364:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r9, r2, r13)
            goto L_0x048e
        L_0x0374:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzc(r4, r9, r2, r13)
            goto L_0x048e
        L_0x0384:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb(r4, r9, r2, r13)
            goto L_0x048e
        L_0x0394:
            r13 = 0
            int[] r4 = r0.zzmi
            r4 = r4[r12]
            java.lang.Object r9 = r8.getObject(r1, r9)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza(r4, r9, r2, r13)
            goto L_0x048e
        L_0x03a4:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r12)
            r2.zzb(r14, r4, r9)
            goto L_0x048e
        L_0x03b5:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            long r9 = r8.getLong(r1, r9)
            r2.zzb(r14, r9)
            goto L_0x048e
        L_0x03c2:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            int r4 = r8.getInt(r1, r9)
            r2.zze(r14, r4)
            goto L_0x048e
        L_0x03cf:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            long r9 = r8.getLong(r1, r9)
            r2.zzj(r14, r9)
            goto L_0x048e
        L_0x03dc:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            int r4 = r8.getInt(r1, r9)
            r2.zzm(r14, r4)
            goto L_0x048e
        L_0x03e9:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            int r4 = r8.getInt(r1, r9)
            r2.zzn(r14, r4)
            goto L_0x048e
        L_0x03f6:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            int r4 = r8.getInt(r1, r9)
            r2.zzd(r14, r4)
            goto L_0x048e
        L_0x0403:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.zzbb r4 = (com.google.android.gms.internal.clearcut.zzbb) r4
            r2.zza(r14, r4)
            goto L_0x048e
        L_0x0412:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            java.lang.Object r4 = r8.getObject(r1, r9)
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r12)
            r2.zza(r14, r4, r9)
            goto L_0x048e
        L_0x0423:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            java.lang.Object r4 = r8.getObject(r1, r9)
            zza(r14, r4, r2)
            goto L_0x048e
        L_0x042f:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            boolean r4 = com.google.android.gms.internal.clearcut.zzfd.zzl(r1, r9)
            r2.zzb(r14, r4)
            goto L_0x048e
        L_0x043b:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            int r4 = r8.getInt(r1, r9)
            r2.zzf(r14, r4)
            goto L_0x048e
        L_0x0447:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            long r9 = r8.getLong(r1, r9)
            r2.zzc(r14, r9)
            goto L_0x048e
        L_0x0453:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            int r4 = r8.getInt(r1, r9)
            r2.zzc(r14, r4)
            goto L_0x048e
        L_0x045f:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            long r9 = r8.getLong(r1, r9)
            r2.zza(r14, r9)
            goto L_0x048e
        L_0x046b:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            long r9 = r8.getLong(r1, r9)
            r2.zzi(r14, r9)
            goto L_0x048e
        L_0x0477:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            float r4 = com.google.android.gms.internal.clearcut.zzfd.zzm(r1, r9)
            r2.zza(r14, r4)
            goto L_0x048e
        L_0x0483:
            r13 = 0
            r4 = r4 & r11
            if (r4 == 0) goto L_0x048e
            double r9 = com.google.android.gms.internal.clearcut.zzfd.zzn(r1, r9)
            r2.zza(r14, r9)
        L_0x048e:
            int r10 = r12 + 4
            goto L_0x002b
        L_0x0492:
            if (r5 == 0) goto L_0x04a9
            com.google.android.gms.internal.clearcut.zzbu<?> r4 = r0.zzmy
            r4.zza(r2, r5)
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x04a7
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            r5 = r4
            goto L_0x0492
        L_0x04a7:
            r5 = 0
            goto L_0x0492
        L_0x04a9:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r3 = r0.zzmx
            zza(r3, r1, r2)
            return
            switch-data {0->0x0483, 1->0x0477, 2->0x046b, 3->0x045f, 4->0x0453, 5->0x0447, 6->0x043b, 7->0x042f, 8->0x0423, 9->0x0412, 10->0x0403, 11->0x03f6, 12->0x03e9, 13->0x03dc, 14->0x03cf, 15->0x03c2, 16->0x03b5, 17->0x03a4, 18->0x0394, 19->0x0384, 20->0x0374, 21->0x0364, 22->0x0354, 23->0x0344, 24->0x0334, 25->0x0324, 26->0x0315, 27->0x0302, 28->0x02f3, 29->0x02e3, 30->0x02d3, 31->0x02c3, 32->0x02b3, 33->0x02a3, 34->0x0293, 35->0x0283, 36->0x0273, 37->0x0263, 38->0x0253, 39->0x0243, 40->0x0233, 41->0x0223, 42->0x0213, 43->0x0203, 44->0x01f3, 45->0x01e3, 46->0x01d3, 47->0x01c3, 48->0x01b3, 49->0x01a0, 50->0x0197, 51->0x0188, 52->0x0179, 53->0x016a, 54->0x015b, 55->0x014c, 56->0x013d, 57->0x012e, 58->0x011f, 59->0x0110, 60->0x00fd, 61->0x00ed, 62->0x00df, 63->0x00d1, 64->0x00c3, 65->0x00b5, 66->0x00a7, 67->0x0099, 68->0x0087, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzb(java.lang.Object, com.google.android.gms.internal.clearcut.zzfr):void");
    }

    private final void zzb(T t, T t2, int i) {
        int zzag = zzag(i);
        int i2 = this.zzmi[i];
        long j = (long) (zzag & 1048575);
        if (zza(t2, i2, i)) {
            Object zzo = zzfd.zzo(t, j);
            Object zzo2 = zzfd.zzo(t2, j);
            if (zzo != null && zzo2 != null) {
                zzfd.zza(t, j, zzci.zza(zzo, zzo2));
                zzb(t, i2, i);
            } else if (zzo2 != null) {
                zzfd.zza(t, j, zzo2);
                zzb(t, i2, i);
            }
        }
    }

    private final boolean zzc(T t, T t2, int i) {
        return zza(t, i) == zza(t2, i);
    }

    private static <E> List<E> zzd(Object obj, long j) {
        return (List) zzfd.zzo(obj, j);
    }

    private static <T> double zze(T t, long j) {
        return ((Double) zzfd.zzo(t, j)).doubleValue();
    }

    private static <T> float zzf(T t, long j) {
        return ((Float) zzfd.zzo(t, j)).floatValue();
    }

    private static <T> int zzg(T t, long j) {
        return ((Integer) zzfd.zzo(t, j)).intValue();
    }

    private static <T> long zzh(T t, long j) {
        return ((Long) zzfd.zzo(t, j)).longValue();
    }

    private static <T> boolean zzi(T t, long j) {
        return ((Boolean) zzfd.zzo(t, j)).booleanValue();
    }

    private static zzey zzn(Object obj) {
        zzcg zzcg = (zzcg) obj;
        zzey zzey = zzcg.zzjp;
        if (zzey != zzey.zzea()) {
            return zzey;
        }
        zzey zzeb = zzey.zzeb();
        zzcg.zzjp = zzeb;
        return zzeb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0070, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0082, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00a8, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00ba, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00cc, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00e2, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00f8, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x010e, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0120, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzl(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzl(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x0132, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x0145, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x0156, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:0x0169, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:0x017c, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x018d, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x01a0, code lost:
        if (com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6) == com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0038, code lost:
        if (com.google.android.gms.internal.clearcut.zzeh.zzd(com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6), com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)) != false) goto L_0x01a3;
     */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(T r10, T r11) {
        /*
            r9 = this;
            int[] r0 = r9.zzmi
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            r3 = 1
            if (r2 >= r0) goto L_0x01aa
            int r4 = r9.zzag(r2)
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r6 = r4 & r5
            long r6 = (long) r6
            r8 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = r4 & r8
            int r4 = r4 >>> 20
            switch(r4) {
                case 0: goto L_0x0190;
                case 1: goto L_0x017f;
                case 2: goto L_0x016c;
                case 3: goto L_0x0159;
                case 4: goto L_0x0148;
                case 5: goto L_0x0135;
                case 6: goto L_0x0124;
                case 7: goto L_0x0112;
                case 8: goto L_0x00fc;
                case 9: goto L_0x00e6;
                case 10: goto L_0x00d0;
                case 11: goto L_0x00be;
                case 12: goto L_0x00ac;
                case 13: goto L_0x009a;
                case 14: goto L_0x0086;
                case 15: goto L_0x0074;
                case 16: goto L_0x0060;
                case 17: goto L_0x004a;
                case 18: goto L_0x003c;
                case 19: goto L_0x003c;
                case 20: goto L_0x003c;
                case 21: goto L_0x003c;
                case 22: goto L_0x003c;
                case 23: goto L_0x003c;
                case 24: goto L_0x003c;
                case 25: goto L_0x003c;
                case 26: goto L_0x003c;
                case 27: goto L_0x003c;
                case 28: goto L_0x003c;
                case 29: goto L_0x003c;
                case 30: goto L_0x003c;
                case 31: goto L_0x003c;
                case 32: goto L_0x003c;
                case 33: goto L_0x003c;
                case 34: goto L_0x003c;
                case 35: goto L_0x003c;
                case 36: goto L_0x003c;
                case 37: goto L_0x003c;
                case 38: goto L_0x003c;
                case 39: goto L_0x003c;
                case 40: goto L_0x003c;
                case 41: goto L_0x003c;
                case 42: goto L_0x003c;
                case 43: goto L_0x003c;
                case 44: goto L_0x003c;
                case 45: goto L_0x003c;
                case 46: goto L_0x003c;
                case 47: goto L_0x003c;
                case 48: goto L_0x003c;
                case 49: goto L_0x003c;
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
            goto L_0x01a3
        L_0x001c:
            int r4 = r9.zzah(r2)
            r4 = r4 & r5
            long r4 = (long) r4
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r4)
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r4)
            if (r8 != r4) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x003c:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r3 = com.google.android.gms.internal.clearcut.zzeh.zzd(r3, r4)
            goto L_0x01a3
        L_0x004a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x01a2
        L_0x0060:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x0074:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x0086:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x009a:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x00ac:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x00be:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x00d0:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x00e6:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x01a2
        L_0x00fc:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            java.lang.Object r4 = com.google.android.gms.internal.clearcut.zzfd.zzo(r10, r6)
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r11, r6)
            boolean r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4, r5)
            if (r4 != 0) goto L_0x01a3
            goto L_0x018f
        L_0x0112:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            boolean r4 = com.google.android.gms.internal.clearcut.zzfd.zzl(r10, r6)
            boolean r5 = com.google.android.gms.internal.clearcut.zzfd.zzl(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x01a2
        L_0x0124:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x0135:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x01a2
        L_0x0148:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
            goto L_0x018f
        L_0x0159:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x01a2
        L_0x016c:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
            goto L_0x018f
        L_0x017f:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            int r4 = com.google.android.gms.internal.clearcut.zzfd.zzj(r10, r6)
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r11, r6)
            if (r4 == r5) goto L_0x01a3
        L_0x018f:
            goto L_0x01a2
        L_0x0190:
            boolean r4 = r9.zzc(r10, r11, r2)
            if (r4 == 0) goto L_0x01a2
            long r4 = com.google.android.gms.internal.clearcut.zzfd.zzk(r10, r6)
            long r6 = com.google.android.gms.internal.clearcut.zzfd.zzk(r11, r6)
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x01a3
        L_0x01a2:
            r3 = 0
        L_0x01a3:
            if (r3 != 0) goto L_0x01a6
            return r1
        L_0x01a6:
            int r2 = r2 + 4
            goto L_0x0005
        L_0x01aa:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r9.zzmx
            java.lang.Object r0 = r0.zzq(r10)
            com.google.android.gms.internal.clearcut.zzex<?, ?> r2 = r9.zzmx
            java.lang.Object r2 = r2.zzq(r11)
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x01bd
            return r1
        L_0x01bd:
            boolean r0 = r9.zzmo
            if (r0 == 0) goto L_0x01d2
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r9.zzmy
            com.google.android.gms.internal.clearcut.zzby r10 = r0.zza(r10)
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r9.zzmy
            com.google.android.gms.internal.clearcut.zzby r11 = r0.zza(r11)
            boolean r10 = r10.equals(r11)
            return r10
        L_0x01d2:
            return r3
            switch-data {0->0x0190, 1->0x017f, 2->0x016c, 3->0x0159, 4->0x0148, 5->0x0135, 6->0x0124, 7->0x0112, 8->0x00fc, 9->0x00e6, 10->0x00d0, 11->0x00be, 12->0x00ac, 13->0x009a, 14->0x0086, 15->0x0074, 16->0x0060, 17->0x004a, 18->0x003c, 19->0x003c, 20->0x003c, 21->0x003c, 22->0x003c, 23->0x003c, 24->0x003c, 25->0x003c, 26->0x003c, 27->0x003c, 28->0x003c, 29->0x003c, 30->0x003c, 31->0x003c, 32->0x003c, 33->0x003c, 34->0x003c, 35->0x003c, 36->0x003c, 37->0x003c, 38->0x003c, 39->0x003c, 40->0x003c, 41->0x003c, 42->0x003c, 43->0x003c, 44->0x003c, 45->0x003c, 46->0x003c, 47->0x003c, 48->0x003c, 49->0x003c, 50->0x003c, 51->0x001c, 52->0x001c, 53->0x001c, 54->0x001c, 55->0x001c, 56->0x001c, 57->0x001c, 58->0x001c, 59->0x001c, 60->0x001c, 61->0x001c, 62->0x001c, 63->0x001c, 64->0x001c, 65->0x001c, 66->0x001c, 67->0x001c, 68->0x001c, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.equals(java.lang.Object, java.lang.Object):boolean");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ce, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00e0, code lost:
        if (r3 != null) goto L_0x00e2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00e2, code lost:
        r7 = r3.hashCode();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00e6, code lost:
        r2 = (r2 * 53) + r7;
     */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int hashCode(T r9) {
        /*
            r8 = this;
            int[] r0 = r8.zzmi
            int r0 = r0.length
            r1 = 0
            r2 = 0
        L_0x0005:
            if (r1 >= r0) goto L_0x012e
            int r3 = r8.zzag(r1)
            int[] r4 = r8.zzmi
            r4 = r4[r1]
            r5 = 1048575(0xfffff, float:1.469367E-39)
            r5 = r5 & r3
            long r5 = (long) r5
            r7 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = r3 & r7
            int r3 = r3 >>> 20
            r7 = 37
            switch(r3) {
                case 0: goto L_0x011b;
                case 1: goto L_0x0110;
                case 2: goto L_0x0109;
                case 3: goto L_0x0109;
                case 4: goto L_0x0102;
                case 5: goto L_0x0109;
                case 6: goto L_0x0102;
                case 7: goto L_0x00f7;
                case 8: goto L_0x00ea;
                case 9: goto L_0x00dc;
                case 10: goto L_0x00d1;
                case 11: goto L_0x0102;
                case 12: goto L_0x0102;
                case 13: goto L_0x0102;
                case 14: goto L_0x0109;
                case 15: goto L_0x0102;
                case 16: goto L_0x0109;
                case 17: goto L_0x00ca;
                case 18: goto L_0x00d1;
                case 19: goto L_0x00d1;
                case 20: goto L_0x00d1;
                case 21: goto L_0x00d1;
                case 22: goto L_0x00d1;
                case 23: goto L_0x00d1;
                case 24: goto L_0x00d1;
                case 25: goto L_0x00d1;
                case 26: goto L_0x00d1;
                case 27: goto L_0x00d1;
                case 28: goto L_0x00d1;
                case 29: goto L_0x00d1;
                case 30: goto L_0x00d1;
                case 31: goto L_0x00d1;
                case 32: goto L_0x00d1;
                case 33: goto L_0x00d1;
                case 34: goto L_0x00d1;
                case 35: goto L_0x00d1;
                case 36: goto L_0x00d1;
                case 37: goto L_0x00d1;
                case 38: goto L_0x00d1;
                case 39: goto L_0x00d1;
                case 40: goto L_0x00d1;
                case 41: goto L_0x00d1;
                case 42: goto L_0x00d1;
                case 43: goto L_0x00d1;
                case 44: goto L_0x00d1;
                case 45: goto L_0x00d1;
                case 46: goto L_0x00d1;
                case 47: goto L_0x00d1;
                case 48: goto L_0x00d1;
                case 49: goto L_0x00d1;
                case 50: goto L_0x00d1;
                case 51: goto L_0x00bd;
                case 52: goto L_0x00b0;
                case 53: goto L_0x00a2;
                case 54: goto L_0x009b;
                case 55: goto L_0x008d;
                case 56: goto L_0x0086;
                case 57: goto L_0x007f;
                case 58: goto L_0x0071;
                case 59: goto L_0x0069;
                case 60: goto L_0x005b;
                case 61: goto L_0x0053;
                case 62: goto L_0x004c;
                case 63: goto L_0x0045;
                case 64: goto L_0x003e;
                case 65: goto L_0x0036;
                case 66: goto L_0x002f;
                case 67: goto L_0x0027;
                case 68: goto L_0x0020;
                default: goto L_0x001e;
            }
        L_0x001e:
            goto L_0x012a
        L_0x0020:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0061
        L_0x0027:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x002f:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x004b
        L_0x0036:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x003e:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x004b
        L_0x0045:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
        L_0x004b:
            goto L_0x0093
        L_0x004c:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0093
        L_0x0053:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00d1
        L_0x005b:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
        L_0x0061:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            int r2 = r2 * 53
            goto L_0x00d7
        L_0x0069:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00ea
        L_0x0071:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            boolean r3 = zzi(r9, r5)
            goto L_0x00fd
        L_0x007f:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x0093
        L_0x0086:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x008d:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
        L_0x0093:
            int r2 = r2 * 53
            int r3 = zzg(r9, r5)
            goto L_0x0129
        L_0x009b:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            goto L_0x00a8
        L_0x00a2:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
        L_0x00a8:
            int r2 = r2 * 53
            long r3 = zzh(r9, r5)
            goto L_0x0125
        L_0x00b0:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            float r3 = zzf(r9, r5)
            goto L_0x0116
        L_0x00bd:
            boolean r3 = r8.zza(r9, r4, r1)
            if (r3 == 0) goto L_0x012a
            int r2 = r2 * 53
            double r3 = zze(r9, r5)
            goto L_0x0121
        L_0x00ca:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            if (r3 == 0) goto L_0x00e6
            goto L_0x00e2
        L_0x00d1:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
        L_0x00d7:
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00dc:
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            if (r3 == 0) goto L_0x00e6
        L_0x00e2:
            int r7 = r3.hashCode()
        L_0x00e6:
            int r2 = r2 * 53
            int r2 = r2 + r7
            goto L_0x012a
        L_0x00ea:
            int r2 = r2 * 53
            java.lang.Object r3 = com.google.android.gms.internal.clearcut.zzfd.zzo(r9, r5)
            java.lang.String r3 = (java.lang.String) r3
            int r3 = r3.hashCode()
            goto L_0x0129
        L_0x00f7:
            int r2 = r2 * 53
            boolean r3 = com.google.android.gms.internal.clearcut.zzfd.zzl(r9, r5)
        L_0x00fd:
            int r3 = com.google.android.gms.internal.clearcut.zzci.zzc(r3)
            goto L_0x0129
        L_0x0102:
            int r2 = r2 * 53
            int r3 = com.google.android.gms.internal.clearcut.zzfd.zzj(r9, r5)
            goto L_0x0129
        L_0x0109:
            int r2 = r2 * 53
            long r3 = com.google.android.gms.internal.clearcut.zzfd.zzk(r9, r5)
            goto L_0x0125
        L_0x0110:
            int r2 = r2 * 53
            float r3 = com.google.android.gms.internal.clearcut.zzfd.zzm(r9, r5)
        L_0x0116:
            int r3 = java.lang.Float.floatToIntBits(r3)
            goto L_0x0129
        L_0x011b:
            int r2 = r2 * 53
            double r3 = com.google.android.gms.internal.clearcut.zzfd.zzn(r9, r5)
        L_0x0121:
            long r3 = java.lang.Double.doubleToLongBits(r3)
        L_0x0125:
            int r3 = com.google.android.gms.internal.clearcut.zzci.zzl(r3)
        L_0x0129:
            int r2 = r2 + r3
        L_0x012a:
            int r1 = r1 + 4
            goto L_0x0005
        L_0x012e:
            int r2 = r2 * 53
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r8.zzmx
            java.lang.Object r0 = r0.zzq(r9)
            int r0 = r0.hashCode()
            int r2 = r2 + r0
            boolean r0 = r8.zzmo
            if (r0 == 0) goto L_0x014c
            int r2 = r2 * 53
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r8.zzmy
            com.google.android.gms.internal.clearcut.zzby r9 = r0.zza(r9)
            int r9 = r9.hashCode()
            int r2 = r2 + r9
        L_0x014c:
            return r2
            switch-data {0->0x011b, 1->0x0110, 2->0x0109, 3->0x0109, 4->0x0102, 5->0x0109, 6->0x0102, 7->0x00f7, 8->0x00ea, 9->0x00dc, 10->0x00d1, 11->0x0102, 12->0x0102, 13->0x0102, 14->0x0109, 15->0x0102, 16->0x0109, 17->0x00ca, 18->0x00d1, 19->0x00d1, 20->0x00d1, 21->0x00d1, 22->0x00d1, 23->0x00d1, 24->0x00d1, 25->0x00d1, 26->0x00d1, 27->0x00d1, 28->0x00d1, 29->0x00d1, 30->0x00d1, 31->0x00d1, 32->0x00d1, 33->0x00d1, 34->0x00d1, 35->0x00d1, 36->0x00d1, 37->0x00d1, 38->0x00d1, 39->0x00d1, 40->0x00d1, 41->0x00d1, 42->0x00d1, 43->0x00d1, 44->0x00d1, 45->0x00d1, 46->0x00d1, 47->0x00d1, 48->0x00d1, 49->0x00d1, 50->0x00d1, 51->0x00bd, 52->0x00b0, 53->0x00a2, 54->0x009b, 55->0x008d, 56->0x0086, 57->0x007f, 58->0x0071, 59->0x0069, 60->0x005b, 61->0x0053, 62->0x004c, 63->0x0045, 64->0x003e, 65->0x0036, 66->0x002f, 67->0x0027, 68->0x0020, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.hashCode(java.lang.Object):int");
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final T newInstance() {
        return this.zzmv.newInstance(this.zzmn);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:173:0x04b9  */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x04f6  */
    /* JADX WARNING: Removed duplicated region for block: B:351:0x0976  */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r14, com.google.android.gms.internal.clearcut.zzfr r15) throws java.io.IOException {
        /*
            r13 = this;
            int r0 = r15.zzaj()
            int r1 = com.google.android.gms.internal.clearcut.zzcg.zzg.zzkp
            r2 = 267386880(0xff00000, float:2.3665827E-29)
            r3 = 0
            r4 = 1
            r5 = 0
            r6 = 1048575(0xfffff, float:1.469367E-39)
            if (r0 != r1) goto L_0x04cf
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r13.zzmx
            zza(r0, r14, r15)
            boolean r0 = r13.zzmo
            if (r0 == 0) goto L_0x0030
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r13.zzmy
            com.google.android.gms.internal.clearcut.zzby r0 = r0.zza(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x0030
            java.util.Iterator r0 = r0.descendingIterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0032
        L_0x0030:
            r0 = r3
            r1 = r0
        L_0x0032:
            int[] r7 = r13.zzmi
            int r7 = r7.length
            int r7 = r7 + -4
        L_0x0037:
            if (r7 < 0) goto L_0x04b7
            int r8 = r13.zzag(r7)
            int[] r9 = r13.zzmi
            r9 = r9[r7]
        L_0x0041:
            if (r1 == 0) goto L_0x005f
            com.google.android.gms.internal.clearcut.zzbu<?> r10 = r13.zzmy
            int r10 = r10.zza(r1)
            if (r10 <= r9) goto L_0x005f
            com.google.android.gms.internal.clearcut.zzbu<?> r10 = r13.zzmy
            r10.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005d
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0041
        L_0x005d:
            r1 = r3
            goto L_0x0041
        L_0x005f:
            r10 = r8 & r2
            int r10 = r10 >>> 20
            switch(r10) {
                case 0: goto L_0x04a4;
                case 1: goto L_0x0494;
                case 2: goto L_0x0484;
                case 3: goto L_0x0474;
                case 4: goto L_0x0464;
                case 5: goto L_0x0454;
                case 6: goto L_0x0444;
                case 7: goto L_0x0433;
                case 8: goto L_0x0422;
                case 9: goto L_0x040d;
                case 10: goto L_0x03fa;
                case 11: goto L_0x03e9;
                case 12: goto L_0x03d8;
                case 13: goto L_0x03c7;
                case 14: goto L_0x03b6;
                case 15: goto L_0x03a5;
                case 16: goto L_0x0394;
                case 17: goto L_0x037f;
                case 18: goto L_0x036e;
                case 19: goto L_0x035d;
                case 20: goto L_0x034c;
                case 21: goto L_0x033b;
                case 22: goto L_0x032a;
                case 23: goto L_0x0319;
                case 24: goto L_0x0308;
                case 25: goto L_0x02f7;
                case 26: goto L_0x02e6;
                case 27: goto L_0x02d1;
                case 28: goto L_0x02c0;
                case 29: goto L_0x02af;
                case 30: goto L_0x029e;
                case 31: goto L_0x028d;
                case 32: goto L_0x027c;
                case 33: goto L_0x026b;
                case 34: goto L_0x025a;
                case 35: goto L_0x0249;
                case 36: goto L_0x0238;
                case 37: goto L_0x0227;
                case 38: goto L_0x0216;
                case 39: goto L_0x0205;
                case 40: goto L_0x01f4;
                case 41: goto L_0x01e3;
                case 42: goto L_0x01d2;
                case 43: goto L_0x01c1;
                case 44: goto L_0x01b0;
                case 45: goto L_0x019f;
                case 46: goto L_0x018e;
                case 47: goto L_0x017d;
                case 48: goto L_0x016c;
                case 49: goto L_0x0157;
                case 50: goto L_0x014c;
                case 51: goto L_0x013e;
                case 52: goto L_0x0130;
                case 53: goto L_0x0122;
                case 54: goto L_0x0114;
                case 55: goto L_0x0106;
                case 56: goto L_0x00f8;
                case 57: goto L_0x00ea;
                case 58: goto L_0x00dc;
                case 59: goto L_0x00d4;
                case 60: goto L_0x00cc;
                case 61: goto L_0x00c4;
                case 62: goto L_0x00b6;
                case 63: goto L_0x00a8;
                case 64: goto L_0x009a;
                case 65: goto L_0x008c;
                case 66: goto L_0x007e;
                case 67: goto L_0x0070;
                case 68: goto L_0x0068;
                default: goto L_0x0066;
            }
        L_0x0066:
            goto L_0x04b3
        L_0x0068:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            goto L_0x0385
        L_0x0070:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x03a0
        L_0x007e:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03b1
        L_0x008c:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x03c2
        L_0x009a:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03d3
        L_0x00a8:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03e4
        L_0x00b6:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x03f5
        L_0x00c4:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            goto L_0x0400
        L_0x00cc:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            goto L_0x0413
        L_0x00d4:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            goto L_0x0428
        L_0x00dc:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = zzi(r14, r10)
            goto L_0x043f
        L_0x00ea:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x0450
        L_0x00f8:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0460
        L_0x0106:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = zzg(r14, r10)
            goto L_0x0470
        L_0x0114:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0480
        L_0x0122:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = zzh(r14, r10)
            goto L_0x0490
        L_0x0130:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = zzf(r14, r10)
            goto L_0x04a0
        L_0x013e:
            boolean r10 = r13.zza(r14, r9, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = zze(r14, r10)
            goto L_0x04b0
        L_0x014c:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            r13.zza(r15, r9, r8, r7)
            goto L_0x04b3
        L_0x0157:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzef r10 = r13.zzad(r7)
            com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15, r10)
            goto L_0x04b3
        L_0x016c:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zze(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x017d:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzj(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x018e:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzg(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x019f:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzl(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01b0:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzm(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01c1:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzi(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01d2:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzn(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01e3:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzk(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x01f4:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzf(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0205:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzh(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0216:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzd(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0227:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzc(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0238:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x0249:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza(r9, r8, r15, r4)
            goto L_0x04b3
        L_0x025a:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zze(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x026b:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzj(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x027c:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzg(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x028d:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzl(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x029e:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzm(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x02af:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzi(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x02c0:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15)
            goto L_0x04b3
        L_0x02d1:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzef r10 = r13.zzad(r7)
            com.google.android.gms.internal.clearcut.zzeh.zza(r9, r8, r15, r10)
            goto L_0x04b3
        L_0x02e6:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza(r9, r8, r15)
            goto L_0x04b3
        L_0x02f7:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzn(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x0308:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzk(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x0319:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzf(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x032a:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzh(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x033b:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzd(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x034c:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzc(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x035d:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zzb(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x036e:
            int[] r9 = r13.zzmi
            r9 = r9[r7]
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            java.util.List r8 = (java.util.List) r8
            com.google.android.gms.internal.clearcut.zzeh.zza(r9, r8, r15, r5)
            goto L_0x04b3
        L_0x037f:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
        L_0x0385:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            com.google.android.gms.internal.clearcut.zzef r10 = r13.zzad(r7)
            r15.zzb(r9, r8, r10)
            goto L_0x04b3
        L_0x0394:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
        L_0x03a0:
            r15.zzb(r9, r10)
            goto L_0x04b3
        L_0x03a5:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
        L_0x03b1:
            r15.zze(r9, r8)
            goto L_0x04b3
        L_0x03b6:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
        L_0x03c2:
            r15.zzj(r9, r10)
            goto L_0x04b3
        L_0x03c7:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
        L_0x03d3:
            r15.zzm(r9, r8)
            goto L_0x04b3
        L_0x03d8:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
        L_0x03e4:
            r15.zzn(r9, r8)
            goto L_0x04b3
        L_0x03e9:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
        L_0x03f5:
            r15.zzd(r9, r8)
            goto L_0x04b3
        L_0x03fa:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
        L_0x0400:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            com.google.android.gms.internal.clearcut.zzbb r8 = (com.google.android.gms.internal.clearcut.zzbb) r8
            r15.zza(r9, r8)
            goto L_0x04b3
        L_0x040d:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
        L_0x0413:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            com.google.android.gms.internal.clearcut.zzef r10 = r13.zzad(r7)
            r15.zza(r9, r8, r10)
            goto L_0x04b3
        L_0x0422:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
        L_0x0428:
            r8 = r8 & r6
            long r10 = (long) r8
            java.lang.Object r8 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r10)
            zza(r9, r8, r15)
            goto L_0x04b3
        L_0x0433:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            boolean r8 = com.google.android.gms.internal.clearcut.zzfd.zzl(r14, r10)
        L_0x043f:
            r15.zzb(r9, r8)
            goto L_0x04b3
        L_0x0444:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
        L_0x0450:
            r15.zzf(r9, r8)
            goto L_0x04b3
        L_0x0454:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
        L_0x0460:
            r15.zzc(r9, r10)
            goto L_0x04b3
        L_0x0464:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            int r8 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r10)
        L_0x0470:
            r15.zzc(r9, r8)
            goto L_0x04b3
        L_0x0474:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
        L_0x0480:
            r15.zza(r9, r10)
            goto L_0x04b3
        L_0x0484:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            long r10 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r10)
        L_0x0490:
            r15.zzi(r9, r10)
            goto L_0x04b3
        L_0x0494:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            float r8 = com.google.android.gms.internal.clearcut.zzfd.zzm(r14, r10)
        L_0x04a0:
            r15.zza(r9, r8)
            goto L_0x04b3
        L_0x04a4:
            boolean r10 = r13.zza(r14, r7)
            if (r10 == 0) goto L_0x04b3
            r8 = r8 & r6
            long r10 = (long) r8
            double r10 = com.google.android.gms.internal.clearcut.zzfd.zzn(r14, r10)
        L_0x04b0:
            r15.zza(r9, r10)
        L_0x04b3:
            int r7 = r7 + -4
            goto L_0x0037
        L_0x04b7:
            if (r1 == 0) goto L_0x04ce
            com.google.android.gms.internal.clearcut.zzbu<?> r14 = r13.zzmy
            r14.zza(r15, r1)
            boolean r14 = r0.hasNext()
            if (r14 == 0) goto L_0x04cc
            java.lang.Object r14 = r0.next()
            java.util.Map$Entry r14 = (java.util.Map.Entry) r14
            r1 = r14
            goto L_0x04b7
        L_0x04cc:
            r1 = r3
            goto L_0x04b7
        L_0x04ce:
            return
        L_0x04cf:
            boolean r0 = r13.zzmq
            if (r0 == 0) goto L_0x0990
            boolean r0 = r13.zzmo
            if (r0 == 0) goto L_0x04ee
            com.google.android.gms.internal.clearcut.zzbu<?> r0 = r13.zzmy
            com.google.android.gms.internal.clearcut.zzby r0 = r0.zza(r14)
            boolean r1 = r0.isEmpty()
            if (r1 != 0) goto L_0x04ee
            java.util.Iterator r0 = r0.iterator()
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x04f0
        L_0x04ee:
            r0 = r3
            r1 = r0
        L_0x04f0:
            int[] r7 = r13.zzmi
            int r7 = r7.length
            r8 = 0
        L_0x04f4:
            if (r8 >= r7) goto L_0x0974
            int r9 = r13.zzag(r8)
            int[] r10 = r13.zzmi
            r10 = r10[r8]
        L_0x04fe:
            if (r1 == 0) goto L_0x051c
            com.google.android.gms.internal.clearcut.zzbu<?> r11 = r13.zzmy
            int r11 = r11.zza(r1)
            if (r11 > r10) goto L_0x051c
            com.google.android.gms.internal.clearcut.zzbu<?> r11 = r13.zzmy
            r11.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x051a
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x04fe
        L_0x051a:
            r1 = r3
            goto L_0x04fe
        L_0x051c:
            r11 = r9 & r2
            int r11 = r11 >>> 20
            switch(r11) {
                case 0: goto L_0x0961;
                case 1: goto L_0x0951;
                case 2: goto L_0x0941;
                case 3: goto L_0x0931;
                case 4: goto L_0x0921;
                case 5: goto L_0x0911;
                case 6: goto L_0x0901;
                case 7: goto L_0x08f0;
                case 8: goto L_0x08df;
                case 9: goto L_0x08ca;
                case 10: goto L_0x08b7;
                case 11: goto L_0x08a6;
                case 12: goto L_0x0895;
                case 13: goto L_0x0884;
                case 14: goto L_0x0873;
                case 15: goto L_0x0862;
                case 16: goto L_0x0851;
                case 17: goto L_0x083c;
                case 18: goto L_0x082b;
                case 19: goto L_0x081a;
                case 20: goto L_0x0809;
                case 21: goto L_0x07f8;
                case 22: goto L_0x07e7;
                case 23: goto L_0x07d6;
                case 24: goto L_0x07c5;
                case 25: goto L_0x07b4;
                case 26: goto L_0x07a3;
                case 27: goto L_0x078e;
                case 28: goto L_0x077d;
                case 29: goto L_0x076c;
                case 30: goto L_0x075b;
                case 31: goto L_0x074a;
                case 32: goto L_0x0739;
                case 33: goto L_0x0728;
                case 34: goto L_0x0717;
                case 35: goto L_0x0706;
                case 36: goto L_0x06f5;
                case 37: goto L_0x06e4;
                case 38: goto L_0x06d3;
                case 39: goto L_0x06c2;
                case 40: goto L_0x06b1;
                case 41: goto L_0x06a0;
                case 42: goto L_0x068f;
                case 43: goto L_0x067e;
                case 44: goto L_0x066d;
                case 45: goto L_0x065c;
                case 46: goto L_0x064b;
                case 47: goto L_0x063a;
                case 48: goto L_0x0629;
                case 49: goto L_0x0614;
                case 50: goto L_0x0609;
                case 51: goto L_0x05fb;
                case 52: goto L_0x05ed;
                case 53: goto L_0x05df;
                case 54: goto L_0x05d1;
                case 55: goto L_0x05c3;
                case 56: goto L_0x05b5;
                case 57: goto L_0x05a7;
                case 58: goto L_0x0599;
                case 59: goto L_0x0591;
                case 60: goto L_0x0589;
                case 61: goto L_0x0581;
                case 62: goto L_0x0573;
                case 63: goto L_0x0565;
                case 64: goto L_0x0557;
                case 65: goto L_0x0549;
                case 66: goto L_0x053b;
                case 67: goto L_0x052d;
                case 68: goto L_0x0525;
                default: goto L_0x0523;
            }
        L_0x0523:
            goto L_0x0970
        L_0x0525:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            goto L_0x0842
        L_0x052d:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x085d
        L_0x053b:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x086e
        L_0x0549:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x087f
        L_0x0557:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x0890
        L_0x0565:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x08a1
        L_0x0573:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x08b2
        L_0x0581:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            goto L_0x08bd
        L_0x0589:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            goto L_0x08d0
        L_0x0591:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            goto L_0x08e5
        L_0x0599:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = zzi(r14, r11)
            goto L_0x08fc
        L_0x05a7:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x090d
        L_0x05b5:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x091d
        L_0x05c3:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = zzg(r14, r11)
            goto L_0x092d
        L_0x05d1:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x093d
        L_0x05df:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = zzh(r14, r11)
            goto L_0x094d
        L_0x05ed:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = zzf(r14, r11)
            goto L_0x095d
        L_0x05fb:
            boolean r11 = r13.zza(r14, r10, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = zze(r14, r11)
            goto L_0x096d
        L_0x0609:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            r13.zza(r15, r10, r9, r8)
            goto L_0x0970
        L_0x0614:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzef r11 = r13.zzad(r8)
            com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15, r11)
            goto L_0x0970
        L_0x0629:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zze(r10, r9, r15, r4)
            goto L_0x0970
        L_0x063a:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzj(r10, r9, r15, r4)
            goto L_0x0970
        L_0x064b:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzg(r10, r9, r15, r4)
            goto L_0x0970
        L_0x065c:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzl(r10, r9, r15, r4)
            goto L_0x0970
        L_0x066d:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzm(r10, r9, r15, r4)
            goto L_0x0970
        L_0x067e:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzi(r10, r9, r15, r4)
            goto L_0x0970
        L_0x068f:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzn(r10, r9, r15, r4)
            goto L_0x0970
        L_0x06a0:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzk(r10, r9, r15, r4)
            goto L_0x0970
        L_0x06b1:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzf(r10, r9, r15, r4)
            goto L_0x0970
        L_0x06c2:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzh(r10, r9, r15, r4)
            goto L_0x0970
        L_0x06d3:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzd(r10, r9, r15, r4)
            goto L_0x0970
        L_0x06e4:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzc(r10, r9, r15, r4)
            goto L_0x0970
        L_0x06f5:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15, r4)
            goto L_0x0970
        L_0x0706:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza(r10, r9, r15, r4)
            goto L_0x0970
        L_0x0717:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zze(r10, r9, r15, r5)
            goto L_0x0970
        L_0x0728:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzj(r10, r9, r15, r5)
            goto L_0x0970
        L_0x0739:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzg(r10, r9, r15, r5)
            goto L_0x0970
        L_0x074a:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzl(r10, r9, r15, r5)
            goto L_0x0970
        L_0x075b:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzm(r10, r9, r15, r5)
            goto L_0x0970
        L_0x076c:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzi(r10, r9, r15, r5)
            goto L_0x0970
        L_0x077d:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15)
            goto L_0x0970
        L_0x078e:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzef r11 = r13.zzad(r8)
            com.google.android.gms.internal.clearcut.zzeh.zza(r10, r9, r15, r11)
            goto L_0x0970
        L_0x07a3:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza(r10, r9, r15)
            goto L_0x0970
        L_0x07b4:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzn(r10, r9, r15, r5)
            goto L_0x0970
        L_0x07c5:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzk(r10, r9, r15, r5)
            goto L_0x0970
        L_0x07d6:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzf(r10, r9, r15, r5)
            goto L_0x0970
        L_0x07e7:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzh(r10, r9, r15, r5)
            goto L_0x0970
        L_0x07f8:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzd(r10, r9, r15, r5)
            goto L_0x0970
        L_0x0809:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzc(r10, r9, r15, r5)
            goto L_0x0970
        L_0x081a:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zzb(r10, r9, r15, r5)
            goto L_0x0970
        L_0x082b:
            int[] r10 = r13.zzmi
            r10 = r10[r8]
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            java.util.List r9 = (java.util.List) r9
            com.google.android.gms.internal.clearcut.zzeh.zza(r10, r9, r15, r5)
            goto L_0x0970
        L_0x083c:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
        L_0x0842:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            com.google.android.gms.internal.clearcut.zzef r11 = r13.zzad(r8)
            r15.zzb(r10, r9, r11)
            goto L_0x0970
        L_0x0851:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
        L_0x085d:
            r15.zzb(r10, r11)
            goto L_0x0970
        L_0x0862:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
        L_0x086e:
            r15.zze(r10, r9)
            goto L_0x0970
        L_0x0873:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
        L_0x087f:
            r15.zzj(r10, r11)
            goto L_0x0970
        L_0x0884:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
        L_0x0890:
            r15.zzm(r10, r9)
            goto L_0x0970
        L_0x0895:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
        L_0x08a1:
            r15.zzn(r10, r9)
            goto L_0x0970
        L_0x08a6:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
        L_0x08b2:
            r15.zzd(r10, r9)
            goto L_0x0970
        L_0x08b7:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
        L_0x08bd:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            com.google.android.gms.internal.clearcut.zzbb r9 = (com.google.android.gms.internal.clearcut.zzbb) r9
            r15.zza(r10, r9)
            goto L_0x0970
        L_0x08ca:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
        L_0x08d0:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            com.google.android.gms.internal.clearcut.zzef r11 = r13.zzad(r8)
            r15.zza(r10, r9, r11)
            goto L_0x0970
        L_0x08df:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
        L_0x08e5:
            r9 = r9 & r6
            long r11 = (long) r9
            java.lang.Object r9 = com.google.android.gms.internal.clearcut.zzfd.zzo(r14, r11)
            zza(r10, r9, r15)
            goto L_0x0970
        L_0x08f0:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            boolean r9 = com.google.android.gms.internal.clearcut.zzfd.zzl(r14, r11)
        L_0x08fc:
            r15.zzb(r10, r9)
            goto L_0x0970
        L_0x0901:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
        L_0x090d:
            r15.zzf(r10, r9)
            goto L_0x0970
        L_0x0911:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
        L_0x091d:
            r15.zzc(r10, r11)
            goto L_0x0970
        L_0x0921:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            int r9 = com.google.android.gms.internal.clearcut.zzfd.zzj(r14, r11)
        L_0x092d:
            r15.zzc(r10, r9)
            goto L_0x0970
        L_0x0931:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
        L_0x093d:
            r15.zza(r10, r11)
            goto L_0x0970
        L_0x0941:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            long r11 = com.google.android.gms.internal.clearcut.zzfd.zzk(r14, r11)
        L_0x094d:
            r15.zzi(r10, r11)
            goto L_0x0970
        L_0x0951:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            float r9 = com.google.android.gms.internal.clearcut.zzfd.zzm(r14, r11)
        L_0x095d:
            r15.zza(r10, r9)
            goto L_0x0970
        L_0x0961:
            boolean r11 = r13.zza(r14, r8)
            if (r11 == 0) goto L_0x0970
            r9 = r9 & r6
            long r11 = (long) r9
            double r11 = com.google.android.gms.internal.clearcut.zzfd.zzn(r14, r11)
        L_0x096d:
            r15.zza(r10, r11)
        L_0x0970:
            int r8 = r8 + 4
            goto L_0x04f4
        L_0x0974:
            if (r1 == 0) goto L_0x098a
            com.google.android.gms.internal.clearcut.zzbu<?> r2 = r13.zzmy
            r2.zza(r15, r1)
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0988
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            goto L_0x0974
        L_0x0988:
            r1 = r3
            goto L_0x0974
        L_0x098a:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r0 = r13.zzmx
            zza(r0, r14, r15)
            return
        L_0x0990:
            r13.zzb(r14, r15)
            return
            switch-data {0->0x04a4, 1->0x0494, 2->0x0484, 3->0x0474, 4->0x0464, 5->0x0454, 6->0x0444, 7->0x0433, 8->0x0422, 9->0x040d, 10->0x03fa, 11->0x03e9, 12->0x03d8, 13->0x03c7, 14->0x03b6, 15->0x03a5, 16->0x0394, 17->0x037f, 18->0x036e, 19->0x035d, 20->0x034c, 21->0x033b, 22->0x032a, 23->0x0319, 24->0x0308, 25->0x02f7, 26->0x02e6, 27->0x02d1, 28->0x02c0, 29->0x02af, 30->0x029e, 31->0x028d, 32->0x027c, 33->0x026b, 34->0x025a, 35->0x0249, 36->0x0238, 37->0x0227, 38->0x0216, 39->0x0205, 40->0x01f4, 41->0x01e3, 42->0x01d2, 43->0x01c1, 44->0x01b0, 45->0x019f, 46->0x018e, 47->0x017d, 48->0x016c, 49->0x0157, 50->0x014c, 51->0x013e, 52->0x0130, 53->0x0122, 54->0x0114, 55->0x0106, 56->0x00f8, 57->0x00ea, 58->0x00dc, 59->0x00d4, 60->0x00cc, 61->0x00c4, 62->0x00b6, 63->0x00a8, 64->0x009a, 65->0x008c, 66->0x007e, 67->0x0070, 68->0x0068, }
            switch-data {0->0x0961, 1->0x0951, 2->0x0941, 3->0x0931, 4->0x0921, 5->0x0911, 6->0x0901, 7->0x08f0, 8->0x08df, 9->0x08ca, 10->0x08b7, 11->0x08a6, 12->0x0895, 13->0x0884, 14->0x0873, 15->0x0862, 16->0x0851, 17->0x083c, 18->0x082b, 19->0x081a, 20->0x0809, 21->0x07f8, 22->0x07e7, 23->0x07d6, 24->0x07c5, 25->0x07b4, 26->0x07a3, 27->0x078e, 28->0x077d, 29->0x076c, 30->0x075b, 31->0x074a, 32->0x0739, 33->0x0728, 34->0x0717, 35->0x0706, 36->0x06f5, 37->0x06e4, 38->0x06d3, 39->0x06c2, 40->0x06b1, 41->0x06a0, 42->0x068f, 43->0x067e, 44->0x066d, 45->0x065c, 46->0x064b, 47->0x063a, 48->0x0629, 49->0x0614, 50->0x0609, 51->0x05fb, 52->0x05ed, 53->0x05df, 54->0x05d1, 55->0x05c3, 56->0x05b5, 57->0x05a7, 58->0x0599, 59->0x0591, 60->0x0589, 61->0x0581, 62->0x0573, 63->0x0565, 64->0x0557, 65->0x0549, 66->0x053b, 67->0x052d, 68->0x0525, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, com.google.android.gms.internal.clearcut.zzfr):void");
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0069, code lost:
        if (r7 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00ce, code lost:
        if (r7 == 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d0, code lost:
        r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11);
        r1 = r11.zzfd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0164, code lost:
        if (r0 == r10) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:0x0188, code lost:
        if (r0 == r15) goto L_0x01a3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x01a1, code lost:
        if (r0 == r15) goto L_0x01a3;
     */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(T r23, byte[] r24, int r25, int r26, com.google.android.gms.internal.clearcut.zzay r27) throws java.io.IOException {
        /*
            r22 = this;
            r15 = r22
            r14 = r23
            r12 = r24
            r13 = r26
            r11 = r27
            boolean r0 = r15.zzmq
            if (r0 == 0) goto L_0x01ce
            sun.misc.Unsafe r9 = com.google.android.gms.internal.clearcut.zzds.zzmh
            r0 = r25
        L_0x0012:
            if (r0 >= r13) goto L_0x01c5
            int r1 = r0 + 1
            byte r0 = r12[r0]
            if (r0 >= 0) goto L_0x0024
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r0, r12, r1, r11)
            int r1 = r11.zzfd
            r10 = r0
            r16 = r1
            goto L_0x0027
        L_0x0024:
            r16 = r0
            r10 = r1
        L_0x0027:
            int r6 = r16 >>> 3
            r7 = r16 & 7
            int r8 = r15.zzai(r6)
            if (r8 < 0) goto L_0x01a5
            int[] r0 = r15.zzmi
            int r1 = r8 + 1
            r5 = r0[r1]
            r0 = 267386880(0xff00000, float:2.3665827E-29)
            r0 = r0 & r5
            int r4 = r0 >>> 20
            r0 = 1048575(0xfffff, float:1.469367E-39)
            r0 = r0 & r5
            long r2 = (long) r0
            r0 = 17
            r1 = 2
            if (r4 > r0) goto L_0x0106
            r0 = 5
            r6 = 1
            switch(r4) {
                case 0: goto L_0x00f9;
                case 1: goto L_0x00ec;
                case 2: goto L_0x00db;
                case 3: goto L_0x00db;
                case 4: goto L_0x00ce;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00b7;
                case 7: goto L_0x00a2;
                case 8: goto L_0x0091;
                case 9: goto L_0x0079;
                case 10: goto L_0x006d;
                case 11: goto L_0x00ce;
                case 12: goto L_0x0069;
                case 13: goto L_0x00b7;
                case 14: goto L_0x00c1;
                case 15: goto L_0x005b;
                case 16: goto L_0x004d;
                default: goto L_0x004b;
            }
        L_0x004b:
            goto L_0x01a5
        L_0x004d:
            if (r7 != 0) goto L_0x01a5
            int r6 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11)
            long r0 = r11.zzfe
            long r4 = com.google.android.gms.internal.clearcut.zzbk.zza(r0)
            goto L_0x00e3
        L_0x005b:
            if (r7 != 0) goto L_0x01a5
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11)
            int r1 = r11.zzfd
            int r1 = com.google.android.gms.internal.clearcut.zzbk.zzm(r1)
            goto L_0x00d6
        L_0x0069:
            if (r7 != 0) goto L_0x01a5
            goto L_0x00d0
        L_0x006d:
            if (r7 != r1) goto L_0x01a5
            int r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r10, r11)
        L_0x0073:
            java.lang.Object r1 = r11.zzff
        L_0x0075:
            r9.putObject(r14, r2, r1)
            goto L_0x0012
        L_0x0079:
            if (r7 != r1) goto L_0x01a5
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r8)
            int r0 = zza(r0, r12, r10, r13, r11)
            java.lang.Object r1 = r9.getObject(r14, r2)
            if (r1 != 0) goto L_0x008a
            goto L_0x0073
        L_0x008a:
            java.lang.Object r4 = r11.zzff
            java.lang.Object r1 = com.google.android.gms.internal.clearcut.zzci.zza(r1, r4)
            goto L_0x0075
        L_0x0091:
            if (r7 != r1) goto L_0x01a5
            r0 = 536870912(0x20000000, float:1.0842022E-19)
            r0 = r0 & r5
            if (r0 != 0) goto L_0x009d
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r10, r11)
            goto L_0x0073
        L_0x009d:
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r10, r11)
            goto L_0x0073
        L_0x00a2:
            if (r7 != 0) goto L_0x01a5
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11)
            long r4 = r11.zzfe
            r7 = 0
            int r1 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x00b1
            goto L_0x00b2
        L_0x00b1:
            r6 = 0
        L_0x00b2:
            com.google.android.gms.internal.clearcut.zzfd.zza(r14, r2, r6)
            goto L_0x0012
        L_0x00b7:
            if (r7 != r0) goto L_0x01a5
            int r0 = com.google.android.gms.internal.clearcut.zzax.zzc(r12, r10)
            r9.putInt(r14, r2, r0)
            goto L_0x00f5
        L_0x00c1:
            if (r7 != r6) goto L_0x01a5
            long r4 = com.google.android.gms.internal.clearcut.zzax.zzd(r12, r10)
            r0 = r9
            r1 = r23
            r0.putLong(r1, r2, r4)
            goto L_0x0102
        L_0x00ce:
            if (r7 != 0) goto L_0x01a5
        L_0x00d0:
            int r0 = com.google.android.gms.internal.clearcut.zzax.zza(r12, r10, r11)
            int r1 = r11.zzfd
        L_0x00d6:
            r9.putInt(r14, r2, r1)
            goto L_0x0012
        L_0x00db:
            if (r7 != 0) goto L_0x01a5
            int r6 = com.google.android.gms.internal.clearcut.zzax.zzb(r12, r10, r11)
            long r4 = r11.zzfe
        L_0x00e3:
            r0 = r9
            r1 = r23
            r0.putLong(r1, r2, r4)
            r0 = r6
            goto L_0x0012
        L_0x00ec:
            if (r7 != r0) goto L_0x01a5
            float r0 = com.google.android.gms.internal.clearcut.zzax.zzf(r12, r10)
            com.google.android.gms.internal.clearcut.zzfd.zza(r14, r2, r0)
        L_0x00f5:
            int r0 = r10 + 4
            goto L_0x0012
        L_0x00f9:
            if (r7 != r6) goto L_0x01a5
            double r0 = com.google.android.gms.internal.clearcut.zzax.zze(r12, r10)
            com.google.android.gms.internal.clearcut.zzfd.zza(r14, r2, r0)
        L_0x0102:
            int r0 = r10 + 8
            goto L_0x0012
        L_0x0106:
            r0 = 27
            if (r4 != r0) goto L_0x013e
            if (r7 != r1) goto L_0x01a5
            java.lang.Object r0 = r9.getObject(r14, r2)
            com.google.android.gms.internal.clearcut.zzcn r0 = (com.google.android.gms.internal.clearcut.zzcn) r0
            boolean r1 = r0.zzu()
            if (r1 != 0) goto L_0x012a
            int r1 = r0.size()
            if (r1 != 0) goto L_0x0121
            r1 = 10
            goto L_0x0123
        L_0x0121:
            int r1 = r1 << 1
        L_0x0123:
            com.google.android.gms.internal.clearcut.zzcn r0 = r0.zzi(r1)
            r9.putObject(r14, r2, r0)
        L_0x012a:
            r5 = r0
            com.google.android.gms.internal.clearcut.zzef r0 = r15.zzad(r8)
            r1 = r16
            r2 = r24
            r3 = r10
            r4 = r26
            r6 = r27
            int r0 = zza(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0012
        L_0x013e:
            r0 = 49
            if (r4 > r0) goto L_0x0167
            long r0 = (long) r5
            r17 = r0
            r0 = r22
            r1 = r23
            r19 = r2
            r2 = r24
            r3 = r10
            r5 = r4
            r4 = r26
            r25 = r5
            r5 = r16
            r21 = r9
            r15 = r10
            r9 = r17
            r11 = r25
            r12 = r19
            r14 = r27
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r11, r12, r14)
            if (r0 != r15) goto L_0x01b7
            goto L_0x01a3
        L_0x0167:
            r19 = r2
            r25 = r4
            r21 = r9
            r15 = r10
            r0 = 50
            r9 = r25
            if (r9 != r0) goto L_0x018b
            if (r7 != r1) goto L_0x01a8
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r15
            r4 = r26
            r5 = r8
            r7 = r19
            r9 = r27
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r9)
            if (r0 != r15) goto L_0x01b7
            goto L_0x01a3
        L_0x018b:
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r15
            r4 = r26
            r10 = r5
            r5 = r16
            r12 = r8
            r8 = r10
            r10 = r19
            r13 = r27
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12, r13)
            if (r0 != r15) goto L_0x01b7
        L_0x01a3:
            r2 = r0
            goto L_0x01a9
        L_0x01a5:
            r21 = r9
            r15 = r10
        L_0x01a8:
            r2 = r15
        L_0x01a9:
            r0 = r16
            r1 = r24
            r3 = r26
            r4 = r23
            r5 = r27
            int r0 = zza(r0, r1, r2, r3, r4, r5)
        L_0x01b7:
            r15 = r22
            r14 = r23
            r12 = r24
            r13 = r26
            r11 = r27
            r9 = r21
            goto L_0x0012
        L_0x01c5:
            r4 = r13
            if (r0 != r4) goto L_0x01c9
            return
        L_0x01c9:
            com.google.android.gms.internal.clearcut.zzco r0 = com.google.android.gms.internal.clearcut.zzco.zzbo()
            throw r0
        L_0x01ce:
            r4 = r13
            r5 = 0
            r0 = r22
            r1 = r23
            r2 = r24
            r3 = r25
            r4 = r26
            r6 = r27
            r0.zza(r1, r2, r3, r4, r5, r6)
            return
            switch-data {0->0x00f9, 1->0x00ec, 2->0x00db, 3->0x00db, 4->0x00ce, 5->0x00c1, 6->0x00b7, 7->0x00a2, 8->0x0091, 9->0x0079, 10->0x006d, 11->0x00ce, 12->0x0069, 13->0x00b7, 14->0x00c1, 15->0x005b, 16->0x004d, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zza(java.lang.Object, byte[], int, int, com.google.android.gms.internal.clearcut.zzay):void");
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t) {
        int[] iArr = this.zzmt;
        if (iArr != null) {
            for (int i : iArr) {
                long zzag = (long) (zzag(i) & 1048575);
                Object zzo = zzfd.zzo(t, zzag);
                if (zzo != null) {
                    zzfd.zza(t, zzag, this.zzmz.zzj(zzo));
                }
            }
        }
        int[] iArr2 = this.zzmu;
        if (iArr2 != null) {
            for (int i2 : iArr2) {
                this.zzmw.zza(t, (long) i2);
            }
        }
        this.zzmx.zzc(t);
        if (this.zzmo) {
            this.zzmy.zzc(t);
        }
    }

    @Override // com.google.android.gms.internal.clearcut.zzef
    public final void zzc(T t, T t2) {
        if (t2 != null) {
            for (int i = 0; i < this.zzmi.length; i += 4) {
                int zzag = zzag(i);
                long j = (long) (1048575 & zzag);
                int i2 = this.zzmi[i];
                switch ((zzag & 267386880) >>> 20) {
                    case 0:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzfd.zza(t, j, zzfd.zzn(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 1:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzfd.zza((Object) t, j, zzfd.zzm(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 2:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case 3:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case 4:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 5:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case 6:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 7:
                        if (!zza(t2, i)) {
                            break;
                        } else {
                            zzfd.zza(t, j, zzfd.zzl(t2, j));
                            zzb(t, i);
                            break;
                        }
                    case 8:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i);
                        break;
                    case 9:
                    case 17:
                        zza(t, t2, i);
                        break;
                    case 10:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i);
                        break;
                    case 11:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 12:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 13:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 14:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
                        break;
                    case 15:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzj(t2, j));
                        zzb(t, i);
                        break;
                    case 16:
                        if (!zza(t2, i)) {
                            break;
                        }
                        zzfd.zza((Object) t, j, zzfd.zzk(t2, j));
                        zzb(t, i);
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
                        this.zzmw.zza(t, t2, j);
                        break;
                    case 50:
                        zzeh.zza(this.zzmz, t, t2, j);
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
                        }
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i2, i);
                        break;
                    case 60:
                    case 68:
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
                        }
                        zzfd.zza(t, j, zzfd.zzo(t2, j));
                        zzb(t, i2, i);
                        break;
                }
            }
            if (!this.zzmq) {
                zzeh.zza(this.zzmx, t, t2);
                if (this.zzmo) {
                    zzeh.zza(this.zzmy, t, t2);
                    return;
                }
                return;
            }
            return;
        }
        throw null;
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01d8, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01e9, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01fa, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x020b, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x020d, code lost:
        r2.putInt(r20, (long) r14, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0211, code lost:
        r3 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r3) + com.google.android.gms.internal.clearcut.zzbn.zzt(r5)) + r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x0331, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x0334, code lost:
        r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, (java.lang.String) r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x0414, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x06b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x0434, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x06e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x043c, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x06ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x045c, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x0713;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x0464, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x0722;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x0474, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x0717;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x047c, code lost:
        if (zza(r20, r15, r5) != false) goto L_0x0749;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:272:0x0514, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:276:0x0526, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:280:0x0538, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:284:0x054a, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:288:0x055c, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:292:0x056e, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:296:0x0580, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:300:0x0592, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:304:0x05a3, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:308:0x05b4, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:312:0x05c5, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:316:0x05d6, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:320:0x05e7, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:324:0x05f8, code lost:
        if (r19.zzmr != false) goto L_0x05fa;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:325:0x05fa, code lost:
        r2.putInt(r20, (long) r9, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:326:0x05fe, code lost:
        r9 = (com.google.android.gms.internal.clearcut.zzbn.zzr(r15) + com.google.android.gms.internal.clearcut.zzbn.zzt(r4)) + r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:344:0x06b4, code lost:
        if ((r12 & r18) != 0) goto L_0x06b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:345:0x06b6, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzdo) r2.getObject(r20, r10), zzad(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:355:0x06e1, code lost:
        if ((r12 & r18) != 0) goto L_0x06e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:356:0x06e3, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, 0L);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:358:0x06ec, code lost:
        if ((r12 & r18) != 0) goto L_0x06ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:359:0x06ee, code lost:
        r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:370:0x0711, code lost:
        if ((r12 & r18) != 0) goto L_0x0713;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:371:0x0713, code lost:
        r4 = r2.getObject(r20, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:372:0x0717, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, (com.google.android.gms.internal.clearcut.zzbb) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:374:0x0720, code lost:
        if ((r12 & r18) != 0) goto L_0x0722;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:375:0x0722, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r2.getObject(r20, r10), zzad(r5));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:379:0x073a, code lost:
        if ((r4 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x0717;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ab, code lost:
        if ((r5 instanceof com.google.android.gms.internal.clearcut.zzbb) != false) goto L_0x030a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:380:0x073d, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, (java.lang.String) r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:382:0x0747, code lost:
        if ((r12 & r18) != 0) goto L_0x0749;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:383:0x0749, code lost:
        r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, true);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x0127, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0139, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x014b, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:74:0x015d, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x016f, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:82:0x0181, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0193, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x01a5, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x01b6, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01c7, code lost:
        if (r19.zzmr != false) goto L_0x020d;
     */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzm(T r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            boolean r2 = r0.zzmq
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            r4 = 0
            r7 = 1
            r8 = 1048575(0xfffff, float:1.469367E-39)
            r9 = 0
            r11 = 0
            if (r2 == 0) goto L_0x03b8
            sun.misc.Unsafe r2 = com.google.android.gms.internal.clearcut.zzds.zzmh
            r12 = 0
            r13 = 0
        L_0x0016:
            int[] r14 = r0.zzmi
            int r14 = r14.length
            if (r12 >= r14) goto L_0x03b0
            int r14 = r0.zzag(r12)
            r15 = r14 & r3
            int r15 = r15 >>> 20
            int[] r3 = r0.zzmi
            r3 = r3[r12]
            r14 = r14 & r8
            long r5 = (long) r14
            com.google.android.gms.internal.clearcut.zzcb r14 = com.google.android.gms.internal.clearcut.zzcb.DOUBLE_LIST_PACKED
            int r14 = r14.id()
            if (r15 < r14) goto L_0x0041
            com.google.android.gms.internal.clearcut.zzcb r14 = com.google.android.gms.internal.clearcut.zzcb.SINT64_LIST_PACKED
            int r14 = r14.id()
            if (r15 > r14) goto L_0x0041
            int[] r14 = r0.zzmi
            int r17 = r12 + 2
            r14 = r14[r17]
            r14 = r14 & r8
            goto L_0x0042
        L_0x0041:
            r14 = 0
        L_0x0042:
            switch(r15) {
                case 0: goto L_0x039c;
                case 1: goto L_0x0390;
                case 2: goto L_0x0380;
                case 3: goto L_0x0370;
                case 4: goto L_0x0360;
                case 5: goto L_0x0354;
                case 6: goto L_0x0348;
                case 7: goto L_0x033c;
                case 8: goto L_0x0325;
                case 9: goto L_0x0311;
                case 10: goto L_0x0300;
                case 11: goto L_0x02f1;
                case 12: goto L_0x02e2;
                case 13: goto L_0x02d7;
                case 14: goto L_0x02cc;
                case 15: goto L_0x02bd;
                case 16: goto L_0x02ae;
                case 17: goto L_0x0299;
                case 18: goto L_0x028e;
                case 19: goto L_0x0285;
                case 20: goto L_0x027c;
                case 21: goto L_0x0273;
                case 22: goto L_0x026a;
                case 23: goto L_0x028e;
                case 24: goto L_0x0285;
                case 25: goto L_0x0261;
                case 26: goto L_0x0258;
                case 27: goto L_0x024b;
                case 28: goto L_0x0242;
                case 29: goto L_0x0239;
                case 30: goto L_0x0230;
                case 31: goto L_0x0285;
                case 32: goto L_0x028e;
                case 33: goto L_0x0227;
                case 34: goto L_0x021d;
                case 35: goto L_0x01fd;
                case 36: goto L_0x01ec;
                case 37: goto L_0x01db;
                case 38: goto L_0x01ca;
                case 39: goto L_0x01b9;
                case 40: goto L_0x01a8;
                case 41: goto L_0x0197;
                case 42: goto L_0x0185;
                case 43: goto L_0x0173;
                case 44: goto L_0x0161;
                case 45: goto L_0x014f;
                case 46: goto L_0x013d;
                case 47: goto L_0x012b;
                case 48: goto L_0x0119;
                case 49: goto L_0x010b;
                case 50: goto L_0x00fb;
                case 51: goto L_0x00f3;
                case 52: goto L_0x00eb;
                case 53: goto L_0x00df;
                case 54: goto L_0x00d3;
                case 55: goto L_0x00c7;
                case 56: goto L_0x00bf;
                case 57: goto L_0x00b7;
                case 58: goto L_0x00af;
                case 59: goto L_0x009f;
                case 60: goto L_0x0097;
                case 61: goto L_0x008f;
                case 62: goto L_0x0083;
                case 63: goto L_0x0077;
                case 64: goto L_0x006f;
                case 65: goto L_0x0067;
                case 66: goto L_0x005b;
                case 67: goto L_0x004f;
                case 68: goto L_0x0047;
                default: goto L_0x0045;
            }
        L_0x0045:
            goto L_0x03aa
        L_0x0047:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            goto L_0x029f
        L_0x004f:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = zzh(r1, r5)
            goto L_0x02b8
        L_0x005b:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = zzg(r1, r5)
            goto L_0x02c7
        L_0x0067:
            boolean r5 = r0.zza(r1, r3, r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x02d2
        L_0x006f:
            boolean r5 = r0.zza(r1, r3, r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x02dd
        L_0x0077:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = zzg(r1, r5)
            goto L_0x02ec
        L_0x0083:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = zzg(r1, r5)
            goto L_0x02fb
        L_0x008f:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            goto L_0x0306
        L_0x0097:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            goto L_0x0317
        L_0x009f:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r6 == 0) goto L_0x0334
            goto L_0x0333
        L_0x00af:
            boolean r5 = r0.zza(r1, r3, r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x0342
        L_0x00b7:
            boolean r5 = r0.zza(r1, r3, r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x034e
        L_0x00bf:
            boolean r5 = r0.zza(r1, r3, r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x035a
        L_0x00c7:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = zzg(r1, r5)
            goto L_0x036a
        L_0x00d3:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = zzh(r1, r5)
            goto L_0x037a
        L_0x00df:
            boolean r14 = r0.zza(r1, r3, r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = zzh(r1, r5)
            goto L_0x038a
        L_0x00eb:
            boolean r5 = r0.zza(r1, r3, r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x0396
        L_0x00f3:
            boolean r5 = r0.zza(r1, r3, r12)
            if (r5 == 0) goto L_0x03aa
            goto L_0x03a2
        L_0x00fb:
            com.google.android.gms.internal.clearcut.zzdj r14 = r0.zzmz
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5)
            java.lang.Object r6 = r0.zzae(r12)
            int r3 = r14.zzb(r3, r5, r6)
            goto L_0x0296
        L_0x010b:
            java.util.List r5 = zzd(r1, r5)
            com.google.android.gms.internal.clearcut.zzef r6 = r0.zzad(r12)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzd(r3, r5, r6)
            goto L_0x0296
        L_0x0119:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzc(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x012b:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzg(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x013d:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzi(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x014f:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzh(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x0161:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzd(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x0173:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzf(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x0185:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzj(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x0197:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzh(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01a8:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzi(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01b9:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zze(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01ca:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzb(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01db:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zza(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01ec:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzh(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
            goto L_0x020d
        L_0x01fd:
            java.lang.Object r5 = r2.getObject(r1, r5)
            java.util.List r5 = (java.util.List) r5
            int r5 = com.google.android.gms.internal.clearcut.zzeh.zzi(r5)
            if (r5 <= 0) goto L_0x03aa
            boolean r6 = r0.zzmr
            if (r6 == 0) goto L_0x0211
        L_0x020d:
            long r14 = (long) r14
            r2.putInt(r1, r14, r5)
        L_0x0211:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzr(r3)
            int r6 = com.google.android.gms.internal.clearcut.zzbn.zzt(r5)
            int r3 = r3 + r6
            int r3 = r3 + r5
            goto L_0x0296
        L_0x021d:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzq(r3, r5, r11)
            goto L_0x0296
        L_0x0227:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzu(r3, r5, r11)
            goto L_0x0296
        L_0x0230:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzr(r3, r5, r11)
            goto L_0x0296
        L_0x0239:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzt(r3, r5, r11)
            goto L_0x0296
        L_0x0242:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzd(r3, r5)
            goto L_0x0296
        L_0x024b:
            java.util.List r5 = zzd(r1, r5)
            com.google.android.gms.internal.clearcut.zzef r6 = r0.zzad(r12)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzc(r3, r5, r6)
            goto L_0x0296
        L_0x0258:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzc(r3, r5)
            goto L_0x0296
        L_0x0261:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzx(r3, r5, r11)
            goto L_0x0296
        L_0x026a:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzs(r3, r5, r11)
            goto L_0x0296
        L_0x0273:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzp(r3, r5, r11)
            goto L_0x0296
        L_0x027c:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzo(r3, r5, r11)
            goto L_0x0296
        L_0x0285:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzv(r3, r5, r11)
            goto L_0x0296
        L_0x028e:
            java.util.List r5 = zzd(r1, r5)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzw(r3, r5, r11)
        L_0x0296:
            int r13 = r13 + r3
            goto L_0x03aa
        L_0x0299:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
        L_0x029f:
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5)
            com.google.android.gms.internal.clearcut.zzdo r5 = (com.google.android.gms.internal.clearcut.zzdo) r5
            com.google.android.gms.internal.clearcut.zzef r6 = r0.zzad(r12)
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, r5, r6)
            goto L_0x0296
        L_0x02ae:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r5)
        L_0x02b8:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzf(r3, r5)
            goto L_0x0296
        L_0x02bd:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r5)
        L_0x02c7:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzi(r3, r5)
            goto L_0x0296
        L_0x02cc:
            boolean r5 = r0.zza(r1, r12)
            if (r5 == 0) goto L_0x03aa
        L_0x02d2:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzh(r3, r9)
            goto L_0x0296
        L_0x02d7:
            boolean r5 = r0.zza(r1, r12)
            if (r5 == 0) goto L_0x03aa
        L_0x02dd:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzk(r3, r11)
            goto L_0x0296
        L_0x02e2:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r5)
        L_0x02ec:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzl(r3, r5)
            goto L_0x0296
        L_0x02f1:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r5)
        L_0x02fb:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzh(r3, r5)
            goto L_0x0296
        L_0x0300:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
        L_0x0306:
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5)
        L_0x030a:
            com.google.android.gms.internal.clearcut.zzbb r5 = (com.google.android.gms.internal.clearcut.zzbb) r5
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, r5)
            goto L_0x0296
        L_0x0311:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
        L_0x0317:
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5)
            com.google.android.gms.internal.clearcut.zzef r6 = r0.zzad(r12)
            int r3 = com.google.android.gms.internal.clearcut.zzeh.zzc(r3, r5, r6)
            goto L_0x0296
        L_0x0325:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
            java.lang.Object r5 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r5)
            boolean r6 = r5 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r6 == 0) goto L_0x0334
        L_0x0333:
            goto L_0x030a
        L_0x0334:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, r5)
            goto L_0x0296
        L_0x033c:
            boolean r5 = r0.zza(r1, r12)
            if (r5 == 0) goto L_0x03aa
        L_0x0342:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzc(r3, r7)
            goto L_0x0296
        L_0x0348:
            boolean r5 = r0.zza(r1, r12)
            if (r5 == 0) goto L_0x03aa
        L_0x034e:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzj(r3, r11)
            goto L_0x0296
        L_0x0354:
            boolean r5 = r0.zza(r1, r12)
            if (r5 == 0) goto L_0x03aa
        L_0x035a:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzg(r3, r9)
            goto L_0x0296
        L_0x0360:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
            int r5 = com.google.android.gms.internal.clearcut.zzfd.zzj(r1, r5)
        L_0x036a:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzg(r3, r5)
            goto L_0x0296
        L_0x0370:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r5)
        L_0x037a:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zze(r3, r5)
            goto L_0x0296
        L_0x0380:
            boolean r14 = r0.zza(r1, r12)
            if (r14 == 0) goto L_0x03aa
            long r5 = com.google.android.gms.internal.clearcut.zzfd.zzk(r1, r5)
        L_0x038a:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzd(r3, r5)
            goto L_0x0296
        L_0x0390:
            boolean r5 = r0.zza(r1, r12)
            if (r5 == 0) goto L_0x03aa
        L_0x0396:
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, r4)
            goto L_0x0296
        L_0x039c:
            boolean r5 = r0.zza(r1, r12)
            if (r5 == 0) goto L_0x03aa
        L_0x03a2:
            r5 = 0
            int r3 = com.google.android.gms.internal.clearcut.zzbn.zzb(r3, r5)
            goto L_0x0296
        L_0x03aa:
            int r12 = r12 + 4
            r3 = 267386880(0xff00000, float:2.3665827E-29)
            goto L_0x0016
        L_0x03b0:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r2 = r0.zzmx
            int r1 = zza(r2, r1)
            int r13 = r13 + r1
            return r13
        L_0x03b8:
            sun.misc.Unsafe r2 = com.google.android.gms.internal.clearcut.zzds.zzmh
            r3 = -1
            r5 = 0
            r6 = 0
            r12 = 0
        L_0x03be:
            int[] r13 = r0.zzmi
            int r13 = r13.length
            if (r5 >= r13) goto L_0x07bf
            int r13 = r0.zzag(r5)
            int[] r14 = r0.zzmi
            r15 = r14[r5]
            r16 = 267386880(0xff00000, float:2.3665827E-29)
            r17 = r13 & r16
            int r4 = r17 >>> 20
            r11 = 17
            if (r4 > r11) goto L_0x03e9
            int r11 = r5 + 2
            r11 = r14[r11]
            r14 = r11 & r8
            int r18 = r11 >>> 20
            int r18 = r7 << r18
            if (r14 == r3) goto L_0x03e7
            long r9 = (long) r14
            int r12 = r2.getInt(r1, r9)
            r3 = r14
        L_0x03e7:
            r9 = r11
            goto L_0x0408
        L_0x03e9:
            boolean r9 = r0.zzmr
            if (r9 == 0) goto L_0x0405
            com.google.android.gms.internal.clearcut.zzcb r9 = com.google.android.gms.internal.clearcut.zzcb.DOUBLE_LIST_PACKED
            int r9 = r9.id()
            if (r4 < r9) goto L_0x0405
            com.google.android.gms.internal.clearcut.zzcb r9 = com.google.android.gms.internal.clearcut.zzcb.SINT64_LIST_PACKED
            int r9 = r9.id()
            if (r4 > r9) goto L_0x0405
            int[] r9 = r0.zzmi
            int r10 = r5 + 2
            r9 = r9[r10]
            r9 = r9 & r8
            goto L_0x0406
        L_0x0405:
            r9 = 0
        L_0x0406:
            r18 = 0
        L_0x0408:
            r10 = r13 & r8
            long r10 = (long) r10
            switch(r4) {
                case 0: goto L_0x07a9;
                case 1: goto L_0x0799;
                case 2: goto L_0x0787;
                case 3: goto L_0x0777;
                case 4: goto L_0x0767;
                case 5: goto L_0x075b;
                case 6: goto L_0x074f;
                case 7: goto L_0x0745;
                case 8: goto L_0x0730;
                case 9: goto L_0x071e;
                case 10: goto L_0x070f;
                case 11: goto L_0x0702;
                case 12: goto L_0x06f5;
                case 13: goto L_0x06ea;
                case 14: goto L_0x06df;
                case 15: goto L_0x06d2;
                case 16: goto L_0x06c5;
                case 17: goto L_0x06b2;
                case 18: goto L_0x069e;
                case 19: goto L_0x0692;
                case 20: goto L_0x0686;
                case 21: goto L_0x067a;
                case 22: goto L_0x066e;
                case 23: goto L_0x069e;
                case 24: goto L_0x0692;
                case 25: goto L_0x0662;
                case 26: goto L_0x0657;
                case 27: goto L_0x0648;
                case 28: goto L_0x063d;
                case 29: goto L_0x0631;
                case 30: goto L_0x0624;
                case 31: goto L_0x0692;
                case 32: goto L_0x069e;
                case 33: goto L_0x0617;
                case 34: goto L_0x060a;
                case 35: goto L_0x05ea;
                case 36: goto L_0x05d9;
                case 37: goto L_0x05c8;
                case 38: goto L_0x05b7;
                case 39: goto L_0x05a6;
                case 40: goto L_0x0595;
                case 41: goto L_0x0584;
                case 42: goto L_0x0572;
                case 43: goto L_0x0560;
                case 44: goto L_0x054e;
                case 45: goto L_0x053c;
                case 46: goto L_0x052a;
                case 47: goto L_0x0518;
                case 48: goto L_0x0506;
                case 49: goto L_0x04f6;
                case 50: goto L_0x04e6;
                case 51: goto L_0x04d8;
                case 52: goto L_0x04cb;
                case 53: goto L_0x04bb;
                case 54: goto L_0x04ab;
                case 55: goto L_0x049b;
                case 56: goto L_0x048d;
                case 57: goto L_0x0480;
                case 58: goto L_0x0478;
                case 59: goto L_0x0468;
                case 60: goto L_0x0460;
                case 61: goto L_0x0458;
                case 62: goto L_0x044c;
                case 63: goto L_0x0440;
                case 64: goto L_0x0438;
                case 65: goto L_0x0430;
                case 66: goto L_0x0424;
                case 67: goto L_0x0418;
                case 68: goto L_0x0410;
                default: goto L_0x040e;
            }
        L_0x040e:
            goto L_0x06aa
        L_0x0410:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            goto L_0x06b6
        L_0x0418:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            long r9 = zzh(r1, r10)
            goto L_0x06cd
        L_0x0424:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            int r4 = zzg(r1, r10)
            goto L_0x06da
        L_0x0430:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            goto L_0x06e3
        L_0x0438:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            goto L_0x06ee
        L_0x0440:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            int r4 = zzg(r1, r10)
            goto L_0x06fd
        L_0x044c:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            int r4 = zzg(r1, r10)
            goto L_0x070a
        L_0x0458:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            goto L_0x0713
        L_0x0460:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            goto L_0x0722
        L_0x0468:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            java.lang.Object r4 = r2.getObject(r1, r10)
            boolean r9 = r4 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r9 == 0) goto L_0x073d
            goto L_0x073c
        L_0x0478:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            goto L_0x0749
        L_0x0480:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            r4 = 0
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzj(r15, r4)
            goto L_0x06f3
        L_0x048d:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            r9 = 0
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzg(r15, r9)
            goto L_0x06a9
        L_0x049b:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            int r4 = zzg(r1, r10)
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzg(r15, r4)
            goto L_0x06a9
        L_0x04ab:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            long r9 = zzh(r1, r10)
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zze(r15, r9)
            goto L_0x06a9
        L_0x04bb:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            long r9 = zzh(r1, r10)
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzd(r15, r9)
            goto L_0x06a9
        L_0x04cb:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            r4 = 0
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, r4)
            goto L_0x06f3
        L_0x04d8:
            boolean r4 = r0.zza(r1, r15, r5)
            if (r4 == 0) goto L_0x06aa
            r9 = 0
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, r9)
            goto L_0x06a9
        L_0x04e6:
            com.google.android.gms.internal.clearcut.zzdj r4 = r0.zzmz
            java.lang.Object r9 = r2.getObject(r1, r10)
            java.lang.Object r10 = r0.zzae(r5)
            int r4 = r4.zzb(r15, r9, r10)
            goto L_0x06a9
        L_0x04f6:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r5)
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r15, r4, r9)
            goto L_0x06a9
        L_0x0506:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x0518:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzg(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x052a:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzi(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x053c:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzh(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x054e:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x0560:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzf(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x0572:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzj(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x0584:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzh(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x0595:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzi(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x05a6:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zze(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x05b7:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzb(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x05c8:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zza(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x05d9:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzh(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
            goto L_0x05fa
        L_0x05ea:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzi(r4)
            if (r4 <= 0) goto L_0x06aa
            boolean r10 = r0.zzmr
            if (r10 == 0) goto L_0x05fe
        L_0x05fa:
            long r9 = (long) r9
            r2.putInt(r1, r9, r4)
        L_0x05fe:
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzr(r15)
            int r10 = com.google.android.gms.internal.clearcut.zzbn.zzt(r4)
            int r9 = r9 + r10
            int r9 = r9 + r4
            goto L_0x06f3
        L_0x060a:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            r9 = 0
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzq(r15, r4, r9)
            goto L_0x06a9
        L_0x0617:
            r9 = 0
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzu(r15, r4, r9)
            goto L_0x06a9
        L_0x0624:
            r9 = 0
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzr(r15, r4, r9)
            goto L_0x06a9
        L_0x0631:
            r9 = 0
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzt(r15, r4, r9)
            goto L_0x06a9
        L_0x063d:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzd(r15, r4)
            goto L_0x06a9
        L_0x0648:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r5)
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r4, r9)
            goto L_0x06a9
        L_0x0657:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r4)
            goto L_0x06a9
        L_0x0662:
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            r9 = 0
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzx(r15, r4, r9)
            goto L_0x06a9
        L_0x066e:
            r9 = 0
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzs(r15, r4, r9)
            goto L_0x06a9
        L_0x067a:
            r9 = 0
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzp(r15, r4, r9)
            goto L_0x06a9
        L_0x0686:
            r9 = 0
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzo(r15, r4, r9)
            goto L_0x06a9
        L_0x0692:
            r9 = 0
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzv(r15, r4, r9)
            goto L_0x06a9
        L_0x069e:
            r9 = 0
            java.lang.Object r4 = r2.getObject(r1, r10)
            java.util.List r4 = (java.util.List) r4
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzw(r15, r4, r9)
        L_0x06a9:
            int r6 = r6 + r4
        L_0x06aa:
            r4 = 0
        L_0x06ab:
            r9 = 0
            r10 = 0
            r13 = 0
            goto L_0x07b8
        L_0x06b2:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
        L_0x06b6:
            java.lang.Object r4 = r2.getObject(r1, r10)
            com.google.android.gms.internal.clearcut.zzdo r4 = (com.google.android.gms.internal.clearcut.zzdo) r4
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r5)
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, r4, r9)
            goto L_0x06a9
        L_0x06c5:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
            long r9 = r2.getLong(r1, r10)
        L_0x06cd:
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzf(r15, r9)
            goto L_0x06a9
        L_0x06d2:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
            int r4 = r2.getInt(r1, r10)
        L_0x06da:
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzi(r15, r4)
            goto L_0x06a9
        L_0x06df:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
        L_0x06e3:
            r9 = 0
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, r9)
            goto L_0x06a9
        L_0x06ea:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
        L_0x06ee:
            r4 = 0
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzk(r15, r4)
        L_0x06f3:
            int r6 = r6 + r9
            goto L_0x06aa
        L_0x06f5:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
            int r4 = r2.getInt(r1, r10)
        L_0x06fd:
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzl(r15, r4)
            goto L_0x06a9
        L_0x0702:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
            int r4 = r2.getInt(r1, r10)
        L_0x070a:
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzh(r15, r4)
            goto L_0x06a9
        L_0x070f:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
        L_0x0713:
            java.lang.Object r4 = r2.getObject(r1, r10)
        L_0x0717:
            com.google.android.gms.internal.clearcut.zzbb r4 = (com.google.android.gms.internal.clearcut.zzbb) r4
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, r4)
            goto L_0x06a9
        L_0x071e:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
        L_0x0722:
            java.lang.Object r4 = r2.getObject(r1, r10)
            com.google.android.gms.internal.clearcut.zzef r9 = r0.zzad(r5)
            int r4 = com.google.android.gms.internal.clearcut.zzeh.zzc(r15, r4, r9)
            goto L_0x06a9
        L_0x0730:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
            java.lang.Object r4 = r2.getObject(r1, r10)
            boolean r9 = r4 instanceof com.google.android.gms.internal.clearcut.zzbb
            if (r9 == 0) goto L_0x073d
        L_0x073c:
            goto L_0x0717
        L_0x073d:
            java.lang.String r4 = (java.lang.String) r4
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, r4)
            goto L_0x06a9
        L_0x0745:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
        L_0x0749:
            int r4 = com.google.android.gms.internal.clearcut.zzbn.zzc(r15, r7)
            goto L_0x06a9
        L_0x074f:
            r4 = r12 & r18
            if (r4 == 0) goto L_0x06aa
            r4 = 0
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzj(r15, r4)
            int r6 = r6 + r9
            goto L_0x06ab
        L_0x075b:
            r4 = 0
            r9 = r12 & r18
            r13 = 0
            if (r9 == 0) goto L_0x0797
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzg(r15, r13)
            goto L_0x0796
        L_0x0767:
            r4 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0797
            int r9 = r2.getInt(r1, r10)
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzg(r15, r9)
            goto L_0x0796
        L_0x0777:
            r4 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0797
            long r9 = r2.getLong(r1, r10)
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zze(r15, r9)
            goto L_0x0796
        L_0x0787:
            r4 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0797
            long r9 = r2.getLong(r1, r10)
            int r9 = com.google.android.gms.internal.clearcut.zzbn.zzd(r15, r9)
        L_0x0796:
            int r6 = r6 + r9
        L_0x0797:
            r9 = 0
            goto L_0x07a6
        L_0x0799:
            r4 = 0
            r13 = 0
            r9 = r12 & r18
            if (r9 == 0) goto L_0x0797
            r9 = 0
            int r10 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, r9)
            int r6 = r6 + r10
        L_0x07a6:
            r10 = 0
            goto L_0x07b8
        L_0x07a9:
            r4 = 0
            r9 = 0
            r13 = 0
            r10 = r12 & r18
            if (r10 == 0) goto L_0x07a6
            r10 = 0
            int r15 = com.google.android.gms.internal.clearcut.zzbn.zzb(r15, r10)
            int r6 = r6 + r15
        L_0x07b8:
            int r5 = r5 + 4
            r9 = r13
            r4 = 0
            r11 = 0
            goto L_0x03be
        L_0x07bf:
            com.google.android.gms.internal.clearcut.zzex<?, ?> r2 = r0.zzmx
            int r2 = zza(r2, r1)
            int r6 = r6 + r2
            boolean r2 = r0.zzmo
            if (r2 == 0) goto L_0x07d5
            com.google.android.gms.internal.clearcut.zzbu<?> r2 = r0.zzmy
            com.google.android.gms.internal.clearcut.zzby r1 = r2.zza(r1)
            int r1 = r1.zzas()
            int r6 = r6 + r1
        L_0x07d5:
            return r6
            switch-data {0->0x039c, 1->0x0390, 2->0x0380, 3->0x0370, 4->0x0360, 5->0x0354, 6->0x0348, 7->0x033c, 8->0x0325, 9->0x0311, 10->0x0300, 11->0x02f1, 12->0x02e2, 13->0x02d7, 14->0x02cc, 15->0x02bd, 16->0x02ae, 17->0x0299, 18->0x028e, 19->0x0285, 20->0x027c, 21->0x0273, 22->0x026a, 23->0x028e, 24->0x0285, 25->0x0261, 26->0x0258, 27->0x024b, 28->0x0242, 29->0x0239, 30->0x0230, 31->0x0285, 32->0x028e, 33->0x0227, 34->0x021d, 35->0x01fd, 36->0x01ec, 37->0x01db, 38->0x01ca, 39->0x01b9, 40->0x01a8, 41->0x0197, 42->0x0185, 43->0x0173, 44->0x0161, 45->0x014f, 46->0x013d, 47->0x012b, 48->0x0119, 49->0x010b, 50->0x00fb, 51->0x00f3, 52->0x00eb, 53->0x00df, 54->0x00d3, 55->0x00c7, 56->0x00bf, 57->0x00b7, 58->0x00af, 59->0x009f, 60->0x0097, 61->0x008f, 62->0x0083, 63->0x0077, 64->0x006f, 65->0x0067, 66->0x005b, 67->0x004f, 68->0x0047, }
            switch-data {0->0x07a9, 1->0x0799, 2->0x0787, 3->0x0777, 4->0x0767, 5->0x075b, 6->0x074f, 7->0x0745, 8->0x0730, 9->0x071e, 10->0x070f, 11->0x0702, 12->0x06f5, 13->0x06ea, 14->0x06df, 15->0x06d2, 16->0x06c5, 17->0x06b2, 18->0x069e, 19->0x0692, 20->0x0686, 21->0x067a, 22->0x066e, 23->0x069e, 24->0x0692, 25->0x0662, 26->0x0657, 27->0x0648, 28->0x063d, 29->0x0631, 30->0x0624, 31->0x0692, 32->0x069e, 33->0x0617, 34->0x060a, 35->0x05ea, 36->0x05d9, 37->0x05c8, 38->0x05b7, 39->0x05a6, 40->0x0595, 41->0x0584, 42->0x0572, 43->0x0560, 44->0x054e, 45->0x053c, 46->0x052a, 47->0x0518, 48->0x0506, 49->0x04f6, 50->0x04e6, 51->0x04d8, 52->0x04cb, 53->0x04bb, 54->0x04ab, 55->0x049b, 56->0x048d, 57->0x0480, 58->0x0478, 59->0x0468, 60->0x0460, 61->0x0458, 62->0x044c, 63->0x0440, 64->0x0438, 65->0x0430, 66->0x0424, 67->0x0418, 68->0x0410, }
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzm(java.lang.Object):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:80:0x0109 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x011d A[SYNTHETIC] */
    @Override // com.google.android.gms.internal.clearcut.zzef
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzo(T r17) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            int[] r2 = r0.zzms
            r3 = 1
            if (r2 == 0) goto L_0x0133
            int r4 = r2.length
            if (r4 != 0) goto L_0x000e
            goto L_0x0133
        L_0x000e:
            r4 = -1
            int r5 = r2.length
            r7 = 0
            r8 = 0
        L_0x0012:
            if (r7 >= r5) goto L_0x0121
            r9 = r2[r7]
            int r10 = r0.zzai(r9)
            int r11 = r0.zzag(r10)
            boolean r12 = r0.zzmq
            r13 = 1048575(0xfffff, float:1.469367E-39)
            if (r12 != 0) goto L_0x003f
            int[] r12 = r0.zzmi
            int r14 = r10 + 2
            r12 = r12[r14]
            r14 = r12 & r13
            int r12 = r12 >>> 20
            int r12 = r3 << r12
            if (r14 == r4) goto L_0x003d
            sun.misc.Unsafe r4 = com.google.android.gms.internal.clearcut.zzds.zzmh
            r15 = r7
            long r6 = (long) r14
            int r8 = r4.getInt(r1, r6)
            r4 = r14
            goto L_0x0041
        L_0x003d:
            r15 = r7
            goto L_0x0041
        L_0x003f:
            r15 = r7
            r12 = 0
        L_0x0041:
            r6 = 268435456(0x10000000, float:2.5243549E-29)
            r6 = r6 & r11
            if (r6 == 0) goto L_0x0048
            r6 = 1
            goto L_0x0049
        L_0x0048:
            r6 = 0
        L_0x0049:
            if (r6 == 0) goto L_0x0053
            boolean r6 = r0.zza(r1, r10, r8, r12)
            if (r6 != 0) goto L_0x0053
            r6 = 0
            return r6
        L_0x0053:
            r6 = 267386880(0xff00000, float:2.3665827E-29)
            r6 = r6 & r11
            int r6 = r6 >>> 20
            r7 = 9
            if (r6 == r7) goto L_0x010b
            r7 = 17
            if (r6 == r7) goto L_0x010b
            r7 = 27
            if (r6 == r7) goto L_0x00dd
            r7 = 60
            if (r6 == r7) goto L_0x00cb
            r7 = 68
            if (r6 == r7) goto L_0x00cb
            r7 = 49
            if (r6 == r7) goto L_0x00dd
            r7 = 50
            if (r6 == r7) goto L_0x0076
            goto L_0x011d
        L_0x0076:
            com.google.android.gms.internal.clearcut.zzdj r6 = r0.zzmz
            r7 = r11 & r13
            long r11 = (long) r7
            java.lang.Object r7 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r11)
            java.util.Map r6 = r6.zzh(r7)
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x00c6
            java.lang.Object r7 = r0.zzae(r10)
            com.google.android.gms.internal.clearcut.zzdj r9 = r0.zzmz
            com.google.android.gms.internal.clearcut.zzdh r7 = r9.zzl(r7)
            com.google.android.gms.internal.clearcut.zzfl r7 = r7.zzmd
            com.google.android.gms.internal.clearcut.zzfq r7 = r7.zzek()
            com.google.android.gms.internal.clearcut.zzfq r9 = com.google.android.gms.internal.clearcut.zzfq.MESSAGE
            if (r7 != r9) goto L_0x00c6
            r7 = 0
            java.util.Collection r6 = r6.values()
            java.util.Iterator r6 = r6.iterator()
        L_0x00a6:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x00c6
            java.lang.Object r9 = r6.next()
            if (r7 != 0) goto L_0x00be
            com.google.android.gms.internal.clearcut.zzea r7 = com.google.android.gms.internal.clearcut.zzea.zzcm()
            java.lang.Class r10 = r9.getClass()
            com.google.android.gms.internal.clearcut.zzef r7 = r7.zze(r10)
        L_0x00be:
            boolean r9 = r7.zzo(r9)
            if (r9 != 0) goto L_0x00a6
            r6 = 0
            goto L_0x00c7
        L_0x00c6:
            r6 = 1
        L_0x00c7:
            if (r6 != 0) goto L_0x011d
            r6 = 0
            return r6
        L_0x00cb:
            r6 = 0
            boolean r7 = r0.zza(r1, r9, r10)
            if (r7 == 0) goto L_0x011d
            com.google.android.gms.internal.clearcut.zzef r7 = r0.zzad(r10)
            boolean r7 = zza(r1, r11, r7)
            if (r7 != 0) goto L_0x011d
            return r6
        L_0x00dd:
            r6 = r11 & r13
            long r6 = (long) r6
            java.lang.Object r6 = com.google.android.gms.internal.clearcut.zzfd.zzo(r1, r6)
            java.util.List r6 = (java.util.List) r6
            boolean r7 = r6.isEmpty()
            if (r7 != 0) goto L_0x0106
            com.google.android.gms.internal.clearcut.zzef r7 = r0.zzad(r10)
            r9 = 0
        L_0x00f1:
            int r10 = r6.size()
            if (r9 >= r10) goto L_0x0106
            java.lang.Object r10 = r6.get(r9)
            boolean r10 = r7.zzo(r10)
            if (r10 != 0) goto L_0x0103
            r6 = 0
            goto L_0x0107
        L_0x0103:
            int r9 = r9 + 1
            goto L_0x00f1
        L_0x0106:
            r6 = 1
        L_0x0107:
            if (r6 != 0) goto L_0x011d
            r6 = 0
            return r6
        L_0x010b:
            r6 = 0
            boolean r7 = r0.zza(r1, r10, r8, r12)
            if (r7 == 0) goto L_0x011d
            com.google.android.gms.internal.clearcut.zzef r7 = r0.zzad(r10)
            boolean r7 = zza(r1, r11, r7)
            if (r7 != 0) goto L_0x011d
            return r6
        L_0x011d:
            int r7 = r15 + 1
            goto L_0x0012
        L_0x0121:
            boolean r2 = r0.zzmo
            if (r2 == 0) goto L_0x0133
            com.google.android.gms.internal.clearcut.zzbu<?> r2 = r0.zzmy
            com.google.android.gms.internal.clearcut.zzby r1 = r2.zza(r1)
            boolean r1 = r1.isInitialized()
            if (r1 != 0) goto L_0x0133
            r1 = 0
            return r1
        L_0x0133:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.clearcut.zzds.zzo(java.lang.Object):boolean");
    }
}
