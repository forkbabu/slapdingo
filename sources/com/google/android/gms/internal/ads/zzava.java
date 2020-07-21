package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzava extends zzaup {
    private final RewardedAdLoadCallback zzdux;

    public zzava(RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzdux = rewardedAdLoadCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzauq
    public final void onRewardedAdLoaded() {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdux;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauq
    public final void onRewardedAdFailedToLoad(int i) {
        RewardedAdLoadCallback rewardedAdLoadCallback = this.zzdux;
        if (rewardedAdLoadCallback != null) {
            rewardedAdLoadCallback.onRewardedAdFailedToLoad(i);
        }
    }
}
