package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzrl implements Runnable {
    private final /* synthetic */ zzri zzbtm;
    private final /* synthetic */ View zzbtn;

    zzrl(zzri zzri, View view) {
        this.zzbtm = zzri;
        this.zzbtn = view;
    }

    public final void run() {
        this.zzbtm.zzj(this.zzbtn);
    }
}
