package com.google.android.gms.ads.rewarded;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaut;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class RewardedAd {
    private final zzaut zzhhh;

    public RewardedAd(Context context, String str) {
        Preconditions.checkNotNull(context, "context cannot be null");
        Preconditions.checkNotNull(str, "adUnitID cannot be null");
        this.zzhhh = new zzaut(context, str);
    }

    public final void loadAd(AdRequest adRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzhhh.zza(adRequest.zzdq(), rewardedAdLoadCallback);
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest, RewardedAdLoadCallback rewardedAdLoadCallback) {
        this.zzhhh.zza(publisherAdRequest.zzdq(), rewardedAdLoadCallback);
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzhhh.getMediationAdapterClassName();
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        this.zzhhh.setServerSideVerificationOptions(serverSideVerificationOptions);
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzhhh.setOnAdMetadataChangedListener(onAdMetadataChangedListener);
    }

    public final Bundle getAdMetadata() {
        return this.zzhhh.getAdMetadata();
    }

    public final boolean isLoaded() {
        return this.zzhhh.isLoaded();
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        this.zzhhh.show(activity, rewardedAdCallback);
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        this.zzhhh.show(activity, rewardedAdCallback, z);
    }

    public final RewardItem getRewardItem() {
        return this.zzhhh.getRewardItem();
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzhhh.getResponseInfo();
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzhhh.setOnPaidEventListener(onPaidEventListener);
    }
}
