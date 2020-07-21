package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzchf extends VideoController.VideoLifecycleCallbacks {
    private final zzcck zzfuu;

    public zzchf(zzcck zzcck) {
        this.zzfuu = zzcck;
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoStart() {
        zzyj zza = zza(this.zzfuu);
        if (zza != null) {
            try {
                zza.onVideoStart();
            } catch (RemoteException e) {
                zzaxv.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoPause() {
        zzyj zza = zza(this.zzfuu);
        if (zza != null) {
            try {
                zza.onVideoPause();
            } catch (RemoteException e) {
                zzaxv.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    @Override // com.google.android.gms.ads.VideoController.VideoLifecycleCallbacks
    public final void onVideoEnd() {
        zzyj zza = zza(this.zzfuu);
        if (zza != null) {
            try {
                zza.onVideoEnd();
            } catch (RemoteException e) {
                zzaxv.zzd("Unable to call onVideoEnd()", e);
            }
        }
    }

    private static zzyj zza(zzcck zzcck) {
        zzyi videoController = zzcck.getVideoController();
        if (videoController == null) {
            return null;
        }
        try {
            return videoController.zzqi();
        } catch (RemoteException unused) {
            return null;
        }
    }
}
