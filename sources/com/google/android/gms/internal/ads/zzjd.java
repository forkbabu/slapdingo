package com.google.android.gms.internal.ads;

import java.nio.ShortBuffer;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzjd {
    private final int zzahh;
    private float zzaht = 1.0f;
    private float zzahu = 1.0f;
    private final int zzamp;
    private final int zzamq;
    private final int zzamr;
    private final int zzams;
    private final short[] zzamt;
    private int zzamu;
    private short[] zzamv;
    private int zzamw;
    private short[] zzamx;
    private int zzamy;
    private short[] zzamz;
    private int zzana = 0;
    private int zzanb = 0;
    private int zzanc;
    private int zzand;
    private int zzane;
    private int zzanf;
    private int zzang = 0;
    private int zzanh;
    private int zzani;
    private int zzanj;

    public zzjd(int i, int i2) {
        this.zzahh = i;
        this.zzamp = i2;
        this.zzamq = i / 400;
        int i3 = i / 65;
        this.zzamr = i3;
        int i4 = i3 * 2;
        this.zzams = i4;
        this.zzamt = new short[i4];
        this.zzamu = i4;
        this.zzamv = new short[(i4 * i2)];
        this.zzamw = i4;
        this.zzamx = new short[(i4 * i2)];
        this.zzamy = i4;
        this.zzamz = new short[(i4 * i2)];
    }

    public final void setSpeed(float f) {
        this.zzaht = f;
    }

    public final void zza(float f) {
        this.zzahu = f;
    }

    public final void zza(ShortBuffer shortBuffer) {
        int remaining = shortBuffer.remaining();
        int i = this.zzamp;
        int i2 = remaining / i;
        zzaa(i2);
        shortBuffer.get(this.zzamv, this.zzanc * this.zzamp, ((i * i2) << 1) / 2);
        this.zzanc += i2;
        zzgf();
    }

    public final void zzb(ShortBuffer shortBuffer) {
        int min = Math.min(shortBuffer.remaining() / this.zzamp, this.zzand);
        shortBuffer.put(this.zzamx, 0, this.zzamp * min);
        int i = this.zzand - min;
        this.zzand = i;
        short[] sArr = this.zzamx;
        int i2 = this.zzamp;
        System.arraycopy(sArr, min * i2, sArr, 0, i * i2);
    }

    public final void zzfk() {
        int i;
        int i2 = this.zzanc;
        float f = this.zzaht;
        float f2 = this.zzahu;
        int i3 = this.zzand + ((int) ((((((float) i2) / (f / f2)) + ((float) this.zzane)) / f2) + 0.5f));
        zzaa((this.zzams * 2) + i2);
        int i4 = 0;
        while (true) {
            i = this.zzams;
            int i5 = this.zzamp;
            if (i4 >= i * 2 * i5) {
                break;
            }
            this.zzamv[(i5 * i2) + i4] = 0;
            i4++;
        }
        this.zzanc += i * 2;
        zzgf();
        if (this.zzand > i3) {
            this.zzand = i3;
        }
        this.zzanc = 0;
        this.zzanf = 0;
        this.zzane = 0;
    }

    public final int zzge() {
        return this.zzand;
    }

    private final void zzz(int i) {
        int i2 = this.zzand + i;
        int i3 = this.zzamw;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.zzamw = i4;
            this.zzamx = Arrays.copyOf(this.zzamx, i4 * this.zzamp);
        }
    }

    private final void zzaa(int i) {
        int i2 = this.zzanc + i;
        int i3 = this.zzamu;
        if (i2 > i3) {
            int i4 = i3 + (i3 / 2) + i;
            this.zzamu = i4;
            this.zzamv = Arrays.copyOf(this.zzamv, i4 * this.zzamp);
        }
    }

    private final void zza(short[] sArr, int i, int i2) {
        zzz(i2);
        int i3 = this.zzamp;
        System.arraycopy(sArr, i * i3, this.zzamx, this.zzand * i3, i3 * i2);
        this.zzand += i2;
    }

    private final void zzb(short[] sArr, int i, int i2) {
        int i3 = this.zzams / i2;
        int i4 = this.zzamp;
        int i5 = i2 * i4;
        int i6 = i * i4;
        for (int i7 = 0; i7 < i3; i7++) {
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                i8 += sArr[(i7 * i5) + i6 + i9];
            }
            this.zzamt[i7] = (short) (i8 / i5);
        }
    }

    private final int zza(short[] sArr, int i, int i2, int i3) {
        int i4 = i * this.zzamp;
        int i5 = 1;
        int i6 = 255;
        int i7 = 0;
        int i8 = 0;
        while (i2 <= i3) {
            int i9 = 0;
            for (int i10 = 0; i10 < i2; i10++) {
                short s = sArr[i4 + i10];
                short s2 = sArr[i4 + i2 + i10];
                i9 += s >= s2 ? s - s2 : s2 - s;
            }
            if (i9 * i7 < i5 * i2) {
                i7 = i2;
                i5 = i9;
            }
            if (i9 * i6 > i8 * i2) {
                i6 = i2;
                i8 = i9;
            }
            i2++;
        }
        this.zzani = i5 / i7;
        this.zzanj = i8 / i6;
        return i7;
    }

    private final void zzgf() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7 = this.zzand;
        float f = this.zzaht / this.zzahu;
        double d = (double) f;
        int i8 = 1;
        if (d > 1.00001d || d < 0.99999d) {
            int i9 = this.zzanc;
            if (i9 >= this.zzams) {
                int i10 = 0;
                while (true) {
                    int i11 = this.zzanf;
                    if (i11 > 0) {
                        int min = Math.min(this.zzams, i11);
                        zza(this.zzamv, i10, min);
                        this.zzanf -= min;
                        i10 += min;
                    } else {
                        short[] sArr = this.zzamv;
                        int i12 = this.zzahh;
                        int i13 = i12 > 4000 ? i12 / 4000 : 1;
                        if (this.zzamp == i8 && i13 == i8) {
                            i4 = zza(sArr, i10, this.zzamq, this.zzamr);
                        } else {
                            zzb(sArr, i10, i13);
                            int zza = zza(this.zzamt, 0, this.zzamq / i13, this.zzamr / i13);
                            if (i13 != i8) {
                                int i14 = zza * i13;
                                int i15 = i13 << 2;
                                int i16 = i14 - i15;
                                int i17 = i14 + i15;
                                int i18 = this.zzamq;
                                if (i16 < i18) {
                                    i16 = i18;
                                }
                                int i19 = this.zzamr;
                                if (i17 > i19) {
                                    i17 = i19;
                                }
                                if (this.zzamp == i8) {
                                    i4 = zza(sArr, i10, i16, i17);
                                } else {
                                    zzb(sArr, i10, i8);
                                    i4 = zza(this.zzamt, 0, i16, i17);
                                }
                            } else {
                                i4 = zza;
                            }
                        }
                        int i20 = this.zzani;
                        int i21 = i20 != 0 && this.zzang != 0 && this.zzanj <= i20 * 3 && (i20 << 1) > this.zzanh * 3 ? this.zzang : i4;
                        this.zzanh = this.zzani;
                        this.zzang = i4;
                        if (d > 1.0d) {
                            short[] sArr2 = this.zzamv;
                            if (f >= 2.0f) {
                                i6 = (int) (((float) i21) / (f - 1.0f));
                            } else {
                                this.zzanf = (int) ((((float) i21) * (2.0f - f)) / (f - 1.0f));
                                i6 = i21;
                            }
                            zzz(i6);
                            zza(i6, this.zzamp, this.zzamx, this.zzand, sArr2, i10, sArr2, i10 + i21);
                            this.zzand += i6;
                            i10 += i21 + i6;
                        } else {
                            short[] sArr3 = this.zzamv;
                            if (f < 0.5f) {
                                i5 = (int) ((((float) i21) * f) / (1.0f - f));
                            } else {
                                this.zzanf = (int) ((((float) i21) * ((2.0f * f) - 1.0f)) / (1.0f - f));
                                i5 = i21;
                            }
                            int i22 = i21 + i5;
                            zzz(i22);
                            int i23 = this.zzamp;
                            System.arraycopy(sArr3, i10 * i23, this.zzamx, this.zzand * i23, i23 * i21);
                            zza(i5, this.zzamp, this.zzamx, this.zzand + i21, sArr3, i21 + i10, sArr3, i10);
                            this.zzand += i22;
                            i10 += i5;
                        }
                    }
                    if (this.zzams + i10 > i9) {
                        break;
                    }
                    i8 = 1;
                }
                int i24 = this.zzanc - i10;
                short[] sArr4 = this.zzamv;
                int i25 = this.zzamp;
                System.arraycopy(sArr4, i10 * i25, sArr4, 0, i25 * i24);
                this.zzanc = i24;
            }
        } else {
            zza(this.zzamv, 0, this.zzanc);
            this.zzanc = 0;
        }
        float f2 = this.zzahu;
        if (f2 != 1.0f && this.zzand != i7) {
            int i26 = this.zzahh;
            int i27 = (int) (((float) i26) / f2);
            while (true) {
                if (i27 <= 16384 && i26 <= 16384) {
                    break;
                }
                i27 /= 2;
                i26 /= 2;
            }
            int i28 = this.zzand - i7;
            int i29 = this.zzane + i28;
            int i30 = this.zzamy;
            if (i29 > i30) {
                int i31 = i30 + (i30 / 2) + i28;
                this.zzamy = i31;
                this.zzamz = Arrays.copyOf(this.zzamz, i31 * this.zzamp);
            }
            short[] sArr5 = this.zzamx;
            int i32 = this.zzamp;
            System.arraycopy(sArr5, i7 * i32, this.zzamz, this.zzane * i32, i32 * i28);
            this.zzand = i7;
            this.zzane += i28;
            int i33 = 0;
            while (true) {
                i = this.zzane;
                if (i33 >= i - 1) {
                    break;
                }
                while (true) {
                    i2 = this.zzana;
                    int i34 = (i2 + 1) * i27;
                    i3 = this.zzanb;
                    if (i34 <= i3 * i26) {
                        break;
                    }
                    zzz(1);
                    int i35 = 0;
                    while (true) {
                        int i36 = this.zzamp;
                        if (i35 >= i36) {
                            break;
                        }
                        short[] sArr6 = this.zzamz;
                        int i37 = (i33 * i36) + i35;
                        short s = sArr6[i37];
                        short s2 = sArr6[i37 + i36];
                        int i38 = this.zzana;
                        int i39 = i38 * i27;
                        int i40 = (i38 + 1) * i27;
                        int i41 = i40 - (this.zzanb * i26);
                        int i42 = i40 - i39;
                        this.zzamx[(this.zzand * i36) + i35] = (short) (((s * i41) + ((i42 - i41) * s2)) / i42);
                        i35++;
                    }
                    this.zzanb++;
                    this.zzand++;
                }
                int i43 = i2 + 1;
                this.zzana = i43;
                if (i43 == i26) {
                    this.zzana = 0;
                    zzpb.checkState(i3 == i27);
                    this.zzanb = 0;
                }
                i33++;
            }
            int i44 = i - 1;
            if (i44 != 0) {
                short[] sArr7 = this.zzamz;
                int i45 = this.zzamp;
                System.arraycopy(sArr7, i44 * i45, sArr7, 0, (i - i44) * i45);
                this.zzane -= i44;
            }
        }
    }

    private static void zza(int i, int i2, short[] sArr, int i3, short[] sArr2, int i4, short[] sArr3, int i5) {
        for (int i6 = 0; i6 < i2; i6++) {
            int i7 = (i3 * i2) + i6;
            int i8 = (i5 * i2) + i6;
            int i9 = (i4 * i2) + i6;
            for (int i10 = 0; i10 < i; i10++) {
                sArr[i7] = (short) (((sArr2[i9] * (i - i10)) + (sArr3[i8] * i10)) / i);
                i7 += i2;
                i9 += i2;
                i8 += i2;
            }
        }
    }
}
