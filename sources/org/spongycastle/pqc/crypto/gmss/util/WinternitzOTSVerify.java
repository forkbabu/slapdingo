package org.spongycastle.pqc.crypto.gmss.util;

import kotlin.UByte;
import org.spongycastle.crypto.Digest;

public class WinternitzOTSVerify {
    private Digest messDigestOTS;
    private int w;

    public int getLog(int i) {
        int i2 = 1;
        int i3 = 2;
        while (i3 < i) {
            i3 <<= 1;
            i2++;
        }
        return i2;
    }

    public WinternitzOTSVerify(Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
    }

    public int getSignatureLength() {
        int digestSize = this.messDigestOTS.getDigestSize();
        int i = this.w;
        int i2 = ((digestSize << 3) + (i - 1)) / i;
        int log = getLog((i2 << i) + 1);
        int i3 = this.w;
        return digestSize * (i2 + (((log + i3) - 1) / i3));
    }

    public byte[] Verify(byte[] bArr, byte[] bArr2) {
        int i;
        byte[] bArr3 = bArr2;
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        int i2 = 0;
        this.messDigestOTS.update(bArr, 0, bArr.length);
        int digestSize2 = this.messDigestOTS.getDigestSize();
        byte[] bArr5 = new byte[digestSize2];
        this.messDigestOTS.doFinal(bArr5, 0);
        int i3 = digestSize << 3;
        int i4 = this.w;
        int i5 = ((i4 - 1) + i3) / i4;
        int log = getLog((i5 << i4) + 1);
        int i6 = this.w;
        int i7 = ((((log + i6) - 1) / i6) + i5) * digestSize;
        if (i7 != bArr3.length) {
            return null;
        }
        byte[] bArr6 = new byte[i7];
        int i8 = 8;
        if (8 % i6 == 0) {
            int i9 = 8 / i6;
            int i10 = (1 << i6) - 1;
            byte[] bArr7 = new byte[digestSize];
            int i11 = 0;
            byte b = 0;
            int i12 = 0;
            while (i11 < digestSize2) {
                while (i2 < i9) {
                    byte b2 = bArr5[i11] & i10;
                    b += b2;
                    int i13 = i12 * digestSize;
                    System.arraycopy(bArr3, i13, bArr7, 0, digestSize);
                    int i14 = b2;
                    while (i14 < i10) {
                        this.messDigestOTS.update(bArr7, 0, bArr7.length);
                        bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr7, 0);
                        i14++;
                        b = b;
                        i7 = i7;
                    }
                    System.arraycopy(bArr7, 0, bArr6, i13, digestSize);
                    bArr5[i11] = (byte) (bArr5[i11] >>> this.w);
                    i12++;
                    i2++;
                    digestSize2 = digestSize2;
                    bArr3 = bArr2;
                    i9 = i9;
                }
                i11++;
                bArr3 = bArr2;
                i2 = 0;
            }
            i = i7;
            int i15 = (i5 << this.w) - b;
            int i16 = 0;
            while (i16 < log) {
                int i17 = i12 * digestSize;
                System.arraycopy(bArr2, i17, bArr7, 0, digestSize);
                for (int i18 = i15 & i10; i18 < i10; i18++) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                }
                System.arraycopy(bArr7, 0, bArr6, i17, digestSize);
                int i19 = this.w;
                i15 >>>= i19;
                i12++;
                i16 += i19;
            }
        } else {
            i = i7;
            if (i6 < 8) {
                int i20 = digestSize / i6;
                int i21 = (1 << i6) - 1;
                byte[] bArr8 = new byte[digestSize];
                int i22 = 0;
                int i23 = 0;
                int i24 = 0;
                int i25 = 0;
                while (i22 < i20) {
                    int i26 = 0;
                    long j = 0;
                    while (i26 < this.w) {
                        j ^= (long) ((bArr5[i23] & UByte.MAX_VALUE) << (i26 << 3));
                        i23++;
                        i26++;
                        bArr8 = bArr8;
                    }
                    int i27 = 0;
                    while (i27 < i8) {
                        int i28 = (int) (j & ((long) i21));
                        i24 += i28;
                        int i29 = i25 * digestSize;
                        System.arraycopy(bArr3, i29, bArr8, 0, digestSize);
                        while (i28 < i21) {
                            this.messDigestOTS.update(bArr8, 0, bArr8.length);
                            bArr8 = new byte[this.messDigestOTS.getDigestSize()];
                            this.messDigestOTS.doFinal(bArr8, 0);
                            i28++;
                            i20 = i20;
                            i23 = i23;
                        }
                        System.arraycopy(bArr8, 0, bArr6, i29, digestSize);
                        j >>>= this.w;
                        i25++;
                        i27++;
                        i22 = i22;
                        i8 = 8;
                    }
                    i22++;
                    i8 = 8;
                }
                int i30 = digestSize % this.w;
                long j2 = 0;
                for (int i31 = 0; i31 < i30; i31++) {
                    j2 ^= (long) ((bArr5[i23] & UByte.MAX_VALUE) << (i31 << 3));
                    i23++;
                }
                int i32 = i30 << 3;
                byte[] bArr9 = bArr8;
                int i33 = 0;
                while (i33 < i32) {
                    int i34 = (int) (j2 & ((long) i21));
                    i24 += i34;
                    int i35 = i25 * digestSize;
                    System.arraycopy(bArr3, i35, bArr9, 0, digestSize);
                    while (i34 < i21) {
                        this.messDigestOTS.update(bArr9, 0, bArr9.length);
                        bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr9, 0);
                        i34++;
                    }
                    System.arraycopy(bArr9, 0, bArr6, i35, digestSize);
                    int i36 = this.w;
                    j2 >>>= i36;
                    i25++;
                    i33 += i36;
                }
                int i37 = (i5 << this.w) - i24;
                int i38 = 0;
                while (i38 < log) {
                    int i39 = i25 * digestSize;
                    System.arraycopy(bArr3, i39, bArr9, 0, digestSize);
                    for (int i40 = i37 & i21; i40 < i21; i40++) {
                        this.messDigestOTS.update(bArr9, 0, bArr9.length);
                        bArr9 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr9, 0);
                    }
                    System.arraycopy(bArr9, 0, bArr6, i39, digestSize);
                    int i41 = this.w;
                    i37 >>>= i41;
                    i25++;
                    i38 += i41;
                }
            } else if (i6 < 57) {
                int i42 = i3 - i6;
                int i43 = (1 << i6) - 1;
                byte[] bArr10 = new byte[digestSize];
                int i44 = 0;
                int i45 = 0;
                int i46 = 0;
                while (i45 <= i42) {
                    int i47 = i45 >>> 3;
                    int i48 = i45 % 8;
                    int i49 = i45 + this.w;
                    int i50 = (i49 + 7) >>> 3;
                    int i51 = 0;
                    long j3 = 0;
                    while (i47 < i50) {
                        j3 ^= (long) ((bArr5[i47] & UByte.MAX_VALUE) << (i51 << 3));
                        i51++;
                        i47++;
                        i42 = i42;
                        log = log;
                        i5 = i5;
                    }
                    long j4 = (long) i43;
                    long j5 = (j3 >>> i48) & j4;
                    int i52 = i49;
                    i46 = (int) (((long) i46) + j5);
                    int i53 = i44 * digestSize;
                    System.arraycopy(bArr3, i53, bArr10, 0, digestSize);
                    while (j5 < j4) {
                        this.messDigestOTS.update(bArr10, 0, bArr10.length);
                        bArr10 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr10, 0);
                        j5++;
                        i52 = i52;
                        i46 = i46;
                    }
                    System.arraycopy(bArr10, 0, bArr6, i53, digestSize);
                    i44++;
                    i45 = i52;
                    i42 = i42;
                    log = log;
                    i5 = i5;
                }
                int i54 = i45 >>> 3;
                if (i54 < digestSize) {
                    int i55 = i45 % 8;
                    int i56 = 0;
                    long j6 = 0;
                    while (i54 < digestSize) {
                        j6 ^= (long) ((bArr5[i54] & UByte.MAX_VALUE) << (i56 << 3));
                        i56++;
                        i54++;
                    }
                    long j7 = (long) i43;
                    long j8 = (j6 >>> i55) & j7;
                    i46 = (int) (((long) i46) + j8);
                    int i57 = i44 * digestSize;
                    System.arraycopy(bArr3, i57, bArr10, 0, digestSize);
                    while (j8 < j7) {
                        this.messDigestOTS.update(bArr10, 0, bArr10.length);
                        bArr10 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr10, 0);
                        j8++;
                    }
                    System.arraycopy(bArr10, 0, bArr6, i57, digestSize);
                    i44++;
                }
                int i58 = (i5 << this.w) - i46;
                int i59 = 0;
                while (i59 < log) {
                    int i60 = i44 * digestSize;
                    System.arraycopy(bArr3, i60, bArr10, 0, digestSize);
                    for (long j9 = (long) (i58 & i43); j9 < ((long) i43); j9++) {
                        this.messDigestOTS.update(bArr10, 0, bArr10.length);
                        bArr10 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr10, 0);
                    }
                    System.arraycopy(bArr10, 0, bArr6, i60, digestSize);
                    int i61 = this.w;
                    i58 >>>= i61;
                    i44++;
                    i59 += i61;
                }
            }
        }
        byte[] bArr11 = new byte[digestSize];
        this.messDigestOTS.update(bArr6, 0, i);
        byte[] bArr12 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr12, 0);
        return bArr12;
    }
}
