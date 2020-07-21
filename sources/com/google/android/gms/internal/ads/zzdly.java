package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzdly implements zzela<zzdlv> {
    private final zzelj<Context> zzere;
    private final zzelj<zzaxs> zzexn;

    private zzdly(zzelj<Context> zzelj, zzelj<zzaxs> zzelj2) {
        this.zzere = zzelj;
        this.zzexn = zzelj2;
    }

    public static zzdly zzbj(zzelj<Context> zzelj, zzelj<zzaxs> zzelj2) {
        return new zzdly(zzelj, zzelj2);
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzdlv(this.zzere.get(), this.zzexn.get());
    }
}
