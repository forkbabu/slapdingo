package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcms implements zzela<zzdvf<String>> {
    private final zzelj<Context> zzere;
    private final zzelj<zzeg> zzfkz;
    private final zzelj<zzdvi> zzggo;

    private zzcms(zzelj<zzeg> zzelj, zzelj<Context> zzelj2, zzelj<zzdvi> zzelj3) {
        this.zzfkz = zzelj;
        this.zzere = zzelj2;
        this.zzggo = zzelj3;
    }

    public static zzcms zzo(zzelj<zzeg> zzelj, zzelj<Context> zzelj2, zzelj<zzdvi> zzelj3) {
        return new zzcms(zzelj, zzelj2, zzelj3);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzdvf) zzelg.zza(this.zzggo.get().zze(new zzcmt(this.zzfkz.get(), this.zzere.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
