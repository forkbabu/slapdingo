package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzuu;
import com.google.android.gms.internal.ads.zzys;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
class BaseAdView extends ViewGroup {
    protected final zzys zzadc;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzadc = new zzys(this, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzadc = new zzys(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzadc = new zzys(this, attributeSet, false, i2);
    }

    public void destroy() {
        this.zzadc.destroy();
    }

    public AdListener getAdListener() {
        return this.zzadc.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzadc.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzadc.getAdUnitId();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzadc.zza(adRequest.zzdq());
    }

    public void pause() {
        this.zzadc.pause();
    }

    public void resume() {
        this.zzadc.resume();
    }

    public boolean isLoading() {
        return this.zzadc.isLoading();
    }

    public void setAdListener(AdListener adListener) {
        this.zzadc.setAdListener(adListener);
        if (adListener == null) {
            this.zzadc.zza((zzuu) null);
            this.zzadc.setAppEventListener(null);
            return;
        }
        if (adListener instanceof zzuu) {
            this.zzadc.zza((zzuu) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzadc.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzadc.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzadc.setAdUnitId(str);
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        return this.zzadc.getMediationAdapterClassName();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    public void onMeasure(int i, int i2) {
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

    public ResponseInfo getResponseInfo() {
        return this.zzadc.getResponseInfo();
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzadc.setOnPaidEventListener(onPaidEventListener);
    }
}
