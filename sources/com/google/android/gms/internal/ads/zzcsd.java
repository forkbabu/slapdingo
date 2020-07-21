package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcsd extends zzamw implements zzbtt {
    private zzamx zzdlh;
    private zzbtw zzglh;

    public final synchronized void zzb(zzamx zzamx) {
        this.zzdlh = zzamx;
    }

    @Override // com.google.android.gms.internal.ads.zzbtt
    public final synchronized void zza(zzbtw zzbtw) {
        this.zzglh = zzbtw;
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onAdClicked() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onAdClicked();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onAdClosed() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onAdClosed();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onAdFailedToLoad(int i) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onAdFailedToLoad(i);
        }
        if (this.zzglh != null) {
            this.zzglh.zzf(i, null);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zzc(int i, String str) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zzc(i, str);
        }
        if (this.zzglh != null) {
            this.zzglh.zzf(i, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onAdLeftApplication() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onAdLeftApplication();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onAdOpened() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onAdOpened();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onAdLoaded() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onAdLoaded();
        }
        if (this.zzglh != null) {
            this.zzglh.onAdLoaded();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zza(zzamy zzamy) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zza(zzamy);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onAdImpression() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onAdImpression();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onAppEvent(String str, String str2) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onAppEvent(str, str2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zza(zzaep zzaep, String str) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zza(zzaep, str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onVideoEnd() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onVideoEnd();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zzdm(String str) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zzdm(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zztt() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zztt();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onVideoPlay() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onVideoPlay();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zzb(zzaub zzaub) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zzb(zzaub);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void onVideoPause() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.onVideoPause();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zzb(Bundle bundle) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zzb(bundle);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zztu() throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zztu();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zzdc(int i) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zzdc(i);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zzdn(String str) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zzdn(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final synchronized void zza(zzaud zzaud) throws RemoteException {
        if (this.zzdlh != null) {
            this.zzdlh.zza(zzaud);
        }
    }
}
