package com.google.firebase.iid;

import android.content.Intent;
import com.google.android.gms.stats.WakeLock;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.firebase:firebase-iid@@20.1.5 */
public final class zzbd {
    private static final long zza = TimeUnit.MINUTES.toMillis(1);
    private static final Object zzb = new Object();
    private static WakeLock zzc;

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0032, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.ComponentName zza(android.content.Context r4, android.content.Intent r5) {
        /*
            java.lang.Object r0 = com.google.firebase.iid.zzbd.zzb
            monitor-enter(r0)
            com.google.android.gms.stats.WakeLock r1 = com.google.firebase.iid.zzbd.zzc     // Catch:{ all -> 0x0033 }
            r2 = 1
            if (r1 != 0) goto L_0x0015
            com.google.android.gms.stats.WakeLock r1 = new com.google.android.gms.stats.WakeLock     // Catch:{ all -> 0x0033 }
            java.lang.String r3 = "wake:com.google.firebase.iid.WakeLockHolder"
            r1.<init>(r4, r2, r3)     // Catch:{ all -> 0x0033 }
            com.google.firebase.iid.zzbd.zzc = r1     // Catch:{ all -> 0x0033 }
            r1.setReferenceCounted(r2)     // Catch:{ all -> 0x0033 }
        L_0x0015:
            java.lang.String r1 = "com.google.firebase.iid.WakeLockHolder.wakefulintent"
            r3 = 0
            boolean r1 = r5.getBooleanExtra(r1, r3)     // Catch:{ all -> 0x0033 }
            zza(r5, r2)     // Catch:{ all -> 0x0033 }
            android.content.ComponentName r4 = r4.startService(r5)     // Catch:{ all -> 0x0033 }
            if (r4 != 0) goto L_0x0028
            r4 = 0
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x0028:
            if (r1 != 0) goto L_0x0031
            com.google.android.gms.stats.WakeLock r5 = com.google.firebase.iid.zzbd.zzc     // Catch:{ all -> 0x0033 }
            long r1 = com.google.firebase.iid.zzbd.zza     // Catch:{ all -> 0x0033 }
            r5.acquire(r1)     // Catch:{ all -> 0x0033 }
        L_0x0031:
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            return r4
        L_0x0033:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0033 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.iid.zzbd.zza(android.content.Context, android.content.Intent):android.content.ComponentName");
    }

    private static void zza(Intent intent, boolean z) {
        intent.putExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", z);
    }

    public static void zza(Intent intent) {
        synchronized (zzb) {
            if (zzc != null && intent.getBooleanExtra("com.google.firebase.iid.WakeLockHolder.wakefulintent", false)) {
                zza(intent, false);
                zzc.release();
            }
        }
    }
}
