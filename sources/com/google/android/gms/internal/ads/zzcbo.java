package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcbo implements zzela<zzcbk> {
    private final zzelj<Context> zzere;
    private final zzelj<JSONObject> zzetu;
    private final zzelj<zzblu> zzeub;
    private final zzelj<zzbsk> zzeus;
    private final zzelj<zzbtc> zzevi;
    private final zzelj<zzbyj> zzewn;
    private final zzelj<zzdpd> zzfbe;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<Clock> zzfmf;
    private final zzelj<zzccv> zzfnq;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzdkk> zzfos;
    private final zzelj<zzcgr> zzfvo;
    private final zzelj<zzcck> zzfvp;
    private final zzelj<zzeg> zzfvq;
    private final zzelj<zzcdn> zzfvr;

    public zzcbo(zzelj<Context> zzelj, zzelj<zzccv> zzelj2, zzelj<JSONObject> zzelj3, zzelj<zzcgr> zzelj4, zzelj<zzcck> zzelj5, zzelj<zzeg> zzelj6, zzelj<zzbtc> zzelj7, zzelj<zzbsk> zzelj8, zzelj<zzdkk> zzelj9, zzelj<zzbbd> zzelj10, zzelj<zzdla> zzelj11, zzelj<zzblu> zzelj12, zzelj<zzcdn> zzelj13, zzelj<Clock> zzelj14, zzelj<zzbyj> zzelj15, zzelj<zzdpd> zzelj16) {
        this.zzere = zzelj;
        this.zzfnq = zzelj2;
        this.zzetu = zzelj3;
        this.zzfvo = zzelj4;
        this.zzfvp = zzelj5;
        this.zzfvq = zzelj6;
        this.zzevi = zzelj7;
        this.zzeus = zzelj8;
        this.zzfos = zzelj9;
        this.zzfjy = zzelj10;
        this.zzfnz = zzelj11;
        this.zzeub = zzelj12;
        this.zzfvr = zzelj13;
        this.zzfmf = zzelj14;
        this.zzewn = zzelj15;
        this.zzfbe = zzelj16;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcbk(this.zzere.get(), this.zzfnq.get(), this.zzetu.get(), this.zzfvo.get(), this.zzfvp.get(), this.zzfvq.get(), this.zzevi.get(), this.zzeus.get(), this.zzfos.get(), this.zzfjy.get(), this.zzfnz.get(), this.zzeub.get(), this.zzfvr.get(), this.zzfmf.get(), this.zzewn.get(), this.zzfbe.get());
    }
}
