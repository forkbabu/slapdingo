package com.google.android.gms.internal.ads;

import android.graphics.Bitmap;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzavh implements Runnable {
    private final zzavi zzdvd;
    private final Bitmap zzdve;

    zzavh(zzavi zzavi, Bitmap bitmap) {
        this.zzdvd = zzavi;
        this.zzdve = bitmap;
    }

    public final void run() {
        this.zzdvd.zza(this.zzdve);
    }
}
