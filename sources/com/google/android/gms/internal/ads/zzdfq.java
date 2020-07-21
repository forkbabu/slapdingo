package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfq implements zzddz<JSONObject> {
    private String zzgvq;
    private String zzgvr;

    public zzdfq(String str, String str2) {
        this.zzgvq = str;
        this.zzgvr = str2;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzazy.zzb(jSONObject, "pii");
            zzb.put("doritos", this.zzgvq);
            zzb.put("doritos_v2", this.zzgvr);
        } catch (JSONException unused) {
            zzaxv.zzeh("Failed putting doritos string.");
        }
    }
}
