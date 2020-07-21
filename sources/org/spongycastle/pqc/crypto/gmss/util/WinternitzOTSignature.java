package org.spongycastle.pqc.crypto.gmss.util;

import java.lang.reflect.Array;
import kotlin.UByte;
import org.spongycastle.crypto.Digest;

public class WinternitzOTSignature {
    private int checksumsize;
    private GMSSRandom gmssRandom;
    private int keysize;
    private int mdsize;
    private Digest messDigestOTS;
    private int messagesize;
    private byte[][] privateKeyOTS;
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

    public WinternitzOTSignature(byte[] bArr, Digest digest, int i) {
        this.w = i;
        this.messDigestOTS = digest;
        this.gmssRandom = new GMSSRandom(digest);
        int digestSize = this.messDigestOTS.getDigestSize();
        this.mdsize = digestSize;
        double d = (double) i;
        int ceil = (int) Math.ceil(((double) (digestSize << 3)) / d);
        this.messagesize = ceil;
        int log = getLog((ceil << i) + 1);
        this.checksumsize = log;
        int ceil2 = this.messagesize + ((int) Math.ceil(((double) log) / d));
        this.keysize = ceil2;
        int[] iArr = new int[2];
        iArr[1] = this.mdsize;
        iArr[0] = ceil2;
        this.privateKeyOTS = (byte[][]) Array.newInstance(byte.class, iArr);
        int i2 = this.mdsize;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, 0, bArr2, 0, i2);
        for (int i3 = 0; i3 < this.keysize; i3++) {
            this.privateKeyOTS[i3] = this.gmssRandom.nextSeed(bArr2);
        }
    }

    public byte[][] getPrivateKey() {
        return this.privateKeyOTS;
    }

    public byte[] getPublicKey() {
        int i = this.keysize;
        int i2 = this.mdsize;
        int i3 = i * i2;
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[i2];
        int i4 = 1 << this.w;
        for (int i5 = 0; i5 < this.keysize; i5++) {
            Digest digest = this.messDigestOTS;
            byte[][] bArr3 = this.privateKeyOTS;
            digest.update(bArr3[i5], 0, bArr3[i5].length);
            byte[] bArr4 = new byte[this.messDigestOTS.getDigestSize()];
            this.messDigestOTS.doFinal(bArr4, 0);
            for (int i6 = 2; i6 < i4; i6++) {
                this.messDigestOTS.update(bArr4, 0, bArr4.length);
                bArr4 = new byte[this.messDigestOTS.getDigestSize()];
                this.messDigestOTS.doFinal(bArr4, 0);
            }
            int i7 = this.mdsize;
            System.arraycopy(bArr4, 0, bArr, i7 * i5, i7);
        }
        this.messDigestOTS.update(bArr, 0, i3);
        byte[] bArr5 = new byte[this.messDigestOTS.getDigestSize()];
        this.messDigestOTS.doFinal(bArr5, 0);
        return bArr5;
    }

    public byte[] getSignature(byte[] bArr) {
        int i;
        int i2 = this.keysize;
        int i3 = this.mdsize;
        byte[] bArr2 = new byte[(i2 * i3)];
        byte[] bArr3 = new byte[i3];
        this.messDigestOTS.update(bArr, 0, bArr.length);
        int digestSize = this.messDigestOTS.getDigestSize();
        byte[] bArr4 = new byte[digestSize];
        this.messDigestOTS.doFinal(bArr4, 0);
        int i4 = this.w;
        int i5 = 8;
        if (8 % i4 == 0) {
            int i6 = 8 / i4;
            int i7 = (1 << i4) - 1;
            byte[] bArr5 = new byte[this.mdsize];
            int i8 = 0;
            int i9 = 0;
            for (int i10 = 0; i10 < digestSize; i10++) {
                for (int i11 = 0; i11 < i6; i11++) {
                    int i12 = bArr4[i10] & i7;
                    i8 += i12;
                    System.arraycopy(this.privateKeyOTS[i9], 0, bArr5, 0, this.mdsize);
                    while (i12 > 0) {
                        this.messDigestOTS.update(bArr5, 0, bArr5.length);
                        bArr5 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr5, 0);
                        i12--;
                    }
                    int i13 = this.mdsize;
                    System.arraycopy(bArr5, 0, bArr2, i9 * i13, i13);
                    bArr4[i10] = (byte) (bArr4[i10] >>> this.w);
                    i9++;
                }
            }
            int i14 = (this.messagesize << this.w) - i8;
            int i15 = 0;
            while (i15 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i9], 0, bArr5, 0, this.mdsize);
                for (int i16 = i14 & i7; i16 > 0; i16--) {
                    this.messDigestOTS.update(bArr5, 0, bArr5.length);
                    bArr5 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr5, 0);
                }
                int i17 = this.mdsize;
                System.arraycopy(bArr5, 0, bArr2, i9 * i17, i17);
                int i18 = this.w;
                i14 >>>= i18;
                i9++;
                i15 += i18;
            }
        } else if (i4 < 8) {
            int i19 = this.mdsize;
            int i20 = i19 / i4;
            int i21 = (1 << i4) - 1;
            byte[] bArr6 = new byte[i19];
            int i22 = 0;
            int i23 = 0;
            int i24 = 0;
            int i25 = 0;
            while (i22 < i20) {
                long j = 0;
                for (int i26 = 0; i26 < this.w; i26++) {
                    j ^= (long) ((bArr4[i23] & UByte.MAX_VALUE) << (i26 << 3));
                    i23++;
                }
                int i27 = 0;
                while (i27 < i5) {
                    int i28 = (int) (j & ((long) i21));
                    i25 += i28;
                    System.arraycopy(this.privateKeyOTS[i24], 0, bArr6, 0, this.mdsize);
                    while (i28 > 0) {
                        this.messDigestOTS.update(bArr6, 0, bArr6.length);
                        bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                        this.messDigestOTS.doFinal(bArr6, 0);
                        i28--;
                    }
                    int i29 = this.mdsize;
                    System.arraycopy(bArr6, 0, bArr2, i24 * i29, i29);
                    j >>>= this.w;
                    i24++;
                    i27++;
                    i20 = i20;
                    i5 = 8;
                }
                i22++;
                i5 = 8;
            }
            int i30 = this.mdsize % this.w;
            int i31 = 0;
            long j2 = 0;
            while (i31 < i30) {
                j2 ^= (long) ((bArr4[i23] & UByte.MAX_VALUE) << (i31 << 3));
                i23++;
                i31++;
                i30 = i30;
            }
            int i32 = i30 << 3;
            int i33 = 0;
            while (i33 < i32) {
                int i34 = (int) (((long) i21) & j2);
                i25 += i34;
                System.arraycopy(this.privateKeyOTS[i24], 0, bArr6, 0, this.mdsize);
                while (i34 > 0) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                    i34--;
                }
                int i35 = this.mdsize;
                System.arraycopy(bArr6, 0, bArr2, i24 * i35, i35);
                int i36 = this.w;
                j2 >>>= i36;
                i24++;
                i33 += i36;
            }
            int i37 = (this.messagesize << this.w) - i25;
            int i38 = 0;
            while (i38 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i24], 0, bArr6, 0, this.mdsize);
                for (int i39 = i37 & i21; i39 > 0; i39--) {
                    this.messDigestOTS.update(bArr6, 0, bArr6.length);
                    bArr6 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr6, 0);
                }
                int i40 = this.mdsize;
                System.arraycopy(bArr6, 0, bArr2, i24 * i40, i40);
                int i41 = this.w;
                i37 >>>= i41;
                i24++;
                i38 += i41;
            }
        } else if (i4 < 57) {
            int i42 = this.mdsize;
            int i43 = (i42 << 3) - i4;
            int i44 = (1 << i4) - 1;
            byte[] bArr7 = new byte[i42];
            int i45 = 0;
            int i46 = 0;
            int i47 = 0;
            while (i46 <= i43) {
                int i48 = i46 % 8;
                i46 += this.w;
                int i49 = (i46 + 7) >>> 3;
                int i50 = 0;
                long j3 = 0;
                for (int i51 = i46 >>> 3; i51 < i49; i51++) {
                    j3 ^= (long) ((bArr4[i51] & UByte.MAX_VALUE) << (i50 << 3));
                    i50++;
                }
                long j4 = (j3 >>> i48) & ((long) i44);
                i45 = (int) (((long) i45) + j4);
                System.arraycopy(this.privateKeyOTS[i47], 0, bArr7, 0, this.mdsize);
                while (j4 > 0) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                    j4--;
                }
                int i52 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i47 * i52, i52);
                i47++;
            }
            int i53 = i46 >>> 3;
            if (i53 < this.mdsize) {
                int i54 = i46 % 8;
                int i55 = 0;
                long j5 = 0;
                while (true) {
                    i = this.mdsize;
                    if (i53 >= i) {
                        break;
                    }
                    j5 ^= (long) ((bArr4[i53] & UByte.MAX_VALUE) << (i55 << 3));
                    i55++;
                    i53++;
                }
                long j6 = (j5 >>> i54) & ((long) i44);
                i45 = (int) (((long) i45) + j6);
                System.arraycopy(this.privateKeyOTS[i47], 0, bArr7, 0, i);
                while (j6 > 0) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                    j6--;
                }
                int i56 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i47 * i56, i56);
                i47++;
            }
            int i57 = (this.messagesize << this.w) - i45;
            int i58 = i47;
            int i59 = 0;
            while (i59 < this.checksumsize) {
                System.arraycopy(this.privateKeyOTS[i58], 0, bArr7, 0, this.mdsize);
                for (long j7 = (long) (i57 & i44); j7 > 0; j7--) {
                    this.messDigestOTS.update(bArr7, 0, bArr7.length);
                    bArr7 = new byte[this.messDigestOTS.getDigestSize()];
                    this.messDigestOTS.doFinal(bArr7, 0);
                }
                int i60 = this.mdsize;
                System.arraycopy(bArr7, 0, bArr2, i58 * i60, i60);
                int i61 = this.w;
                i57 >>>= i61;
                i58++;
                i59 += i61;
            }
        }
        return bArr2;
    }
}
