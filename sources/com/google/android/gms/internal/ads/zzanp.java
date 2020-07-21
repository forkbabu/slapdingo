package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzanp implements MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> {
    private final /* synthetic */ zzamx zzdkj;
    private final /* synthetic */ zzann zzdkk;

    zzanp(zzann zzann, zzamx zzamx) {
        this.zzdkk = zzann;
        this.zzdkj = zzamx;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationRewardedAdCallback onSuccess(MediationRewardedAd mediationRewardedAd) {
        try {
            MediationRewardedAd unused = this.zzdkk.zzdke = mediationRewardedAd;
            this.zzdkj.onAdLoaded();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
        return new zzavb(this.zzdkj);
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            String canonicalName = this.zzdkk.zzdka.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 31 + String.valueOf(str).length());
            sb.append(canonicalName);
            sb.append("failed to loaded mediation ad: ");
            sb.append(str);
            zzbba.zzee(sb.toString());
            this.zzdkj.zzc(0, str);
            this.zzdkj.onAdFailedToLoad(0);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
