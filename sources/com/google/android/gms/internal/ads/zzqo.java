package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.zzq;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzqo implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbqx = ((Long) zzwg.zzpw().zzd(zzaav.zzcpi)).longValue();
    private final Context zzaah;
    private final PowerManager zzaai;
    private final KeyguardManager zzaaj;
    private WeakReference<ViewTreeObserver> zzaal;
    private int zzaap = -1;
    private final WindowManager zzbqy;
    private BroadcastReceiver zzbqz;
    private WeakReference<View> zzbra;
    private zzqv zzbrb;
    private zzbag zzbrc = new zzbag(zzbqx);
    private boolean zzbrd = false;
    private final HashSet<zzqs> zzbre = new HashSet<>();
    private final Rect zzbrf;
    private final DisplayMetrics zzxc;
    private Application zzyg;

    public zzqo(Context context, View view) {
        this.zzaah = context.getApplicationContext();
        this.zzbqy = (WindowManager) context.getSystemService("window");
        this.zzaai = (PowerManager) this.zzaah.getSystemService("power");
        this.zzaaj = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzaah;
        if (context2 instanceof Application) {
            this.zzyg = (Application) context2;
            this.zzbrb = new zzqv((Application) context2, this);
        }
        this.zzxc = context.getResources().getDisplayMetrics();
        Rect rect = new Rect();
        this.zzbrf = rect;
        rect.right = this.zzbqy.getDefaultDisplay().getWidth();
        this.zzbrf.bottom = this.zzbqy.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbra;
        View view2 = weakReference != null ? weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzg(view2);
        }
        this.zzbra = new WeakReference<>(view);
        if (view != null) {
            if (zzq.zzky().isAttachedToWindow(view)) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    public final void zza(zzqs zzqs) {
        this.zzbre.add(zzqs);
        zzbt(3);
    }

    public final void zzb(zzqs zzqs) {
        this.zzbre.remove(zzqs);
    }

    private final void zzcu() {
        zzaye.zzdzw.post(new zzqr(this));
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzaap = -1;
        zzf(view);
        zzbt(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzaap = -1;
        zzbt(3);
        zzcu();
        zzg(view);
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzbra != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = this.zzbra.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzaap = i;
            }
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbt(3);
        zzcu();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbt(3);
        zzcu();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbt(3);
        zzcu();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbt(3);
        zzcu();
    }

    public final void onActivityStopped(Activity activity) {
        zzbt(3);
        zzcu();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbt(3);
        zzcu();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzbt(3);
        zzcu();
    }

    public final void onGlobalLayout() {
        zzbt(2);
        zzcu();
    }

    public final void onScrollChanged() {
        zzbt(1);
    }

    /* access modifiers changed from: private */
    public final void zzbt(int i) {
        WeakReference<View> weakReference;
        boolean z;
        boolean z2;
        List<Rect> list;
        if (this.zzbre.size() != 0 && (weakReference = this.zzbra) != null) {
            View view = weakReference.get();
            boolean z3 = i == 1;
            boolean z4 = view == null;
            Rect rect = new Rect();
            Rect rect2 = new Rect();
            Rect rect3 = new Rect();
            Rect rect4 = new Rect();
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            if (view != null) {
                boolean globalVisibleRect = view.getGlobalVisibleRect(rect2);
                boolean localVisibleRect = view.getLocalVisibleRect(rect3);
                view.getHitRect(rect4);
                try {
                    view.getLocationOnScreen(iArr);
                    view.getLocationInWindow(iArr2);
                } catch (Exception e) {
                    zzaxv.zzc("Failure getting view location.", e);
                }
                rect.left = iArr[0];
                rect.top = iArr[1];
                rect.right = rect.left + view.getWidth();
                rect.bottom = rect.top + view.getHeight();
                z2 = globalVisibleRect;
                z = localVisibleRect;
            } else {
                z2 = false;
                z = false;
            }
            if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcpl)).booleanValue() || view == null) {
                list = Collections.emptyList();
            } else {
                list = zzi(view);
            }
            int windowVisibility = view != null ? view.getWindowVisibility() : 8;
            int i2 = this.zzaap;
            if (i2 != -1) {
                windowVisibility = i2;
            }
            boolean z5 = !z4 && zzq.zzkw().zza(view, this.zzaai, this.zzaaj) && z2 && z && windowVisibility == 0;
            if (z3 && !this.zzbrc.tryAcquire() && z5 == this.zzbrd) {
                return;
            }
            if (z5 || this.zzbrd || i != 1) {
                zzqt zzqt = new zzqt(zzq.zzld().elapsedRealtime(), this.zzaai.isScreenOn(), view != null && zzq.zzky().isAttachedToWindow(view), view != null ? view.getWindowVisibility() : 8, zza(this.zzbrf), zza(rect), zza(rect2), z2, zza(rect3), z, zza(rect4), this.zzxc.density, z5, list);
                Iterator<zzqs> it2 = this.zzbre.iterator();
                while (it2.hasNext()) {
                    it2.next().zza(zzqt);
                }
                this.zzbrd = z5;
            }
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbu(rect.left), zzbu(rect.top), zzbu(rect.right), zzbu(rect.bottom));
    }

    private final int zzbu(int i) {
        return (int) (((float) i) / this.zzxc.density);
    }

    private final List<Rect> zzi(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzq.zzla().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaal = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbqz == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbqz = new zzqq(this);
            zzq.zzlr().zza(this.zzaah, this.zzbqz, intentFilter);
        }
        Application application = this.zzyg;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbrb);
            } catch (Exception e) {
                zzaxv.zzc("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzg(View view) {
        try {
            if (this.zzaal != null) {
                ViewTreeObserver viewTreeObserver = this.zzaal.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzaal = null;
            }
        } catch (Exception e) {
            zzaxv.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzaxv.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzbqz != null) {
            try {
                zzq.zzlr().zza(this.zzaah, this.zzbqz);
            } catch (IllegalStateException e3) {
                zzaxv.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzq.zzla().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbqz = null;
        }
        Application application = this.zzyg;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbrb);
            } catch (Exception e5) {
                zzaxv.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    public final void zzen(long j) {
        this.zzbrc.zzfb(j);
    }

    public final void zzlv() {
        this.zzbrc.zzfb(zzbqx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzlw() {
        zzbt(3);
    }
}
