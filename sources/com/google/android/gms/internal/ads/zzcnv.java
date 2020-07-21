package com.google.android.gms.internal.ads;

import com.itextpdf.text.html.HtmlTags;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcnv implements zzduh {
    private final zzcns zzghg;
    private final zzuw zzghh;

    zzcnv(zzcns zzcns, zzuw zzuw) {
        this.zzghg = zzcns;
        this.zzghh = zzuw;
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        zzuw zzuw = this.zzghh;
        String str = (String) obj;
        String str2 = zzuw.zzcgm;
        String str3 = zzuw.zzcgn;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject3.put("headers", new JSONObject());
        jSONObject3.put(HtmlTags.BODY, str2);
        jSONObject2.put("base_url", "");
        jSONObject2.put("signals", new JSONObject(str3));
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", new JSONObject());
        return zzdux.zzaf(jSONObject);
    }
}
