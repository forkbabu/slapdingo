package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.html.HtmlTags;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Future;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaaz {
    private String zzbpn = null;
    private String zzcxu;
    private Map<String, String> zzcxx;
    private Context zzvr = null;

    public zzaaz(Context context, String str) {
        String str2;
        this.zzvr = context;
        this.zzbpn = str;
        this.zzcxu = zzace.zzczi.get();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        this.zzcxx = linkedHashMap;
        linkedHashMap.put(HtmlTags.S, "gmob_sdk");
        this.zzcxx.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        this.zzcxx.put("os", Build.VERSION.RELEASE);
        this.zzcxx.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzcxx;
        zzq.zzkw();
        map.put("device", zzaye.zzxk());
        Map<String, String> map2 = this.zzcxx;
        if (context.getApplicationContext() != null) {
            str2 = context.getApplicationContext().getPackageName();
        } else {
            str2 = context.getPackageName();
        }
        map2.put("app", str2);
        Map<String, String> map3 = this.zzcxx;
        zzq.zzkw();
        map3.put("is_lite_sdk", zzaye.zzba(context) ? "1" : "0");
        Future<zzasr> zzu = zzq.zzlh().zzu(this.zzvr);
        try {
            this.zzcxx.put("network_coarse", Integer.toString(zzu.get().zzdtk));
            this.zzcxx.put("network_fine", Integer.toString(zzu.get().zzdtl));
        } catch (Exception e) {
            zzq.zzla().zza(e, "CsiConfiguration.CsiConfiguration");
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzrj() {
        return this.zzcxu;
    }

    /* access modifiers changed from: package-private */
    public final Context getContext() {
        return this.zzvr;
    }

    /* access modifiers changed from: package-private */
    public final String zzks() {
        return this.zzbpn;
    }

    /* access modifiers changed from: package-private */
    public final Map<String, String> zzrk() {
        return this.zzcxx;
    }
}
