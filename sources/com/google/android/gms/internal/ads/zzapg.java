package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.rtb.SignalCallbacks;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzapg implements SignalCallbacks {
    private final /* synthetic */ zzaoy zzdlf;

    zzapg(zzapc zzapc, zzaoy zzaoy) {
        this.zzdlf = zzaoy;
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onSuccess(String str) {
        try {
            this.zzdlf.zzdr(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.rtb.SignalCallbacks
    public final void onFailure(String str) {
        try {
            this.zzdlf.onFailure(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
