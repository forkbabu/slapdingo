package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.mediation.InitializationCompleteCallback;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzanm implements InitializationCompleteCallback {
    private final /* synthetic */ zzaie zzdjz;

    zzanm(zzann zzann, zzaie zzaie) {
        this.zzdjz = zzaie;
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationSucceeded() {
        try {
            this.zzdjz.onInitializationSucceeded();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.mediation.InitializationCompleteCallback
    public final void onInitializationFailed(String str) {
        try {
            this.zzdjz.onInitializationFailed(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
