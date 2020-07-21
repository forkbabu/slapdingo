package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzanr extends zzamw {
    private final zzatx zzdkc;
    private final Adapter zzdkm;

    zzanr(Adapter adapter, zzatx zzatx) {
        this.zzdkm = adapter;
        this.zzdkc = zzatx;
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdImpression() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdLeftApplication() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAppEvent(String str, String str2) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onVideoEnd() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onVideoPause() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onVideoPlay() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zza(zzaep zzaep, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zza(zzamy zzamy) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzb(Bundle bundle) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzb(zzaub zzaub) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzc(int i, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzdc(int i) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzdm(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zzdn(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdLoaded() throws RemoteException {
        zzatx zzatx = this.zzdkc;
        if (zzatx != null) {
            zzatx.zzag(ObjectWrapper.wrap(this.zzdkm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdOpened() throws RemoteException {
        zzatx zzatx = this.zzdkc;
        if (zzatx != null) {
            zzatx.zzah(ObjectWrapper.wrap(this.zzdkm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdClosed() throws RemoteException {
        zzatx zzatx = this.zzdkc;
        if (zzatx != null) {
            zzatx.zzaj(ObjectWrapper.wrap(this.zzdkm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zza(zzaud zzaud) throws RemoteException {
        zzatx zzatx = this.zzdkc;
        if (zzatx != null) {
            zzatx.zza(ObjectWrapper.wrap(this.zzdkm), new zzaub(zzaud.getType(), zzaud.getAmount()));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zztt() throws RemoteException {
        zzatx zzatx = this.zzdkc;
        if (zzatx != null) {
            zzatx.zzai(ObjectWrapper.wrap(this.zzdkm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void zztu() throws RemoteException {
        zzatx zzatx = this.zzdkc;
        if (zzatx != null) {
            zzatx.zzam(ObjectWrapper.wrap(this.zzdkm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdClicked() throws RemoteException {
        zzatx zzatx = this.zzdkc;
        if (zzatx != null) {
            zzatx.zzak(ObjectWrapper.wrap(this.zzdkm));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzamx
    public final void onAdFailedToLoad(int i) throws RemoteException {
        zzatx zzatx = this.zzdkc;
        if (zzatx != null) {
            zzatx.zze(ObjectWrapper.wrap(this.zzdkm), i);
        }
    }
}
