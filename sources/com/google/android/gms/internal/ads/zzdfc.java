package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdfc implements zzela<zzdfa> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzere;
    private final zzelj<zzasp> zzesg;
    private final zzelj<String> zzfqz;

    public zzdfc(zzelj<zzasp> zzelj, zzelj<Context> zzelj2, zzelj<String> zzelj3, zzelj<zzdvi> zzelj4) {
        this.zzesg = zzelj;
        this.zzere = zzelj2;
        this.zzfqz = zzelj3;
        this.zzerc = zzelj4;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdfa(this.zzesg.get(), this.zzere.get(), this.zzfqz.get(), this.zzerc.get());
    }
}
