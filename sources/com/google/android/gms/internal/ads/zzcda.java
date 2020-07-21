package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcda implements zzela<zzavv> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdla> zzfnz;
    private final zzccw zzfxu;

    private zzcda(zzccw zzccw, zzelj<Context> zzelj, zzelj<zzdla> zzelj2) {
        this.zzfxu = zzccw;
        this.zzere = zzelj;
        this.zzfnz = zzelj2;
    }

    public static zzcda zza(zzccw zzccw, zzelj<Context> zzelj, zzelj<zzdla> zzelj2) {
        return new zzcda(zzccw, zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzavv) zzelg.zza(new zzavv(this.zzere.get(), this.zzfnz.get().zzhaz), "Cannot return null from a non-@Nullable @Provides method");
    }
}
