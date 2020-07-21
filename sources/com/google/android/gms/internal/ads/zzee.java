package com.google.android.gms.internal.ads;

import android.view.MotionEvent;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzee implements Runnable {
    private final /* synthetic */ int zzxt;
    private final /* synthetic */ int zzxu;
    private final /* synthetic */ int zzxv;

    zzee(zzdy zzdy, int i, int i2, int i3) {
        this.zzxt = i;
        this.zzxu = i2;
        this.zzxv = i3;
    }

    public final void run() {
        try {
            zzdy.zzxd.zza(MotionEvent.obtain(0, (long) this.zzxt, 0, (float) this.zzxu, (float) this.zzxv, 0));
        } catch (Exception e) {
            zzdy.zzxf.zza(2022, -1, e);
        }
    }
}
