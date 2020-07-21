package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final /* synthetic */ class zzzr implements Runnable {
    private final zzauq zzckl;

    zzzr(zzauq zzauq) {
        this.zzckl = zzauq;
    }

    public final void run() {
        zzauq zzauq = this.zzckl;
        if (zzauq != null) {
            try {
                zzauq.onRewardedAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbba.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
