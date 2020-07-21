package com.google.android.gms.internal.ads;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import androidx.exifinterface.media.ExifInterface;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzced implements ViewTreeObserver.OnScrollChangedListener {
    private final String zzdia;
    private final View zzfzo;
    private final zzbfn zzfzp;
    private final WindowManager.LayoutParams zzfzq;
    private final int zzfzr;
    private final WindowManager zzfzs;

    zzced(View view, zzbfn zzbfn, String str, WindowManager.LayoutParams layoutParams, int i, WindowManager windowManager) {
        this.zzfzo = view;
        this.zzfzp = zzbfn;
        this.zzdia = str;
        this.zzfzq = layoutParams;
        this.zzfzr = i;
        this.zzfzs = windowManager;
    }

    public final void onScrollChanged() {
        View view = this.zzfzo;
        zzbfn zzbfn = this.zzfzp;
        String str = this.zzdia;
        WindowManager.LayoutParams layoutParams = this.zzfzq;
        int i = this.zzfzr;
        WindowManager windowManager = this.zzfzs;
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect) && zzbfn.getView().getWindowToken() != null) {
            if ("1".equals(str) || ExifInterface.GPS_MEASUREMENT_2D.equals(str)) {
                layoutParams.y = rect.bottom - i;
            } else {
                layoutParams.y = rect.top - i;
            }
            windowManager.updateViewLayout(zzbfn.getView(), layoutParams);
        }
    }
}
