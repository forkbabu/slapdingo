package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzapj implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzamx zzdlc;
    private final /* synthetic */ zzapc zzdld;
    private final /* synthetic */ zzaos zzdli;

    zzapj(zzapc zzapc, zzaos zzaos, zzamx zzamx) {
        this.zzdld = zzapc;
        this.zzdli = zzaos;
        this.zzdlc = zzamx;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        if (mediationRewardedAd == null) {
            zzbba.zzfd("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdli.zzdp("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbba.zzc("", e);
                return null;
            }
        } else {
            try {
                MediationRewardedAd unused = this.zzdld.zzdke = mediationRewardedAd;
                this.zzdli.zzuc();
            } catch (RemoteException e2) {
                zzbba.zzc("", e2);
            }
            return new zzapi(this.zzdlc);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdli.zzdp(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
