package com.google.android.gms.internal.ads;

import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbut implements Runnable {
    private final WeakReference<zzbus> zzfsa;

    private zzbut(zzbus zzbus) {
        this.zzfsa = new WeakReference<>(zzbus);
    }

    public final void run() {
        zzbus zzbus = this.zzfsa.get();
        if (zzbus != null) {
            zzbus.zzaje();
        }
    }
}
