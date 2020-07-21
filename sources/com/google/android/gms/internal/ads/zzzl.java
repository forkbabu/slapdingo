package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzzl implements Runnable {
    private final /* synthetic */ zzzi zzcki;

    zzzl(zzzi zzzi) {
        this.zzcki = zzzi;
    }

    public final void run() {
        if (this.zzcki.zzbpd != null) {
            try {
                this.zzcki.zzbpd.onAdFailedToLoad(1);
            } catch (RemoteException e) {
                zzbba.zzd("Could not notify onAdFailedToLoad event.", e);
            }
        }
    }
}
