package com.google.android.gms.internal.ads;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class zzefl extends zzeeo {
    private static final Logger logger = Logger.getLogger(zzefl.class.getName());
    /* access modifiers changed from: private */
    public static final boolean zziay = zzejf.zzbhv();
    zzefn zziaz;

    public static int zzbt(boolean z) {
        return 1;
    }

    public static int zzc(double d) {
        return 8;
    }

    public static int zzfm(long j) {
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

    public static int zzfo(long j) {
        return 8;
    }

    public static int zzfp(long j) {
        return 8;
    }

    private static long zzfq(long j) {
        return (j >> 63) ^ (j << 1);
    }

    public static int zzg(float f) {
        return 4;
    }

    public static int zzgr(int i) {
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

    public static int zzgt(int i) {
        return 4;
    }

    public static int zzgu(int i) {
        return 4;
    }

    private static int zzgw(int i) {
        return (i >> 31) ^ (i << 1);
    }

    public static zzefl zzw(byte[] bArr) {
        return new zzb(bArr, 0, bArr.length);
    }

    public abstract void writeTag(int i, int i2) throws IOException;

    public abstract void zza(int i, zzeer zzeer) throws IOException;

    public abstract void zza(int i, zzehl zzehl) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zza(int i, zzehl zzehl, zzeih zzeih) throws IOException;

    public abstract void zzab(int i, int i2) throws IOException;

    public abstract void zzac(int i, int i2) throws IOException;

    public abstract void zzae(int i, int i2) throws IOException;

    public abstract void zzah(zzeer zzeer) throws IOException;

    public abstract void zzb(int i, zzeer zzeer) throws IOException;

    public abstract int zzbem();

    public abstract void zzd(byte b) throws IOException;

    public abstract void zzfi(long j) throws IOException;

    public abstract void zzfk(long j) throws IOException;

    public abstract void zzg(zzehl zzehl) throws IOException;

    public abstract void zzgl(int i) throws IOException;

    public abstract void zzgm(int i) throws IOException;

    public abstract void zzgo(int i) throws IOException;

    public abstract void zzh(int i, long j) throws IOException;

    public abstract void zzh(int i, boolean z) throws IOException;

    public abstract void zzht(String str) throws IOException;

    public abstract void zzj(int i, long j) throws IOException;

    public abstract void zzk(int i, String str) throws IOException;

    /* access modifiers changed from: package-private */
    public abstract void zzk(byte[] bArr, int i, int i2) throws IOException;

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
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
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzefl.zza.<init>(java.lang.String, java.lang.Throwable):void");
        }
    }

    private zzefl() {
    }

    public final void zzad(int i, int i2) throws IOException {
        zzac(i, zzgw(i2));
    }

    public final void zzi(int i, long j) throws IOException {
        zzh(i, zzfq(j));
    }

    public final void zza(int i, float f) throws IOException {
        zzae(i, Float.floatToRawIntBits(f));
    }

    public final void zzb(int i, double d) throws IOException {
        zzj(i, Double.doubleToRawLongBits(d));
    }

    public final void zzgn(int i) throws IOException {
        zzgm(zzgw(i));
    }

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    static class zzb extends zzefl {
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

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void writeTag(int i, int i2) throws IOException {
            zzgm((i << 3) | i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzab(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgl(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzac(int i, int i2) throws IOException {
            writeTag(i, 0);
            zzgm(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzae(int i, int i2) throws IOException {
            writeTag(i, 5);
            zzgo(i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzh(int i, long j) throws IOException {
            writeTag(i, 0);
            zzfi(j);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzj(int i, long j) throws IOException {
            writeTag(i, 1);
            zzfk(j);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzh(int i, boolean z) throws IOException {
            writeTag(i, 0);
            zzd(z ? (byte) 1 : 0);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzk(int i, String str) throws IOException {
            writeTag(i, 2);
            zzht(str);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zza(int i, zzeer zzeer) throws IOException {
            writeTag(i, 2);
            zzah(zzeer);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzah(zzeer zzeer) throws IOException {
            zzgm(zzeer.size());
            zzeer.zza(this);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzk(byte[] bArr, int i, int i2) throws IOException {
            zzgm(i2);
            write(bArr, 0, i2);
        }

        /* access modifiers changed from: package-private */
        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zza(int i, zzehl zzehl, zzeih zzeih) throws IOException {
            writeTag(i, 2);
            zzeeh zzeeh = (zzeeh) zzehl;
            int zzbcu = zzeeh.zzbcu();
            if (zzbcu == -1) {
                zzbcu = zzeih.zzat(zzeeh);
                zzeeh.zzfp(zzbcu);
            }
            zzgm(zzbcu);
            zzeih.zza(zzehl, this.zziaz);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zza(int i, zzehl zzehl) throws IOException {
            writeTag(1, 3);
            zzac(2, i);
            writeTag(3, 2);
            zzg(zzehl);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzb(int i, zzeer zzeer) throws IOException {
            writeTag(1, 3);
            zzac(2, i);
            zza(3, zzeer);
            writeTag(1, 4);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzg(zzehl zzehl) throws IOException {
            zzgm(zzehl.zzbfe());
            zzehl.zzb(this);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzd(byte b) throws IOException {
            try {
                byte[] bArr = this.buffer;
                int i = this.position;
                this.position = i + 1;
                bArr[i] = b;
            } catch (IndexOutOfBoundsException e) {
                throw new zza(String.format("Pos: %d, limit: %d, len: %d", Integer.valueOf(this.position), Integer.valueOf(this.limit), 1), e);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzgl(int i) throws IOException {
            if (i >= 0) {
                zzgm(i);
            } else {
                zzfi((long) i);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzgm(int i) throws IOException {
            if (!zzefl.zziay || zzeek.zzbcw() || zzbem() < 5) {
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
                zzejf.zza(bArr3, (long) i4, (byte) i);
            } else {
                byte[] bArr4 = this.buffer;
                int i5 = this.position;
                this.position = i5 + 1;
                zzejf.zza(bArr4, (long) i5, (byte) (i | 128));
                int i6 = i >>> 7;
                if ((i6 & -128) == 0) {
                    byte[] bArr5 = this.buffer;
                    int i7 = this.position;
                    this.position = i7 + 1;
                    zzejf.zza(bArr5, (long) i7, (byte) i6);
                    return;
                }
                byte[] bArr6 = this.buffer;
                int i8 = this.position;
                this.position = i8 + 1;
                zzejf.zza(bArr6, (long) i8, (byte) (i6 | 128));
                int i9 = i6 >>> 7;
                if ((i9 & -128) == 0) {
                    byte[] bArr7 = this.buffer;
                    int i10 = this.position;
                    this.position = i10 + 1;
                    zzejf.zza(bArr7, (long) i10, (byte) i9);
                    return;
                }
                byte[] bArr8 = this.buffer;
                int i11 = this.position;
                this.position = i11 + 1;
                zzejf.zza(bArr8, (long) i11, (byte) (i9 | 128));
                int i12 = i9 >>> 7;
                if ((i12 & -128) == 0) {
                    byte[] bArr9 = this.buffer;
                    int i13 = this.position;
                    this.position = i13 + 1;
                    zzejf.zza(bArr9, (long) i13, (byte) i12);
                    return;
                }
                byte[] bArr10 = this.buffer;
                int i14 = this.position;
                this.position = i14 + 1;
                zzejf.zza(bArr10, (long) i14, (byte) (i12 | 128));
                byte[] bArr11 = this.buffer;
                int i15 = this.position;
                this.position = i15 + 1;
                zzejf.zza(bArr11, (long) i15, (byte) (i12 >>> 7));
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzgo(int i) throws IOException {
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

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzfi(long j) throws IOException {
            if (!zzefl.zziay || zzbem() < 10) {
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
                    zzejf.zza(bArr3, (long) i3, (byte) ((((int) j) & 127) | 128));
                    j >>>= 7;
                }
                byte[] bArr4 = this.buffer;
                int i4 = this.position;
                this.position = i4 + 1;
                zzejf.zza(bArr4, (long) i4, (byte) ((int) j));
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzfk(long j) throws IOException {
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

        @Override // com.google.android.gms.internal.ads.zzeeo
        public final void zzh(byte[] bArr, int i, int i2) throws IOException {
            write(bArr, i, i2);
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final void zzht(String str) throws IOException {
            int i = this.position;
            try {
                int zzgr = zzgr(str.length() * 3);
                int zzgr2 = zzgr(str.length());
                if (zzgr2 == zzgr) {
                    int i2 = i + zzgr2;
                    this.position = i2;
                    int zza = zzeji.zza(str, this.buffer, i2, zzbem());
                    this.position = i;
                    zzgm((zza - i) - zzgr2);
                    this.position = zza;
                    return;
                }
                zzgm(zzeji.zza(str));
                this.position = zzeji.zza(str, this.buffer, this.position, zzbem());
            } catch (zzejl e) {
                this.position = i;
                zza(str, e);
            } catch (IndexOutOfBoundsException e2) {
                throw new zza(e2);
            }
        }

        @Override // com.google.android.gms.internal.ads.zzefl
        public final int zzbem() {
            return this.limit - this.position;
        }
    }

    public final void zzfj(long j) throws IOException {
        zzfi(zzfq(j));
    }

    public final void zzf(float f) throws IOException {
        zzgo(Float.floatToRawIntBits(f));
    }

    public final void zzb(double d) throws IOException {
        zzfk(Double.doubleToRawLongBits(d));
    }

    public final void zzbs(boolean z) throws IOException {
        zzd(z ? (byte) 1 : 0);
    }

    public static int zzaf(int i, int i2) {
        return zzgp(i) + zzgq(i2);
    }

    public static int zzag(int i, int i2) {
        return zzgp(i) + zzgr(i2);
    }

    public static int zzah(int i, int i2) {
        return zzgp(i) + zzgr(zzgw(i2));
    }

    public static int zzai(int i, int i2) {
        return zzgp(i) + 4;
    }

    public static int zzaj(int i, int i2) {
        return zzgp(i) + 4;
    }

    public static int zzk(int i, long j) {
        return zzgp(i) + zzfm(j);
    }

    public static int zzl(int i, long j) {
        return zzgp(i) + zzfm(j);
    }

    public static int zzm(int i, long j) {
        return zzgp(i) + zzfm(zzfq(j));
    }

    public static int zzn(int i, long j) {
        return zzgp(i) + 8;
    }

    public static int zzo(int i, long j) {
        return zzgp(i) + 8;
    }

    public static int zzb(int i, float f) {
        return zzgp(i) + 4;
    }

    public static int zzc(int i, double d) {
        return zzgp(i) + 8;
    }

    public static int zzi(int i, boolean z) {
        return zzgp(i) + 1;
    }

    public static int zzak(int i, int i2) {
        return zzgp(i) + zzgq(i2);
    }

    public static int zzl(int i, String str) {
        return zzgp(i) + zzhu(str);
    }

    public static int zzc(int i, zzeer zzeer) {
        int zzgp = zzgp(i);
        int size = zzeer.size();
        return zzgp + zzgr(size) + size;
    }

    public static int zza(int i, zzegu zzegu) {
        int zzgp = zzgp(i);
        int zzbfe = zzegu.zzbfe();
        return zzgp + zzgr(zzbfe) + zzbfe;
    }

    static int zzb(int i, zzehl zzehl, zzeih zzeih) {
        return zzgp(i) + zza(zzehl, zzeih);
    }

    public static int zzb(int i, zzehl zzehl) {
        return (zzgp(1) << 1) + zzag(2, i) + zzgp(3) + zzh(zzehl);
    }

    public static int zzd(int i, zzeer zzeer) {
        return (zzgp(1) << 1) + zzag(2, i) + zzc(3, zzeer);
    }

    public static int zzb(int i, zzegu zzegu) {
        return (zzgp(1) << 1) + zzag(2, i) + zza(3, zzegu);
    }

    public static int zzgp(int i) {
        return zzgr(i << 3);
    }

    public static int zzgq(int i) {
        if (i >= 0) {
            return zzgr(i);
        }
        return 10;
    }

    public static int zzgs(int i) {
        return zzgr(zzgw(i));
    }

    public static int zzfl(long j) {
        return zzfm(j);
    }

    public static int zzfn(long j) {
        return zzfm(zzfq(j));
    }

    public static int zzgv(int i) {
        return zzgq(i);
    }

    public static int zzhu(String str) {
        int i;
        try {
            i = zzeji.zza(str);
        } catch (zzejl unused) {
            i = str.getBytes(zzegd.UTF_8).length;
        }
        return zzgr(i) + i;
    }

    public static int zza(zzegu zzegu) {
        int zzbfe = zzegu.zzbfe();
        return zzgr(zzbfe) + zzbfe;
    }

    public static int zzai(zzeer zzeer) {
        int size = zzeer.size();
        return zzgr(size) + size;
    }

    public static int zzx(byte[] bArr) {
        int length = bArr.length;
        return zzgr(length) + length;
    }

    public static int zzh(zzehl zzehl) {
        int zzbfe = zzehl.zzbfe();
        return zzgr(zzbfe) + zzbfe;
    }

    static int zza(zzehl zzehl, zzeih zzeih) {
        zzeeh zzeeh = (zzeeh) zzehl;
        int zzbcu = zzeeh.zzbcu();
        if (zzbcu == -1) {
            zzbcu = zzeih.zzat(zzeeh);
            zzeeh.zzfp(zzbcu);
        }
        return zzgr(zzbcu) + zzbcu;
    }

    public final void zzben() {
        if (zzbem() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, zzejl zzejl) throws IOException {
        logger.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) zzejl);
        byte[] bytes = str.getBytes(zzegd.UTF_8);
        try {
            zzgm(bytes.length);
            zzh(bytes, 0, bytes.length);
        } catch (IndexOutOfBoundsException e) {
            throw new zza(e);
        } catch (zza e2) {
            throw e2;
        }
    }

    @Deprecated
    static int zzc(int i, zzehl zzehl, zzeih zzeih) {
        int zzgp = zzgp(i) << 1;
        zzeeh zzeeh = (zzeeh) zzehl;
        int zzbcu = zzeeh.zzbcu();
        if (zzbcu == -1) {
            zzbcu = zzeih.zzat(zzeeh);
            zzeeh.zzfp(zzbcu);
        }
        return zzgp + zzbcu;
    }

    @Deprecated
    public static int zzi(zzehl zzehl) {
        return zzehl.zzbfe();
    }

    @Deprecated
    public static int zzgx(int i) {
        return zzgr(i);
    }
}
