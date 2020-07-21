package com.google.android.gms.internal.vision;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import android.os.UserManager;
import android.util.Log;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.0 */
public class zzas {
    private static UserManager zzfn;
    private static volatile boolean zzfo = (!zzt());
    private static boolean zzfp = false;

    private zzas() {
    }

    public static boolean zzt() {
        return Build.VERSION.SDK_INT >= 24;
    }

    public static boolean isUserUnlocked(Context context) {
        return !zzt() || zzd(context);
    }

    private static boolean zzc(Context context) {
        boolean z;
        boolean z2 = true;
        int i = 1;
        while (true) {
            z = false;
            if (i > 2) {
                break;
            }
            if (zzfn == null) {
                zzfn = (UserManager) context.getSystemService(UserManager.class);
            }
            UserManager userManager = zzfn;
            if (userManager == null) {
                return true;
            }
            try {
                if (!userManager.isUserUnlocked() && userManager.isUserRunning(Process.myUserHandle())) {
                    z2 = false;
                }
                z = z2;
            } catch (NullPointerException e) {
                Log.w("DirectBootUtils", "Failed to check if user is unlocked.", e);
                zzfn = null;
                i++;
            }
        }
        if (z) {
            zzfn = null;
        }
        return z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0018, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean zzd(android.content.Context r3) {
        /*
            boolean r0 = com.google.android.gms.internal.vision.zzas.zzfo
            r1 = 1
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            java.lang.Class<com.google.android.gms.internal.vision.zzas> r0 = com.google.android.gms.internal.vision.zzas.class
            monitor-enter(r0)
            boolean r2 = com.google.android.gms.internal.vision.zzas.zzfo     // Catch:{ all -> 0x0019 }
            if (r2 == 0) goto L_0x000f
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r1
        L_0x000f:
            boolean r3 = zzc(r3)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0017
            com.google.android.gms.internal.vision.zzas.zzfo = r3     // Catch:{ all -> 0x0019 }
        L_0x0017:
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            return r3
        L_0x0019:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0019 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzas.zzd(android.content.Context):boolean");
    }
}
