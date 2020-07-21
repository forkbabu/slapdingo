package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.appopen.AppOpenAd;
import java.lang.ref.WeakReference;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzsd extends zzsj {
    private final WeakReference<AppOpenAd.AppOpenAdLoadCallback> zzbuj;

    public zzsd(AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback) {
        this.zzbuj = new WeakReference<>(appOpenAdLoadCallback);
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void zza(zzsf zzsf) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbuj.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdLoaded(new zzsm(zzsf));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzsg
    public final void onAppOpenAdFailedToLoad(int i) {
        AppOpenAd.AppOpenAdLoadCallback appOpenAdLoadCallback = this.zzbuj.get();
        if (appOpenAdLoadCallback != null) {
            appOpenAdLoadCallback.onAppOpenAdFailedToLoad(i);
        }
    }
}
