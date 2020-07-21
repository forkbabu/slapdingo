package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.JavascriptInterface;
import com.google.android.gms.internal.ads.zzbgq;
import com.google.android.gms.internal.ads.zzbgy;
import com.google.android.gms.internal.ads.zzbha;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbgm<WebViewT extends zzbgq & zzbgy & zzbha> {
    private final zzbgn zzeou;
    private final WebViewT zzeov;

    public static zzbgm<zzbfn> zzc(zzbfn zzbfn) {
        return new zzbgm<>(zzbfn, new zzbgl(zzbfn));
    }

    private zzbgm(WebViewT webviewt, zzbgn zzbgn) {
        this.zzeou = zzbgn;
        this.zzeov = webviewt;
    }

    @JavascriptInterface
    public final void notify(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaxv.zzfd("URL is empty, ignoring message");
        } else {
            zzaye.zzdzw.post(new zzbgo(this, str));
        }
    }

    @JavascriptInterface
    public final String getClickSignals(String str) {
        if (TextUtils.isEmpty(str)) {
            zzaxv.zzeh("Click string is empty, not proceeding.");
            return "";
        }
        zzeg zzabc = this.zzeov.zzabc();
        if (zzabc == null) {
            zzaxv.zzeh("Signal utils is empty, ignoring.");
            return "";
        }
        zzdw zzcb = zzabc.zzcb();
        if (zzcb == null) {
            zzaxv.zzeh("Signals object is empty, ignoring.");
            return "";
        } else if (this.zzeov.getContext() != null) {
            return zzcb.zza(this.zzeov.getContext(), str, this.zzeov.getView(), this.zzeov.zzzl());
        } else {
            zzaxv.zzeh("Context is null, ignoring.");
            return "";
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzft(String str) {
        this.zzeou.zzh(Uri.parse(str));
    }
}
