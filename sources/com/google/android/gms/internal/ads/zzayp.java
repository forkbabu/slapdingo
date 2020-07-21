package com.google.android.gms.internal.ads;

import android.content.Context;
import android.webkit.CookieManager;
import android.webkit.WebResourceResponse;
import com.google.android.gms.ads.internal.zzq;
import java.io.InputStream;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzayp extends zzayq {
    @Override // com.google.android.gms.internal.ads.zzayj
    public final int zzxq() {
        return 16974374;
    }

    @Override // com.google.android.gms.internal.ads.zzayj
    public final CookieManager zzbh(Context context) {
        if (zzxp()) {
            return null;
        }
        try {
            return CookieManager.getInstance();
        } catch (Throwable th) {
            zzaxv.zzc("Failed to obtain CookieManager.", th);
            zzq.zzla().zza(th, "ApiLevelUtil.getCookieManager");
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzayj
    public final zzbfq zza(zzbfn zzbfn, zztm zztm, boolean z) {
        return new zzbgu(zzbfn, zztm, z);
    }

    @Override // com.google.android.gms.internal.ads.zzayj
    public final WebResourceResponse zza(String str, String str2, int i, String str3, Map<String, String> map, InputStream inputStream) {
        return new WebResourceResponse(str, str2, i, str3, map, inputStream);
    }
}
