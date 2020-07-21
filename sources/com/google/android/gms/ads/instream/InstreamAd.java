package com.google.android.gms.ads.instream;

import android.content.Context;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.doubleclick.PublisherAdRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzaja;
import com.google.android.gms.internal.ads.zzajf;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public abstract class InstreamAd {

    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static abstract class InstreamAdLoadCallback {
        public void onInstreamAdFailedToLoad(int i) {
        }

        public void onInstreamAdLoaded(InstreamAd instreamAd) {
        }
    }

    public abstract void destroy();

    @Deprecated
    public abstract float getAspectRatio();

    public abstract MediaContent getMediaContent();

    @Deprecated
    public abstract VideoController getVideoController();

    @Deprecated
    public abstract float getVideoCurrentTime();

    @Deprecated
    public abstract float getVideoDuration();

    /* access modifiers changed from: protected */
    public abstract void zza(InstreamAdView instreamAdView);

    public static void load(Context context, String str, AdRequest adRequest, int i, InstreamAdLoadCallback instreamAdLoadCallback) {
        Preconditions.checkArgument(i == 2 || i == 3, "Instream ads only support Landscape and Portrait media aspect ratios");
        new zzajf(context, str).zza(instreamAdLoadCallback).zza(new zzaja(i)).zzsx().loadAd(adRequest);
    }

    public static void load(Context context, String str, InstreamAdLoadCallback instreamAdLoadCallback) {
        new zzajf(context, "").zza(instreamAdLoadCallback).zza(new zzaja(str)).zzsx().loadAd(new PublisherAdRequest.Builder().build());
    }
}
