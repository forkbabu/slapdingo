package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcfj implements zzela<zzcey> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzcet> zzfbs;
    private final zzelj<zzcfp> zzfbu;
    private final zzelj<zzbbd> zzfjy;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzeg> zzfvq;
    private final zzelj<zza> zzgaz;
    private final zzelj<zztm> zzgba;

    public zzcfj(zzelj<Context> zzelj, zzelj<zzcet> zzelj2, zzelj<zzeg> zzelj3, zzelj<zzbbd> zzelj4, zzelj<zza> zzelj5, zzelj<zztm> zzelj6, zzelj<Executor> zzelj7, zzelj<zzdla> zzelj8, zzelj<zzcfp> zzelj9, zzelj<ScheduledExecutorService> zzelj10) {
        this.zzere = zzelj;
        this.zzfbs = zzelj2;
        this.zzfvq = zzelj3;
        this.zzfjy = zzelj4;
        this.zzgaz = zzelj5;
        this.zzgba = zzelj6;
        this.zzerc = zzelj7;
        this.zzfnz = zzelj8;
        this.zzfbu = zzelj9;
        this.zzfkv = zzelj10;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcey(this.zzere.get(), this.zzfbs.get(), this.zzfvq.get(), this.zzfjy.get(), this.zzgaz.get(), this.zzgba.get(), this.zzerc.get(), this.zzfnz.get(), this.zzfbu.get(), this.zzfkv.get());
    }
}
