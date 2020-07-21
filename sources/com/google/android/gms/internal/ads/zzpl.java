package com.google.android.gms.internal.ads;

import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpl {
    private byte[] data;
    private int zzbjz;
    private int zzbka = 0;
    private int zzbkb;

    public zzpl(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbjz = i;
        this.zzbkb = i2;
        zzjg();
    }

    public final void zzbo(int i) {
        int i2 = this.zzbjz;
        int i3 = (i / 8) + i2;
        this.zzbjz = i3;
        int i4 = this.zzbka + (i % 8);
        this.zzbka = i4;
        if (i4 > 7) {
            this.zzbjz = i3 + 1;
            this.zzbka = i4 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbjz) {
                zzjg();
                return;
            } else if (zzbp(i2)) {
                this.zzbjz++;
                i2 += 2;
            }
        }
    }

    public final boolean zzjc() {
        return zzbn(1) == 1;
    }

    public final int zzbn(int i) {
        byte b;
        byte b2;
        if (i == 0) {
            return 0;
        }
        int i2 = i / 8;
        byte b3 = 0;
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = zzbp(this.zzbjz + 1) ? this.zzbjz + 2 : this.zzbjz + 1;
            int i5 = this.zzbka;
            if (i5 != 0) {
                byte[] bArr = this.data;
                b2 = ((bArr[i4] & UByte.MAX_VALUE) >>> (8 - i5)) | ((bArr[this.zzbjz] & UByte.MAX_VALUE) << i5);
            } else {
                b2 = this.data[this.zzbjz];
            }
            i -= 8;
            b3 |= (255 & b2) << i;
            this.zzbjz = i4;
        }
        if (i > 0) {
            int i6 = this.zzbka + i;
            byte b4 = (byte) (255 >> (8 - i));
            int i7 = zzbp(this.zzbjz + 1) ? this.zzbjz + 2 : this.zzbjz + 1;
            if (i6 > 8) {
                byte[] bArr2 = this.data;
                b = (b4 & (((255 & bArr2[i7]) >> (16 - i6)) | ((bArr2[this.zzbjz] & UByte.MAX_VALUE) << (i6 - 8)))) | b3;
                this.zzbjz = i7;
            } else {
                b = (b4 & ((255 & this.data[this.zzbjz]) >> (8 - i6))) | b3;
                if (i6 == 8) {
                    this.zzbjz = i7;
                }
            }
            b3 = b;
            this.zzbka = i6 % 8;
        }
        zzjg();
        return b3;
    }

    public final int zzjd() {
        return zzjf();
    }

    public final int zzje() {
        int zzjf = zzjf();
        return (zzjf % 2 == 0 ? -1 : 1) * ((zzjf + 1) / 2);
    }

    private final int zzjf() {
        int i = 0;
        int i2 = 0;
        while (!zzjc()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbn(i2);
        }
        return i3 + i;
    }

    private final boolean zzbp(int i) {
        if (2 > i || i >= this.zzbkb) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
    }

    private final void zzjg() {
        int i;
        int i2;
        int i3 = this.zzbjz;
        zzpb.checkState(i3 >= 0 && (i = this.zzbka) >= 0 && i < 8 && (i3 < (i2 = this.zzbkb) || (i3 == i2 && i == 0)));
    }
}
