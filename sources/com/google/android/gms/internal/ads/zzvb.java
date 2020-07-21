package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzvb extends zzxc {
    private final AdMetadataListener zzcgr;

    public zzvb(AdMetadataListener adMetadataListener) {
        this.zzcgr = adMetadataListener;
    }

    @Override // com.google.android.gms.internal.ads.zzwz
    public final void onAdMetadataChanged() {
        AdMetadataListener adMetadataListener = this.zzcgr;
        if (adMetadataListener != null) {
            adMetadataListener.onAdMetadataChanged();
        }
    }
}
