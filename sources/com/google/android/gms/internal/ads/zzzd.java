package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.query.QueryInfo;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzd {
    private final String zzbpi;
    private final Bundle zzcke;

    public zzzd(String str, Bundle bundle) {
        this.zzbpi = str;
        this.zzcke = bundle;
    }

    public final String getQuery() {
        return this.zzbpi;
    }

    public static String zza(QueryInfo queryInfo) {
        String str = zzwg.zzqa().get(queryInfo);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final Bundle getQueryBundle() {
        return this.zzcke;
    }
}
