package com.google.android.gms.internal.ads;

import android.content.Context;

/* compiled from: com.google.android.gms:play-services-ads@@19.2.0 */
public final class zzcrt implements zzela<zzcrp> {
    private final zzelj<Context> zzere;
    private final zzelj<zzbny> zzgkp;

    public zzcrt(zzelj<Context> zzelj, zzelj<zzbny> zzelj2) {
        this.zzere = zzelj;
        this.zzgkp = zzelj2;
    }

    @Override // com.google.android.gms.internal.ads.zzelj
    public final /* synthetic */ Object get() {
        return new zzcrp(this.zzere.get(), this.zzgkp.get());
    }
}
