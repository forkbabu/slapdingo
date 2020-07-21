package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzzj implements Runnable {
    private final /* synthetic */ zzzg zzckg;

    zzzj(zzzg zzzg) {
        this.zzckg = zzzg;
    }

    public final void run() {
        if (this.zzckg.zzckf.zzbpd != null) {
            try {
                this.zzckg.zzckf.zzbpd.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbba.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
