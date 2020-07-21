package org.spongycastle.pqc.crypto.xmss;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class XMSSReducedSignature implements XMSSStoreableObjectInterface {
    private final List<XMSSNode> authPath;
    private final XMSSParameters params;
    private final WOTSPlusSignature wotsPlusSignature;

    protected XMSSReducedSignature(Builder builder) {
        XMSSParameters access$000 = builder.params;
        this.params = access$000;
        if (access$000 != null) {
            int digestSize = access$000.getDigestSize();
            int len = this.params.getWOTSPlus().getParams().getLen();
            int height = this.params.getHeight();
            byte[] access$100 = builder.reducedSignature;
            if (access$100 != null) {
                if (access$100.length == (len * digestSize) + (height * digestSize)) {
                    byte[][] bArr = new byte[len][];
                    int i = 0;
                    for (int i2 = 0; i2 < len; i2++) {
                        bArr[i2] = XMSSUtil.extractBytesAtOffset(access$100, i, digestSize);
                        i += digestSize;
                    }
                    this.wotsPlusSignature = new WOTSPlusSignature(this.params.getWOTSPlus().getParams(), bArr);
                    ArrayList arrayList = new ArrayList();
                    for (int i3 = 0; i3 < height; i3++) {
                        arrayList.add(new XMSSNode(i3, XMSSUtil.extractBytesAtOffset(access$100, i, digestSize)));
                        i += digestSize;
                    }
                    this.authPath = arrayList;
                    return;
                }
                throw new IllegalArgumentException("signature has wrong size");
            }
            WOTSPlusSignature access$200 = builder.wotsPlusSignature;
            if (access$200 != null) {
                this.wotsPlusSignature = access$200;
            } else {
                WOTSPlusParameters params2 = this.params.getWOTSPlus().getParams();
                int[] iArr = new int[2];
                iArr[1] = digestSize;
                iArr[0] = len;
                this.wotsPlusSignature = new WOTSPlusSignature(params2, (byte[][]) Array.newInstance(byte.class, iArr));
            }
            List<XMSSNode> access$300 = builder.authPath;
            if (access$300 == null) {
                this.authPath = new ArrayList();
            } else if (access$300.size() == height) {
                this.authPath = access$300;
            } else {
                throw new IllegalArgumentException("size of authPath needs to be equal to height of tree");
            }
        } else {
            throw new NullPointerException("params == null");
        }
    }

    public static class Builder {
        /* access modifiers changed from: private */
        public List<XMSSNode> authPath = null;
        /* access modifiers changed from: private */
        public final XMSSParameters params;
        /* access modifiers changed from: private */
        public byte[] reducedSignature = null;
        /* access modifiers changed from: private */
        public WOTSPlusSignature wotsPlusSignature = null;

        public Builder(XMSSParameters xMSSParameters) {
            this.params = xMSSParameters;
        }

        public Builder withWOTSPlusSignature(WOTSPlusSignature wOTSPlusSignature) {
            this.wotsPlusSignature = wOTSPlusSignature;
            return this;
        }

        public Builder withAuthPath(List<XMSSNode> list) {
            this.authPath = list;
            return this;
        }

        public Builder withReducedSignature(byte[] bArr) {
            this.reducedSignature = XMSSUtil.cloneArray(bArr);
            return this;
        }

        public XMSSReducedSignature build() {
            return new XMSSReducedSignature(this);
        }
    }

    @Override // org.spongycastle.pqc.crypto.xmss.XMSSStoreableObjectInterface
    public byte[] toByteArray() {
        byte[][] byteArray;
        int digestSize = this.params.getDigestSize();
        byte[] bArr = new byte[((this.params.getWOTSPlus().getParams().getLen() * digestSize) + (this.params.getHeight() * digestSize))];
        int i = 0;
        for (byte[] bArr2 : this.wotsPlusSignature.toByteArray()) {
            XMSSUtil.copyBytesAtOffset(bArr, bArr2, i);
            i += digestSize;
        }
        for (int i2 = 0; i2 < this.authPath.size(); i2++) {
            XMSSUtil.copyBytesAtOffset(bArr, this.authPath.get(i2).getValue(), i);
            i += digestSize;
        }
        return bArr;
    }

    public XMSSParameters getParams() {
        return this.params;
    }

    public WOTSPlusSignature getWOTSPlusSignature() {
        return this.wotsPlusSignature;
    }

    public List<XMSSNode> getAuthPath() {
        return this.authPath;
    }
}
