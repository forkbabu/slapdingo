package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.BidiOrder;
import java.io.IOException;
import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzeen {
    static int zza(byte[] bArr, int i, zzeem zzeem) {
        int i2 = i + 1;
        byte b = bArr[i];
        if (b < 0) {
            return zza(b, bArr, i2, zzeem);
        }
        zzeem.zzhzo = b;
        return i2;
    }

    static int zza(int i, byte[] bArr, int i2, zzeem zzeem) {
        int i3 = i & 127;
        int i4 = i2 + 1;
        byte b = bArr[i2];
        if (b >= 0) {
            zzeem.zzhzo = i3 | (b << 7);
            return i4;
        }
        int i5 = i3 | ((b & ByteCompanionObject.MAX_VALUE) << 7);
        int i6 = i4 + 1;
        byte b2 = bArr[i4];
        if (b2 >= 0) {
            zzeem.zzhzo = i5 | (b2 << BidiOrder.BN);
            return i6;
        }
        int i7 = i5 | ((b2 & ByteCompanionObject.MAX_VALUE) << BidiOrder.BN);
        int i8 = i6 + 1;
        byte b3 = bArr[i6];
        if (b3 >= 0) {
            zzeem.zzhzo = i7 | (b3 << 21);
            return i8;
        }
        int i9 = i7 | ((b3 & ByteCompanionObject.MAX_VALUE) << 21);
        int i10 = i8 + 1;
        byte b4 = bArr[i8];
        if (b4 >= 0) {
            zzeem.zzhzo = i9 | (b4 << 28);
            return i10;
        }
        int i11 = i9 | ((b4 & ByteCompanionObject.MAX_VALUE) << 28);
        while (true) {
            int i12 = i10 + 1;
            if (bArr[i10] >= 0) {
                zzeem.zzhzo = i11;
                return i12;
            }
            i10 = i12;
        }
    }

    static int zzb(byte[] bArr, int i, zzeem zzeem) {
        int i2 = i + 1;
        long j = (long) bArr[i];
        if (j >= 0) {
            zzeem.zzhzp = j;
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
        zzeem.zzhzp = j2;
        return i3;
    }

    static int zzg(byte[] bArr, int i) {
        return ((bArr[i + 3] & UByte.MAX_VALUE) << 24) | (bArr[i] & UByte.MAX_VALUE) | ((bArr[i + 1] & UByte.MAX_VALUE) << 8) | ((bArr[i + 2] & UByte.MAX_VALUE) << 16);
    }

    static long zzh(byte[] bArr, int i) {
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    static double zzi(byte[] bArr, int i) {
        return Double.longBitsToDouble(zzh(bArr, i));
    }

    static float zzj(byte[] bArr, int i) {
        return Float.intBitsToFloat(zzg(bArr, i));
    }

    static int zzc(byte[] bArr, int i, zzeem zzeem) throws zzegl {
        int zza = zza(bArr, i, zzeem);
        int i2 = zzeem.zzhzo;
        if (i2 < 0) {
            throw zzegl.zzbfv();
        } else if (i2 == 0) {
            zzeem.zzhzq = "";
            return zza;
        } else {
            zzeem.zzhzq = new String(bArr, zza, i2, zzegd.UTF_8);
            return zza + i2;
        }
    }

    static int zzd(byte[] bArr, int i, zzeem zzeem) throws zzegl {
        int zza = zza(bArr, i, zzeem);
        int i2 = zzeem.zzhzo;
        if (i2 < 0) {
            throw zzegl.zzbfv();
        } else if (i2 == 0) {
            zzeem.zzhzq = "";
            return zza;
        } else {
            zzeem.zzhzq = zzeji.zzo(bArr, zza, i2);
            return zza + i2;
        }
    }

    static int zze(byte[] bArr, int i, zzeem zzeem) throws zzegl {
        int zza = zza(bArr, i, zzeem);
        int i2 = zzeem.zzhzo;
        if (i2 < 0) {
            throw zzegl.zzbfv();
        } else if (i2 > bArr.length - zza) {
            throw zzegl.zzbfu();
        } else if (i2 == 0) {
            zzeem.zzhzq = zzeer.zzhzv;
            return zza;
        } else {
            zzeem.zzhzq = zzeer.zzi(bArr, zza, i2);
            return zza + i2;
        }
    }

    /* JADX DEBUG: Additional 2 move instruction added to help type inference */
    static int zza(zzeih zzeih, byte[] bArr, int i, int i2, zzeem zzeem) throws IOException {
        int i3 = i + 1;
        byte b = bArr[i];
        byte b2 = b;
        if (b < 0) {
            i3 = zza(b, bArr, i3, zzeem);
            b2 = zzeem.zzhzo;
        }
        if (b2 < 0 || b2 > i2 - i3) {
            throw zzegl.zzbfu();
        }
        Object newInstance = zzeih.newInstance();
        int i4 = b2 + i3;
        zzeih.zza(newInstance, bArr, i3, i4, zzeem);
        zzeih.zzaj(newInstance);
        zzeem.zzhzq = newInstance;
        return i4;
    }

    static int zza(zzeih zzeih, byte[] bArr, int i, int i2, int i3, zzeem zzeem) throws IOException {
        zzehp zzehp = (zzehp) zzeih;
        Object newInstance = zzehp.newInstance();
        int zza = zzehp.zza(newInstance, bArr, i, i2, i3, zzeem);
        zzehp.zzaj(newInstance);
        zzeem.zzhzq = newInstance;
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzegm<?> zzegm, zzeem zzeem) {
        zzege zzege = (zzege) zzegm;
        int zza = zza(bArr, i2, zzeem);
        zzege.zzhb(zzeem.zzhzo);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzeem);
            if (i != zzeem.zzhzo) {
                break;
            }
            zza = zza(bArr, zza2, zzeem);
            zzege.zzhb(zzeem.zzhzo);
        }
        return zza;
    }

    static int zza(byte[] bArr, int i, zzegm<?> zzegm, zzeem zzeem) throws IOException {
        zzege zzege = (zzege) zzegm;
        int zza = zza(bArr, i, zzeem);
        int i2 = zzeem.zzhzo + zza;
        while (zza < i2) {
            zza = zza(bArr, zza, zzeem);
            zzege.zzhb(zzeem.zzhzo);
        }
        if (zza == i2) {
            return zza;
        }
        throw zzegl.zzbfu();
    }

    static int zza(zzeih<?> zzeih, int i, byte[] bArr, int i2, int i3, zzegm<?> zzegm, zzeem zzeem) throws IOException {
        int zza = zza(zzeih, bArr, i2, i3, zzeem);
        zzegm.add(zzeem.zzhzq);
        while (zza < i3) {
            int zza2 = zza(bArr, zza, zzeem);
            if (i != zzeem.zzhzo) {
                break;
            }
            zza = zza(zzeih, bArr, zza2, i3, zzeem);
            zzegm.add(zzeem.zzhzq);
        }
        return zza;
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzejc zzejc, zzeem zzeem) throws zzegl {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                int zzb = zzb(bArr, i2, zzeem);
                zzejc.zzd(i, Long.valueOf(zzeem.zzhzp));
                return zzb;
            } else if (i4 == 1) {
                zzejc.zzd(i, Long.valueOf(zzh(bArr, i2)));
                return i2 + 8;
            } else if (i4 == 2) {
                int zza = zza(bArr, i2, zzeem);
                int i5 = zzeem.zzhzo;
                if (i5 < 0) {
                    throw zzegl.zzbfv();
                } else if (i5 <= bArr.length - zza) {
                    if (i5 == 0) {
                        zzejc.zzd(i, zzeer.zzhzv);
                    } else {
                        zzejc.zzd(i, zzeer.zzi(bArr, zza, i5));
                    }
                    return zza + i5;
                } else {
                    throw zzegl.zzbfu();
                }
            } else if (i4 == 3) {
                zzejc zzbht = zzejc.zzbht();
                int i6 = (i & -8) | 4;
                int i7 = 0;
                while (true) {
                    if (i2 >= i3) {
                        break;
                    }
                    int zza2 = zza(bArr, i2, zzeem);
                    int i8 = zzeem.zzhzo;
                    i7 = i8;
                    if (i8 == i6) {
                        i2 = zza2;
                        break;
                    }
                    int zza3 = zza(i7, bArr, zza2, i3, zzbht, zzeem);
                    i7 = i8;
                    i2 = zza3;
                }
                if (i2 > i3 || i7 != i6) {
                    throw zzegl.zzbgb();
                }
                zzejc.zzd(i, zzbht);
                return i2;
            } else if (i4 == 5) {
                zzejc.zzd(i, Integer.valueOf(zzg(bArr, i2)));
                return i2 + 4;
            } else {
                throw zzegl.zzbfx();
            }
        } else {
            throw zzegl.zzbfx();
        }
    }

    static int zza(int i, byte[] bArr, int i2, int i3, zzeem zzeem) throws zzegl {
        if ((i >>> 3) != 0) {
            int i4 = i & 7;
            if (i4 == 0) {
                return zzb(bArr, i2, zzeem);
            }
            if (i4 == 1) {
                return i2 + 8;
            }
            if (i4 == 2) {
                return zza(bArr, i2, zzeem) + zzeem.zzhzo;
            }
            if (i4 == 3) {
                int i5 = (i & -8) | 4;
                int i6 = 0;
                while (i2 < i3) {
                    i2 = zza(bArr, i2, zzeem);
                    i6 = zzeem.zzhzo;
                    if (i6 == i5) {
                        break;
                    }
                    i2 = zza(i6, bArr, i2, i3, zzeem);
                }
                if (i2 <= i3 && i6 == i5) {
                    return i2;
                }
                throw zzegl.zzbgb();
            } else if (i4 == 5) {
                return i2 + 4;
            } else {
                throw zzegl.zzbfx();
            }
        } else {
            throw zzegl.zzbfx();
        }
    }
}
