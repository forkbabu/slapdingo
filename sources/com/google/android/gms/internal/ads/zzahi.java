package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.applex.snaplingo.util.Constants;
import com.google.android.gms.ads.internal.zzq;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzahi implements zzahc<Object> {
    private final Object lock = new Object();
    private final Map<String, zzahk> zzdei = new HashMap();

    public final void zza(String str, zzahk zzahk) {
        synchronized (this.lock) {
            this.zzdei.put(str, zzahk);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahc
    public final void zza(Object obj, Map<String, String> map) {
        String str;
        String str2 = map.get("id");
        String str3 = map.get("fail");
        String str4 = map.get("fail_reason");
        String str5 = map.get("fail_stack");
        String str6 = map.get(Constants.RESULT);
        if (TextUtils.isEmpty(str5)) {
            str4 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str5)) {
            str = "";
        } else {
            String valueOf = String.valueOf(str5);
            str = valueOf.length() != 0 ? "\n".concat(valueOf) : new String("\n");
        }
        synchronized (this.lock) {
            zzahk remove = this.zzdei.remove(str2);
            if (remove == null) {
                String valueOf2 = String.valueOf(str2);
                zzaxv.zzfd(valueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(valueOf2) : new String("Received result for unexpected method invocation: "));
            } else if (!TextUtils.isEmpty(str3)) {
                String valueOf3 = String.valueOf(str4);
                String valueOf4 = String.valueOf(str);
                remove.onFailure(valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3));
            } else if (str6 == null) {
                remove.zzc(null);
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str6);
                    if (zzaxv.zzwr()) {
                        String valueOf5 = String.valueOf(jSONObject.toString(2));
                        zzaxv.zzeh(valueOf5.length() != 0 ? "Result GMSG: ".concat(valueOf5) : new String("Result GMSG: "));
                    }
                    remove.zzc(jSONObject);
                } catch (JSONException e) {
                    remove.onFailure(e.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzake> zzdvf<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzbbn zzbbn = new zzbbn();
        zzq.zzkw();
        String zzxj = zzaye.zzxj();
        zza(zzxj, new zzahl(this, zzbbn));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", zzxj);
            jSONObject2.put("args", jSONObject);
            enginet.zza(str, jSONObject2);
        } catch (Exception e) {
            zzbbn.setException(e);
        }
        return zzbbn;
    }
}
