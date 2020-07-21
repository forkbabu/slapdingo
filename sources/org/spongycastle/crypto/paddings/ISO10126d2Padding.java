package org.spongycastle.crypto.paddings;

import java.security.SecureRandom;
import kotlin.UByte;
import org.spongycastle.crypto.InvalidCipherTextException;

public class ISO10126d2Padding implements BlockCipherPadding {
    SecureRandom random;

    @Override // org.spongycastle.crypto.paddings.BlockCipherPadding
    public String getPaddingName() {
        return "ISO10126-2";
    }

    @Override // org.spongycastle.crypto.paddings.BlockCipherPadding
    public void init(SecureRandom secureRandom) throws IllegalArgumentException {
        if (secureRandom != null) {
            this.random = secureRandom;
        } else {
            this.random = new SecureRandom();
        }
    }

    @Override // org.spongycastle.crypto.paddings.BlockCipherPadding
    public int addPadding(byte[] bArr, int i) {
        byte length = (byte) (bArr.length - i);
        while (i < bArr.length - 1) {
            bArr[i] = (byte) this.random.nextInt();
            i++;
        }
        bArr[i] = length;
        return length;
    }

    @Override // org.spongycastle.crypto.paddings.BlockCipherPadding
    public int padCount(byte[] bArr) throws InvalidCipherTextException {
        byte b = bArr[bArr.length - 1] & UByte.MAX_VALUE;
        if (b <= bArr.length) {
            return b;
        }
        throw new InvalidCipherTextException("pad block corrupted");
    }
}
