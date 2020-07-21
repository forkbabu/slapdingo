package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzamj {
    private static zzamj zzdib;
    private AtomicBoolean zzdic = new AtomicBoolean(false);

    public static zzamj zzti() {
        if (zzdib == null) {
            zzdib = new zzamj();
        }
        return zzdib;
    }

    zzamj() {
    }

    public final Thread zzd(Context context, String str) {
        if (!this.zzdic.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzami(this, context, str));
        thread.start();
        return thread;
    }

    public final Thread zzm(Context context) {
        if (!this.zzdic.compareAndSet(false, true)) {
            return null;
        }
        Thread thread = new Thread(new zzaml(this, context));
        thread.start();
        return thread;
    }

    private static void zza(Context context, AppMeasurementSdk appMeasurementSdk) {
        try {
            ((zzbia) zzbaz.zza(context, "com.google.android.gms.ads.measurement.DynamiteMeasurementManager", zzamk.zzbxr)).zza(ObjectWrapper.wrap(context), new zzamg(appMeasurementSdk));
        } catch (RemoteException | zzbbb | NullPointerException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    private static boolean zzn(Context context) {
        try {
            context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    static /* synthetic */ void zzo(Context context) {
        zzaav.initialize(context);
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcnl)).booleanValue() && zzn(context)) {
            zza(context, AppMeasurementSdk.getInstance(context));
        }
    }

    static /* synthetic */ void zze(Context context, String str) {
        zzaav.initialize(context);
        Bundle bundle = new Bundle();
        bundle.putBoolean("measurementEnabled", ((Boolean) zzwg.zzpw().zzd(zzaav.zzcng)).booleanValue());
        zza(context, AppMeasurementSdk.getInstance(context, "FA-Ads", "am", str, bundle));
    }
}
