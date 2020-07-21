package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdea implements zzela<zzddt> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzfqq;

    private zzdea(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2) {
        this.zzerc = zzelj;
        this.zzfqq = zzelj2;
    }

    public static zzdea zzbg(zzelj<zzdvi> zzelj, zzelj<Context> zzelj2) {
        return new zzdea(zzelj, zzelj2);
    }

    public static zzddt zza(zzdvi zzdvi, Context context) {
        return new zzddt(zzdvi, context);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzerc.get(), this.zzfqq.get());
    }
}
