package com.google.android.gms.ads.formats;

import android.widget.ImageView;
import com.google.android.gms.internal.ads.zzadg;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzd implements zzadg {
    private final UnifiedNativeAdView zzbnw;

    zzd(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzbnw = unifiedNativeAdView;
    }

    @Override // com.google.android.gms.internal.ads.zzadg
    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        this.zzbnw.zza(scaleType);
    }
}
