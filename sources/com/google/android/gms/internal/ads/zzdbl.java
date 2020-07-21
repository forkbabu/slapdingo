package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdbl implements zzela<zzdbh> {
    private final zzelj<zzdvi> zzerc;
    private final zzelj<Context> zzfqq;

    private zzdbl(zzelj<Context> zzelj, zzelj<zzdvi> zzelj2) {
        this.zzfqq = zzelj;
        this.zzerc = zzelj2;
    }

    public static zzdbl zzba(zzelj<Context> zzelj, zzelj<zzdvi> zzelj2) {
        return new zzdbl(zzelj, zzelj2);
    }

    public static zzdbh zza(Context context, zzdvi zzdvi) {
        return new zzdbh(context, zzdvi);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return zza(this.zzfqq.get(), this.zzerc.get());
    }
}
