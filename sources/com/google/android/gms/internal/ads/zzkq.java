package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzkq {
    private static final long[] zzask = {128, 64, 32, 16, 8, 4, 2, 1};
    private int length;
    private int state;
    private final byte[] zzaos = new byte[8];

    public final void reset() {
        this.state = 0;
        this.length = 0;
    }

    public final long zza(zzjw zzjw, boolean z, boolean z2, int i) throws IOException, InterruptedException {
        if (this.state == 0) {
            if (!zzjw.zza(this.zzaos, 0, 1, z)) {
                return -1;
            }
            int zzap = zzap(this.zzaos[0] & UByte.MAX_VALUE);
            this.length = zzap;
            if (zzap != -1) {
                this.state = 1;
            } else {
                throw new IllegalStateException("No valid varint length mask found");
            }
        }
        int i2 = this.length;
        if (i2 > i) {
            this.state = 0;
            return -2;
        }
        if (i2 != 1) {
            zzjw.readFully(this.zzaos, 1, i2 - 1);
        }
        this.state = 0;
        return zza(this.zzaos, this.length, z2);
    }

    public final int zzgv() {
        return this.length;
    }

    public static int zzap(int i) {
        int i2 = 0;
        while (true) {
            long[] jArr = zzask;
            if (i2 >= jArr.length) {
                return -1;
            }
            if ((jArr[i2] & ((long) i)) != 0) {
                return i2 + 1;
            }
            i2++;
        }
    }

    public static long zza(byte[] bArr, int i, boolean z) {
        long j = ((long) bArr[0]) & 255;
        if (z) {
            j &= ~zzask[i - 1];
        }
        for (int i2 = 1; i2 < i; i2++) {
            j = (j << 8) | (((long) bArr[i2]) & 255);
        }
        return j;
    }
}
