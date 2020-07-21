package com.google.android.gms.internal.ads;

import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzq;
import java.io.File;
import java.util.Collections;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public class zzbgr extends zzbfq {
    public zzbgr(zzbfn zzbfn, zztm zztm, boolean z) {
        super(zzbfn, zztm, z);
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zza(WebView webView, String str, Map<String, String> map) {
        String str2;
        if (!(webView instanceof zzbfn)) {
            zzaxv.zzfd("Tried to intercept request from a WebView that wasn't an AdWebView.");
            return null;
        }
        zzbfn zzbfn = (zzbfn) webView;
        if (this.zzelu != null) {
            this.zzelu.zza(str, map, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(str).getName())) {
            if (map == null) {
                map = Collections.emptyMap();
            }
            return super.zzd(str, map);
        }
        if (zzbfn.zzaaz() != null) {
            zzbfn.zzaaz().zzum();
        }
        if (zzbfn.zzaax().zzacs()) {
            str2 = (String) zzwg.zzpw().zzd(zzaav.zzcmn);
        } else if (zzbfn.zzabe()) {
            str2 = (String) zzwg.zzpw().zzd(zzaav.zzcmm);
        } else {
            str2 = (String) zzwg.zzpw().zzd(zzaav.zzcml);
        }
        zzq.zzkw();
        return zzaye.zzd(zzbfn.getContext(), zzbfn.zzzo().zzbpn, str2);
    }
}
