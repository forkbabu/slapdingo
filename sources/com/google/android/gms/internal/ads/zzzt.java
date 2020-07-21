package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzzt implements Runnable {
    private final /* synthetic */ zzzq zzckn;

    zzzt(zzzq zzzq) {
        this.zzckn = zzzq;
    }

    public final void run() {
        if (this.zzckn.zzckk != null) {
            try {
                this.zzckn.zzckk.onRewardedVideoAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbba.zzd("Could not notify onRewardedVideoAdFailedToLoad event.", e);
            }
        }
    }
}
