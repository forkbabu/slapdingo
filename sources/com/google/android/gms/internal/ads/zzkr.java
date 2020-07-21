package com.google.android.gms.internal.ads;

import java.io.IOException;
import kotlin.UByte;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzkr {
    private final zzpi zzapl = new zzpi(8);
    private int zzasl;

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0098, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(com.google.android.gms.internal.ads.zzjw r18) throws java.io.IOException, java.lang.InterruptedException {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            long r2 = r18.getLength()
            r4 = 1024(0x400, double:5.06E-321)
            r6 = -1
            int r8 = (r2 > r6 ? 1 : (r2 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0016
            int r6 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r6 <= 0) goto L_0x0015
            goto L_0x0016
        L_0x0015:
            r4 = r2
        L_0x0016:
            int r5 = (int) r4
            com.google.android.gms.internal.ads.zzpi r4 = r0.zzapl
            byte[] r4 = r4.data
            r6 = 0
            r7 = 4
            r1.zza(r4, r6, r7)
            com.google.android.gms.internal.ads.zzpi r4 = r0.zzapl
            long r9 = r4.zziw()
            r0.zzasl = r7
        L_0x0028:
            r11 = 440786851(0x1a45dfa3, double:2.1777764E-315)
            r4 = 1
            int r7 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r7 == 0) goto L_0x0050
            int r7 = r0.zzasl
            int r7 = r7 + r4
            r0.zzasl = r7
            if (r7 != r5) goto L_0x0038
            return r6
        L_0x0038:
            com.google.android.gms.internal.ads.zzpi r7 = r0.zzapl
            byte[] r7 = r7.data
            r1.zza(r7, r6, r4)
            r4 = 8
            long r9 = r9 << r4
            r11 = -256(0xffffffffffffff00, double:NaN)
            long r9 = r9 & r11
            com.google.android.gms.internal.ads.zzpi r4 = r0.zzapl
            byte[] r4 = r4.data
            byte r4 = r4[r6]
            r4 = r4 & 255(0xff, float:3.57E-43)
            long r11 = (long) r4
            long r9 = r9 | r11
            goto L_0x0028
        L_0x0050:
            long r9 = r17.zzc(r18)
            int r5 = r0.zzasl
            long r11 = (long) r5
            r13 = -9223372036854775808
            int r5 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
            if (r5 == 0) goto L_0x009f
            if (r8 == 0) goto L_0x0066
            long r7 = r11 + r9
            int r5 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r5 < 0) goto L_0x0066
            goto L_0x009f
        L_0x0066:
            int r2 = r0.zzasl
            long r7 = (long) r2
            long r15 = r11 + r9
            int r3 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r3 >= 0) goto L_0x0099
            long r2 = r17.zzc(r18)
            int r5 = (r2 > r13 ? 1 : (r2 == r13 ? 0 : -1))
            if (r5 != 0) goto L_0x0078
            return r6
        L_0x0078:
            long r2 = r17.zzc(r18)
            r7 = 0
            int r5 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x0098
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r15 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r15 <= 0) goto L_0x008a
            goto L_0x0098
        L_0x008a:
            if (r5 == 0) goto L_0x0066
            int r5 = (int) r2
            r1.zzai(r5)
            int r5 = r0.zzasl
            long r7 = (long) r5
            long r7 = r7 + r2
            int r2 = (int) r7
            r0.zzasl = r2
            goto L_0x0066
        L_0x0098:
            return r6
        L_0x0099:
            long r1 = (long) r2
            int r3 = (r1 > r15 ? 1 : (r1 == r15 ? 0 : -1))
            if (r3 != 0) goto L_0x009f
            return r4
        L_0x009f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzkr.zza(com.google.android.gms.internal.ads.zzjw):boolean");
    }

    private final long zzc(zzjw zzjw) throws IOException, InterruptedException {
        int i = 0;
        zzjw.zza(this.zzapl.data, 0, 1);
        byte b = this.zzapl.data[0] & UByte.MAX_VALUE;
        if (b == 0) {
            return Long.MIN_VALUE;
        }
        int i2 = 128;
        int i3 = 0;
        while ((b & i2) == 0) {
            i2 >>= 1;
            i3++;
        }
        int i4 = b & (~i2);
        zzjw.zza(this.zzapl.data, 1, i3);
        while (i < i3) {
            i++;
            i4 = (this.zzapl.data[i] & UByte.MAX_VALUE) + (i4 << 8);
        }
        this.zzasl += i3 + 1;
        return (long) i4;
    }
}
