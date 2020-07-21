package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzccl extends zzyh {
    private final Object lock = new Object();
    @Nullable
    private zzyi zzfxg;
    @Nullable
    private final zzang zzfxh;

    public zzccl(@Nullable zzyi zzyi, @Nullable zzang zzang) {
        this.zzfxg = zzyi;
        this.zzfxh = zzang;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void play() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void pause() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void stop() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void mute(boolean z) throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final boolean isMuted() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final int getPlaybackState() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final float getDuration() throws RemoteException {
        zzang zzang = this.zzfxh;
        if (zzang != null) {
            return zzang.getVideoDuration();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final float getCurrentTime() throws RemoteException {
        zzang zzang = this.zzfxh;
        if (zzang != null) {
            return zzang.getVideoCurrentTime();
        }
        return 0.0f;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void zza(zzyj zzyj) throws RemoteException {
        synchronized (this.lock) {
            if (this.zzfxg != null) {
                this.zzfxg.zza(zzyj);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final zzyj zzqi() throws RemoteException {
        synchronized (this.lock) {
            if (this.zzfxg == null) {
                return null;
            }
            zzyj zzqi = this.zzfxg.zzqi();
            return zzqi;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final float getAspectRatio() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final boolean isCustomControlsEnabled() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final boolean isClickToExpandEnabled() throws RemoteException {
        throw new RemoteException();
    }
}
