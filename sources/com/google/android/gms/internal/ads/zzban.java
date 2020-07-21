package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzban {
    private final View view;
    private boolean zzbrm;
    private boolean zzbvq;
    private Activity zzeci;
    private boolean zzecj;
    private ViewTreeObserver.OnGlobalLayoutListener zzeck;
    private ViewTreeObserver.OnScrollChangedListener zzecl = null;

    public zzban(Activity activity, View view2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzeci = activity;
        this.view = view2;
        this.zzeck = onGlobalLayoutListener;
    }

    public final void zzh(Activity activity) {
        this.zzeci = activity;
    }

    public final void zzyd() {
        this.zzbvq = true;
        if (this.zzbrm) {
            zzyf();
        }
    }

    public final void zzye() {
        this.zzbvq = false;
        zzyg();
    }

    public final void onAttachedToWindow() {
        this.zzbrm = true;
        if (this.zzbvq) {
            zzyf();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbrm = false;
        zzyg();
    }

    private final void zzyf() {
        ViewTreeObserver zzi;
        if (!this.zzecj) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzeck;
            if (onGlobalLayoutListener != null) {
                Activity activity = this.zzeci;
                if (!(activity == null || (zzi = zzi(activity)) == null)) {
                    zzi.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
                zzq.zzlt();
                zzbbv.zza(this.view, this.zzeck);
            }
            this.zzecj = true;
        }
    }

    private final void zzyg() {
        ViewTreeObserver zzi;
        Activity activity = this.zzeci;
        if (activity != null && this.zzecj) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzeck;
            if (!(onGlobalLayoutListener == null || (zzi = zzi(activity)) == null)) {
                zzq.zzky();
                zzi.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.zzecj = false;
        }
    }

    private static ViewTreeObserver zzi(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }
}
