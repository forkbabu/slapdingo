package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.rewarded.RewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzauv extends zzaum {
    private final RewardedAdCallback zzduv;

    public zzauv(RewardedAdCallback rewardedAdCallback) {
        this.zzduv = rewardedAdCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzauj
    public final void zzb(zzuy zzuy) {
    }

    @Override // com.google.android.gms.internal.ads.zzauj
    public final void onRewardedAdOpened() {
        RewardedAdCallback rewardedAdCallback = this.zzduv;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauj
    public final void onRewardedAdClosed() {
        RewardedAdCallback rewardedAdCallback = this.zzduv;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauj
    public final void zza(zzaud zzaud) {
        RewardedAdCallback rewardedAdCallback = this.zzduv;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onUserEarnedReward(new zzauw(zzaud));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzauj
    public final void onRewardedAdFailedToShow(int i) {
        RewardedAdCallback rewardedAdCallback = this.zzduv;
        if (rewardedAdCallback != null) {
            rewardedAdCallback.onRewardedAdFailedToShow(i);
        }
    }
}
