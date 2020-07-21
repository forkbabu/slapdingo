package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.List;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzceu {
    private final zzdvi zzgad;
    private final zzcey zzgae;
    private final zzcfi zzgaf;

    public zzceu(zzdvi zzdvi, zzcey zzcey, zzcfi zzcfi) {
        this.zzgad = zzdvi;
        this.zzgae = zzcey;
        this.zzgaf = zzcfi;
    }

    public final zzdvf<zzcck> zza(zzdkw zzdkw, zzdkk zzdkk, JSONObject jSONObject) {
        zzdvf zzb;
        zzdvf zze = this.zzgad.zze(new zzcex(this, zzdkw, zzdkk, jSONObject));
        zzdvf<List<zzadf>> zzd = this.zzgae.zzd(jSONObject, "images");
        zzdvf<zzadf> zzc = this.zzgae.zzc(jSONObject, "secondary_image");
        zzdvf<zzadf> zzc2 = this.zzgae.zzc(jSONObject, "app_icon");
        zzdvf<zzada> zze2 = this.zzgae.zze(jSONObject, "attribution");
        zzdvf<zzbfn> zzm = this.zzgae.zzm(jSONObject);
        zzcey zzcey = this.zzgae;
        if (!jSONObject.optBoolean("enable_omid")) {
            zzb = zzdux.zzaf(null);
        } else {
            JSONObject optJSONObject = jSONObject.optJSONObject("omid_settings");
            if (optJSONObject == null) {
                zzb = zzdux.zzaf(null);
            } else {
                String optString = optJSONObject.optString("omid_html");
                if (TextUtils.isEmpty(optString)) {
                    zzb = zzdux.zzaf(null);
                } else {
                    zzb = zzdux.zzb(zzdux.zzaf(null), new zzcfc(zzcey, optString), zzbbf.zzedl);
                }
            }
        }
        zzdvf<List<zzcfn>> zzg = this.zzgaf.zzg(jSONObject, "custom_assets");
        return zzdux.zza(zze, zzd, zzc, zzc2, zze2, zzm, zzb, zzg).zza(new zzcew(this, zze, zzd, zzc2, zzc, zze2, jSONObject, zzm, zzb, zzg), this.zzgad);
    }
}
