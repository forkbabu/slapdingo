package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblh implements zzbld {
    private final zzdki zzfkk;

    public zzblh(zzdki zzdki) {
        this.zzfkk = zzdki;
    }

    @Override // com.google.android.gms.internal.ads.zzbld
    public final void zzl(Map<String, String> map) {
        String str = map.get("render_in_browser");
        if (!TextUtils.isEmpty(str)) {
            try {
                this.zzfkk.zzbn(Boolean.parseBoolean(str));
            } catch (Exception unused) {
                throw new IllegalStateException("Invalid render_in_browser state");
            }
        }
    }
}
