package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.html.HtmlTags;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzcpp implements zzalk<zzcpm> {
    zzcpp() {
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzalk
    public final /* synthetic */ JSONObject zzj(zzcpm zzcpm) throws JSONException {
        zzcpm zzcpm2 = zzcpm;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcpm2.zzgip.zzva());
        jSONObject2.put("signals", zzcpm2.zzgio);
        jSONObject3.put(HtmlTags.BODY, zzcpm2.zzgin.zzdrd);
        jSONObject3.put("headers", zzq.zzkw().zzj(zzcpm2.zzgin.zzam));
        jSONObject3.put("response_code", zzcpm2.zzgin.zzgiw);
        jSONObject3.put("latency", zzcpm2.zzgin.zzgix);
        jSONObject.put("request", jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcpm2.zzgip.zzvd());
        return jSONObject;
    }
}
