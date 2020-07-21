package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbew implements Runnable {
    private final /* synthetic */ String zzebn;
    private final /* synthetic */ String zzekf;
    private final /* synthetic */ int zzekh;
    private final /* synthetic */ zzbes zzekj;

    zzbew(zzbes zzbes, String str, String str2, int i) {
        this.zzekj = zzbes;
        this.zzebn = str;
        this.zzekf = str2;
        this.zzekh = i;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheComplete");
        hashMap.put(HtmlTags.SRC, this.zzebn);
        hashMap.put("cachedSrc", this.zzekf);
        hashMap.put("totalBytes", Integer.toString(this.zzekh));
        this.zzekj.zza("onPrecacheEvent", hashMap);
    }
}
