package com.google.android.gms.vision.face.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.vision.zzb;
import com.google.android.gms.internal.vision.zzd;
import com.google.android.gms.internal.vision.zzu;

/* compiled from: com.google.android.gms:play-services-vision@@20.1.0 */
public final class zzj extends zzb implements zzh {
    zzj(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.face.internal.client.INativeFaceDetector");
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zzc(IObjectWrapper iObjectWrapper, zzu zzu) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(obtainAndWriteInterfaceToken, zzu);
        Parcel zza = zza(1, obtainAndWriteInterfaceToken);
        FaceParcel[] faceParcelArr = (FaceParcel[]) zza.createTypedArray(FaceParcel.CREATOR);
        zza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final FaceParcel[] zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3, int i, int i2, int i3, int i4, int i5, int i6, zzu zzu) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper);
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper2);
        zzd.zza(obtainAndWriteInterfaceToken, iObjectWrapper3);
        obtainAndWriteInterfaceToken.writeInt(i);
        obtainAndWriteInterfaceToken.writeInt(i2);
        obtainAndWriteInterfaceToken.writeInt(i3);
        obtainAndWriteInterfaceToken.writeInt(i4);
        obtainAndWriteInterfaceToken.writeInt(i5);
        obtainAndWriteInterfaceToken.writeInt(i6);
        zzd.zza(obtainAndWriteInterfaceToken, zzu);
        Parcel zza = zza(4, obtainAndWriteInterfaceToken);
        FaceParcel[] faceParcelArr = (FaceParcel[]) zza.createTypedArray(FaceParcel.CREATOR);
        zza.recycle();
        return faceParcelArr;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final boolean zzd(int i) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        obtainAndWriteInterfaceToken.writeInt(i);
        Parcel zza = zza(2, obtainAndWriteInterfaceToken);
        boolean zza2 = zzd.zza(zza);
        zza.recycle();
        return zza2;
    }

    @Override // com.google.android.gms.vision.face.internal.client.zzh
    public final void zzn() throws RemoteException {
        zzb(3, obtainAndWriteInterfaceToken());
    }
}
