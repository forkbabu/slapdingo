package com.google.android.gms.ads;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzb {
    public static AdSize zza(int i, int i2, String str) {
        return new AdSize(i, i2, str);
    }

    public static AdSize zza(int i, int i2) {
        AdSize adSize = new AdSize(i, 0);
        adSize.zzc(true);
        adSize.zzq(i2);
        return adSize;
    }

    public static boolean zza(AdSize adSize) {
        return adSize.zzdr();
    }

    public static boolean zzb(AdSize adSize) {
        return adSize.zzds();
    }

    public static int zzc(AdSize adSize) {
        return adSize.zzdt();
    }
}
