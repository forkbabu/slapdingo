package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzs implements zzela<zzbyg<zzo>> {
    private final zzelj<zzcao> zzfmy;
    private final zzbzk zzftx;

    private zzbzs(zzbzk zzbzk, zzelj<zzcao> zzelj) {
        this.zzftx = zzbzk;
        this.zzfmy = zzelj;
    }

    public static zzbzs zzb(zzbzk zzbzk, zzelj<zzcao> zzelj) {
        return new zzbzs(zzbzk, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), zzbbf.zzedl), "Cannot return null from a non-@Nullable @Provides method");
    }
}
