package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzea implements Runnable {
    private final /* synthetic */ Context zzxo;

    zzea(zzdy zzdy, Context context) {
        this.zzxo = context;
    }

    public final void run() {
        try {
            zzdy.zzxd.zzb(this.zzxo);
        } catch (Exception e) {
            zzdy.zzxf.zza(2019, -1, e);
        }
    }
}
