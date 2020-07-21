package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcqn implements zzela<zzcqi> {
    private final zzelj<Context> zzere;
    private final zzelj<zzcqf> zzeyi;
    private final zzelj<zzcpz> zzfax;
    private final zzelj<zzbrq> zzgkb;

    private zzcqn(zzelj<Context> zzelj, zzelj<zzbrq> zzelj2, zzelj<zzcqf> zzelj3, zzelj<zzcpz> zzelj4) {
        this.zzere = zzelj;
        this.zzgkb = zzelj2;
        this.zzeyi = zzelj3;
        this.zzfax = zzelj4;
    }

    public static zzcqn zzd(zzelj<Context> zzelj, zzelj<zzbrq> zzelj2, zzelj<zzcqf> zzelj3, zzelj<zzcpz> zzelj4) {
        return new zzcqn(zzelj, zzelj2, zzelj3, zzelj4);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcqi(this.zzere.get(), this.zzgkb.get(), this.zzeyi.get(), this.zzfax.get());
    }
}
