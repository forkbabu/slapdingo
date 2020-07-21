package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzauw implements RewardItem {
    private final zzaud zzduw;

    public zzauw(zzaud zzaud) {
        this.zzduw = zzaud;
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final String getType() {
        zzaud zzaud = this.zzduw;
        if (zzaud == null) {
            return null;
        }
        try {
            return zzaud.getType();
        } catch (RemoteException e) {
            zzbba.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.rewarded.RewardItem
    public final int getAmount() {
        zzaud zzaud = this.zzduw;
        if (zzaud == null) {
            return 0;
        }
        try {
            return zzaud.getAmount();
        } catch (RemoteException e) {
            zzbba.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
