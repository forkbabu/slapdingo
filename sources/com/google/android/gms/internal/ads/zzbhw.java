package com.google.android.gms.internal.ads;

import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbhw {
    private static Boolean zzepl;

    private zzbhw() {
    }

    private static boolean zzb(WebView webView) {
        boolean booleanValue;
        synchronized (zzbhw.class) {
            if (zzepl == null) {
                try {
                    webView.evaluateJavascript("(function(){})()", null);
                    zzepl = true;
                } catch (IllegalStateException unused) {
                    zzepl = false;
                }
            }
            booleanValue = zzepl.booleanValue();
        }
        return booleanValue;
    }

    static void zza(WebView webView, String str) {
        if (!PlatformVersion.isAtLeastKitKat() || !zzb(webView)) {
            String valueOf = String.valueOf(str);
            webView.loadUrl(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        webView.evaluateJavascript(str, null);
    }
}
