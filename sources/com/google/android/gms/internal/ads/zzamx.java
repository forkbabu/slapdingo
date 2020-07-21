package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public interface zzamx extends IInterface {
    void onAdClicked() throws RemoteException;

    void onAdClosed() throws RemoteException;

    void onAdFailedToLoad(int i) throws RemoteException;

    void onAdImpression() throws RemoteException;

    void onAdLeftApplication() throws RemoteException;

    void onAdLoaded() throws RemoteException;

    void onAdOpened() throws RemoteException;

    void onAppEvent(String str, String str2) throws RemoteException;

    void onVideoEnd() throws RemoteException;

    void onVideoPause() throws RemoteException;

    void onVideoPlay() throws RemoteException;

    void zza(zzaep zzaep, String str) throws RemoteException;

    void zza(zzamy zzamy) throws RemoteException;

    void zza(zzaud zzaud) throws RemoteException;

    void zzb(Bundle bundle) throws RemoteException;

    void zzb(zzaub zzaub) throws RemoteException;

    void zzc(int i, String str) throws RemoteException;

    void zzdc(int i) throws RemoteException;

    void zzdm(String str) throws RemoteException;

    void zzdn(String str) throws RemoteException;

    void zztt() throws RemoteException;

    void zztu() throws RemoteException;
}
