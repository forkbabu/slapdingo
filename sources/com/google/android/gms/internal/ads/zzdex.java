package com.google.android.gms.internal.ads;

import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdex implements zzddz<JSONObject> {
    private final JSONObject zzgvc;

    public zzdex(JSONObject jSONObject) {
        this.zzgvc = jSONObject;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzazy.zzb(jSONObject, "content_info");
            JSONObject jSONObject2 = this.zzgvc;
            Iterator<String> keys = jSONObject2.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                zzb.put(next, jSONObject2.get(next));
            }
        } catch (JSONException unused) {
            zzaxv.zzeh("Failed putting app indexing json.");
        }
    }
}
