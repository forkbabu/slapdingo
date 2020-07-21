package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbzu implements zzela<zzavv> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdla> zzfnz;
    private final zzbzk zzftx;

    private zzbzu(zzbzk zzbzk, zzelj<Context> zzelj, zzelj<zzdla> zzelj2) {
        this.zzftx = zzbzk;
        this.zzere = zzelj;
        this.zzfnz = zzelj2;
    }

    public static zzbzu zza(zzbzk zzbzk, zzelj<Context> zzelj, zzelj<zzdla> zzelj2) {
        return new zzbzu(zzbzk, zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzavv) zzelg.zza(new zzavv(this.zzere.get(), this.zzfnz.get().zzhaz), "Cannot return null from a non-@Nullable @Provides method");
    }
}
