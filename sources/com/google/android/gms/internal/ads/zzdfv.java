package com.google.android.gms.internal.ads;

import android.location.Location;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfv implements zzddz<JSONObject> {
    private final Location zznb;

    public zzdfv(Location location) {
        this.zznb = location;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        try {
            if (this.zznb != null) {
                JSONObject jSONObject3 = new JSONObject();
                Float valueOf = Float.valueOf(this.zznb.getAccuracy() * 1000.0f);
                Long valueOf2 = Long.valueOf(this.zznb.getTime() * 1000);
                Long valueOf3 = Long.valueOf((long) (this.zznb.getLatitude() * 1.0E7d));
                Long valueOf4 = Long.valueOf((long) (this.zznb.getLongitude() * 1.0E7d));
                jSONObject3.put("radius", valueOf);
                jSONObject3.put("lat", valueOf3);
                jSONObject3.put("long", valueOf4);
                jSONObject3.put("time", valueOf2);
                jSONObject2.put("uule", jSONObject3);
            }
        } catch (JSONException e) {
            zzaxv.zza("Failed adding location to the request JSON.", e);
        }
    }
}
