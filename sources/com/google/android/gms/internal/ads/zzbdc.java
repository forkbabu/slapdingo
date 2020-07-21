package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbdc {
    public final boolean zzehh;
    public final int zzehi;
    public final int zzehj;
    public final int zzehk;
    private final String zzehl;
    public final int zzehm;
    public final int zzehn;
    public final int zzeho;
    public final int zzehp;
    public final boolean zzehq;
    public final int zzehr;

    public zzbdc(String str) {
        JSONObject jSONObject = null;
        if (str != null) {
            try {
                jSONObject = new JSONObject(str);
            } catch (JSONException unused) {
            }
        }
        this.zzehh = zza(jSONObject, "aggressive_media_codec_release", zzaav.zzcmh);
        this.zzehi = zzb(jSONObject, "byte_buffer_precache_limit", zzaav.zzclp);
        this.zzehj = zzb(jSONObject, "exo_cache_buffer_size", zzaav.zzclw);
        this.zzehk = zzb(jSONObject, "exo_connect_timeout_millis", zzaav.zzcll);
        this.zzehl = zzc(jSONObject, "exo_player_version", zzaav.zzclk);
        this.zzehm = zzb(jSONObject, "exo_read_timeout_millis", zzaav.zzclm);
        this.zzehn = zzb(jSONObject, "load_check_interval_bytes", zzaav.zzcln);
        this.zzeho = zzb(jSONObject, "player_precache_limit", zzaav.zzclo);
        this.zzehp = zzb(jSONObject, "socket_receive_buffer_size", zzaav.zzclq);
        this.zzehq = zza(jSONObject, "use_cache_data_source", zzaav.zzcsk);
        this.zzehr = zzb(jSONObject, "min_retry_count", zzaav.zzcls);
    }

    private static boolean zza(JSONObject jSONObject, String str, zzaag<Boolean> zzaag) {
        return zza(jSONObject, str, ((Boolean) zzwg.zzpw().zzd(zzaag)).booleanValue());
    }

    private static boolean zza(JSONObject jSONObject, String str, boolean z) {
        if (jSONObject != null) {
            try {
                return jSONObject.getBoolean(str);
            } catch (JSONException unused) {
            }
        }
        return z;
    }

    private static int zzb(JSONObject jSONObject, String str, zzaag<Integer> zzaag) {
        if (jSONObject != null) {
            try {
                return jSONObject.getInt(str);
            } catch (JSONException unused) {
            }
        }
        return ((Integer) zzwg.zzpw().zzd(zzaag)).intValue();
    }

    private static String zzc(JSONObject jSONObject, String str, zzaag<String> zzaag) {
        if (jSONObject != null) {
            try {
                return jSONObject.getString(str);
            } catch (JSONException unused) {
            }
        }
        return (String) zzwg.zzpw().zzd(zzaag);
    }
}
