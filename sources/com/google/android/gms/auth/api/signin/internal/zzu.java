package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.internal.p001authapi.zzd;
import com.google.android.gms.internal.p001authapi.zzf;

/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
public final class zzu extends zzd implements zzv {
    zzu(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zzc(zzt zzt, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzc(obtainAndWriteInterfaceToken, zzt);
        zzf.zzc(obtainAndWriteInterfaceToken, googleSignInOptions);
        transactAndReadExceptionReturnVoid(101, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zzd(zzt zzt, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzc(obtainAndWriteInterfaceToken, zzt);
        zzf.zzc(obtainAndWriteInterfaceToken, googleSignInOptions);
        transactAndReadExceptionReturnVoid(102, obtainAndWriteInterfaceToken);
    }

    @Override // com.google.android.gms.auth.api.signin.internal.zzv
    public final void zze(zzt zzt, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel obtainAndWriteInterfaceToken = obtainAndWriteInterfaceToken();
        zzf.zzc(obtainAndWriteInterfaceToken, zzt);
        zzf.zzc(obtainAndWriteInterfaceToken, googleSignInOptions);
        transactAndReadExceptionReturnVoid(103, obtainAndWriteInterfaceToken);
    }
}
