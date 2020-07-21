package com.google.android.gms.ads.formats;

import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.internal.ads.zzade;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zze implements zzade {
    private final UnifiedNativeAdView zzbnw;

    zze(UnifiedNativeAdView unifiedNativeAdView) {
        this.zzbnw = unifiedNativeAdView;
    }

    @Override // com.google.android.gms.internal.ads.zzade
    public final void setMediaContent(MediaContent mediaContent) {
        this.zzbnw.zza(mediaContent);
    }
}
