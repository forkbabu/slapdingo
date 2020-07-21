package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface zzams extends IInterface {
    void destroy() throws RemoteException;

    Bundle getInterstitialAdapterInfo() throws RemoteException;

    zzyi getVideoController() throws RemoteException;

    boolean isInitialized() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void showVideo() throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzaie zzaie, List<zzaim> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzatx zzatx, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzve zzve, String str, zzamx zzamx) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzve zzve, String str, zzatx zzatx, String str2) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzve zzve, String str, String str2, zzamx zzamx) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzve zzve, String str, String str2, zzamx zzamx, zzadj zzadj, List<String> list) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvh zzvh, zzve zzve, String str, zzamx zzamx) throws RemoteException;

    void zza(IObjectWrapper iObjectWrapper, zzvh zzvh, zzve zzve, String str, String str2, zzamx zzamx) throws RemoteException;

    void zza(zzve zzve, String str) throws RemoteException;

    void zza(zzve zzve, String str, String str2) throws RemoteException;

    void zzb(IObjectWrapper iObjectWrapper, zzve zzve, String str, zzamx zzamx) throws RemoteException;

    void zzc(IObjectWrapper iObjectWrapper, zzve zzve, String str, zzamx zzamx) throws RemoteException;

    void zzs(IObjectWrapper iObjectWrapper) throws RemoteException;

    void zzt(IObjectWrapper iObjectWrapper) throws RemoteException;

    IObjectWrapper zztj() throws RemoteException;

    zzana zztk() throws RemoteException;

    zzanf zztl() throws RemoteException;

    Bundle zztm() throws RemoteException;

    Bundle zztn() throws RemoteException;

    boolean zzto() throws RemoteException;

    zzaep zztp() throws RemoteException;

    zzang zztq() throws RemoteException;

    zzapl zztr() throws RemoteException;

    zzapl zzts() throws RemoteException;
}
