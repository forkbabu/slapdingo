package com.google.android.gms.internal.ads;

import android.webkit.CookieManager;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcmr implements Callable {
    private final CookieManager zzggn;

    zzcmr(CookieManager cookieManager) {
        this.zzggn = cookieManager;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        CookieManager cookieManager = this.zzggn;
        if (cookieManager == null) {
            return "";
        }
        return cookieManager.getCookie((String) zzwg.zzpw().zzd(zzaav.zzcnw));
    }
}
