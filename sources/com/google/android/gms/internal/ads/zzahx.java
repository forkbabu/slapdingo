package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzahx extends zzgu implements zzahu {
    zzahx(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.httpcache.IHttpAssetsCacheService");
    }

    @Override // com.google.android.gms.internal.ads.zzahu
    public final void zza(zzaho zzaho, zzahs zzahs) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzaho);
        zzgw.zza(obtainAndWriteInterfaceToken, zzahs);
        zzb(2, obtainAndWriteInterfaceToken);
    }
}
