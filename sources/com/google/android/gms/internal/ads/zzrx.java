package com.google.android.gms.internal.ads;

import java.util.PriorityQueue;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzrx {
    public static void zza(String[] strArr, int i, int i2, PriorityQueue<zzrw> priorityQueue) {
        if (strArr.length < i2) {
            zza(i, zzb(strArr, 0, strArr.length), zza(strArr, 0, strArr.length), strArr.length, priorityQueue);
            return;
        }
        long zzb = zzb(strArr, 0, i2);
        zza(i, zzb, zza(strArr, 0, i2), i2, priorityQueue);
        long zza = zza(16785407, i2 - 1);
        for (int i3 = 1; i3 < (strArr.length - i2) + 1; i3++) {
            long j = zzb + 1073807359;
            zzb = (((((j - ((((((long) zzrs.zzbu(strArr[i3 - 1])) + 2147483647L) % 1073807359) * zza) % 1073807359)) % 1073807359) * 16785407) % 1073807359) + ((((long) zzrs.zzbu(strArr[(i3 + i2) - 1])) + 2147483647L) % 1073807359)) % 1073807359;
            zza(i, zzb, zza(strArr, i3, i2), strArr.length, priorityQueue);
        }
    }

    private static void zza(int i, long j, String str, int i2, PriorityQueue<zzrw> priorityQueue) {
        zzrw zzrw = new zzrw(j, str, i2);
        if ((priorityQueue.size() != i || (priorityQueue.peek().zzbtt <= zzrw.zzbtt && priorityQueue.peek().value <= zzrw.value)) && !priorityQueue.contains(zzrw)) {
            priorityQueue.add(zzrw);
            if (priorityQueue.size() > i) {
                priorityQueue.poll();
            }
        }
    }

    private static String zza(String[] strArr, int i, int i2) {
        int i3 = i2 + i;
        if (strArr.length < i3) {
            zzaxv.zzfb("Unable to construct shingle");
            return "";
        }
        StringBuilder sb = new StringBuilder();
        while (true) {
            int i4 = i3 - 1;
            if (i < i4) {
                sb.append(strArr[i]);
                sb.append(' ');
                i++;
            } else {
                sb.append(strArr[i4]);
                return sb.toString();
            }
        }
    }

    private static long zzb(String[] strArr, int i, int i2) {
        long zzbu = (((long) zzrs.zzbu(strArr[0])) + 2147483647L) % 1073807359;
        for (int i3 = 1; i3 < i2; i3++) {
            zzbu = (((zzbu * 16785407) % 1073807359) + ((((long) zzrs.zzbu(strArr[i3])) + 2147483647L) % 1073807359)) % 1073807359;
        }
        return zzbu;
    }

    private static long zza(long j, int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 1) {
            return j;
        }
        if (i % 2 == 0) {
            return zza((j * j) % 1073807359, i / 2) % 1073807359;
        }
        return (j * (zza((j * j) % 1073807359, i / 2) % 1073807359)) % 1073807359;
    }
}
