package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbgs extends zzbgr {
    public zzbgs(zzbfn zzbfn, zztm zztm, boolean z) {
        super(zzbfn, zztm, z);
    }

    @Override // android.webkit.WebViewClient, com.google.android.gms.internal.ads.zzbfq
    public final WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zza(webView, str, (Map<String, String>) null);
    }
}
