package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.zzq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzrh implements Application.ActivityLifecycleCallbacks {
    /* access modifiers changed from: private */
    public boolean foreground = true;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    private Activity zzaar;
    /* access modifiers changed from: private */
    public boolean zzbsr = false;
    /* access modifiers changed from: private */
    public final List<zzrj> zzbss = new ArrayList();
    private final List<zzru> zzbst = new ArrayList();
    private Runnable zzbsu;
    private long zzbsv;
    private Context zzvr;
    private boolean zzzg = false;

    zzrh() {
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    public final void onActivityStopped(Activity activity) {
    }

    public final void zza(Application application, Context context) {
        if (!this.zzzg) {
            application.registerActivityLifecycleCallbacks(this);
            if (context instanceof Activity) {
                setActivity((Activity) context);
            }
            this.zzvr = application;
            this.zzbsv = ((Long) zzwg.zzpw().zzd(zzaav.zzcoc)).longValue();
            this.zzzg = true;
        }
    }

    public final void zza(zzrj zzrj) {
        synchronized (this.lock) {
            this.zzbss.add(zzrj);
        }
    }

    public final void zzb(zzrj zzrj) {
        synchronized (this.lock) {
            this.zzbss.remove(zzrj);
        }
    }

    public final Activity getActivity() {
        return this.zzaar;
    }

    public final Context getContext() {
        return this.zzvr;
    }

    public final void onActivityStarted(Activity activity) {
        setActivity(activity);
    }

    public final void onActivityResumed(Activity activity) {
        setActivity(activity);
        this.zzbsr = false;
        boolean z = !this.foreground;
        this.foreground = true;
        if (this.zzbsu != null) {
            zzaye.zzdzw.removeCallbacks(this.zzbsu);
        }
        synchronized (this.lock) {
            for (zzru zzru : this.zzbst) {
                try {
                    zzru.onActivityResumed(activity);
                } catch (Exception e) {
                    zzq.zzla().zza(e, "AppActivityTracker.ActivityListener.onActivityResumed");
                    zzbba.zzc("", e);
                }
            }
            if (z) {
                for (zzrj zzrj : this.zzbss) {
                    try {
                        zzrj.zzp(true);
                    } catch (Exception e2) {
                        zzbba.zzc("", e2);
                    }
                }
            } else {
                zzaxv.zzee("App is still foreground.");
            }
        }
    }

    public final void onActivityPaused(Activity activity) {
        setActivity(activity);
        synchronized (this.lock) {
            for (zzru zzru : this.zzbst) {
                try {
                    zzru.onActivityPaused(activity);
                } catch (Exception e) {
                    zzq.zzla().zza(e, "AppActivityTracker.ActivityListener.onActivityPaused");
                    zzbba.zzc("", e);
                }
            }
        }
        this.zzbsr = true;
        if (this.zzbsu != null) {
            zzaye.zzdzw.removeCallbacks(this.zzbsu);
        }
        zzdrr zzdrr = zzaye.zzdzw;
        zzrg zzrg = new zzrg(this);
        this.zzbsu = zzrg;
        zzdrr.postDelayed(zzrg, this.zzbsv);
    }

    public final void onActivityDestroyed(Activity activity) {
        synchronized (this.lock) {
            if (this.zzaar != null) {
                if (this.zzaar.equals(activity)) {
                    this.zzaar = null;
                }
                Iterator<zzru> it2 = this.zzbst.iterator();
                while (it2.hasNext()) {
                    try {
                        if (it2.next().zza(activity)) {
                            it2.remove();
                        }
                    } catch (Exception e) {
                        zzq.zzla().zza(e, "AppActivityTracker.ActivityListener.onActivityDestroyed");
                        zzbba.zzc("", e);
                    }
                }
            }
        }
    }

    private final void setActivity(Activity activity) {
        synchronized (this.lock) {
            if (!activity.getClass().getName().startsWith("com.google.android.gms.ads")) {
                this.zzaar = activity;
            }
        }
    }
}
