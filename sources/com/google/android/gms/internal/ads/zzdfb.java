package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfb implements zzddz<JSONObject> {
    private String zzgvg;

    public zzdfb(String str) {
        this.zzgvg = str;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            JSONObject zzb = zzazy.zzb(jSONObject, "pii");
            if (!TextUtils.isEmpty(this.zzgvg)) {
                zzb.put("attok", this.zzgvg);
            }
        } catch (JSONException e) {
            zzaxv.zza("Failed putting attestation token.", e);
        }
    }
}
