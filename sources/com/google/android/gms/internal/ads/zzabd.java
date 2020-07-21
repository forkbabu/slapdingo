package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzabd {
    public static boolean zza(zzabi zzabi, zzabg zzabg, String... strArr) {
        if (zzabi == null || zzabg == null || !zzabi.zzcye || zzabg == null) {
            return false;
        }
        return zzabi.zza(zzabg, zzq.zzld().elapsedRealtime(), strArr);
    }

    public static zzabg zzb(zzabi zzabi) {
        if (zzabi == null) {
            return null;
        }
        return zzabi.zzex(zzq.zzld().elapsedRealtime());
    }
}
