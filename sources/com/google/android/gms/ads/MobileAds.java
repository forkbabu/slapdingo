package com.google.android.gms.ads;

import android.content.Context;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.internal.ads.zzyt;
import com.google.android.gms.internal.ads.zzzb;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public class MobileAds {

    @Deprecated
    /* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
    public static final class Settings {
        private final zzzb zzadf = new zzzb();

        @Deprecated
        public final String getTrackingId() {
            return null;
        }

        @Deprecated
        public final boolean isGoogleAnalyticsEnabled() {
            return false;
        }

        @Deprecated
        public final Settings setGoogleAnalyticsEnabled(boolean z) {
            return this;
        }

        @Deprecated
        public final Settings setTrackingId(String str) {
            return this;
        }
    }

    private MobileAds() {
    }

    @Deprecated
    public static void initialize(Context context, String str) {
        initialize(context, str, null);
    }

    @Deprecated
    public static void initialize(Context context, String str, Settings settings) {
        zzyt.zzqs().zza(context, str, null);
    }

    public static void initialize(Context context) {
        initialize(context, null, null);
    }

    public static void initialize(Context context, OnInitializationCompleteListener onInitializationCompleteListener) {
        zzyt.zzqs().zza(context, null, onInitializationCompleteListener);
    }

    public static RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        return zzyt.zzqs().getRewardedVideoAdInstance(context);
    }

    public static void setAppVolume(float f) {
        zzyt.zzqs().setAppVolume(f);
    }

    public static void setAppMuted(boolean z) {
        zzyt.zzqs().setAppMuted(z);
    }

    public static void openDebugMenu(Context context, String str) {
        zzyt.zzqs().openDebugMenu(context, str);
    }

    public static String getVersionString() {
        return zzyt.zzqs().getVersionString();
    }

    public static void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        zzyt.zzqs().registerRtbAdapter(cls);
    }

    public static InitializationStatus getInitializationStatus() {
        return zzyt.zzqs().getInitializationStatus();
    }

    public static RequestConfiguration getRequestConfiguration() {
        return zzyt.zzqs().getRequestConfiguration();
    }

    public static void setRequestConfiguration(RequestConfiguration requestConfiguration) {
        zzyt.zzqs().setRequestConfiguration(requestConfiguration);
    }

    public static void disableMediationAdapterInitialization(Context context) {
        zzyt.zzqs().disableMediationAdapterInitialization(context);
    }
}
