package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzt;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzcgy implements zzt {
    private final zzbtl zzgbw;

    private zzcgy(zzbtl zzbtl) {
        this.zzgbw = zzbtl;
    }

    static zzt zza(zzbtl zzbtl) {
        return new zzcgy(zzbtl);
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzt
    public final void zzuu() {
        this.zzgbw.onAdLeftApplication();
    }
}
