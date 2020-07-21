package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzyv implements Runnable {
    private final zzyt zzcjx;
    private final OnInitializationCompleteListener zzcjy;

    zzyv(zzyt zzyt, OnInitializationCompleteListener onInitializationCompleteListener) {
        this.zzcjx = zzyt;
        this.zzcjy = onInitializationCompleteListener;
    }

    public final void run() {
        this.zzcjx.zza(this.zzcjy);
    }
}
