package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.customtabs.CustomTabsIntent;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzd;
import com.google.android.gms.ads.internal.zzq;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzapn implements MediationInterstitialAdapter {
    private Uri uri;
    /* access modifiers changed from: private */
    public Activity zzdll;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzdlm;

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdlm = mediationInterstitialListener;
        if (mediationInterstitialListener == null) {
            zzbba.zzfd("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzbba.zzfd("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdlm.onAdFailedToLoad(this, 0);
        } else {
            if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzabs.zzk(context))) {
                zzbba.zzfd("Default browser does not support custom tabs. Bailing out.");
                this.zzdlm.onAdFailedToLoad(this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzbba.zzfd("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzdlm.onAdFailedToLoad(this, 0);
                return;
            }
            this.zzdll = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdlm.onAdLoaded(this);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationInterstitialAdapter
    public final void showInterstitial() {
        CustomTabsIntent build = new CustomTabsIntent.Builder().build();
        build.intent.setData(this.uri);
        zzaye.zzdzw.post(new zzapp(this, new AdOverlayInfoParcel(new zzd(build.intent), null, new zzapm(this), null, new zzbbd(0, 0, false))));
        zzq.zzla().zzwa();
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onDestroy() {
        zzbba.zzee("Destroying AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onPause() {
        zzbba.zzee("Pausing AdMobCustomTabsAdapter adapter.");
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdapter
    public final void onResume() {
        zzbba.zzee("Resuming AdMobCustomTabsAdapter adapter.");
    }
}
