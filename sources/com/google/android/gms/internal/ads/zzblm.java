package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzblm implements zzela<zzblk> {
    private final zzelj<Executor> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzdpd> zzfbe;
    private final zzelj<ScheduledExecutorService> zzfkv;
    private final zzelj<zzdkw> zzfkw;
    private final zzelj<zzdkk> zzfkx;
    private final zzelj<View> zzfky;
    private final zzelj<zzeg> zzfkz;
    private final zzelj<zzabv> zzfla;

    private zzblm(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<ScheduledExecutorService> zzelj3, zzelj<zzdkw> zzelj4, zzelj<zzdkk> zzelj5, zzelj<zzdpd> zzelj6, zzelj<View> zzelj7, zzelj<zzeg> zzelj8, zzelj<zzabv> zzelj9) {
        this.zzere = zzelj;
        this.zzerc = zzelj2;
        this.zzfkv = zzelj3;
        this.zzfkw = zzelj4;
        this.zzfkx = zzelj5;
        this.zzfbe = zzelj6;
        this.zzfky = zzelj7;
        this.zzfkz = zzelj8;
        this.zzfla = zzelj9;
    }

    public static zzblm zza(zzelj<Context> zzelj, zzelj<Executor> zzelj2, zzelj<ScheduledExecutorService> zzelj3, zzelj<zzdkw> zzelj4, zzelj<zzdkk> zzelj5, zzelj<zzdpd> zzelj6, zzelj<View> zzelj7, zzelj<zzeg> zzelj8, zzelj<zzabv> zzelj9) {
        return new zzblm(zzelj, zzelj2, zzelj3, zzelj4, zzelj5, zzelj6, zzelj7, zzelj8, zzelj9);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzblk(this.zzere.get(), this.zzerc.get(), this.zzfkv.get(), this.zzfkw.get(), this.zzfkx.get(), this.zzfbe.get(), this.zzfky.get(), this.zzfkz.get(), this.zzfla.get());
    }
}
