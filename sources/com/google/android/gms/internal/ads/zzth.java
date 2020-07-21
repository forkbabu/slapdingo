package com.google.android.gms.internal.ads;

import java.io.InputStream;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
final class zzth extends zzbbn<InputStream> {
    private final /* synthetic */ zzte zzbvg;

    zzth(zzte zzte) {
        this.zzbvg = zzte;
    }

    @Override // com.google.android.gms.internal.ads.zzbbn
    public final boolean cancel(boolean z) {
        this.zzbvg.disconnect();
        return super.cancel(z);
    }
}
