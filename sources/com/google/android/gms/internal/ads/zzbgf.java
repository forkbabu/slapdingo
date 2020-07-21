package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbgf implements zzahc<zzbfn> {
    private final /* synthetic */ zzbgd zzeoi;

    zzbgf(zzbgd zzbgd) {
        this.zzeoi = zzbgd;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbfn zzbfn, Map map) {
        if (map != null) {
            String str = (String) map.get(HtmlTags.HEIGHT);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzeoi) {
                        if (this.zzeoi.zzeny != parseInt) {
                            int unused = this.zzeoi.zzeny = parseInt;
                            this.zzeoi.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzaxv.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
