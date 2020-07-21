package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzc;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbhi implements Runnable {
    private final zzbhf zzepc;

    zzbhi(zzbhf zzbhf) {
        this.zzepc = zzbhf;
    }

    public final void run() {
        zzbhf zzbhf = this.zzepc;
        zzbhf.zzelj.zzabi();
        zzc zzaav = zzbhf.zzelj.zzaav();
        if (zzaav != null) {
            zzaav.zzum();
        }
    }
}
