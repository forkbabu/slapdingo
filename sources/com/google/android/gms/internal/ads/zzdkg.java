package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdkg extends AdMetadataListener {
    private final /* synthetic */ zzdke zzgzc;
    private final /* synthetic */ zzwz zzgzd;

    zzdkg(zzdke zzdke, zzwz zzwz) {
        this.zzgzc = zzdke;
        this.zzgzd = zzwz;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.zzgzc.zzgzb != null) {
            try {
                this.zzgzd.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzaxv.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
