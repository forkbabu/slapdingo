package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzave extends zzaug {
    private final String type;
    private final int zzdun;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzave(zzaub zzaub) {
        this(zzaub != null ? zzaub.type : "", zzaub != null ? zzaub.zzdun : 1);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public zzave(RewardItem rewardItem) {
        this(rewardItem != null ? rewardItem.getType() : "", rewardItem != null ? rewardItem.getAmount() : 1);
    }

    public zzave(String str, int i) {
        this.type = str;
        this.zzdun = i;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final String getType() throws RemoteException {
        return this.type;
    }

    @Override // com.google.android.gms.internal.ads.zzaud
    public final int getAmount() throws RemoteException {
        return this.zzdun;
    }
}
