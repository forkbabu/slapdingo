package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzaxz implements Runnable {
    private final Context zzcjz;
    private final String zzdia;
    private final zzaya zzdyy;

    zzaxz(zzaya zzaya, Context context, String str) {
        this.zzdyy = zzaya;
        this.zzcjz = context;
        this.zzdia = str;
    }

    public final void run() {
        this.zzdyy.zzq(this.zzcjz, this.zzdia);
    }
}
