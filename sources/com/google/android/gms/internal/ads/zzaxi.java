package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaxi {
    private String zzdqg;
    private final long zzdxs;
    private final List<String> zzdxt = new ArrayList();
    private final List<String> zzdxu = new ArrayList();
    private final Map<String, zzamm> zzdxv = new HashMap();
    private String zzdxw;
    private JSONObject zzdxx;
    private boolean zzdxy;

    public zzaxi(String str, long j) {
        JSONObject optJSONObject;
        this.zzdxy = false;
        this.zzdqg = str;
        this.zzdxs = j;
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                this.zzdxx = jSONObject;
                if (jSONObject.optInt(NotificationCompat.CATEGORY_STATUS, -1) != 1) {
                    this.zzdxy = false;
                    zzaxv.zzfd("App settings could not be fetched successfully.");
                    return;
                }
                this.zzdxy = true;
                this.zzdxw = this.zzdxx.optString("app_id");
                JSONArray optJSONArray = this.zzdxx.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject jSONObject2 = optJSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString(DublinCoreProperties.FORMAT);
                        String optString2 = jSONObject2.optString("ad_unit_id");
                        if (!TextUtils.isEmpty(optString)) {
                            if (!TextUtils.isEmpty(optString2)) {
                                if ("interstitial".equalsIgnoreCase(optString)) {
                                    this.zzdxu.add(optString2);
                                } else if ("rewarded".equalsIgnoreCase(optString) && (optJSONObject = jSONObject2.optJSONObject("mediation_config")) != null) {
                                    this.zzdxv.put(optString2, new zzamm(optJSONObject));
                                }
                            }
                        }
                    }
                }
                JSONArray optJSONArray2 = this.zzdxx.optJSONArray("persistable_banner_ad_unit_ids");
                if (optJSONArray2 != null) {
                    for (int i2 = 0; i2 < optJSONArray2.length(); i2++) {
                        this.zzdxt.add(optJSONArray2.optString(i2));
                    }
                }
            } catch (JSONException e) {
                zzaxv.zzd("Exception occurred while processing app setting json", e);
                zzq.zzla().zza(e, "AppSettings.parseAppSettingsJson");
            }
        }
    }

    public final long zzwi() {
        return this.zzdxs;
    }

    public final boolean zzwj() {
        return this.zzdxy;
    }

    public final String zzwk() {
        return this.zzdqg;
    }

    public final String zzwl() {
        return this.zzdxw;
    }

    public final Map<String, zzamm> zzwm() {
        return this.zzdxv;
    }

    public final JSONObject zzwn() {
        return this.zzdxx;
    }
}
