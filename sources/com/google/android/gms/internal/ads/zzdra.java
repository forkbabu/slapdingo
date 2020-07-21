package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-gass@@19.2.0 */
public final class zzdra extends zzgu implements zzdqx {
    zzdra(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.gass.internal.IGassService");
    }

    @Override // com.google.android.gms.internal.ads.zzdqx
    public final zzdqv zza(zzdqt zzdqt) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzdqt);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzdqv zzdqv = (zzdqv) zzgw.zza(transactAndReadException, zzdqv.CREATOR);
        transactAndReadException.recycle();
        return zzdqv;
    }

    @Override // com.google.android.gms.internal.ads.zzdqx
    public final void zza(zzdqs zzdqs) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzdqs);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzdqx
    public final zzdrf zza(zzdrd zzdrd) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzdrd);
        Parcel transactAndReadException = transactAndReadException(3, obtainAndWriteInterfaceToken);
        zzdrf zzdrf = (zzdrf) zzgw.zza(transactAndReadException, zzdrf.CREATOR);
        transactAndReadException.recycle();
        return zzdrf;
    }
}
