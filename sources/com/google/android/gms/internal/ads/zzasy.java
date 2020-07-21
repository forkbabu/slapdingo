package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzasy extends zzata {
    private final Object lock = new Object();
    private final Context zzaah;
    private SharedPreferences zzdui;
    private final zzalj<JSONObject, JSONObject> zzduj;

    public zzasy(Context context, zzalj<JSONObject, JSONObject> zzalj) {
        this.zzaah = context.getApplicationContext();
        this.zzduj = zzalj;
    }

    @Override // com.google.android.gms.internal.ads.zzata
    public final zzdvf<Void> zzvg() {
        synchronized (this.lock) {
            if (this.zzdui == null) {
                this.zzdui = this.zzaah.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzq.zzld().currentTimeMillis() - this.zzdui.getLong("js_last_update", 0) < zzacl.zzdal.get().longValue()) {
            return zzdux.zzaf(null);
        }
        return zzdux.zzb(this.zzduj.zzi(zzz(this.zzaah)), new zzasx(this), zzbbf.zzedm);
    }

    public static JSONObject zzz(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzbbd.zzym().zzbpn);
            jSONObject.put("mf", zzacl.zzdak.get());
            jSONObject.put("cl", "312401170");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", 20360);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzf(JSONObject jSONObject) {
        zzaav.zza(this.zzaah, 1, jSONObject);
        this.zzdui.edit().putLong("js_last_update", zzq.zzld().currentTimeMillis()).apply();
        return null;
    }
}
