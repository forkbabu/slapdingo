package org.spongycastle.pqc.crypto.newhope;

import org.opencv.ml.DTrees;
import org.spongycastle.crypto.tls.CipherSuite;
import org.spongycastle.util.Arrays;

class ErrorCorrection {
    static int abs(int i) {
        int i2 = i >> 31;
        return (i ^ i2) - i2;
    }

    ErrorCorrection() {
    }

    static int f(int[] iArr, int i, int i2, int i3) {
        int i4 = (i3 * 2730) >> 25;
        int i5 = i4 - ((12288 - (i3 - (i4 * 12289))) >> 31);
        iArr[i] = (i5 >> 1) + (i5 & 1);
        int i6 = i5 - 1;
        iArr[i2] = (i6 >> 1) + (i6 & 1);
        return abs(i3 - ((iArr[i] * 2) * 12289));
    }

    static int g(int i) {
        int i2 = (i * 2730) >> 27;
        int i3 = i2 - ((CipherSuite.TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA - (i - (CipherSuite.TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA * i2))) >> 31);
        return abs((((i3 >> 1) + (i3 & 1)) * 98312) - i);
    }

    static void helpRec(short[] sArr, short[] sArr2, byte[] bArr, byte b) {
        byte[] bArr2 = new byte[8];
        bArr2[0] = b;
        byte[] bArr3 = new byte[32];
        ChaCha20.process(bArr, bArr2, bArr3, 0, 32);
        int[] iArr = new int[8];
        int[] iArr2 = new int[4];
        for (int i = 0; i < 256; i++) {
            int i2 = i + 0;
            int i3 = ((bArr3[i >>> 3] >>> (i & 7)) & 1) * 4;
            int i4 = i + 256;
            int i5 = i + 512;
            int f = f(iArr, 0, 4, (sArr2[i2] * 8) + i3) + f(iArr, 1, 5, (sArr2[i4] * 8) + i3) + f(iArr, 2, 6, (sArr2[i5] * 8) + i3);
            int i6 = i + DTrees.PREDICT_MASK;
            int f2 = (24577 - (f + f(iArr, 3, 7, (sArr2[i6] * 8) + i3))) >> 31;
            int i7 = ~f2;
            iArr2[0] = (i7 & iArr[0]) ^ (f2 & iArr[4]);
            iArr2[1] = (i7 & iArr[1]) ^ (f2 & iArr[5]);
            iArr2[2] = (i7 & iArr[2]) ^ (f2 & iArr[6]);
            iArr2[3] = (i7 & iArr[3]) ^ (iArr[7] & f2);
            sArr[i2] = (short) ((iArr2[0] - iArr2[3]) & 3);
            sArr[i4] = (short) ((iArr2[1] - iArr2[3]) & 3);
            sArr[i5] = (short) ((iArr2[2] - iArr2[3]) & 3);
            sArr[i6] = (short) (3 & ((-f2) + (iArr2[3] * 2)));
        }
    }

    static short LDDecode(int i, int i2, int i3, int i4) {
        return (short) (((((g(i) + g(i2)) + g(i3)) + g(i4)) - 98312) >>> 31);
    }

    static void rec(byte[] bArr, short[] sArr, short[] sArr2) {
        Arrays.fill(bArr, (byte) 0);
        int[] iArr = new int[4];
        for (int i = 0; i < 256; i++) {
            int i2 = i + 0;
            int i3 = i + DTrees.PREDICT_MASK;
            iArr[0] = ((sArr[i2] * 8) + 196624) - (((sArr2[i2] * 2) + sArr2[i3]) * 12289);
            int i4 = i + 256;
            iArr[1] = ((sArr[i4] * 8) + 196624) - (((sArr2[i4] * 2) + sArr2[i3]) * 12289);
            int i5 = i + 512;
            iArr[2] = ((sArr[i5] * 8) + 196624) - (((sArr2[i5] * 2) + sArr2[i3]) * 12289);
            iArr[3] = ((sArr[i3] * 8) + 196624) - (sArr2[i3] * 12289);
            int i6 = i >>> 3;
            bArr[i6] = (byte) ((LDDecode(iArr[0], iArr[1], iArr[2], iArr[3]) << (i & 7)) | bArr[i6]);
        }
    }
}
