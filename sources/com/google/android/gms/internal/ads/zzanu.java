package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.ads.AdRequest;
import com.google.ads.mediation.MediationBannerAdapter;
import com.google.ads.mediation.MediationBannerListener;
import com.google.ads.mediation.MediationInterstitialAdapter;
import com.google.ads.mediation.MediationInterstitialListener;
import com.google.ads.mediation.MediationServerParameters;
import com.google.ads.mediation.NetworkExtras;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzanu<NETWORK_EXTRAS extends NetworkExtras, SERVER_PARAMETERS extends MediationServerParameters> implements MediationBannerListener, MediationInterstitialListener {
    /* access modifiers changed from: private */
    public final zzamx zzdkf;

    public zzanu(zzamx zzamx) {
        this.zzdkf = zzamx;
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onClick(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbba.zzee("Adapter called onClick.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzanx(this));
            return;
        }
        try {
            this.zzdkf.onAdClicked();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onDismissScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbba.zzee("Adapter called onDismissScreen.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zzfd("#008 Must be called on the main UI thread.");
            zzbaq.zzaag.post(new zzany(this));
            return;
        }
        try {
            this.zzdkf.onAdClosed();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onFailedToReceiveAd(MediationBannerAdapter<?, ?> mediationBannerAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error. ");
        sb.append(valueOf);
        zzbba.zzee(sb.toString());
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzaob(this, errorCode));
            return;
        }
        try {
            this.zzdkf.onAdFailedToLoad(zzaog.zza(errorCode));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onLeaveApplication(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbba.zzee("Adapter called onLeaveApplication.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzaoa(this));
            return;
        }
        try {
            this.zzdkf.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onPresentScreen(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbba.zzee("Adapter called onPresentScreen.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzaod(this));
            return;
        }
        try {
            this.zzdkf.onAdOpened();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationBannerListener
    public final void onReceivedAd(MediationBannerAdapter<?, ?> mediationBannerAdapter) {
        zzbba.zzee("Adapter called onReceivedAd.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzaoc(this));
            return;
        }
        try {
            this.zzdkf.onAdLoaded();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onDismissScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbba.zzee("Adapter called onDismissScreen.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzaof(this));
            return;
        }
        try {
            this.zzdkf.onAdClosed();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onFailedToReceiveAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter, AdRequest.ErrorCode errorCode) {
        String valueOf = String.valueOf(errorCode);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 47);
        sb.append("Adapter called onFailedToReceiveAd with error ");
        sb.append(valueOf);
        sb.append(".");
        zzbba.zzee(sb.toString());
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzaoe(this, errorCode));
            return;
        }
        try {
            this.zzdkf.onAdFailedToLoad(zzaog.zza(errorCode));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onLeaveApplication(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbba.zzee("Adapter called onLeaveApplication.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzaoh(this));
            return;
        }
        try {
            this.zzdkf.onAdLeftApplication();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onPresentScreen(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbba.zzee("Adapter called onPresentScreen.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzanw(this));
            return;
        }
        try {
            this.zzdkf.onAdOpened();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.ads.mediation.MediationInterstitialListener
    public final void onReceivedAd(MediationInterstitialAdapter<?, ?> mediationInterstitialAdapter) {
        zzbba.zzee("Adapter called onReceivedAd.");
        zzwg.zzps();
        if (!zzbaq.zzyi()) {
            zzbba.zze("#008 Must be called on the main UI thread.", null);
            zzbaq.zzaag.post(new zzanz(this));
            return;
        }
        try {
            this.zzdkf.onAdLoaded();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }
}
