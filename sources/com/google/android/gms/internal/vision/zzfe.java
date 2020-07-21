package com.google.android.gms.internal.vision;

import com.itextpdf.text.pdf.BidiOrder;
import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
final class zzfe {
    static int zza(byte[] bArr, int i, zzfg zzfg) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzfg);
        }
        zzfg.zzsd = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzfg zzfg) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzfg.zzsd = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzfg.zzsd = i5 | (b2 << BidiOrder.BN);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << BidiOrder.BN);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzfg.zzsd = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzfg.zzsd = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzfg.zzsd = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzfg zzfg) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzfg.zzse = j;
            return i2;
        }
        int i3 = i2 + 1;
        byte b = bArr[i2];
        long j2 = (j & 127) | (((long) (b & ByteCompanionObject.MAX_VALUE)) << 7);
        int i4 = 7;
        while (b < 0) {
            int i5 = i3 + 1;
            byte b2 = bArr[i3];
            i4 += 7;
            j2 |= ((long) (b2 & ByteCompanionObject.MAX_VALUE)) << i4;
            b = b2;
            i3 = i5;
        }
        zzfg.zzse = j2;
        return i3;
    }

    static int zza(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static long zzb(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzc(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzb(bArr, i));
    }

    static float zzd(byte[] bArr, int i) {
        return Float.intBitsToFloat(zza(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzfg zzfg) throws zzhh {
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        } else if (i2 == 0) {
            zzfg.zzsf = "";
            return zza;
        } else {
            zzfg.zzsf = new String(bArr, zza, i2, zzgy.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzfg zzfg) throws zzhh {
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        } else if (i2 == 0) {
            zzfg.zzsf = "";
            return zza;
        } else {
            zzfg.zzsf = zzjx.zzh(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzfg zzfg) throws zzhh {
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd;
        if (i2 < 0) {
            throw zzhh.zzgo();
        } else if (i2 > bArr.length - zza) {
            throw zzhh.zzgn();
        } else if (i2 == 0) {
            zzfg.zzsf = zzfm.zzsm;
            return zza;
        } else {
            zzfg.zzsf = zzfm.zza(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    static int zza(zziw zziw, byte[] bArr, int i, int i2, zzfg zzfg) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zza(b, bArr, i3, zzfg);
            b2 = zzfg.zzsd;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzhh.zzgn();
        }
        Object newInstance = zziw.newInstance();
        int i4 = b2 + i3;
        zziw.zza(newInstance, bArr, i3, i4, zzfg);
        zziw.zzh(newInstance);
        zzfg.zzsf = newInstance;
        return i4;
    }

    static int zza(zziw zziw, byte[] bArr, int i, int i2, int i3, zzfg zzfg) throws IOException {
        zzil zzil = (zzil) zziw;
        Object newInstance = zzil.newInstance();
        int zza = zzil.zza(newInstance, bArr, i, i2, i3, zzfg);
        zzil.zzh(newInstance);
        zzfg.zzsf = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzhe<?> zzhe, zzfg zzfg) {
        zzgz zzgz = (zzgz) zzhe;
        int zza = zza(bArr, i2, zzfg);
        zzgz.zzbm(zzfg.zzsd);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzfg);
            if (i != zzfg.zzsd) {
                break;
            }
            zza = zza(bArr, zza2, zzfg);
            zzgz.zzbm(zzfg.zzsd);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzgz zzgz = (zzgz) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzfg);
            zzgz.zzbm(zzfg.zzsd);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zzb(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzhv zzhv = (zzhv) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfg);
            zzhv.zzac(zzfg.zzse);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zzc(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzgz zzgz = (zzgz) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zzgz.zzbm(zza(bArr, zza));
            zza += 4;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zzd(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzhv zzhv = (zzhv) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zzhv.zzac(zzb(bArr, zza));
            zza += 8;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zze(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzgt zzgt = (zzgt) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zzgt.zzu(zzd(bArr, zza));
            zza += 4;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zzf(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzgg zzgg = (zzgg) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zzgg.zzc(zzc(bArr, zza));
            zza += 8;
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zzg(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzfk zzfk = (zzfk) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfg);
            zzfk.addBoolean(zzfg.zzse != 0);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zzh(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzgz zzgz = (zzgz) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzfg);
            zzgz.zzbm(zzfy.zzav(zzfg.zzsd));
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zzi(byte[] bArr, int i, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        zzhv zzhv = (zzhv) zzhe;
        int zza = zza(bArr, i, zzfg);
        int i2 = zzfg.zzsd + zza;
        while (zza < i2) {
            zza = zzb(bArr, zza, zzfg);
            zzhv.zzac(zzfy.zzr(zzfg.zzse));
        }
        if (zza == i2) {
            return zza;
        }
        throw zzhh.zzgn();
    }

    static int zza(zziw<?> zziw, int i, byte[] bArr, int i2, int i3, zzhe<?> zzhe, zzfg zzfg) throws IOException {
        int zza = zza(zziw, bArr, i2, i3, zzfg);
        zzhe.add(zzfg.zzsf);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzfg);
            if (i != zzfg.zzsd) {
                break;
            }
            zza = zza(zziw, bArr, zza2, i3, zzfg);
            zzhe.add(zzfg.zzsf);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzjr zzjr, zzfg zzfg) throws zzhh {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzfg);
                zzjr.zzb(i, Long.valueOf(zzfg.zzse));
                return zzb;
            } else if (i4 == 1) {
                zzjr.zzb(i, Long.valueOf(zzb(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzfg);
                int i5 = zzfg.zzsd;
                if (i5 < 0) {
                    throw zzhh.zzgo();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzjr.zzb(i, zzfm.zzsm);
                    } else {
                        zzjr.zzb(i, zzfm.zza(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzhh.zzgn();
                }
            } else if (i4 == 3) {
                zzjr zzii = zzjr.zzii();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzfg);
                    int i8 = zzfg.zzsd;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzii, zzfg);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzhh.zzgt();
                }
                zzjr.zzb(i, zzii);
                return i2;
            } else if (i4 == 5) {
                zzjr.zzb(i, Integer.valueOf(zza(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzhh.zzgq();
            }
        } else {
            throw zzhh.zzgq();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzfg zzfg) throws zzhh {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzfg);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzfg) + zzfg.zzsd;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzfg);
                    i6 = zzfg.zzsd;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzfg);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzhh.zzgt();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzhh.zzgq();
            }
        } else {
            throw zzhh.zzgq();
        }
    }
}
