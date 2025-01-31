package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.Arrays;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzga extends zzfy {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzsz;
    private int zzta;
    private int zztb;
    private int zztc;
    private int zztd;

    private zzga(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zztd = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zztb = i;
        this.zzsz = z;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzey() throws IOException {
        if (zzdu()) {
            this.zztc = 0;
            return 0;
        }
        int zzfb = zzfb();
        this.zztc = zzfb;
        if ((zzfb >>> 3) != 0) {
            return zzfb;
        }
        throw zzhh.zzgq();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final void zzar(int i) throws zzhh {
        if (this.zztc != i) {
            throw zzhh.zzgr();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final boolean zzas(int i) throws IOException {
        int zzey;
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
                throw zzhh.zzgp();
            }
            while (i3 < 10) {
                if (zzfg() < 0) {
                    i3++;
                }
            }
            throw zzhh.zzgp();
            return true;
        } else if (i2 == 1) {
            zzaw(8);
            return true;
        } else if (i2 == 2) {
            zzaw(zzfb());
            return true;
        } else if (i2 == 3) {
            do {
                zzey = zzey();
                if (zzey == 0) {
                    break;
                }
            } while (zzas(zzey));
            zzar(((i >>> 3) << 3) | 4);
            return true;
        } else if (i2 == 4) {
            return false;
        } else {
            if (i2 == 5) {
                zzaw(4);
                return true;
            }
            throw zzhh.zzgs();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzfe());
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzfd());
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzdx() throws IOException {
        return zzfc();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzdy() throws IOException {
        return zzfc();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzdz() throws IOException {
        return zzfb();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzea() throws IOException {
        return zzfe();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzeb() throws IOException {
        return zzfd();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final boolean zzec() throws IOException {
        return zzfc() != 0;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final String readString() throws IOException {
        int zzfb = zzfb();
        if (zzfb > 0 && zzfb <= this.limit - this.pos) {
            String str = new String(this.buffer, this.pos, zzfb, zzgy.UTF_8);
            this.pos += zzfb;
            return str;
        } else if (zzfb == 0) {
            return "";
        } else {
            if (zzfb < 0) {
                throw zzhh.zzgo();
            }
            throw zzhh.zzgn();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final String zzed() throws IOException {
        int zzfb = zzfb();
        if (zzfb > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzfb <= i - i2) {
                String zzh = zzjx.zzh(this.buffer, i2, zzfb);
                this.pos += zzfb;
                return zzh;
            }
        }
        if (zzfb == 0) {
            return "";
        }
        if (zzfb <= 0) {
            throw zzhh.zzgo();
        }
        throw zzhh.zzgn();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final zzfm zzee() throws IOException {
        byte[] bArr;
        int zzfb = zzfb();
        if (zzfb > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzfb <= i - i2) {
                zzfm zza = zzfm.zza(this.buffer, i2, zzfb);
                this.pos += zzfb;
                return zza;
            }
        }
        if (zzfb == 0) {
            return zzfm.zzsm;
        }
        if (zzfb > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzfb <= i3 - i4) {
                int i5 = zzfb + i4;
                this.pos = i5;
                bArr = Arrays.copyOfRange(this.buffer, i4, i5);
                return zzfm.zzd(bArr);
            }
        }
        if (zzfb > 0) {
            throw zzhh.zzgn();
        } else if (zzfb == 0) {
            bArr = zzgy.zzxr;
            return zzfm.zzd(bArr);
        } else {
            throw zzhh.zzgo();
        }
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzef() throws IOException {
        return zzfb();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzeg() throws IOException {
        return zzfb();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzeh() throws IOException {
        return zzfd();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzei() throws IOException {
        return zzfe();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzej() throws IOException {
        return zzav(zzfb());
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzek() throws IOException {
        return zzr(zzfc());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzfb() throws java.io.IOException {
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
            long r0 = r5.zzez()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzga.zzfb():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzfc() throws java.io.IOException {
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
            long r0 = r11.zzez()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzga.zzfc():long");
    }

    /* access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.vision.zzfy
    public final long zzez() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzfg = zzfg();
            j |= ((long) (zzfg & ByteCompanionObject.MAX_VALUE)) << i;
            if ((zzfg & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzhh.zzgp();
    }

    private final int zzfd() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
        }
        throw zzhh.zzgn();
    }

    private final long zzfe() throws IOException {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzhh.zzgn();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzat(int i) throws zzhh {
        if (i >= 0) {
            int zzfa = i + zzfa();
            int i2 = this.zztd;
            if (zzfa <= i2) {
                this.zztd = zzfa;
                zzff();
                return i2;
            }
            throw zzhh.zzgn();
        }
        throw zzhh.zzgo();
    }

    private final void zzff() {
        int i = this.limit + this.zzta;
        this.limit = i;
        int i2 = i - this.zztb;
        int i3 = this.zztd;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzta = i4;
            this.limit = i - i4;
            return;
        }
        this.zzta = 0;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final void zzau(int i) {
        this.zztd = i;
        zzff();
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final boolean zzdu() throws IOException {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.vision.zzfy
    public final int zzfa() {
        return this.pos - this.zztb;
    }

    private final byte zzfg() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzhh.zzgn();
    }

    private final void zzaw(int i) throws IOException {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzhh.zzgo();
        }
        throw zzhh.zzgn();
    }
}
