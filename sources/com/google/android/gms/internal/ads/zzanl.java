package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzanl extends zzyh {
    private final Object lock = new Object();
    private volatile zzyj zzdjy;

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
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final float getCurrentTime() throws RemoteException {
        throw new RemoteException();
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void zza(zzyj zzyj) throws RemoteException {
        synchronized (this.lock) {
            this.zzdjy = zzyj;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final zzyj zzqi() throws RemoteException {
        zzyj zzyj;
        synchronized (this.lock) {
            zzyj = this.zzdjy;
        }
        return zzyj;
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
