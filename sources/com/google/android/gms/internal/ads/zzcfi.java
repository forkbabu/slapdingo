package com.google.android.gms.internal.ads;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcfi {
    private final Executor executor;
    private final zzcey zzgae;

    public zzcfi(Executor executor2, zzcey zzcey) {
        this.executor = executor2;
        this.zzgae = zzcey;
    }

    public final zzdvf<List<zzcfn>> zzg(JSONObject jSONObject, String str) {
        zzdvf zzdvf;
        String optString;
        char c;
        JSONArray optJSONArray = jSONObject.optJSONArray(str);
        if (optJSONArray == null) {
            return zzdux.zzaf(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = optJSONArray.length();
        for (int i = 0; i < length; i++) {
            JSONObject optJSONObject = optJSONArray.optJSONObject(i);
            if (!(optJSONObject == null || (optString = optJSONObject.optString(AppMeasurementSdk.ConditionalUserProperty.NAME)) == null)) {
                String optString2 = optJSONObject.optString("type");
                if ("string".equals(optString2)) {
                    c = 1;
                } else {
                    c = "image".equals(optString2) ? (char) 2 : 0;
                }
                if (c == 1) {
                    zzdvf = zzdux.zzaf(new zzcfn(optString, optJSONObject.optString("string_value")));
                } else if (c == 2) {
                    zzdvf = zzdux.zzb(this.zzgae.zzc(optJSONObject, "image_value"), new zzcfk(optString), this.executor);
                }
                arrayList.add(zzdvf);
            }
            zzdvf = zzdux.zzaf(null);
            arrayList.add(zzdvf);
        }
        return zzdux.zzb(zzdux.zzi(arrayList), zzcfl.zzdvt, this.executor);
    }
}
