package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzber implements Runnable {
    private final /* synthetic */ String zzebn;
    private final /* synthetic */ String zzekf;
    private final /* synthetic */ int zzekg;
    private final /* synthetic */ int zzekh;
    private final /* synthetic */ boolean zzeki = false;
    private final /* synthetic */ zzbes zzekj;

    zzber(zzbes zzbes, String str, String str2, int i, int i2, boolean z) {
        this.zzekj = zzbes;
        this.zzebn = str;
        this.zzekf = str2;
        this.zzekg = i;
        this.zzekh = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put(HtmlTags.SRC, this.zzebn);
        hashMap.put("cachedSrc", this.zzekf);
        hashMap.put("bytesLoaded", Integer.toString(this.zzekg));
        hashMap.put("totalBytes", Integer.toString(this.zzekh));
        hashMap.put("cacheReady", this.zzeki ? "1" : "0");
        this.zzekj.zza("onPrecacheEvent", hashMap);
    }
}
