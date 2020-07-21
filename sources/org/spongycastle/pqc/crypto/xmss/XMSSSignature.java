package org.spongycastle.pqc.crypto.xmss;

import org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature;
import org.spongycastle.util.Pack;

public final class XMSSSignature extends XMSSReducedSignature implements XMSSStoreableObjectInterface {
    private final int index;
    private final byte[] random;

    private XMSSSignature(Builder builder) {
        super(builder);
        this.index = builder.index;
        int digestSize = getParams().getDigestSize();
        byte[] access$100 = builder.random;
        if (access$100 == null) {
            this.random = new byte[digestSize];
        } else if (access$100.length == digestSize) {
            this.random = access$100;
        } else {
            throw new IllegalArgumentException("size of random needs to be equal to size of digest");
        }
    }

    public static class Builder extends XMSSReducedSignature.Builder {
        /* access modifiers changed from: private */
        public int index = 0;
        private final XMSSParameters params;
        /* access modifiers changed from: private */
        public byte[] random = null;

        public Builder(XMSSParameters xMSSParameters) {
            super(xMSSParameters);
            this.params = xMSSParameters;
        }

        public Builder withIndex(int i) {
            this.index = i;
            return this;
        }

        public Builder withRandom(byte[] bArr) {
            this.random = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public Builder withSignature(byte[] bArr) {
            if (bArr != null) {
                int digestSize = this.params.getDigestSize();
                int len = this.params.getWOTSPlus().getParams().getLen();
                this.index = Pack.bigEndianToInt(bArr, 0);
                this.random = XMSSUtil.extractBytesAtOffset(bArr, 4, digestSize);
                withReducedSignature(XMSSUtil.extractBytesAtOffset(bArr, 4 + digestSize, (len * digestSize) + (this.params.getHeight() * digestSize)));
                return this;
            }
            throw new NullPointerException("signature == null");
        }

        @Override // org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature.Builder
        public XMSSSignature build() {
            return new XMSSSignature(this);
        }
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface, org.spongycastle.pqc.crypto.xmss.XMSSReducedSignature
    public byte[] toByteArray() {
        byte[][] byteArray;
        int digestSize = getParams().getDigestSize();
        byte[] bArr = new byte[(digestSize + 4 + (getParams().getWOTSPlus().getParams().getLen() * digestSize) + (getParams().getHeight() * digestSize))];
        Pack.intToBigEndian(this.index, bArr, 0);
        XMSSUtil.copyBytesAtOffset(bArr, this.random, 4);
        int i = 4 + digestSize;
        for (byte[] bArr2 : getWOTSPlusSignature().toByteArray()) {
            XMSSUtil.copyBytesAtOffset(bArr, bArr2, i);
            i += digestSize;
        }
        for (int i2 = 0; i2 < getAuthPath().size(); i2++) {
            XMSSUtil.copyBytesAtOffset(bArr, getAuthPath().get(i2).getValue(), i);
            i += digestSize;
        }
        return bArr;
    }

    public int getIndex() {
        return this.index;
    }

    public byte[] getRandom() {
        return XMSSUtil.cloneArray(this.random);
    }
}
