package com.google.android.gms.ads.internal.overlay;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.applex.snaplingo.util.Constants;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzaxv;
import com.google.android.gms.internal.ads.zzaye;
import com.google.android.gms.internal.ads.zzwg;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzb {
    public static boolean zza(Context context, zzd zzd, zzt zzt) {
        int i = 0;
        if (zzd == null) {
            zzaxv.zzfd("No intent data for launcher overlay.");
            return false;
        }
        zzaav.initialize(context);
        if (zzd.intent != null) {
            return zza(context, zzd.intent, zzt);
        }
        Intent intent = new Intent();
        if (TextUtils.isEmpty(zzd.url)) {
            zzaxv.zzfd("Open GMSG did not contain a URL.");
            return false;
        }
        if (!TextUtils.isEmpty(zzd.mimeType)) {
            intent.setDataAndType(Uri.parse(zzd.url), zzd.mimeType);
        } else {
            intent.setData(Uri.parse(zzd.url));
        }
        intent.setAction("android.intent.action.VIEW");
        if (!TextUtils.isEmpty(zzd.packageName)) {
            intent.setPackage(zzd.packageName);
        }
        if (!TextUtils.isEmpty(zzd.zzdnt)) {
            String[] split = zzd.zzdnt.split(Constants.PATH_SEPERATOR, 2);
            if (split.length < 2) {
                String valueOf = String.valueOf(zzd.zzdnt);
                zzaxv.zzfd(valueOf.length() != 0 ? "Could not parse component name from open GMSG: ".concat(valueOf) : new String("Could not parse component name from open GMSG: "));
                return false;
            }
            intent.setClassName(split[0], split[1]);
        }
        String str = zzd.zzdnu;
        if (!TextUtils.isEmpty(str)) {
            try {
                i = Integer.parseInt(str);
            } catch (NumberFormatException unused) {
                zzaxv.zzfd("Could not parse intent flags.");
            }
            intent.addFlags(i);
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcss)).booleanValue()) {
            intent.addFlags(268435456);
            intent.putExtra("android.support.customtabs.extra.user_opt_out", true);
        } else {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcsr)).booleanValue()) {
                zzq.zzkw();
                zzaye.zzb(context, intent);
            }
        }
        return zza(context, intent, zzt);
    }

    private static boolean zza(Context context, Intent intent, zzt zzt) {
        try {
            String valueOf = String.valueOf(intent.toURI());
            zzaxv.zzeh(valueOf.length() != 0 ? "Launching an intent: ".concat(valueOf) : new String("Launching an intent: "));
            zzq.zzkw();
            zzaye.zza(context, intent);
            if (zzt == null) {
                return true;
            }
            zzt.zzuu();
            return true;
        } catch (ActivityNotFoundException e) {
            zzaxv.zzfd(e.getMessage());
            return false;
        }
    }
}
