package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzddi implements Callable {
    private final List zzgtt;

    zzddi(List list) {
        this.zzgtt = list;
    }

    @Override // java.util.concurrent.Callable
    public final Object call() {
        List<zzdvf> list = this.zzgtt;
        JSONArray jSONArray = new JSONArray();
        for (zzdvf zzdvf : list) {
            if (((JSONObject) zzdvf.get()) != null) {
                jSONArray.put(zzdvf.get());
            }
        }
        if (jSONArray.length() == 0) {
            return null;
        }
        return new zzddb(jSONArray.toString());
    }
}
