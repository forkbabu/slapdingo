package com.google.android.gms.internal.ads;

import android.util.Log;
import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxv extends zzbba {
    public static void zzeh(String str) {
        if (zzwr()) {
            Log.v(AdRequest.LOGTAG, str);
        }
    }

    public static void zza(String str, Throwable th) {
        if (zzwr()) {
            Log.v(AdRequest.LOGTAG, str, th);
        }
    }

    public static boolean zzwr() {
        return isLoggable(2) && zzack.zzdaj.get().booleanValue();
    }
}
