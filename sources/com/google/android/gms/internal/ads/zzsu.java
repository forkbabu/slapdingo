package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzsu implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzsq zzbuu;

    zzsu(zzsq zzsq) {
        this.zzbuu = zzsq;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbuu.lock) {
            zztd unused = this.zzbuu.zzbur = (zztd) null;
            if (this.zzbuu.zzbuq != null) {
                zzsz unused2 = this.zzbuu.zzbuq = null;
            }
            this.zzbuu.lock.notifyAll();
        }
    }
}
