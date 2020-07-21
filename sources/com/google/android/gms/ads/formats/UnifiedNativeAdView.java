package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzado;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzwg;
import com.google.android.gms.internal.ads.zzzc;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout zzbnm;
    private final zzadx zzbnn = zzjt();

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.zzbnm = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbnm = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbnm = zzd(context);
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbnm = zzd(context);
    }

    private final void zza(String str, View view) {
        try {
            this.zzbnn.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbba.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    public final void setHeadlineView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setCallToActionView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setIconView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setBodyView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setAdvertiserView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setStoreView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbnn.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbba.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setPriceView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setImageView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setStarRatingView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
        if (mediaView != null) {
            mediaView.zza(new zze(this));
            mediaView.zza(new zzd(this));
        }
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.zzbnn.zza((IObjectWrapper) unifiedNativeAd.zzjr());
        } catch (RemoteException e) {
            zzbba.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    private final View zzbm(String str) {
        try {
            IObjectWrapper zzcr = this.zzbnn.zzcr(str);
            if (zzcr != null) {
                return (View) ObjectWrapper.unwrap(zzcr);
            }
            return null;
        } catch (RemoteException e) {
            zzbba.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }

    public final View getHeadlineView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getCallToActionView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getIconView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getBodyView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getStoreView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    public final View getPriceView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getAdvertiserView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getImageView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final View getStarRatingView() {
        return zzbm(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final MediaView getMediaView() {
        View zzbm = zzbm(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (zzbm instanceof MediaView) {
            return (MediaView) zzbm;
        }
        if (zzbm == null) {
            return null;
        }
        zzbba.zzee("View is not an instance of MediaView");
        return null;
    }

    public final AdChoicesView getAdChoicesView() {
        View zzbm = zzbm(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbm instanceof AdChoicesView) {
            return (AdChoicesView) zzbm;
        }
        return null;
    }

    public final void destroy() {
        try {
            this.zzbnn.destroy();
        } catch (RemoteException e) {
            zzbba.zzc("Unable to destroy native ad view", e);
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzadx zzjt() {
        Preconditions.checkNotNull(this.zzbnm, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwg.zzpt().zza(this.zzbnm.getContext(), this, this.zzbnm);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbnm);
    }

    public final void removeView(View view) {
        if (this.zzbnm != view) {
            super.removeView(view);
        }
    }

    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbnm);
    }

    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbnm;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzadx zzadx = this.zzbnn;
        if (zzadx != null) {
            try {
                zzadx.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzbba.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzadx zzadx;
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcqx)).booleanValue() && (zzadx = this.zzbnn) != null) {
            try {
                zzadx.zzf(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e) {
                zzbba.zzc("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            try {
                this.zzbnn.zzg(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e) {
                zzbba.zzc("Unable to call setMediaViewImageScaleType on delegate", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzzc) {
                this.zzbnn.zza(((zzzc) mediaContent).zzqt());
            } else if (mediaContent == null) {
                this.zzbnn.zza((zzado) null);
            } else {
                zzbba.zzee("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e) {
            zzbba.zzc("Unable to call setMediaContent on delegate", e);
        }
    }
}
