package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzeee {
    private final byte[] zzhzf = new byte[256];
    private int zzhzg;
    private int zzhzh;

    public zzeee(byte[] bArr) {
        for (int i = 0; i < 256; i++) {
            this.zzhzf[i] = (byte) i;
        }
        byte b = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            byte[] bArr2 = this.zzhzf;
            b = (b + bArr2[i2] + bArr[i2 % bArr.length]) & UByte.MAX_VALUE;
            byte b2 = bArr2[i2];
            bArr2[i2] = bArr2[b];
            bArr2[b] = b2;
        }
        this.zzhzg = 0;
        this.zzhzh = 0;
    }

    public final void zzt(byte[] bArr) {
        int i = this.zzhzg;
        int i2 = this.zzhzh;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) & 255;
            byte[] bArr2 = this.zzhzf;
            i2 = (i2 + bArr2[i]) & 255;
            byte b = bArr2[i];
            bArr2[i] = bArr2[i2];
            bArr2[i2] = b;
            bArr[i3] = (byte) (bArr2[(bArr2[i] + bArr2[i2]) & 255] ^ bArr[i3]);
        }
        this.zzhzg = i;
        this.zzhzh = i2;
    }
}
