package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface zzaiq extends IInterface {
    void destroy() throws RemoteException;

    zzyi getVideoController() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzaiv zzaiv) throws RemoteException;

    void zzr(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzado zzsn() throws RemoteException;
}
