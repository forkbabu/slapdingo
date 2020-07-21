package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAppInstallAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzagd extends zzaes {
    private final NativeAppInstallAd.OnAppInstallAdLoadedListener zzddb;

    public zzagd(NativeAppInstallAd.OnAppInstallAdLoadedListener onAppInstallAdLoadedListener) {
        this.zzddb = onAppInstallAdLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzaet
    public final void zza(zzaeh zzaeh) {
        this.zzddb.onAppInstallAdLoaded(new zzaei(zzaeh));
    }
}
