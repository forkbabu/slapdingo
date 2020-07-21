package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.ads.instream.InstreamAdView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzajb extends InstreamAd {
    private MediaContent zzbmz = zzsw();
    private VideoController zzcjk = zzsv();
    private final zzaiq zzdez;

    public zzajb(zzaiq zzaiq) {
        this.zzdez = zzaiq;
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final void zza(InstreamAdView instreamAdView) {
        if (instreamAdView == null) {
            zzbba.zzfb("showInView: parameter view must not be null.");
            return;
        }
        try {
            this.zzdez.zzr(ObjectWrapper.wrap(instreamAdView));
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final MediaContent getMediaContent() {
        return this.zzbmz;
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final VideoController getVideoController() {
        return this.zzcjk;
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final float getVideoDuration() {
        VideoController videoController = this.zzcjk;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getVideoDuration();
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final float getVideoCurrentTime() {
        VideoController videoController = this.zzcjk;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getVideoCurrentTime();
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final float getAspectRatio() {
        VideoController videoController = this.zzcjk;
        if (videoController == null) {
            return 0.0f;
        }
        return videoController.getAspectRatio();
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final void destroy() {
        try {
            this.zzdez.destroy();
            this.zzcjk = null;
            this.zzbmz = null;
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
    }

    private final VideoController zzsv() {
        VideoController videoController = new VideoController();
        try {
            videoController.zza(this.zzdez.getVideoController());
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
        }
        return videoController;
    }

    private final MediaContent zzsw() {
        try {
            if (this.zzdez.zzsn() != null) {
                return new zzzc(this.zzdez.zzsn());
            }
            return null;
        } catch (RemoteException e) {
            zzbba.zze("#007 Could not call remote method.", e);
            return null;
        }
    }
}
