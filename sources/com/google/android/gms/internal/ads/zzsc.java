package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAdPresentationCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzsc extends zzsk {
    private final AppOpenAdPresentationCallback zzbui;

    public zzsc(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzbui = appOpenAdPresentationCallback;
    }

    @Override // com.google.android.gms.internal.ads.zzsl
    public final void onAppOpenAdClosed() {
        this.zzbui.onAppOpenAdClosed();
    }
}
