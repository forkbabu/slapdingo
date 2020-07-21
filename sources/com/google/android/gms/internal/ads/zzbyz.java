package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.VideoController;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbyz extends zzbwv<VideoController.VideoLifecycleCallbacks> {
    private boolean zzeom;

    protected zzbyz(Set<zzbyg<VideoController.VideoLifecycleCallbacks>> set) {
        super(set);
    }

    public final void onVideoPause() {
        zza(zzbyy.zzfrq);
    }

    public final void onVideoEnd() {
        zza(zzbzb.zzfrq);
    }

    public final synchronized void onVideoStart() {
        zza(zzbza.zzfrq);
        this.zzeom = true;
    }

    public final synchronized void onVideoPlay() {
        if (!this.zzeom) {
            zza(zzbzd.zzfrq);
            this.zzeom = true;
        }
        zza(zzbzc.zzfrq);
    }
}
