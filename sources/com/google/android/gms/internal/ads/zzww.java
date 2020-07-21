package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface zzww extends IInterface {
    void destroy() throws RemoteException;

    Bundle getAdMetadata() throws RemoteException;

    String getAdUnitId() throws RemoteException;

    String getMediationAdapterClassName() throws RemoteException;

    zzyi getVideoController() throws RemoteException;

    boolean isLoading() throws RemoteException;

    boolean isReady() throws RemoteException;

    void pause() throws RemoteException;

    void resume() throws RemoteException;

    void setImmersiveMode(boolean z) throws RemoteException;

    void setManualImpressionsEnabled(boolean z) throws RemoteException;

    void setUserId(String str) throws RemoteException;

    void showInterstitial() throws RemoteException;

    void stopLoading() throws RemoteException;

    void zza(zzaaa zzaaa) throws RemoteException;

    void zza(zzabo zzabo) throws RemoteException;

    void zza(zzaqs zzaqs) throws RemoteException;

    void zza(zzaqy zzaqy, String str) throws RemoteException;

    void zza(zzatq zzatq) throws RemoteException;

    void zza(zzsg zzsg) throws RemoteException;

    void zza(zzvh zzvh) throws RemoteException;

    void zza(zzvo zzvo) throws RemoteException;

    void zza(zzwi zzwi) throws RemoteException;

    void zza(zzwj zzwj) throws RemoteException;

    void zza(zzwz zzwz) throws RemoteException;

    void zza(zzxe zzxe) throws RemoteException;

    void zza(zzxk zzxk) throws RemoteException;

    void zza(zzyc zzyc) throws RemoteException;

    void zza(zzyo zzyo) throws RemoteException;

    boolean zza(zzve zzve) throws RemoteException;

    void zzbo(String str) throws RemoteException;

    IObjectWrapper zzkf() throws RemoteException;

    void zzkg() throws RemoteException;

    zzvh zzkh() throws RemoteException;

    String zzki() throws RemoteException;

    zzyd zzkj() throws RemoteException;

    zzxe zzkk() throws RemoteException;

    zzwj zzkl() throws RemoteException;
}
