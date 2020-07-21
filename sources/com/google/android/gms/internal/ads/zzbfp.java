package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbfp implements Runnable {
    private final zzbfq zzeli;

    zzbfp(zzbfq zzbfq) {
        this.zzeli = zzbfq;
    }

    public final void run() {
        zzbfq zzbfq = this.zzeli;
        zzbfq.zzelj.zzabi();
        zzc zzaav = zzbfq.zzelj.zzaav();
        if (zzaav != null) {
            zzaav.zzum();
        }
    }
}
