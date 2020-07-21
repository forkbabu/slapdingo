package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.instream.InstreamAd;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzajd extends zzaiz {
    private final InstreamAd.InstreamAdLoadCallback zzdfa;

    public zzajd(InstreamAd.InstreamAdLoadCallback instreamAdLoadCallback) {
        this.zzdfa = instreamAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzaiw
    public final void zza(zzaiq zzaiq) {
        this.zzdfa.onInstreamAdLoaded(new zzajb(zzaiq));
    }

    @Override // com.google.android.gms.internal.ads.zzaiw
    public final void onInstreamAdFailedToLoad(int i) {
        this.zzdfa.onInstreamAdFailedToLoad(i);
    }
}
