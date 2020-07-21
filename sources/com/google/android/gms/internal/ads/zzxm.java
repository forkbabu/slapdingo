package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface zzxm extends IInterface {
    String getVersionString() throws RemoteException;

    void initialize() throws RemoteException;

    void setAppMuted(boolean z) throws RemoteException;

    void setAppVolume(float f) throws RemoteException;

    void zza(zzaij zzaij) throws RemoteException;

    void zza(zzamr zzamr) throws RemoteException;

    void zza(zzzu zzzu) throws RemoteException;

    void zza(String str, IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, String str) throws RemoteException;

    void zzcg(String str) throws RemoteException;

    void zzch(String str) throws RemoteException;

    float zzqc() throws RemoteException;

    boolean zzqd() throws RemoteException;

    List<zzaic> zzqe() throws RemoteException;

    void zzqf() throws RemoteException;
}
