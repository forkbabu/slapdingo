package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.itextpdf.text.html.HtmlTags;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbex implements zzahc<zzbdb> {
    private static Integer zzb(Map<String, String> map, String str) {
        if (!map.containsKey(str)) {
            return null;
        }
        try {
            return Integer.valueOf(Integer.parseInt(map.get(str)));
        } catch (NumberFormatException unused) {
            String str2 = map.get(str);
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 39 + String.valueOf(str2).length());
            sb.append("Precache invalid numeric parameter '");
            sb.append(str);
            sb.append("': ");
            sb.append(str2);
            zzaxv.zzfd(sb.toString());
            return null;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbdb zzbdb, Map map) {
        zzbes zzbes;
        zzbdb zzbdb2 = zzbdb;
        if (zzaxv.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String valueOf = String.valueOf(jSONObject);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 15);
            sb.append("Precache GMSG: ");
            sb.append(valueOf);
            zzaxv.zzee(sb.toString());
        }
        zzq.zzls();
        if (!map.containsKey("abort")) {
            String str = (String) map.get(HtmlTags.SRC);
            if (str != null) {
                String[] strArr = {str};
                String str2 = (String) map.get("demuxed");
                if (str2 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str2);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i = 0; i < jSONArray.length(); i++) {
                            strArr2[i] = jSONArray.getString(i);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused) {
                        String valueOf2 = String.valueOf(str2);
                        zzaxv.zzfd(valueOf2.length() != 0 ? "Malformed demuxed URL list for precache: ".concat(valueOf2) : new String("Malformed demuxed URL list for precache: "));
                        strArr = null;
                    }
                }
                if (strArr == null) {
                    strArr = new String[]{str};
                }
                if (zzbep.zzd(zzbdb2) != null) {
                    zzaxv.zzfd("Precache task is already running.");
                    return;
                } else if (zzbdb2.zzzm() == null) {
                    zzaxv.zzfd("Precache requires a dependency provider.");
                    return;
                } else {
                    zzbdc zzbdc = new zzbdc((String) map.get("flags"));
                    Integer zzb = zzb(map, "player");
                    if (zzb == null) {
                        zzb = 0;
                    }
                    zzbes = zzbdb2.zzzm().zzbny.zza(zzbdb2, zzb.intValue(), null, zzbdc);
                    new zzben(zzbdb2, zzbes, str, strArr).zzwq();
                }
            } else {
                zzben zzd = zzbep.zzd(zzbdb2);
                if (zzd != null) {
                    zzbes = zzd.zzekc;
                } else {
                    zzaxv.zzfd("Precache must specify a source.");
                    return;
                }
            }
            Integer zzb2 = zzb(map, "minBufferMs");
            if (zzb2 != null) {
                zzbes.zzdj(zzb2.intValue());
            }
            Integer zzb3 = zzb(map, "maxBufferMs");
            if (zzb3 != null) {
                zzbes.zzdk(zzb3.intValue());
            }
            Integer zzb4 = zzb(map, "bufferForPlaybackMs");
            if (zzb4 != null) {
                zzbes.zzdl(zzb4.intValue());
            }
            Integer zzb5 = zzb(map, "bufferForPlaybackAfterRebufferMs");
            if (zzb5 != null) {
                zzbes.zzdm(zzb5.intValue());
            }
        } else if (!zzbep.zzc(zzbdb2)) {
            zzaxv.zzfd("Precache abort but no precache task running.");
        }
    }
}
