package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdz implements Runnable {
    private final /* synthetic */ Context zzxo;
    private final /* synthetic */ View zzxp;
    private final /* synthetic */ Activity zzxq;

    zzdz(zzdy zzdy, Context context, View view, Activity activity) {
        this.zzxo = context;
        this.zzxp = view;
        this.zzxq = activity;
    }

    public final void run() {
        try {
            zzdy.zzxd.zza(this.zzxo, this.zzxp, this.zzxq);
        } catch (Exception e) {
            zzdy.zzxf.zza(2020, -1, e);
        }
    }
}
