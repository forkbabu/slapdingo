package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzefh extends zzefc {
    private final byte[] buffer;
    private int pos;
    private int zzajz;
    private int zzian;
    private int zziap;
    private int zziaq;
    private final InputStream zziar;
    private int zzias;
    private zzefg zziat;

    private zzefh(InputStream inputStream, int i) {
        super();
        this.zziaq = Integer.MAX_VALUE;
        this.zziat = null;
        zzegd.zza(inputStream, "input");
        this.zziar = inputStream;
        this.buffer = new byte[i];
        this.zzajz = 0;
        this.pos = 0;
        this.zzias = 0;
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
            if (this.zzajz - this.pos >= 10) {
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
        if (zzbee > 0 && zzbee <= this.zzajz - this.pos) {
            String str = new String(this.buffer, this.pos, zzbee, zzegd.UTF_8);
            this.pos += zzbee;
            return str;
        } else if (zzbee == 0) {
            return "";
        } else {
            if (zzbee > this.zzajz) {
                return new String(zzg(zzbee, false), zzegd.UTF_8);
            }
            zzgd(zzbee);
            String str2 = new String(this.buffer, this.pos, zzbee, zzegd.UTF_8);
            this.pos += zzbee;
            return str2;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final String zzbdt() throws IOException {
        byte[] bArr;
        int zzbee = zzbee();
        int i = this.pos;
        if (zzbee <= this.zzajz - i && zzbee > 0) {
            bArr = this.buffer;
            this.pos = i + zzbee;
        } else if (zzbee == 0) {
            return "";
        } else {
            if (zzbee <= this.zzajz) {
                zzgd(zzbee);
                bArr = this.buffer;
                this.pos = zzbee;
            } else {
                bArr = zzg(zzbee, false);
            }
            i = 0;
        }
        return zzeji.zzo(bArr, i, zzbee);
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final zzeer zzbdu() throws IOException {
        int zzbee = zzbee();
        int i = this.zzajz;
        int i2 = this.pos;
        if (zzbee <= i - i2 && zzbee > 0) {
            zzeer zzi = zzeer.zzi(this.buffer, i2, zzbee);
            this.pos += zzbee;
            return zzi;
        } else if (zzbee == 0) {
            return zzeer.zzhzv;
        } else {
            byte[] zzgf = zzgf(zzbee);
            if (zzgf != null) {
                return zzeer.zzu(zzgf);
            }
            int i3 = this.pos;
            int i4 = this.zzajz;
            int i5 = i4 - i3;
            this.zzias += i4;
            this.pos = 0;
            this.zzajz = 0;
            List<byte[]> zzgg = zzgg(zzbee - i5);
            byte[] bArr = new byte[zzbee];
            System.arraycopy(this.buffer, i3, bArr, 0, i5);
            for (byte[] bArr2 : zzgg) {
                System.arraycopy(bArr2, 0, bArr, i5, bArr2.length);
                i5 += bArr2.length;
            }
            return zzeer.zzv(bArr);
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
            int r1 = r5.zzajz
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefh.zzbee():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzbef() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.zzajz
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefh.zzbef():long");
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
        if (this.zzajz - i < 4) {
            zzgd(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    private final long zzbeh() throws IOException {
        int i = this.pos;
        if (this.zzajz - i < 8) {
            zzgd(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzfz(int i) throws zzegl {
        if (i >= 0) {
            int i2 = i + this.zzias + this.pos;
            int i3 = this.zziaq;
            if (i2 <= i3) {
                this.zziaq = i2;
                zzbei();
                return i3;
            }
            throw zzegl.zzbfu();
        }
        throw zzegl.zzbfv();
    }

    private final void zzbei() {
        int i = this.zzajz + this.zzian;
        this.zzajz = i;
        int i2 = this.zzias + i;
        int i3 = this.zziaq;
        if (i2 > i3) {
            int i4 = i2 - i3;
            this.zzian = i4;
            this.zzajz = i - i4;
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
        return this.pos == this.zzajz && !zzge(1);
    }

    @Override // com.google.android.gms.internal.ads.zzefc
    public final int zzbed() {
        return this.zzias + this.pos;
    }

    private final void zzgd(int i) throws IOException {
        if (zzge(i)) {
            return;
        }
        if (i > (this.zziaj - this.zzias) - this.pos) {
            throw zzegl.zzbga();
        }
        throw zzegl.zzbfu();
    }

    private final boolean zzge(int i) throws IOException {
        while (this.pos + i > this.zzajz) {
            int i2 = this.zziaj;
            int i3 = this.zzias;
            int i4 = this.pos;
            if (i > (i2 - i3) - i4 || i3 + i4 + i > this.zziaq) {
                return false;
            }
            if (i4 > 0) {
                int i5 = this.zzajz;
                if (i5 > i4) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.zzias += i4;
                this.zzajz -= i4;
                this.pos = 0;
            }
            InputStream inputStream = this.zziar;
            byte[] bArr2 = this.buffer;
            int i6 = this.zzajz;
            int read = inputStream.read(bArr2, i6, Math.min(bArr2.length - i6, (this.zziaj - this.zzias) - this.zzajz));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                String valueOf = String.valueOf(this.zziar.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzajz += read;
                zzbei();
                if (this.zzajz >= i) {
                    return true;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte zzbej() throws IOException {
        if (this.pos == this.zzajz) {
            zzgd(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzg(int i, boolean z) throws IOException {
        byte[] zzgf = zzgf(i);
        if (zzgf != null) {
            return zzgf;
        }
        int i2 = this.pos;
        int i3 = this.zzajz;
        int i4 = i3 - i2;
        this.zzias += i3;
        this.pos = 0;
        this.zzajz = 0;
        List<byte[]> zzgg = zzgg(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] bArr2 : zzgg) {
            System.arraycopy(bArr2, 0, bArr, i4, bArr2.length);
            i4 += bArr2.length;
        }
        return bArr;
    }

    private final byte[] zzgf(int i) throws IOException {
        if (i == 0) {
            return zzegd.zziab;
        }
        if (i >= 0) {
            int i2 = this.zzias + this.pos + i;
            if (i2 - this.zziaj <= 0) {
                int i3 = this.zziaq;
                if (i2 <= i3) {
                    int i4 = this.zzajz - this.pos;
                    int i5 = i - i4;
                    if (i5 >= 4096 && i5 > this.zziar.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
                    this.zzias += this.zzajz;
                    this.pos = 0;
                    this.zzajz = 0;
                    while (i4 < i) {
                        int read = this.zziar.read(bArr, i4, i - i4);
                        if (read != -1) {
                            this.zzias += read;
                            i4 += read;
                        } else {
                            throw zzegl.zzbfu();
                        }
                    }
                    return bArr;
                }
                zzgc((i3 - this.zzias) - this.pos);
                throw zzegl.zzbfu();
            }
            throw zzegl.zzbga();
        }
        throw zzegl.zzbfv();
    }

    private final List<byte[]> zzgg(int i) throws IOException {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            int min = Math.min(i, 4096);
            byte[] bArr = new byte[min];
            int i2 = 0;
            while (i2 < min) {
                int read = this.zziar.read(bArr, i2, min - i2);
                if (read != -1) {
                    this.zzias += read;
                    i2 += read;
                } else {
                    throw zzegl.zzbfu();
                }
            }
            i -= min;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzgc(int i) throws IOException {
        int i2 = this.zzajz;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
        } else if (i >= 0) {
            int i4 = this.zzias;
            int i5 = this.pos;
            int i6 = i4 + i5 + i;
            int i7 = this.zziaq;
            if (i6 <= i7) {
                this.zzias = i4 + i5;
                int i8 = this.zzajz - i5;
                this.zzajz = 0;
                this.pos = 0;
                while (i8 < i) {
                    try {
                        long j = (long) (i - i8);
                        long skip = this.zziar.skip(j);
                        int i9 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i9 >= 0 && skip <= j) {
                            if (i9 == 0) {
                                break;
                            }
                            i8 += (int) skip;
                        } else {
                            String valueOf = String.valueOf(this.zziar.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                    } catch (Throwable th) {
                        this.zzias += i8;
                        zzbei();
                        throw th;
                    }
                }
                this.zzias += i8;
                zzbei();
                if (i8 < i) {
                    int i10 = this.zzajz;
                    int i11 = i10 - this.pos;
                    this.pos = i10;
                    zzgd(1);
                    while (true) {
                        int i12 = i - i11;
                        int i13 = this.zzajz;
                        if (i12 > i13) {
                            i11 += i13;
                            this.pos = i13;
                            zzgd(1);
                        } else {
                            this.pos = i12;
                            return;
                        }
                    }
                }
            } else {
                zzgc((i7 - i4) - i5);
                throw zzegl.zzbfu();
            }
        } else {
            throw zzegl.zzbfv();
        }
    }
}
