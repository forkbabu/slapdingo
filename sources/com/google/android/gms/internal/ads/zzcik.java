package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcik implements zzela<zzchw> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzbus> zzfoa;
    private final zzelj<zzeg> zzfvq;
    private final zzelj<zztm> zzgba;
    private final zzelj<zzbfv> zzgcd;
    private final zzelj<zza> zzgcs;
    private final zzelj<zzbze> zzgct;

    private zzcik(zzelj<zzbfv> zzelj, zzelj<Context> zzelj2, zzelj<zzdla> zzelj3, zzelj<zzeg> zzelj4, zzelj<zzbbd> zzelj5, zzelj<zza> zzelj6, zzelj<zztm> zzelj7, zzelj<zzbus> zzelj8, zzelj<zzbze> zzelj9) {
        this.zzgcd = zzelj;
        this.zzere = zzelj2;
        this.zzfnz = zzelj3;
        this.zzfvq = zzelj4;
        this.zzfjy = zzelj5;
        this.zzgcs = zzelj6;
        this.zzgba = zzelj7;
        this.zzfoa = zzelj8;
        this.zzgct = zzelj9;
    }

    public static zzcik zzc(zzelj<zzbfv> zzelj, zzelj<Context> zzelj2, zzelj<zzdla> zzelj3, zzelj<zzeg> zzelj4, zzelj<zzbbd> zzelj5, zzelj<zza> zzelj6, zzelj<zztm> zzelj7, zzelj<zzbus> zzelj8, zzelj<zzbze> zzelj9) {
        return new zzcik(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7, zzelj8, zzelj9);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzchw(this.zzgcd.get(), this.zzere.get(), this.zzfnz.get(), this.zzfvq.get(), this.zzfjy.get(), this.zzgcs.get(), this.zzgba.get(), this.zzfoa.get(), this.zzgct.get());
    }
}
