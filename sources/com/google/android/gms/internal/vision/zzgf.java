package com.google.android.gms.internal.vision;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public abstract class zzgf extends zzfn {
    private static final Logger logger = Logger.getLogger(zzgf.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zztg = zzju.zzik();
    zzgh zzth;

    private static long zzaa(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzb(double d) {
        return 8;
    }

    public static int zzbd(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        return (i & -268435456) == 0 ? 4 : 5;
    }

    public static int zzbf(int i) {
        return 4;
    }

    public static int zzbg(int i) {
        return 4;
    }

    private static int zzbi(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static zzgf zze(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public static int zzl(boolean z) {
        return 1;
    }

    public static int zzt(float f) {
        return 4;
    }

    public static int zzw(long j) {
        int i;
        if ((-128 & j) == 0) {
            return 1;
        }
        if (j < 0) {
            return 10;
        }
        if ((-34359738368L & j) != 0) {
            i = 6;
            j >>>= 28;
        } else {
            i = 2;
        }
        if ((-2097152 & j) != 0) {
            i += 2;
            j >>>= 14;
        }
        return (j & -16384) != 0 ? i + 1 : i;
    }

    public static int zzy(long j) {
        return 8;
    }

    public static int zzz(long j) {
        return 8;
    }

    public abstract void writeTag(int i, int i2) throws IOException;

    public abstract void zza(int i, long j) throws IOException;

    public abstract void zza(int i, zzfm zzfm) throws IOException;

    public abstract void zza(int i, zzih zzih) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzih zzih, zziw zziw) throws IOException;

    public abstract void zza(int i, String str) throws IOException;

    public abstract void zza(int i, boolean z) throws IOException;

    public abstract void zza(zzfm zzfm) throws IOException;

    public abstract void zzax(int i) throws IOException;

    public abstract void zzay(int i) throws IOException;

    public abstract void zzb(int i, zzfm zzfm) throws IOException;

    public abstract void zzb(zzih zzih) throws IOException;

    public abstract void zzba(int i) throws IOException;

    public abstract void zzc(byte b) throws IOException;

    public abstract void zzc(int i, long j) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zze(byte[] bArr, int i, int i2) throws IOException;

    public abstract int zzfh();

    public abstract void zzh(int i, int i2) throws IOException;

    public abstract void zzi(int i, int i2) throws IOException;

    public abstract void zzk(int i, int i2) throws IOException;

    public abstract void zzs(long j) throws IOException;

    public abstract void zzu(long j) throws IOException;

    public abstract void zzx(String str) throws IOException;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    public static class zza extends IOException {
        zza() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }

        zza(Throwable th) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        zza(java.lang.String r3, java.lang.Throwable r4) {
            /*
                r2 = this;
                java.lang.String r3 = java.lang.String.valueOf(r3)
                int r0 = r3.length()
                java.lang.String r1 = "CodedOutputStream was writing to a flat byte array and ran out of space.: "
                if (r0 == 0) goto L_0x0011
                java.lang.String r3 = r1.concat(r3)
                goto L_0x0016
            L_0x0011:
                java.lang.String r3 = new java.lang.String
                r3.<init>(r1)
            L_0x0016:
                r2.<init>(r3, r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzgf.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzgf() {
    }

    public final void zzj(int i, int i2) throws IOException {
        zzi(i, zzbi(i2));
    }

    public final void zzb(int i, long j) throws IOException {
        zza(i, zzaa(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzk(i, Float.floatToRawIntBits(f));
    }

    public final void zza(int i, double d) throws IOException {
        zzc(i, Double.doubleToRawLongBits(d));
    }

    public final void zzaz(int i) throws IOException {
        zzay(zzbi(i));
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
    static class zzb extends zzgf {
        private final byte[] buffer;
        private final int limit;
        private final int offset;
        private int position;

        zzb(byte[] bArr, int i, int i2) {
            super();
            if (bArr != null) {
                int i3 = i2 + 0;
                if ((i2 | 0 | (bArr.length - i3)) >= 0) {
                    this.buffer = bArr;
                    this.offset = 0;
                    this.position = 0;
                    this.limit = i3;
                    return;
                }
                throw new IllegalArgumentException(String.format("Array range is invalid. Buffer.length=%d, offset=%d, length=%d", Integer.valueOf(bArr.length), 0, Integer.valueOf(i2)));
            }
            throw new NullPointerException("buffer");
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void writeTag(int i, int i2) throws IOException {
            zzay((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzh(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzax(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzi(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzay(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzk(int i, int i2) throws IOException {
            writeTag(i, 5);
            zzba(i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, long j) throws IOException {
            writeTag(i, 0);
            zzs(j);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzc(int i, long j) throws IOException {
            writeTag(i, 1);
            zzu(j);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, boolean z) throws IOException {
            writeTag(i, 0);
            zzc(z ? (byte) 1 : 0);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, String str) throws IOException {
            writeTag(i, 2);
            zzx(str);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, zzfm zzfm) throws IOException {
            writeTag(i, 2);
            zza(zzfm);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(zzfm zzfm) throws IOException {
            zzay(zzfm.size());
            zzfm.zza(this);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zze(byte[] bArr, int i, int i2) throws IOException {
            zzay(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, zzih zzih, zziw zziw) throws IOException {
            writeTag(i, 2);
            zzey zzey = (zzey) zzih;
            int zzdm = zzey.zzdm();
            if (zzdm == -1) {
                zzdm = zziw.zzs(zzey);
                zzey.zzae(zzdm);
            }
            zzay(zzdm);
            zziw.zza(zzih, this.zzth);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zza(int i, zzih zzih) throws IOException {
            writeTag(1, 3);
            zzi(2, i);
            writeTag(3, 2);
            zzb(zzih);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzb(int i, zzfm zzfm) throws IOException {
            writeTag(1, 3);
            zzi(2, i);
            zza(3, zzfm);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzb(zzih zzih) throws IOException {
            zzay(zzih.zzgg());
            zzih.zzb(this);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzc(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzax(int i) throws IOException {
            if (i >= 0) {
                zzay(i);
            } else {
                zzs((long) i);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzay(int i) throws IOException {
            if (!zzgf.zztg || zzff.zzds() || zzfh() < 5) {
                while ((i & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr[i2] = (byte) ((i & 127) | 128);
                    i >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    bArr2[i3] = (byte) i;
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else if ((i & -128) == 0) {
                byte[] bArr3 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzju.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzju.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzju.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzju.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzju.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzju.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzju.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzju.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzju.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzba(int i) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i2 = this.position;
                int i3 = i2 + 1;
                this.position = i3;
                bArr[i2] = (byte) i;
                byte[] bArr2 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr2[i3] = (byte) (i >> 8);
                byte[] bArr3 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr3[i4] = (byte) (i >> 16);
                byte[] bArr4 = this.buffer;
                this.position = i5 + 1;
                bArr4[i5] = (byte) (i >>> 24);
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzs(long j) throws IOException {
            if (!zzgf.zztg || zzfh() < 10) {
                while ((j & -128) != 0) {
                    byte[] bArr = this.buffer;
                    int i = this.position;
                    this.position = i + 1;
                    bArr[i] = (byte) ((((int) j) & 127) | 128);
                    j >>>= 7;
                }
                try {
                    byte[] bArr2 = this.buffer;
                    int i2 = this.position;
                    this.position = i2 + 1;
                    bArr2[i2] = (byte) ((int) j);
                } catch (IndexOutOfBoundsException e) {
                    throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
                }
            } else {
                while ((j & -128) != 0) {
                    byte[] bArr3 = this.buffer;
                    int i3 = this.position;
                    this.position = i3 + 1;
                    zzju.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzju.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzu(long j) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                int i2 = i + 1;
                this.position = i2;
                bArr[i] = (byte) ((int) j);
                byte[] bArr2 = this.buffer;
                int i3 = i2 + 1;
                this.position = i3;
                bArr2[i2] = (byte) ((int) (j >> 8));
                byte[] bArr3 = this.buffer;
                int i4 = i3 + 1;
                this.position = i4;
                bArr3[i3] = (byte) ((int) (j >> 16));
                byte[] bArr4 = this.buffer;
                int i5 = i4 + 1;
                this.position = i5;
                bArr4[i4] = (byte) ((int) (j >> 24));
                byte[] bArr5 = this.buffer;
                int i6 = i5 + 1;
                this.position = i6;
                bArr5[i5] = (byte) ((int) (j >> 32));
                byte[] bArr6 = this.buffer;
                int i7 = i6 + 1;
                this.position = i7;
                bArr6[i6] = (byte) ((int) (j >> 40));
                byte[] bArr7 = this.buffer;
                int i8 = i7 + 1;
                this.position = i8;
                bArr7[i7] = (byte) ((int) (j >> 48));
                byte[] bArr8 = this.buffer;
                this.position = i8 + 1;
                bArr8[i8] = (byte) ((int) (j >> 56));
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        private final void write(byte[] bArr, int i, int i2) throws IOException {
            try {
                System.arraycopy(bArr, i, this.buffer, this.position, i2);
                this.position += i2;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), Integer.valueOf(i2)), e);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzfn
        public final void zzc(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final void zzx(String str) throws IOException {
            int i = this.position;
            try {
                int zzbd = zzbd(str.length() * 3);
                int zzbd2 = zzbd(str.length());
                if (zzbd2 == zzbd) {
                    int i2 = i + zzbd2;
                    this.position = i2;
                    int zza = zzjx.zza(str, this.buffer, i2, zzfh());
                    this.position = i;
                    zzay((zza - i) - zzbd2);
                    this.position = zza;
                    return;
                }
                zzay(zzjx.zza(str));
                this.position = zzjx.zza(str, this.buffer, this.position, zzfh());
            } catch (zzka e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        @Override // com.google.android.gms.internal.vision.zzgf
        public final int zzfh() {
            return this.limit - this.position;
        }
    }

    public final void zzt(long j) throws IOException {
        zzs(zzaa(j));
    }

    public final void zzs(float f) throws IOException {
        zzba(Float.floatToRawIntBits(f));
    }

    public final void zza(double d) throws IOException {
        zzu(Double.doubleToRawLongBits(d));
    }

    public final void zzk(boolean z) throws IOException {
        zzc(z ? (byte) 1 : 0);
    }

    public static int zzl(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzm(int i, int i2) {
        return zzbb(i) + zzbd(i2);
    }

    public static int zzn(int i, int i2) {
        return zzbb(i) + zzbd(zzbi(i2));
    }

    public static int zzo(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzp(int i, int i2) {
        return zzbb(i) + 4;
    }

    public static int zzd(int i, long j) {
        return zzbb(i) + zzw(j);
    }

    public static int zze(int i, long j) {
        return zzbb(i) + zzw(j);
    }

    public static int zzf(int i, long j) {
        return zzbb(i) + zzw(zzaa(j));
    }

    public static int zzg(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzh(int i, long j) {
        return zzbb(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzbb(i) + 4;
    }

    public static int zzb(int i, double d) {
        return zzbb(i) + 8;
    }

    public static int zzb(int i, boolean z) {
        return zzbb(i) + 1;
    }

    public static int zzq(int i, int i2) {
        return zzbb(i) + zzbc(i2);
    }

    public static int zzb(int i, String str) {
        return zzbb(i) + zzy(str);
    }

    public static int zzc(int i, zzfm zzfm) {
        int zzbb = zzbb(i);
        int size = zzfm.size();
        return zzbb + zzbd(size) + size;
    }

    public static int zza(int i, zzhm zzhm) {
        int zzbb = zzbb(i);
        int zzgg = zzhm.zzgg();
        return zzbb + zzbd(zzgg) + zzgg;
    }

    static int zzb(int i, zzih zzih, zziw zziw) {
        return zzbb(i) + zza(zzih, zziw);
    }

    public static int zzb(int i, zzih zzih) {
        return (zzbb(1) << 1) + zzm(2, i) + zzbb(3) + zzc(zzih);
    }

    public static int zzd(int i, zzfm zzfm) {
        return (zzbb(1) << 1) + zzm(2, i) + zzc(3, zzfm);
    }

    public static int zzb(int i, zzhm zzhm) {
        return (zzbb(1) << 1) + zzm(2, i) + zza(3, zzhm);
    }

    public static int zzbb(int i) {
        return zzbd(i << 3);
    }

    public static int zzbc(int i) {
        if (i >= 0) {
            return zzbd(i);
        }
        return 10;
    }

    public static int zzbe(int i) {
        return zzbd(zzbi(i));
    }

    public static int zzv(long j) {
        return zzw(j);
    }

    public static int zzx(long j) {
        return zzw(zzaa(j));
    }

    public static int zzbh(int i) {
        return zzbc(i);
    }

    public static int zzy(String str) {
        int i;
        try {
            i = zzjx.zza(str);
        } catch (zzka unused) {
            i = str.getBytes(zzgy.UTF_8).length;
        }
        return zzbd(i) + i;
    }

    public static int zza(zzhm zzhm) {
        int zzgg = zzhm.zzgg();
        return zzbd(zzgg) + zzgg;
    }

    public static int zzb(zzfm zzfm) {
        int size = zzfm.size();
        return zzbd(size) + size;
    }

    public static int zzf(byte[] bArr) {
        int length = bArr.length;
        return zzbd(length) + length;
    }

    public static int zzc(zzih zzih) {
        int zzgg = zzih.zzgg();
        return zzbd(zzgg) + zzgg;
    }

    static int zza(zzih zzih, zziw zziw) {
        zzey zzey = (zzey) zzih;
        int zzdm = zzey.zzdm();
        if (zzdm == -1) {
            zzdm = zziw.zzs(zzey);
            zzey.zzae(zzdm);
        }
        return zzbd(zzdm) + zzdm;
    }

    public final void zzfi() {
        if (zzfh() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzka zzka) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzka);
        byte[] bytes = str.getBytes(zzgy.UTF_8);
        try {
            zzay(bytes.length);
            zzc(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzih zzih, zziw zziw) {
        int zzbb = zzbb(i) << 1;
        zzey zzey = (zzey) zzih;
        int zzdm = zzey.zzdm();
        if (zzdm == -1) {
            zzdm = zziw.zzs(zzey);
            zzey.zzae(zzdm);
        }
        return zzbb + zzdm;
    }

    @Deprecated
    public static int zzd(zzih zzih) {
        return zzih.zzgg();
    }

    @Deprecated
    public static int zzbj(int i) {
        return zzbd(i);
    }
}
