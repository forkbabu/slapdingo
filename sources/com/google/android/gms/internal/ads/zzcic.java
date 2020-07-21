package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcic implements View.OnTouchListener {
    private final zzchy zzgcq;

    zzcic(zzchy zzchy) {
        this.zzgcq = zzchy;
    }

    public final boolean onTouch(View view, MotionEvent motionEvent) {
        return this.zzgcq.zza(view, motionEvent);
    }
}
