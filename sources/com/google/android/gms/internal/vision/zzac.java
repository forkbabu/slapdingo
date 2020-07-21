package com.google.android.gms.internal.vision;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
public final class zzac extends zzb implements zzad {
    zzac(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final zzah[] zza(IObjectWrapper iObjectWrapper, zzu zzu, zzaj zzaj) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(obtainAndWriteInterfaceToken, zzu);
        zzd.zza(obtainAndWriteInterfaceToken, zzaj);
        Parcel zza = zza(3, obtainAndWriteInterfaceToken);
        zzah[] zzahArr = (zzah[]) zza.createTypedArray(zzah.CREATOR);
        zza.recycle();
        return zzahArr;
    }

    @Override // com.google.android.gms.internal.vision.zzad
    public final void zzr() throws RemoteException {
        zzb(2, obtainAndWriteInterfaceToken());
    }
}
