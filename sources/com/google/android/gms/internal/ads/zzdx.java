package com.google.android.gms.internal.ads;

import org.opencv.features2d.FeatureDetector;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdx implements Runnable {
    zzdx() {
    }

    public final void run() {
        try {
            zzdy.zzxd.zzbr();
            zzdy.zzxd.zzbs();
        } catch (Exception e) {
            zzdy.zzxf.zza(FeatureDetector.PYRAMID_FAST, -1, e);
        }
    }
}
