package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbgb implements Runnable {
    private final IObjectWrapper zzemu;

    zzbgb(IObjectWrapper iObjectWrapper) {
        this.zzemu = iObjectWrapper;
    }

    public final void run() {
        zzq.zzll().zzac(this.zzemu);
    }
}
