package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdgn implements zzddz<JSONObject> {
    private final Map<String, Object> zzgvz;

    public zzdgn(Map<String, Object> map) {
        this.zzgvz = map;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        try {
            jSONObject.put("video_decoders", zzq.zzkw().zzj(this.zzgvz));
        } catch (JSONException e) {
            String valueOf = String.valueOf(e.getMessage());
            zzaxv.zzeh(valueOf.length() != 0 ? "Could not encode video decoder properties: ".concat(valueOf) : new String("Could not encode video decoder properties: "));
        }
    }
}
