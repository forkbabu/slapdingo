package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfu implements zzddz<JSONObject> {
    private List<String> zzdpu;

    public zzdfu(List<String> list) {
        this.zzdpu = list;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("eid", TextUtils.join(",", this.zzdpu));
        } catch (JSONException unused) {
            zzaxv.zzeh("Failed putting experiment ids.");
        }
    }
}
