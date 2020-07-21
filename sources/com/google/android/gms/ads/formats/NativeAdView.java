package com.google.android.gms.ads.formats;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaav;
import com.google.android.gms.internal.ads.zzadx;
import com.google.android.gms.internal.ads.zzbba;
import com.google.android.gms.internal.ads.zzwg;

@Deprecated
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class NativeAdView extends FrameLayout {
    private final FrameLayout zzbnm;
    private final zzadx zzbnn = zzjt();

    public NativeAdView(Context context) {
        super(context);
        this.zzbnm = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbnm = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbnm = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbnm = zzd(context);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public AdChoicesView getAdChoicesView() {
        View zzbm = zzbm(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbm instanceof AdChoicesView) {
            return (AdChoicesView) zzbm;
        }
        return null;
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzbnn.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzbba.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final View zzbm(String str) {
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

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzbnn.zza((IObjectWrapper) nativeAd.zzjr());
        } catch (RemoteException e) {
            zzbba.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    public void destroy() {
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
        Preconditions.checkNotNull(this.zzbnm, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwg.zzpt().zza(this.zzbnm.getContext(), this, this.zzbnm);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbnm);
    }

    public void removeView(View view) {
        if (this.zzbnm != view) {
            super.removeView(view);
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbnm);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbnm;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void onVisibilityChanged(View view, int i) {
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

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
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
}
