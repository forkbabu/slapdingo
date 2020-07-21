package com.google.android.gms.ads.internal;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzn implements View.OnTouchListener {
    private final /* synthetic */ zzl zzbox;

    zzn(zzl zzl) {
        this.zzbox = zzl;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzbox.zzbpe == null) {
            return false;
        }
        this.zzbox.zzbpe.zza(motionEvent);
        return false;
    }
}
