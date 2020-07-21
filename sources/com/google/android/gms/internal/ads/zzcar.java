package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzty;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcar implements zzela<zzcao> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<zzty.zza.C0018zza> zzfmi;
    private final zzelj<zzbfn> zzfno;
    private final zzelj<zzdkk> zzfos;

    private zzcar(zzelj<Context> zzelj, zzelj<zzbfn> zzelj2, zzelj<zzdkk> zzelj3, zzelj<zzbbd> zzelj4, zzelj<zzty.zza.C0018zza> zzelj5) {
        this.zzere = zzelj;
        this.zzfno = zzelj2;
        this.zzfos = zzelj3;
        this.zzfjy = zzelj4;
        this.zzfmi = zzelj5;
    }

    public static zzcar zzc(zzelj<Context> zzelj, zzelj<zzbfn> zzelj2, zzelj<zzdkk> zzelj3, zzelj<zzbbd> zzelj4, zzelj<zzty.zza.C0018zza> zzelj5) {
        return new zzcar(zzelj, zzelj2, zzelj3, zzelj4, zzelj5);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcao(this.zzere.get(), this.zzfno.get(), this.zzfos.get(), this.zzfjy.get(), this.zzfmi.get());
    }
}
