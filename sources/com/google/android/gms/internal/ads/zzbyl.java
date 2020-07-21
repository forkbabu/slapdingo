package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbyl implements zzela<zzbyj> {
    private final zzelj<Context> zzere;
    private final zzelj<Set<zzbyg<zzqs>>> zzfnx;
    private final zzelj<zzdkk> zzfos;

    private zzbyl(zzelj<Context> zzelj, zzelj<Set<zzbyg<zzqs>>> zzelj2, zzelj<zzdkk> zzelj3) {
        this.zzere = zzelj;
        this.zzfnx = zzelj2;
        this.zzfos = zzelj3;
    }

    public static zzbyl zzj(zzelj<Context> zzelj, zzelj<Set<zzbyg<zzqs>>> zzelj2, zzelj<zzdkk> zzelj3) {
        return new zzbyl(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzbyj(this.zzere.get(), this.zzfnx.get(), this.zzfos.get());
    }
}
