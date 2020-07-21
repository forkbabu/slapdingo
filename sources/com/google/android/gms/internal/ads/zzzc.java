package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzc implements MediaContent {
    private final VideoController zzcjk = new VideoController();
    private final zzado zzckd;

    public zzzc(zzado zzado) {
        this.zzckd = zzado;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getAspectRatio() {
        try {
            return this.zzckd.getAspectRatio();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getDuration() {
        try {
            return this.zzckd.getDuration();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getCurrentTime() {
        try {
            return this.zzckd.getCurrentTime();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return 0.0f;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final VideoController getVideoController() {
        try {
            if (this.zzckd.getVideoController() != null) {
                this.zzcjk.zza(this.zzckd.getVideoController());
            }
        } catch (RemoteException e) {
            zzbba.zzc("Exception occurred while getting video controller", e);
        }
        return this.zzcjk;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean hasVideoContent() {
        try {
            return this.zzckd.hasVideoContent();
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final void setMainImage(Drawable drawable) {
        try {
            this.zzckd.zzo(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e) {
            zzbba.zzc("", e);
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final Drawable getMainImage() {
        try {
            IObjectWrapper zzsa = this.zzckd.zzsa();
            if (zzsa != null) {
                return (Drawable) ObjectWrapper.unwrap(zzsa);
            }
            return null;
        } catch (RemoteException e) {
            zzbba.zzc("", e);
            return null;
        }
    }

    public final zzado zzqt() {
        return this.zzckd;
    }
}
