package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.ads.internal.zzq;
import com.google.firebase.crashlytics.internal.common.AbstractSpiCall;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzaze {
    private final Object lock = new Object();
    private String zzear = "";
    private String zzeas = "";
    private boolean zzeat = false;
    private String zzeau = "";

    public final void zze(Context context, String str, String str2) {
        if (!zzf(context, str, str2)) {
            zza(context, "In-app preview failed to load because of a system error. Please try again later.", true, true);
        } else if (ExifInterface.GPS_MEASUREMENT_2D.equals(this.zzeau)) {
            zzaxv.zzee("Creative is not pushed for this device.");
            zza(context, "There was no creative pushed from DFP to the device.", false, false);
        } else if ("1".equals(this.zzeau)) {
            zzaxv.zzee("The app is not linked for creative preview.");
            zzi(context, str, str2);
        } else if ("0".equals(this.zzeau)) {
            zzaxv.zzee("Device is linked for in app preview.");
            zza(context, "The device is successfully linked for creative preview.", false, true);
        }
    }

    public final void zza(Context context, String str, String str2, String str3) {
        boolean zzxx = zzxx();
        if (zzg(context, str, str2)) {
            if (!zzxx && !TextUtils.isEmpty(str3)) {
                zzc(context, str2, str3, str);
            }
            zzaxv.zzee("Device is linked for debug signals.");
            zza(context, "The device is successfully linked for troubleshooting.", false, true);
            return;
        }
        zzi(context, str, str2);
    }

    private final boolean zzf(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzwg.zzpw().zzd(zzaav.zzcsv), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzaxv.zzee("Not linked for in app preview.");
            return false;
        }
        try {
            JSONObject jSONObject = new JSONObject(zzh.trim());
            String optString = jSONObject.optString("gct");
            this.zzeau = jSONObject.optString(NotificationCompat.CATEGORY_STATUS);
            synchronized (this.lock) {
                this.zzeas = optString;
            }
            return true;
        } catch (JSONException e) {
            zzaxv.zzd("Fail to get in app preview response json.", e);
            return false;
        }
    }

    private final boolean zzg(Context context, String str, String str2) {
        String zzh = zzh(context, zzd(context, (String) zzwg.zzpw().zzd(zzaav.zzcsw), str, str2).toString(), str2);
        if (TextUtils.isEmpty(zzh)) {
            zzaxv.zzee("Not linked for debug signals.");
            return false;
        }
        try {
            boolean equals = "1".equals(new JSONObject(zzh.trim()).optString("debug_mode"));
            synchronized (this.lock) {
                this.zzeat = equals;
            }
            return equals;
        } catch (JSONException e) {
            zzaxv.zzd("Fail to get debug mode response json.", e);
            return false;
        }
    }

    private static String zzh(Context context, String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put(AbstractSpiCall.HEADER_USER_AGENT, zzq.zzkw().zzs(context, str2));
        zzdvf<String> zzc = new zzazq(context).zzc(str, hashMap);
        try {
            return zzc.get((long) ((Integer) zzwg.zzpw().zzd(zzaav.zzcsy)).intValue(), TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            String valueOf = String.valueOf(str);
            zzaxv.zzc(valueOf.length() != 0 ? "Timeout while retriving a response from: ".concat(valueOf) : new String("Timeout while retriving a response from: "), e);
            zzc.cancel(true);
            return null;
        } catch (InterruptedException e2) {
            String valueOf2 = String.valueOf(str);
            zzaxv.zzc(valueOf2.length() != 0 ? "Interrupted while retriving a response from: ".concat(valueOf2) : new String("Interrupted while retriving a response from: "), e2);
            zzc.cancel(true);
            return null;
        } catch (Exception e3) {
            String valueOf3 = String.valueOf(str);
            zzaxv.zzc(valueOf3.length() != 0 ? "Error retriving a response from: ".concat(valueOf3) : new String("Error retriving a response from: "), e3);
            return null;
        }
    }

    private final void zzi(Context context, String str, String str2) {
        zzq.zzkw();
        zzaye.zza(context, zzd(context, (String) zzwg.zzpw().zzd(zzaav.zzcsu), str, str2));
    }

    public final boolean zzb(Context context, String str, String str2, String str3) {
        if (TextUtils.isEmpty(str2) || !zzq.zzlg().zzxx()) {
            return false;
        }
        zzaxv.zzee("Sending troubleshooting signals to the server.");
        zzc(context, str, str2, str3);
        return true;
    }

    private final void zzc(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = zzd(context, (String) zzwg.zzpw().zzd(zzaav.zzcsx), str3, str).buildUpon();
        buildUpon.appendQueryParameter("debugData", str2);
        zzq.zzkw();
        zzaye.zzb(context, str, buildUpon.build().toString());
    }

    private final Uri zzd(Context context, String str, String str2, String str3) {
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("linkedDeviceId", zzbj(context));
        buildUpon.appendQueryParameter("adSlotPath", str2);
        buildUpon.appendQueryParameter("afmaVersion", str3);
        return buildUpon.build();
    }

    private final String zzbj(Context context) {
        String str;
        synchronized (this.lock) {
            if (TextUtils.isEmpty(this.zzear)) {
                zzq.zzkw();
                String zzt = zzaye.zzt(context, "debug_signals_id.txt");
                this.zzear = zzt;
                if (TextUtils.isEmpty(zzt)) {
                    zzq.zzkw();
                    this.zzear = zzaye.zzxj();
                    zzq.zzkw();
                    zzaye.zzc(context, "debug_signals_id.txt", this.zzear);
                }
            }
            str = this.zzear;
        }
        return str;
    }

    public final String zzxw() {
        String str;
        synchronized (this.lock) {
            str = this.zzeas;
        }
        return str;
    }

    public final boolean zzxx() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzeat;
        }
        return z;
    }

    private final void zza(Context context, String str, boolean z, boolean z2) {
        if (!(context instanceof Activity)) {
            zzaxv.zzfc("Can not create dialog without Activity Context");
        } else {
            zzaye.zzdzw.post(new zzazd(this, context, str, z, z2));
        }
    }
}
