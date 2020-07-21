package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzty;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzcym {
    private String zzgqz;

    /* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
    public static class zza {
        /* access modifiers changed from: private */
        public String zzgqz;

        public final zza zzgr(String str) {
            this.zzgqz = str;
            return this;
        }
    }

    private zzcym(zza zza2) {
        this.zzgqz = zza2.zzgqz;
    }

    public final Set<String> zzaqj() {
        HashSet hashSet = new HashSet();
        hashSet.add(this.zzgqz.toLowerCase(Locale.ROOT));
        return hashSet;
    }

    public final String zzaqk() {
        return this.zzgqz.toLowerCase(Locale.ROOT);
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    public final zzty.zza.C0018zza zzaql() {
        char c;
        String str = this.zzgqz;
        switch (str.hashCode()) {
            case -1999289321:
                if (str.equals("NATIVE")) {
                    c = 2;
                    break;
                }
                c = 65535;
                break;
            case -1372958932:
                if (str.equals("INTERSTITIAL")) {
                    c = 1;
                    break;
                }
                c = 65535;
                break;
            case 543046670:
                if (str.equals("REWARDED")) {
                    c = 3;
                    break;
                }
                c = 65535;
                break;
            case 1951953708:
                if (str.equals("BANNER")) {
                    c = 0;
                    break;
                }
                c = 65535;
                break;
            default:
                c = 65535;
                break;
        }
        if (c == 0) {
            return zzty.zza.C0018zza.BANNER;
        }
        if (c == 1) {
            return zzty.zza.C0018zza.INTERSTITIAL;
        }
        if (c == 2) {
            return zzty.zza.C0018zza.AD_LOADER;
        }
        if (c != 3) {
            return zzty.zza.C0018zza.AD_INITIATER_UNSPECIFIED;
        }
        return zzty.zza.C0018zza.REWARD_BASED_VIDEO_AD;
    }
}
