package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzva extends zzwm {
    private final AdListener zzcgq;

    public zzva(AdListener adListener) {
        this.zzcgq = adListener;
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void onAdClosed() {
        this.zzcgq.onAdClosed();
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void onAdFailedToLoad(int i) {
        this.zzcgq.onAdFailedToLoad(i);
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void zza(zzuy zzuy) {
        new AdError(zzuy.errorCode, zzuy.zzcgo, zzuy.zzcgp);
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void onAdLeftApplication() {
        this.zzcgq.onAdLeftApplication();
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void onAdLoaded() {
        this.zzcgq.onAdLoaded();
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void onAdOpened() {
        this.zzcgq.onAdOpened();
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void onAdClicked() {
        this.zzcgq.onAdClicked();
    }

    @Override // com.google.android.gms.internal.ads.zzwj
    public final void onAdImpression() {
        this.zzcgq.onAdImpression();
    }

    public final AdListener getAdListener() {
        return this.zzcgq;
    }
}
