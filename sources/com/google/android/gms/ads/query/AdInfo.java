package com.google.android.gms.ads.query;

import com.google.android.gms.internal.ads.zzbba;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class AdInfo {
    private final QueryInfo zzhhc;
    private final String zzhhd;

    public static String getRequestId(String str) {
        if (str == null) {
            zzbba.zzfd("adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.");
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            zzbba.zzfd("Invalid adString passed to AdInfo.getRequestId(). Returning empty string.");
            return "";
        }
    }

    public AdInfo(QueryInfo queryInfo, String str) {
        this.zzhhc = queryInfo;
        this.zzhhd = str;
    }

    public QueryInfo getQueryInfo() {
        return this.zzhhc;
    }

    public String getAdString() {
        return this.zzhhd;
    }
}
