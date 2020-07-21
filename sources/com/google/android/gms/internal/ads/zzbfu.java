package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbfu implements View.OnAttachStateChangeListener {
    private final /* synthetic */ zzavr zzelz;
    private final /* synthetic */ zzbfq zzemb;

    zzbfu(zzbfq zzbfq, zzavr zzavr) {
        this.zzemb = zzbfq;
        this.zzelz = zzavr;
    }

    public final void onViewDetachedFromWindow(View view) {
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzemb.zza(view, this.zzelz, 10);
    }
}
