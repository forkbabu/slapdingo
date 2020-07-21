package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzamn {
    private final long zzdie;
    private final String zzdiy;
    private final String zzdiz;
    public final List<String> zzdja;
    private final String zzdjb;
    private final String zzdjc;
    private final List<String> zzdjd;
    private final List<String> zzdje;
    private final List<String> zzdjf;
    private final List<String> zzdjg;
    private final List<String> zzdjh;
    public final String zzdji;
    private final List<String> zzdjj;
    private final List<String> zzdjk;
    private final List<String> zzdjl;
    private final String zzdjm;
    private final String zzdjn;
    private final String zzdjo;
    private final String zzdjp;
    private final String zzdjq;
    private final List<String> zzdjr;
    private final String zzdjs;
    public final String zzdjt;

    public zzamn(JSONObject jSONObject) throws JSONException {
        List<String> list;
        this.zzdiz = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdja = Collections.unmodifiableList(arrayList);
        this.zzdjb = jSONObject.optString("allocation_id", null);
        zzq.zzlo();
        this.zzdjd = zzamp.zza(jSONObject, "clickurl");
        zzq.zzlo();
        this.zzdje = zzamp.zza(jSONObject, "imp_urls");
        zzq.zzlo();
        this.zzdjf = zzamp.zza(jSONObject, "downloaded_imp_urls");
        zzq.zzlo();
        this.zzdjh = zzamp.zza(jSONObject, "fill_urls");
        zzq.zzlo();
        this.zzdjj = zzamp.zza(jSONObject, "video_start_urls");
        zzq.zzlo();
        this.zzdjl = zzamp.zza(jSONObject, "video_complete_urls");
        zzq.zzlo();
        this.zzdjk = zzamp.zza(jSONObject, "video_reward_urls");
        this.zzdjm = jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        this.zzdjn = jSONObject.optString("valid_from_timestamp");
        JSONObject optJSONObject = jSONObject.optJSONObject("ad");
        if (optJSONObject != null) {
            zzq.zzlo();
            list = zzamp.zza(optJSONObject, "manual_impression_urls");
        } else {
            list = null;
        }
        this.zzdjg = list;
        this.zzdiy = optJSONObject != null ? optJSONObject.toString() : null;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdji = optJSONObject2 != null ? optJSONObject2.toString() : null;
        this.zzdjc = optJSONObject2 != null ? optJSONObject2.optString("class_name") : null;
        this.zzdjo = jSONObject.optString("html_template", null);
        this.zzdjp = jSONObject.optString("ad_base_url", null);
        JSONObject optJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzdjq = optJSONObject3 != null ? optJSONObject3.toString() : null;
        zzq.zzlo();
        this.zzdjr = zzamp.zza(jSONObject, "template_ids");
        JSONObject optJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzdjs = optJSONObject4 != null ? optJSONObject4.toString() : null;
        this.zzdjt = jSONObject.optString("response_type", null);
        this.zzdie = jSONObject.optLong("ad_network_timeout_millis", -1);
    }
}
