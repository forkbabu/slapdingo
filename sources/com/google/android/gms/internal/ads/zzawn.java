package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzawn {
    public static String zzc(String str, Context context, boolean z) {
        String zzah;
        if ((((Boolean) zzwg.zzpw().zzd(zzaav.zzcnk)).booleanValue() && !z) || !zzq.zzlu().zzac(context) || TextUtils.isEmpty(str) || (zzah = zzq.zzlu().zzah(context)) == null) {
            return str;
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnc)).booleanValue()) {
            String str2 = (String) zzwg.zzpw().zzd(zzaav.zzcnd);
            if (!str.contains(str2)) {
                return str;
            }
            if (zzq.zzkw().zzeo(str)) {
                zzq.zzlu().zzi(context, zzah);
                return zzb(str, context).replace(str2, zzah);
            } else if (!zzq.zzkw().zzep(str)) {
                return str;
            } else {
                zzq.zzlu().zzj(context, zzah);
                return zzb(str, context).replace(str2, zzah);
            }
        } else if (str.contains("fbs_aeid")) {
            return str;
        } else {
            if (zzq.zzkw().zzeo(str)) {
                zzq.zzlu().zzi(context, zzah);
                return zza(zzb(str, context), "fbs_aeid", zzah).toString();
            } else if (!zzq.zzkw().zzep(str)) {
                return str;
            } else {
                zzq.zzlu().zzj(context, zzah);
                return zza(zzb(str, context), "fbs_aeid", zzah).toString();
            }
        }
    }

    private static String zzb(String str, Context context) {
        String zzaf = zzq.zzlu().zzaf(context);
        String zzag = zzq.zzlu().zzag(context);
        if (!str.contains("gmp_app_id") && !TextUtils.isEmpty(zzaf)) {
            str = zza(str, "gmp_app_id", zzaf).toString();
        }
        return (str.contains("fbs_aiid") || TextUtils.isEmpty(zzag)) ? str : zza(str, "fbs_aiid", zzag).toString();
    }

    public static String zzb(Uri uri, Context context) {
        if (!zzq.zzlu().zzac(context)) {
            return uri.toString();
        }
        String zzah = zzq.zzlu().zzah(context);
        if (zzah == null) {
            return uri.toString();
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnc)).booleanValue()) {
            String str = (String) zzwg.zzpw().zzd(zzaav.zzcnd);
            String uri2 = uri.toString();
            if (uri2.contains(str)) {
                zzq.zzlu().zzi(context, zzah);
                return zzb(uri2, context).replace(str, zzah);
            }
        } else if (TextUtils.isEmpty(uri.getQueryParameter("fbs_aeid"))) {
            String uri3 = zza(zzb(uri.toString(), context), "fbs_aeid", zzah).toString();
            zzq.zzlu().zzi(context, zzah);
            return uri3;
        }
        return uri.toString();
    }

    private static Uri zza(String str, String str2, String str3) {
        int indexOf = str.indexOf("&adurl");
        if (indexOf == -1) {
            indexOf = str.indexOf("?adurl");
        }
        if (indexOf == -1) {
            return Uri.parse(str).buildUpon().appendQueryParameter(str2, str3).build();
        }
        int i = indexOf + 1;
        return Uri.parse(str.substring(0, i) + str2 + "=" + str3 + "&" + str.substring(i));
    }
}
