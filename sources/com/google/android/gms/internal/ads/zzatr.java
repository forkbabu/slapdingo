package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzatr implements RewardItem {
    private final zzatg zzduo;

    public zzatr(zzatg zzatg) {
        this.zzduo = zzatg;
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final String getType() {
        zzatg zzatg = this.zzduo;
        if (zzatg == null) {
            return null;
        }
        try {
            return zzatg.getType();
        } catch (RemoteException e) {
            zzbba.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.reward.RewardItem
    public final int getAmount() {
        zzatg zzatg = this.zzduo;
        if (zzatg == null) {
            return 0;
        }
        try {
            return zzatg.getAmount();
        } catch (RemoteException e) {
            zzbba.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }
}
