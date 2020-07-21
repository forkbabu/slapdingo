package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzany implements Runnable {
    private final /* synthetic */ zzanu zzdkt;

    zzany(zzanu zzanu) {
        this.zzdkt = zzanu;
    }

    public final void run() {
        try {
            this.zzdkt.zzdkf.onAdClosed();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }
}
