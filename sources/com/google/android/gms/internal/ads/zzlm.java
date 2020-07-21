package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzlm {
    private static final int[] zzazu = {zzpo.zzbk("isom"), zzpo.zzbk("iso2"), zzpo.zzbk("iso3"), zzpo.zzbk("iso4"), zzpo.zzbk("iso5"), zzpo.zzbk("iso6"), zzpo.zzbk("avc1"), zzpo.zzbk("hvc1"), zzpo.zzbk("hev1"), zzpo.zzbk("mp41"), zzpo.zzbk("mp42"), zzpo.zzbk("3g2a"), zzpo.zzbk("3g2b"), zzpo.zzbk("3gr6"), zzpo.zzbk("3gs6"), zzpo.zzbk("3ge6"), zzpo.zzbk("3gg6"), zzpo.zzbk("M4V "), zzpo.zzbk("M4A "), zzpo.zzbk("f4v "), zzpo.zzbk("kddi"), zzpo.zzbk("M4VP"), zzpo.zzbk("qt  "), zzpo.zzbk("MSNV")};

    public static boolean zzd(zzjw zzjw) throws IOException, InterruptedException {
        return zza(zzjw, true);
    }

    public static boolean zze(zzjw zzjw) throws IOException, InterruptedException {
        return zza(zzjw, false);
    }

    private static boolean zza(zzjw zzjw, boolean z) throws IOException, InterruptedException {
        boolean z2;
        boolean z3;
        long length = zzjw.getLength();
        if (length == -1 || length > PlaybackStateCompat.ACTION_SKIP_TO_QUEUE_ITEM) {
            length = 4096;
        }
        int i = (int) length;
        zzpi zzpi = new zzpi(64);
        int i2 = 0;
        boolean z4 = false;
        while (true) {
            if (i2 >= i) {
                break;
            }
            zzpi.reset(8);
            zzjw.zza(zzpi.data, 0, 8);
            long zziw = zzpi.zziw();
            int readInt = zzpi.readInt();
            int i3 = 16;
            if (zziw == 1) {
                zzjw.zza(zzpi.data, 8, 8);
                zzpi.zzbj(16);
                zziw = zzpi.zzja();
            } else {
                i3 = 8;
            }
            long j = (long) i3;
            if (zziw >= j) {
                i2 += i3;
                if (readInt != zzkt.zzatq) {
                    if (readInt != zzkt.zzatz && readInt != zzkt.zzaub) {
                        if ((((long) i2) + zziw) - j >= ((long) i)) {
                            break;
                        }
                        int i4 = (int) (zziw - j);
                        i2 += i4;
                        if (readInt == zzkt.zzasp) {
                            if (i4 < 8) {
                                return false;
                            }
                            zzpi.reset(i4);
                            zzjw.zza(zzpi.data, 0, i4);
                            int i5 = i4 / 4;
                            int i6 = 0;
                            while (true) {
                                if (i6 >= i5) {
                                    break;
                                }
                                if (i6 == 1) {
                                    zzpi.zzbl(4);
                                } else {
                                    int readInt2 = zzpi.readInt();
                                    if ((readInt2 >>> 8) != zzpo.zzbk("3gp")) {
                                        int[] iArr = zzazu;
                                        int length2 = iArr.length;
                                        int i7 = 0;
                                        while (true) {
                                            if (i7 >= length2) {
                                                z3 = false;
                                                break;
                                            } else if (iArr[i7] == readInt2) {
                                                break;
                                            } else {
                                                i7++;
                                            }
                                        }
                                    }
                                    z3 = true;
                                    if (z3) {
                                        z4 = true;
                                        break;
                                    }
                                }
                                i6++;
                            }
                            if (!z4) {
                                return false;
                            }
                        } else if (i4 != 0) {
                            zzjw.zzai(i4);
                        }
                    } else {
                        z2 = true;
                    }
                }
            } else {
                return false;
            }
        }
        z2 = false;
        if (!z4 || z != z2) {
            return false;
        }
        return true;
    }
}
