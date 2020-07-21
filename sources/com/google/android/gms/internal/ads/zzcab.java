package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcab implements zzela<View> {
    private final zzbzk zzftx;

    private zzcab(zzbzk zzbzk) {
        this.zzftx = zzbzk;
    }

    public static zzcab zzd(zzbzk zzbzk) {
        return new zzcab(zzbzk);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return this.zzftx.zzakg();
    }
}
