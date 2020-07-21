package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbfr implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzavr zzelz;
    private final /* synthetic */ int zzema;
    private final /* synthetic */ zzbfq zzemb;

    zzbfr(zzbfq zzbfq, View view, zzavr zzavr, int i) {
        this.zzemb = zzbfq;
        this.val$view = view;
        this.zzelz = zzavr;
        this.zzema = i;
    }

    public final void run() {
        this.zzemb.zza(this.val$view, this.zzelz, this.zzema - 1);
    }
}
