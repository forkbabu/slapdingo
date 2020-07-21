package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.zzq;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfz implements zzddz<JSONObject> {
    private Bundle zzgvu;

    public zzdfz(Bundle bundle) {
        this.zzgvu = bundle;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // com.google.android.gms.internal.ads.zzddz
    public final /* synthetic */ void zzs(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        if (this.zzgvu != null) {
            try {
                zzazy.zzb(zzazy.zzb(jSONObject2, "device"), "play_store").put("parental_controls", zzq.zzkw().zzd(this.zzgvu));
            } catch (JSONException unused) {
                zzaxv.zzeh("Failed putting parental controls bundle.");
            }
        }
    }
}
