package com.google.android.gms.internal.ads;

import android.content.Context;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdfl implements zzdec<zzddz<JSONObject>> {
    private final JSONObject zzgvn;

    zzdfl(Context context) {
        this.zzgvn = zzasy.zzz(context);
    }

    @Override // com.google.android.gms.internal.ads.zzdec
    public final zzdvf<zzddz<JSONObject>> zzaqm() {
        return zzdux.zzaf(new zzdfo(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzq(JSONObject jSONObject) {
        try {
            jSONObject.put("gms_sdk_env", this.zzgvn);
        } catch (JSONException unused) {
            zzaxv.zzeh("Failed putting version constants.");
        }
    }
}
