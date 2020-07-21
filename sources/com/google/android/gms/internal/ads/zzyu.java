package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzyu {
    private final zzvf zzacq;
    private AppEventListener zzbnt;
    private boolean zzbop;
    private zzww zzbul;
    private String zzbum;
    private final zzamo zzbuo;
    private zzuu zzcgl;
    private AdListener zzcgq;
    private AdMetadataListener zzcgr;
    private OnCustomRenderedAdLoadedListener zzcjm;
    private OnPaidEventListener zzcjp;
    private RewardedVideoAdListener zzcjv;
    private boolean zzcjw;
    private final Context zzvr;

    public zzyu(Context context) {
        this(context, zzvf.zzchh, null);
    }

    public zzyu(Context context, PublisherInterstitialAd publisherInterstitialAd) {
        this(context, zzvf.zzchh, publisherInterstitialAd);
    }

    private zzyu(Context context, zzvf zzvf, PublisherInterstitialAd publisherInterstitialAd) {
        this.zzbuo = new zzamo();
        this.zzvr = context;
        this.zzacq = zzvf;
    }

    public final AdListener getAdListener() {
        return this.zzcgq;
    }

    public final String getAdUnitId() {
        return this.zzbum;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnt;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcjm;
    }

    public final boolean isLoaded() {
        try {
            if (this.zzbul == null) {
                return false;
            }
            return this.zzbul.isReady();
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbul == null) {
                return false;
            }
            return this.zzbul.isLoading();
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
            return false;
        }
    }

    public final void zza(zzyq zzyq) {
        try {
            if (this.zzbul == null) {
                if (this.zzbum == null) {
                    zzcq("loadAd");
                }
                zzvh zzpi = this.zzcjw ? zzvh.zzpi() : new zzvh();
                zzvp zzpt = zzwg.zzpt();
                Context context = this.zzvr;
                zzww zzww = (zzww) new zzvx(zzpt, context, zzpi, this.zzbum, this.zzbuo).zzd(context, false);
                this.zzbul = zzww;
                if (this.zzcgq != null) {
                    zzww.zza(new zzva(this.zzcgq));
                }
                if (this.zzcgl != null) {
                    this.zzbul.zza(new zzut(this.zzcgl));
                }
                if (this.zzcgr != null) {
                    this.zzbul.zza(new zzvb(this.zzcgr));
                }
                if (this.zzbnt != null) {
                    this.zzbul.zza(new zzvl(this.zzbnt));
                }
                if (this.zzcjm != null) {
                    this.zzbul.zza(new zzabt(this.zzcjm));
                }
                if (this.zzcjv != null) {
                    this.zzbul.zza(new zzatt(this.zzcjv));
                }
                this.zzbul.zza(new zzzv(this.zzcjp));
                this.zzbul.setImmersiveMode(this.zzbop);
            }
            if (this.zzbul.zza(zzvf.zza(this.zzvr, zzyq))) {
                this.zzbuo.zzf(zzyq.zzqm());
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        try {
            this.zzcgq = adListener;
            if (this.zzbul != null) {
                this.zzbul.zza(adListener != null ? new zzva(adListener) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zza(zzuu zzuu) {
        try {
            this.zzcgl = zzuu;
            if (this.zzbul != null) {
                this.zzbul.zza(zzuu != null ? new zzut(zzuu) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setAdUnitId(String str) {
        if (this.zzbum == null) {
            this.zzbum = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on InterstitialAd.");
    }

    public final void setAdMetadataListener(AdMetadataListener adMetadataListener) {
        try {
            this.zzcgr = adMetadataListener;
            if (this.zzbul != null) {
                this.zzbul.zza(adMetadataListener != null ? new zzvb(adMetadataListener) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final Bundle getAdMetadata() {
        try {
            if (this.zzbul != null) {
                return this.zzbul.getAdMetadata();
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
        return new Bundle();
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbnt = appEventListener;
            if (this.zzbul != null) {
                this.zzbul.zza(appEventListener != null ? new zzvl(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        try {
            this.zzcjm = onCustomRenderedAdLoadedListener;
            if (this.zzbul != null) {
                this.zzbul.zza(onCustomRenderedAdLoadedListener != null ? new zzabt(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setRewardedVideoAdListener(RewardedVideoAdListener rewardedVideoAdListener) {
        try {
            this.zzcjv = rewardedVideoAdListener;
            if (this.zzbul != null) {
                this.zzbul.zza(rewardedVideoAdListener != null ? new zzatt(rewardedVideoAdListener) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void zzd(boolean z) {
        this.zzcjw = true;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbul != null) {
                return this.zzbul.zzki();
            }
            return null;
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
            return null;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzyd zzyd = null;
        try {
            if (this.zzbul != null) {
                zzyd = this.zzbul.zzkj();
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
        return ResponseInfo.zza(zzyd);
    }

    public final void show() {
        try {
            zzcq("show");
            this.zzbul.showInterstitial();
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setImmersiveMode(boolean z) {
        try {
            this.zzbop = z;
            if (this.zzbul != null) {
                this.zzbul.setImmersiveMode(z);
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzcjp = onPaidEventListener;
            if (this.zzbul != null) {
                this.zzbul.zza(new zzzv(onPaidEventListener));
            }
        } catch (RemoteException e) {
            zzbba.zze("#008 Must be called on the main UI thread.", e);
        }
    }

    private final void zzcq(String str) {
        if (this.zzbul == null) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63);
            sb.append("The ad unit ID must be set on InterstitialAd before ");
            sb.append(str);
            sb.append(" is called.");
            throw new IllegalStateException(sb.toString());
        }
    }
}
