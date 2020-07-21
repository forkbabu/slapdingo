package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.regex.Pattern;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaax {
    public static boolean zzcs(String str) {
        return zzf((String) zzwg.zzpw().zzd(zzaav.zzctw), str);
    }

    private static boolean zzf(String str, String str2) {
        if (!(str == null || str2 == null)) {
            try {
                return Pattern.matches(str, str2);
            } catch (RuntimeException e) {
                zzq.zzla().zza(e, "NonagonUtil.isPatternMatched");
            }
        }
        return false;
    }
}
