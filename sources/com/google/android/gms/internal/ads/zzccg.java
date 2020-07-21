package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzccg implements zzela<zzccd> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzcco> zzetw;
    private final zzelj<zzbpa> zzewi;
    private final zzelj<zzccs> zzewp;
    private final zzelj<zzccj> zzewv;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<zzccv> zzfnq;
    private final zzelj<zzavv> zzfoy;
    private final zzelj<zzcck> zzfvp;
    private final zzelj<zzeg> zzfvq;
    private final zzelj<zzcdg> zzfwk;
    private final zzelj<zzcgj> zzfwl;
    private final zzelj<zzcgh> zzfwm;
    private final zzelj<zzcgm> zzfwn;
    private final zzelj<zzcgd> zzfwo;
    private final zzelj<zzcgl> zzfwp;
    private final zzelj<zzcww> zzfwq;

    private zzccg(zzelj<zzbpa> zzelj, zzelj<Executor> zzelj2, zzelj<zzcck> zzelj3, zzelj<zzccs> zzelj4, zzelj<zzcdg> zzelj5, zzelj<zzcco> zzelj6, zzelj<zzccv> zzelj7, zzelj<zzcgj> zzelj8, zzelj<zzcgh> zzelj9, zzelj<zzcgm> zzelj10, zzelj<zzcgd> zzelj11, zzelj<zzcgl> zzelj12, zzelj<zzavv> zzelj13, zzelj<zzeg> zzelj14, zzelj<zzbbd> zzelj15, zzelj<Context> zzelj16, zzelj<zzccj> zzelj17, zzelj<zzcww> zzelj18) {
        this.zzewi = zzelj;
        this.zzerc = zzelj2;
        this.zzfvp = zzelj3;
        this.zzewp = zzelj4;
        this.zzfwk = zzelj5;
        this.zzetw = zzelj6;
        this.zzfnq = zzelj7;
        this.zzfwl = zzelj8;
        this.zzfwm = zzelj9;
        this.zzfwn = zzelj10;
        this.zzfwo = zzelj11;
        this.zzfwp = zzelj12;
        this.zzfoy = zzelj13;
        this.zzfvq = zzelj14;
        this.zzfjy = zzelj15;
        this.zzere = zzelj16;
        this.zzewv = zzelj17;
        this.zzfwq = zzelj18;
    }

    public static zzccg zza(zzelj<zzbpa> zzelj, zzelj<Executor> zzelj2, zzelj<zzcck> zzelj3, zzelj<zzccs> zzelj4, zzelj<zzcdg> zzelj5, zzelj<zzcco> zzelj6, zzelj<zzccv> zzelj7, zzelj<zzcgj> zzelj8, zzelj<zzcgh> zzelj9, zzelj<zzcgm> zzelj10, zzelj<zzcgd> zzelj11, zzelj<zzcgl> zzelj12, zzelj<zzavv> zzelj13, zzelj<zzeg> zzelj14, zzelj<zzbbd> zzelj15, zzelj<Context> zzelj16, zzelj<zzccj> zzelj17, zzelj<zzcww> zzelj18) {
        return new zzccg(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7, zzelj8, zzelj9, zzelj10, zzelj11, zzelj12, zzelj13, zzelj14, zzelj15, zzelj16, zzelj17, zzelj18);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzccd(this.zzewi.get(), this.zzerc.get(), this.zzfvp.get(), this.zzewp.get(), this.zzfwk.get(), this.zzetw.get(), this.zzfnq.get(), zzekx.zzat(this.zzfwl), zzekx.zzat(this.zzfwm), zzekx.zzat(this.zzfwn), zzekx.zzat(this.zzfwo), zzekx.zzat(this.zzfwp), this.zzfoy.get(), this.zzfvq.get(), this.zzfjy.get(), this.zzere.get(), this.zzewv.get(), this.zzfwq.get());
    }
}
