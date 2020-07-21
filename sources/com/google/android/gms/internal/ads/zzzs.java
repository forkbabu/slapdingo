package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzzs extends zzya {
    private final OnAdMetadataChangedListener zzckm;

    public zzzs(OnAdMetadataChangedListener onAdMetadataChangedListener) {
        this.zzckm = onAdMetadataChangedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxx
    public final void onAdMetadataChanged() throws RemoteException {
        OnAdMetadataChangedListener onAdMetadataChangedListener = this.zzckm;
        if (onAdMetadataChangedListener != null) {
            onAdMetadataChangedListener.onAdMetadataChanged();
        }
    }
}
