package com.google.android.gms.internal.ads;

import androidx.core.app.NotificationCompat;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbeu implements Runnable {
    private final /* synthetic */ String zzebn;
    private final /* synthetic */ String zzekf;
    private final /* synthetic */ boolean zzeki;
    private final /* synthetic */ zzbes zzekj;
    private final /* synthetic */ long zzekl;
    private final /* synthetic */ long zzekm;
    private final /* synthetic */ int zzekn;
    private final /* synthetic */ int zzeko;

    zzbeu(zzbes zzbes, String str, String str2, long j, long j2, boolean z, int i, int i2) {
        this.zzekj = zzbes;
        this.zzebn = str;
        this.zzekf = str2;
        this.zzekl = j;
        this.zzekm = j2;
        this.zzeki = z;
        this.zzekn = i;
        this.zzeko = i2;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheProgress");
        hashMap.put(HtmlTags.SRC, this.zzebn);
        hashMap.put("cachedSrc", this.zzekf);
        hashMap.put("bufferedDuration", Long.toString(this.zzekl));
        hashMap.put("totalDuration", Long.toString(this.zzekm));
        hashMap.put("cacheReady", this.zzeki ? "1" : "0");
        hashMap.put("playerCount", Integer.toString(this.zzekn));
        hashMap.put("playerPreparedCount", Integer.toString(this.zzeko));
        this.zzekj.zza("onPrecacheEvent", hashMap);
    }
}
