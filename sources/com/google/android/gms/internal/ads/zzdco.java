package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdco implements zzela<zzdcm> {
    private final zzelj<Context> zzere;
    private final zzelj<zzdvi> zzgrl;
    private final zzelj<Set<String>> zzgry;

    private zzdco(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2, zzelj<Set<String>> zzelj3) {
        this.zzgrl = zzelj;
        this.zzere = zzelj2;
        this.zzgry = zzelj3;
    }

    public static zzdco zzs(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2, zzelj<Set<String>> zzelj3) {
        return new zzdco(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdcm(this.zzgrl.get(), this.zzere.get(), this.zzgry.get());
    }
}
