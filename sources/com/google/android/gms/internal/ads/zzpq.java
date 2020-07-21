package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzpq {
    private final int height;
    private final int width;
    public final List<byte[]> zzagy;
    public final int zzasi;
    public final float zzbjp;

    public static zzpq zzg(zzpi zzpi) throws zzht {
        float f;
        int i;
        int i2;
        try {
            zzpi.zzbl(4);
            int readUnsignedByte = (zzpi.readUnsignedByte() & 3) + 1;
            if (readUnsignedByte != 3) {
                ArrayList arrayList = new ArrayList();
                int readUnsignedByte2 = zzpi.readUnsignedByte() & 31;
                for (int i3 = 0; i3 < readUnsignedByte2; i3++) {
                    arrayList.add(zzh(zzpi));
                }
                int readUnsignedByte3 = zzpi.readUnsignedByte();
                for (int i4 = 0; i4 < readUnsignedByte3; i4++) {
                    arrayList.add(zzh(zzpi));
                }
                if (readUnsignedByte2 > 0) {
                    zzpg zzd = zzph.zzd((byte[]) arrayList.get(0), readUnsignedByte, ((byte[]) arrayList.get(0)).length);
                    int i5 = zzd.width;
                    int i6 = zzd.height;
                    f = zzd.zzbjp;
                    i2 = i5;
                    i = i6;
                } else {
                    i2 = -1;
                    i = -1;
                    f = 1.0f;
                }
                return new zzpq(arrayList, readUnsignedByte, i2, i, f);
            }
            throw new IllegalStateException();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new zzht("Error parsing AVC config", e);
        }
    }

    private zzpq(List<byte[]> list, int i, int i2, int i3, float f) {
        this.zzagy = list;
        this.zzasi = i;
        this.width = i2;
        this.height = i3;
        this.zzbjp = f;
    }

    private static byte[] zzh(zzpi zzpi) {
        int readUnsignedShort = zzpi.readUnsignedShort();
        int position = zzpi.getPosition();
        zzpi.zzbl(readUnsignedShort);
        return zzpa.zzc(zzpi.data, position, readUnsignedShort);
    }
}
