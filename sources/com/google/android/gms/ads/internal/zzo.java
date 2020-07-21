package com.google.android.gms.ads.internal;

import android.content.Context;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzbbd;
import com.google.android.gms.internal.ads.zzddt;
import com.google.android.gms.internal.ads.zzve;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzo {
    private final String zzbpg;
    private final Map<String, String> zzbph = new TreeMap();
    private String zzbpi;
    private String zzbpj;
    private final Context zzvr;

    public zzo(Context context, String str) {
        this.zzvr = context.getApplicationContext();
        this.zzbpg = str;
    }

    public final String zzko() {
        return this.zzbpj;
    }

    public final String getQuery() {
        return this.zzbpi;
    }

    public final String zzkp() {
        return this.zzbpg;
    }

    public final Map<String, String> zzkq() {
        return this.zzbph;
    }

    public final void zza(zzve zzve, zzbbd zzbbd) {
        this.zzbpi = zzve.zzcgx.zzbpi;
        Bundle bundle = zzve.zzcgz != null ? zzve.zzcgz.getBundle(AdMobAdapter.class.getName()) : null;
        if (bundle != null) {
            String str = zzacb.zzcyz.get();
            for (String str2 : bundle.keySet()) {
                if (str.equals(str2)) {
                    this.zzbpj = bundle.getString(str2);
                } else if (str2.startsWith("csa_")) {
                    this.zzbph.put(str2.substring(4), bundle.getString(str2));
                }
            }
            this.zzbph.put("SDKVersion", zzbbd.zzbpn);
            if (zzacb.zzcyx.get().booleanValue()) {
                try {
                    Bundle zza = zzddt.zza(this.zzvr, new JSONArray(zzacb.zzcyy.get()));
                    for (String str3 : zza.keySet()) {
                        this.zzbph.put(str3, zza.get(str3).toString());
                    }
                } catch (JSONException e) {
                    zzaxv.zzc("Flag gads:afs:csa_tcf_data_to_collect not a valid JSON array", e);
                }
            }
        }
    }
}
