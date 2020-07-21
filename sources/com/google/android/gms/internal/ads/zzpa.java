package com.google.android.gms.internal.ads;

import android.util.Pair;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpa {
    private static final byte[] zzbjk = {0, 0, 0, 1};
    private static final int[] zzbjl = {96000, 88200, 64000, 48000, 44100, 32000, 24000, 22050, 16000, 12000, 11025, 8000, 7350};
    private static final int[] zzbjm = {0, 1, 2, 3, 4, 5, 6, 8, -1, -1, -1, 7, 8, -1, 8, -1};

    public static Pair<Integer, Integer> zze(byte[] bArr) {
        zzpj zzpj = new zzpj(bArr);
        int zza = zza(zzpj);
        int zzb = zzb(zzpj);
        int zzbn = zzpj.zzbn(4);
        if (zza == 5 || zza == 29) {
            zzb = zzb(zzpj);
            if (zza(zzpj) == 22) {
                zzbn = zzpj.zzbn(4);
            }
        }
        int i = zzbjm[zzbn];
        zzpb.checkArgument(i != -1);
        return Pair.create(Integer.valueOf(zzb), Integer.valueOf(i));
    }

    public static byte[] zzc(byte[] bArr, int i, int i2) {
        byte[] bArr2 = zzbjk;
        byte[] bArr3 = new byte[(bArr2.length + i2)];
        System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
        System.arraycopy(bArr, i, bArr3, zzbjk.length, i2);
        return bArr3;
    }

    private static int zza(zzpj zzpj) {
        int zzbn = zzpj.zzbn(5);
        return zzbn == 31 ? zzpj.zzbn(6) + 32 : zzbn;
    }

    private static int zzb(zzpj zzpj) {
        int zzbn = zzpj.zzbn(4);
        if (zzbn == 15) {
            return zzpj.zzbn(24);
        }
        zzpb.checkArgument(zzbn < 13);
        return zzbjl[zzbn];
    }
}
