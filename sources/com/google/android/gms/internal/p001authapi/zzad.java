package com.google.android.gms.internal.p001authapi;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.auth.api.identity.BeginSignInRequest;
import com.google.android.gms.common.api.internal.IStatusCallback;

/* renamed from: com.google.android.gms.internal.auth-api.zzad  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@18.0.0 */
public interface zzad extends IInterface {
    void zzc(IStatusCallback iStatusCallback, String str) throws RemoteException;

    void zzc(zzab zzab, BeginSignInRequest beginSignInRequest) throws RemoteException;
}
