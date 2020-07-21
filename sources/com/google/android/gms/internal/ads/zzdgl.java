package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzdgl implements zzddz {
    static final zzddz zzgud = new zzdgl();

    private zzdgl() {
    }

    @Override // com.google.android.gms.internal.ads.zzddz
    public final void zzs(Object obj) {
        try {
            ((JSONObject) obj).getJSONObject("sdk_env").put("container_version", 12451009);
        } catch (JSONException unused) {
        }
    }
}
