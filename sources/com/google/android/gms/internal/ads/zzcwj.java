package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.xml.xmp.DublinCoreProperties;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcwj {
    private final Executor executor;
    private JSONObject zzgdg;
    private final Map<String, zzcwm> zzgoo = new ConcurrentHashMap();
    private final Map<String, Map<String, List<zzcwm>>> zzgop = new ConcurrentHashMap();

    public zzcwj(Executor executor2) {
        this.executor = executor2;
    }

    public final void zzann() {
        zzq.zzla().zzwe().zzb(new zzcwi(this));
        this.executor.execute(new zzcwl(this));
    }

    public final Map<String, List<Bundle>> zzs(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Collections.emptyMap();
        }
        Map<String, List<zzcwm>> map = this.zzgop.get(str);
        if (map == null) {
            return Collections.emptyMap();
        }
        List<zzcwm> list = map.get(str2);
        if (list == null) {
            list = map.get(zzcjc.zza(this.zzgdg, str2, str));
        }
        if (list == null) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap();
        for (zzcwm zzcwm : list) {
            String str3 = zzcwm.zzfpp;
            if (!hashMap.containsKey(str3)) {
                hashMap.put(str3, new ArrayList());
            }
            ((List) hashMap.get(str3)).add(zzcwm.zzepn);
        }
        return hashMap;
    }

    public final void zzgp(String str) {
        if (!TextUtils.isEmpty(str) && !this.zzgoo.containsKey(str)) {
            this.zzgoo.put(str, new zzcwm(str, "", new Bundle()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzapr */
    public final synchronized void zzapu() {
        JSONArray optJSONArray;
        JSONObject zzwn = zzq.zzla().zzwe().zzwz().zzwn();
        if (zzwn != null) {
            try {
                JSONArray optJSONArray2 = zzwn.optJSONArray("ad_unit_id_settings");
                this.zzgdg = zzwn.optJSONObject("ad_unit_patterns");
                if (optJSONArray2 != null) {
                    for (int i = 0; i < optJSONArray2.length(); i++) {
                        JSONObject jSONObject = optJSONArray2.getJSONObject(i);
                        String optString = jSONObject.optString("ad_unit_id", "");
                        String optString2 = jSONObject.optString(DublinCoreProperties.FORMAT, "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject optJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (!(optJSONObject == null || (optJSONArray = optJSONObject.optJSONArray("ad_networks")) == null)) {
                            for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = optJSONArray.getJSONObject(i2);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (optJSONObject2 != null) {
                                        Iterator<String> keys = optJSONObject2.keys();
                                        while (keys.hasNext()) {
                                            String next = keys.next();
                                            bundle.putString(next, optJSONObject2.optString(next, ""));
                                        }
                                    }
                                    JSONArray optJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (optJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i3 = 0; i3 < optJSONArray3.length(); i3++) {
                                            String optString3 = optJSONArray3.optString(i3, "");
                                            if (!TextUtils.isEmpty(optString3)) {
                                                arrayList3.add(optString3);
                                            }
                                        }
                                        ArrayList arrayList4 = arrayList3;
                                        int size = arrayList4.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            Object obj = arrayList4.get(i4);
                                            i4++;
                                            String str = (String) obj;
                                            zzgp(str);
                                            if (this.zzgoo.get(str) != null) {
                                                arrayList2.add(new zzcwm(str, optString2, bundle));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(optString2) && !TextUtils.isEmpty(optString)) {
                            Map<String, List<zzcwm>> map = this.zzgop.get(optString2);
                            if (map == null) {
                                map = new ConcurrentHashMap<>();
                            }
                            this.zzgop.put(optString2, map);
                            List<zzcwm> list = map.get(optString);
                            if (list == null) {
                                list = new ArrayList<>();
                            }
                            list.addAll(arrayList);
                            map.put(optString, list);
                        }
                    }
                }
            } catch (JSONException e) {
                zzaxv.zza("Malformed config loading JSON.", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzapt() {
        this.executor.execute(new zzcwk(this));
    }
}
