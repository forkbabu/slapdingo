package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzaoc implements Runnable {
    private final /* synthetic */ zzanu zzdkt;

    zzaoc(zzanu zzanu) {
        this.zzdkt = zzanu;
    }

    public final void run() {
        try {
            this.zzdkt.zzdkf.onAdLoaded();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }
}
