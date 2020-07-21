package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdpe implements zzela<zzalr> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbbd> zzfro;
    private final zzdpb zzhgz;

    public zzdpe(zzdpb zzdpb, zzelj<Context> zzelj, zzelj<zzbbd> zzelj2) {
        this.zzhgz = zzdpb;
        this.zzere = zzelj;
        this.zzfro = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return (zzalr) zzelg.zza(new zzali().zzb(this.zzere.get(), this.zzfro.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
