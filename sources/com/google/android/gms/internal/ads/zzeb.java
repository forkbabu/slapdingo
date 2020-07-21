package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzeb implements Runnable {
    private final /* synthetic */ MotionEvent zzxr;

    zzeb(zzdy zzdy, MotionEvent motionEvent) {
        this.zzxr = motionEvent;
    }

    public final void run() {
        try {
            zzdy.zzxd.zza(this.zzxr);
        } catch (Exception e) {
            zzdy.zzxf.zza(2022, -1, e);
        }
    }
}
