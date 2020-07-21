package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzec implements Runnable {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Context zzxo;
    private final /* synthetic */ View zzxp;
    private final /* synthetic */ String zzxs;

    zzec(zzdy zzdy, Context context, String str, View view, Activity activity) {
        this.zzxo = context;
        this.zzxs = str;
        this.zzxp = view;
        this.val$activity = activity;
    }

    public final void run() {
        try {
            zzdy.zzxd.zza(this.zzxo, this.zzxs, this.zzxp, this.val$activity);
        } catch (Exception e) {
            zzdy.zzxf.zza(2021, -1, e);
        }
    }
}
