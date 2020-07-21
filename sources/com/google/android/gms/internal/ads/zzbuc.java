package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final /* synthetic */ class zzbuc implements zzbwx {
    static final zzbwx zzfrq = new zzbuc();

    private zzbuc() {
    }

    @Override // com.google.android.gms.internal.ads.zzbwx
    public final void zzp(Object obj) {
        ((AdMetadataListener) obj).onAdMetadataChanged();
    }
}
