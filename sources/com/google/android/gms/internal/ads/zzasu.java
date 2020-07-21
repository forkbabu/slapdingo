package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import androidx.core.app.NotificationCompat;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzasu {
    private float zzbru;
    private int zzdmt;
    private int zzdmu;
    private int zzdsw;
    private boolean zzdsx;
    private boolean zzdsy;
    private String zzdsz;
    private String zzdta;
    private boolean zzdtb;
    private final boolean zzdtc;
    private boolean zzdtd;
    private boolean zzdte;
    private boolean zzdtf;
    private String zzdtg;
    private String zzdth;
    private String zzdti;
    private int zzdtj;
    private int zzdtk;
    private int zzdtl;
    private int zzdtm;
    private int zzdtn;
    private int zzdto;
    private double zzdtp;
    private boolean zzdtq;
    private boolean zzdtr;
    private int zzdts;
    private String zzdtt;
    private String zzdtu;
    private boolean zzdtv;

    public zzasu(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzv(context);
        zzw(context);
        zzx(context);
        Locale locale = Locale.getDefault();
        boolean z = true;
        this.zzdsx = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdsy = zza(packageManager, "http://www.google.com") == null ? false : z;
        this.zzdta = locale.getCountry();
        zzwg.zzps();
        this.zzdtb = zzbaq.zzyh();
        this.zzdtc = DeviceProperties.isLatchsky(context);
        this.zzdtd = DeviceProperties.isSidewinder(context);
        this.zzdtg = locale.getLanguage();
        this.zzdth = zza(context, packageManager);
        this.zzdti = zzy(context);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.zzbru = displayMetrics.density;
            this.zzdmt = displayMetrics.widthPixels;
            this.zzdmu = displayMetrics.heightPixels;
        }
    }

    public zzasu(Context context, zzasr zzasr) {
        zzv(context);
        zzw(context);
        zzx(context);
        this.zzdtt = Build.FINGERPRINT;
        this.zzdtu = Build.DEVICE;
        this.zzdtv = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzabs.zzk(context);
        this.zzdsx = zzasr.zzdsx;
        this.zzdsy = zzasr.zzdsy;
        this.zzdta = zzasr.zzdta;
        this.zzdtb = zzasr.zzdtb;
        this.zzdtc = zzasr.zzdtc;
        this.zzdtd = zzasr.zzdtd;
        this.zzdtg = zzasr.zzdtg;
        this.zzdth = zzasr.zzdth;
        this.zzdti = zzasr.zzdti;
        this.zzbru = zzasr.zzbru;
        this.zzdmt = zzasr.zzdmt;
        this.zzdmu = zzasr.zzdmu;
    }

    private final void zzv(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdsw = audioManager.getMode();
                this.zzdte = audioManager.isMusicActive();
                this.zzdtf = audioManager.isSpeakerphoneOn();
                this.zzdtj = audioManager.getStreamVolume(3);
                this.zzdtn = audioManager.getRingerMode();
                this.zzdto = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzq.zzla().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdsw = -2;
        this.zzdte = false;
        this.zzdtf = false;
        this.zzdtj = 0;
        this.zzdtn = 2;
        this.zzdto = 0;
    }

    private final void zzw(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.zzdsz = telephonyManager.getNetworkOperator();
        this.zzdtl = telephonyManager.getNetworkType();
        this.zzdtm = telephonyManager.getPhoneType();
        this.zzdtk = -2;
        this.zzdtr = false;
        this.zzdts = -1;
        zzq.zzkw();
        if (zzaye.zzr(context, "android.permission.ACCESS_NETWORK_STATE")) {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                this.zzdtk = activeNetworkInfo.getType();
                this.zzdts = activeNetworkInfo.getDetailedState().ordinal();
            } else {
                this.zzdtk = -1;
            }
            this.zzdtr = connectivityManager.isActiveNetworkMetered();
        }
    }

    private final void zzx(Context context) {
        Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra(NotificationCompat.CATEGORY_STATUS, -1);
            this.zzdtp = (double) (((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzdtq = z;
            return;
        }
        this.zzdtp = -1.0d;
        this.zzdtq = false;
    }

    private static String zzy(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), 65536);
        } catch (Throwable th) {
            zzq.zzla().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    public final zzasr zzvf() {
        return new zzasr(this.zzdsw, this.zzdsx, this.zzdsy, this.zzdsz, this.zzdta, this.zzdtb, this.zzdtc, this.zzdtd, this.zzdte, this.zzdtf, this.zzdtg, this.zzdth, this.zzdti, this.zzdtj, this.zzdtk, this.zzdtl, this.zzdtm, this.zzdtn, this.zzdto, this.zzbru, this.zzdmt, this.zzdmu, this.zzdtp, this.zzdtq, this.zzdtr, this.zzdts, this.zzdtt, this.zzdtv, this.zzdtu);
    }
}
