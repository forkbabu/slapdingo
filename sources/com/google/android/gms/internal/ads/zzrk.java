package com.google.android.gms.internal.ads;

import android.webkit.ValueCallback;
import android.webkit.WebView;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzrk implements Runnable {
    private ValueCallback<String> zzbti = new zzrn(this);
    final /* synthetic */ zzrc zzbtj;
    final /* synthetic */ WebView zzbtk;
    final /* synthetic */ boolean zzbtl;
    final /* synthetic */ zzri zzbtm;

    zzrk(zzri zzri, zzrc zzrc, WebView webView, boolean z) {
        this.zzbtm = zzri;
        this.zzbtj = zzrc;
        this.zzbtk = webView;
        this.zzbtl = z;
    }

    public final void run() {
        if (this.zzbtk.getSettings().getJavaScriptEnabled()) {
            try {
                this.zzbtk.evaluateJavascript("(function() { return  {text:document.body.innerText}})();", this.zzbti);
            } catch (Throwable unused) {
                this.zzbti.onReceiveValue("");
            }
        }
    }
}
