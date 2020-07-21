package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzegb;
import com.itextpdf.text.pdf.codec.wmf.MetaDo;
import java.io.IOException;
import java.util.Arrays;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzejc {
    private static final zzejc zziiy = new zzejc(0, new int[0], new Object[0], false);
    private int count;
    private boolean zzhzk;
    private int zzieh;
    private Object[] zzigt;
    private int[] zziiz;

    public static zzejc zzbhs() {
        return zziiy;
    }

    static zzejc zzbht() {
        return new zzejc();
    }

    static zzejc zza(zzejc zzejc, zzejc zzejc2) {
        int i = zzejc.count + zzejc2.count;
        int[] copyOf = Arrays.copyOf(zzejc.zziiz, i);
        System.arraycopy(zzejc2.zziiz, 0, copyOf, zzejc.count, zzejc2.count);
        Object[] copyOf2 = Arrays.copyOf(zzejc.zzigt, i);
        System.arraycopy(zzejc2.zzigt, 0, copyOf2, zzejc.count, zzejc2.count);
        return new zzejc(i, copyOf, copyOf2, true);
    }

    private zzejc() {
        this(0, new int[8], new Object[8], true);
    }

    private zzejc(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zzieh = -1;
        this.count = i;
        this.zziiz = iArr;
        this.zzigt = objArr;
        this.zzhzk = z;
    }

    public final void zzbcz() {
        this.zzhzk = false;
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzejw zzejw) throws IOException {
        if (zzejw.zzbep() == zzegb.zze.zzifa) {
            for (int i = this.count - 1; i >= 0; i--) {
                zzejw.zzc(this.zziiz[i] >>> 3, this.zzigt[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.count; i2++) {
            zzejw.zzc(this.zziiz[i2] >>> 3, this.zzigt[i2]);
        }
    }

    public final void zzb(zzejw zzejw) throws IOException {
        if (this.count != 0) {
            if (zzejw.zzbep() == zzegb.zze.zziez) {
                for (int i = 0; i < this.count; i++) {
                    zzb(this.zziiz[i], this.zzigt[i], zzejw);
                }
                return;
            }
            for (int i2 = this.count - 1; i2 >= 0; i2--) {
                zzb(this.zziiz[i2], this.zzigt[i2], zzejw);
            }
        }
    }

    private static void zzb(int i, Object obj, zzejw zzejw) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzejw.zzp(i2, ((Long) obj).longValue());
        } else if (i3 == 1) {
            zzejw.zzj(i2, ((Long) obj).longValue());
        } else if (i3 == 2) {
            zzejw.zza(i2, (zzeer) obj);
        } else if (i3 != 3) {
            if (i3 == 5) {
                zzejw.zzae(i2, ((Integer) obj).intValue());
                return;
            }
            throw new RuntimeException(zzegl.zzbfz());
        } else if (zzejw.zzbep() == zzegb.zze.zziez) {
            zzejw.zzgy(i2);
            ((zzejc) obj).zzb(zzejw);
            zzejw.zzgz(i2);
        } else {
            zzejw.zzgz(i2);
            ((zzejc) obj).zzb(zzejw);
            zzejw.zzgy(i2);
        }
    }

    public final int zzbhu() {
        int i = this.zzieh;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.count; i3++) {
            i2 += zzefl.zzd(this.zziiz[i3] >>> 3, (zzeer) this.zzigt[i3]);
        }
        this.zzieh = i2;
        return i2;
    }

    public final int zzbfe() {
        int i;
        int i2 = this.zzieh;
        if (i2 != -1) {
            return i2;
        }
        int i3 = 0;
        for (int i4 = 0; i4 < this.count; i4++) {
            int i5 = this.zziiz[i4];
            int i6 = i5 >>> 3;
            int i7 = i5 & 7;
            if (i7 == 0) {
                i = zzefl.zzl(i6, ((Long) this.zzigt[i4]).longValue());
            } else if (i7 == 1) {
                i = zzefl.zzn(i6, ((Long) this.zzigt[i4]).longValue());
            } else if (i7 == 2) {
                i = zzefl.zzc(i6, (zzeer) this.zzigt[i4]);
            } else if (i7 == 3) {
                i = (zzefl.zzgp(i6) << 1) + ((zzejc) this.zzigt[i4]).zzbfe();
            } else if (i7 == 5) {
                i = zzefl.zzai(i6, ((Integer) this.zzigt[i4]).intValue());
            } else {
                throw new IllegalStateException(zzegl.zzbfz());
            }
            i3 += i;
        }
        this.zzieh = i3;
        return i3;
    }

    public final boolean equals(Object obj) {
        boolean z;
        boolean z2;
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzejc)) {
            return false;
        }
        zzejc zzejc = (zzejc) obj;
        int i = this.count;
        if (i == zzejc.count) {
            int[] iArr = this.zziiz;
            int[] iArr2 = zzejc.zziiz;
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
                Object[] objArr = this.zzigt;
                Object[] objArr2 = zzejc.zzigt;
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
        int[] iArr = this.zziiz;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzigt;
        int i7 = this.count;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    /* access modifiers changed from: package-private */
    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.count; i2++) {
            zzehq.zza(sb, i, String.valueOf(this.zziiz[i2] >>> 3), this.zzigt[i2]);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzd(int i, Object obj) {
        if (this.zzhzk) {
            int i2 = this.count;
            if (i2 == this.zziiz.length) {
                int i3 = this.count + (i2 < 4 ? 8 : i2 >> 1);
                this.zziiz = Arrays.copyOf(this.zziiz, i3);
                this.zzigt = Arrays.copyOf(this.zzigt, i3);
            }
            int[] iArr = this.zziiz;
            int i4 = this.count;
            iArr[i4] = i;
            this.zzigt[i4] = obj;
            this.count = i4 + 1;
            return;
        }
        throw new UnsupportedOperationException();
    }
}
