package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzn;
import com.google.android.gms.ads.internal.zzq;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzapp implements Runnable {
    private final /* synthetic */ zzapn zzdlk;
    private final /* synthetic */ AdOverlayInfoParcel zzdls;

    zzapp(zzapn zzapn, AdOverlayInfoParcel adOverlayInfoParcel) {
        this.zzdlk = zzapn;
        this.zzdls = adOverlayInfoParcel;
    }

    public final void run() {
        zzq.zzkv();
        zzn.zza(this.zzdlk.zzdll, this.zzdls, true);
    }
}
