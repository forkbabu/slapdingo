package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zztg implements BaseGmsClient.BaseConnectionCallbacks {
    private final /* synthetic */ zzsy zzbve;
    private final /* synthetic */ zzbbn zzbvf;
    final /* synthetic */ zzte zzbvg;

    zztg(zzte zzte, zzsy zzsy, zzbbn zzbbn) {
        this.zzbvg = zzte;
        this.zzbve = zzsy;
        this.zzbvf = zzbbn;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i) {
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        synchronized (this.zzbvg.lock) {
            if (!this.zzbvg.zzbvd) {
                boolean unused = this.zzbvg.zzbvd = true;
                zzsz zzd = this.zzbvg.zzbuq;
                if (zzd != null) {
                    this.zzbvf.addListener(new zzti(this.zzbvf, zzbbf.zzedh.zzf(new zztj(this, zzd, this.zzbve, this.zzbvf))), zzbbf.zzedm);
                }
            }
        }
    }
}
