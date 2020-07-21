package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import com.google.firebase.crashlytics.internal.settings.model.AppSettingsData;
import com.itextpdf.text.html.HtmlTags;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbel implements zzahc<zzbdb> {
    private boolean zzeka;

    private static int zza(Context context, Map<String, String> map, String str, int i) {
        String str2 = map.get(str);
        if (str2 == null) {
            return i;
        }
        try {
            zzwg.zzps();
            return zzbaq.zzc(context, Integer.parseInt(str2));
        } catch (NumberFormatException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 34 + String.valueOf(str2).length());
            sb.append("Could not parse ");
            sb.append(str);
            sb.append(" in a video GMSG: ");
            sb.append(str2);
            zzaxv.zzfd(sb.toString());
            return i;
        }
    }

    private static void zza(zzbco zzbco, Map<String, String> map) {
        String str = map.get("minBufferMs");
        String str2 = map.get("maxBufferMs");
        String str3 = map.get("bufferForPlaybackMs");
        String str4 = map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzbco.zzdj(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                zzaxv.zzfd(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzbco.zzdk(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzbco.zzdl(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzbco.zzdm(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzbco.zzdn(Integer.parseInt(str5));
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.util.Map] */
    @Override // com.google.android.gms.internal.ads.zzahc
    public final /* synthetic */ void zza(zzbdb zzbdb, Map map) {
        int i;
        zzbdb zzbdb2 = zzbdb;
        String str = (String) map.get("action");
        if (str == null) {
            zzaxv.zzfd("Action missing from video GMSG.");
            return;
        }
        if (zzaxv.isLoggable(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            String jSONObject2 = jSONObject.toString();
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 13 + String.valueOf(jSONObject2).length());
            sb.append("Video GMSG: ");
            sb.append(str);
            sb.append(" ");
            sb.append(jSONObject2);
            zzaxv.zzee(sb.toString());
        }
        if ("background".equals(str)) {
            String str2 = (String) map.get(HtmlTags.COLOR);
            if (TextUtils.isEmpty(str2)) {
                zzaxv.zzfd("Color parameter missing from color video GMSG.");
                return;
            }
            try {
                zzbdb2.setBackgroundColor(Color.parseColor(str2));
            } catch (IllegalArgumentException unused) {
                zzaxv.zzfd("Invalid color parameter in video GMSG.");
            }
        } else {
            if ("decoderProps".equals(str)) {
                String str3 = (String) map.get("mimeTypes");
                if (str3 == null) {
                    zzaxv.zzfd("No MIME types specified for decoder properties inspection.");
                    zzbco.zza(zzbdb2, "missingMimeTypes");
                    return;
                }
                HashMap hashMap = new HashMap();
                String[] split = str3.split(",");
                for (String str4 : split) {
                    hashMap.put(str4, zzbao.zzev(str4.trim()));
                }
                zzbco.zza(zzbdb2, hashMap);
                return;
            }
            zzbcu zzzi = zzbdb2.zzzi();
            if (zzzi == null) {
                zzaxv.zzfd("Could not get underlay container for a video GMSG.");
                return;
            }
            boolean equals = AppSettingsData.STATUS_NEW.equals(str);
            boolean equals2 = "position".equals(str);
            if (equals || equals2) {
                Context context = zzbdb2.getContext();
                int zza = zza(context, map, "x", 0);
                int zza2 = zza(context, map, "y", 0);
                int zza3 = zza(context, map, "w", -1);
                int zza4 = zza(context, map, "h", -1);
                int min = Math.min(zza3, zzbdb2.zzzq() - zza);
                int min2 = Math.min(zza4, zzbdb2.zzzp() - zza2);
                try {
                    i = Integer.parseInt((String) map.get("player"));
                } catch (NumberFormatException unused2) {
                    i = 0;
                }
                boolean parseBoolean = Boolean.parseBoolean((String) map.get("spherical"));
                if (!equals || zzzi.zzze() != null) {
                    zzzi.zze(zza, zza2, min, min2);
                    return;
                }
                zzzi.zza(zza, zza2, min, min2, i, parseBoolean, new zzbdc((String) map.get("flags")));
                zzbco zzze = zzzi.zzze();
                if (zzze != null) {
                    zza(zzze, (Map<String, String>) map);
                    return;
                }
                return;
            }
            zzbgh zzzj = zzbdb2.zzzj();
            if (zzzj != null) {
                if ("timeupdate".equals(str)) {
                    String str5 = (String) map.get("currentTime");
                    if (str5 == null) {
                        zzaxv.zzfd("currentTime parameter missing from timeupdate video GMSG.");
                        return;
                    }
                    try {
                        zzzj.zze(Float.parseFloat(str5));
                        return;
                    } catch (NumberFormatException unused3) {
                        String valueOf = String.valueOf(str5);
                        zzaxv.zzfd(valueOf.length() != 0 ? "Could not parse currentTime parameter from timeupdate video GMSG: ".concat(valueOf) : new String("Could not parse currentTime parameter from timeupdate video GMSG: "));
                        return;
                    }
                } else if ("skip".equals(str)) {
                    zzzj.zzacn();
                    return;
                }
            }
            zzbco zzze2 = zzzi.zzze();
            if (zzze2 == null) {
                zzbco.zzb(zzbdb2);
            } else if ("click".equals(str)) {
                Context context2 = zzbdb2.getContext();
                int zza5 = zza(context2, map, "x", 0);
                int zza6 = zza(context2, map, "y", 0);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 0, (float) zza5, (float) zza6, 0);
                zzze2.zze(obtain);
                obtain.recycle();
            } else if ("currentTime".equals(str)) {
                String str6 = (String) map.get("time");
                if (str6 == null) {
                    zzaxv.zzfd("Time parameter missing from currentTime video GMSG.");
                    return;
                }
                try {
                    zzze2.seekTo((int) (Float.parseFloat(str6) * 1000.0f));
                } catch (NumberFormatException unused4) {
                    String valueOf2 = String.valueOf(str6);
                    zzaxv.zzfd(valueOf2.length() != 0 ? "Could not parse time parameter from currentTime video GMSG: ".concat(valueOf2) : new String("Could not parse time parameter from currentTime video GMSG: "));
                }
            } else if ("hide".equals(str)) {
                zzze2.setVisibility(4);
            } else if ("load".equals(str)) {
                zzze2.zzhx();
            } else if ("loadControl".equals(str)) {
                zza(zzze2, (Map<String, String>) map);
            } else if ("muted".equals(str)) {
                if (Boolean.parseBoolean((String) map.get("muted"))) {
                    zzze2.zzyy();
                } else {
                    zzze2.zzyz();
                }
            } else if ("pause".equals(str)) {
                zzze2.pause();
            } else if ("play".equals(str)) {
                zzze2.play();
            } else if ("show".equals(str)) {
                zzze2.setVisibility(0);
            } else if (HtmlTags.SRC.equals(str)) {
                String str7 = (String) map.get(HtmlTags.SRC);
                String[] strArr = {str7};
                String str8 = (String) map.get("demuxed");
                if (str8 != null) {
                    try {
                        JSONArray jSONArray = new JSONArray(str8);
                        String[] strArr2 = new String[jSONArray.length()];
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            strArr2[i2] = jSONArray.getString(i2);
                        }
                        strArr = strArr2;
                    } catch (JSONException unused5) {
                        String valueOf3 = String.valueOf(str8);
                        zzaxv.zzfd(valueOf3.length() != 0 ? "Malformed demuxed URL list for playback: ".concat(valueOf3) : new String("Malformed demuxed URL list for playback: "));
                        strArr = new String[]{str7};
                    }
                }
                zzze2.zzc(str7, strArr);
            } else if ("touchMove".equals(str)) {
                Context context3 = zzbdb2.getContext();
                zzze2.zza((float) zza(context3, map, "dx", 0), (float) zza(context3, map, "dy", 0));
                if (!this.zzeka) {
                    zzbdb2.zzur();
                    this.zzeka = true;
                }
            } else if ("volume".equals(str)) {
                String str9 = (String) map.get("volume");
                if (str9 == null) {
                    zzaxv.zzfd("Level parameter missing from volume video GMSG.");
                    return;
                }
                try {
                    zzze2.setVolume(Float.parseFloat(str9));
                } catch (NumberFormatException unused6) {
                    String valueOf4 = String.valueOf(str9);
                    zzaxv.zzfd(valueOf4.length() != 0 ? "Could not parse volume parameter from volume video GMSG: ".concat(valueOf4) : new String("Could not parse volume parameter from volume video GMSG: "));
                }
            } else if ("watermark".equals(str)) {
                zzze2.zzza();
            } else {
                String valueOf5 = String.valueOf(str);
                zzaxv.zzfd(valueOf5.length() != 0 ? "Unknown video action: ".concat(valueOf5) : new String("Unknown video action: "));
            }
        }
    }
}
