package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzclc {
    private final Executor executor;
    private final String packageName;
    private final String zzbpn;
    private final String zzcxu = zzace.zzczi.get();
    private final zzbbe zzebx;
    private final Map<String, String> zzgel = new HashMap();
    private final boolean zzges;
    private final Context zzvr;

    public zzclc(Executor executor2, zzbbe zzbbe, Context context, zzbbd zzbbd) {
        this.executor = executor2;
        this.zzebx = zzbbe;
        this.zzvr = context;
        this.packageName = context.getPackageName();
        this.zzges = ((double) zzwg.zzpz().nextFloat()) <= zzace.zzczh.get().doubleValue();
        this.zzbpn = zzbbd.zzbpn;
        this.zzgel.put(HtmlTags.S, "gmob_sdk");
        this.zzgel.put("v", ExifInterface.GPS_MEASUREMENT_3D);
        this.zzgel.put("os", Build.VERSION.RELEASE);
        this.zzgel.put("api_v", Build.VERSION.SDK);
        Map<String, String> map = this.zzgel;
        zzq.zzkw();
        map.put("device", zzaye.zzxk());
        this.zzgel.put("app", this.packageName);
        Map<String, String> map2 = this.zzgel;
        zzq.zzkw();
        map2.put("is_lite_sdk", zzaye.zzba(this.zzvr) ? "1" : "0");
        this.zzgel.put("e", TextUtils.join(",", zzaav.zzrd()));
        this.zzgel.put("sdkVersion", this.zzbpn);
    }

    /* access modifiers changed from: package-private */
    public final void zzn(Map<String, String> map) {
        Uri.Builder buildUpon = Uri.parse(this.zzcxu).buildUpon();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            buildUpon.appendQueryParameter(entry.getKey(), entry.getValue());
        }
        String uri = buildUpon.build().toString();
        if (this.zzges) {
            this.executor.execute(new zzclf(this, uri));
        }
        zzaxv.zzeh(uri);
    }

    public final Map<String, String> zzaol() {
        return new HashMap(this.zzgel);
    }

    public final ConcurrentHashMap<String, String> zzaom() {
        return new ConcurrentHashMap<>(this.zzgel);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzgh(String str) {
        this.zzebx.zzer(str);
    }
}
