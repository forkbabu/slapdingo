package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdlj {
    public static void zza(int i, Throwable th, String str) {
        StringBuilder sb = new StringBuilder(31);
        sb.append("Ad failed to load : ");
        sb.append(i);
        zzaxv.zzfc(sb.toString());
        zzaxv.zza(str, th);
        if (i != 3) {
            zzq.zzla().zzb(th, str);
        }
    }

    public static void zze(Context context, boolean z) {
        if (z) {
            zzaxv.zzfc("This request is sent from a test device.");
            return;
        }
        zzwg.zzps();
        String zzbn = zzbaq.zzbn(context);
        StringBuilder sb = new StringBuilder(String.valueOf(zzbn).length() + 101);
        sb.append("Use RequestConfiguration.Builder().setTestDeviceIds(Arrays.asList(\"");
        sb.append(zzbn);
        sb.append("\") to get test ads on this device.");
        zzaxv.zzfc(sb.toString());
    }
}
