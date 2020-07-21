package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewardedinterstitial.RewardedInterstitialAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzavg extends zzaup {
    private final RewardedInterstitialAdLoadCallback zzdvb;
    private final zzavf zzdvc;

    public zzavg(RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback, zzavf zzavf) {
        this.zzdvb = rewardedInterstitialAdLoadCallback;
        this.zzdvc = zzavf;
    }

    @Override // com.google.android.gms.internal.ads.zzauq
    public final void onRewardedAdLoaded() {
        zzavf zzavf;
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdvb;
        if (rewardedInterstitialAdLoadCallback != null && (zzavf = this.zzdvc) != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdLoaded(zzavf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauq
    public final void onRewardedAdFailedToLoad(int i) {
        RewardedInterstitialAdLoadCallback rewardedInterstitialAdLoadCallback = this.zzdvb;
        if (rewardedInterstitialAdLoadCallback != null) {
            rewardedInterstitialAdLoadCallback.onRewardedInterstitialAdFailedToLoad(i);
        }
    }
}
