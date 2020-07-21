package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzavy {
    private final AtomicReference<ThreadPoolExecutor> zzdwg = new AtomicReference<>(null);
    private final Object zzdwh = new Object();
    private String zzdwi = null;
    private String zzdwj = null;
    private final AtomicBoolean zzdwk = new AtomicBoolean(false);
    private final AtomicInteger zzdwl = new AtomicInteger(-1);
    private final AtomicReference<Object> zzdwm = new AtomicReference<>(null);
    private final AtomicReference<Object> zzdwn = new AtomicReference<>(null);
    private final ConcurrentMap<String, Method> zzdwo = new ConcurrentHashMap(9);
    private final AtomicReference<zzbhy> zzdwp = new AtomicReference<>(null);
    private final BlockingQueue<FutureTask<?>> zzdwq = new ArrayBlockingQueue(20);
    private final Object zzdwr = new Object();

    public final boolean zzac(Context context) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcmz)).booleanValue() && !this.zzdwk.get()) {
            if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnj)).booleanValue()) {
                return true;
            }
            if (this.zzdwl.get() == -1) {
                zzwg.zzps();
                if (!zzbaq.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzwg.zzps();
                    if (zzbaq.zzbp(context)) {
                        zzaxv.zzfd("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzdwl.set(0);
                    }
                }
                this.zzdwl.set(1);
            }
            if (this.zzdwl.get() == 1) {
                return true;
            }
        }
        return false;
    }

    private static boolean zzad(Context context) {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcng)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzwg.zzpw().zzd(zzaav.zzcnh)).intValue()) {
            return false;
        }
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcni)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    public final void zza(Context context, zzzu zzzu) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnm)).booleanValue() && zzac(context) && zzad(context)) {
            synchronized (this.zzdwr) {
            }
        }
    }

    public final void zza(Context context, zzve zzve) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnm)).booleanValue() && zzac(context) && zzad(context)) {
            synchronized (this.zzdwr) {
            }
        }
    }

    public final void zzf(Context context, String str) {
        if (zzac(context)) {
            if (zzad(context)) {
                zza("beginAdUnitExposure", new zzavx(str));
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zzg(Context context, String str) {
        if (zzac(context)) {
            if (zzad(context)) {
                zza("endAdUnitExposure", new zzawe(str));
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    public final String zzae(Context context) {
        if (!zzac(context)) {
            return "";
        }
        if (zzad(context)) {
            return (String) zza("getCurrentScreenNameOrScreenClass", "", zzawd.zzdwt);
        }
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdwm, true)) {
            return "";
        }
        try {
            String str = (String) zzn(context, "getCurrentScreenName").invoke(this.zzdwm.get(), new Object[0]);
            if (str == null) {
                str = (String) zzn(context, "getCurrentScreenClass").invoke(this.zzdwm.get(), new Object[0]);
            }
            if (str != null) {
                return str;
            }
            return "";
        } catch (Exception e) {
            zza(e, "getCurrentScreenName", false);
            return "";
        }
    }

    public final void zzh(Context context, String str) {
        if (!zzac(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzad(context)) {
            zza("setScreenName", new zzawg(context, str));
        } else if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdwn, false)) {
            Method zzo = zzo(context, "setCurrentScreen");
            try {
                zzo.invoke(this.zzdwn.get(), (Activity) context, str, context.getPackageName());
            } catch (Exception e) {
                zza(e, "setCurrentScreen", false);
            }
        }
    }

    public final String zzaf(Context context) {
        if (!zzac(context)) {
            return null;
        }
        synchronized (this.zzdwh) {
            if (this.zzdwi != null) {
                String str = this.zzdwi;
                return str;
            }
            if (zzad(context)) {
                this.zzdwi = (String) zza("getGmpAppId", this.zzdwi, zzawf.zzdwt);
            } else {
                this.zzdwi = (String) zza("getGmpAppId", context);
            }
            String str2 = this.zzdwi;
            return str2;
        }
    }

    public final String zzag(Context context) {
        if (!zzac(context)) {
            return null;
        }
        long longValue = ((Long) zzwg.zzpw().zzd(zzaav.zzcne)).longValue();
        if (zzad(context)) {
            if (longValue >= 0) {
                return (String) zzvp().submit(new zzawh(this)).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zza("getAppInstanceId", (Object) null, zzawi.zzdwt);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) zza("getAppInstanceId", context);
        } else {
            try {
                return (String) zzvp().submit(new zzawk(this, context)).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return "TIME_OUT";
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    public final String zzah(Context context) {
        if (!zzac(context)) {
            return null;
        }
        if (zzad(context)) {
            Long l = (Long) zza("getAdEventId", (Object) null, zzawj.zzdwt);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zza = zza("generateEventId", context);
        if (zza != null) {
            return zza.toString();
        }
        return null;
    }

    public final String zzai(Context context) {
        if (!zzac(context)) {
            return null;
        }
        synchronized (this.zzdwh) {
            if (this.zzdwj != null) {
                String str = this.zzdwj;
                return str;
            }
            if (zzad(context)) {
                this.zzdwj = (String) zza("getAppIdOrigin", this.zzdwj, zzawa.zzdwt);
            } else {
                this.zzdwj = "fa";
            }
            String str2 = this.zzdwj;
            return str2;
        }
    }

    public final void zzi(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzk(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzl(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzac(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzaxv.zzeh(sb.toString());
        }
    }

    private final void zza(Context context, String str, String str2, Bundle bundle) {
        if (zzac(context)) {
            Bundle zzl = zzl(str2, str);
            if (bundle != null) {
                zzl.putAll(bundle);
            }
            if (zzad(context)) {
                zza("logEventInternal", new zzavz(str, zzl));
            } else if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdwm, true)) {
                Method zzaj = zzaj(context);
                try {
                    zzaj.invoke(this.zzdwm.get(), "am", str, zzl);
                } catch (Exception e) {
                    zza(e, "logEventInternal", true);
                }
            }
        }
    }

    private static Bundle zzl(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzaxv.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final Method zzaj(Context context) {
        Method method = this.zzdwo.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", String.class, String.class, Bundle.class);
            this.zzdwo.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, "logEventInternal", true);
            return null;
        }
    }

    private final Method zzm(Context context, String str) {
        Method method = this.zzdwo.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, String.class);
            this.zzdwo.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzn(Context context, String str) {
        Method method = this.zzdwo.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzdwo.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final Method zzo(Context context, String str) {
        Method method = this.zzdwo.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, Activity.class, String.class, String.class);
            this.zzdwo.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception e) {
            zza(e, str, false);
            return null;
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdwm, true)) {
            Method zzm = zzm(context, str2);
            try {
                zzm.invoke(this.zzdwm.get(), str);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzaxv.zzeh(sb.toString());
            } catch (Exception e) {
                zza(e, str2, false);
            }
        }
    }

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdwm, true)) {
            return null;
        }
        try {
            return zzn(context, str).invoke(this.zzdwm.get(), new Object[0]);
        } catch (Exception e) {
            zza(e, str, true);
            return null;
        }
    }

    private final void zza(Exception exc, String str, boolean z) {
        if (!this.zzdwk.get()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzaxv.zzfd(sb.toString());
            if (z) {
                zzaxv.zzfd("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zzdwk.set(true);
            }
        }
    }

    private final ThreadPoolExecutor zzvp() {
        if (this.zzdwg.get() == null) {
            this.zzdwg.compareAndSet(null, new ThreadPoolExecutor(((Integer) zzwg.zzpw().zzd(zzaav.zzcnf)).intValue(), ((Integer) zzwg.zzpw().zzd(zzaav.zzcnf)).intValue(), 1, TimeUnit.MINUTES, new LinkedBlockingQueue(), new zzawm(this)));
        }
        return this.zzdwg.get();
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet(null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", Context.class).invoke(null, context));
            } catch (Exception e) {
                zza(e, "getInstance", z);
                return false;
            }
        }
        return true;
    }

    private final void zza(String str, zzawo zzawo) {
        synchronized (this.zzdwp) {
            FutureTask<?> futureTask = new FutureTask<>(new zzawc(this, zzawo, str), null);
            if (this.zzdwp.get() != null) {
                futureTask.run();
            } else {
                this.zzdwq.offer(futureTask);
            }
        }
    }

    private final <T> T zza(String str, T t, zzawl<T> zzawl) {
        synchronized (this.zzdwp) {
            if (this.zzdwp.get() != null) {
                try {
                    T zzb = zzawl.zzb(this.zzdwp.get());
                    return zzb;
                } catch (Exception e) {
                    zza(e, str, false);
                    return t;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzawo zzawo, String str) {
        if (this.zzdwp.get() != null) {
            try {
                zzawo.zza(this.zzdwp.get());
            } catch (Exception e) {
                zza(e, str, false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzak(Context context) throws Exception {
        return (String) zza("getAppInstanceId", context);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzvq() throws Exception {
        return (String) zza("getAppInstanceId", (Object) null, zzawb.zzdwt);
    }
}
