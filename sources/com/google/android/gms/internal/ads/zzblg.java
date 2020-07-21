package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.google.android.gms.ads.internal.zzq;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblg implements zzbld {
    private final Context zzvr;

    public zzblg(Context context) {
        this.zzvr = context;
    }

    @Override // com.google.android.gms.internal.ads.zzbld
    public final void zzl(Map<String, String> map) {
        CookieManager zzbh;
        String str = map.get("cookie");
        if (!TextUtils.isEmpty(str) && (zzbh = zzq.zzky().zzbh(this.zzvr)) != null) {
            zzbh.setCookie((String) zzwg.zzpw().zzd(zzaav.zzcnw), str);
        }
    }
}
