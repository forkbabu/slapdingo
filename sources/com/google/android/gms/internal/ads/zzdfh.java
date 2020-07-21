package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfh implements zzddz<JSONObject> {
    private JSONObject zzgvj;

    public zzdfh(JSONObject jSONObject) {
        this.zzgvj = jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("cache_state", this.zzgvj);
        } catch (JSONException unused) {
            zzaxv.zzeh("Unable to get cache_state");
        }
    }
}
