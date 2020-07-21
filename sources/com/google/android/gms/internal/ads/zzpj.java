package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpj {
    private byte[] data;
    private int zzbjz;
    private int zzbka;
    private int zzbkb;

    public zzpj() {
    }

    public zzpj(byte[] bArr) {
        this(bArr, bArr.length);
    }

    private zzpj(byte[] bArr, int i) {
        this.data = bArr;
        this.zzbkb = i;
    }

    public final int zzbn(int i) {
        int i2;
        int i3;
        byte b;
        byte b2;
        boolean z = false;
        if (i == 0) {
            return 0;
        }
        int i4 = i / 8;
        byte b3 = 0;
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = this.zzbka;
            if (i6 != 0) {
                byte[] bArr = this.data;
                int i7 = this.zzbjz;
                b2 = ((bArr[i7 + 1] & UByte.MAX_VALUE) >>> (8 - i6)) | ((bArr[i7] & UByte.MAX_VALUE) << i6);
            } else {
                b2 = this.data[this.zzbjz];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzbjz++;
        }
        if (i > 0) {
            int i8 = this.zzbka + i;
            byte b4 = (byte) (255 >> (8 - i));
            if (i8 > 8) {
                byte[] bArr2 = this.data;
                int i9 = this.zzbjz;
                b = (b4 & (((255 & bArr2[i9 + 1]) >> (16 - i8)) | ((bArr2[i9] & UByte.MAX_VALUE) << (i8 - 8)))) | b3;
                this.zzbjz = i9 + 1;
            } else {
                byte[] bArr3 = this.data;
                int i10 = this.zzbjz;
                b = (b4 & ((255 & bArr3[i10]) >> (8 - i8))) | b3;
                if (i8 == 8) {
                    this.zzbjz = i10 + 1;
                }
            }
            b3 = b;
            this.zzbka = i8 % 8;
        }
        int i11 = this.zzbjz;
        if (i11 >= 0 && (i2 = this.zzbka) >= 0 && i2 < 8 && (i11 < (i3 = this.zzbkb) || (i11 == i3 && i2 == 0))) {
            z = true;
        }
        zzpb.checkState(z);
        return b3;
    }
}
