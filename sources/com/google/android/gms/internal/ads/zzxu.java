package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.MuteThisAdListener;

/* compiled from: com.google.android.gms:play-services-ads-lite@@19.2.0 */
public final class zzxu extends zzxs {
    private final MuteThisAdListener zzciv;

    public zzxu(MuteThisAdListener muteThisAdListener) {
        this.zzciv = muteThisAdListener;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final void onAdMuted() {
        this.zzciv.onAdMuted();
    }
}
