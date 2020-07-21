package com.google.android.gms.ads.internal;

import com.google.android.gms.internal.ads.zzduh;
import com.google.android.gms.internal.ads.zzdux;
import com.google.android.gms.internal.ads.zzdvf;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzf implements zzduh {
    static final zzduh zzboi = new zzf();

    private zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzduh
    public final zzdvf zzf(Object obj) {
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.optBoolean("isSuccessful", false)) {
            zzq.zzla().zzwe().zzek(jSONObject.getString("appSettingsJson"));
        }
        return zzdux.zzaf(null);
    }
}
