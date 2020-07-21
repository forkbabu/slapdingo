package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzxr extends zzgu implements zzxp {
    zzxr(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IMuteThisAdListener");
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final void onAdMuted() throws RemoteException {
        zza(1, obtainAndWriteInterfaceToken());
    }
}
