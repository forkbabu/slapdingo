package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationNativeAdCallback;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzaph implements MediationAdLoadCallback<UnifiedNativeAdMapper, MediationNativeAdCallback> {
    private final /* synthetic */ zzamx zzdlc;
    private final /* synthetic */ zzaor zzdlg;

    zzaph(zzapc zzapc, zzaor zzaor, zzamx zzamx) {
        this.zzdlg = zzaor;
        this.zzdlc = zzamx;
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final MediationNativeAdCallback onSuccess(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        if (unifiedNativeAdMapper == null) {
            zzbba.zzfd("Adapter incorrectly returned a null ad. The onFailure() callback should be called if an adapter fails to load an ad.");
            try {
                this.zzdlg.zzdp("Adapter returned null.");
                return null;
            } catch (RemoteException e) {
                zzbba.zzc("", e);
                return null;
            }
        } else {
            try {
                this.zzdlg.zza(new zzaoi(unifiedNativeAdMapper));
            } catch (RemoteException e2) {
                zzbba.zzc("", e2);
            }
            return new zzapi(this.zzdlc);
        }
    }

    @Override // com.google.android.gms.ads.mediation.MediationAdLoadCallback
    public final void onFailure(String str) {
        try {
            this.zzdlg.zzdp(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
