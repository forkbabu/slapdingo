package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface zzaui extends IInterface {
    Bundle getAdMetadata() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    boolean isLoaded() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, boolean z) throws RemoteException;

    void zza(zzauj zzauj) throws RemoteException;

    void zza(zzaur zzaur) throws RemoteException;

    void zza(zzauz zzauz) throws RemoteException;

    void zza(zzve zzve, zzauq zzauq) throws RemoteException;

    void zza(zzxx zzxx) throws RemoteException;

    void zza(zzyc zzyc) throws RemoteException;

    void zzb(zzve zzve, zzauq zzauq) throws RemoteException;

    void zzh(IObjectWrapper iObjectWrapper) throws RemoteException;

    zzyd zzkj() throws RemoteException;

    zzaud zzqv() throws RemoteException;
}
