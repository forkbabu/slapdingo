package com.google.android.gms.internal.ads;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdlq {
    public static zzuy zzh(int i, String str) {
        while (str == null) {
            int i2 = zzdlp.zzhbp[i - 1];
            str = i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "Internal error." : "App ID missing." : "No fill." : "Network error." : "Invalid request.";
        }
        int i3 = zzdlp.zzhbp[i - 1];
        if (i3 == 1) {
            return new zzuy(1, str, "com.google.android.gms.ads");
        }
        if (i3 == 2) {
            return new zzuy(2, str, "com.google.android.gms.ads");
        }
        if (i3 == 3) {
            return new zzuy(3, str, "com.google.android.gms.ads");
        }
        if (i3 != 4) {
            return new zzuy(0, str, "com.google.android.gms.ads");
        }
        return new zzuy(8, str, "com.google.android.gms.ads");
    }
}
