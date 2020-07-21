package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzckv {
    private ConcurrentHashMap<String, String> zzgej;

    public zzckv(zzclc zzclc) {
        this.zzgej = zzclc.zzaom();
    }

    public final void zzc(zzdkw zzdkw) {
        if (zzdkw.zzhau.zzhaq.size() > 0) {
            int i = zzdkw.zzhau.zzhaq.get(0).zzgzl;
            if (i == 1) {
                this.zzgej.put("ad_format", "banner");
            } else if (i == 2) {
                this.zzgej.put("ad_format", "interstitial");
            } else if (i == 3) {
                this.zzgej.put("ad_format", "native_express");
            } else if (i == 4) {
                this.zzgej.put("ad_format", "native_advanced");
            } else if (i != 5) {
                this.zzgej.put("ad_format", "unknown");
            } else {
                this.zzgej.put("ad_format", "rewarded");
            }
        }
        if (!TextUtils.isEmpty(zzdkw.zzhau.zzhar.zzdrt)) {
            this.zzgej.put("gqi", zzdkw.zzhau.zzhar.zzdrt);
        }
    }

    public final void zzj(Bundle bundle) {
        if (bundle.containsKey("cnt")) {
            this.zzgej.put("network_coarse", Integer.toString(bundle.getInt("cnt")));
        }
        if (bundle.containsKey("gnt")) {
            this.zzgej.put("network_fine", Integer.toString(bundle.getInt("gnt")));
        }
    }

    public final Map<String, String> zzro() {
        return this.zzgej;
    }
}
