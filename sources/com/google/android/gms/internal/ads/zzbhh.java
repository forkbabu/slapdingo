package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbhh implements Runnable {
    private final /* synthetic */ View val$view;
    private final /* synthetic */ zzavr zzelz;
    private final /* synthetic */ int zzema;
    private final /* synthetic */ zzbhf zzepb;

    zzbhh(zzbhf zzbhf, View view, zzavr zzavr, int i) {
        this.zzepb = zzbhf;
        this.val$view = view;
        this.zzelz = zzavr;
        this.zzema = i;
    }

    public final void run() {
        this.zzepb.zza(this.val$view, this.zzelz, this.zzema - 1);
    }
}
