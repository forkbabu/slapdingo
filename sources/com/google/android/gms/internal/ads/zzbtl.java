package com.google.android.gms.internal.ads;

import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbtl extends zzbwv<zzbsl> {
    public zzbtl(Set<zzbyg<zzbsl>> set) {
        super(set);
    }

    public final void onAdClosed() {
        zza(zzbto.zzfrq);
    }

    public final void onAdLeftApplication() {
        zza(zzbtn.zzfrq);
    }

    public final void onAdOpened() {
        zza(zzbtq.zzfrq);
    }

    public final void onRewardedVideoStarted() {
        zza(zzbtp.zzfrq);
    }

    public final void zzb(zzatg zzatg, String str, String str2) {
        zza(new zzbts(zzatg, str, str2));
    }

    public final void onRewardedVideoCompleted() {
        zza(zzbtr.zzfrq);
    }
}
