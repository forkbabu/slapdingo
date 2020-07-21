package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzasb extends zzgu implements zzarz {
    zzasb(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.request.IAdRequestService");
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final zzarv zza(zzart zzart) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzart);
        Parcel transactAndReadException = transactAndReadException(1, obtainAndWriteInterfaceToken);
        zzarv zzarv = (zzarv) zzgw.zza(transactAndReadException, zzarv.CREATOR);
        transactAndReadException.recycle();
        return zzarv;
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zza(zzart zzart, zzase zzase) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzart);
        zzgw.zza(obtainAndWriteInterfaceToken, zzase);
        zza(2, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zza(zzasm zzasm, zzasg zzasg) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzasm);
        zzgw.zza(obtainAndWriteInterfaceToken, zzasg);
        zza(4, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzb(zzasm zzasm, zzasg zzasg) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzasm);
        zzgw.zza(obtainAndWriteInterfaceToken, zzasg);
        zza(5, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zzc(zzasm zzasm, zzasg zzasg) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzgw.zza(obtainAndWriteInterfaceToken, zzasm);
        zzgw.zza(obtainAndWriteInterfaceToken, zzasg);
        zza(6, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.internal.ads.zzarz
    public final void zza(String str, zzasg zzasg) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeString(str);
        zzgw.zza(obtainAndWriteInterfaceToken, zzasg);
        zza(7, obtainAndWriteInterfaceToken);
    }
}
