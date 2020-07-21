package com.google.android.gms.internal.ads;

import android.os.Looper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzbcx implements Runnable {
    zzbcx(zzbcy zzbcy) {
    }

    public final void run() {
        Looper.myLooper().quit();
    }
}
