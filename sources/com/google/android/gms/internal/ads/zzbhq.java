package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbhq implements zzahc<zzbfn> {
    private final /* synthetic */ zzbho zzepf;

    zzbhq(zzbho zzbho) {
        this.zzepf = zzbho;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbfn zzbfn, Map map) {
        if (map != null) {
            String str = (String) map.get(HtmlTags.HEIGHT);
            if (!TextUtils.isEmpty(str)) {
                try {
                    int parseInt = Integer.parseInt(str);
                    synchronized (this.zzepf) {
                        if (this.zzepf.zzeny != parseInt) {
                            int unused = this.zzepf.zzeny = parseInt;
                            this.zzepf.requestLayout();
                        }
                    }
                } catch (Exception e) {
                    zzaxv.zzd("Exception occurred while getting webview content height", e);
                }
            }
        }
    }
}
