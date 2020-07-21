package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.html.HtmlTags;
import com.itextpdf.text.xml.xmp.XmpWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.i18n.TextBundle;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcey {
    private final Executor executor;
    private final zzbbd zzboy;
    private final zzadj zzdkn;
    private final zztm zzelk;
    private final zzeg zzemz;
    private final ScheduledExecutorService zzfkm;
    private final zzcet zzgaq;
    private final zza zzgar;
    private final zzcfp zzgas;
    private final Context zzvr;

    public zzcey(Context context, zzcet zzcet, zzeg zzeg, zzbbd zzbbd, zza zza, zztm zztm, Executor executor2, zzdla zzdla, zzcfp zzcfp, ScheduledExecutorService scheduledExecutorService) {
        this.zzvr = context;
        this.zzgaq = zzcet;
        this.zzemz = zzeg;
        this.zzboy = zzbbd;
        this.zzgar = zza;
        this.zzelk = zztm;
        this.executor = executor2;
        this.zzdkn = zzdla.zzdkn;
        this.zzgas = zzcfp;
        this.zzfkm = scheduledExecutorService;
    }

    public static List<zzza> zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return Collections.emptyList();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzza zzl = zzl(optJSONArray.optJSONObject(i));
            if (zzl != null) {
                arrayList.add(zzl);
            }
        }
        return arrayList;
    }

    public static zzza zzk(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzl(optJSONObject);
    }

    private static zzza zzl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzza(optString, optString2);
    }

    public final zzdvf<zzadf> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdkn.zzdcf);
    }

    public final zzdvf<List<zzadf>> zzd(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONArray(str), this.zzdkn.zzdcf, this.zzdkn.zzbni);
    }

    private final zzdvf<List<zzadf>> zza(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdux.zzaf(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzdux.zzb(zzdux.zzi(arrayList), zzcfb.zzdvt, this.executor);
    }

    private final zzdvf<zzadf> zza(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdux.zzaf(null);
        }
        String optString = jSONObject.optString("url");
        if (TextUtils.isEmpty(optString)) {
            return zzdux.zzaf(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt(HtmlTags.WIDTH, -1);
        int optInt2 = jSONObject.optInt(HtmlTags.HEIGHT, -1);
        if (z) {
            return zzdux.zzaf(new zzadf(null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), zzdux.zzb(this.zzgaq.zza(optString, optDouble, optBoolean), new zzcfa(optString, optDouble, optInt, optInt2), this.executor), (Object) null);
    }

    public final zzdvf<zzada> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdux.zzaf(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzdux.zzb(zza(optJSONArray, false, true), new zzcfd(this, optJSONObject), this.executor), (Object) null);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt(HtmlTags.B)));
        } catch (JSONException unused) {
            return null;
        }
    }

    public final zzdvf<zzbfn> zzm(JSONObject jSONObject) {
        JSONObject zza = zzazy.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzdux.zzaf(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzaxv.zzfd("Required field 'vast_xml' is missing");
                return zzdux.zzaf(null);
            }
            return zza(zzdux.zza(this.zzgas.zzn(optJSONObject), (long) ((Integer) zzwg.zzpw().zzd(zzaav.zzcrh)).intValue(), TimeUnit.SECONDS, this.zzfkm), (Object) null);
        }
        zzdvf<zzbfn> zzo = this.zzgas.zzo(zza.optString("base_url"), zza.optString("html"));
        return zzdux.zzb(zzo, new zzcff(zzo), zzbbf.zzedm);
    }

    private static <T> zzdvf<T> zza(zzdvf<T> zzdvf, T t) {
        return zzdux.zzb(zzdvf, Exception.class, new zzcfe(null), zzbbf.zzedm);
    }

    private static <T> zzdvf<T> zza(boolean z, zzdvf<T> zzdvf, T t) {
        if (z) {
            return zzdux.zzb(zzdvf, new zzcfh(zzdvf), zzbbf.zzedm);
        }
        return zza(zzdvf, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdvf zzb(String str, Object obj) throws Exception {
        zzq.zzkx();
        zzbfn zza = zzbfv.zza(this.zzvr, zzbhg.zzacp(), "native-omid", false, false, this.zzemz, this.zzboy, null, null, this.zzgar, this.zzelk, null, false);
        zzbbo zzl = zzbbo.zzl(zza);
        zza.zzaaz().zza(new zzcfg(zzl));
        zza.loadData(str, "text/html", XmpWriter.UTF8);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzada zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString(TextBundle.TEXT_ENTRY);
        Integer zzf = zzf(jSONObject, "bg_color");
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", 1000);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzada(optString, list, zzf, zzf2, num, optInt3 + optInt2, this.zzdkn.zzbnj, optBoolean);
    }
}
