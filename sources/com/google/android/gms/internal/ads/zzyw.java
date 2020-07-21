package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzyw implements Runnable {
    private final zzyt zzcjx;
    private final Context zzcjz;

    zzyw(zzyt zzyt, Context context) {
        this.zzcjx = zzyt;
        this.zzcjz = context;
    }

    public final void run() {
        this.zzcjx.getRewardedVideoAdInstance(this.zzcjz);
    }
}
