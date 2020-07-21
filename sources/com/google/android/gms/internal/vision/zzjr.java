package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgx;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public final class zzjr {
    private static final zzjr zzaay = new zzjr(0, new int[0], new Object[0], false);
    private int count;
    private int[] zzaaz;
    private boolean zzry;
    private int zzwt;
    private Object[] zzzk;

    public static zzjr zzih() {
        return zzaay;
    }

    static zzjr zzii() {
        return new zzjr();
    }

    static zzjr zza(zzjr zzjr, zzjr zzjr2) {
        int i = zzjr.count + zzjr2.count;
        int[] copyOf = Arrays.copyOf(zzjr.zzaaz, i);
        System.arraycopy(zzjr2.zzaaz, 0, copyOf, zzjr.count, zzjr2.count);
        Object[] copyOf2 = Arrays.copyOf(zzjr.zzzk, i);
        System.arraycopy(zzjr2.zzzk, 0, copyOf2, zzjr.count, zzjr2.count);
        return new zzjr(i, copyOf, copyOf2, true);
    }

    private zzjr() {
        this(0, new int[8], new Object[8], true);
    }

    private zzjr(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzwt = -1;
        this.count = i;
        this.zzaaz = iArr;
        this.zzzk = objArr;
        this.zzry = z;
    }

    public final void zzdq() {
        this.zzry = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzkl zzkl) throws IOException {
        if (zzkl.zzfk() == zzgx.zzf.zzxm) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzkl.zza(this.zzaaz[i] >>> 3, this.zzzk[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzkl.zza(this.zzaaz[i2] >>> 3, this.zzzk[i2]);
        }
    }

    public final void zzb(zzkl zzkl) throws IOException {
        if (this.count != 0) {
            if (zzkl.zzfk() == zzgx.zzf.zzxl) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zzaaz[i], this.zzzk[i], zzkl);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zzaaz[i2], this.zzzk[i2], zzkl);
            }
        }
    }

    private static void zzb(int i, Object obj, zzkl zzkl) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzkl.zzi(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzkl.zzc(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzkl.zza(i2, (zzfm) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzkl.zzk(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzhh.zzgs());
        } else if (zzkl.zzfk() == zzgx.zzf.zzxl) {
            zzkl.zzbk(i2);
            ((zzjr) obj).zzb(zzkl);
            zzkl.zzbl(i2);
        } else {
            zzkl.zzbl(i2);
            ((zzjr) obj).zzb(zzkl);
            zzkl.zzbk(i2);
        }
    }

    public final int zzij() {
        int i = this.zzwt;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzgf.zzd(this.zzaaz[i3] >>> 3, (zzfm) this.zzzk[i3]);
        }
        this.zzwt = i2;
        return i2;
    }

    public final int zzgg() {
        int i;
        int i2 = this.zzwt;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zzaaz[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzgf.zze(i6, ((Long) this.zzzk[i4]).longValue());
            } else if (i7 == 1) {
                i = zzgf.zzg(i6, ((Long) this.zzzk[i4]).longValue());
            } else if (i7 == 2) {
                i = zzgf.zzc(i6, (zzfm) this.zzzk[i4]);
            } else if (i7 == 3) {
                i = (zzgf.zzbb(i6) << 1) + ((zzjr) this.zzzk[i4]).zzgg();
            } else if (i7 == 5) {
                i = zzgf.zzo(i6, ((Integer) this.zzzk[i4]).intValue());
            } else {
                throw new IllegalStateException(zzhh.zzgs());
            }
            i3 += i;
        }
        this.zzwt = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzjr)) {
            return false;
        }
        zzjr zzjr = (zzjr) obj;
        int i = this.count;
        if (i == zzjr.count) {
            int[] iArr = this.zzaaz;
            int[] iArr2 = zzjr.zzaaz;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    z = true;
                    break;
                } else if (iArr[i2] != iArr2[i2]) {
                    z = false;
                    break;
                } else {
                    i2++;
                }
            }
            if (z) {
                Object[] objArr = this.zzzk;
                Object[] objArr2 = zzjr.zzzk;
                int i3 = this.count;
                int i4 = 0;
                while (true) {
                    if (i4 >= i3) {
                        z2 = true;
                        break;
                    } else if (!objArr[i4].equals(objArr2[i4])) {
                        z2 = false;
                        break;
                    } else {
                        i4++;
                    }
                }
                return z2;
            }
        }
    }

    public final int hashCode() {
        int i = this.count;
        int i2 = (i + MetaDo.META_OFFSETWINDOWORG) * 31;
        int[] iArr = this.zzaaz;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzzk;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzii.zza(sb, i, String.valueOf(this.zzaaz[i2] >>> 3), this.zzzk[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(int i, Object obj) {
        if (this.zzry) {
            int i2 = this.count;
            if (i2 == this.zzaaz.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zzaaz = Arrays.copyOf(this.zzaaz, i3);
                this.zzzk = Arrays.copyOf(this.zzzk, i3);
            }
            int[] iArr = this.zzaaz;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzzk[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
