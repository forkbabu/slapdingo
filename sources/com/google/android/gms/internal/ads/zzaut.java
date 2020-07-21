package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAdCallback;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.rewarded.ServerSideVerificationOptions;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaut {
    private final Context zzaah;
    private final zzaui zzduu;

    public zzaut(Context context, String str) {
        this.zzaah = context.getApplicationContext();
        this.zzduu = zzwg.zzpt().zzc(context, str, new zzamo());
    }

    public final void zza(zzyq zzyq, RewardedAdLoadCallback rewardedAdLoadCallback) {
        try {
            this.zzduu.zza(zzvf.zza(this.zzaah, zzyq), new zzava(rewardedAdLoadCallback));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            return this.zzduu.getMediationAdapterClassName();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return "";
        }
    }

    public final void setServerSideVerificationOptions(ServerSideVerificationOptions serverSideVerificationOptions) {
        try {
            this.zzduu.zza(new zzauz(serverSideVerificationOptions));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnAdMetadataChangedListener(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        try {
            this.zzduu.zza(new zzzs(onAdMetadataChangedListener));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            return this.zzduu.getAdMetadata();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return new Bundle();
        }
    }

    public final boolean isLoaded() {
        try {
            return this.zzduu.isLoaded();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback) {
        try {
            this.zzduu.zza(new zzauv(rewardedAdCallback));
            this.zzduu.zzh(ObjectWrapper.wrap(activity));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final void show(Activity activity, RewardedAdCallback rewardedAdCallback, boolean z) {
        try {
            this.zzduu.zza(new zzauv(rewardedAdCallback));
            this.zzduu.zza(ObjectWrapper.wrap(activity), z);
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final RewardItem getRewardItem() {
        try {
            zzaud zzqv = this.zzduu.zzqv();
            if (zzqv == null) {
                return null;
            }
            return new zzauw(zzqv);
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzyd zzyd;
        try {
            zzyd = this.zzduu.zzkj();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            zzyd = null;
        }
        return ResponseInfo.zza(zzyd);
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzduu.zza(new zzzv(onPaidEventListener));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }
}
