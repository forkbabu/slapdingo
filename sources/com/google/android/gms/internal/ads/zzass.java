package com.google.android.gms.internal.ads;

import com.itextpdf.text.pdf.PdfBoolean;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzass {
    private final int errorCode;
    private final String type;
    private String url;
    private final String zzdpt;
    private final String zzdsg;
    private final boolean zzdsh;
    private final String zzdsu;
    private final List<String> zzdtw;
    private final String zzdtx;
    private final String zzdty;
    private final boolean zzdtz;
    private final String zzdua;
    private final boolean zzdub;
    private final JSONObject zzduc;

    public zzass(JSONObject jSONObject) {
        List<String> list;
        this.url = jSONObject.optString("url");
        this.zzdtx = jSONObject.optString("base_uri");
        this.zzdty = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        int i = 1;
        this.zzdtz = optString != null && (optString.equals("1") || optString.equals(PdfBoolean.TRUE));
        this.zzdpt = jSONObject.optString("request_id");
        this.type = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        if (optString2 == null) {
            list = null;
        } else {
            list = Arrays.asList(optString2.split(","));
        }
        this.zzdtw = list;
        this.errorCode = jSONObject.optInt("valid", 0) == 1 ? -2 : i;
        this.zzdua = jSONObject.optString("fetched_ad");
        this.zzdub = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzduc = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzdsg = jSONObject.optString("analytics_query_ad_event_id");
        this.zzdsh = jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzdsu = jSONObject.optString("pool_key");
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final List<String> zzuz() {
        return this.zzdtw;
    }

    public final String zzva() {
        return this.zzdtx;
    }

    public final String zzvb() {
        return this.zzdty;
    }

    public final String getUrl() {
        return this.url;
    }

    public final boolean zzvc() {
        return this.zzdtz;
    }

    public final JSONObject zzvd() {
        return this.zzduc;
    }

    public final String zzve() {
        return this.zzdsu;
    }
}
