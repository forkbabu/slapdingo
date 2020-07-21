package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
final class zzaoe implements Runnable {
    private final /* synthetic */ zzanu zzdkt;
    private final /* synthetic */ AdRequest.ErrorCode zzdku;

    zzaoe(zzanu zzanu, AdRequest.ErrorCode errorCode) {
        this.zzdkt = zzanu;
        this.zzdku = errorCode;
    }

    public final void run() {
        try {
            this.zzdkt.zzdkf.onAdFailedToLoad(zzaog.zza(this.zzdku));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }
}
