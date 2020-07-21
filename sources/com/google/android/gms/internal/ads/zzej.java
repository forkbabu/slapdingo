package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzej implements Application.ActivityLifecycleCallbacks {
    private final Application zzyg;
    private final WeakReference<Application.ActivityLifecycleCallbacks> zzyh;
    private boolean zzyi = false;

    public zzej(Application application, Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        this.zzyh = new WeakReference<>(activityLifecycleCallbacks);
        this.zzyg = application;
    }

    private final void zza(zzer zzer) {
        try {
            Application.ActivityLifecycleCallbacks activityLifecycleCallbacks = this.zzyh.get();
            if (activityLifecycleCallbacks != null) {
                zzer.zza(activityLifecycleCallbacks);
            } else if (!this.zzyi) {
                this.zzyg.unregisterActivityLifecycleCallbacks(this);
                this.zzyi = true;
            }
        } catch (Exception unused) {
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(new zzem(this, activity, bundle));
    }

    public final void onActivityStarted(Activity activity) {
        zza(new zzel(this, activity));
    }

    public final void onActivityResumed(Activity activity) {
        zza(new zzeo(this, activity));
    }

    public final void onActivityPaused(Activity activity) {
        zza(new zzen(this, activity));
    }

    public final void onActivityStopped(Activity activity) {
        zza(new zzeq(this, activity));
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zza(new zzep(this, activity, bundle));
    }

    public final void onActivityDestroyed(Activity activity) {
        zza(new zzes(this, activity));
    }
}
