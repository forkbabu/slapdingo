package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzamm {
    public final List<zzamn> zzdid;
    private final long zzdie;
    private final List<String> zzdif;
    private final List<String> zzdig;
    private final List<String> zzdih;
    private final List<String> zzdii;
    private final List<String> zzdij;
    private final boolean zzdik;
    private final String zzdil;
    private final long zzdim;
    private final String zzdin;
    private final int zzdio;
    private final int zzdip;
    private final long zzdiq;
    private final boolean zzdir;
    private final boolean zzdis;
    private final boolean zzdit;
    private final boolean zzdiu;
    private int zzdiv;
    private int zzdiw;
    private boolean zzdix;

    public zzamm(JSONObject jSONObject) throws JSONException {
        if (zzaxv.isLoggable(2)) {
            String valueOf = String.valueOf(jSONObject.toString(2));
            zzaxv.zzeh(valueOf.length() != 0 ? "Mediation Response JSON: ".concat(valueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzamn zzamn = new zzamn(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzamn.zzdjt)) {
                    this.zzdix = true;
                }
                arrayList.add(zzamn);
                if (i < 0) {
                    Iterator<String> it2 = zzamn.zzdja.iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            if (it2.next().equals("com.google.ads.mediation.admob.AdMobAdapter")) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdiv = i;
        this.zzdiw = jSONArray.length();
        this.zzdid = Collections.unmodifiableList(arrayList);
        this.zzdil = jSONObject.optString("qdata");
        this.zzdip = jSONObject.optInt("fs_model_type", -1);
        long j = -1;
        this.zzdiq = jSONObject.optLong("timeout_ms", -1);
        JSONObject optJSONObject = jSONObject.optJSONObject("settings");
        if (optJSONObject != null) {
            this.zzdie = optJSONObject.optLong("ad_network_timeout_millis", -1);
            zzq.zzlo();
            this.zzdif = zzamp.zza(optJSONObject, "click_urls");
            zzq.zzlo();
            this.zzdig = zzamp.zza(optJSONObject, "imp_urls");
            zzq.zzlo();
            this.zzdih = zzamp.zza(optJSONObject, "downloaded_imp_urls");
            zzq.zzlo();
            this.zzdii = zzamp.zza(optJSONObject, "nofill_urls");
            zzq.zzlo();
            this.zzdij = zzamp.zza(optJSONObject, "remote_ping_urls");
            this.zzdik = optJSONObject.optBoolean("render_in_browser", false);
            long optLong = optJSONObject.optLong("refresh", -1);
            this.zzdim = optLong > 0 ? 1000 * optLong : j;
            zzaub zza = zzaub.zza(optJSONObject.optJSONArray("rewards"));
            if (zza == null) {
                this.zzdin = null;
                this.zzdio = 0;
            } else {
                this.zzdin = zza.type;
                this.zzdio = zza.zzdun;
            }
            this.zzdir = optJSONObject.optBoolean("use_displayed_impression", false);
            this.zzdis = optJSONObject.optBoolean("allow_pub_rendered_attribution", false);
            this.zzdit = optJSONObject.optBoolean("allow_pub_owned_ad_view", false);
            this.zzdiu = optJSONObject.optBoolean("allow_custom_click_gesture", false);
            return;
        }
        this.zzdie = -1;
        this.zzdif = null;
        this.zzdig = null;
        this.zzdih = null;
        this.zzdii = null;
        this.zzdij = null;
        this.zzdim = -1;
        this.zzdin = null;
        this.zzdio = 0;
        this.zzdir = false;
        this.zzdik = false;
        this.zzdis = false;
        this.zzdit = false;
        this.zzdiu = false;
    }
}
