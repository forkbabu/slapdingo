package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzaeq implements NativeCustomTemplateAd {
    private final VideoController zzcjk = new VideoController();
    private final zzaep zzdcr;
    private final MediaView zzdcs;
    private NativeCustomTemplateAd.DisplayOpenMeasurement zzdct;

    public zzaeq(zzaep zzaep) {
        Context context;
        this.zzdcr = zzaep;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzaep.zzsg());
        } catch (RemoteException | NullPointerException e) {
            zzbba.zzc("", e);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzdcr.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e2) {
                zzbba.zzc("", e2);
            }
        }
        this.zzdcs = mediaView;
    }

    public final zzaep zzsk() {
        return this.zzdcr;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final CharSequence getText(String str) {
        try {
            return this.zzdcr.zzcw(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeAd.Image getImage(String str) {
        try {
            zzadt zzcx = this.zzdcr.zzcx(str);
            if (zzcx != null) {
                return new zzadu(zzcx);
            }
            return null;
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final VideoController getVideoController() {
        try {
            zzyi videoController = this.zzdcr.getVideoController();
            if (videoController != null) {
                this.zzcjk.zza(videoController);
            }
        } catch (RemoteException e) {
            zzbba.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcjk;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final MediaView getVideoMediaView() {
        return this.zzdcs;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzdcr.getAvailableAssetNames();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String getCustomTemplateId() {
        try {
            return this.zzdcr.getCustomTemplateId();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void performClick(String str) {
        try {
            this.zzdcr.performClick(str);
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void recordImpression() {
        try {
            this.zzdcr.recordImpression();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzdct == null && this.zzdcr.zzsh()) {
                this.zzdct = new zzadp(this.zzdcr);
            }
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
        return this.zzdct;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void destroy() {
        try {
            this.zzdcr.destroy();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }
}
