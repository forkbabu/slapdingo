package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzys {
    private final zzvf zzacq;
    private VideoOptions zzbnk;
    private boolean zzbnr;
    private AppEventListener zzbnt;
    private zzww zzbul;
    private String zzbum;
    private final zzamo zzbuo;
    private zzuu zzcgl;
    private AdListener zzcgq;
    private AdSize[] zzchz;
    private final AtomicBoolean zzcjj;
    /* access modifiers changed from: private */
    public final VideoController zzcjk;
    private final zzwf zzcjl;
    private OnCustomRenderedAdLoadedListener zzcjm;
    private ViewGroup zzcjn;
    private int zzcjo;
    private OnPaidEventListener zzcjp;

    private static boolean zzda(int i) {
        return i == 1;
    }

    public zzys(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzvf.zzchh, 0);
    }

    public zzys(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzvf.zzchh, i);
    }

    public zzys(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzvf.zzchh, 0);
    }

    public zzys(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzvf.zzchh, i);
    }

    private zzys(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvf zzvf, zzww zzww, int i) {
        zzvh zzvh;
        this.zzbuo = new zzamo();
        this.zzcjk = new VideoController();
        this.zzcjl = new zzyr(this);
        this.zzcjn = viewGroup;
        this.zzacq = zzvf;
        this.zzbul = null;
        this.zzcjj = new AtomicBoolean(false);
        this.zzcjo = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzvq zzvq = new zzvq(context, attributeSet);
                this.zzchz = zzvq.zzy(z);
                this.zzbum = zzvq.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzbaq zzps = zzwg.zzps();
                    AdSize adSize = this.zzchz[0];
                    int i2 = this.zzcjo;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzvh = zzvh.zzpk();
                    } else {
                        zzvh zzvh2 = new zzvh(context, adSize);
                        zzvh2.zzchl = zzda(i2);
                        zzvh = zzvh2;
                    }
                    zzps.zza(viewGroup, zzvh, "Ads by Google");
                }
            } catch (IllegalArgumentException e) {
                zzwg.zzps().zza(viewGroup, new zzvh(context, AdSize.BANNER), e.getMessage(), e.getMessage());
            }
        }
    }

    private zzys(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvf zzvf, int i) {
        this(viewGroup, attributeSet, z, zzvf, null, i);
    }

    public final void destroy() {
        try {
            if (this.zzbul != null) {
                this.zzbul.destroy();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final AdListener getAdListener() {
        return this.zzcgq;
    }

    public final AdSize getAdSize() {
        zzvh zzkh;
        try {
            if (!(this.zzbul == null || (zzkh = this.zzbul.zzkh()) == null)) {
                return zzkh.zzpl();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        AdSize[] adSizeArr = this.zzchz;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzchz;
    }

    public final String getAdUnitId() {
        zzww zzww;
        if (this.zzbum == null && (zzww = this.zzbul) != null) {
            try {
                this.zzbum = zzww.getAdUnitId();
            } catch (RemoteException e) {
                zzbba.zze("#007 Could not call remote method.", e);
            }
        }
        return this.zzbum;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzbnt;
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcjm;
    }

    public final void zza(zzyq zzyq) {
        zzww zzww;
        try {
            if (this.zzbul == null) {
                if ((this.zzchz == null || this.zzbum == null) && this.zzbul == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzcjn.getContext();
                zzvh zza = zza(context, this.zzchz, this.zzcjo);
                if ("search_v2".equals(zza.zzacv)) {
                    zzww = (zzww) new zzvy(zzwg.zzpt(), context, zza, this.zzbum).zzd(context, false);
                } else {
                    zzww = (zzww) new zzvs(zzwg.zzpt(), context, zza, this.zzbum, this.zzbuo).zzd(context, false);
                }
                this.zzbul = zzww;
                zzww.zza(new zzva(this.zzcjl));
                if (this.zzcgl != null) {
                    this.zzbul.zza(new zzut(this.zzcgl));
                }
                if (this.zzbnt != null) {
                    this.zzbul.zza(new zzvl(this.zzbnt));
                }
                if (this.zzcjm != null) {
                    this.zzbul.zza(new zzabt(this.zzcjm));
                }
                if (this.zzbnk != null) {
                    this.zzbul.zza(new zzaaa(this.zzbnk));
                }
                this.zzbul.zza(new zzzv(this.zzcjp));
                this.zzbul.setManualImpressionsEnabled(this.zzbnr);
                try {
                    IObjectWrapper zzkf = this.zzbul.zzkf();
                    if (zzkf != null) {
                        this.zzcjn.addView((View) ObjectWrapper.unwrap(zzkf));
                    }
                } catch (RemoteException e) {
                    zzbba.zze("#007 Could not call remote method.", e);
                }
            }
            if (this.zzbul.zza(zzvf.zza(this.zzcjn.getContext(), zzyq))) {
                this.zzbuo.zzf(zzyq.zzqm());
            }
        } catch (RemoteException e2) {
            zzbba.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void pause() {
        try {
            if (this.zzbul != null) {
                this.zzbul.pause();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final void recordManualImpression() {
        if (!this.zzcjj.getAndSet(true)) {
            try {
                if (this.zzbul != null) {
                    this.zzbul.zzkg();
                }
            } catch (RemoteException e) {
                zzbba.zze("#007 Could not call remote method.", e);
            }
        }
    }

    public final void resume() {
        try {
            if (this.zzbul != null) {
                this.zzbul.resume();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzcgq = adListener;
        this.zzcjl.zza(adListener);
    }

    public final void zza(zzuu zzuu) {
        try {
            this.zzcgl = zzuu;
            if (this.zzbul != null) {
                this.zzbul.zza(zzuu != null ? new zzut(zzuu) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzchz == null) {
            zza(adSizeArr);
            return;
        }
        throw new IllegalStateException("The ad size can only be set once on AdView.");
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzchz = adSizeArr;
        try {
            if (this.zzbul != null) {
                this.zzbul.zza(zza(this.zzcjn.getContext(), this.zzchz, this.zzcjo));
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        this.zzcjn.requestLayout();
    }

    public final void setAdUnitId(String str) {
        if (this.zzbum == null) {
            this.zzbum = str;
            return;
        }
        throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzbnt = appEventListener;
            if (this.zzbul != null) {
                this.zzbul.zza(appEventListener != null ? new zzvl(appEventListener) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcjm = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzbul != null) {
                this.zzbul.zza(onCustomRenderedAdLoadedListener != null ? new zzabt(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbnr = z;
        try {
            if (this.zzbul != null) {
                this.zzbul.setManualImpressionsEnabled(z);
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbul != null) {
                return this.zzbul.zzki();
            }
            return null;
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final boolean isLoading() {
        try {
            if (this.zzbul != null) {
                return this.zzbul.isLoading();
            }
            return false;
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    public final ResponseInfo getResponseInfo() {
        zzyd zzyd = null;
        try {
            if (this.zzbul != null) {
                zzyd = this.zzbul.zzkj();
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        return ResponseInfo.zza(zzyd);
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

    public final VideoController getVideoController() {
        return this.zzcjk;
    }

    public final zzyi zzdu() {
        zzww zzww = this.zzbul;
        if (zzww == null) {
            return null;
        }
        try {
            return zzww.getVideoController();
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return null;
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        zzaaa zzaaa;
        this.zzbnk = videoOptions;
        try {
            if (this.zzbul != null) {
                zzww zzww = this.zzbul;
                if (videoOptions == null) {
                    zzaaa = null;
                } else {
                    zzaaa = new zzaaa(videoOptions);
                }
                zzww.zza(zzaaa);
            }
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbnk;
    }

    public final boolean zza(zzww zzww) {
        if (zzww == null) {
            return false;
        }
        try {
            IObjectWrapper zzkf = zzww.zzkf();
            if (zzkf == null || ((View) ObjectWrapper.unwrap(zzkf)).getParent() != null) {
                return false;
            }
            this.zzcjn.addView((View) ObjectWrapper.unwrap(zzkf));
            this.zzbul = zzww;
            return true;
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return false;
        }
    }

    private static zzvh zza(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return zzvh.zzpk();
            }
        }
        zzvh zzvh = new zzvh(context, adSizeArr);
        zzvh.zzchl = zzda(i);
        return zzvh;
    }
}
