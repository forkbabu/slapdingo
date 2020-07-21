package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzefe extends zzefc {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zziam;
    private int zzian;
    private int zziao;
    private int zziap;
    private int zziaq;

    private zzefe(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zziaq = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zziao = i;
        this.zziam = z;
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbdm() throws IOException {
        if (zzbec()) {
            this.zziap = 0;
            return 0;
        }
        int zzbee = zzbee();
        this.zziap = zzbee;
        if ((zzbee >>> 3) != 0) {
            return zzbee;
        }
        throw zzegl.zzbfx();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final void zzfx(int i) throws zzegl {
        if (this.zziap != i) {
            throw zzegl.zzbfy();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final boolean zzfy(int i) throws IOException {
        int zzbdm;
        int i2 = i & 7;
        int i3 = 0;
        if (i2 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i3 < 10) {
                    byte[] bArr = this.buffer;
                    int i4 = this.pos;
                    this.pos = i4 + 1;
                    if (bArr[i4] < 0) {
                        i3++;
                    }
                }
                throw zzegl.zzbfw();
            }
            while (i3 < 10) {
                if (zzbej() < 0) {
                    i3++;
                }
            }
            throw zzegl.zzbfw();
            return true;
        } else if (i2 == 1) {
            zzgc(8);
            return true;
        } else if (i2 == 2) {
            zzgc(zzbee());
            return true;
        } else if (i2 == 3) {
            do {
                zzbdm = zzbdm();
                if (zzbdm == 0) {
                    break;
                }
            } while (zzfy(zzbdm));
            zzfx(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzgc(4);
                return true;
            }
            throw zzegl.zzbfz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzbeh());
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzbeg());
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final long zzbdn() throws IOException {
        return zzbef();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final long zzbdo() throws IOException {
        return zzbef();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbdp() throws IOException {
        return zzbee();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final long zzbdq() throws IOException {
        return zzbeh();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbdr() throws IOException {
        return zzbeg();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final boolean zzbds() throws IOException {
        return zzbef() != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final String readString() throws IOException {
        int zzbee = zzbee();
        if (zzbee > 0 && zzbee <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzbee, zzegd.UTF_8);
            this.pos += zzbee;
            return str;
        } else if (zzbee == 0) {
            return "";
        } else {
            if (zzbee < 0) {
                throw zzegl.zzbfv();
            }
            throw zzegl.zzbfu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final String zzbdt() throws IOException {
        int zzbee = zzbee();
        if (zzbee > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzbee <= i - i2) {
                String zzo = zzeji.zzo(this.buffer, i2, zzbee);
                this.pos += zzbee;
                return zzo;
            }
        }
        if (zzbee == 0) {
            return "";
        }
        if (zzbee <= 0) {
            throw zzegl.zzbfv();
        }
        throw zzegl.zzbfu();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final zzeer zzbdu() throws IOException {
        byte[] bArr;
        int zzbee = zzbee();
        if (zzbee > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzbee <= i - i2) {
                zzeer zzi = zzeer.zzi(this.buffer, i2, zzbee);
                this.pos += zzbee;
                return zzi;
            }
        }
        if (zzbee == 0) {
            return zzeer.zzhzv;
        }
        if (zzbee > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzbee <= i3 - i4) {
                int i5 = zzbee + i4;
                this.pos = i5;
                bArr = Arrays.copyOfRange(this.buffer, i4, i5);
                return zzeer.zzv(bArr);
            }
        }
        if (zzbee > 0) {
            throw zzegl.zzbfu();
        } else if (zzbee == 0) {
            bArr = zzegd.zziab;
            return zzeer.zzv(bArr);
        } else {
            throw zzegl.zzbfv();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbdv() throws IOException {
        return zzbee();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbdw() throws IOException {
        return zzbee();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbdx() throws IOException {
        return zzbeg();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final long zzbdy() throws IOException {
        return zzbeh();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbdz() throws IOException {
        return zzgb(zzbee());
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final long zzbea() throws IOException {
        return zzfh(zzbef());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzbee() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzbeb()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefe.zzbee():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzbef() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.limit
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r2 = r3 ^ r5
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            r11.pos = r1
            return r2
        L_0x00b8:
            long r0 = r11.zzbeb()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefe.zzbef():long");
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzefc
    public final long zzbeb() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzbej = zzbej();
            j |= ((long) (zzbej & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzbej & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzegl.zzbfw();
    }

    private final int zzbeg() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        }
        throw zzegl.zzbfu();
    }

    private final long zzbeh() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzegl.zzbfu();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzfz(int i) throws zzegl {
        if (i >= 0) {
            int zzbed = i + zzbed();
            int i2 = this.zziaq;
            if (zzbed <= i2) {
                this.zziaq = zzbed;
                zzbei();
                return i2;
            }
            throw zzegl.zzbfu();
        }
        throw zzegl.zzbfv();
    }

    private final void zzbei() {
        int i = this.limit + this.zzian;
        this.limit = i;
        int i2 = i - this.zziao;
        int i3 = this.zziaq;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzian = i4;
            this.limit = i - i4;
            return;
        }
        this.zzian = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final void zzga(int i) {
        this.zziaq = i;
        zzbei();
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final boolean zzbec() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbed() {
        return this.pos - this.zziao;
    }

    private final byte zzbej() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzegl.zzbfu();
    }

    private final void zzgc(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzegl.zzbfv();
        }
        throw zzegl.zzbfu();
    }
}
