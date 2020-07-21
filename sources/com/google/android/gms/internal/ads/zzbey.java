package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbey implements Runnable {
    private final /* synthetic */ String val$message;
    private final /* synthetic */ String zzebn;
    private final /* synthetic */ String zzekf;
    private final /* synthetic */ zzbes zzekj;
    private final /* synthetic */ String zzekp;

    zzbey(zzbes zzbes, String str, String str2, String str3, String str4) {
        this.zzekj = zzbes;
        this.zzebn = str;
        this.zzekf = str2;
        this.zzekp = str3;
        this.val$message = str4;
    }

    public final void run() {
        HashMap hashMap = new HashMap();
        hashMap.put(NotificationCompat.CATEGORY_EVENT, "precacheCanceled");
        hashMap.put(HtmlTags.SRC, this.zzebn);
        if (!TextUtils.isEmpty(this.zzekf)) {
            hashMap.put("cachedSrc", this.zzekf);
        }
        hashMap.put("type", zzbes.zzfo(this.zzekp));
        hashMap.put("reason", this.zzekp);
        if (!TextUtils.isEmpty(this.val$message)) {
            hashMap.put("message", this.val$message);
        }
        this.zzekj.zza("onPrecacheEvent", hashMap);
    }
}
