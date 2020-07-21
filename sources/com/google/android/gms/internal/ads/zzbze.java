package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.webkit.WebView;
import com.itextpdf.text.xml.xmp.XmpWriter;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbze implements zzso {
    private zzdrw zzftn;

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zza(Activity activity, WebView webView) {
        try {
            this.zzftn = new zzdrw(activity, webView);
        } catch (RuntimeException e) {
            String valueOf = String.valueOf(e);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 46);
            sb.append(" Failed to initialize the internal ArWebView: ");
            sb.append(valueOf);
            zzaxv.zzfb(sb.toString());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void zzc(String str, String str2) {
        if (this.zzftn == null) {
            zzaxv.zzfb("ArWebView is not initialized.");
        } else {
            zzdrw.getWebView().loadDataWithBaseURL(str, str2, "text/html", XmpWriter.UTF8, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final WebView getWebView() {
        if (this.zzftn == null) {
            return null;
        }
        return zzdrw.getWebView();
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final View getView() {
        return this.zzftn;
    }

    @Override // com.google.android.gms.internal.ads.zzso
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        if (this.zzftn != null) {
            zzdrw.onPageStarted(webView, str, bitmap);
        }
    }
}
