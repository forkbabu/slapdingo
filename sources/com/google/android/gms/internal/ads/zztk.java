package com.google.android.gms.internal.ads;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zztk implements BaseGmsClient.BaseOnConnectionFailedListener {
    private final /* synthetic */ zzbbn zzbvf;
    private final /* synthetic */ zzte zzbvg;

    zztk(zzte zzte, zzbbn zzbbn) {
        this.zzbvg = zzte;
        this.zzbvf = zzbbn;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        synchronized (this.zzbvg.lock) {
            this.zzbvf.setException(new RuntimeException("Connection failed."));
        }
    }
}
