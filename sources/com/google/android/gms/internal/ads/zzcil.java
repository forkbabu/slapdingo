package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzc;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcil implements zzela<zzchy> {
    private final zzelj<Executor> zzerc;
    private final zzelj<zzblu> zzeub;
    private final zzelj<zzbtl> zzeuo;
    private final zzelj<zzbsk> zzeus;
    private final zzelj<zzbui> zzevu;
    private final zzelj<zzbyj> zzewn;
    private final zzelj<zzbwj> zzfdg;
    private final zzelj<zzbtz> zzfdo;
    private final zzelj<zzbwc> zzffh;
    private final zzelj<zzavr> zzfqo;
    private final zzelj<zzeg> zzfvq;
    private final zzelj<zzc> zzgcu;
    private final zzelj<zzbtf> zzgcv;

    private zzcil(zzelj<zzbsk> zzelj, zzelj<zzbtl> zzelj2, zzelj<zzbtz> zzelj3, zzelj<zzbui> zzelj4, zzelj<zzbwj> zzelj5, zzelj<Executor> zzelj6, zzelj<zzbyj> zzelj7, zzelj<zzblu> zzelj8, zzelj<zzc> zzelj9, zzelj<zzbtf> zzelj10, zzelj<zzavr> zzelj11, zzelj<zzeg> zzelj12, zzelj<zzbwc> zzelj13) {
        this.zzeus = zzelj;
        this.zzeuo = zzelj2;
        this.zzfdo = zzelj3;
        this.zzevu = zzelj4;
        this.zzfdg = zzelj5;
        this.zzerc = zzelj6;
        this.zzewn = zzelj7;
        this.zzeub = zzelj8;
        this.zzgcu = zzelj9;
        this.zzgcv = zzelj10;
        this.zzfqo = zzelj11;
        this.zzfvq = zzelj12;
        this.zzffh = zzelj13;
    }

    public static zzcil zza(zzelj<zzbsk> zzelj, zzelj<zzbtl> zzelj2, zzelj<zzbtz> zzelj3, zzelj<zzbui> zzelj4, zzelj<zzbwj> zzelj5, zzelj<Executor> zzelj6, zzelj<zzbyj> zzelj7, zzelj<zzblu> zzelj8, zzelj<zzc> zzelj9, zzelj<zzbtf> zzelj10, zzelj<zzavr> zzelj11, zzelj<zzeg> zzelj12, zzelj<zzbwc> zzelj13) {
        return new zzcil(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7, zzelj8, zzelj9, zzelj10, zzelj11, zzelj12, zzelj13);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzchy(this.zzeus.get(), this.zzeuo.get(), this.zzfdo.get(), this.zzevu.get(), this.zzfdg.get(), this.zzerc.get(), this.zzewn.get(), this.zzeub.get(), this.zzgcu.get(), this.zzgcv.get(), this.zzfqo.get(), this.zzfvq.get(), this.zzffh.get());
    }
}
