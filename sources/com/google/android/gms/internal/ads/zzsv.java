package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzsv implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzsq zzbuu;

    zzsv(zzsq zzsq) {
        this.zzbuu = zzsq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzbuu.lock) {
            try {
                if (this.zzbuu.zzbuq != null) {
                    zztd unused = this.zzbuu.zzbur = this.zzbuu.zzbuq.zzmy();
                }
            } catch (DeadObjectException e) {
                zzaxv.zzc("Unable to obtain a cache service instance.", e);
                this.zzbuu.disconnect();
            }
            this.zzbuu.lock.notifyAll();
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
        synchronized (this.zzbuu.lock) {
            zztd unused = this.zzbuu.zzbur = (zztd) null;
            this.zzbuu.lock.notifyAll();
        }
    }
}
