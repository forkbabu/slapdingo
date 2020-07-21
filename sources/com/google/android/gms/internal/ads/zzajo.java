package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final /* synthetic */ class zzajo {
    public static void zza(zzajp zzajp, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzajp.zzj(str, jSONObject.toString());
    }

    public static void zza(zzajp zzajp, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzajp.zzdb(sb.toString());
    }

    public static void zzb(zzajp zzajp, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzaxv.zzee(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzajp.zzdb(sb.toString());
    }

    public static void zza(zzajp zzajp, String str, Map map) {
        try {
            zzajp.zzb(str, zzq.zzkw().zzj(map));
        } catch (JSONException unused) {
            zzaxv.zzfd("Could not convert parameters to JSON.");
        }
    }
}
