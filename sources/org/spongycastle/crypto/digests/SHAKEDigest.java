package org.spongycastle.crypto.digests;

import org.spongycastle.crypto.Xof;

public class SHAKEDigest extends KeccakDigest implements Xof {
    private static int checkBitLength(int i) {
        if (i == 128 || i == 256) {
            return i;
        }
        throw new IllegalArgumentException("'bitLength' " + i + " not supported for SHAKE");
    }

    public SHAKEDigest() {
        this(128);
    }

    public SHAKEDigest(int i) {
        super(checkBitLength(i));
    }

    public SHAKEDigest(SHAKEDigest sHAKEDigest) {
        super(sHAKEDigest);
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest, org.spongycastle.crypto.Digest
    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }

    @Override // org.spongycastle.crypto.digests.KeccakDigest, org.spongycastle.crypto.Digest
    public int doFinal(byte[] bArr, int i) {
        return doFinal(bArr, i, getDigestSize());
    }

    @Override // org.spongycastle.crypto.Xof
    public int doFinal(byte[] bArr, int i, int i2) {
        int doOutput = doOutput(bArr, i, i2);
        reset();
        return doOutput;
    }

    @Override // org.spongycastle.crypto.Xof
    public int doOutput(byte[] bArr, int i, int i2) {
        if (!this.squeezing) {
            absorbBits(15, 4);
        }
        squeeze(bArr, i, ((long) i2) * 8);
        return i2;
    }

    /* access modifiers changed from: protected */
    @Override // org.spongycastle.crypto.digests.KeccakDigest
    public int doFinal(byte[] bArr, int i, byte b, int i2) {
        return doFinal(bArr, i, getDigestSize(), b, i2);
    }

    /* access modifiers changed from: protected */
    public int doFinal(byte[] bArr, int i, int i2, byte b, int i3) {
        if (i3 < 0 || i3 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i4 = (b & ((1 << i3) - 1)) | (15 << i3);
        int i5 = i3 + 4;
        if (i5 >= 8) {
            absorb(new byte[]{(byte) i4}, 0, 1);
            i5 -= 8;
            i4 >>>= 8;
        }
        if (i5 > 0) {
            absorbBits(i4, i5);
        }
        squeeze(bArr, i, ((long) i2) * 8);
        reset();
        return i2;
    }
}
