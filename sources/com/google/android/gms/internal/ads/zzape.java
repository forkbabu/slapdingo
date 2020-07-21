package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzape implements MediationAdLoadCallback<MediationInterstitialAd, MediationInterstitialAdCallback> {
    private final /* synthetic */ zzaom zzdlb;
    private final /* synthetic */ zzamx zzdlc;
    private final /* synthetic */ zzapc zzdld;

    zzape(zzapc zzapc, zzaom zzaom, zzamx zzamx) {
        this.zzdld = zzapc;
        this.zzdlb = zzaom;
        this.zzdlc = zzamx;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationInterstitialAdCallback onSuccess(MediationInterstitialAd mediationInterstitialAd) {
        if (mediationInterstitialAd == null) {
            zzbba.zzfd("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdlb.zzdp("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbba.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationInterstitialAd unused = this.zzdld.zzdkz = mediationInterstitialAd;
                this.zzdlb.zzuc();
            } catch (RemoteException e2) {
                zzbba.zzc("", e2);
            }
            return new zzapi(this.zzdlc);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdlb.zzdp(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
