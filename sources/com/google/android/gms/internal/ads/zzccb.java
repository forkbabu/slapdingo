package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzccb extends zzadr {
    private final zzcck zzfuu;
    private IObjectWrapper zzfvw;

    public zzccb(zzcck zzcck) {
        this.zzfuu = zzcck;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final float getAspectRatio() throws RemoteException {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcvs)).booleanValue()) {
            return 0.0f;
        }
        if (this.zzfuu.getMediaContentAspectRatio() != 0.0f) {
            return this.zzfuu.getMediaContentAspectRatio();
        }
        if (this.zzfuu.getVideoController() != null) {
            return zzala();
        }
        IObjectWrapper iObjectWrapper = this.zzfvw;
        if (iObjectWrapper != null) {
            return zzar(iObjectWrapper);
        }
        zzadt zzali = this.zzfuu.zzali();
        if (zzali == null) {
            return 0.0f;
        }
        float width = (zzali == null || zzali.getWidth() == -1 || zzali.getHeight() == -1) ? 0.0f : ((float) zzali.getWidth()) / ((float) zzali.getHeight());
        if (width != 0.0f) {
            return width;
        }
        return zzar(zzali.zzry());
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final float getDuration() throws RemoteException {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvt)).booleanValue() && this.zzfuu.getVideoController() != null) {
            return this.zzfuu.getVideoController().getDuration();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final float getCurrentTime() throws RemoteException {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvt)).booleanValue() && this.zzfuu.getVideoController() != null) {
            return this.zzfuu.getVideoController().getCurrentTime();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final zzyi getVideoController() throws RemoteException {
        if (!((Boolean) zzwg.zzpw().zzd(zzaav.zzcvt)).booleanValue()) {
            return null;
        }
        return this.zzfuu.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final boolean hasVideoContent() throws RemoteException {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvt)).booleanValue() && this.zzfuu.getVideoController() != null) {
            return true;
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final void zza(zzaff zzaff) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcvt)).booleanValue() && (this.zzfuu.getVideoController() instanceof zzbgh)) {
            ((zzbgh) this.zzfuu.getVideoController()).zza(zzaff);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwg.zzpw().zzd(zzaav.zzcrk)).booleanValue()) {
            this.zzfvw = iObjectWrapper;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzado
    public final IObjectWrapper zzsa() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzfvw;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzadt zzali = this.zzfuu.zzali();
        if (zzali == null) {
            return null;
        }
        return zzali.zzry();
    }

    private final float zzala() {
        try {
            return this.zzfuu.getVideoController().getAspectRatio();
        } catch (RemoteException e) {
            zzaxv.zzc("Remote exception getting video controller aspect ratio.", e);
            return 0.0f;
        }
    }

    private static float zzar(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        if (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) {
            return 0.0f;
        }
        return ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
    }
}
