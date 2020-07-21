package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzyu;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class PublisherInterstitialAd {
    private final zzyu zzadd;

    public PublisherInterstitialAd(Context context) {
        this.zzadd = new zzyu(context, this);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public final AdListener getAdListener() {
        return this.zzadd.getAdListener();
    }

    public final String getAdUnitId() {
        return this.zzadd.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzadd.getAppEventListener();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzadd.getOnCustomRenderedAdLoadedListener();
    }

    public final boolean isLoaded() {
        return this.zzadd.isLoaded();
    }

    public final boolean isLoading() {
        return this.zzadd.isLoading();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzadd.zza(publisherAdRequest.zzdq());
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadd.setAdListener(adListener);
    }

    public final void setAdUnitId(String str) {
        this.zzadd.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzadd.setAppEventListener(appEventListener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzadd.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadd.getMediationAdapterClassName();
    }

    public final void show() {
        this.zzadd.show();
    }

    public final void setImmersiveMode(boolean z) {
        this.zzadd.setImmersiveMode(z);
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzadd.getResponseInfo();
    }
}
