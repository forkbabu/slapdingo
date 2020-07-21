package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAd;
import com.google.android.gms.ads.mediation.MediationBannerAdCallback;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzapf implements MediationAdLoadCallback<MediationBannerAd, MediationBannerAdCallback> {
    private final /* synthetic */ zzamx zzdlc;
    private final /* synthetic */ zzaol zzdle;

    zzapf(zzapc zzapc, zzaol zzaol, zzamx zzamx) {
        this.zzdle = zzaol;
        this.zzdlc = zzamx;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationBannerAdCallback onSuccess(MediationBannerAd mediationBannerAd) {
        if (mediationBannerAd == null) {
            zzbba.zzfd("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdle.zzdp("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbba.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdle.zzx(ObjectWrapper.wrap(mediationBannerAd.getView()));
            } catch (RemoteException e2) {
                zzbba.zzc("", e2);
            }
            return new zzapi(this.zzdlc);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdle.zzdp(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
