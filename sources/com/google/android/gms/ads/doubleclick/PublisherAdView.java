package com.google.android.gms.ads.doubleclick;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.Correlator;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzww;
import com.google.android.gms.internal.ads.zzys;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class PublisherAdView extends ViewGroup {
    private final zzys zzadt;

    public PublisherAdView(Context context) {
        super(context);
        this.zzadt = new zzys(this);
    }

    @Deprecated
    public final void setCorrelator(Correlator correlator) {
    }

    public PublisherAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzadt = new zzys(this, attributeSet, true);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public PublisherAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzadt = new zzys(this, attributeSet, true);
    }

    public final VideoController getVideoController() {
        return this.zzadt.getVideoController();
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzadt.setVideoOptions(videoOptions);
    }

    public final VideoOptions getVideoOptions() {
        return this.zzadt.getVideoOptions();
    }

    public final void destroy() {
        this.zzadt.destroy();
    }

    public final AdListener getAdListener() {
        return this.zzadt.getAdListener();
    }

    public final AdSize getAdSize() {
        return this.zzadt.getAdSize();
    }

    public final AdSize[] getAdSizes() {
        return this.zzadt.getAdSizes();
    }

    public final String getAdUnitId() {
        return this.zzadt.getAdUnitId();
    }

    public final AppEventListener getAppEventListener() {
        return this.zzadt.getAppEventListener();
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzadt.getOnCustomRenderedAdLoadedListener();
    }

    public final void loadAd(PublisherAdRequest publisherAdRequest) {
        this.zzadt.zza(publisherAdRequest.zzdq());
    }

    public final void pause() {
        this.zzadt.pause();
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzadt.setManualImpressionsEnabled(z);
    }

    public final void recordManualImpression() {
        this.zzadt.recordManualImpression();
    }

    public final void resume() {
        this.zzadt.resume();
    }

    public final void setAdListener(AdListener adListener) {
        this.zzadt.setAdListener(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (adSizeArr == null || adSizeArr.length <= 0) {
            throw new IllegalArgumentException("The supported ad sizes must contain at least one valid ad size.");
        }
        this.zzadt.zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        this.zzadt.setAdUnitId(str);
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        this.zzadt.setAppEventListener(appEventListener);
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzadt.setOnCustomRenderedAdLoadedListener(onCustomRenderedAdLoadedListener);
    }

    @Deprecated
    public final String getMediationAdapterClassName() {
        return this.zzadt.getMediationAdapterClassName();
    }

    public final boolean isLoading() {
        return this.zzadt.isLoading();
    }

    public final ResponseInfo getResponseInfo() {
        return this.zzadt.getResponseInfo();
    }

    public final boolean zza(zzww zzww) {
        return this.zzadt.zza(zzww);
    }

    /* access modifiers changed from: protected */
    public final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt != null && childAt.getVisibility() != 8) {
            int measuredWidth = childAt.getMeasuredWidth();
            int measuredHeight = childAt.getMeasuredHeight();
            int i5 = ((i3 - i) - measuredWidth) / 2;
            int i6 = ((i4 - i2) - measuredHeight) / 2;
            childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
        }
    }

    /* access modifiers changed from: protected */
    public final void onMeasure(int i, int i2) {
        int i3;
        int i4 = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e) {
                zzbba.zzc("Unable to retrieve ad size.", e);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                i3 = adSize.getHeightInPixels(context);
                i4 = widthInPixels;
            } else {
                i3 = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            i4 = childAt.getMeasuredWidth();
            i3 = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(i4, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(i3, getSuggestedMinimumHeight()), i2));
    }
}
