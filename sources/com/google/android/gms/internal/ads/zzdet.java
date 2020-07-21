package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdet implements zzddz<JSONObject> {
    private final String zzgva;

    public zzdet(String str) {
        this.zzgva = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("ms", this.zzgva);
        } catch (JSONException e) {
            zzaxv.zza("Failed putting Ad ID.", e);
        }
    }
}
