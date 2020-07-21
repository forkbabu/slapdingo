package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashSet;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbx implements zzela<zzbyj> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdkk> zzfos;

    public zzcbx(zzelj<Context> zzelj, zzelj<zzdkk> zzelj2) {
        this.zzere = zzelj;
        this.zzfos = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzbyj) zzelg.zza(new zzbyj(this.zzere.get(), new HashSet(), this.zzfos.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
