package com.google.android.gms.internal.ads;

import android.view.View;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzp implements zzela<View> {
    private final zzbzk zzftx;

    private zzbzp(zzbzk zzbzk) {
        this.zzftx = zzbzk;
    }

    public static zzbzp zza(zzbzk zzbzk) {
        return new zzbzp(zzbzk);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return this.zzftx.zzakh();
    }
}
