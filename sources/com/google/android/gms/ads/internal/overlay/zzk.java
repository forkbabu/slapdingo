package com.google.android.gms.ads.internal.overlay;

import android.graphics.drawable.Drawable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzk implements Runnable {
    private final zzl zzdoa;
    private final Drawable zzdob;

    zzk(zzl zzl, Drawable drawable) {
        this.zzdoa = zzl;
        this.zzdob = drawable;
    }

    public final void run() {
        zzl zzl = this.zzdoa;
        zzl.zzdoc.zzaar.getWindow().setBackgroundDrawable(this.zzdob);
    }
}
