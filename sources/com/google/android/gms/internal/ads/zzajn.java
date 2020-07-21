package com.google.android.gms.internal.ads;

import android.webkit.JavascriptInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzajn {
    private final zzajq zzdfi;

    private zzajn(zzajq zzajq) {
        this.zzdfi = zzajq;
    }

    @JavascriptInterface
    public final void notify(String str) {
        this.zzdfi.zzdf(str);
    }
}
