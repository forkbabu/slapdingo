package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzqv implements Application.ActivityLifecycleCallbacks {
    private final Application zzyg;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzyh;
    private boolean zzyi = false;

    public zzqv(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzyh = new WeakReference<>(activityLifecycleCallbacks);
        this.zzyg = application;
    }

    private final void zza(zzrd zzrd) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzyh.get();
            if (activityLifecycleCallbacks != null) {
                zzrd.zza(activityLifecycleCallbacks);
            } else if (!this.zzyi) {
                this.zzyg.unregisterActivityLifecycleCallbacks(this);
                this.zzyi = true;
            }
        } catch (Exception e) {
            zzaxv.zzc("Error while dispatching lifecycle callback.", e);
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzqu(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzqx(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzqw(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzqz(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzqy(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzrb(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzra(this, activity));
    }
}
