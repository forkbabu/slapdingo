package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzagj implements zzahc<Object> {
    private final zzagi zzddi;

    public zzagj(zzagi zzagi) {
        this.zzddi = zzagi;
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        if (this.zzddi != null) {
            String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
            if (str == null) {
                zzaxv.zzfc("Ad metadata with no name parameter.");
                str = "";
            }
            Bundle bundle = null;
            if (map.containsKey("info")) {
                try {
                    bundle = zzazy.zzh(new JSONObject(map.get("info")));
                } catch (JSONException e) {
                    zzaxv.zzc("Failed to convert ad metadata to JSON.", e);
                }
            }
            if (bundle == null) {
                zzaxv.zzfb("Failed to convert ad metadata to Bundle.");
            } else {
                this.zzddi.zza(str, bundle);
            }
        }
    }
}
