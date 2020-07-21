package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzdjx extends AdMetadataListener {
    private final /* synthetic */ zzxx zzgyx;
    private final /* synthetic */ zzdjy zzgyy;

    zzdjx(zzdjy zzdjy, zzxx zzxx) {
        this.zzgyy = zzdjy;
        this.zzgyx = zzxx;
    }

    @Override // com.google.android.gms.ads.reward.AdMetadataListener
    public final void onAdMetadataChanged() {
        if (this.zzgyy.zzgzb != null) {
            try {
                this.zzgyx.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzaxv.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
