package com.google.android.gms.ads;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzuu;
import com.google.android.gms.internal.ads.zzyu;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class InterstitialAd {
    private final zzyu zzadd;

    public InterstitialAd(Context context) {
        this.zzadd = new zzyu(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final AdListener getAdListener() {
        return this.zzadd.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzadd.getAdUnitId();
    }

    public final boolean isLoaded() {
        return this.zzadd.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzadd.isLoading();
    }

    public final void loadAd(AdRequest adRequest) {
        this.zzadd.zza(adRequest.zzdq());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadd.setAdListener(adListener);
        if (adListener != null && (adListener instanceof zzuu)) {
            this.zzadd.zza((zzuu) adListener);
        } else if (adListener == null) {
            this.zzadd.zza((zzuu) null);
        }
    }

    public final void setAdUnitId(String str) {
        this.zzadd.setAdUnitId(str);
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadd.getMediationAdapterClassName();
    }

    public final void show() {
        this.zzadd.show();
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        this.zzadd.setRewardedVideoAdListener(rewardedVideoAdListener);
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        this.zzadd.setAdMetadataListener(adMetadataListener);
    }

    public final Bundle getAdMetadata() {
        return this.zzadd.getAdMetadata();
    }

    public final void zzd(boolean z) {
        this.zzadd.zzd(true);
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadd.setImmersiveMode(z);
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzadd.getResponseInfo();
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzadd.setOnPaidEventListener(onPaidEventListener);
    }
}
