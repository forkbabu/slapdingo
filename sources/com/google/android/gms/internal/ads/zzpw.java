package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpw {
    public final List<byte[]> zzagy;
    public final int zzasi;

    public static zzpw zzi(zzpi zzpi) throws zzht {
        List list;
        try {
            zzpi.zzbl(21);
            int readUnsignedByte = zzpi.readUnsignedByte() & 3;
            int readUnsignedByte2 = zzpi.readUnsignedByte();
            int position = zzpi.getPosition();
            int i = 0;
            for (int i2 = 0; i2 < readUnsignedByte2; i2++) {
                zzpi.zzbl(1);
                int readUnsignedShort = zzpi.readUnsignedShort();
                for (int i3 = 0; i3 < readUnsignedShort; i3++) {
                    int readUnsignedShort2 = zzpi.readUnsignedShort();
                    i += readUnsignedShort2 + 4;
                    zzpi.zzbl(readUnsignedShort2);
                }
            }
            zzpi.zzbk(position);
            byte[] bArr = new byte[i];
            int i4 = 0;
            for (int i5 = 0; i5 < readUnsignedByte2; i5++) {
                zzpi.zzbl(1);
                int readUnsignedShort3 = zzpi.readUnsignedShort();
                for (int i6 = 0; i6 < readUnsignedShort3; i6++) {
                    int readUnsignedShort4 = zzpi.readUnsignedShort();
                    System.arraycopy(zzph.zzbjk, 0, bArr, i4, zzph.zzbjk.length);
                    int length = i4 + zzph.zzbjk.length;
                    System.arraycopy(zzpi.data, zzpi.getPosition(), bArr, length, readUnsignedShort4);
                    i4 = length + readUnsignedShort4;
                    zzpi.zzbl(readUnsignedShort4);
                }
            }
            if (i == 0) {
                list = null;
            } else {
                list = Collections.singletonList(bArr);
            }
            return new zzpw(list, readUnsignedByte + 1);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzht("Error parsing HEVC config", e);
        }
    }

    private zzpw(List<byte[]> list, int i) {
        this.zzagy = list;
        this.zzasi = i;
    }
}
