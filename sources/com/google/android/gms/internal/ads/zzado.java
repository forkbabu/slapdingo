package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface zzado extends IInterface {
    float getAspectRatio() throws RemoteException;

    float getCurrentTime() throws RemoteException;

    float getDuration() throws RemoteException;

    zzyi getVideoController() throws RemoteException;

    boolean hasVideoContent() throws RemoteException;

    void zza(zzaff zzaff) throws RemoteException;

    void zzo(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzsa() throws RemoteException;
}
