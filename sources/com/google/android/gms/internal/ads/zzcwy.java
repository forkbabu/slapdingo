package com.google.android.gms.internal.ads;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcwy implements zzuu {
    private zzwi zzgpp;

    public final synchronized void zzb(zzwi zzwi) {
        this.zzgpp = zzwi;
    }

    @Override // com.google.android.gms.internal.ads.zzuu
    public final synchronized void onAdClicked() {
        if (this.zzgpp != null) {
            try {
                this.zzgpp.onAdClicked();
            } catch (RemoteException e) {
                zzaxv.zzd("Remote Exception at onAdClicked.", e);
            }
        }
    }
}
