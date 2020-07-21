package com.google.android.gms.internal.vision;

import com.itextpdf.text.pdf.BidiOrder;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzfl extends zzfj {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int tag;
    private final boolean zzsj = true;
    private final int zzsk;
    private int zzsl;

    public zzfl(ByteBuffer byteBuffer, boolean z) {
        super(null);
        this.buffer = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.pos = arrayOffset;
        this.zzsk = arrayOffset;
        this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final boolean zzdu() {
        return this.pos == this.limit;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdv() throws IOException {
        if (zzdu()) {
            return Integer.MAX_VALUE;
        }
        int zzel = zzel();
        this.tag = zzel;
        if (zzel == this.zzsl) {
            return Integer.MAX_VALUE;
        }
        return zzel >>> 3;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int getTag() {
        return this.tag;
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0037  */
    @Override // com.google.android.gms.internal.vision.zzix
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdw() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzdu()
            r1 = 0
            if (r0 != 0) goto L_0x0085
            int r0 = r7.tag
            int r2 = r7.zzsl
            if (r0 != r2) goto L_0x000f
            goto L_0x0085
        L_0x000f:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L_0x0059
            if (r3 == r4) goto L_0x0053
            r1 = 2
            if (r3 == r1) goto L_0x004b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L_0x0029
            r0 = 5
            if (r3 != r0) goto L_0x0024
            r7.zzai(r1)
            return r4
        L_0x0024:
            com.google.android.gms.internal.vision.zzhg r0 = com.google.android.gms.internal.vision.zzhh.zzgs()
            throw r0
        L_0x0029:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.zzsl = r0
        L_0x002e:
            int r0 = r7.zzdv()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x003d
            boolean r0 = r7.zzdw()
            if (r0 != 0) goto L_0x002e
        L_0x003d:
            int r0 = r7.tag
            int r1 = r7.zzsl
            if (r0 != r1) goto L_0x0046
            r7.zzsl = r2
            return r4
        L_0x0046:
            com.google.android.gms.internal.vision.zzhh r0 = com.google.android.gms.internal.vision.zzhh.zzgt()
            throw r0
        L_0x004b:
            int r0 = r7.zzel()
            r7.zzai(r0)
            return r4
        L_0x0053:
            r0 = 8
            r7.zzai(r0)
            return r4
        L_0x0059:
            int r0 = r7.limit
            int r2 = r7.pos
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L_0x0074
            byte[] r0 = r7.buffer
            r5 = 0
        L_0x0065:
            if (r5 >= r3) goto L_0x0074
            int r6 = r2 + 1
            byte r2 = r0[r2]
            if (r2 < 0) goto L_0x0070
            r7.pos = r6
            goto L_0x007f
        L_0x0070:
            int r5 = r5 + 1
            r2 = r6
            goto L_0x0065
        L_0x0074:
            if (r1 >= r3) goto L_0x0080
            byte r0 = r7.readByte()
            if (r0 >= 0) goto L_0x007f
            int r1 = r1 + 1
            goto L_0x0074
        L_0x007f:
            return r4
        L_0x0080:
            com.google.android.gms.internal.vision.zzhh r0 = com.google.android.gms.internal.vision.zzhh.zzgp()
            throw r0
        L_0x0085:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfl.zzdw():boolean");
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final double readDouble() throws IOException {
        zzak(1);
        return Double.longBitsToDouble(zzep());
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final float readFloat() throws IOException {
        zzak(5);
        return Float.intBitsToFloat(zzeo());
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdx() throws IOException {
        zzak(0);
        return zzem();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzdy() throws IOException {
        zzak(0);
        return zzem();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzdz() throws IOException {
        zzak(0);
        return zzel();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzea() throws IOException {
        zzak(1);
        return zzep();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeb() throws IOException {
        zzak(5);
        return zzeo();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final boolean zzec() throws IOException {
        zzak(0);
        if (zzel() != 0) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String readString() throws IOException {
        return zzj(false);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final String zzed() throws IOException {
        return zzj(true);
    }

    private final String zzj(boolean z) throws IOException {
        zzak(2);
        int zzel = zzel();
        if (zzel == 0) {
            return "";
        }
        zzaj(zzel);
        if (z) {
            byte[] bArr = this.buffer;
            int i = this.pos;
            if (!zzjx.zzf(bArr, i, i + zzel)) {
                throw zzhh.zzgu();
            }
        }
        String str = new String(this.buffer, this.pos, zzel, zzgy.UTF_8);
        this.pos += zzel;
        return str;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zza(Class<T> cls, zzgi zzgi) throws IOException {
        zzak(2);
        return zzb(zzis.zzhp().zzf(cls), zzgi);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zza(zziw<T> zziw, zzgi zzgi) throws IOException {
        zzak(2);
        return zzb(zziw, zzgi);
    }

    private final <T> T zzb(zziw<T> zziw, zzgi zzgi) throws IOException {
        int zzel = zzel();
        zzaj(zzel);
        int i = this.limit;
        int i2 = this.pos + zzel;
        this.limit = i2;
        try {
            T newInstance = zziw.newInstance();
            zziw.zza(newInstance, this, zzgi);
            zziw.zzh(newInstance);
            if (this.pos == i2) {
                return newInstance;
            }
            throw zzhh.zzgt();
        } finally {
            this.limit = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zzb(Class<T> cls, zzgi zzgi) throws IOException {
        zzak(3);
        return zzd(zzis.zzhp().zzf(cls), zzgi);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> T zzc(zziw<T> zziw, zzgi zzgi) throws IOException {
        zzak(3);
        return zzd(zziw, zzgi);
    }

    private final <T> T zzd(zziw<T> zziw, zzgi zzgi) throws IOException {
        int i = this.zzsl;
        this.zzsl = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zziw.newInstance();
            zziw.zza(newInstance, this, zzgi);
            zziw.zzh(newInstance);
            if (this.tag == this.zzsl) {
                return newInstance;
            }
            throw zzhh.zzgt();
        } finally {
            this.zzsl = i;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final zzfm zzee() throws IOException {
        zzfm zzfm;
        zzak(2);
        int zzel = zzel();
        if (zzel == 0) {
            return zzfm.zzsm;
        }
        zzaj(zzel);
        if (this.zzsj) {
            zzfm = zzfm.zzb(this.buffer, this.pos, zzel);
        } else {
            zzfm = zzfm.zza(this.buffer, this.pos, zzel);
        }
        this.pos += zzel;
        return zzfm;
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzef() throws IOException {
        zzak(0);
        return zzel();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeg() throws IOException {
        zzak(0);
        return zzel();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzeh() throws IOException {
        zzak(5);
        return zzeo();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzei() throws IOException {
        zzak(1);
        return zzep();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final int zzej() throws IOException {
        zzak(0);
        return zzfy.zzav(zzel());
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final long zzek() throws IOException {
        zzak(0);
        return zzfy.zzr(zzem());
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zza(List<Double> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgg) {
            zzgg zzgg = (zzgg) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzgg.zzc(readDouble());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = zzel();
                zzal(zzel);
                int i4 = this.pos + zzel;
                while (this.pos < i4) {
                    zzgg.zzc(Double.longBitsToDouble(zzer()));
                }
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Double.valueOf(readDouble()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzel2 = zzel();
                zzal(zzel2);
                int i6 = this.pos + zzel2;
                while (this.pos < i6) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzer())));
                }
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzb(List<Float> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgt) {
            zzgt zzgt = (zzgt) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzel = zzel();
                zzam(zzel);
                int i4 = this.pos + zzel;
                while (this.pos < i4) {
                    zzgt.zzu(Float.intBitsToFloat(zzeq()));
                }
            } else if (i3 == 5) {
                do {
                    zzgt.zzu(readFloat());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzel2 = zzel();
                zzam(zzel2);
                int i6 = this.pos + zzel2;
                while (this.pos < i6) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzeq())));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzc(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhv.zzac(zzdx());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = this.pos + zzel();
                while (this.pos < zzel) {
                    zzhv.zzac(zzem());
                }
                zzan(zzel);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzdx()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzel2 = this.pos + zzel();
                while (this.pos < zzel2) {
                    list.add(Long.valueOf(zzem()));
                }
                zzan(zzel2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzd(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhv.zzac(zzdy());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = this.pos + zzel();
                while (this.pos < zzel) {
                    zzhv.zzac(zzem());
                }
                zzan(zzel);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzdy()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzel2 = this.pos + zzel();
                while (this.pos < zzel2) {
                    list.add(Long.valueOf(zzem()));
                }
                zzan(zzel2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zze(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgz.zzbm(zzdz());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = this.pos + zzel();
                while (this.pos < zzel) {
                    zzgz.zzbm(zzel());
                }
                zzan(zzel);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzdz()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzel2 = this.pos + zzel();
                while (this.pos < zzel2) {
                    list.add(Integer.valueOf(zzel()));
                }
                zzan(zzel2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzf(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzhv.zzac(zzea());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = zzel();
                zzal(zzel);
                int i4 = this.pos + zzel;
                while (this.pos < i4) {
                    zzhv.zzac(zzer());
                }
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzea()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzel2 = zzel();
                zzal(zzel2);
                int i6 = this.pos + zzel2;
                while (this.pos < i6) {
                    list.add(Long.valueOf(zzer()));
                }
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzg(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzel = zzel();
                zzam(zzel);
                int i4 = this.pos + zzel;
                while (this.pos < i4) {
                    zzgz.zzbm(zzeq());
                }
            } else if (i3 == 5) {
                do {
                    zzgz.zzbm(zzeb());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzel2 = zzel();
                zzam(zzel2);
                int i6 = this.pos + zzel2;
                while (this.pos < i6) {
                    list.add(Integer.valueOf(zzeq()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzeb()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzh(List<Boolean> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzfk) {
            zzfk zzfk = (zzfk) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzfk.addBoolean(zzec());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = this.pos + zzel();
                while (this.pos < zzel) {
                    zzfk.addBoolean(zzel() != 0);
                }
                zzan(zzel);
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Boolean.valueOf(zzec()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzel2 = this.pos + zzel();
                while (this.pos < zzel2) {
                    list.add(Boolean.valueOf(zzel() != 0));
                }
                zzan(zzel2);
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    private final void zza(List<String> list, boolean z) throws IOException {
        int i;
        int i2;
        if ((this.tag & 7) != 2) {
            throw zzhh.zzgs();
        } else if (!(list instanceof zzho) || z) {
            do {
                list.add(zzj(z));
                if (!zzdu()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzel() == this.tag);
            this.pos = i;
        } else {
            zzho zzho = (zzho) list;
            do {
                zzho.zzc(zzee());
                if (!zzdu()) {
                    i2 = this.pos;
                } else {
                    return;
                }
            } while (zzel() == this.tag);
            this.pos = i2;
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zza(List<T> list, zziw<T> zziw, zzgi zzgi) throws IOException {
        int i;
        int i2 = this.tag;
        if ((i2 & 7) == 2) {
            do {
                list.add(zzb(zziw, zzgi));
                if (!zzdu()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzel() == i2);
            this.pos = i;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <T> void zzb(List<T> list, zziw<T> zziw, zzgi zzgi) throws IOException {
        int i;
        int i2 = this.tag;
        if ((i2 & 7) == 3) {
            do {
                list.add(zzd(zziw, zzgi));
                if (!zzdu()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzel() == i2);
            this.pos = i;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzj(List<zzfm> list) throws IOException {
        int i;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzee());
                if (!zzdu()) {
                    i = this.pos;
                } else {
                    return;
                }
            } while (zzel() == this.tag);
            this.pos = i;
            return;
        }
        throw zzhh.zzgs();
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzk(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgz.zzbm(zzef());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = this.pos + zzel();
                while (this.pos < zzel) {
                    zzgz.zzbm(zzel());
                }
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzef()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzel2 = this.pos + zzel();
                while (this.pos < zzel2) {
                    list.add(Integer.valueOf(zzel()));
                }
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzl(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgz.zzbm(zzeg());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = this.pos + zzel();
                while (this.pos < zzel) {
                    zzgz.zzbm(zzel());
                }
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzeg()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzel2 = this.pos + zzel();
                while (this.pos < zzel2) {
                    list.add(Integer.valueOf(zzel()));
                }
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzm(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 2) {
                int zzel = zzel();
                zzam(zzel);
                int i4 = this.pos + zzel;
                while (this.pos < i4) {
                    zzgz.zzbm(zzeq());
                }
            } else if (i3 == 5) {
                do {
                    zzgz.zzbm(zzeh());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 2) {
                int zzel2 = zzel();
                zzam(zzel2);
                int i6 = this.pos + zzel2;
                while (this.pos < i6) {
                    list.add(Integer.valueOf(zzeq()));
                }
            } else if (i5 == 5) {
                do {
                    list.add(Integer.valueOf(zzeh()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzn(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 1) {
                do {
                    zzhv.zzac(zzei());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = zzel();
                zzal(zzel);
                int i4 = this.pos + zzel;
                while (this.pos < i4) {
                    zzhv.zzac(zzer());
                }
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i5 = this.tag & 7;
            if (i5 == 1) {
                do {
                    list.add(Long.valueOf(zzei()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i5 == 2) {
                int zzel2 = zzel();
                zzal(zzel2);
                int i6 = this.pos + zzel2;
                while (this.pos < i6) {
                    list.add(Long.valueOf(zzer()));
                }
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzo(List<Integer> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzgz) {
            zzgz zzgz = (zzgz) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzgz.zzbm(zzej());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = this.pos + zzel();
                while (this.pos < zzel) {
                    zzgz.zzbm(zzfy.zzav(zzel()));
                }
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Integer.valueOf(zzej()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzel2 = this.pos + zzel();
                while (this.pos < zzel2) {
                    list.add(Integer.valueOf(zzfy.zzav(zzel())));
                }
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final void zzp(List<Long> list) throws IOException {
        int i;
        int i2;
        if (list instanceof zzhv) {
            zzhv zzhv = (zzhv) list;
            int i3 = this.tag & 7;
            if (i3 == 0) {
                do {
                    zzhv.zzac(zzek());
                    if (!zzdu()) {
                        i2 = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i2;
            } else if (i3 == 2) {
                int zzel = this.pos + zzel();
                while (this.pos < zzel) {
                    zzhv.zzac(zzfy.zzr(zzem()));
                }
            } else {
                throw zzhh.zzgs();
            }
        } else {
            int i4 = this.tag & 7;
            if (i4 == 0) {
                do {
                    list.add(Long.valueOf(zzek()));
                    if (!zzdu()) {
                        i = this.pos;
                    } else {
                        return;
                    }
                } while (zzel() == this.tag);
                this.pos = i;
            } else if (i4 == 2) {
                int zzel2 = this.pos + zzel();
                while (this.pos < zzel2) {
                    list.add(Long.valueOf(zzfy.zzr(zzem())));
                }
            } else {
                throw zzhh.zzgs();
            }
        }
    }

    @Override // com.google.android.gms.internal.vision.zzix
    public final <K, V> void zza(Map<K, V> map, zzhy<K, V> zzhy, zzgi zzgi) throws IOException {
        zzak(2);
        int zzel = zzel();
        zzaj(zzel);
        int i = this.limit;
        this.limit = this.pos + zzel;
        try {
            K k = zzhy.zzzc;
            V v = zzhy.zzgl;
            while (true) {
                int zzdv = zzdv();
                if (zzdv == Integer.MAX_VALUE) {
                    map.put(k, v);
                    return;
                } else if (zzdv == 1) {
                    k = zza(zzhy.zzzb, (Class<?>) null, (zzgi) null);
                } else if (zzdv != 2) {
                    try {
                        if (!zzdw()) {
                            throw new zzhh("Unable to parse map entry.");
                        }
                    } catch (zzhg unused) {
                        if (!zzdw()) {
                            throw new zzhh("Unable to parse map entry.");
                        }
                    }
                } else {
                    v = zza(zzhy.zzzd, zzhy.zzgl.getClass(), zzgi);
                }
            }
        } finally {
            this.limit = i;
        }
    }

    private final Object zza(zzkf zzkf, Class<?> cls, zzgi zzgi) throws IOException {
        switch (zzfi.zzsg[zzkf.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzec());
            case 2:
                return zzee();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzeg());
            case 5:
                return Integer.valueOf(zzeb());
            case 6:
                return Long.valueOf(zzea());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdz());
            case 9:
                return Long.valueOf(zzdy());
            case 10:
                return zza(cls, zzgi);
            case 11:
                return Integer.valueOf(zzeh());
            case 12:
                return Long.valueOf(zzei());
            case 13:
                return Integer.valueOf(zzej());
            case 14:
                return Long.valueOf(zzek());
            case 15:
                return zzj(true);
            case 16:
                return Integer.valueOf(zzef());
            case 17:
                return Long.valueOf(zzdx());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }

    private final int zzel() throws IOException {
        byte b;
        int i = this.pos;
        int i2 = this.limit;
        if (i2 != i) {
            byte[] bArr = this.buffer;
            int i3 = i + 1;
            byte b2 = bArr[i];
            if (b2 >= 0) {
                this.pos = i3;
                return b2;
            } else if (i2 - i3 < 9) {
                return (int) zzen();
            } else {
                int i4 = i3 + 1;
                byte b3 = b2 ^ (bArr[i3] << 7);
                if (b3 < 0) {
                    b = b3 ^ ByteCompanionObject.MIN_VALUE;
                } else {
                    int i5 = i4 + 1;
                    byte b4 = b3 ^ (bArr[i4] << BidiOrder.BN);
                    if (b4 >= 0) {
                        b = b4 ^ ByteCompanionObject.MIN_VALUE;
                    } else {
                        i4 = i5 + 1;
                        byte b5 = b4 ^ (bArr[i5] << 21);
                        if (b5 < 0) {
                            b = b5 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            i5 = i4 + 1;
                            byte b6 = bArr[i4];
                            b = (b5 ^ (b6 << 28)) ^ ByteCompanionObject.MIN_VALUE;
                            if (b6 < 0) {
                                i4 = i5 + 1;
                                if (bArr[i5] < 0) {
                                    i5 = i4 + 1;
                                    if (bArr[i4] < 0) {
                                        i4 = i5 + 1;
                                        if (bArr[i5] < 0) {
                                            i5 = i4 + 1;
                                            if (bArr[i4] < 0) {
                                                i4 = i5 + 1;
                                                if (bArr[i5] < 0) {
                                                    throw zzhh.zzgp();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i4 = i5;
                }
                this.pos = i4;
                return b;
            }
        } else {
            throw zzhh.zzgn();
        }
    }

    private final long zzem() throws IOException {
        long j;
        int i;
        long j2;
        long j3;
        byte b;
        int i2 = this.pos;
        int i3 = this.limit;
        if (i3 != i2) {
            byte[] bArr = this.buffer;
            int i4 = i2 + 1;
            byte b2 = bArr[i2];
            if (b2 >= 0) {
                this.pos = i4;
                return (long) b2;
            } else if (i3 - i4 < 9) {
                return zzen();
            } else {
                int i5 = i4 + 1;
                byte b3 = b2 ^ (bArr[i4] << 7);
                if (b3 < 0) {
                    b = b3 ^ ByteCompanionObject.MIN_VALUE;
                } else {
                    int i6 = i5 + 1;
                    byte b4 = b3 ^ (bArr[i5] << BidiOrder.BN);
                    if (b4 >= 0) {
                        i = i6;
                        j = (long) (b4 ^ ByteCompanionObject.MIN_VALUE);
                    } else {
                        i5 = i6 + 1;
                        byte b5 = b4 ^ (bArr[i6] << 21);
                        if (b5 < 0) {
                            b = b5 ^ ByteCompanionObject.MIN_VALUE;
                        } else {
                            long j4 = (long) b5;
                            int i7 = i5 + 1;
                            long j5 = j4 ^ (((long) bArr[i5]) << 28);
                            if (j5 >= 0) {
                                j3 = 266354560;
                            } else {
                                int i8 = i7 + 1;
                                long j6 = j5 ^ (((long) bArr[i7]) << 35);
                                if (j6 < 0) {
                                    j2 = -34093383808L;
                                } else {
                                    i7 = i8 + 1;
                                    j5 = j6 ^ (((long) bArr[i8]) << 42);
                                    if (j5 >= 0) {
                                        j3 = 4363953127296L;
                                    } else {
                                        i8 = i7 + 1;
                                        j6 = j5 ^ (((long) bArr[i7]) << 49);
                                        if (j6 < 0) {
                                            j2 = -558586000294016L;
                                        } else {
                                            int i9 = i8 + 1;
                                            long j7 = (j6 ^ (((long) bArr[i8]) << 56)) ^ 71499008037633920L;
                                            if (j7 < 0) {
                                                i = i9 + 1;
                                                if (((long) bArr[i9]) < 0) {
                                                    throw zzhh.zzgp();
                                                }
                                            } else {
                                                i = i9;
                                            }
                                            j = j7;
                                        }
                                    }
                                }
                                j = j6 ^ j2;
                            }
                            j = j5 ^ j3;
                            i = i7;
                        }
                    }
                    this.pos = i;
                    return j;
                }
                j = (long) b;
                this.pos = i;
                return j;
            }
        } else {
            throw zzhh.zzgn();
        }
    }

    private final long zzen() throws IOException {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte readByte = readByte();
            j |= ((long) (readByte & ByteCompanionObject.MAX_VALUE)) << i;
            if ((readByte & ByteCompanionObject.MIN_VALUE) == 0) {
                return j;
            }
        }
        throw zzhh.zzgp();
    }

    private final byte readByte() throws IOException {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzhh.zzgn();
    }

    private final int zzeo() throws IOException {
        zzaj(4);
        return zzeq();
    }

    private final long zzep() throws IOException {
        zzaj(8);
        return zzer();
    }

    private final int zzeq() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    private final long zzer() {
        int i = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzai(int i) throws IOException {
        zzaj(i);
        this.pos += i;
    }

    private final void zzaj(int i) throws IOException {
        if (i < 0 || i > this.limit - this.pos) {
            throw zzhh.zzgn();
        }
    }

    private final void zzak(int i) throws IOException {
        if ((this.tag & 7) != i) {
            throw zzhh.zzgs();
        }
    }

    private final void zzal(int i) throws IOException {
        zzaj(i);
        if ((i & 7) != 0) {
            throw zzhh.zzgt();
        }
    }

    private final void zzam(int i) throws IOException {
        zzaj(i);
        if ((i & 3) != 0) {
            throw zzhh.zzgt();
        }
    }

    private final void zzan(int i) throws IOException {
        if (this.pos != i) {
            throw zzhh.zzgn();
        }
    }
}
