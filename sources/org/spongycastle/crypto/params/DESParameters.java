package org.spongycastle.crypto.params;

import com.itextpdf.text.pdf.BidiOrder;

public class DESParameters extends KeyParameter {
    public static final int DES_KEY_LENGTH = 8;
    private static byte[] DES_weak_keys = {1, 1, 1, 1, 1, 1, 1, 1, 31, 31, 31, 31, BidiOrder.BN, BidiOrder.BN, BidiOrder.BN, BidiOrder.BN, -32, -32, -32, -32, -15, -15, -15, -15, -2, -2, -2, -2, -2, -2, -2, -2, 1, -2, 1, -2, 1, -2, 1, -2, 31, -32, 31, -32, BidiOrder.BN, -15, BidiOrder.BN, -15, 1, -32, 1, -32, 1, -15, 1, -15, 31, -2, 31, -2, BidiOrder.BN, -2, BidiOrder.BN, -2, 1, 31, 1, 31, 1, BidiOrder.BN, 1, BidiOrder.BN, -32, -2, -32, -2, -15, -2, -15, -2, -2, 1, -2, 1, -2, 1, -2, 1, -32, 31, -32, 31, -15, BidiOrder.BN, -15, BidiOrder.BN, -32, 1, -32, 1, -15, 1, -15, 1, -2, 31, -2, 31, -2, BidiOrder.BN, -2, BidiOrder.BN, 31, 1, 31, 1, BidiOrder.BN, 1, BidiOrder.BN, 1, -2, -32, -2, -32, -2, -15, -2, -15};
    private static final int N_DES_WEAK_KEYS = 16;

    public DESParameters(byte[] bArr) {
        super(bArr);
        if (isWeakKey(bArr, 0)) {
            throw new IllegalArgumentException("attempt to create weak DES key");
        }
    }

    public static boolean isWeakKey(byte[] bArr, int i) {
        if (bArr.length - i >= 8) {
            int i2 = 0;
            while (i2 < 16) {
                int i3 = 0;
                while (i3 < 8) {
                    if (bArr[i3 + i] != DES_weak_keys[(i2 * 8) + i3]) {
                        i2++;
                    } else {
                        i3++;
                    }
                }
                return true;
            }
            return false;
        }
        throw new IllegalArgumentException("key material too short.");
    }

    public static void setOddParity(byte[] bArr) {
        for (int i = 0; i < bArr.length; i++) {
            byte b = bArr[i];
            bArr[i] = (byte) (((((b >> 7) ^ ((((((b >> 1) ^ (b >> 2)) ^ (b >> 3)) ^ (b >> 4)) ^ (b >> 5)) ^ (b >> 6))) ^ 1) & 1) | (b & 254));
        }
    }
}
