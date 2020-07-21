package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzbng implements zzela<zzbne> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbyk> zzevm;
    private final zzelj<zzbpa> zzewi;
    private final zzelj<zzcwo> zzfge;
    private final zzelj<View> zzfky;
    private final zzelj<zzdkj> zzfnn;
    private final zzelj<zzbfn> zzfno;
    private final zzelj<zzboy> zzfnp;
    private final zzelj<zzccv> zzfnq;
    private final zzelj<Executor> zzfnr;

    public zzbng(zzelj<zzbpa> zzelj, zzelj<Context> zzelj2, zzelj<zzdkj> zzelj3, zzelj<View> zzelj4, zzelj<zzbfn> zzelj5, zzelj<zzboy> zzelj6, zzelj<zzccv> zzelj7, zzelj<zzbyk> zzelj8, zzelj<zzcwo> zzelj9, zzelj<Executor> zzelj10) {
        this.zzewi = zzelj;
        this.zzere = zzelj2;
        this.zzfnn = zzelj3;
        this.zzfky = zzelj4;
        this.zzfno = zzelj5;
        this.zzfnp = zzelj6;
        this.zzfnq = zzelj7;
        this.zzevm = zzelj8;
        this.zzfge = zzelj9;
        this.zzfnr = zzelj10;
    }

    public static zzbne zza(zzbpa zzbpa, Context context, zzdkj zzdkj, View view, zzbfn zzbfn, zzboy zzboy, zzccv zzccv, zzbyk zzbyk, zzeku<zzcwo> zzeku, Executor executor) {
        return new zzbne(zzbpa, context, zzdkj, view, zzbfn, zzboy, zzccv, zzbyk, zzeku, executor);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzewi.get(), this.zzere.get(), this.zzfnn.get(), this.zzfky.get(), this.zzfno.get(), this.zzfnp.get(), this.zzfnq.get(), this.zzevm.get(), zzekx.zzat(this.zzfge), this.zzfnr.get());
    }
}
