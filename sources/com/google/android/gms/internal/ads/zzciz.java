package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzciz {
    private final Executor executor;
    private final Map<String, Map<String, JSONObject>> zzgdf = new ConcurrentHashMap();
    private JSONObject zzgdg;
    private boolean zzxh;

    public zzciz(Executor executor2) {
        this.executor = executor2;
    }

    public final void zzann() {
        zzq.zzla().zzwe().zzb(new zzciy(this));
        this.executor.execute(new zzcjb(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: zzano */
    public final synchronized void zzanr() {
        Map<String, JSONObject> map;
        this.zzxh = true;
        zzaxi zzwz = zzq.zzla().zzwe().zzwz();
        if (zzwz != null) {
            JSONObject zzwn = zzwz.zzwn();
            if (zzwn != null) {
                this.zzgdg = zzwn.optJSONObject("ad_unit_patterns");
                JSONArray optJSONArray = zzwn.optJSONArray("ad_unit_id_settings");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                        if (optJSONObject != null) {
                            String optString = optJSONObject.optString("ad_unit_id");
                            String optString2 = optJSONObject.optString(DublinCoreProperties.FORMAT);
                            JSONObject optJSONObject2 = optJSONObject.optJSONObject("request_signals");
                            if (!(optString == null || optJSONObject2 == null || optString2 == null)) {
                                if (this.zzgdf.containsKey(optString2)) {
                                    map = this.zzgdf.get(optString2);
                                } else {
                                    ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                                    this.zzgdf.put(optString2, concurrentHashMap);
                                    map = concurrentHashMap;
                                }
                                map.put(optString, optJSONObject2);
                            }
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzanq() {
        this.executor.execute(new zzcja(this));
    }
}
