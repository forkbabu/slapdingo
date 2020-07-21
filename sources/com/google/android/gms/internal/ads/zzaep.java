package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface zzaep extends IInterface {
    void destroy() throws RemoteException;

    List<String> getAvailableAssetNames() throws RemoteException;

    String getCustomTemplateId() throws RemoteException;

    zzyi getVideoController() throws RemoteException;

    void performClick(String str) throws RemoteException;

    void recordImpression() throws RemoteException;

    String zzcw(String str) throws RemoteException;

    zzadt zzcx(String str) throws RemoteException;

    boolean zzp(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzq(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zzsb() throws RemoteException;

    IObjectWrapper zzsg() throws RemoteException;

    boolean zzsh() throws RemoteException;

    boolean zzsi() throws RemoteException;

    void zzsj() throws RemoteException;
}
