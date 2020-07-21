package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.applex.snaplingo.util.Constants;
import com.itextpdf.text.html.HtmlTags;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzagm {
    public static final zzahc<zzbfn> zzddk = zzagp.zzded;
    public static final zzahc<zzbfn> zzddl = zzago.zzded;
    public static final zzahc<zzbfn> zzddm = zzagr.zzded;
    public static final zzahc<zzbfn> zzddn = zzagq.zzded;
    public static final zzahc<zzbfn> zzddo = new zzagv();
    public static final zzahc<zzbfn> zzddp = new zzagu();
    public static final zzahc<zzbfn> zzddq = zzagt.zzded;
    public static final zzahc<Object> zzddr = new zzagx();
    public static final zzahc<zzbfn> zzdds = new zzagw();
    public static final zzahc<zzbfn> zzddt = zzags.zzded;
    public static final zzahc<zzbfn> zzddu = new zzagz();
    public static final zzahc<zzbfn> zzddv = new zzagy();
    public static final zzahc<zzbdb> zzddw = new zzbel();
    public static final zzahc<zzbdb> zzddx = new zzbeo();
    public static final zzahc<zzbfn> zzddy = new zzagn();
    public static final zzahi zzddz = new zzahi();
    public static final zzahc<zzbfn> zzdea = new zzahb();
    public static final zzahc<zzbfn> zzdeb = new zzaha();
    public static final zzahc<zzbfn> zzdec = new zzahd();

    static final /* synthetic */ void zza(zzbgy zzbgy, Map map) {
        String str = (String) map.get("tx");
        String str2 = (String) map.get("ty");
        String str3 = (String) map.get(HtmlTags.TD);
        try {
            int parseInt = Integer.parseInt(str);
            int parseInt2 = Integer.parseInt(str2);
            int parseInt3 = Integer.parseInt(str3);
            zzeg zzabc = zzbgy.zzabc();
            if (zzabc != null) {
                zzabc.zzcb().zza(parseInt, parseInt2, parseInt3);
            }
        } catch (NumberFormatException unused) {
            zzaxv.zzfd("Could not parse touch parameters from gmsg.");
        }
    }

    static final /* synthetic */ void zza(zzbgq zzbgq, Map map) {
        String str = (String) map.get(HtmlTags.U);
        if (str == null) {
            zzaxv.zzfd("URL missing from httpTrack GMSG.");
        } else {
            new zzbad(zzbgq.getContext(), ((zzbgx) zzbgq).zzzo().zzbpn, str).zzwq();
        }
    }

    static final /* synthetic */ void zza(zzajh zzajh, Map map) {
        String str = (String) map.get(HtmlTags.U);
        if (str == null) {
            zzaxv.zzfd("URL missing from click GMSG.");
            return;
        }
        Uri parse = Uri.parse(str);
        try {
            zzeg zzabc = ((zzbgy) zzajh).zzabc();
            if (zzabc != null && zzabc.zzb(parse)) {
                parse = zzabc.zza(parse, ((zzbgq) zzajh).getContext(), ((zzbha) zzajh).getView(), ((zzbgq) zzajh).zzzl());
            }
        } catch (zzef unused) {
            String valueOf = String.valueOf(str);
            zzaxv.zzfd(valueOf.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf) : new String("Unable to append parameter to URL: "));
        }
        zzbgq zzbgq = (zzbgq) zzajh;
        new zzbad(zzbgq.getContext(), ((zzbgx) zzajh).zzzo().zzbpn, zzawn.zzb(parse, zzbgq.getContext())).zzwq();
    }

    static final /* synthetic */ void zzb(zzbgq zzbgq, Map map) {
        PackageManager packageManager = zzbgq.getContext().getPackageManager();
        try {
            try {
                JSONArray jSONArray = new JSONObject((String) map.get("data")).getJSONArray("intents");
                JSONObject jSONObject = new JSONObject();
                for (int i = 0; i < jSONArray.length(); i++) {
                    try {
                        JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                        String optString = jSONObject2.optString("id");
                        String optString2 = jSONObject2.optString(HtmlTags.U);
                        String optString3 = jSONObject2.optString(HtmlTags.I);
                        String optString4 = jSONObject2.optString("m");
                        String optString5 = jSONObject2.optString(HtmlTags.P);
                        String optString6 = jSONObject2.optString("c");
                        String optString7 = jSONObject2.optString("intent_url");
                        Intent intent = null;
                        if (!TextUtils.isEmpty(optString7)) {
                            try {
                                intent = Intent.parseUri(optString7, 0);
                            } catch (URISyntaxException e) {
                                String valueOf = String.valueOf(optString7);
                                zzaxv.zzc(valueOf.length() != 0 ? "Error parsing the url: ".concat(valueOf) : new String("Error parsing the url: "), e);
                            }
                        }
                        boolean z = true;
                        if (intent == null) {
                            intent = new Intent();
                            if (!TextUtils.isEmpty(optString2)) {
                                intent.setData(Uri.parse(optString2));
                            }
                            if (!TextUtils.isEmpty(optString3)) {
                                intent.setAction(optString3);
                            }
                            if (!TextUtils.isEmpty(optString4)) {
                                intent.setType(optString4);
                            }
                            if (!TextUtils.isEmpty(optString5)) {
                                intent.setPackage(optString5);
                            }
                            if (!TextUtils.isEmpty(optString6)) {
                                String[] split = optString6.split(Constants.PATH_SEPERATOR, 2);
                                if (split.length == 2) {
                                    intent.setComponent(new ComponentName(split[0], split[1]));
                                }
                            }
                        }
                        if (packageManager.resolveActivity(intent, 65536) == null) {
                            z = false;
                        }
                        try {
                            jSONObject.put(optString, z);
                        } catch (JSONException e2) {
                            zzaxv.zzc("Error constructing openable urls response.", e2);
                        }
                    } catch (JSONException e3) {
                        zzaxv.zzc("Error parsing the intent data.", e3);
                    }
                }
                ((zzajh) zzbgq).zzb("openableIntents", jSONObject);
            } catch (JSONException unused) {
                ((zzajh) zzbgq).zzb("openableIntents", new JSONObject());
            }
        } catch (JSONException unused2) {
            ((zzajh) zzbgq).zzb("openableIntents", new JSONObject());
        }
    }

    static final /* synthetic */ void zzc(zzbgq zzbgq, Map map) {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcxq)).booleanValue()) {
            zzaxv.zzfd("canOpenAppGmsgHandler disabled.");
            return;
        }
        String str = (String) map.get("package_name");
        if (TextUtils.isEmpty(str)) {
            zzaxv.zzfd("Package name missing in canOpenApp GMSG.");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put(str, Boolean.valueOf(zzbgq.getContext().getPackageManager().getLaunchIntentForPackage(str) != null));
        ((zzajh) zzbgq).zza("openableApp", hashMap);
    }

    static final /* synthetic */ void zzd(zzbgq zzbgq, Map map) {
        String str = (String) map.get("urls");
        if (TextUtils.isEmpty(str)) {
            zzaxv.zzfd("URLs missing in canOpenURLs GMSG.");
            return;
        }
        String[] split = str.split(",");
        HashMap hashMap = new HashMap();
        PackageManager packageManager = zzbgq.getContext().getPackageManager();
        for (String str2 : split) {
            String[] split2 = str2.split(";", 2);
            boolean z = true;
            if (packageManager.resolveActivity(new Intent(split2.length > 1 ? split2[1].trim() : "android.intent.action.VIEW", Uri.parse(split2[0].trim())), 65536) == null) {
                z = false;
            }
            hashMap.put(str2, Boolean.valueOf(z));
        }
        ((zzajh) zzbgq).zza("openableURLs", hashMap);
    }
}
