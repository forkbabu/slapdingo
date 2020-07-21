package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzczl implements zzela<zzczj> {
    private final zzelj<Context> zzere;
    private final zzelj<zzday<zzdef>> zzesp;
    private final zzelj<zzdla> zzfnz;
    private final zzelj<zzaxh> zzgrt;

    private zzczl(zzelj<zzday<zzdef>> zzelj, zzelj<zzdla> zzelj2, zzelj<Context> zzelj3, zzelj<zzaxh> zzelj4) {
        this.zzesp = zzelj;
        this.zzfnz = zzelj2;
        this.zzere = zzelj3;
        this.zzgrt = zzelj4;
    }

    public static zzczl zzf(zzelj<zzday<zzdef>> zzelj, zzelj<zzdla> zzelj2, zzelj<Context> zzelj3, zzelj<zzaxh> zzelj4) {
        return new zzczl(zzelj, zzelj2, zzelj3, zzelj4);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzczj(this.zzesp.get(), this.zzfnz.get(), this.zzere.get(), this.zzgrt.get());
    }
}
