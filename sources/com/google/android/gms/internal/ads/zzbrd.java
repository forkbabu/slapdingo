package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzo;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbrd implements zzela<zzbyg<zzo>> {
    private final zzelj<zzbpv> zzfmy;
    private final zzbqu zzfqp;

    private zzbrd(zzbqu zzbqu, zzelj<zzbpv> zzelj) {
        this.zzfqp = zzbqu;
        this.zzfmy = zzelj;
    }

    public static zzbrd zza(zzbqu zzbqu, zzelj<zzbpv> zzelj) {
        return new zzbrd(zzbqu, zzelj);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyg) zzelg.zza(new zzbyg(this.zzfmy.get(), zzbbf.zzedm), "Cannot return null from a non-@Nullable @Provides method");
    }
}
