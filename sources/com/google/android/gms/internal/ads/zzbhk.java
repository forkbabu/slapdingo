package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbhk implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzavr zzelz;
    private final /* synthetic */ zzbhf zzepb;

    zzbhk(zzbhf zzbhf, zzavr zzavr) {
        this.zzepb = zzbhf;
        this.zzelz = zzavr;
    }

    public final void onViewDetachedFromWindow(View view) {
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzepb.zza(view, this.zzelz, 10);
    }
}
